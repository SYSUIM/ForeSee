<template>
  <div>
    <el-table :data="noticelist" style="width: 100%">
      <el-table-column prop="date" label="日期" width="180"> </el-table-column>
      <!-- <el-table-column prop="url" label="链接" width="180"> </el-table-column> -->
      <el-table-column prop="title" label="标题">
        <template slot-scope="noticelist">
          <a :href="noticelist.row.url" target="_blank" class="TestCSS"
            >{{ noticelist.row.title }}
          </a>
        </template>
      </el-table-column>
    </el-table>
    <PaginationForNotice :pagecount="5"></PaginationForNotice>

    <!-- <el-pagination layout="prev, pager, next" :total="50"> </el-pagination> -->
  </div>
</template>
<script>
import PaginationForNotice from "@/components/PaginationForNotice";

export default {
  components:{
    PaginationForNotice
  },
  data() {
    return {
      noticelist: [],
      stockCode: decodeURI(this.$route.query.stockCode)
    };
  },
  methods: {
    async loadMoreNotice(stockCode, page) {
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
        "http://121.46.19.26:8288/ForeSee/allNotice/" +
          this.stockCode +
          "/" +
          page
      );
      this.noticelist = data.notice;
    },
  },
  created() {
    this.loadMoreNotice(this.stockCode,1);
    // this.show();

  },
};
</script>
<style>
</style>