package com.ForeSee.ForeSee.dao.MongoDBDao;

import com.ForeSee.ForeSee.util.MongoConn;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Sorts;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;


@Slf4j
@Component
public class StockNotice {
    private static class NoticeStructureHolder {
        static List<String> noticeStructure =new ArrayList();
        static{
            noticeStructure.add("notice_title");
            noticeStructure.add("notice_time");
            noticeStructure.add("notice_link");
        }
    }
    private static List<String> getNoticeStructure(){
        return NoticeStructureHolder.noticeStructure;
    }
    private static final String jsonHead="[\"notice_info\":[";
    private static final String table="Notice";

    private static MongoCursor<Document> cursor;
    private static StringBuilder sb;
    private static MongoCollection<Document> collection;

    /**
     * 查询Notice表，返回最新的3条StockNotice
     * @param stockCode
     * @return 返回字段见NoticeStructureHolder.noticeStructure
     */
    public static String getThreeLatestStockNotice(String stockCode, MongoClient client) {
        log.info("start to get Three Latest Notice from MongoDB for stock_code=" + stockCode);
        collection= MongoConn.getConn().getDatabase("ForeSee").getCollection(table);
        cursor = collection.find(eq("stock_code", stockCode))
                .sort(Sorts.ascending("notice_time")).limit(3).iterator();
        sb = new StringBuilder(jsonHead);
        try {

            while (cursor.hasNext()) {
                Document originDoc = cursor.next(),extractDoc=new Document();
                for(String name:getNoticeStructure()){
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


    /**
     * 查询Notice表，返回所有StockNotice
     * @param stockCode
     * @return 返回字段见NoticeStructureHolder.noticeStructure
     */
    public static String getAllStockNotice(String stockCode,MongoClient client) {
        collection= MongoConn.getConn().getDatabase("ForeSee").getCollection(table);
        cursor = collection.find(eq("stock_code", stockCode)).iterator();
        sb = new StringBuilder(jsonHead);
        try {
            while (cursor.hasNext()) {
                Document originDoc = cursor.next(),extractDoc=new Document();
                for(String name:getNoticeStructure()){
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
        log.info("getAllNotice from MongoDB for stock_code=");
        return sb.toString();
    }
}