# MongoDBDesign

## 表结构

```
ForeSee
    ArticleInfo -- 分析的文章相关内容
    BasicInfo -- 公司基本信息
    News -- 股票新闻
    Notice -- 股票公告
    Profit -- 利润图表数据
    geo -- 地理信息
```

表结构示例如structure所示，表索引如structure下的index.json所示。

其中windowsLoad.txt中存有在Windows上将示例表存入MongoDB的命令行语句，以便调试。

load文件夹下为在192服务器导入表的脚本文件，**现有问题是News和Notice没有唯一索引，无法保证去重**。

## 数据压缩

更新了192服务器上的MongoDB，从2.6更新至3.4，3.2后默认使用存储引擎WiredTiger，默认进行数据压缩。

## 分片与复制集

若服务器数量足够（4台），可以使用如下结构进行分片：

```
服务器a:
shard-a 27017
ConfigServer 27019
```

```
服务器b:
shard-a 27017
shard-b arbiter 300000
ConfigServer 27019
```

```
服务器c:
shard-b 27017
ConfigServer 27019
```

```
服务器d:
shard-b 27017
shard-a arbiter 300000
```

