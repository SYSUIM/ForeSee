<template>
  <div>
    <el-table :data="newslist" style="width: 100%">
      <el-table-column prop="date" label="日期" width="180"> </el-table-column>
      <!-- <el-table-column prop="url" label="链接" width="180"> </el-table-column> -->
      <el-table-column prop="title" label="标题">
        <template slot-scope="newslist">
          <a :href="newslist.row.url" target="_blank" class="TestCSS"
            >{{ newslist.row.title }}
          </a>
        </template>
      </el-table-column>
    </el-table>
    <PaginationForNews :pagecount="5"></PaginationForNews>

    <!-- <el-pagination layout="prev, pager, next" :total="50"> </el-pagination> -->
  </div>
</template>
<script>
import PaginationForNews from "@/components/PaginationForNews";

export default {
  components:{
    PaginationForNews
  },
  data() {
    return {
      newslist: [],
      stockCode: decodeURI(this.$route.query.stockCode)
    };
  },
  methods: {
    async loadMoreNews(stockCode, page) {
      this.page = page;
      console.log(page);

      //处理url的显示问题
      if(page!=1)
      {
        this.$router.replace({
        path: this.$route.path,
        query: { ...this.$route.query, page },
      });
      }
      

      // let { data } = await this.$get("/data/morenews_expect.json");
      let { data } = await this.$get(
        "http://121.46.19.26:8288/ForeSee/allNews/" +
          this.stockCode +
          "/" +
          page
      );
      this.newslist = data.news;
    },
  },
  created() {
    this.loadMoreNews(this.stockCode,1);
    // this.show();

  },
};
</script>
<style>
</style>