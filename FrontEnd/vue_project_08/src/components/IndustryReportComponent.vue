<template>
    <div>
      <div class="report">
        <!-- <el-button class="clearBtn" @click="resetDateFilter">清除日期过滤器</el-button> -->
        <!-- <el-button class="clearBtn" @click="clearFilter">清除过滤器</el-button> -->
        <el-table
        ref="filterTable"
        :data="tableData"
        style="width: 100%">
            <el-table-column
            prop="date"
            sortable
            label="发表日期"
            width="180"
            column-key="date"
            >
            <template slot-scope="scope">              
                {{scope.row.date}}
            </template>
            </el-table-column>
            <el-table-column
            prop="title"
            label="标题"
            :formatter="formatter">
            <template slot-scope="scope">
              <a :href="scope.row.url" target="_blank">{{scope.row.title}}</a>
            </template>
            </el-table-column>
            <el-table-column
            prop="research"
            label="分析年份"
            width="100"
            :filters="filters_ay"
            :filter-method="filterTag"
            filter-placement="bottom-end">
            <template slot-scope="scope">
                <el-tag
                :type="scope.row.research === '2020' ? 'success' : 'primary'"
                disable-transitions>{{scope.row.research}}</el-tag>
            </template>
            </el-table-column>
        </el-table>
      </div>
    </div>
</template>

<script>
  export default {
    data() {
      return {
        tableData: [],
        filters_ay: [
          {text:'2016',value:'2016'},
          {text:'2017',value:'2017'},
          {text:'2018',value:'2018'},
          {text:'2019',value:'2019'},
          {text:'2020',value:'2020'},
        ]
      }
    },
    methods: {
      async load() {
        // let { data } = await this.$get("/data/Internet_article_info.json");
        let { data } = await this.$get("http://222.200.184.74:8288/ForeSee/industryReports/industryCode/1");
        this.tableData = data.reports;
        console.log(data)
        
      },
      // resetDateFilter() {
      //   this.$refs.filterTable.clearFilter('date');
      // },
      // clearFilter() {
      //   this.$refs.filterTable.clearFilter();
      // },
      //formatter(row, column) {
      formatter(row) {
        return row.title;
      },
      filterTag(value, row) {
        return row.research === value;
      },
      filterHandler(value, row, column) {
        const property = column['property'];
        return row[property] === value;
      }
    },
    created() {
      this.load();
      // this.show();
    }
  }
</script>

<style scoped>
  .report {
    width: 70%;
    margin: 20px auto;
  }
  .report .clearBtn:hover {
    background-color: rgb(255,218,8);
    color: white;
    font-weight: 700;
    border: 1px solid white;
  }
  .el-table th>.cell.highlight {
    color: #909399;
  }
  .el-table .ascending .sort-caret.ascending {
    border-top-color: #FFD808;
  }
  .el-table .descending .sort-caret.descending {
    border-top-color: #FFD808;
  }
</style>