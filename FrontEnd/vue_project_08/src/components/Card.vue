<template>
  <el-card class="box-card" shadow="hover">
    <div slot="header" class="clearfix">
      <span>基本信息</span>
    </div>
    <div class="text item">
      <el-table
        :data="tableData"
        border
        style="width: 100%">
        <el-table-column
          prop="name"
          :label="label1">
        </el-table-column>
        <el-table-column
          prop="value"
          :label="label2"
          width="450">
        </el-table-column>
      </el-table>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'Card',
  data () {
    return {
      stockCode: this.$route.query.stockCode,
      label1: "",
      label2: "",
      tableData: []
    }
  },
  methods: {
    async getData () {
            let {data} = await this.$get(
                "http://222.200.184.74:8288/ForeSee/allInfo/" + this.stockCode
            )
            this.label1 = data.tableData[1].name;
            this.label2 = data.tableData[1].value;
            this.tableData.push(data.tableData[0]);
            for (var i = 2; i <= 6; i++)
                this.tableData.push(data.tableData[i]);
    }

  },
  mounted () {
    this.getData();
  }
}
</script>

<style>
  th {
    font-weight: normal;
    color: #606266;
  } 
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
  .el-card {
    color: #FFD808;
    /* font-weight: 700; */
  }
  .box-card {
    width: 100%;
    margin-top: 30px;
  }
</style>
