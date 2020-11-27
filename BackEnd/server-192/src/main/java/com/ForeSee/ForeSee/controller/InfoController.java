package com.ForeSee.ForeSee.controller;

import com.ForeSee.ForeSee.service.InfoService;
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
     * 根据stockCode返回某一页的News
     * @param stockCode page
     * @return
     */
    @GetMapping("/allNews/{stockCode}/{page}")
    public String getAllNews(@PathVariable("stockCode")String stockCode,@PathVariable("page")String page){
        log.info("Receive  getAllNews stockCode: " + stockCode+" page:"+page);
        log.info("Search for News...");
        String companyInfo = infoService.getAllNews(stockCode, page);
        log.info("Result: " + companyInfo);
        return companyInfo;
    }


    /**
     * 根据stockCode返回某一页的Notice
     * @param stockCode
     * @param page
     * @return
     */
    @GetMapping("/allNotice/{stockCode}/{page}")
    public String getAllNotice(@PathVariable("stockCode")String stockCode,@PathVariable("page")String page){
        log.info("Receive  getAllNotice stockCode: " + stockCode+" page:"+page);
        log.info("Search for Notice...");
        String companyInfo = infoService.getAllNotice(stockCode, page);
        log.info("Result: " + companyInfo);
        return companyInfo;
    }

    /**
     * 根据industryCode返回某一页的行业分析报告
     * @param industryCode
     * @param page
     * @return
     */
    @GetMapping("/industryReports/{industryCode}/{page}")
    public String getIndustryReports(@PathVariable("industryCode")String industryCode,@PathVariable("page")String page){
        log.info("Receive  getIndustryReports industryCode: " + industryCode+" page:"+page);
        log.info("Search for IndustryReports...");
        String industryReports = infoService.getIndustryReports(industryCode, page);
        log.info("Result: " + industryReports);
        return industryReports;
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

