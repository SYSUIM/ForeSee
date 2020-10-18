package com.ForeSee.ForeSee.service;

import com.ForeSee.ForeSee.dao.MongodbDao;
import com.ForeSee.ForeSee.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InfoService {
    @Autowired
    MongodbDao mongodbDao;
    @Autowired
    RedisDao redisDao;
    /**
     * 先将检索词传给redis，让redis找出这个公司的代号，再用mongodb查出他的信息
     * @param query 检索词
     * @return
     */
    public String getCompanyInfo(String query){
        // redis方法
        String stockCode = redisDao.getStockcode(query);
        // mongodb方法
        String companyInfo = mongodbDao.getCompanyInfo(stockCode);
        return companyInfo;
    }

    /**
     * 根据公司的代号检索mongodb，查出它的所有信息，包括基本信息、news、notice
     * @param stockCode 公司代号
     * @return
     */
    public String getAllInfo(String stockCode){
        StringBuffer sb = new StringBuffer("{\"companyInfo\":");
        String companyInfo = mongodbDao.getCompanyInfo(stockCode);
        companyInfo = companyInfo.substring(1,companyInfo.length()-1);
        if(companyInfo.length()==0){
            companyInfo = "{}";
        }
        sb.append(companyInfo);
        sb.append(",\"news\":");
        sb.append(mongodbDao.getStockNews(stockCode));
        sb.append(",\"notice_info\":");
        sb.append(mongodbDao.getStockNotice(stockCode));
        sb.append("}");
        return sb.toString();

    }
}
