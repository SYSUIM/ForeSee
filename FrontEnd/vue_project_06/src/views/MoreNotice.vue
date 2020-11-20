<template>
  <div>
    <Header></Header>
    <Banner :title="title" :show_title="show_title" :show_value="stockCode"></Banner>
    <MoreNoticeComponent></MoreNoticeComponent>
    <CTA></CTA>
    <Footer></Footer>
  </div>
</template>
<script>
import Header from "@/components/Header";
import CTA from "@/components/CTA";
import MoreNoticeComponent from "@/components/MoreNoticeComponent";
import Footer from "@/components/Footer";
import Banner from "@/components/Banner";


export default {
  components: {
    Header,
    Banner,
    CTA,
    Footer,
    MoreNoticeComponent,
    // Pagination,
  },
  data() {
    return {
      newslist: {},
      // query: "蓝思科技",
      stockCode: decodeURI(this.$route.query.stockCode),
      // page:1
      title: "企业公告",          //传入banner
      show_title: "股票代码：   " //传入banner
    };
  },
  methods: {
    
  },
  created() {
    
  },
};
</script>
<style>
</style>