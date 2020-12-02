from bert_serving.client import BertClient
import numpy as np

#计算两个一维向量之间的相似度
def cos_sim(vector_a, vector_b):
    #列表转为向量
    vector_a = np.array(vector_a)
    vector_b = np.array(vector_b)
    #维度不同时，要求填充至相同长苏
    if vector_a.size != vector_b.size:
        if vector_a.size > vector_b.size:
            length = vector_a.size - vector_b.size
            #在第一维左边填充0个，右边填充length个
            vector_b = np.pad(vector_b, (0, length), 'constant', constant_values=0)
        else:
            length = vector_b.size - vector_a.size
            vector_a = np.pad(vector_a, (0, length), 'constant', constant_values=0)
    vector_a = np.mat(vector_a)
    vector_b = np.mat(vector_b)
    num = float(vector_a * vector_b.T)
    denom = np.linalg.norm(vector_a) * np.linalg.norm(vector_b)
    sim = num / denom
    return sim

#获取词向量
def bert(word):
    bc = BertClient(port=5777,port_out=5778)
    print("encoding ......")
    #返回np.array
    vec = bc.encode(word)   
    return vec