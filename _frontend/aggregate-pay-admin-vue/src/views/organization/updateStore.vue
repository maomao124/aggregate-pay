<template>
  <el-dialog title="修改门店信息" :visible.sync="syncDialogVisible" @open="opend">
    <el-form :inline="false">
      <el-form-item label="门店名称：" :label-width="formLabelWidth" :rules="[{required:true}]">
        <el-input v-model="form.storeName"></el-input>
      </el-form-item >

      <el-form-item label="门店地址：" :label-width="formLabelWidth">
        <el-input v-model="form.storeAddress"></el-input>
      </el-form-item>

      <el-form-item label="门店编号：" :label-width="formLabelWidth">
        <el-input v-model="form.storeNumber"></el-input>
      </el-form-item>

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
import { updateStore, getStoresData} from '@/api/organization.ts'
@Component({
  components:{
    
  }
})
export default class createTasks extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean
  @PropSync('storeIds',{type:String})
  storeId!:string
  private form = {
      storeAddress:'',
      storeName:'',
      storeNumber:0,
      parentId:0,
      storeStatus:'',
      merchantId:0

  }
  private storeForm = {
    storeNumber:'',
    storeName:''
  }
  private listData:any [] = []
  private filterData:any [] = []
  private opend () {
    this.getList()
  }
  private async getList () {
    let ret = await getStoresData(1,10,this.storeForm)
    this.listData = ret.items
    this.filterData = this.listData.filter((item:any) => {
      return this.storeId == item.id
    })

    this.form.storeName = this.filterData[0].storeName
    this.form.storeAddress = this.filterData[0].storeAddress
    this.form.storeNumber = this.filterData[0].storeNumber

  }
  private async ensureDialog () {
    let res = await updateStore(this.form)
    this.syncDialogVisible = false;
    this.$message.success('修改成功')
  }
}
</script>
