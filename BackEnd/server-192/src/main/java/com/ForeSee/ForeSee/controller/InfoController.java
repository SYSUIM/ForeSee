package com.ForeSee.ForeSee.controller;

import com.ForeSee.ForeSee.service.InfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
        log.info("Receive query: " + query);
        log.info("Search according to the query...");
        String companyInfo = infoService.getCompanyInfo(query);
        log.info("Result: " + companyInfo);
        return companyInfo;
    }

    /**
     * 检索某个公司的所有相关信息
     * @param stockCode 公司代号
     * @return
     */
    @GetMapping("/allInfo/{stockCode}")
    public String getAllInfo(@PathVariable("stockCode")String stockCode){
        log.info("Receive stockCode: "+stockCode);
        log.info("Search all information of the company according to the stockCode");
        String allInfo = infoService.getAllInfo(stockCode);
        log.info("Result: " + allInfo);
        return allInfo;
    }

    /**
     * 根据行业代号查询简介、url、地理位置
     * @param industryCode 行业代号
     * @return
     */
    @GetMapping("/industryInfo/{industryCode}")
    public String getIndustryInfo(@PathVariable("industryCode")String industryCode){
        log.info("Receive industryCode: " + industryCode);
        log.info("Search information of the industry according to the industryCode");
        String industryInfo = infoService.getIndustryInfo(industryCode);
        log.info("Result: " + industryInfo);
        return industryInfo;
    }

}

