<template>
  <!-- 检索框 -->
<div >
  <div class="search-box">
      <el-input
        v-model="input"
        @keyup.enter.native="search"
        class="search keyword"
        placeholder="Search Company" clearable @clear="setValueNull"
      >
      </el-input>
    <button class="btn btn-primary" v-bind:disabled="dis" type="button" @click="trans" id="searchclick">Search</button>
  </div>
  <!-- 实时检索下拉菜单 -->
  <div class="search-content" ref="search" v-show="input" style="background:white">
        <ul>
          <li class="search-item " v-for="item in returnlist" :key="item.id" @click="transFromRealtime(item)" >
              <p>{{ item.company_name }}</p>
          </li>
          <li class="search-item nodata" v-show="hasNoData">没有找到匹配数据</li>
        </ul>
  </div>
</div>
</template>

<script>
//import $ from 'jquery'
import data from '../../public/data/real-time-retrieve.json'
export default {
  name: "SearchBox1",
  data() {
    return {
      input: "",
      list:data,
      returnlist:[],
      dis:true,
    };
  },
  computed: {
    hasNoData () {
      return !this.returnlist.length
    },
    },
  methods: {
    /*
    // 实时检索列表
    async realtimeSearch() {
      let {data}  = await this.$get(
        '/data/real-time-retrieve.json'
      );
      this.list=data;
      // console.log(this.list);
    },
    */

    // 发送检索请求
    trans() {
      if(this.input=== ''){
        /*$(".btn btn-primary").addClass("huise")
        // 将鼠标设置为不可点击状态
        document.getElementById('searchclick').style.cursor = 'not-allowed'*/
        this.dis=true;
      }
      else{
      setTimeout(() => {
        this.$router.push("/retrieval" + "?query=" + this.input);
      }, 200);
      }
    },
    setValueNull(){
      this.dis=true;
    },
    async transFromRealtime(item){
      await this.$router.push("/retrieval" + "?query=" + item.short_name);
    },
    /*hideIcon(){
      let dom = '';
        dom = document.getElementsByClassName("el-icon-search")
      this.$nextTick(() => {
        dom.style.display="none";
        })
    }*/
  },
  created(){
    // this.realtimeSearch();
  },
  watch: {
    input () {
      if (this.timer) {
        clearTimeout(this.timer)
      }
      if (!this.input) {
        this.returnlist = []
        return
      }
      if (this.input!='')
      {
        //this.hideIcon();
        this.dis=false;
        /*$(".btn btn-primary").removeClass("huise") //移除不可点击状态
        document.getElementById('searchclick').style.cursor = 'pointer'*/
      }
      this.timer = setTimeout(() => {
        const result = []
        for (let i in this.list) {
            if(result.length>5) break;
            let index = this.list[i].company_name.indexOf(this.input);
            if (index > -1 ) {
              // 实现优先级赋值，index：第几个匹配到
              this.list[i].index=index;
              result.push(this.list[i]);
            }
        }
        //实现优先级排序
        result.sort(function(a,b){return a.index-b.index});
        console.log(result);
        this.returnlist = result;
      }, 100)
    }
  }
};
</script>

<style>
.search-box{
  margin-bottom: 0;
  position: relative;
  height: 100px;
}

.search-content{
  margin-top:-40px;
  padding:0;
  width:280px;
  margin-left: 224px;
  /* text-align: left; */
  /* border-top: 1px solid #eee; */
  border-bottom-left-radius: 10px;
  border-bottom-right-radius: 10px;
  overflow: hidden;
  position: absolute;
  z-index: 9999;


}
.search-content ul{
  margin-left: 0px;
}
.search-content .search-item{
  margin-left: 0;
  height: 40px;
  /* text-align: left; */
  display:flex;
  vertical-align: middle;
  align-items: center;
  align-content: center;
  border-top: 1px solid #eee;
}

.search-content .search-item p{
  margin-top: 30px;
  margin-left: 10px;
  font-size: 12px;
}
.banner .wrap-caption .search-content .search-item p {
  color: #606266;
}

.search-item:hover{
  cursor: pointer;
}

.search-item.nodata{
  margin-left: 10px;
  border-bottom: none;
}
#searchclick.btn.btn-primary{
  background-color: #ffd808;
    font-size: 18px;
  font-weight: bold;
}
#searchclick.btn.btn-primary:hover{
  background-color: #000000;
}
 .el-input__inner {
  height: 54px;
  width: 280px;
  padding: 10px;
  border: none;
  border-radius: 28px;
  outline: none;
  margin-bottom: 10px;
}
/*.el-input__icon {
  position: relative;
  top: 13px;
  left: 12px;
}*/
.el-input__suffix {
  /*width: 48px;
  height: 48px;*/
  right: 28px;
}
.btn {
  font-size: 14px;
  color: #ffffff;
  padding: 14px 50px;
  border: 0;
  min-width: 150px;
  font-family: "Ubuntu", sans-serif;
  -webkit-border-radius: 0;
  -moz-border-radius: 0;
  -ms-border-radius: 0;
  border-radius: 8;
  font-size: 16px;
  -webkit-box-shadow: 0px 5px 30px rgba(0, 0, 0, 0.1);
  -moz-box-shadow: 0px 5px 30px rgba(0, 0, 0, 0.1);
  box-shadow: 0px 5px 30px rgba(0, 0, 0, 0.1);
}
.btn-primary {
  background-color: #ffd808;
  color: #fff;
  font-size: 18px;
  font-weight: bold;
  border-radius: 28px;
}
.btn-primary:hover {
  background-color: #000000;
  color: #ffd808;
}
.search-box .el-input .el-input__inner {
  height: 54px;
  width: 280px;
  padding: 10px;
  border: none;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  border-bottom-right-radius: 5px;
  border-bottom-left-radius: 5px;
  outline: none;
  margin-bottom: 0;
}
</style>