import torch
from torch.utils.data import Dataset
from utils import load_pkl


def collate_fn(cfg):
    def collate_fn_intra(batch):
        batch.sort(key=lambda data: data['seq_len'], reverse=True)

        max_len = batch[0]['seq_len']

        def _padding(x, max_len):
            return x + [0] * (max_len - len(x))

        x, y = dict(), []
        word, word_len = [], []
        head_pos, tail_pos = [], []
        for data in batch:
            word.append(_padding(data['token2idx'], max_len))
            word_len.append(data['seq_len'])
            y.append(int(data['rel2idx']))
            head_pos.append(_padding(data['head_pos'], max_len))
            tail_pos.append(_padding(data['tail_pos'], max_len))


        x['word'] = torch.tensor(word)
        x['lens'] = torch.tensor(word_len)
        y = torch.tensor(y)
        x['head_pos'] = torch.tensor(head_pos)
        x['tail_pos'] = torch.tensor(tail_pos)
        return x, y

    return collate_fn_intra


class CustomDataset(Dataset):
    """默认使用 List 存储数据"""
    def __init__(self, fp):
        self.file = load_pkl(fp)

    def __getitem__(self, item):
        sample = self.file[item]
        return sample

    def __len__(self):
        return len(self.file)


if __name__ == '__main__':
    from torch.utils.data import DataLoader
    train_data_path = 'data/outComp2/train.pkl'
    vocab_path = 'data/outComp2/vocab.pkl'
    unk_str = 'UNK'
    vocab = load_pkl(vocab_path)
    train_ds = CustomDataset(train_data_path)
    train_dl = DataLoader(train_ds, batch_size=4, shuffle=True, collate_fn=collate_fn, drop_last=False)

    for batch_idx, (x, y) in enumerate(train_dl):
        word = x['word']
        for idx in word:
            idx2token = ''.join([vocab.idx2word.get(i, unk_str) for i in idx.numpy()])
            print(idx2token)
        print(y)
        break

