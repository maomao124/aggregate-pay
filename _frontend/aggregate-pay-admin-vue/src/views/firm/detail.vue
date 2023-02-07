<template>
  <el-dialog title="基本信息" :visible.sync="syncDialogVisible" @open="open">
    <el-form :inline="false">
      <el-form-item label="企业名称：" :label-width="formLabelWidth">
        <span>{{list.merchantName}}</span>
      </el-form-item >

      <el-form-item label="企业编号" :label-width="formLabelWidth">
        <span>{{list.merchantNo}}</span>
      </el-form-item>

      <el-form-item label="企业地址：" :label-width="formLabelWidth">
        <span>{{list.merchantAddress}}</span>
      </el-form-item>
      <el-form-item label="行业类型	：" :label-width="formLabelWidth">
        <span>{{list.merchantType}}</span>
      </el-form-item>
      <el-form-item label="联系人:" :label-width="formLabelWidth">
        <span>{{list.username}}</span>
      </el-form-item>
      <el-form-item label="联系人地址：" :label-width="formLabelWidth">
        <span>{{list.contactsAddress}}</span>
      </el-form-item>
      <el-form-item label="手机号:" :label-width="formLabelWidth">
        <span>{{list.mobile}}</span>
      </el-form-item>

    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="passClick">通 过</el-button>
      <el-button type="danger" @click="rejectClick">驳 回</el-button>
    </div>
    
  </el-dialog>
</template>

<script lang="ts">
import { Component, Vue, PropSync, Emit, Prop } from 'vue-property-decorator'
import { Message } from 'element-ui'
import { constants } from 'fs';
import { getMsgFromMer,OneApprove } from '@/api/firm.ts'
@Component({
  components:{
    
  }
})
export default class createTasks extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean

  @PropSync('tenantId', { type: Number })
    tenantIds!: number

  private list = {}
  private open () {
    
    this.getMsgFromMers()
  }

  private async passClick () {
    let res = await OneApprove(2,this.tenantIds)

      if (!res) {
       Message({
        message: "通过失败",
        type: 'error',
        duration: 2 * 1000
      })
    } else {
       Message({
        message: "通过成功",
        type: 'info',
        duration: 2 * 1000
      })

      
    }
  }

  private async rejectClick () {
    let res = await OneApprove(3,this.tenantIds)

      if (!res) {
       Message({
        message: "驳回失败",
        type: 'error',
        duration: 2 * 1000
      })
    } else {
       Message({
        message: "驳回成功",
        type: 'info',
        duration: 2 * 1000
      })
  }

  }
  private async getMsgFromMers () {
    this.list = await getMsgFromMer(this.tenantIds)
  }
  private ensureDialog () {
    this.syncDialogVisible = false;
  }
}
</script>
