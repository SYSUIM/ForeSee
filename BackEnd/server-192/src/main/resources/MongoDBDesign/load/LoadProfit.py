import os
import json
import pymongo
def files_name(file_dir:str):
	return [file_dir+x for x in os.listdir(file_dir)]
myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["ForeSee"]
mycol = mydb["Profit"]

file_dir=r"/data/prj2020/EnterpriseSpider/profit/chart/"
files=files_name(file_dir)
for afile in files:
	with open (afile,"r",encoding='utf8') as f:
		dic=eval(f.read())
		res=mycol.insert_one(dic)
		with open(r"/home/user02/mysql/mongodb/ProfitLog.txt","a",encoding='utf8') as Log:
			Log.write(afile+"，res="+str(res)+"\n")
		print(res)
