<template>
  <div>
    <BackTop></BackTop>
    <Header></Header>
    <Banner :title="title" :show_title="show_title" :show_value="query"></Banner>
    <Tabs></Tabs>
    <Footer></Footer>
  </div>
</template>
<script>
import BackTop from "@/components/BackTop";
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import Banner from "@/components/Banner";
import Tabs from '@/components/Tabs';

export default {
  components: {
    BackTop,
    Header,
    Banner,
    Footer,
    Tabs
  },
  data () {
    return {
      query:decodeURI(this.$route.query.query),
      title: "行业检索",                      //传入 banner 组件
      show_title: "检索词：   ",            //传入 banner 组件
    }
  }
};
</script>
<style>

</style>