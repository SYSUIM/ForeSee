package com.ForeSee.ForeSee.dao.MongoDBDao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Sorts;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.mongodb.client.model.Filters.eq;


@Slf4j
@Component
public class StockNotice {
    private static final int pageSize=20;
    private static class NoticeStructureHolder {
        static Map<String,String> noticeStructure =new HashMap();
        static{
            noticeStructure.put("notice_title","notice_title");
            noticeStructure.put("notice_time","notice_time");
            noticeStructure.put("notice_link","link");
        }
    }
    private static class MultiNoticeStructureHolder {
        static Map<String,String> multiNoticeStructure =new HashMap();
        static{
            multiNoticeStructure.put("title","notice_title");
            multiNoticeStructure.put("date","notice_time");
            multiNoticeStructure.put("url","link");
        }
    }
    private static Map<String,String> getMultiNoticeStructure(){return MultiNoticeStructureHolder.multiNoticeStructure;}
    private static Map<String,String> getNoticeStructure(){
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
        collection= client.getDatabase("ForeSee").getCollection(table);
        cursor = collection.find(eq("stock_code", stockCode))
                .sort(Sorts.descending("notice_time")).limit(3).iterator();
        sb = new StringBuilder(jsonHead);
        try {
            Map<String,String> info=getNoticeStructure();
            while (cursor.hasNext()) {
                Document originDoc = cursor.next(),extractDoc=new Document();
                for(String name:info.keySet()){
                    extractDoc.put(name,originDoc.get(info.get(name)));
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
        log.info("getNotice from MongoDB for stock_code=" + stockCode);
        return sb.toString();

    }


    /**
     * 查询Notice表，返回所有StockNotice
     * @param stockCode
     * @return 返回字段见NoticeStructureHolder.noticeStructure
     */
    public static String getAllStockNotice(String stockCode,MongoClient client,String page) {
        collection=client.getDatabase("ForeSee").getCollection(table);
        cursor = collection.find(eq("stock_code", stockCode))
                .sort(Sorts.descending("notice_time"))
                .skip(pageSize*(Integer.parseInt(page)-1))
                .limit(pageSize).iterator();
        String head="{\"page\":"+page+",\"notice\":[";
        sb = new StringBuilder(head);
        try {
            Map<String,String> info=getMultiNoticeStructure();
            while (cursor.hasNext()) {
                Document originDoc = cursor.next(),extractDoc=new Document();
                for(String name:info.keySet()){
                    extractDoc.put(name,originDoc.get(info.get(name)));
                }
                sb.append(extractDoc.toJson());
                sb.append(",");
            }
        } finally {
            cursor.close();
        }
        if (sb.length() > head.length()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]}");
        log.info("getAllNotice from MongoDB for stock_code=");
        return sb.toString();
    }
}