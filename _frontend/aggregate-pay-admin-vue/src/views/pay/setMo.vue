<template>
  <el-dialog title="支付设置" :visible.sync="syncDialogVisible" @open="opend">
    <el-form :inline="false">
      <el-form-item label="默认应用：">
          <el-select v-model="appId" placeholder="请选择">
            <el-option
                v-for="item in list"
                :key="item.appId"
                :label="item.appName"
                :value="item.appId">
                </el-option>
            </el-select>
      </el-form-item >

    <el-form-item label="默认门店：" >
          <el-select v-model="storeId" placeholder="请选择">
                <el-option
                v-for="item in storeList"
                :key="item.id"
                :label="item.storeName"
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
import { getAppList } from '@/api/pay.ts'
import { getStoresData} from '@/api/organization.ts'
@Component({
  components:{ 
  }
})
export default class  extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean
  private pageNo:number = 1;
  private pageSize:number = 10;
  private appId:string = ''
  private storeId: string = ''
  private list = []
  private storeList = []
  private storeForm = {
    storeName:'',
    storeNumber:''
  }
  created () {
      
      
  }

  opend () {
      this.getList()
  }
  private async getList () {
      this.list = await getAppList()
      let data = await getStoresData(this.pageNo,this.pageSize,this.storeForm)
      console.log(data)
      this.storeList = data.items
 
      
  }
  private ensureDialog () {
      localStorage.setItem('appId',this.appId)
      localStorage.setItem('storeId',this.storeId)
      console.log(this.appId)
      this.syncDialogVisible = false;
      this.$emit('getAppId',this.appId)
      this.$emit('getStoreId',this.storeId)
   
  }
}
</script>
