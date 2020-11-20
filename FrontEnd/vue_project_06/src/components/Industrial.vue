<template>
<div class="main">
  <div class="intro">
    <h5>行业报告</h5>
      <div>{{brief_intro}}</div>
      <a :href="intro_url">点击获取详情</a>
  </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      brief_intro: "",
      intro_url: "",
    };
  },
  methods: {
    async loadIntro() {
      let { data } = await this.$get("/data/industrialReport.json");
      this.brief_intro = data.introduction.brief;
      this.intro_url=data.introduction.url;
    },
  },
  created(){
      this.loadIntro();
  }
};
</script>
<style scoped>
.main{
  justify-content: center;
  display: flex;
}
.intro{
  border: 1px solid #eee;
  width: 1100px;
  margin:50px;
}
.intro a{
  text-decoration-line:underline;
  color: #C6A639;
}
</style>