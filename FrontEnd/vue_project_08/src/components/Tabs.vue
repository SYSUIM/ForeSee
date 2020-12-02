<template>
  <div>
    <el-tabs
      v-model="activeName"
      type="card"
      @tab-click="handleClick"
      class="yellowTab"
    >
      <el-tab-pane label="相关企业" name="first">
        <Content :content="showlist"></Content>
      </el-tab-pane>
      <el-tab-pane label="企业可视化" name="second">
        <Geo></Geo>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
import Content from "@/components/Content";
import Geo from "@/components/Geo";

export default {
  components: {
    Content,
    Geo,
  },
  data() {
    return {
      activeName: "first",
      showlist: [],
      query:decodeURI(this.$route.query.query),
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
    async loadshowlist() {
      let { data } = await this.$get(
        "http://222.200.184.74:8288/ForeSee/companyInfo/" + this.query
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
.tabs {
  margin: 20px 30px;
}
.yellowTab .el-tabs__item{
  color: black;
}
.yellowTab .el-tabs__item.is-active {
  color: #fad84b;
}

.yellowTab .el-tabs__item:hover {
  color: #fad84b;
}
.el-tabs__item:hover {
  color: #fad84b;
}
</style>