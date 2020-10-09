# UpdateLog

此文件系索引组与后端组工作日志。

## BackEnd

### 2020.10

#### 2020.10.07

- 原有项目已经经过部分升级，在其中加入了Mybatis部分

### 2020.10.08

- 修正了返回json格式错误
- 完成了分页功能加入
- 在服务器上联通成功
- 完成了192服务器部分的单元测试逻辑书写

### 2020.10.09

- 尝试121压力测试逻辑
- 尝试192MySQL压力测试逻辑
- 完成了121服务器的单元测试逻辑书写
- 对Spring Cloud的考察初步完成

### TODO

1. 完成Junit单元测试的测试用例与断言书写
2. 明确压力测试的意义
3. 确定Spring Cloud的实现与否
4. 考察分布式数据库

## SuoyinUpdateLog

此部分内容为索引组工作日志

### 2020.10

#### 2020.10.07

- 对原有项目进行了升级，将Redis内容整合进Springboot框架中

### TODO

1. 将Redis相关内容记性了修改，将其中的方法整合进Springboot框架中
   - 将原有MINA_Maven中的MyRedis包进行改造，将其整合进Springboot框架中
   - 原有Jedis操作改为RedisTemplate操作
   - 将分页的方法进行改造
2. 整合Springboot实现Redis缓存
   - 完成单元测试纠正部分错误
