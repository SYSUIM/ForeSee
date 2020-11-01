<template>
  <div>
    <Header></Header>
    <Banner></Banner>
    <Content :content="showlist"></Content>
    <Geo :addr="address"></Geo>
    <CTA></CTA>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/Header";
import Content from "@/components/Content";
import Geo from "@/components/Geo";
import CTA from "@/components/CTA";
import Footer from "@/components/Footer";
import Banner from "@/components/Banner";

export default {
  components: {
    Header,
    Banner,
    Content,
    Geo,
    CTA,
    Footer,
  },
  data() {
    return {
      showlist: [],
      query: "蓝思科技",
      address: ["湖南浏阳生物医药园", "广东中山大学东校园"],
    };
  },
  methods: {
    async loadshowlist() {
      let { data } = await this.$get("/data/page2.json");
      // let { data } = await this.$get(
      //   "http://121.46.19.26:8288/ForeSee/companyInfo/" + this.query
      // );
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