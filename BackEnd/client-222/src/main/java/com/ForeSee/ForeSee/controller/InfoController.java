package com.ForeSee.ForeSee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@CrossOrigin("*")
@RestController
public class InfoController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${http.REST_URL_PREFIX}")
    String REST_URL_PREFIX;
    /**
     * 根据关键词检索内容
     * @param query 关键词
     * @return
     */
    @GetMapping("/companyInfo/{query}")
    public String getCompanyInfo(@PathVariable("query")String query){
        log.info("Receive getCompanyInfo request:" + query);
        String url = REST_URL_PREFIX + "/companyInfo/" + query;
        String result = restTemplate.getForObject(url, String.class);
        log.info("Result: " + result);
        return result;
    }
    /**
     * 根据stockCode检索某一页的Notice
     * @param stockCode page
     * @return
     */
    @GetMapping("/allNotice/{stockCode}/{page}")
    public String getAllNotice(@PathVariable("stockCode")String stockCode,@PathVariable("page")String page){
        log.info("Receive getAllNotice request:" + stockCode+" page="+page);
        String url = REST_URL_PREFIX + "/allNotice/" + stockCode+"/"+page;
        String result = restTemplate.getForObject(url, String.class);
        log.info("Result: " + result);
        return result;
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
        String url = REST_URL_PREFIX + "/industryReports/" + industryCode+"/"+page;
        String result = restTemplate.getForObject(url, String.class);
        log.info("Result: " + result);
        return result;
    }

    /**
     * 根据stockCode检索某一页的News
     * @param stockCode page
     * @return
     */
    @GetMapping("/allNews/{stockCode}/{page}")
    public String getAllNews(@PathVariable("stockCode")String stockCode,@PathVariable("page")String page){
        log.info("Receive getAllNews request:" + stockCode+" page="+page);
        String url = REST_URL_PREFIX + "/allNews/" + stockCode+"/"+page;
        String result = restTemplate.getForObject(url, String.class);
        log.info("Result: " + result);
        return result;
    }

    /**
     * 检索某个公司的所有相关信息
     * @param stockCode 公司代号
     * @return
     */
    @GetMapping("/allInfo/{stockCode}")
    public String getAllInfo(@PathVariable("stockCode")String stockCode){
        log.info("Receive getAllInfo request:" + stockCode);
        String url = REST_URL_PREFIX + "/allInfo/" + stockCode;
        String result = restTemplate.getForObject(url, String.class);
        log.info("Result: " + result);
        return result;
    }

    /**
     * 检索某个行业的相关信息
     * @param industryCode 行业代号
     * @return
     */
    @GetMapping("/industryInfo/{industryCode}")
    public String getIndustryInfo(@PathVariable("industryCode")String industryCode) {
        log.info("Receive getIndustryInfo request:" + industryCode);
        String url = REST_URL_PREFIX + "/industryInfo/" + industryCode;
        String result = restTemplate.getForObject(url, String.class);
        log.info("Result: " + result);
        return result;
    }
}
