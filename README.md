# ForeSee

# 前端

## 一、技术栈

- [Vue.js](https://cn.vuejs.org)
- [vue-cli-3](https://cli.vuejs.org/zh/)
- [vue-router](https://router.vuejs.org/zh/)
- [webpack](https://www.webpackjs.com/)
- [aixos](https://github.com/axios/axios)
- [Element-UI](http://element-cn.eleme.io/#/zh-CN)
- [echarts](https://echarts.apache.org/zh/index.html)



## 二、项目结构

以下为 /src 目录下文件结构

```
│  App.vue                                       //主组件
│  main.js
│  
├─assets                                         //静态资源
│  │  logo.png                                   //浏览器标签图表
│  │  
│  ├─images
│  │      banner-bg.png
│  │      cta-bg.png
│  │      index-wordcloud.png
│  │      logo-black.png
│  │      logo-white.png
│  │      
│  └─js
│          LineChart.js                          //企业营收折线图
│          
├─components                                     //组件
│      Banner.vue                                //横幅
│      Card.vue                                  //企业详情表格
│      Content.vue                               //企业网格
│      CTA.vue                                   //联系我们（广告标语）
│      Footer.vue                                //尾部
│      Geo.vue                                   //行业地图
│      GeoSingle.vue                             //企业地图
│      Header.vue                                //头部
│      Industrial.vue                            //行业检索结果
│      LineChart.vue                             //企业营收折线图
│      News.vue                                  //新闻公告
│      Search.vue                                //搜索框
│      SearchBox1.vue                            //搜索框-企业检索
│      SearchBox2.vue                            //搜索框-行业检索
│      Tabs.vue                                  //标签-行业检索页
│      Tabs2.vue                                 //备用
│      
├─mixins
│      index.js
│      
├─router                                         //路由配置
│      index.js
│      
└─views                                          //主要页面
        Detail.vue                               //企业详情页
        Index.vue                                //首页
        Industry.vue                             //行业检索页
        MoreNews.vue                             //新闻详情页
        Retrieval.vue                            //企业检索页
```



## 三、后端接口

| 序号 | URL 示例                                             | 参数                                         | 返回值             | 调用的网页或组件                 |
| ---- | ---------------------------------------------------- | -------------------------------------------- | ------------------ | -------------------------------- |
| 1    | http://121.46.19.26:8288/ForeSee/companyInfo/600485  | 股票代码；企业名称；<br />行业代码；行业名称 | 企业列表           | Retrieval.vue;<br />Industry.vue |
| 2    | http://121.46.19.26:8288/ForeSee/allInfo/300433      | 股票代码；企业名称                           | 某个企业的全部信息 | Detail.vue                       |
| 3    | http://121.46.19.26:8288/ForeSee/industryInfo/BK0427 | 行业代码                                     | 企业地理信息       | Geo.vue                          |
| 4    | http://121.46.19.26:8288/ForeSee/allNews/300433/2    | 股票代码；页数                               | 企业新闻           | MoreNews.vue                     |
| 5    | http://121.46.19.26:8288/ForeSee/allNotice/600496/2  | 股票代码；页数                               | 企业公告           | MoreNotice.vue                   |

