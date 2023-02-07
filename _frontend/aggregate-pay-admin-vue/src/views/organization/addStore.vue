<template>
  <el-dialog title="新增门店" :visible.sync="syncDialogVisible" @open="opend">
    <el-form :inline="false">
      <el-form-item label="门店名称：" :label-width="formLabelWidth" :rules="[{required:true}]">
        <el-input v-model="form.storeName"></el-input>
      </el-form-item >

      <el-form-item label="门店地址：" :label-width="formLabelWidth"  :rules="[{required:true}]">
        <el-input v-model="form.storeAddress"></el-input>
      </el-form-item>

      <el-form-item label="门店编号：" :label-width="formLabelWidth"  :rules="[{required:true}]">
        <el-input v-model="form.storeNumber"></el-input>
      </el-form-item>
          <el-form-item label="管理员：" :rules="[{required:true}]">
          <el-select v-model="list" multiple placeholder="请选择">
                <el-option
                v-for="item in memberList"
                :key="item.id"
                :label="item.username"
                :value="item.id">
                </el-option>
            </el-select>
      </el-form-item >
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="syncDialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="ensureDialog">确 定</el-button>
    </div>
    
  </el-dialog>
</template>

<script lang="ts">
import { Component, Vue, PropSync, Emit, Prop } from 'vue-property-decorator'
import { Message } from 'element-ui'
import { constants } from 'fs';
import { createStore,getMemberData } from '@/api/organization.ts'
import { getAdminList} from '@/api/system.ts'
@Component({
  components:{
    
  }
})
export default class createTasks extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean
  private form = {
      storeAddress:'',
      storeName:'',
      storeNumber:0,
      parentId:0,
      storeStatus:'',
      merchantId:0

  }
  private storeFrom = {
    storeName:'',
    storeNumber:''
  }
  private memberList:any[] = []
  private list:any[] = []
  created () {
    
  }
  opend () {
    this.getList()
  }
  private async  getList () {
    let data = await getMemberData(1,10,this.storeFrom)
    this.memberList = data.items
  }
  private async ensureDialog () {
    if (this.form.storeAddress === '' || this.form.storeName === '' || this.list == []) {
      this.$message.error('必填项不能为空')
    } 
    let res = createStore(this.form,this.list)
    this.syncDialogVisible = false;
    this.$message.success('创建成功')
  }
}
</script>
