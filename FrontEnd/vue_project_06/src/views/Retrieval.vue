<template>
  <div>
    <BackTop></BackTop>
    <Header></Header>
    <Banner :title="title" :show_title="show_title" :show_value="query"></Banner>
    <Content :content="showlist"></Content>
    <!-- <Geo :addr="address"></Geo> -->
    <CTA></CTA>
    <Footer></Footer>
  </div>
</template>

<script>
import BackTop from "@/components/BackTop";
import Header from "@/components/Header";
import Content from "@/components/Content";
// import Geo from "@/components/Geo";
import CTA from "@/components/CTA";
import Footer from "@/components/Footer";
import Banner from "@/components/Banner";

export default {
  components: {
    BackTop,
    Header,
    Banner,
    Content,
    // Geo,
    CTA,
    Footer,
  },
  data() {
    return {
      showlist: [],
      // query: "蓝思科技",
      query:decodeURI(this.$route.query.query),
      // address: ["湖南浏阳生物医药园", "广东中山大学东校园"],
      title: "企业检索",                      //传入 banner 组件
      show_title: "检索词：   ",            //传入 banner 组件
    };
  },
  methods: {
    async loadshowlist() {
      // let { data } = await this.$get("/data/page2.json");
      let { data } = await this.$get(
        "http://121.46.19.26:8288/ForeSee/companyInfo/" + this.query
      );
      this.showlist = data;
    },
  },
  created() {
    this.loadshowlist();
  },
};
</script>
<style>
</style>