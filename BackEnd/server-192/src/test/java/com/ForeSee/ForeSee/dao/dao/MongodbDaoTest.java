package com.ForeSee.ForeSee.dao.dao;

import com.ForeSee.ForeSee.dao.MongodbDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MongodbDaoTest {
    @Autowired
    MongodbDao mongodbDao;
    @Test
    public void getCompanyInfo(){
        String result = mongodbDao.getCompanyInfo("300433");
        log.info(result);
    }
    @Test
    public void getStockNotice(){
        String result = mongodbDao.getStockNotice("000828");
        log.info(result);
    }
    @Test
    public void getStockNews(){
        String result = mongodbDao.getStockNews("300433");
        log.info(result);
    }
}
