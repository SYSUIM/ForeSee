package com.ForeSee.ForeSee.service;

import com.ForeSee.ForeSee.dao.MongoDBDao.*;
import com.ForeSee.ForeSee.dao.RedisDao;
import com.ForeSee.ForeSee.util.MongoConn;
import com.mongodb.MongoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class InfoService {
    @Autowired
    StockNotice stockNotice;
    @Autowired
    RedisDao redisDao;
    /**
     * 先将检索词传给redis，让redis找出这个公司的代号，再用mongodb查出他的信息
     * @param query 检索词
     * @return
     */
    public String getCompanyInfo(String query){
        // redis模糊查询返回stockCodeList
        List<String> stockCodes = redisDao.getStockCodeList(query);
        log.info("Fuzzy matching result: " + stockCodes);
        // mongodb方法
        MongoClient mongoClient=null;
        String companyInfo;
        try {
            mongoClient = MongoConn.getConn();
            companyInfo = CompanyInfo.getCompanyInfo(stockCodes, mongoClient);
        }finally {
            mongoClient.close();
        }
        return companyInfo;
    }

    /**
     * 根据公司的代号检索mongodb，查出它的所有信息，包括基本信息、news、notice
     * @param stockCode 公司代号
     * @return
     */
    public String getAllInfo(String stockCode){
        MongoClient mongoClient=null;
        StringBuffer sb;
        try {
            mongoClient = MongoConn.getConn();
            sb = new StringBuffer("{");
            String companyInfo = CompanyInfo.getCompanyInfo(stockCode, mongoClient);
            sb.append(companyInfo.substring(1, companyInfo.length() - 1));
            sb.append(",");
            String stockNews = StockNews.getThreeLatestStockNews(stockCode, mongoClient);
            sb.append(stockNews.substring(1, stockNews.length() - 1));
            sb.append(",");
            String stockNotice = StockNotice.getThreeLatestStockNotice(stockCode, mongoClient);
            sb.append(stockNotice.substring(1, stockNotice.length() - 1));
            sb.append(",\"profit\":{");
            String profit = Profit.getProfit(stockCode, mongoClient);
            sb.append(profit.substring(1, profit.length() - 1));
            sb.append("},");
            String geo = GeoInfo.getCompanyGeoInfo(stockCode,mongoClient);
            sb.append(geo);
            sb.append("}");
        }finally {
            mongoClient.close();
        }
        return sb.toString();
    }
    /**
     * 根据行业代号查询简介、url、地理位置
     * @param industryCode 行业
     * @return
     */
    public String getIndustryInfo(String industryCode){
        MongoClient mongoClient=null;
        StringBuilder sb=new StringBuilder();
        try {
            mongoClient = MongoConn.getConn();
            sb.append(IndustryInfo.getIndustryInfo(industryCode,mongoClient));
        }finally {
            mongoClient.close();
        }
        return sb.toString();
    }
}
