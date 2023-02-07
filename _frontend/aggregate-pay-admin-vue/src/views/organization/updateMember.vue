<template>
  <el-dialog title="新增成员" :visible.sync="syncDialogVisible" @open="opend">
    <el-form :inline="false">
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
import {updateMember,getMemberData,getStoresData,getRole } from '@/api/organization.ts'
@Component({
  components:{ 
  }
})
export default class  extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean
  @PropSync('memberIds',{type:String})
  memberId!:string
  private form = {
      fullname:'',
      position:'',
      storeId:''
  }
  private rolecode:any[] = []
  private listData: any [] = []
  private filterData: any [] = []
  private roleList:any[] = []
  private storeList:any[] = []
  private opend () {
    this.getList()
  }
  private memberFrom = {
    username:''
  }
  private async getList () {
    let res = await getMemberData(1,10,this.memberFrom)
    this.listData = res.items
    this.filterData = this.listData.filter((item:any) => {
      return this.memberId == item.id
    })
    this.roleList= await getRole()
    let datas = await getStoresData(1,10,this.memberFrom)
    this.storeList = datas.items;
    this.form.fullname = this.filterData[0].fullname
    this.form.position = this.filterData[0].position
  
  }
  private async ensureDialog () {
    if(this.form.storeId === '' || this.rolecode === []) {
      this.$message.error('必填项不能为空');return;
    }
    let res = await updateMember(this.form,this.rolecode)
  }
}
</script>
