<template>
  <div class="HistoryRecords">
    <div class="search">
      <m-form :formData="formData" :columns="formColumns"></m-form>
    </div>
    <m-table :tableData="tableData" :columns="tableColumns" @pageChange="pageChange" :page="pageInfo" :stripe="true">
      <div slot="发送总数（条）" slot-scope="{row}">
        <span class="total">{{row}}</span>
      </div>
      <div slot="发送成功（条）" slot-scope="{row}">
        <span class="success">{{row}}</span>
      </div>
      <div slot="发送失败（条）" slot-scope="{row}">
        <span class="file">{{row}}</span>
      </div>
      <div slot="btn" slot-scope="{row}">
        <el-tooltip class="item" effect="dark" content="点击查看" placement="top">
          <el-button class="btn-img" type="text"><img src="@/assets/marketSMS/xiangqing.png" alt="" /></el-button>
        </el-tooltip>
        <el-tooltip class="item" effect="dark" content="点击重发" placement="top">
          <el-button @click="recordsFun(row)" class="btn-img" type="text"><img src="@/assets/marketSMS/xinxichakan.png" alt="" /></el-button>
        </el-tooltip>
      </div>
    </m-table>
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import { PageInfo } from '@/types/index'

@Component
export default class HistoryRecords extends Vue {
  private formData = {}
  private tableData = [
    {
      date: '2020',
      content: '人工智能大咖座谈会',
      info: '&#91传智播客]您的验证码…',
      name: '慕容小鱼',
      type: 0
    },
    {
      date: '2020',
      content: '人工智能大咖座谈会',
      info: '&#91传智播客]您的验证码…',
      name: '慕容小鱼',
      type: 1
    },
    {
      date: '2020',
      content: '人工智能大咖座谈会',
      info: '&#91传智播客]您的验证码…',
      name: '慕容小鱼',
      type: 0
    },
    {
      date: '2020',
      content: '人工智能大咖座谈会',
      info: '&#91传智播客]您的验证码…',
      name: '慕容小鱼',
      type: 1
    }
  ]
  private pageInfo = {
    pageSize: 15,
    pageNum: 1,
    total: 0
  }
  get formColumns () {
    return [
      {
        label: '签名名称：',
        prop: '签名名称',
        span: 6,
        el: 'input',
        placeholder: '请输入'
      },
      {
        label: '主题名称：',
        prop: '主题名称',
        span: 6,
        el: 'input',
        placeholder: '请输入'
      },
      {
        label: '发送时间：',
        prop: '发送时间',
        el: 'date-picker',
        type: 'dates',
        span: 6
      },
      {
        prop: 'btn',
        span: 6,
        render: () => {
          return <div>
            <el-button type="primary" icon="el-icon-search" style="margin-left: 34px;margin-right: 34px;" onClick={this.getList}>搜索</el-button>
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
        prop: '发送时间'
      },
      {
        label: '签名名称',
        prop: '签名名称'
      },
      {
        label: '主题名称',
        prop: '主题名称'
      },
      {
        label: '发送总数（条）',
        prop: '发送总数（条）'
      },
      {
        label: '发送成功（条）',
        prop: '发送成功（条）'
      },
      {
        label: '发送失败（条）',
        prop: '发送失败（条）'
      },
      {
        label: '操作',
        prop: 'btn'
      }
    ]
  }

  getList () {
    // TODO
  }

  resetFun () {
    this.formData = {}
  }

  pageChange (pageInfo: PageInfo) {
    this.pageInfo = pageInfo
  }

  recordsFun (item: any) {
    this.$message.success('短信已发出，请稍后查看结果！')
  }
}
</script>

<style lang="scss" scoped>
  .HistoryRecords {
    .total {
      color: #5771de;
      font-weight: 500;
    }
    .success {
      color: #0bb290;
      font-weight: 500;
    }
    .file {
      color: #ff5a5a;
      font-weight: 500;
    }
    .btn-img {
      img {
        width: 24px;
        height: 24px;
        margin-right: 10px;
      }
    }
  }
</style>