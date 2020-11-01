<template>
  <div>
    <Header></Header>
    <Banner></Banner>
    <Industrial></Industrial>
    <Geo></Geo>
    <Footer></Footer>
  </div>
</template>
<script>
import Header from "@/components/Header";
import Footer from "@/components/Footer";
import Banner from "@/components/Banner";
import Industrial from "@/components/Industrial";
import Geo from "@/components/Geo";

export default {
  components: {
    Header,
    Banner,
    Footer,
    Geo,
    Industrial
  },
};
</script>
<style>

</style>