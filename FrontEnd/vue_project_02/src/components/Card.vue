<template>
  <el-card class="box-card" shadow="hover">
    <div slot="header" class="clearfix">
      <span>基本信息</span>
    </div>
    <div class="text item">
      <el-table
        :data="table"
        border
        stripe
        height="320"
        style="width: 100%">
        <el-table-column
          prop="name"
          label="名称"
          width="215">
        </el-table-column>
        <el-table-column
          prop="value"
          label="值"
          width="500">
        </el-table-column>
      </el-table>
    </div>
  </el-card>
</template>

<script>
export default {
  name: 'Card',
  props: ['table']
}
</script>

<style>
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
