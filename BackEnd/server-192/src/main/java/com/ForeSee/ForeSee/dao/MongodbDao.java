package com.ForeSee.ForeSee.dao;

import com.ForeSee.ForeSee.util.MongoConn;
import com.mongodb.client.*;


import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * mongodb的数据访问
 *
 * Memo from Legion: 把getAllInfo的方法拆了，感觉拼在一起是逻辑层service做的，拆开也方便以后调用
 */
@Slf4j
@Component
public class MongodbDao{
    public MongoCursor<Document> cursor;
    public StringBuilder sb;
    public MongoDatabase database;
    public MongoCollection<Document> collection;
    public Document document;
    public List<Document> documents;
    @Autowired
    MongoConn mongoConn;

    /**
     * 查询CompanyInfo表
     * @param stockCode
     * @return
     */
    public  String getCompanyInfo(String stockCode){
        database= mongoConn.getConn();
        collection=database.getCollection("companyInfo");
        sb=new StringBuilder("[");
        cursor=collection.find(eq("stock_code", stockCode)).iterator();
        try{
            while(cursor.hasNext()){
                sb.append(cursor.next().toJson());
                sb.append(",");
            }
        }finally {
            cursor.close();
        }
        if(sb.length()>1){
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        log.info("getCompanyInfoJson from MongoDB for stock_code="+stockCode+" : "+sb);
        return sb.toString();
    }

    /**
     * 查询StockNews表
     * @param stockCode
     * @return
     */
    public String getStockNews(String stockCode){
        database= mongoConn.getConn();
        collection=database.getCollection("stockNews");
        document=collection.find(eq("allInfo.stock_code",stockCode)).first();
        sb=new StringBuilder("[");
        if(document!=null) {
            try {
                documents = (List<Document>) document.get("allInfo");
            }catch (ClassCastException e){
                log.warn("When stockNews from MongoDB for stock_code="+stockCode+", ClassCastError occurs," +
                        "Please check the data stored in MongoDB");
            }
            for (Document doc : documents) {
                if (doc.get("stock_code").equals(stockCode)) {
                    try {
                        documents = (List<Document>) doc.get("news");
                    }catch (ClassCastException e){
                        log.warn("When stockNews from MongoDB for stock_code="+stockCode+", ClassCastError occurs," +
                                "Please check the data stored in MongoDB");
                    }
                    for (Document doc2 : documents) {
                        sb.append(doc2.toJson());
                        sb.append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    break;
                }
            }
        }
        sb.append("]");
        log.info("getStockNewsJson from MongoDB for stock_code="+stockCode+" : "+sb);
        return sb.toString();
    }

    /**
     * 查询StockNotice表
     * @param stockCode
     * @return
     */
    public String getStockNotice(String stockCode){
        database= mongoConn.getConn();
        collection=database.getCollection("stockNotice");
        document=collection.find(eq("stock_code",stockCode)).first();
        sb=new StringBuilder("[");
        if(document!=null) {
            try {
                documents = (List<Document>) document.get("notice_info");
            }catch (ClassCastException e){
                log.warn("When stockNotice from MongoDB for stock_code="+stockCode+", ClassCastError occurs," +
                        "Please check the data stored in MongoDB");
            }
            for (Document doc : documents) {
                sb.append(doc.toJson());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("]");
        log.info("getStockNoticeJson from MongoDB for stock_code="+stockCode+" : "+sb);
        return sb.toString();
    }

//    public  String getAllInfo(String stockCode){
//        database= MongoConn.getConn();
//        sb=new StringBuilder("{");
//        collection=database.getCollection("CompanyInfo");
//        document= collection.find(eq("stock_code", stockCode)).first();
//        sb.append("\"companyInfo\":");
//        if(document!=null) {
//            string=document.toJson();
//        }else{
//            string="{}";
//        }
//        sb.append(string);
//        sb.append(",");
//        collection=database.getCollection("stockNews");
//        document=  collection.find(eq("allInfo.stock_code",stockCode)).first();
//        sb.append("news:[");
//        if(document!=null) {
//            try {
//                documents = (List<Document>) document.get("allInfo");
//            }catch (ClassCastException e){
//                log.warn("When stockNews from MongoDB for stock_code="+stockCode+", ClassCastError occurs," +
//                        "Please check the data stored in MongoDB");
//            }
//            for (Document doc : documents) {
//                if (doc.get("stock_code").equals(stockCode)) {
//                    try {
//                        documents = (List<Document>) doc.get("news");
//                    }catch (ClassCastException e){
//                        log.warn("When stockNews from MongoDB for stock_code="+stockCode+", ClassCastError occurs," +
//                                "Please check the data stored in MongoDB");
//                    }
//                    for (Document doc2 : documents) {
//                        sb.append(doc2.toJson());
//                        sb.append(",");
//                    }
//                    sb.deleteCharAt(sb.length() - 1);
//                    break;
//                }
//            }
//        }
//        sb.append("],");
//        collection=database.getCollection("stockNotice");
//        sb.append("\"notice_info\":[");
//        document=collection.find(eq("stock_code",stockCode)).first();
//        if(document!=null) {
//            try {
//                documents = (List<Document>) document.get("notice_info");
//            }catch (ClassCastException e){
//                log.warn("When stockNotice from MongoDB for stock_code="+stockCode+", ClassCastError occurs," +
//                        "Please check the data stored in MongoDB");
//            }
//            for (Document doc : documents) {
//                sb.append(doc.toJson());
//                sb.append(",");
//            }
//            sb.deleteCharAt(sb.length()-1);
//        }
//        sb.append("]}");
//        log.debug("getAllInfo from MongoDB: "+sb);
//        return sb.toString();
//    }
}