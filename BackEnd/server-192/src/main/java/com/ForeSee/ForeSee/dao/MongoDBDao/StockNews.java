package com.ForeSee.ForeSee.dao.MongoDBDao;

import com.ForeSee.ForeSee.util.MongoConn;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Sorts;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

@Slf4j
public class StockNews {
    private static class NewsStructureHolder{
        static List<String> newsStructure=new ArrayList();
        static{
            newsStructure.add("news_title");
            newsStructure.add("news_time");
            newsStructure.add("news_link");
        }
    }
    private static List<String> getNewsStructure(){
        return NewsStructureHolder.newsStructure;
    }
    private static final String jsonHead="[\"news\":[";
    private static final String tableName="News";
    private static MongoCursor<Document> cursor;
    private static StringBuilder sb;
    private static MongoCollection<Document> collection;
    /**
     * 查询News表，拿出所有StockNews
     * @param stockCode
     * @return 返回字段见 NewsStructureHolder.newsStructure
     */
    public static String getAllStockNews(String stockCode, MongoClient client) {
        int code = Integer.parseInt(stockCode);
        collection= MongoConn.getConn().getDatabase("ForeSee").getCollection(tableName);
        cursor = collection.find(eq("stock_code", code)).iterator();
        sb = new StringBuilder(jsonHead);
        try {
            while (cursor.hasNext()) {
                Document originDoc = cursor.next(),extractDoc=new Document();
                for(String name:getNewsStructure()){
                    extractDoc.put(name,originDoc.get(name));
                }
                sb.append(extractDoc.toJson());
                sb.append(",");
            }
        } finally {
            cursor.close();
        }
        if (sb.length() > jsonHead.length()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]]");
        log.info("getAllNews from MongoDB for stock_code=");
        return sb.toString();
    }
    /**
     * 查询News表，拿出最新的3条StockNews
     * @param stockCode
     * @return 返回结构：
     * ["news": [{
     * "news_title": "",
     * "news_time": "",
     * "news_link": "",
     * "news_abstract": ""
     * },{},{}]
     * ]
     */
    public static String getThreeLatestStockNews(String stockCode,MongoClient client) {
        log.info("start to get Three Latest News from MongoDB for stock_code=" + stockCode);
        int code = Integer.parseInt(stockCode);
        collection= MongoConn.getConn().getDatabase("ForeSee").getCollection(tableName);
        cursor = collection.find(eq("stock_code", code))
                .sort(Sorts.ascending("news_time")).limit(3)
                .iterator();
        sb = new StringBuilder(jsonHead);
        try {
            while (cursor.hasNext()) {
                Document originDoc = cursor.next(),extractDoc=new Document();
                for(String name:getNewsStructure()){
                    extractDoc.put(name,originDoc.get(name));
                }
                sb.append(extractDoc.toJson());
                sb.append(",");
            }
        } finally {
            cursor.close();
        }
        if (sb.length() > jsonHead.length()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]]");
        log.info("getNews from MongoDB for stock_code=" + stockCode);
        return sb.toString();

    }

}
