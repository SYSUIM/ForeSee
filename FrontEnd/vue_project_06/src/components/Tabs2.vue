<template>
  <div>
    <el-tabs
      v-model="activeName"
      type="card"
      @tab-click="handleClick"
      class="yellowTab"
    >
      <el-tab-pane label="行业报告" name="first">
        <Industrial></Industrial>
      </el-tab-pane>
      <el-tab-pane label="企业可视化" name="second">
        <Geo></Geo>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
import Industrial from "@/components/Industrial";
import Geo from "@/components/Geo";

export default {
  components: {
    Industrial,
    Geo,
  },
  data() {
    return {
      activeName: "first",
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    },
  },
};
</script>

<style>
.tabs {
  margin: 20px 30px;
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