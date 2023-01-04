<template>
  <div class="SendRecord">
    <div class="search">
      <m-form ref="mform" :formData="formData" :columns="formColumns"></m-form>
    </div>
    <m-table :tableData="tableData" :columns="tableColumns" @pageChange="pageChange" :page="pageInfo" :stripe="true" layout="total, prev, pager, next, jumper">
      <div slot="name" slot-scope="{row}" class="name-color" style="height: 40px;line-height: 40px;">
        <span class="name-color-success" v-if="row.status === 1">发送成功</span>
        <span class="name-color" v-else>发送失败</span>
      </div>
    </m-table>
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import { PageInfo } from '@/types/index'
import { formatTodayDate } from '@/utils/formValidate'

interface ArrValue {
  [index: number]: string;
}

@Component
export default class SendRecord extends Vue {
  
  private formData = {
    arrDate: this.$route.query.sendRecordParams ? this.$route.query.sendRecordParams : formatTodayDate(),
    status: this.$route.query.sendRecordParams ? 0 : ''
  } as any

  private pageInfo = {
    pageSize: 15,
    pageNum: 1,
    total: 0
  }
  
  private tableData = [] as any

  // @Watch('$route.query.sendRecordParams', { immediate: true })
  // getListRightNow () {
  //   this.getList(this.$route.query.sendRecordParams)
  // }

  get formColumns () {
    return [
      {
        label: '发送时间：',
        prop: 'arrDate',
        el: 'date-picker',
        type: 'date',
        placeholder: '请输入',
        span: 7,
        'value-format': 'yyyy-MM-dd',
        pickerOptions: {
          disabledDate(time: any) {
            return time.getTime() >= Date.now()
          }
        },
        rules: {
          required: true,
          trigger: 'blur',
          message: '发送时间不能为空'
        }
      },
      {
        label: '手机号：',
        prop: 'mobile',
        span: 7,
        el: 'input',
        labelWidth: '120px',
        placeholder: '请输入'
      },
      {
        label: '发送状态：',
        prop: 'status',
        el: 'mSelect',
        labelWidth: '120px',
        dataList: [
          {
            label: '失败',
            value: 0
          },
          {
            label: '成功',
            value: 1
          }
        ],
        span: 7,
        placeholder: '请选择'
      },
      {
        label: '签名名称：',
        prop: 'signatureName',
        span: 7,
        el: 'input',
        placeholder: '请输入'
      },
      {
        label: '模板类型：',
        prop: 'templateType',
        labelWidth: '120px',
        span: 7,
        el: 'mSelect',
        dataList: [
          {
            label: '验证码',
            value: 1
          },
          {
            label: '通知',
            value: 2
          },
          {
            label: '推广',
            value: 3
          }
        ],
        placeholder: '请输入'
      },
      {
        label: '发信方：',
        prop: 'platformName',
        labelWidth: '120px',
        span: 7,
        el: 'input',
        placeholder: '请输入'
      },
      {
        prop: 'btn',
        span: 7,
        labelWidth: '0',
        render: () => {
          return <div>
            <el-button type="primary" icon="el-icon-search" style="margin-left: 0px;margin-right: 17px;" onClick={this.getList}>搜索</el-button>
            <el-button icon="el-icon-edit" onClick={this.resetFun}>重置</el-button>
          </div>
        }
      }
    ]
  }

  get tableColumns () {
    return [
      {
        label: '手机号',
        prop: 'mobile'
      },
      {
        label: '发送时间',
        prop: 'createTime'
      },
      {
        label: '签名名称',
        prop: 'signatureName'
      },
      {
        label: '模板类型',
        prop: 'templateType',
        format (obj: any) {
          switch (obj.templateType) {
            case '1': return '验证码'
            case '2': return '通知'
            case '3': return '推广'
          }
        }
      },
      {
        label: '发送状态',
        prop: 'name'
      },
      {
        label: '失败原因',
        prop: 'remark',
        'show-overflow-tooltip': true,
        width: 260
      }
    ]
  }

  $refs!: {
    mform: any;
  }

  created () {
    this.$nextTick(() => {
      this.getList()
    })
  }
  
  getList () {
    this.$refs.mform.validate().then((value: boolean) => {
      if (value) {
        const { pageSize, pageNum } = this.pageInfo
        let params = {
          current: pageNum,
          size: pageSize,
          arrDate: this.formData.arrDate,
          mobile: this.formData.mobile,
          status: this.formData.status,
          signatureName: this.formData.signatureName,
          templateType: this.formData.templateType,
          platformName: this.formData.platformName,
        } as any
        if (!this.$route.query) {
          params = {
            ...params
          }
          // 不带时间
        } else if (this.$route.query.name === '营销') {
          params = {
            ...params,
            marketingId: this.$route.query.sendRecordParams,
            status: 0
          }
          // 带时间
        } else {
          params = {
            ...params,
            date: this.$route.query.sendRecordParams
            // status
          }
        }
        this.$api.getLogSendLogPage(params).then(res => {
          if (res && res.records) {
            this.tableData = [
              ...res.records
            ]
            this.pageInfo.total = Number(res.total)
          }
        })
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
  .SendRecord {
    .name-color {
      color: rgba(255,90,90,1);
      font-weight: 700;
    }
    
    .name-color-success {
      color: rgba(11,178,144,1);
      font-weight: 700;
    }
    /deep/ .el-range-editor.is-active, .el-range-editor.is-active:hover {
      border-color: rgba(11,178,144,1);
    }

    /deep/ .el-select .el-input.is-focus .el-input__inner {
      border-color: rgba(11,178,144,1);
    }
    /deep/ .el-input.is-active .el-input__inner, /deep/ .el-input__inner:focus {
      border-color: rgba(11,178,144,1);
    }

  }
</style>