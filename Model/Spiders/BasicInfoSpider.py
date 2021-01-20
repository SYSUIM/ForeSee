import requests
from bs4 import BeautifulSoup
import re
import json
import pandas as pd
import time
import csv
import os
import datetime

def getCompanyPid(CompanyName):
    null=''
    headers={'User-Agent': 'User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36'}
    url='https://aiqicha.baidu.com/s?q='+str(CompanyName)+'&t=0'
    r = requests.get(url, headers=headers)
    r.raise_for_status()
    r.encoding = r.apparent_encoding
    soup = BeautifulSoup(r.text, 'html.parser')
    x = soup.body.script.string
    del_string1='/* eslint-disable */  window.loginStatus = null;  window.pageData = '
    del_string2=';\n\n        /* eslint-enable */'
    #dic为字典
    dic=eval(x.replace(del_string1,'').replace(del_string2,''))
    pid=dic['result']['resultList'][0]['pid']
    print("finish getting pid ",pid)
    return pid

def CompanyInfo(pid,feaList):
    null=''
    false='False'
    true='True'
    headers={'User-Agent': 'User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36'}
    url='https://aiqicha.baidu.com/detail/basicAllDataAjax?pid='+str(pid)
    r = requests.get(url, headers=headers)
    r.raise_for_status()
    r.encoding = r.apparent_encoding
    #soup = BeautifulSoup(r.text, 'html.parser')
    #dic=eval(soup)
    dic=eval(r.text)
    InfoDic={}
    for fea in feaList:
        if fea in dic['data']['basicData'].keys():
            InfoDic[fea]=dic['data']['basicData'][fea]
        else:
            InfoDic[fea]='-'
    print("finish getting info of ",pid)
    return InfoDic

def writeJson(text,path):
    text=json.dumps(text, indent=4, ensure_ascii=False)
    with open(path,'w',encoding='utf-8') as f:
        print("writing file ", path, ".......")
        f.write(text)

def writeCsv(lis,newcsvpath):
    with open(newcsvpath,'a',encoding='utf-8',newline='') as f:
        f_csv = csv.writer(f)
        f_csv.writerow(lis)

def run(csvpath,filepath,feaList,newcsvpath):
    print(datetime.datetime.now().strftime('%F %T'))
    data=pd.read_csv(csvpath,converters={'stockCode ': str})
    for i in range(data.shape[0]):
        line=data.iloc[i]
        if os.path.exists(filepath+str(line['industryCode'])+'/'+str(line['stockCode '])+'.json'):
       #     print("skip ",filepath+str(line['industryCode'])+'/'+str(line['stockCode '])+'.json')
            continue
        companyName=str(line['companyName'])
        pid=getCompanyPid(companyName)
        InfoDic = CompanyInfo(pid,feaList)
        InfoDic['industry_code']=str(line['industryCode'])
        InfoDic['stock_code']=str(line['stockCode '])
        writeJson(InfoDic,filepath+InfoDic['industry_code']+'/'+InfoDic['stock_code']+'.json')
        writeCsv([InfoDic['industry_code'],InfoDic['stock_code'],InfoDic['entName'],InfoDic['regAddr']],newcsvpath)
        if i % 10 ==0:
            print("time sleeping for 3 seconds ......")
            time.sleep(3)

def getMoreInfo(csvpath,filepath,feaList):
    print(datetime.datetime.now().strftime('%F %T'))
    data=pd.read_csv(csvpath,converters={'stockCode': str})
    for i in range(data.shape[0]):
        line=data.iloc[i]
        dic= DongFangSpider(line['stoke_code'],line['stoke_exchange'],feaList)
        with open(filepath + str(line['industryCode']) + '/' + str(line['stockCode ']) + '.json') as f:
            OriInfoDic=json.loads(f,encoding='utf-8')
            OriInfoDic['fax']=dic['cz']
            OriInfoDic['email'] = dic['dzxx']
            OriInfoDic['office'] = dic['lxdh']
        writeJson(OriInfoDic,filepath + str(line['industryCode']) + '/' + str(line['stockCode ']) + '.json')
        if i % 10 ==0:
            print("time sleeping for 3 seconds ......")
            time.sleep(3)


def DongFangSpider(code,mark,feaList):
    null = ''
    headers = {
        'User-Agent': 'User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36'}
    url = 'http://f10.eastmoney.com/CompanySurvey/CompanySurveyAjax?code='+str(mark)+str(code)
    r = requests.get(url, headers=headers)
    r.raise_for_status()
    r.encoding = r.apparent_encoding
    TotalInfoDic=json.load(r.text)
    InfoDic={}
    for fea in feaList:
        if fea in TotalInfoDic['jbzl'].keys():
            InfoDic[fea]=TotalInfoDic['jbzl'][fea]
        else:
            InfoDic[fea]='-'
    print("finish getting info of ",code)
    return InfoDic



if __name__=='__main__':
    filepath='/data/prj2020/EnterpriseSpider/basic/BasicInfoFile/'
    #csvpath='/data/prj2020/EnterpriseSpider/basic/CompanyIndex.csv'
    csvpath='/data/prj2020/EnterpriseSpider/basic/stock_index.csv'
    #feaList=['entName','authority','district','describe','entType','industry','openStatus','legalPerson','scope','startDate','regCapital','annualDate','licenseNumber','openTime','orgNo','regNo','regAddr','prevEntName','realCapital','entLogo']
    feaList=['cz','dzxx','lxdh']
    #newcsvpath='/data/prj2020/EnterpriseSpider/basic/newCompanyIndex.csv'
    #run(csvpath,filepath,feaList,newcsvpath)
    getMoreInfo(csvpath, filepath, feaList)
