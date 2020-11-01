import os
import json
import logging
import requests
import pandas as pd
from jsonpath import jsonpath

log_name = './viewGeo.log'
if os.path.exists(log_name):
    os.remove(log_name)
logging.basicConfig(filename=log_name,
                    level=logging.INFO,
                    format='[%(asctime)s]  %(levelname)-12s | %(message)s',
                    datefmt='%Y-%m-%d %H:%M:%S')
logger = logging.getLogger()


def getGeoInfo(address, error_num):
    url = f'http://api.map.baidu.com/geocoding/v3/?address={address}&output=json&ak=8e0YnN6TkPzG5pvSzOAzVPxU5tENgrtt'
    try:
        r = requests.get(url)
        content = json.loads(r.text)
        site = jsonpath(content, '$..location')[0]
        return site['lng'], site['lat']
    except Exception:
        logger.error(f'{address}')
        error_num += 1
        return False, False


def getAllGeoInfo(data_path):
    error_num = 0
    all_data = pd.read_csv('../basic/newCompanyIndex.csv', header=0, dtype=str)
    for ind, ind_data in all_data.groupby('industryCode'):
        industry = []
        logger.info(f'Start crawling industry: {ind}')
        for stock in ind_data.itertuples(index=False):
            logger.info(f'Get location information of stock: {stock.stockCode}')
            geo_info = {}
            lng, lat = getGeoInfo(stock.companyAddress, error_num)
            if not lng:
                continue
            geo_info['lng'] = lng
            geo_info['lat'] = lat
            geo_info['company_name'] = stock.companyName
            geo_info['stock_code'] = stock.stockCode
            geo_info['industry_code'] = ind
            industry.append(geo_info)
        with open(data_path + f'{ind}.json', 'w', encoding='utf-8') as f:
            json.dump(industry, f, ensure_ascii=False)
    logger.info(f'Finish! Error num: {error_num}')


if __name__ == '__main__':
    data_path = './geoData/'
    getAllGeoInfo(data_path)
    logger.info()
