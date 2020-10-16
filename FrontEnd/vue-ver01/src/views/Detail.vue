<template>
  <div>
      <div v-for="item in detailInfo.news" :key="item.news_link">
          <a :href="item.news_link.split(/\'/g)[1]">{{item.news_title}}</a>
          <div style="margin-bottom:20px">{{item.news_time}}</div>

      </div>
      
  </div>
</template>
<script>
export default {
    data(){
        return{
            stockCode:decodeURI(this.$route.query.stockCode),
            // stockCode:"300433",
            detailInfo:{}
        }
    },
    methods:{
        async getDetail(){
            let {data}=await this.$get(
                "http://121.46.19.26:8288/ForeSee/allInfo/"+this.stockCode
            )
            this.detailInfo=data
        }
    },
    created(){
        this.getDetail()
        console.log(this.detailInfo.companyInfo)
    }
};
</script>
<style>
</style>