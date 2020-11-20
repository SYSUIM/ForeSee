<template>
  <div class="pagination">
    <el-pagination
      ref="changepage"
      :page-size="20"
      :pager-count="13"
      layout="prev, pager, next"
      :total="20*pagecount"
      :current-page="this.page"
      @current-change="currentChange"
      @prev-click="prevpage"
      @next-click="nextpage"
    ></el-pagination>
  </div>
</template>

<script>
export default {
  props: ['pagecount'],
  data() {
    return {
      page: parseInt(this.$route.query.page),
    };
  },
  methods: {
    currentChange(val) {
      this.page = val;
      // console.log(this.page);
      this.$parent.loadMoreNews(this.stockCode, val);
    },
    prevpage(val) {
      this.page = val;
      console.log(val);
      this.$parent.loadMoreNews(this.stockCode, val);
    },
    nextpage(val) {
      this.page = val;
      // console.log(val);
      this.$parent.loadMoreNews(this.stockCode, val);
    },
  },
};
</script>

<style>
.pagination{
    padding:50px 100px;
}
.el-pager li{
    color:#1b22228e
}
.el-pager li.active {
  color: #3A8283;
  cursor: default;
}
.el-pagination .el-pager li:hover {
  color: #3A8283;
}
.el-pagination .el-pager li:not(.disabled):hover {
  color: #3A8283;
}
</style>
