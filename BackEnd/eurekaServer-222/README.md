# ForeSee服务注册中心

## 模块介绍

本模块充当服务注册中心，将Foresee的数据访问模块和路由网关模块注册到本模块，使得路由网关模块可以发现数据访问模块并将触发端的请求转发给数据访问模块。

### 模块结构

```lua
├── eurekaServer-222
    ├── src
        ├── main
            ├── java  -- java源文件
                ├── com.ForeSee.ForeSee
                    ├── eurekaServerMain.java  -- 启动类
            ├── resource  -- 其他文件
                ├── application.yml  -- 配置文件，用于指定服务注册中心的地址
        ├── test  -- 测试文件
	├── pom.xml  -- Maven依赖文件
```

### 接口文档