import os
import re
import csv
import time
import json
import requests
import traceback
from retrying import retry
from bs4 import BeautifulSoup
from jsonpath import jsonpath
from getLog import Logger

headers = {
    'Accept': 'application/json, text/plain, */*',
    'Connection': 'keep-alive',
    'Cookie': 'acw_tc=2760822e16048928135948745ebee7b9fb6357e66c971c1e47ca4b8a20792e;xq_a_token=db48cfe87b71562f38e03269b22f459d974aa8ae',
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36'
}


def _writeJSON(data, file_name):
    with open(file_name, 'w', encoding='utf-8') as f:
        json.dump(data, f, ensure_ascii=False, indent=4)


def _writeFailCode(ind, code):
    with open('failCode.csv', 'a', encoding='utf-8') as f:
        writer = csv.writer(f)
        writer.writerow([ind, code])


def get_stock_info(file_name, stock_dict, download_path, log_path):
    # 获取日志
    ind, full_code, stock_code = stock_dict['industry_code'], stock_dict['full_code'], stock_dict['stock_code']
    log = Logger(log_path, f'{ind}_{stock_code}')
    logger = log.getLogger()
    # 获取公告
    logger.info(f'Start crawling industry: {ind}, stock:{stock_code}')
    notice_info = _getNoticeInfo(ind, full_code, download_path, logger)
    stock_dict['notice_info'] = notice_info
    if stock_dict:
        _writeJSON(stock_dict, file_name)
    logger.info('Finish!')
    log.remove()
    return ind, stock_code


def _getNoticeInfo(ind, full_code, download_path, logger):
    base_url = 'https://xueqiu.com/statuses/stock_timeline.json?symbol_id=' + str(full_code) + '&count=20&source=%E5%85%AC%E5%91%8A&page='
    # 初始化
    notice_info = []
    page = 1
    max_page = 2
    download_path = download_path + f'{ind}/{str(full_code)[2:]}/'
    generatePath(download_path)
    # 编译用于获取公告标题的正则表达式
    regex = re.compile('(公司公告：)?\d*：?\s*?(.*?)：(.*?) ')
    while page <= max_page:
        try:
            time.sleep(2)
            url = base_url + str(page)
            r = requests.get(url, headers=headers)
            r.raise_for_status()
            r.encoding = r.apparent_encoding
            content = json.loads(r.text)
            if page == 1:
                max_page = jsonpath(content, '$.maxPage')[0]
            notices = jsonpath(content, '$.list.*')
            logger.info(f'Getting page {page} of stock:{full_code[2:]}')
            if not notices:
                _writeFailCode(ind, full_code)
                logger.error(f'Cannot get any notice of stock:{full_code[2:]}')
                break
            for notice in notices:
                this_dict = {}
                title, link = _getNotice(notice['description'], regex)
                if not link:
                    print(f'[{time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())}]  Error in industry: {ind}, stock:{full_code[2:]}')
                    logger.error(f'Stock:{full_code[2:]} Title:{title}')
                    continue
                this_dict['notice_title'] = title
                this_dict['notice_time'] = _transferTime(notice['created_at'])
                this_dict['link'] = link
                if '：' not in title and '摘要' not in title and ('年度报告' in title or '季度报告' in title):
                    _downloadNotice(download_path, title, link)
                notice_info.append(this_dict)
        except Exception:
            traceback.print_exc()
            page += 1
            continue
        page += 1
    notice_info.reverse()
    return notice_info


# 将时间戳转换为日期
def _transferTime(timeStamp):
    timeArray = time.localtime(timeStamp/1000)
    realtime = time.strftime('%Y-%m-%d', timeArray)
    return realtime


# 从description中获取title和link
def _getNotice(text, regex):
    soup = BeautifulSoup(text, 'html.parser')
    try:
        m = regex.match(soup.text)
        title = m.group(3)
    except Exception:
        title = soup.text
        if len(soup.text) > 50:
            return title, False
    try:
        link = soup.a['href']
    except Exception:
        return title, False
    return title, link


@retry(stop_max_attempt_number=5, wait_fixed=3000)
def _downloadNotice(download_path, title, link):
    filename = f'{download_path}{title}.pdf'
    if not os.path.exists(filename):
        r = requests.get(link, headers=headers)
        with open(filename, 'wb') as f:
            f.write(r.content)


# 查看目录是否存在，不存在则生成
def generatePath(path):
    if not os.path.exists(path):
        os.mkdir(path)
