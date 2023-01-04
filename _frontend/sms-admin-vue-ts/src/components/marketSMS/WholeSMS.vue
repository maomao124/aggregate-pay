<template>
  <div class="whole-SMS">
    <div class="search">
      <m-form :formData="formData" :columns="formColumns"></m-form>
    </div>
    <div class="add list">
      <el-button type="primary" style="margin-right: 26px;" @click="addWholeSMS('add')">
        <i class="el-icon-circle-plus-outline icon-sign"></i>
        新建短信
      </el-button>
      <el-button @click="getRecords" class="delete">
        <i class="menuicon iconfont icon-lishi" style="vertical-align: top;"></i>
        历史记录
      </el-button>
    </div>
    <m-table :tableData="tableData" :columns="tableColumns" @pageChange="pageChange" :page="pageInfo" :stripe="true" :border="false" layout="total, prev, pager, next, jumper">
      <div slot="btn" slot-scope="{row}">
        <div>
          <!-- 查看 -->
          <el-tooltip class="item" effect="dark" content="点击查看" placement="top">
            <el-button class="btn-img" type="text" @click="getItemObj(row)"><img src="@/assets/marketSMS/chakan.png" alt="" /></el-button>
          </el-tooltip>
          <!-- 通过 -->
          <el-tooltip class="item" effect="dark" content="点击通过" placement="top" v-if="toggleAdoptState(row)">
            <el-button class="btn-img" type="text" @click="adoptOrRefuseOrdel('adopt', row)"><img src="@/assets/marketSMS/tongguo.png" alt="" /></el-button>
          </el-tooltip>
          <!-- 拒绝 -->
          <el-tooltip class="item" effect="dark" content="点击拒绝" placement="top" v-if="toggleRefuse(row)">
            <el-button class="btn-img" type="text" @click="adoptOrRefuseOrdel('refuse', row)"><img src="@/assets/marketSMS/jujue.png" alt="" /></el-button>
          </el-tooltip>
          <!-- 修改 -->
          <el-tooltip class="item" effect="dark" content="点击修改" placement="top" v-if="toggleEdit(row)">
            <el-button :disabled="row.type === 1" class="btn-img" type="text" @click="addWholeSMS('edit', row)"><img src="@/assets/marketSMS/xiugai.png" alt="" /></el-button>
          </el-tooltip>
          <!-- 删除 -->
          <el-tooltip class="item" effect="dark" content="点击删除" placement="top">
            <el-button class="btn-img" type="text" @click="adoptOrRefuseOrdel('delete', row)"><img src="@/assets/marketSMS/shanchu.png" alt="" /></el-button>
          </el-tooltip>
        </div>
      </div>
    </m-table>
    <!-- 新增和修改 -->
    <WholeSMSDialog :dialogShow="dialogShow" :title="wholeTitle" @closeDialog="closeDialog" :dialogData="sendWholeDiaData" />
    <!-- 弹框动作 -->
    <el-dialog :visible.sync="centerDialogVisible" :width="diaTypeInfo === '确认通过?' ? '371px' : '322px'" center :show-close="false" top="22vh" class="dia-whole">
      <span class="diaLog-span" style="text-align:center;">{{diaTypeInfo}}</span>
      <p v-if="diaTypeInfo === '确认通过?'">确认后该信息将直接发送，并且不 可撤回，确认通过吗？</p>
      <span slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisible = false" class="btn-sty">取 消</el-button>
        <el-button type="primary" @click="deteleWholeDialog" style="padding: 10px 20px;">确 定</el-button>
      </span>
    </el-dialog>
    <!-- 短信详情 -->
    <el-dialog title="短信详情" :visible.sync="dialogVisible" width="660px" top="22vh">
      <m-form :formData="formInfoData" :columns="formInfoColums" />
      <span slot="footer">
        <el-button type="primary" @click="dialogVisible = false" style="text-align:center;">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator'
import WholeSMSDialog from './WholeSMSDialog.vue'
import { PageInfo } from '@/types/index'
import { getList } from '@/api/ajax'

@Component({
  components: {
    WholeSMSDialog
  }
})
export default class WholeSMS extends Vue {
  static componentName = 'WholeSMS'

  @Prop([Number]) tabsIndex!: number

  private formData = {} as any
  private formInfoData = {}
  private centerDialogVisible = false
  private dialogVisible = false
  private wholeTitle = '新建短信'
  private sendWholeDiaData = {}
  private diaTypeInfo = '确认删除?'
  private dialogShow =  false
  private pageInfo = {
    pageSize: 15,
    pageNum: 1,
    total: 0
  }
  private idsObj = {} as any
  private tableData = [] as any

  get formColumns () {
    return [
      {
        label: '提交时间：',
        prop: 'dateArr',
        el: 'date-picker',
        type: 'daterange',
        span: 6,
        'prefix-icon': ''
      },
      {
        label: '主题名称：',
        prop: 'title',
        span: 6,
        placeholder: '请输入',
        labelWidth: '120px',
        el: 'input'
      },
      {
        label: '申请人：',
        prop: 'createUserName',
        span: 6,
        placeholder: '请输入',
        labelWidth: '120px',
        el: 'input'
      },
      {
        prop: 'btn',
        span: 6,
        align: 'left',
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
        prop: 'createTime',
        align: 'left'
      },
      {
        label: '主题',
        prop: 'title',
        align: 'left'
      },
      {
        label: '短信内容',
        prop: 'contentText',
        'show-overflow-tooltip': true,
        align: 'left',
        width: 260
      },
      {
        label: '申请人',
        prop: 'createUserName',
        align: 'left'
      },
      {
        label: '状态',
        prop: 'status',
        format (obj: any) {
          switch (obj.status) {
            case 0: return '待审核'
            case 1: return '通过'
            case 2: return '驳回'
          }
        },
        align: 'left'
      },
      {
        prop: 'btn',
        label: '操作',
        align: 'left'
      }
    ]
  }

  get formInfoColums () {
    return [
      {
        label: '主题：',
        prop: 'title',
        span: 22
      },
      {
        label: '内容：',
        prop: 'contentText',
        span: 22
      },
      {
        label: '申请人：',
        prop: 'createUserName',
        span: 22
      },
      {
        label: '提交时间:',
        prop: 'createTime',
        span: 22
      }
    ]
  }

  toggleAdoptState (row: any) {
    if (row.status === 0) {
      // TODO
      return true
    } else if (row.status === 1) {
      return false
    } else if (row.status === 2) {
      return false
    } else {
      return true
    }
  }

  toggleRefuse (row: any) {
    if (row.status === 1) {
      return false
    } else if (row.status === 2) {
       return false
    } else {
      return true
    }
  }

  toggleEdit (row: any) {
    if (row.status === 0) {
      return false
    } else if (row.status === 1) {
      return false
    } else if (row.status === 2) {
       return true
    } else {
      return true
    }
  }

  @Watch('tabsIndex', { immediate: true })
  getNewTabsIndex () {
    this.getList()
  }

  getList () {
    // tabsIndex 0通过 1审核中 2已拒绝 3已通过
    const { pageSize, pageNum } = this.pageInfo
    const params = {
      current: pageNum,
      size: pageSize,
      title: this.formData.title,
      createUserName: this.formData.createUserName,
      startCreateTime: this.formData.dateArr ? this.formData.dateArr[0] : null,
      endCreateTime: this.formData.dateArr ? this.formData.dateArr[1] : null,
      status: this.tabsIndex === 0 ? '' : this.tabsIndex === 1 ? 0 : this.tabsIndex === 2 ? 2 : 1
    }
    this.$api.getMarketingPage(params).then(res => {
      if (res && res.records !== null) {
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

  // 详情接口
  getItemObj (obj: any) {
    this.dialogVisible = true
    getList(`/api/marketing/${obj.id}`).then((res: any) => {
      if (res) {
        this.formInfoData = {
          ...res
        }
      }
    })
  }

  addWholeSMS (type: string, item?: any) {
    this.dialogShow = true
    this.wholeTitle = type === 'add' ? '新建短信' : '修改短信'
    this.sendWholeDiaData = {
      ...(item || {})
    }
  }
  
  deteleWholeDialog () {
    // 弹框动作
    // 审核短信
    let arcoss = 0
    this.diaTypeInfo === '确认通过?' ? arcoss = 1 : arcoss = 2
    this.diaTypeInfo !== '确认删除?' && this.$api.examineMarketingAudit({ status: arcoss, id: this.idsObj.id }).then(() => {
      this.$message.success(`${this.diaTypeInfo.slice(this.diaTypeInfo.length - 3, 4)}成功`)
      this.centerDialogVisible = false
      this.getList()
    })
    // 删除短信
    const ids = [ this.idsObj.id ]
    this.diaTypeInfo === '确认删除?' && this.$api.deleteMarketing(ids).then(res => {
      if (res === true || res !== null) {
        this.$message.success('删除成功')
        this.centerDialogVisible = false
        this.getList()
      }
    })
  }

  adoptOrRefuseOrdel (type: string, item: any) {
    this.idsObj = {}
    this.diaTypeInfo = type === 'delete' ? '确认删除?' : type === 'refuse' ? '确认拒绝?' : '确认通过?'
    this.centerDialogVisible = true
    this.idsObj = {
      ...item
    }
  }

  closeDialog () {
    this.dialogShow = false
    this.getList()
  }

  getRecords () {
    this.$router.push({ path: '/businessStatist/MarketSMSStatist', query: { type: '营销' } })
  }

}
</script>

<style lang="scss" scoped>
  .whole-SMS {
    .add {
      margin-bottom: 20px;
    }
    .active {
      color: #0bb290;
      font-weight: 600;
    }
    .activeFile {
      color: #ff5a5a;
      font-weight: 600;
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
    p {
      margin-left: 40px;
      width: 240px;
      height: 56px;
      font-size: 16px;
      font-family: PingFangSC, PingFangSC-Light;
      font-weight: 400;
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
    /deep/ .el-dialog__footer {
      text-align: center;
    }


    .dia-whole {
      // 弹框按钮样式迭代
      // 朴素按钮样式迭代
      // hover
      // /deep/ .el-button:first-child:hover {
      //   color: rgba(11,178,144,1);
      //   border-color: rgba(11,178,144,1);
      // }
      // /deep/ .el-button:first-child:focus {
      //   color: rgba(11,178,144,1);
      //   border-color: rgba(11,178,144,1);
      // }
    }


    // 日期框颜色覆盖
    /deep/ .el-range-editor.is-active, .el-range-editor.is-active:hover {
      border-color: rgba(11,178,144,1);
    }
  }
</style>