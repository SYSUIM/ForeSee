# ForeSee触发模块

## 模块介绍

本模块主要用于接收来自前端的请求，将请求转发至ForeSee数据访问模块，收到检索结果后把结果返回给前端。

### 模块结构

```lua
├── client-121
    ├── src
        ├── main
            ├── java  -- java源文件
                ├── com.ForeSee.ForeSee
                    ├── controller  -- controller层代码，接收前端的请求并发送请求给数据访问模块
                    ├── ClientMain.java  -- 启动类
            ├── resource  -- 其他文件
                ├── application.yml  -- 主配置文件，用于指定使用哪个配置文件
                ├── application-dev.yml  -- 开发环境配置文件
                ├── application-prod.yml  -- 生产环境配置文件
        ├── test  -- 测试文件
	├── pom.xml  -- Maven依赖文件
```

### 接口文档