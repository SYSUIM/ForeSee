package com.example.rwredis;

import redis.clients.jedis.Jedis;
/*
该类获取jedis连接之后，将每一个Data实例作为一条数据，以有序集合的方式存入Redis数据库中。其中，以检索词query作为集合名称，以序号作为排序依据，以博文ID作为集合中的元素内容
 */
public class Write {
    private static Jedis jedis;

    public static void main(String[] args) throws Exception {
        //获取jedis连接
        jedis = RedisPoolUtil.getJedis();

        //设置密码
//        jedis.auth("nopassword");
//        jedis.auth("");
        System.out.println(jedis.ping());
        //从csv文件中读取每条数据相应字段的内容作为Data类实例存储在数组中
        Data[] d=Read.readDB();
        //以每条数据的检索词query作为集合名称，以序号作为排序依据，以博文ID作为集合中的成员
        for(int i=0; i<d.length&&d[i]!=null; i++)
        {
            if(d[i].getStock_code()!=null) {
                jedis.select(1);
                jedis.sadd("stockCode",d[i].getStock_code());
            }
            if(d[i].getCompany_name()!=null) {
                jedis.select(2);
                jedis.set(d[i].getCompany_name(), d[i].getStock_code());
            }
            if(d[i].getShort_name()!=null) {
                jedis.select(3);
                jedis.set(d[i].getShort_name(), d[i].getStock_code());
            }
            if(d[i].getIndustry_name()!=null) {
                jedis.select(4);
                jedis.sadd(d[i].getIndustry_name(),d[i].getStock_code());
            }
            if(d[i].getIndustry_code()!=null){
                jedis.select(5);
                jedis.sadd(d[i].getIndustry_code(),d[i].getStock_code());
            }
//            jedis.zadd(d[i].getQuery(),d[i].getRepost_count(),d[i].getWeibo_id());
        }
        jedis.close();
        System.exit(0);
    }
}
