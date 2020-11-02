import os
import json
import pymongo
myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["ForeSee"]
mycol = mydb["ArticleInfo"]
afile=r"/data/prj2020/EnterpriseSpider/analysis/Internet_article_info.json"
array=""
with open (afile,"r",encoding='utf8') as f:
	array=f.read()
jsonArray = json.loads(array, encoding='utf-8')
for json in jsonArray:
	date=str(json["pub_date"]["year"])+"-"+str(json["pub_date"]["month"])+"-"+str(json["pub_date"]["day"])
	json["pub_date"]=date
	res=mycol.insert_one(json)
	with open(r"/home/user02/mysql/mongodb/ArticleInfoLog.txt","a",encoding='utf8') as Log:
		Log.write(json["aid"]+"，res="+str(res)+"\n")
	print(res)
