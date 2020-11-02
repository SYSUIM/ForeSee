import os
import json
import pymongo
myclient = pymongo.MongoClient("mongodb://localhost:27017/")
mydb = myclient["ForeSee"]
mycol = mydb["ArticleInfo"]
afile=r"/data/prj2020/EnterpriseSpider/analysis/Internet_article_abstract.json"
array=""
with open (afile,"r",encoding='utf8') as f:
        array=f.read()
jsonArray = json.loads(array, encoding='utf-8')
for json in jsonArray:
        res=mycol.update_one({"aid":json["id"]},{ "$set":{"abstract":json["abstract"]}})
        with open(r"/home/user02/mysql/mongodb/ArticleInfoLog.txt","a",encoding='utf8') as Log:
                Log.write(json["id"]+"，res="+str(res)+"\n")
        print(res)
