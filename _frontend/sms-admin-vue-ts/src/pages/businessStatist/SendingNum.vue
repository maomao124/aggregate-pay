<template>
  <div class="SendingNum">
    <div class="search">
      <m-form :formData="formData" :columns="formDataColumns"></m-form>
    </div>
    <m-table :tableData="tableData" :columns="tableColumns" @pageChange="pageChange" :page="pageInfo" :stripe="true" class="send-num" layout="total, prev, pager, next, jumper">
      <div slot="count" slot-scope="{row}">
        <span class="total-info">{{ row.count }}</span>
      </div>
      <div slot="success" slot-scope="{ row }">
        <span class="success">{{ row.success }}</span>
      </div>
      <div slot="fail" slot-scope="{row}">
        <span class="file">{{ row.fail }}</span>
      </div>
      <div slot="btn" slot-scope="{row}" style="height: 40px;">
        <el-tooltip class="item" effect="dark" content="点击查看失败详情" placement="top">
          <el-button @click="goDetail(row)" type="text" class="btn-img" v-show="row.fail !== 0">
            <img src="@/assets/marketSMS/xiangqing.png" alt="" />
          </el-button>
        </el-tooltip>
      </div>
    </m-table>
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import { PageInfo } from '@/types/index'
import { monthOneDay, formatTodayDate } from '@/utils/formValidate'

@Component
export default class SendingNum extends Vue {
  private formData = {
    dateArr: [ monthOneDay(), formatTodayDate() ]
  } as any
  private pageInfo = {
    pageSize: 15,
    pageNum: 1,
    total: 0
  }
  private tableData = [] as any

  get formDataColumns () {
    return [
      {
        label: '发送时间：',
        prop: 'dateArr',
        'value-format': 'yyyy-MM-dd',
        format: 'yyyy-MM-dd',
        el: 'date-picker',
        type: 'daterange',
        span: 6,
      },
      {
        prop: 'btn',
        span: 6,
        render: () => {
          return <div>
            <el-button type="primary" icon="el-icon-search" style="margin-left: 34px;margin-right: 17px;" onClick={this.getList}>搜索</el-button>
            <el-button icon="el-icon-edit" onClick={this.resetFun}>重置</el-button>
          </div>
        }
      }
    ]
  }

  get tableColumns () {
    return [
      {
        label: '发送时间',
        prop: 'date'
      },
      {
        label: '发送总数（条）',
        prop: 'count'
      },
      {
        label: '发送成功（条）',
        prop: 'success'
      },
      {
        label: '发送失败（条）',
        prop: 'fail'
      },
      {
        label: '发送成功率',
        prop: 'successRate'
      },
      {
        label: '操作',
        prop: 'btn'
      }
    ]
  }

  created() {
  this.getList() 
  }

  getList () {
    const { pageSize, pageNum } = this.pageInfo
    const params = {
      current: pageNum,
      size: pageSize,
      startCreateTime: this.formData.dateArr ? this.formData.dateArr[0] + ' 00:00:00' : null,
      endCreateTime: this.formData.dateArr ? this.formData.dateArr[1] + ' 23:59:59' : null
    }
    this.$api.getStatisticsCountPage(params).then(res =>{
      if (res && res.records) {
        this.tableData = [
          ...res.records
        ]
        this.pageInfo.total = Number(res.total)
      }
    })
  }

  resetFun () {
    this.formData = {}
  }

  pageChange (pageInfo: PageInfo) {
    this.pageInfo = pageInfo
    this.getList()
  }

  goDetail (item: any) {
    this.$router.push({ path: '/businessStatist/SendRecord', query: { sendRecordParams: item.date, name: '发送量' } })
  }
}
</script>

<style lang="scss" scoped>
  .SendingNum {
    .total-info {
      color: #5771de;
      font-weight: 700;
    }
    .success {
      color: #0bb290;
      font-weight: 700;
    }
    .file {
      color: #ff5a5a;
      font-weight: 700;
    }
    /deep/ .el-table--border, .el-table--group {
      border: 1px solid #EBEEF5;
      border-radius: 10px;
    }
    .btn-img {
      img {
        width: 18px;
        height: 18px;
        margin-right: 10px;
      }
    }

    .send-num {
    }

    /deep/ .el-range-editor.is-active, .el-range-editor.is-active:hover {
      border-color: rgba(11,178,144,1);
    }
  }
</style>