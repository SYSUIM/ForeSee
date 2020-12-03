from bert_serving.client import BertClient
import numpy as np
import csv
import json

# source activate tensorflow
# bert-serving-start -model_dir /data/prj2020/EnterpriseSpider/Transformers/chinese_L-12_H-768_A-12/  -num_worker=1 -port=5777 -port_out=5778
# nohup bert-serving-start -model_dir /data/prj2020/EnterpriseSpider/Transformers/chinese_L-12_H-768_A-12/  -num_worker=1 -port=5777 -port_out=5778 > bert.log 2>&1 &
# ps -ux | grep python
# ps -ux | grep xxx.py
# ps -ux | grep tensorflow
# 进程45145

#获取词向量
def bert(word_list):
    bc = BertClient(port=5777,port_out=5778)
    print("encoding ......")
    #返回np.array
    vec = bc.encode(word_list)   
    return vec[0]

#读入json文件
def readJson(jsonpath):
    with open(jsonpath,'r',encoding='utf-8') as f:
        fileList = json.load(f)
        print("reading ", jsonpath)
    return fileList

def writeJson(jsonpath,file):
    with open(jsonpath,'w',encoding='utf-8') as f:
        f.write(json.dumps(file, indent=4, ensure_ascii=False))
        print("writing file ", jsonpath)

def getCode(ori_jsonpath,new_jsonpath,wordList):
    ori_fileList= readJson(ori_jsonpath)
    for ori_file in ori_fileList:
        if os.path.exists(new_jsonpath+ori_file["stock_code"]+".json"):
            continue        
        for word in wordList:
            #获取编码
            if ori_file[word] == "":
                ori_file[word] = "无"
            vec = bert(ori_file[word])
            #以list形式保存数组
            ori_file[word] = vec.tolist()
            writeJson(new_jsonpath+ori_file["stock_code"]+".json",ori_file)


if __name__=='__main__':
    ori_jsonpath = "/data/prj2020/zss/transformer/data.json"
    new_jsonpath = "/data/prj2020/EnterpriseSpider/vector/"
    wordList = ['gsmc','agjc','sshy','sszjhhy','gsjj']
