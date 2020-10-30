<template>
  <div>
    <Header></Header>
    <Banner></Banner>
    <Content :content="showlist"></Content>
    <CTA></CTA>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from "@/components/Header";
import Content from "@/components/Content";
import CTA from "@/components/CTA";
import Footer from "@/components/Footer";
import Banner from "@/components/Banner";


export default {
  components: {
    Header,
    Banner,
    Content,
    CTA,
    Footer
  },
  data(){
    return{
      showlist:[],
      query:decodeURI(this.$route.query.query),
    };
  },
  methods:{
    async loadshowlist(){
      // let  {data}  = await this.$get("/data/page2.json");
      let { data } = await this.$get(
        "http://121.46.19.26:8288/ForeSee/companyInfo/" + this.query
      );
      this.showlist=data
      console.log(this.showlist)
    }
  },
  created(){
    console.log(this.query)
    this.loadshowlist()
  }
};
</script>
<style>
</style>