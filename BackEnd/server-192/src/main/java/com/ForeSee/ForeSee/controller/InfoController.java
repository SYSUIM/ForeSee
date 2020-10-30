package com.ForeSee.ForeSee.controller;

import com.ForeSee.ForeSee.dao.MongodbDao;
import com.ForeSee.ForeSee.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@Slf4j
@RestController
public class InfoController {
    @Autowired
    InfoService infoService;

    /**
     * 根据关键词检索内容
     * @param query 关键词
     * @return
     */
    @GetMapping("/companyInfo/{query}")
    public String getCompanyInfo(@PathVariable("query")String query){
        log.info("Receive getCompanyInfo request: "+query);
        String result = infoService.getCompanyInfo(query);
        log.info(result);
        return result;
    }

    /**
     * 检索某个公司的所有相关信息
     * @param stockCode 公司代码
     * @return
     */
    @GetMapping("/allInfo/{stockCode}")
    public String getAllInfo(@PathVariable("stockCode")String stockCode){
        log.info("Receive getAllInfo request: "+stockCode);
        String result = infoService.getAllInfo(stockCode);
        log.info(result);
        return result;
    }
}
