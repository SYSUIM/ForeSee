package com.ForeSee.ForeSee.dao.MongoDBDao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;


public class IndustryInfo {
    private static final String table="geo";
    public static String getIndustryInfo(String industryCode, MongoClient client){
        MongoCollection<Document> collection=client.getDatabase("ForeSee").getCollection(table);
        MongoCursor cursor=null;
        StringBuilder sb=new StringBuilder("{\"introduction\":{" +
                "\"brief\":\"目前后端好像还没有这个数据\"" +
                ",\"url\":\"目前后端好像还没有这个数据\"" +
                "},");
        try {
            cursor = collection.find(eq("industry_code", industryCode)).iterator();
            sb.append("\"geo\": [");
            int size=sb.length();
            while (cursor.hasNext()) {
                Document tmp= (Document) cursor.next();
                tmp.remove("industry_code");
                tmp.remove("_id");
                sb.append(tmp.toJson()+",");
            }
            if(sb.length()!=size){
                sb.deleteCharAt(sb.length()-1);
            }
        }finally {
            cursor.close();
        }
        sb.append("]}");
        return sb.toString();
    }
}
