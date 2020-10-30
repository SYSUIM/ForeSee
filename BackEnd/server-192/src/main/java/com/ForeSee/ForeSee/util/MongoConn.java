package com.ForeSee.ForeSee.util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class MongoConn {
    /**
     * @return Mongodb的连接
     */
    public MongoDatabase getConn(){
        MongoDatabase mongoDatabase = null;
        MongoClient mongoClient = null;
        try{
            mongoClient = new MongoClient("localhost",27017);
            mongoDatabase = mongoClient.getDatabase("foreSeeTest");
        }catch (Exception e){
            log.error(e.getClass().getName()+": "+e.getMessage());
        }
        return mongoDatabase;

    }

}
