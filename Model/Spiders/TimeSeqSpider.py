import requests
import pandas as pd
import time
import os
import random


#读取csv文件中的公司代码，以列表形式返回
def getCodeList(csvpath):
    df=pd.read_csv(csvpath,sep=',',dtype={'stockCode ':str})
    return df['stockCode '].tolist()

def getTimeSeq(code,filepath):
    url='http://money.finance.sina.com.cn/corp/go.php/vDOWN_ProfitStatement/displaytype/4/stockid/'+str(code)+'/ctrl/all.phtml'
    data=requests.get(url)
    if '<html>' in data.text:
        return False
    else:
        with open(filepath,'w',encoding='utf-8') as f:
            f.write(data.text)
            print('writing file ',filepath)
            return True

def spider(codeList,filepath):
    sleepCount=0
    for code in codeList:
        if os.path.exists(filepath+str(code)+'.xls'):
            continue
        if (getTimeSeq(code,filepath+str(code)+'.xls') and sleepCount <= 100):
            sleepCount+=1
            if sleepCount % 10 == 0:
                time.sleep(random.randint(3,6))
                print('sleep ......')
        else:
            print(" finish ")
            break

if __name__=='__main__':
    csvpath='C:\\Users\\hzs\\Desktop\\科研训练\\CompanyIndex.csv'
    filepath='C:\\Users\\hzs\\Desktop\\科研训练\\时间序列\\data\\'
    codeList=getCodeList(csvpath)
    spider(codeList,filepath)
    