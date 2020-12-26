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
                ├── application.yml  -- 主配置文件，用于指定哪个配置文件
                ├── application-dev.yml -- 开发环境配置文件
                ├── application-prod.yml -- 生产环境配置文件
        ├── test  -- 测试文件
	├── pom.xml  -- Maven依赖文件
```
### 配置说明

```yaml
spring:
  cloud:
     gateway:
       discovery:
         locator:
           enabled: true                   //开启从eureka服务中心动态创建路由的功能
       routes:                             //定义路由转发规则
         - id: springcloud-foresee1        //路由id，配合微服务名设置
           uri: lb://springcloud-foresee   //匹配后提供服务的路由地址
           predicates:                     //断言：匹配成功才进行路由转发
             - Path=/companyInfo/**        //需要匹配的请求路径
             - Method=GET                  //需要匹配的请求方法
```