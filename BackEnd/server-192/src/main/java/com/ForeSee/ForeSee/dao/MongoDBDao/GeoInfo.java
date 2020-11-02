package com.ForeSee.ForeSee.dao.MongoDBDao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import static com.mongodb.client.model.Filters.in;

/**
 * @Author Legion
 * @Create 2020/11/2 12:19
 */
public class GeoInfo {
    private static final String table="geo";
    public static String getCompanyGeoInfo(String stockCode, MongoClient client){
        MongoCollection<Document> collection=client.getDatabase("ForeSee").getCollection(table);
        StringBuilder sb=new StringBuilder("\"geo\":");
        Document document = collection.find(in("stock_code", stockCode)).first();
        document.remove("_id");
        if (!document.isEmpty()){
            sb.append(document.toJson());
        }else{
            sb.append("{}");
        }
        return sb.toString();
    }
}
