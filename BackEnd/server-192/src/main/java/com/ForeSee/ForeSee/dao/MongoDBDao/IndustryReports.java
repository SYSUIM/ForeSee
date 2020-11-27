package com.ForeSee.ForeSee.dao.MongoDBDao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Sorts;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: ForeSee
 * @description: 返回行业分析报告，目前数据只有互联网的，所以全部返回就可以了
 * @create: 2020-11-27 12:15
 **/
@Slf4j
public class IndustryReports {
    private static MongoCollection<Document> collection;
    private static final String tableName="ArticleInfo";
    private static MongoCursor<Document> cursor;
    private static int pageSize=20;
    private static StringBuilder sb;
    private static class ReportsStructureHolder {
        static Map<String,String> reportsStructure =new HashMap();
        static{
            reportsStructure.put("title","title");
            reportsStructure.put("date","pub_date");
            reportsStructure.put("url","link");
            reportsStructure.put("research","analysis_year");
        }
    }
    private static Map<String,String> getReportsStructure(){return ReportsStructureHolder.reportsStructure;}

    public static String getIndustryReports(String industryId, MongoClient client, String page) {
        collection= client.getDatabase("ForeSee").getCollection(tableName);
        cursor = collection.find()
                .sort(Sorts.descending("pub_date"))
                .skip(pageSize*(Integer.parseInt(page)-1))
                .limit(pageSize).iterator();
        long totalPage=collection.count();
        String head="{\"industry\": \"互联网\",\"page\":"+page+","+"\"totalpage\":"+totalPage+",\"reports\":[";
        sb = new StringBuilder(head);
        try {
            while (cursor.hasNext()) {
                Document originDoc = cursor.next(), extractDoc = new Document();
                Map<String, String> info = getReportsStructure();
                for (String name : info.keySet()) {
                    String tmp = originDoc.get(info.get(name)).toString();
                    extractDoc.put(name, tmp);
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
        log.info("getIndustryReport from MongoDB for industryId="+industryId);
        log.info("注意，不管前端发送什么industryid都会返回一样的，因为现在只有互联网的数据");
        return sb.toString();
    }
}
