import os
import re
import csv
import time
import json
import logging
import requests
import pandas as pd
from bs4 import BeautifulSoup
from jsonpath import jsonpath

log_name = './viewNotice.log'
if os.path.exists(log_name):
    os.remove(log_name)
logging.basicConfig(filename=log_name,
                    level=logging.INFO,
                    format='[%(asctime)s]  %(levelname)-12s | %(message)s',
                    datefmt='%Y-%m-%d %H:%M:%S')
logger = logging.getLogger()


class NoticeSpider:

    def __init__(self, input_file, download_path, data_path, final_data_path):
        # 得到命名元组迭代器
        all_data = pd.read_csv(input_file, header=0, dtype=str)
        self.groups = all_data.groupby('industry_code')
        self.download_path = download_path
        self.data_path = data_path
        self.final_data_path = final_data_path
        self.headers = {
            'Accept': 'application/json, text/plain, */*',
            'Connection': 'keep-alive',
            'Cookie': 'acw_tc=2760824016027758519397694e39887f25f884631bd1ec5b81b6f7ee0b8a81;xq_a_token=3242a6863ac15761c18a8469b89065b03bd5e164',
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36'
        }

    def _writeJSON(self, data, file_name):
        with open(file_name, 'w', encoding='utf-8') as f:
            json.dump(data, f, ensure_ascii=False)

    def _writeFailCode(self, code):
        with open(self.final_data_path + 'failCode.csv', 'a', encoding='utf-8') as f:
            writer = csv.writer(f)
            writer.writerow([code])

    def run(self):
        '''
        # 命名元组通过'对象名.属性'获取相应值
        # stock的属性：industryCode, stockCode, companyName
        # 运作流程
            1. 获取股票全代码：雪球网的股票页url中包含股票全代码(即包含证券的前缀，如SZ300433)
            2. 获取公告信息的字典并完成公告下载
        # notice_info数组按公告发布时间从新到旧排布
        # 数组中每个元素为字典，键的含义如下：
            - notice_title：公告名
            - notice_time：发布时间
            - link：公告链接
        '''
        logger.info('Start crawling notice!')
        for ind, ind_data in self.groups:
            generatePath(self.data_path + f'{ind}/')
            logger.info(f'Start crawling industry: {ind}')
            for stock in ind_data.itertuples(index=False):
                file_name = self.data_path + f'{ind}/{stock.stock_code}.json'
                if os.path.exists(file_name):
                    continue
                else:
                    stock_info = self._getStockInfo(ind, stock)
                    if stock_info:
                        self._writeJSON(stock_info, file_name)
            logger.info(f'Finish transfering data into json!')
        logger.info('Finish crawling notice!')

    def _getStockInfo(self, ind, stock):
        stock_dict = {}
        code = str(stock.stock_code)
        stock_dict['industry_code'] = ind
        stock_dict['stock_code'] = code
        stock_dict['company_name'] = stock.company_name
        stock_dict['stock_name'] = stock.short_name
        logger.info(f'Start crawling stock: {code}')
        full_code = self._getFullCode(code)
        if not full_code:
            return None
        notice_info = self._getNoticeInfo(full_code, self._processSpecial(stock))
        stock_dict['notice_info'] = notice_info
        logger.info(f'Finish crawling stock: {code}')
        return stock_dict

    def _processSpecial(self, stock):
        if stock.short_name == '海控Ｂ股':
            return '海航控股'
        else:
            return stock.short_name

    def _getFullCode(self, code):
        url = 'https://xueqiu.com/stock/search.json?code=' + str(code)
        try:
            r = requests.get(url, headers=self.headers)
            r.raise_for_status()
            r.encoding = r.apparent_encoding
            content = json.loads(r.text)
            stock = jsonpath(content, '$.stocks')[0][0]
            full_code = stock['code']
            return full_code
        except Exception:
            logger.error(f'Fail to get full code of stock: {str(code)}')
            self._writeFailCode(code)
            return None

    def _getNoticeInfo(self, full_code, stock_name):
        base_url = 'https://xueqiu.com/statuses/stock_timeline.json?symbol_id=' + str(full_code) + '&count=20&source=%E5%85%AC%E5%91%8A&page='
        # 初始化
        notice_info = []
        page = 1
        max_page = 2
        download_path = self.download_path + str(full_code)[2:] + '/'
        generatePath(download_path)
        # 编译用于获取公告标题的正则表达式
        regex = re.compile(f'(公司公告：.*)?{stock_name}：?(.*?) ')
        while page <= max_page:
            try:
                time.sleep(2)
                url = base_url + str(page)
                r = requests.get(url, headers=self.headers)
                r.raise_for_status()
                r.encoding = r.apparent_encoding
                content = json.loads(r.text)
                if page == 1:
                    max_page = jsonpath(content, '$.maxPage')[0]
                notices = jsonpath(content, '$.list.*')
                logger.info(f'Getting page {page} of stock:  {full_code[2:]}')
                for notice in notices:
                    try:
                        this_dict = {}
                        title, link = self._getNotice(notice['description'], regex)
                        this_dict['notice_title'] = title
                        this_dict['notice_time'] = self._transferTime(notice['created_at'])
                        this_dict['link'] = link
                        self._downloadNotice(download_path, title, link)
                        notice_info.append(this_dict)
                    except Exception:
                        continue
            except Exception as e:
                logger.error(f'Fail to get page {str(page)} of stock: {full_code}')
                logger.error(e.args)
            page += 1
        notice_info.reverse()
        return notice_info

    # 将时间戳转换为日期
    def _transferTime(self, timeStamp):
        timeArray = time.localtime(timeStamp/1000)
        realtime = time.strftime('%Y-%m-%d', timeArray)
        return realtime

    # 从description中获取title和link
    def _getNotice(self, text, regex):
        soup = BeautifulSoup(text, 'html.parser')
        try:
            m = regex.match(soup.text)
            title = m.group(2)
        except Exception:
            logger.error(soup.text)
        link = soup.a['href']
        return title, link

    def _downloadNotice(self, download_path, title, link):
        try:
            filename = f'{download_path}{title}.pdf'
            if not os.path.exists(filename):
                r = requests.get(link, headers=self.headers)
                with open(filename, 'wb') as f:
                    f.write(r.content)
        except Exception as e:
            logger.error(e.args)


# 查看目录是否存在，不存在则生成
def generatePath(path):
    if not os.path.exists(path):
        os.mkdir(path)


if __name__ == '__main__':
    input_file = '../basic/companyIndex.csv'
    download_path = './download/'
    data_path = './data/'
    final_data_path = './'
    for path in [download_path, data_path, final_data_path]:
        generatePath(path)
    spider = NoticeSpider(input_file, download_path, data_path, final_data_path)
    spider.run()
