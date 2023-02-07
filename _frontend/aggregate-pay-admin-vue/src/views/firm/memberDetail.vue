<template>
  <el-dialog title="基本信息" :visible.sync="syncDialogVisible" @open="open">
    <el-form :inline="false">
      <el-form-item label="姓名：" :label-width="formLabelWidth">
        <span>{{list.fullName}}</span>
      </el-form-item >

      <el-form-item label="最后一次登录时间" :label-width="formLabelWidth">
        <span>{{list.lastLoginTime}}</span>
      </el-form-item>

      <el-form-item label="手机号：" :label-width="formLabelWidth">
        <span>{{list.mobile}}</span>
      </el-form-item>
      <el-form-item label="职位	：" :label-width="formLabelWidth">
        <span>{{list.position}}</span>
      </el-form-item>
      <el-form-item label="用户名:" :label-width="formLabelWidth">
        <span>{{list.username}}</span>
      </el-form-item>
      <el-form-item label="联系人地址：" :label-width="formLabelWidth">
        <span v-if="list.staffStatus">启用</span>
        <span v-if="!list.staffStatus">禁用</span>
      </el-form-item>
      <el-form-item label="密码：:" :label-width="formLabelWidth">
        <span>{{list.password}}</span>
      </el-form-item>

    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="ensureDialog">确 定</el-button>
    </div>
    
  </el-dialog>
</template>

<script lang="ts">
import { Component, Vue, PropSync, Emit, Prop } from 'vue-property-decorator'
import { Message } from 'element-ui'
import { constants } from 'fs';
import { SearchMsg } from '@/api/firm.ts'
@Component({
  components:{
    
  }
})
export default class createTasks extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean

  @PropSync('memberId', { type: Number })
    memberIds!: number
  private form = {
      storeAddress:'',
      storeName:'',
      storeNumber:0,
      parentId:0,
      storeStatus:'',
      merchantId:0

  }
  private list = {}


  private open () {
    

    this.getMsgFromMers()
  }

  private async getMsgFromMers () {
    this.list = await SearchMsg(this.memberIds)
  }
  private ensureDialog () {
    this.syncDialogVisible = false;
  }
}
</script>
