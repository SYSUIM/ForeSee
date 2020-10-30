<template>
  <el-tabs type="border-card" class="tab-card" v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="新闻" name="first">
        <div class="comments-box">

            <div class="media comment" v-for="item in news_info" :key="item.news_title">
                <div class="media-body">
                    <h5 class="media-heading mt-0 mb-1">{{item.news_title}}<small class="date">{{item.news_time}}</small>
                    </h5>
                    新闻摘要.
                    <a :href="item.news_link">→网页连接</a>
                </div>
            </div>
            <router-link :to="'/morenews'+'?stockCode='+stockCode"> 
								<div class="seeMore">查看更多</div>
						</router-link>

        </div>
    </el-tab-pane>
    <el-tab-pane label="公告" name="second">
        <div class="comments-box">

            <div class="media comment" v-for="item in notice_info" :key="item.notice_title">
                <div class="media-body">
                    <h5 class="media-heading mt-0 mb-1" style="font-weight: 600;">{{item.notice_title}}<small class="date">{{item.notice_time}}</small>
                    </h5><span style="font-size: 14px;">
                    阿里巴巴集团控股有限公司是一家电子商务企业,旗下拥有淘宝,天猫,聚划算,1688等多个品牌。集团经营多元化的互联网…</span>
                    <!-- <a :href="item.notice_link">→网页连接</a> -->
                    <el-link class="el-link" icon="el-icon-link" :underline="false" :href="item.notice_link">网页链接</el-link>
                </div>
            </div>
            <router-link :to="'/morenotice'+'?stockCode='+stockCode"> 
								<div class="seeMore">查看更多</div>
						</router-link>

        </div>
    </el-tab-pane>
    <el-tab-pane label="行业报告" name="third">角色管理</el-tab-pane>
  </el-tabs>
</template>
<script>
export default {
  name: 'News',
  props: ['news_info','notice_info'],
  data () {
    return {
      activeName: 'first',
      stockCode:decodeURI(this.$route.query.stockCode),
    }
  },
  methods: {
    handleClick (tab, event) {
      console.log(tab, event)
    }
  }
}
</script>

<style>
.el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active {
    color: #FFD808;
}
.tab-card {
    margin-top: 30px;
    height: 500px;
}

.comments-box .media-heading {
    color: #000000;
    font-family: "Open Sans", sans-serif;
    font-size: 18px;
    margin-bottom: 30px;
}

.mb-1, .my-1 {
    margin-bottom: 0.25rem !important;
}

.mt-0, .my-0 {
    margin-top: 0 !important;
}

h5 {
    font-size: 1.8em;
    line-height: 22px;
}

</style>
<style scoped>
/* 查看更多 */
.seeMore {
  text-align: right;
}
</style>
