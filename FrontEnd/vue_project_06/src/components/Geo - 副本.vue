<template>
  <div class="content">
    <div class="amap-wrapper">
      <el-amap
        class="amap-box"
        :zoom="zoom"
        :center="center"
        :mapStyle="mapStyle"
      >
        <el-amap-marker
          v-for="(marker, index) in markers"
          :position="marker.position"
          :key="index"
          :events="marker.events"
        ></el-amap-marker>
        <el-amap-info-window
          v-if="window"
          :position="window.position"
          :visible="window.visible"
          :content="window.content"
          :offset="window.offset"
        ></el-amap-info-window>
      </el-amap>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      stockCode:decodeURI(this.$route.query.stockCode),
      //用来接收获取到的raw data
      markers_data: [],
      //center, zoom, mapStyle, windows, window, marker, markers是amap固定的参数，不能随意修改名字
      center: [121.539693, 31.126667], //地图中心点坐标
      zoom: 3, //初始化地图显示层级
      mapStyle: "normal", //设置地图样式, 还有dark等模式
      windows: [], //所有信息窗体的数组
      window: "", //一个信息窗体
      markers: [] //所有地点标志的数组
    };
  },
  methods: {
    async point() {
      let { data } = await this.$get("http://121.46.19.26:8288/ForeSee/allInfo/" + this.stockCode);
      this.markers_data = data.geo;
      let windows = [];
      let markers = [];
      let that = this;
      //将获取到的raw data解析为amap可以读取的format
      //position, events等都是amap固定的，不能擅自修改
      this.markers_data.forEach((item, index) => {
        markers.push({
          position: [item.lng, item.lat],
          events: {
            click() {
              that.windows.forEach((window) => {
                window.visible = false; //关闭窗体
              });
              that.window = that.windows[index];
              that.$nextTick(() => {
                that.window.visible = true; //点击点坐标，出现信息窗体
              });
            },
          },
        });
        windows.push({
          position: [item.lng, item.lat],
          content: "<div>" + item.company_name+item.stock_code + "</div>", //内容
          offset: [0, -40], //窗体偏移
          visible: false, //初始是否显示
        });
      });
      //  加位置点
      this.markers = markers;
      //   加弹窗
      this.windows = windows;
    },
  },
  mounted() {
    this.point();
  },
};
</script>

<style scoped>
.amap-wrapper {
  width: 100%;
  height: 300px;
  margin: 0 auto;
  margin-bottom: 30px;
}
.amap-wrapper {
  box-shadow: 5px 5px 5px rgba(0,0,0,.5)
}
</style>