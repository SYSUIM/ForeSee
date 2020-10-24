# ForeSee工具模块

## 模块介绍

本模块是工具模块，用于放各模块可能会使用的通用类，如工具类、javaBean等。

用处：当修改通用类时不需要逐个模块去修改。

### 模块结构

```lua
├── client-121
    ├── src
        ├── main
            ├── java  -- java源文件
                ├── com.ForeSee.ForeSee
                    ├── entities  -- 实体类
            ├── resource  -- 其他文件
        ├── test  -- 测试文件
```

### 重要说明

每次修改完工具模块之后都需要 mvn clean 然后 mvn install 把该模块放入maven中，这样其他模块才能进行调用。