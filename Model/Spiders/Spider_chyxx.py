# -*- coding: utf-8 -*-
# Written by panzy

import requests
from bs4 import BeautifulSoup
import json

def get_Stream_Text(StreamURL):
    response = requests.get(StreamURL)
    print('Pull request to ' + StreamURL)
    try:
        response.raise_for_status()
        coding_format = response.encoding
        return response.text.encode(coding_format).decode(requests.utils.get_encodings_from_content(response.text)[0])
    except requests.HTTPError as e:
        print(e)
        print('HTTPError: Request for Article Failed.')

def processStreamContent(content):
    soup = BeautifulSoup(content, 'html.parser')
    article_uls = soup.find_all(lambda tag: tag.name=='ul' and tag.get('class')==['list'])
    article_infos = []
    for article_ul in article_uls:
        article_lis = article_ul.find_all('li')
        for article_li in article_lis:
            # 解析到单篇文章
            article_info = {}
            article_info['title'] = article_li.find('a').get_text()
            article_info['link'] = 'http://www.chyxx.com' + article_li.find('a')['href']
            article_info['date'] = article_li.find('span').get_text()
            article_infos.append(article_info)
    print(article_infos)
    return article_infos

if __name__ == '__main__':
    article_info_all = []
    for page in range(31):
        url = 'https://www.chyxx.com/industry/internet/' + str(page+1) + '.html'
        article_info_page = processStreamContent(get_Stream_Text(url))
        article_info_all = article_info_all + article_info_page
    with open('C:\\Users\\Tommy Pan\\Desktop\\industry_article_info.json', 'w', encoding='utf-8') as f:
        f.write(json.dumps(article_info_all))
        f.close()
