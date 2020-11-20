<template>
  <div>
    <BackTop></BackTop>
    <Header></Header>
    <Banner :title="title" :show_title="show_title" :show_value="query"></Banner>
    <IndustryReportComponent></IndustryReportComponent>
    <CTA></CTA>
    <Footer></Footer>
  </div>
</template>
<script>
import BackTop from "@/components/BackTop"
import Header from "@/components/Header";
import CTA from "@/components/CTA";
import IndustryReportComponent from "@/components/IndustryReportComponent";
import Footer from "@/components/Footer";
import Banner from "@/components/Banner";


export default {
  components: {
    BackTop,
    Header,
    Banner,
    CTA,
    Footer,
    IndustryReportComponent
  },
  data() {
    return {
      newslist: {},
      query: "互联网",
      title: "行业报告",          //传入banner
      show_title: "检索词：   "   //传入banner
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