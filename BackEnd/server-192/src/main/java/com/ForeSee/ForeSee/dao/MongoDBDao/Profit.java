package com.ForeSee.ForeSee.dao.MongoDBDao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class Profit {
    private static final String table="Profit";

    public static String getProfit(String stockCode, MongoClient client){
        MongoCollection<Document> coll = client.getDatabase("ForeSee").getCollection(table);
        Document doc=coll.find(eq("stock_code",stockCode)).first();
        String result="";
        if(doc!=null&&!doc.isEmpty()){
            doc.remove("_id");
            return doc.toJson();
        }
        else return "{}";
    }
}
