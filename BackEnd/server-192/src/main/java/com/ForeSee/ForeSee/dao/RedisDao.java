package com.ForeSee.ForeSee.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zenglr
 * @ClassName RedisDao
 * @Description
 * @create 2020-10-08-9:17 上午
 */
@Slf4j
@Component
public class RedisDao {

//    根据stockname得到stockcode
//    public static String getCodeByStockcode(String stockcode)
//    {
//        Jedis jedis = new Jedis("192.168.1.108",6479);
//        jedis.auth("nopassword");
//        jedis.select(1);
//        if(jedis.sismember("stockcode", stockcode))
//            return stockcode;
//        else return null;
//    }
//
//    //根据stockname得到stockcode
//    public static String getCodeByStcokname(String stockname)
//    {
//        Jedis jedis = new Jedis("192.168.1.108",6479);
//        jedis.auth("nopassword");
//        jedis.select(2);
//        if(jedis.exists(stockname))
//            return jedis.get(stockname);
//        else return null;
//    }
//
//    //根据companyname得到stockcode
//    public static String getCodeByCompanyname(String companyname)
//    {
//        Jedis jedis = new Jedis("192.168.1.108",6479);
//        jedis.auth("nopassword");
//        jedis.select(3);
//        if ((jedis.exists(companyname)))
//            return jedis.get(companyname);
//        else return null;
//    }

    //一框式检索，根据stockcode、stockname、companyname的检索统一返回stockcode
    public String getStockcode(String query)
    {
        query=query.replaceAll(" ","");
        Jedis jedis = new Jedis("192.168.1.108",6479);
        jedis.auth("nopassword");
        jedis.select(2);
        if(jedis.sismember("stockcode",query)){
            return query;
        }
        else if(jedis.exists(query)){
            return jedis.get(query);
        }
        else{
            return null;
        }

    }
//    @Autowired
//    private StringRedisTemplate redisTemplate;
//
//    static int pagecount=20;
//    /**
//     * 查询首页的id
//     * @param query 检索词
//     * @return keys
//     */
////    @Cacheable(value = "bw_id", key = "#query")
//    public List<String> getIDList(String query) {
//        List<String> keys = new ArrayList<String>();
//        try {
//            if (redisTemplate.hasKey(query)) {
//                log.info("使用redis查询query返回idList");
//                keys.addAll(redisTemplate.opsForZSet().reverseRange(query,0,19));
//            } else {
//                log.info("redis没有找到query");
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//        return keys;
//    }
//
//    /**
//     * 根据页码查询id
//     * @param query 检索词
//     * @param page 页码
//     * @return keys
//     */
//    public List<String> getIDListOnPage(String query, int page) {
//        int start = (page - 1 ) * pagecount;
//        int end = start + page - 1;
//        List<String> keys = new ArrayList<String>();
//        try {
//            if (redisTemplate.hasKey(query)) {
//                log.info("使用redis查询query返回idList");
//                keys.addAll(redisTemplate.opsForZSet().reverseRange(query,start,end));
//            } else {
//                log.info("redis没有找到query");
//            }
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//        return keys;
//    }
//
//    /**
//     * 返回页码总数
//     * @param query 检索词
//     * @return page
//     */
//    public long getPageNumber(String query)
//    {
//        long num = redisTemplate.opsForZSet().zCard(query);
//        long page = num/pagecount + 1;
//        return page;
//    }

}
