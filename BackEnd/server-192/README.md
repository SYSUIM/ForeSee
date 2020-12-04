# server-192说明

目录结构

```
├─java
│  └─com
│      └─ForeSee
│          └─ForeSee
│              ├─config          --MongoDB配置
│              ├─controller      --接收请求并发送给请求数据访问
│              ├─dao             --数据访问层
│              │  └─MongoDBDao
│              ├─service         --所有需求
│              └─util            --工具类，如MongoDB连接
└─resources
    ├─MongoDBDesign  -- MongoDB字段说明、导入语句
    │  ├─load
    │  └─structure
    └─TestData       -- 一些测试数据
```