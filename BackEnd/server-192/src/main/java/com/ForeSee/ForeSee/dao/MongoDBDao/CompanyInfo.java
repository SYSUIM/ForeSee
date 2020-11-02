package com.ForeSee.ForeSee.dao.MongoDBDao;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mongodb.client.model.Filters.in;

@Slf4j
public class CompanyInfo {
    // 单例懒加载
    // 前端要求给一个表结构形式的公司信息，这里写入表结构需要的键值和对应的数据库字段
    private static class TableStructureHolder {
        static Map<String, String> tableStructure = new HashMap();

        static {
            tableStructure.put("公司名称", "entName");
            tableStructure.put("股票代码", "stock_code");
            tableStructure.put("登记机关", "authority");
            tableStructure.put("法定代表人", "legalPerson");
            tableStructure.put("成立日期", "startDate");
            tableStructure.put("注册资本", "regCapital");
            tableStructure.put("工商注册号", "licenseNumber");
        }
    }
    // 前端要求字段与数据库中字段名不一致，在这里修正
    // 日后如果要求的字段有变，直接在这里修改就可以了
    // 多个stock_code对应的公司信息的字段
    private static class MultiFieldReflectHolder {
        static Map<String, String> multiFieldReflect = new HashMap();
        static {
            multiFieldReflect.put("former_name", "entName");
            multiFieldReflect.put("stock_code", "stock_code");
            multiFieldReflect.put("registered_address", "regAddr");
            multiFieldReflect.put("Logo", "entLogo");
            multiFieldReflect.put("industry_code", "industry_code");

        }
    }
    // 单个stock_code对应的公司信息的字段
    private static class FieldReflectHolder {
        static Map<String, String> fieldReflect = new HashMap();
        static {
            fieldReflect.put("former_name", "entName");
            fieldReflect.put("stock_code", "stock_code");
            fieldReflect.put("registered_address", "regAddr");
            fieldReflect.put("Logo", "entLogo");
            fieldReflect.put("industry_code", "industry_code");

        }
    }
    private static Map<String, String> getTableStructure() {
        return TableStructureHolder.tableStructure;
    }
    private static Map<String, String> getFieldReflect() {
        return FieldReflectHolder.fieldReflect;
    }
    private static Map<String, String> getMultiFieldReflect() {
        return MultiFieldReflectHolder.multiFieldReflect;
    }
    private static final String table="BasicInfo";
    private static MongoCollection<Document> collection;
    private static StringBuilder sb;
    /**
     * 使用表BasicInfo，返回参数列表中的公司的部分基本信息
     * @param stockCodes
     * @return 返回字段见MultiFieldReflectHolder.multiFieldReflect
     */
    public static String getCompanyInfo(List<String> stockCodes, MongoClient client) {
        log.info("start to query companyInfo from MongoDB");
            collection = client.getDatabase("ForeSee").getCollection(table);
            sb = new StringBuilder("[");
            MongoCursor<Document> cursor = collection.find(in("stock_code", stockCodes)).iterator();
            Document originDoc = null, extractedDoc = new Document();
            while (cursor.hasNext()) {
                    originDoc = cursor.next();
                    Map<String, String> multiFileReflect = getMultiFieldReflect();
                    for (String key : multiFileReflect.keySet()) {
                        extractedDoc.put(key, originDoc.get(multiFileReflect.get(key)));
                    }
                    sb.append(extractedDoc.toJson());
                    log.info("getCompanyInfoJson from MongoDB for stock_code=" + originDoc.get("stock_code"));
                    sb.append(",");
            }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        log.info("has already queried companyInfo from MongoDB");
        return sb.toString();
    }

    /**
     * 使用表BasicInfo，返回单个公司的部分基本信息
     * @param stockCode
     * @return 返回字段见FieldReflectHolder.fieldReflect和TableStructureHolder.tableStructure
     */
    public static String getCompanyInfo(String stockCode,MongoClient client) {
        log.info("start to query companyInfo from MongoDB, stockCode=" + stockCode);
        collection = client.getDatabase("ForeSee").getCollection(table);
        sb= new StringBuilder("[\"companyInfo\":");
        Document originDoc = collection.find(in("stock_code", stockCode)).first();
        Document extractedDoc = new Document();
        if (!originDoc.isEmpty()) {
            Map<String, String> fileReflect = getFieldReflect();
            for (String key : fileReflect.keySet()) {
                extractedDoc.put(key, originDoc.get(fileReflect.get(key)));
            }
            sb.append(extractedDoc.toJson());
        }else{
            sb.append("{}");
        }
        sb.append(",\"tableData\": [");
        Map<String, String> tableStructure = getTableStructure();
        for (String name : tableStructure.keySet()) {
            sb.append("{\"name\":\"" + name + "\",\"value\":");
            if (!originDoc.isEmpty()) {
                sb.append("\"");
                sb.append(originDoc.get(tableStructure.get(name)));
                sb.append("\"");
            } else {
                sb.append("\"\"");
            }
            sb.append("},");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]]");
        log.info("has already queried companyInfo from MongoDB");
        return sb.toString();
    }
}
