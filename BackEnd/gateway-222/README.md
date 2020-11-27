# ForeSee路由网关模块

## 模块介绍

本模块主要用于发现注册在Eureka的数据访问模块，将触发端的请求转发给ForeSee的数据访问模块，同时将响应结果返回给触发端。

### 模块结构

```lua
├── gateway-222
    ├── src
        ├── main
            ├── java  -- java源文件
                ├── com.ForeSee.ForeSee
                    ├── GatewayMain.java  -- 启动类
            ├── resource  -- 其他文件
                ├── application.yml  -- 配置文件，用于指定路由转发的路线
        ├── test  -- 测试文件
	├── pom.xml  -- Maven依赖文件
```

### 接口文档