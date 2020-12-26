import os
import time
import pandas as pd
from getStock import get_stock_info
from multiprocessing import Pool


def run(input_file, download_path, data_path, log_path):
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
    all_data = pd.read_csv(input_file, header=0, dtype=str)
    for ind, ind_data in all_data.groupby('industry_code'):
        # 生成以行业代码为名的目录
        generatePath(data_path + f'{ind}/')
        generatePath(download_path + f'{ind}/')

    # 多进程获取公告
    p = Pool(20)
    print(f'[{time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())}]  Start crawling notice!')
    for stock in all_data.itertuples(index=False):
        file_name = data_path + f'{stock.industry_code}/{stock.stock_code}.json'
        if os.path.exists(file_name):
            print(f'[{time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())}]  Have crawn industry: {stock.industry_code}, stock: {stock.stock_code}!')
            continue
        else:
            # 需要将命名元组转换为普通字典，否则多进程不运行
            stock_dict = dict(stock._asdict())
            # get_stock_info(file_name, stock_dict, download_path, log_path)
            p.apply_async(get_stock_info, args=(file_name, stock_dict, download_path, log_path), callback=handle)
    p.close()
    p.join()
    print(f'[{time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())}]  Finish crawling notice!')


def handle(ret):
    print(f'[{time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())}]  Finish crawling industry:{ret[0]}, stock:{ret[1]}!')


# 查看目录是否存在，不存在则生成
def generatePath(path):
    if not os.path.exists(path):
        os.mkdir(path)


if __name__ == '__main__':
    # 设置相关路径
    input_file = 'company.csv'
    download_path = './download/'
    data_path = './data/'
    log_path = './log/'
    for path in [download_path, data_path, log_path]:
        generatePath(path)
    for file in ['failCode.csv', 'wrongCode.csv']:
        if os.path.exists(file):
            os.remove(file)
    run(input_file, download_path, data_path, log_path)
