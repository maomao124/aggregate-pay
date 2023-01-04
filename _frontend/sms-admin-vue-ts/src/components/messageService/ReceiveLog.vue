<template>
  <div class="ReceiveLog">
    <div class="search">
      <m-form :formData="formData" :columns="formColumns"></m-form>
    </div>
    <m-table :tableData="tableData" :columns="tableColumns" @pageChange="pageChange" :page="pageInfo" :stripe="true" layout="total, prev, pager, next, jumper">
      <div slot="btn" slot-scope="{row}" style="height: 40px;line-height: 40px;">
        <span v-if="row.status === 1" :class="{ 'active': row.status === 1 }">成功</span>
        <span v-else :class="{ 'activeFile': row.status === 0 }">失败</span>
      </div>
    </m-table>
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import { PageInfo } from '@/types/index'
import { monthOneDay, formatTodayDate } from '@/utils/formValidate'

@Component
export default class ReceiveLog extends Vue {
  static componentName = 'ReceiveLog'

  private formData = {
    dateArr: [ monthOneDay(), formatTodayDate() ]
  } as any
  private tableData = [] as any
  
  private pageInfo = {
    pageSize: 15,
    pageNum: 1,
    total: 0
  }

  get formColumns () {
    return [
      {
        label: '签名名称：',
        prop: 'signatureName',
        span: 7,
        placeholder: '请输入',
        el: 'input'
      },
      {
        label: '模板名称：',
        prop: 'templateName',
        span: 7,
        placeholder: '请输入',
        labelWidth: '120px',
        el: 'input'
      },
      {
        label: '应用名称：',
        prop: 'platformName',
        span: 7,
        placeholder: '请输入',
        labelWidth: '120px',
        el: 'input'
      },
      {
        label: '创建时间：',
        prop: 'dateArr',
        el: 'date-picker',
        'value-format': 'yyyy-MM-dd',
        format: 'yyyy-MM-dd',
        type: 'daterange',
        pickerOptions: {
          disabledDate(time: any) {
              return time.getTime() > Date.now()
          }
        },
        // rules: {
        //   required: true,
        //   trigger: 'blur',
        //   validator: (rule: any, value: any, callback: Function) => {
        //     if (!value) {
        //       callback(new Error('创建时间不能为空'))
        //     } else {
        //       // 判断时间是不是在一个月之内
        //       const time1 = new Date(this.formData.dateArr[0]).getTime()
        //       const time2 = new Date(this.formData.dateArr[1]).getTime()
        //       const time3 = time2 - time1
        //       const time4 = 1000 * 3600 * 24 * 30
        //       if (time3 > time4) {
        //         // TODO
        //         callback(new Error('时间查询跨度不能超过30天'))
        //       } else {
        //         callback()
        //       }
        //     }
        //   }
        // },
        span: 7,
        'prefix-icon': ''
      },
      {
        prop: 'btn',
        span: 7,
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
        label: '创建时间',
        prop: 'createTime'
      },
      {
        label: '通道名称',
        prop: 'configName'
      },
      {
        label: '签名名称',
        prop: 'signatureName'
      },
      {
        label: '模板名称',
        prop: 'templateName'
      },
      {
        label: '应用',
        prop: 'platformName'
      },
      {
        label: '耗时（秒）',
        prop: 'useTime'
      },
      {
        label: '状态',
        prop: 'btn'
      }
    ]
  }

  created () {
    this.getList()
  }

  getList () {
    const { pageSize, pageNum } = this.pageInfo
    const params = {
      current: pageNum,
      size: pageSize,
      signatureName: this.formData.signatureName,
      templateName: this.formData.templateName,
      startCreateTime: this.formData.dateArr ? this.formData.dateArr[0] + ' 00:00:00' : null,
      endCreateTime: this.formData.dateArr ? this.formData.dateArr[1] + ' 23:59:59' : null,
      platformName: this.formData.platformName
    }
    this.$api.getLogReceivePage(params).then(res => {
      if (res && res !== null) {
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

}
</script>

<style lang="scss" scoped>
  .ReceiveLog {
    width: 100%;
    .active {
      color: #0bb290;
      font-weight: 700;
    }
    .activeFile {
      color: #ff5a5a;
      font-weight: 700;
    }

    /deep/ .el-date-table td.selected span {
      background-color:  #0bb290;
    }

    // 日期框颜色样式覆盖
    /deep/ .el-range-editor.is-active, .el-range-editor.is-active:hover {
      border-color: rgba(11,178,144,1);
    }
  }
</style>