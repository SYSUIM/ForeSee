# UpdateLog

此文件系后端组工作日志。

## 2020.10

### 2020.10.07

- 原有项目已经经过部分升级，在其中加入了Mybatis部分

## TODO

1. 完成Spring Boot升级旧项目 [微博可视化平台](https://github.com/WIN0624/Weibo_RepostRelationship_Visualization_Platform) 。
   - 解决Test方法报空指针错误的问题
   - 加入分页功能
   - 修正json格式
2. 对升级后的项目做junit测试。
3. 考察Spring Cloud。

# SuoyinUpdateLog

此部分内容为索引组工作日志

## 2020.10

### 2020.10.07

- 对原有项目进行了升级，将Redis内容整合进Springboot框架中

## TODO

1. 将Redis相关内容记性了修改，将其中的方法整合进Springboot框架中
   - 将原有MINA_Maven中的MyRedis包进行改造，将其整合进Springboot框架中
   - 原有Jedis操作改为RedisTemplate操作
   - 将分页的方法进行改造
2. 整合Springboot实现Redis缓存
   - 完成单元测试纠正部分错误
