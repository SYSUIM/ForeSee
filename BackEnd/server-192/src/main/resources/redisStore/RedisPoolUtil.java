package com.example.rwredis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolUtil {
    private static JedisPool pool;
    static{
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxTotal(5);     //设置通过pool能够获取到的最大的连接的jedis个数
        jpc.setMaxIdle(1);      //设置jedis链接的最大闲置数量

        int port = 6379;    //设置端口
//        int port = 6479;
//        String host = "192.168.1.103";      //设置主机
        String host = "127.0.0.1";
        
        pool = new JedisPool(jpc, host, port);      //创建Jedis连接池
    }
    public static Jedis getJedis(){
        return pool.getResource();
    }
    public static void release(Jedis jedis){
        if(jedis != null)
            jedis.close();
    }
}
