<template>
  <div class="blacklistManage">
    <div class="search">
      <m-form :formData="formData" :columns="formColumns"></m-form>
    </div>
    <div class="list">
      <el-button type="primary" style="margin-left: 0px;margin-right: 26px;" @click="importDialog" class="delete">
        <i class="iconfont icon-xiazai"></i>
        导入
      </el-button>
      <el-button @click="cancelNums" class="delete" style="padding: 10px 16px;" :disabled="ids.length === 0">
        <i class="el-icon-delete icon-sign"></i>
        取消拉黑
      </el-button>
    </div>
    <m-table :tableData="tableData" :columns="tableColumns" @pageChange="pageChange" :page="pageInfo" :stripe="true" @selection-change="selectChange" selection layout="total, prev, pager, next, jumper">
      <div slot="btn" slot-scope="{row}">
        <el-tooltip class="item" effect="dark" content="点击取消拉黑" placement="top">
          <el-button @click="cancelBlackout(row)" type="text" class="btn-img">
            <img src="@/assets/systemManage/xingzhuang.png" alt="" />
          </el-button>
        </el-tooltip>
      </div>
    </m-table>
    <!-- 导入动作 -->
    <BlacklistManageDialog :dialogShow="dialogShow" title="导入黑名单" @closeDialog="closeDialog" />
    <!-- 取消拉黑动作 -->
    <el-dialog :visible.sync="centerDialogVisible" width="322px" center :show-close="false" top="22vh" class="dia-black">
      <span class="diaLog-span" style="text-align:center;">确认取消拉黑?</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisible = false" class="btn-sty">取 消</el-button>
        <el-button type="primary" @click="cancelDialog" style="padding: 10px 20px;">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import { PageInfo } from '@/types/index'
import BlacklistManageDialog from '@/components/systemManage/BlacklistManageDialog.vue'

@Component({
  components: {
    BlacklistManageDialog
  }
})
export default class BlacklistManage extends Vue {
  private formData = {} as any
  private centerDialogVisible = false
  private fileSuffixXls = ['xlsx', 'xls']
  private ids: Array<number> = []
  private tableData = [] as any
  private dialogShow = false
  private wholeTitle = ''
  private pageInfo = {
    pageSize: 15,
    pageNum: 1,
    total: 0
  }
  
  get formColumns () {
    return [
      {
        label: '手机号：',
        prop: 'content',
        el: 'input',
        placeholder: '请输入',
        span: 6
      },
      {
        prop: 'btn',
        span: 6,
        labelWidth: '0',
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
        label: '手机号',
        prop: 'content'
      },
      {
        label: '发送时间',
        prop: 'createTime'
      },
      {
        label: '备注',
        prop: 'remark'
      },
      {
        label: '操作',
        prop: 'btn'
      }
    ]
  }

  created () {
    this.getList()
  }

  getList () {
    // TODO
    const { pageSize, pageNum } = this.pageInfo
    const params = {
      current: pageNum,
      size: pageSize,
      content: this.formData.content
    }
    this.$api.getBlacklistPage(params).then(res => {
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

  importExcel () {
    // TODO
  }

  importDialog () {
    this.dialogShow = true
  }

  cancelNums () {
    // TODO
    this.centerDialogVisible = true
  }

  selectChange (arr: any) {
    this.ids = []
    // 处理ids展示批量删除
    this.ids = arr.map((item: any) => (item.id))
  }

  pageChange (pageInfo: PageInfo) {
    this.pageInfo = pageInfo
    this.getList()
  }

  cancelBlackout (item: any) {
    // TODO
    this.ids = []
    this.centerDialogVisible = true
    this.ids.push(item.id)
  }

  cancelDialog () {
    // TODO
    const params = [
      ...this.ids
    ]
    this.$api.deleteBlacklist(params).then(res => {
      if (res === true || res !== null) {
        this.centerDialogVisible = false
        this.$message.success('取消拉黑成功')
        this.ids = []
        this.getList()
      }
    })
  }

  closeDialog () {
    this.dialogShow = false
    this.getList()
  }
}
</script>

<style lang="scss" scoped>
  .blacklistManage {
    .list-block {
      margin-bottom: 20px;
      .icon-sign {
        margin-right: 6px;
        /deep/ .el-button--small, .el-button--small.is-round {
          padding: 8px 20px!important;
        }
      }
    }
    .list {
      margin-bottom: 10px;
    }
    .btn-img {
      img {
        width: 18px;
        height: 18px;
        margin-right: 10px;
      }
    }

    /deep/ .el-dialog {
      border-radius: 10px;
    }
    .diaLog-span {
      display: block;
      width: 100%;
      font-size: 20px;
      font-family: PingFangSC, PingFangSC-Semibold;
      font-weight: 600;
      text-align: center;
      color: #333333;
      line-height: 28px;
    }
    .dialog-footer {
      .btn-sty {
        margin-right: 30px;
        margin-bottom: 30px;
        padding: 10px 20px;
      }
    }

    /deep/ .el-checkbox__input.is-checked .el-checkbox__inner, /deep/ .el-checkbox__input.is-indeterminate .el-checkbox__inner {
      background-color: rgba(11,178,144,1);
      border-color:rgba(11,178,144,1);
    }

    /deep/ .el-checkbox__inner:hover {
      border-color: rgba(11,178,144,1);
    }

    .dia-black {
      // 弹框按钮样式迭代
      // 朴素按钮样式迭代
      // hover
      /deep/ .el-button:first-child:hover {
        color: rgba(11,178,144,1);
        border-color: rgba(11,178,144,1);
      }
      /deep/ .el-button:first-child:focus {
        color: rgba(11,178,144,1);
        border-color: rgba(11,178,144,1);
      }
    }
  }
</style>