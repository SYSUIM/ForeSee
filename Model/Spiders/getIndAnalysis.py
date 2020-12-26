# -*- coding: utf-8 -*-
# Written by panzy

import requests
from bs4 import BeautifulSoup
import json
import re

def get_Stream_Text(StreamURL):
    response = requests.get(StreamURL)
    print('Pull request to ' + StreamURL)
    try:
        response.raise_for_status()
        coding_format = response.encoding
        return response.text.encode(coding_format).decode(requests.utils.get_encodings_from_content(response.text)[0])
    except requests.HTTPError as e:
        print(e)
        print('HTTPError: Request for Stream Failed.')

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
            article_info['aid'] = article_li.find('a')['href'][:-5]
            pub_date_str = article_li.find('span').get_text()
            if ' ' in pub_date_str:
                article_info['pub_date'] = {
                    'year': 2020,
                    'month': re.match(r'(\d*)(月)(\d*)(日)(.*)', pub_date_str).groups()[0],
                    'day': re.match(r'(\d*)(月)(\d*)(日)(.*)', pub_date_str).groups()[2]
                }
            else:
                article_info['pub_date'] = {
                    'year': re.match(r'(\d*)(年)(\d*)(月)(\d*)(日)(.*)', pub_date_str).groups()[0],
                    'month': re.match(r'(\d*)(年)(\d*)(月)(\d*)(日)(.*)', pub_date_str).groups()[2],
                    'day': re.match(r'(\d*)(年)(\d*)(月)(\d*)(日)(.*)', pub_date_str).groups()[4],
                }
            try:
                article_info['analysis_year'] = re.match(r'(.*)(20\d{2})-(20\d{2})(年|.)(.*)', article_info['title']).groups()[1]
            except AttributeError as e:
                try:
                    article_info['analysis_year'] = re.match(r'(.*)(20\d{2})(年|.)(.*)', article_info['title']).groups()[1]
                except AttributeError as e:
                    print(e, 'Failed to match ANALYSE YEAR')
                    article_info['analysis_year'] = article_info['pub_date']['year']
            article_infos.append(article_info)
    print(article_infos)
    return article_infos

def WriteArticleInfoJson(article_info_all, name):
    with open('C:\\Users\\Tommy Pan\\Desktop\\' + name, 'w', encoding='utf-8') as f:
        json.dump(article_info_all, f, ensure_ascii=False)

def getArticleHTML(ArticleURL):
    response = requests.get(ArticleURL)
    print('Pull request to ' + ArticleURL)
    try:
        response.raise_for_status()
        coding_format = response.encoding
        return response.text.encode(coding_format).decode(requests.utils.get_encodings_from_content(response.text)[0])
    except requests.HTTPError as e:
        print(e)
        print('HTTPError: Request for Article Failed.')

def toBeautifulSoup(content):
    soup = BeautifulSoup(content, 'html.parser')
    return soup.body.find('div', attrs = {'class': 'articleBody news-content'})

def processArticleContent(soupDiv):
    articleContent = soupDiv.get_text().replace('\n', '').replace('\xa0', '')
    # 去除字符串前后空格字符串
    articleContent = articleContent.strip()
    return articleContent

def getAbstract(soupDiv):
    for abstract in soupDiv.contents:
        try:
            if len(abstract.get_text()) < 30:
                continue
            else: break
        except AttributeError: continue
    abstract = abstract.get_text().replace('\xa0', '').strip()
    if len(abstract) > 75:
        abstract = abstract[:75]
    return abstract

if __name__ == '__main__':
    article_info_all = []
    article_abstract_all = {}
    article_content_all = {}
    for page in range(31):
        url = 'https://www.chyxx.com/industry/internet/' + str(page+1) + '.html'
        article_info_page = processStreamContent(get_Stream_Text(url))
        article_info_all = article_info_all + article_info_page
    WriteArticleInfoJson(article_info_all, 'Internet_article_info.json')
    for article_info in article_info_all:
        soupDiv = toBeautifulSoup(getArticleHTML(article_info['link']))
        articleContent = processArticleContent(soupDiv)
        articleAbstract = getAbstract(soupDiv)
        article_abstract_all[article_info['aid']] = articleAbstract
        article_content_all[article_info['aid']] = articleContent
    WriteArticleInfoJson(article_content_all, 'Internet_article_content.json')
    WriteArticleInfoJson(article_abstract_all, 'Internet_article_abstract.json')