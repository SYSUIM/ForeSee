# ForeSee数据访问模块

## 模块介绍

主要用于接收ForeSee触发模块发过来的请求，并根据请求进行数据访问，最后返回数据结果。

### 模块结构

```lua
├── server-192
	├── src
		├── main
			├── java  -- java源文件
				├── com.ForeSee.ForeSee
					├── controller  -- 接收触发模块发过来的请求
					├── config  -- 配置
					├── dao  -- 数据访问
					├── service  -- 业务逻辑
					├── ServerMain.java  -- 启动类
			├── resource  -- 其他文件
				├── application.yml  -- 主配置文件，用于指定使用哪个配置文件
				├── application-dev.yml  -- 开发环境配置文件
				├── application-prod.yml  -- 生产环境配置文件
		├── test  -- 测试文件
	├── pom.xml  -- Maven依赖文件
```

### 接口文档