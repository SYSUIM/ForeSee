import requests
import json

# 行业索引
# http://18.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112408027522003120358_1602254599330&pn={page}&pz=20&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:2+f:!50&fields=f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1602254599331
# 结束条件 data == null
# data(dict) -> diif(list)[{},{}……] -> {f12:行业编码, f14:行业名称}
def industry():
    d_industry = {}
    for i in [1,2,3,4]:
        url = 'http://18.push2.eastmoney.com/api/qt/clist/get?cb=jQuery112408027522003120358_1602254599330&pn={}&pz=20' \
            '&po=1&np=1&ut=bd1d9ddb04089700cf9c27f6f7426281&fltt=2&invt=2&fid=f3&fs=m:90+t:2+f:!50&fields=f1,f2,f3,f4,f5,f6,' \
            'f7,f8,f9,f10,f12,f13,f14,f15,f16,f17,f18,f20,f21,f23,f24,f25,f26,f22,f33,f11,f62,' \
            'f128,f136,f115,f152,f124,f107,f104,f105,f140,f141,f207,f208,f209,f222&_=1602254599331'.format(str(i))
        # print(url)
        data = requests.get(url).text
        data = eval(data[data.find('(')+1:data.find(')')])
        for j in data.get('data').get('diff'):
            d_industry[j.get('f12')] = j.get('f14')  # {hybm:hymc}
    return d_industry


# 股票索引
# http://push2.eastmoney.com/api/qt/clist/get?pn={4}&pz=50&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&fltt=2&invt=2&fid=f62&fs=b:BK0537&stat=1&fields=f12,f14,f2,f3,f62,f184,f66,f69,f72,f75,f78,f81,f84,f87,f204,f205,f124&rt=53408479&cb=jQuery18306402588362241342_1602254396466&_=1602254397006
# 结束条件 data == null
# data(dict) -> diif(list)[{},{}……] -> {f12:股票编码, f14:股票简称}
def stock(d_industry):
    d_stock = []
    count = -1
    for industry in d_industry.keys():
        count += 1
        hymc = d_industry[industry]
        d_stock.append({'industry_code':industry, 'industry_name':hymc,'stock':{}})
        for i in range(100):
            url = 'http://push2.eastmoney.com/api/qt/clist/get?pn={}&pz=50&po=1&np=1&ut=b2884a393a59ad64002292a3e90d46a5&flt' \
                  't=2&invt=2&fid=f62&fs=b:{}&stat=1&fields=f12,f14,f2,f3,f62,f184,f66,f69,f72,f75,f78,f81,f84,f87,f204,f20' \
                  '5,f124&rt=53408479&cb=jQuery18306402588362241342_1602254396466&_=1602254397006'.format(str(i+1), str(hy))
            print(url)
            data = requests.get(url).text.replace('null','"null"')
            data = eval(data[data.find('(')+1:data.find(')')])
            # print(data)
            try:
                data = data.get('data').get('diff')
                for j in data:
                    d_stock[count]['stock'][j.get('f12')] = j.get('f14')   # {stock_code: stock_name}
                    # print((j.get('f12'),j.get('f14')))
            except:
                break
    return d_stock

# 详情页
# http://f10.eastmoney.com/CompanySurvey/CompanySurveyAjax?code=SH603196
def details(index):
    # index [
    # {'industry_code': ,
    # 'industry_name': ,
    # 'stock': {股票编码: 股票名称}
    # }]
    data = {}  # 股票详情
    # data {
    #     industry_code:{
    #       stock_code:{
    #           ……
    #       }
    #   }
    # }
    for hy in index:
        data[hy['industry_code']] = {}
        i = hy['stock']
        for j in i.keys():
            url = 'http://f10.eastmoney.com/CompanySurvey/CompanySurveyAjax?code=SZ{}'.format(j)
            gp = eval(requests.get(url).text)
            gp = gp.get('jbzl')
            if gp == None:
                url = 'http://f10.eastmoney.com/CompanySurvey/CompanySurveyAjax?code=SH{}'.format(j)
                gp = eval(requests.get(url).text)
                gp = gp.get('jbzl')
                if gp == None:
                    print(url)
            data[hy][j] = gp
            print(url)
            # print(data[hy][j])
    return data

if __name__ == '__main__':

    pass

    # # 爬取股票索引
    # d_industry = industry()
    # d_stock = stock(d_industry)
    # d_stock = json.dumps(d_stock, ensure_ascii=False)
    # with open('stock_index.json', 'w', encoding='utf-8') as f:
    #     f.write(str(d_stock))

    # # 爬取公司详情
    # with open('stock_index.json', 'r', encoding='utf-8') as f:
    #     index = eval(f.read())
    #
    # # testIndex = {'BK0537': {'300433': '蓝思科技'}}
    # data = details(index)
    # data = json.dumps(data, ensure_ascii=False)
    # with open('stock_detail.json', 'w', encoding='utf-8') as f:
    #     f.write(str(data))

