import os
import json
def file_name(file_dir:str):
	dirs=os.listdir(file_dir)
	files=[]
	for adir in dirs:
		files+=[file_dir+adir+"/"+x for x in os.listdir(file_dir+adir+"/")]
	return files
files=file_name(r"/data/prj2020/EnterpriseSpider/basic/BasicInfoFile/")
for afile in files:
	print("now "+afile)
	res=os.system("mongoimport --db ForeSee --collection BasicInfo --file "+afile)
	if(res!=0):
		with open(r"/home/user02/mysql/mongodb/BasicInfoError.txt","a",encoding='utf8') as errorLog:
			errorLog.write(afile+"导入失败，res="+str(res)+"\n")
	else:
		with open(r"/home/user02/mysql/mongodb/BasicInfoSuccess.txt",'a',encoding='utf8') as successLog:
			successLog.write(afile+"成功"+"\n")
	print(res)
