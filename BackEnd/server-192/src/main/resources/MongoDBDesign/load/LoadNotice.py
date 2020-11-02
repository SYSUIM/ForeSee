import os
import pymongo
myclient=pymongo.MongoClient("mongodb://localhost:27017/")
db=myclient["ForeSee"]
col=db["Notice"]
fault_stock_code=set()
def get_fault_stockcode():
	with open(r"/data/prj2020/EnterpriseSpider/notice/failCode.csv","r",encoding="utf8") as f:
		for line in f.readlines():
			fault_stock_code.add(line[:-1])
def file_name(file_dir:str):
	dirs=os.listdir(file_dir)
	files=[]
	for adir in dirs:
		files+=[file_dir+adir+"/"+x for x in os.listdir(file_dir+adir+"/") if x.split(".")[0] not in fault_stock_code]
	return files

get_fault_stockcode()
print(str(fault_stock_code))
file_dir=r"/data/prj2020/EnterpriseSpider/notice/data/"
files=file_name(file_dir)
for afile in files:
	noticeArray=[]
	with open(afile,"r",encoding="utf8") as f:
		print("now ",afile)
		dic=dict(eval(f.read()))
		print("file has been split")
		noticeArray=dic["notice_info"]
		if not noticeArray:
			noticeArray=[{}]
		info={"industry_code":dic["industry_code"],"stock_code":dic["stock_code"]}
		for notice in noticeArray:
			notice.update(info)
	res=col.insert_many(noticeArray)
	print(res)
	with open(r"/home/user02/mysql/mongodb/NoticeLog.txt","a",encoding='utf8') as Log:
		Log.write(afile+"res="+str(res)+"\n")
			
		
