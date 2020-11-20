<template>
  <div>
    <div class="widget-title">
            新闻动态 <span>News</span>
    </div>  
  <div class="widget widget-text" style="overflow: auto"> 
      <div class="latest-post-item" v-for="item in newslist" :key="item.title">
        <div class="meta-date"><span>{{item.day}}</span>{{item.month}}</div>
        <div class="title" :href="item.url">
            <el-link :underline="false" :href="item.url">{{item.title}}</el-link>
        </div>
        <!--p class="meta-author">{{item.news_abstract}}</p-->
        </div>
  </div>
  <router-link :to="'/morenews'+'?stockCode='+stockCode+'&page='+page"> 
		<div class="seeMore" style="position: absolute; right: 0px">查看更多</div>
  </router-link>
  </div>
</template>
<script>
export default {
  data() {
    return {
      newslist: [],
      page:1,
      stockCode: decodeURI(this.$route.query.stockCode)
    };
  },
  created() {
      //console.log(this.stockCode);
      this.getData();
  },
  methods: {
    async getData () {
      // let { data } = await this.$get("/data/morenews_expect.json");
      let { data } = await this.$get(
        "http://121.46.19.26:8288/ForeSee/allNews/" + this.stockCode + "/" + 1
      );
      this.newslist = data.news.map(item => {
                return {
                    //page: item.page,
                    title: item.title,
                    url: item.url,
                    // news_abstract: item.news_abstract.slice(0,90) + "...",
                    date: item.date,
                    day: item.date.slice(8,10),
                    month: this.getMonth(item.date.slice(5,7))
                }
            });
    },
    getMonth(str) {
      if (str == '12')
          return "Dec";
      else if (str == '11')
          return "Nov";
      else if (str == '10')
          return "Oct";
      else if (str == '09')
          return "Sep";
      else if (str == '08')
          return "Aug";
      else if (str == '07')
          return "Jul";
      else if (str == '06')
          return "Jun";
      else if (str == '05')
          return "May";
      else if (str == '04')
          return "Apr";
      else if (str == '03')
          return "Mar";
      else if (str == '02')
          return "Feb";
      else if (str == '01')
          return "Jan";
      else return str;
    }
  },
};
</script>

<style scoped>
/* .el-tabs--border-card>.el-tabs__header .el-tabs__item.is-active {
    color: #FFD808;
} */
.widget-text{
  height: 300px;  
}
</style>

<style src="../../public/css/vendor/bootstrap.min.css"></style>
<style src="../../public/css/vendor/owl.carousel.min.css"></style>
<style src="../../public/css/vendor/owl.theme.default.min.css"></style>
<style src="../../public/css/vendor/magnific-popup.css"></style>
<style src="../../public/css/vendor/animate.min.css"></style>
<style src="../../public/css/fontawesome.css"></style>
<style src="../../public/css/brands.css"></style>
<style src="../../public/css/solid.css"></style>
<style src="../../public/css/style.css"></style>
<style>