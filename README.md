# ForeSee
> written by panzy.

<br>

[ForeSee](http://180.76.249.27/weibo/foresee/vue_project_08/index.html#/)是一套基于Vue框架，利用Spring Cloud集成MongoDB、MySQL，结合Redis快速索引的商业情报可视化系统。目前提供沪深两市上市企业公开信息的可视化服务。

<br>

<p align="center">
  <img src="https://img.shields.io/badge/release-1.0-red"/>
  <img src = "https://img.shields.io/badge/language-python-blue.svg">
<img src = "https://img.shields.io/badge/language-Java-green.svg">
</p>

<br>

## OUTLINE
1. [Front Group](#front)
2. [Back Group](#back)
3. [Model Group](#model)

<br>

## <span id = "front">1. Front Group</span>

> Group Members: Feng Yanxia, Chen Jinying, Li Yi, Gong Zhilin, Peng Jiahui.

前端组编写了相关可视化网页，[ForeSee](http://180.76.249.27/weibo/foresee/vue_project_08/index.html#/)提供了企业搜索、行业搜索和行业报告的检索入口，并针对上市企业公开信息进行可视化展示；对行业内企业信息进行可视化数据分析。

具体技术细节参考前端小组[README](FrontEnd)。

<br>

## <span id = "back">2. Back Group</span>

> Group Members: Li Jiayi, Han Yuxuan, Kuang Qianyin, Jia Chang, Du Chongwen, Xiao Jingbo, Li Ziqian, Lin Jie, Zeng Linrong.

后端组分别完成了分布式数据库、索引库的开发。基于SpringCloud框架，数据库集成了MongoDB、MySQL，开发了分布式的存书数据库。基于Redis，索引端实现了检索词与数据库之间的快速联系。

具体技术细节参考后端小组[README](BackEnd)

<br>

## <span id = "model">3. Model Group</span>

> Group Members: Zeng Ying, Zhong Shanshan, Pan Ziyang, Chen Lehua, Huang Zhishan, Yu Yixia.

模型组的工作主要有数据采集、竞争关系抽取和智能检索。通过合法地采集上市公司的公开数据，项目获得了上市公司的基本信息、相关公开数据等结构化数据，相关新闻、公告信息等非结构化数据以及通过第三方实时获取的地理位置坐标。通过正则表达式匹配和Transformer模型对非结构化文本进行了竞争关系抽取；使用Bert和TransformerXL对检索词和搜索结果文本进行Embedding，实现初步的语义检索。

具体技术细节参考模型组[README](Model)

<br>

## Contribution
Members of the 2018 Class **Research Team** from School of Information Management of SYSU，lead by Prof. Li, contributed to ForeSee.

Welcome to pull REQUESTS or ISSUES to us.