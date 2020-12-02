<template>
  <!-- 检索框 -->
  <div class="search-box">
    <el-input 
      v-model="input" 
      @keyup.enter.native="trans" 
      class="search keyword" placeholder="Search Company" clearable @clear="setValueNull">
    </el-input>
    <button class="btn btn-primary" v-bind:disabled="dis" type="button" @click="trans" id="searchclick">Search</button>
  </div>
</template>

<script>
  export default {
    name: "SearchBox2",
    data() {
      return {
        input: '',
        dis:true,
      }
    },
    methods: {
      // 发送检索请求
      trans () {
        if(this.input=== ''){
        /*$(".btn btn-primary").addClass("huise")
        // 将鼠标设置为不可点击状态
        document.getElementById('searchclick').style.cursor = 'not-allowed'*/
        this.dis=true;
      }
      else{
      setTimeout(() => {
        this.$router.push('/industry' + '?query=' + this.input)
      }, 200)
      }
    },
    setValueNull(){
      this.dis=true;
    },
    },
    watch: {
    input () {
      if (this.input!='')
      {
        //this.hideIcon();
        this.dis=false;
        /*$(".btn btn-primary").removeClass("huise") //移除不可点击状态
        document.getElementById('searchclick').style.cursor = 'pointer'*/
      }
    }
    }
  }
</script>

<style>
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
.el-input__icon {
  position: relative;
  top: 13px;
  left: 12px;
}
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
  background-color: #FFD808;
  color: #fff;
  font-size: 18px;
  font-weight: bold; 
  border-radius: 28px;
}
 .btn-primary:hover {
    background-color: #000000;
    color: #FFD808; 
}
</style>