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
        StringBuilder sb=new StringBuilder("\"geo\":[");
        MongoCursor<Document> cursor = collection.find(in("stock_code", stockCode)).iterator();
        if(!cursor.hasNext()) sb.append("{}");
        while(cursor.hasNext()){
            Document document=cursor.next();
            document.remove("_id");
            document.remove("industry_code");
            sb.append(document.toJson());
        }
        sb.append("]");
        return sb.toString();
    }
}
