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
                ├── application.yml  -- 主配置文件，用于指定使用哪个配置文件
                ├── application-dev.yml -- 开发环境配置文件
                ├── application-prod.yml -- 生产环境配置文件
        ├── test  -- 测试文件
	├── pom.xml  -- Maven依赖文件
```
### 配置说明 

```yaml
eureka:
   instance:
     hostname: eurekaServer //eureka服务器端主机名
   client:
     register-with-eureka: false //是否向eureka服务注册中心注册自己，客户端需要注册
     fetch-registry: false  //是否是eureka服务器端，false表示是
     service-url:  
       defaultZone: http://localhost:8888/eureka/ //eureka注册中心的地址
```
