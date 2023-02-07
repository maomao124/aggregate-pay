<template>
  <el-dialog title="新增成员" :visible.sync="syncDialogVisible" @open="opend">
    <el-form :inline="false">
      <el-form-item label="手机号：" :label-width="formLabelWidth" :rules="[{required:true}]">
        <el-input v-model="form.mobile"></el-input>
      </el-form-item >

      <el-form-item label="密码：" :label-width="formLabelWidth" :rules="[{required:true}]">
        <el-input v-model="form.password"></el-input>
      </el-form-item>

      <el-form-item label="用户名：" :label-width="formLabelWidth" :rules="[{required:true}]">
        <el-input v-model="form.username"></el-input>
      </el-form-item>
      <el-form-item label="姓名：" :label-width="formLabelWidth">
        <el-input v-model="form.fullname"></el-input>
      </el-form-item>
      <el-form-item label="职位：" :label-width="formLabelWidth">
        <el-input v-model="form.position"></el-input>
      </el-form-item>
      <el-form-item label="归属门店" :rules="[{required:true}]" >
          <el-select v-model="form.storeId" placeholder="请选择">
                <el-option
                v-for="item in storeList"
                :key="item.id"
                :label="item.storeName"
                :value="item.id">
                </el-option>
            </el-select>
      </el-form-item >
        <el-form-item label="角色：" :rules="[{required:true}]">
          <el-select v-model="rolecode" multiple placeholder="请选择">
                <el-option
                v-for="item in roleList"
                :key="item.id"
                :label="item.name"
                :value="item.code">
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
import { createMember,getStoresData,getRole } from '@/api/organization.ts'
import { getRolesList } from '@/api/system.ts'
@Component({
  components:{ 
  }
})
export default class  extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean
  private form = {
      mobile:'',
      password:'',
      username:'',
      storeId:'',
      fullname:'',
      position:''
  }
  private memberFrom = {
    username:''
  }
  private memberList:any[] = []
  private roleList:any[] = []
  private storeList:any[] = []
  private rolecode:any[] = []
  // private async getList () {
  //   let data = await getStoresData(1,10)
  //   this.memberList = data.items
  // }
  private opend () {
    this.getList()
  }

  private async getList () {
    this.roleList= await getRole()
    let datas = await getStoresData(1,10,this.memberFrom)
    this.storeList = datas.items;
  }
  private async ensureDialog () {
    if (this.form.username === '' || this.form.mobile === '' || this.form.password === '' || this.form.storeId === '' || this.rolecode === []) {
      this.$message.error('必填项不能为空')
    }
    let res = await createMember(this.form,this.rolecode)
    this.syncDialogVisible = false;
    this.$message.success('添加成功')
    this.form.mobile = ''
    this.form.password = ''
    this.form.username = ''
    this.form.storeId = ''
    this.rolecode = []
  }
}
</script>
