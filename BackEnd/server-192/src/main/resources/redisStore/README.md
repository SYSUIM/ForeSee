## Redis数据库存储
redisStore是关于redis的数据库存储程序，从前端交接的数据中筛选出用作检索词的数据字段，以key-value的形式存储。数据库的作用是将各种检索词返回单一字段公司股票代码stockcode，方便后端统一查询并返回所有所需数据。
```
  Data.java -- 存储数据记录的实体类
  Read.java -- 从模型组提供的csv文件中读取数据
  RedisPoolUtil -- redis连接池配置文件
  Write.java -- 将数据存储进redis数据库中
```
