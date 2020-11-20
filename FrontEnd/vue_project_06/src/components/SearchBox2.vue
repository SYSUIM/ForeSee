<template>
  <!-- 检索框 -->
  <div class="search-box">
    <el-input 
      v-model="input" 
      @keyup.enter.native="trans" 
      class="search keyword" placeholder="Search Industry">
    </el-input>
    <button class="btn btn-primary" type="button" @click="trans">Search</button>
  </div>
</template>

<script>
  export default {
    name: "SearchBox2",
    data() {
      return {
        input: ''
      }
    },
    methods: {
      // 发送检索请求
      trans () {
      setTimeout(() => {
        this.$router.push('/industry' + '?query=' + this.input)
      }, 200)
    }
    }
  }
</script>

<style>
  .el-input__inner {
  height: 54px;
  width: 280px;
  padding: 10px;
  border: none;
  border-radius: 28px;
  outline: none;
  margin-bottom: 10px;
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