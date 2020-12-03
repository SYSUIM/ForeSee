import os
import sys
import torch
import logging
import hydra
import models
from hydra import utils
from utils import load_pkl, load_csv
from serializer import Serializer
from preprocess import _serialize_sentence, _convert_tokens_into_index, _add_pos_seq, _handle_relation_data
import matplotlib.pyplot as plt
import pandas as pd
import csv

logger = logging.getLogger(__name__)


def _preprocess_data(data, cfg):
    vocab = load_pkl(os.path.join(cfg.cwd, cfg.out_path, 'vocab.pkl'), verbose=False)
    relation_data = load_csv(os.path.join(cfg.cwd, cfg.data_path, 'relation.csv'), verbose=False)
    rels = _handle_relation_data(relation_data)
    cfg.vocab_size = vocab.count
    serializer = Serializer(do_chinese_split=cfg.chinese_split)
    serial = serializer.serialize

    _serialize_sentence(data, serial, cfg)
    _convert_tokens_into_index(data, vocab)
    _add_pos_seq(data, cfg)
    logger.info('start sentence preprocess...')
    formats = '\nsentence: {}\nchinese_split: {}\nreplace_entity_with_type:  {}\nreplace_entity_with_scope: {}\n' \
              'tokens:    {}\ntoken2idx: {}\nlength:    {}\nhead_idx:  {}\ntail_idx:  {}'
    logger.info(
        formats.format(data[0]['sentence'], cfg.chinese_split, cfg.replace_entity_with_type,
                       cfg.replace_entity_with_scope, data[0]['tokens'], data[0]['token2idx'], data[0]['seq_len'],
                       data[0]['head_idx'], data[0]['tail_idx']))
    return data, rels

# 自定义模型存储的路径
fp = '/checkpoints/2020-12-03_09-33-16/transformer_epoch3.pth'


# 以下只适合小规模数据集预测
@hydra.main(config_path='conf/config.yaml')
def main(cfg):
    cwd = utils.get_original_cwd()
    cfg.cwd = cwd
    cfg.pos_size = 2 * cfg.pos_limit + 2
    print(cfg.pretty())
   
    with open('result1.csv','a+') as csvf:
        writer = csv.writer(csvf)
        writer.writerow(["head","tail","relation"])
    path = '/Entity/sample_200.csv'
    enty_df = pd.read_csv(path)
    all_data = []
    all_rels = []
    all_pred = []
    for index, row in enty_df.iterrows():
        # get predict instance
        print(row)
        instance= {
            'sentence':row['sentence'],
            'head':row['head'],
            'tail':row['tail'],
            'head_type':'企业',
            'tail_type':'企业'
            }
        data = [instance]
        # preprocess data
        data, rels = _preprocess_data(data, cfg)
         # model
        __Model__ = {
            'transformer': models.Transformer
        }
        # 最好在 cpu 上预测
        # cfg.use_gpu = False
        if cfg.use_gpu and torch.cuda.is_available():
            device = torch.device('cuda', cfg.gpu_id)
        else:
            device = torch.device('cpu')
        logger.info(f'device: {device}')

        model = __Model__[cfg.model_name](cfg)
        logger.info(f'model name: {cfg.model_name}')
        logger.info(f'\n {model}')
        model.load(fp, device=device)
        model.to(device)
        model.eval()
        all_data.append(data)
        all_rels.append(rels)

        x = dict()
        x['word'], x['lens'] = torch.tensor([data[0]['token2idx']]), torch.tensor([data[0]['seq_len']])
        x['head_pos'], x['tail_pos'] = torch.tensor([data[0]['head_pos']]), torch.tensor([data[0]['tail_pos']])
        for key in x.keys():
            x[key] = x[key].to(device)

        with torch.no_grad():
            y_pred = model(x)
            y_pred = torch.softmax(y_pred, dim=-1)[0]
            prob = y_pred.max().item()
            prob_rel = list(rels.keys())[y_pred.argmax().item()]
            all_pred.append(prob_rel)
            logger.info(f"\"{data[0]['head']}\" 和 \"{data[0]['tail']}\" 在句中关系为：\"{prob_rel}\"，置信度为{prob:.2f}。")
            with open('result1.csv','a+') as csvf:
                writer = csv.writer(csvf)
                writer.writerow([row['head'],row['tail'],prob_rel])
    all_res = {
        'Subject':enty_df['head'],
        'Predicate':all_pred,
        'Object':enty_df['tail']
    }   
    all_res_df = pd.DataFrame(all_res)
    all_res_df.to_csv('result2.csv',index = False)

if __name__ == '__main__':
    main()
