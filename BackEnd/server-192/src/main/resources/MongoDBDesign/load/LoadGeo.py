import os
import json
import pymongo
def files_name(file_dir:str):
	return [file_dir+x for x in os.listdir(file_dir)]
myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["ForeSee"]
mycol = mydb["geo"]

file_dir=r"/data/prj2020/EnterpriseSpider/geoInfo/geoData/"
files=files_name(file_dir)
array=""
for afile in files:
	with open (afile,"r",encoding='utf8') as f:
        	array=f.read()
	jsonArray = json.loads(array, encoding='utf-8')
	res=mycol.insert_many(jsonArray)
	with open(r"/home/user02/mysql/mongodb/GeoLog.txt","a",encoding='utf8') as Log:
                Log.write(afile+"，res="+str(res)+"\n")
	print(res)
