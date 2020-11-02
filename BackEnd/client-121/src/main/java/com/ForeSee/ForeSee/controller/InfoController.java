package com.ForeSee.ForeSee.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final String REST_URL_PREFIX = "http://222.200.184.74:6666";
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
