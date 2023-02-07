<template>
  <el-dialog title="" :visible.sync="syncDialogVisible" @open="opend" width="250px">
    <img :src="codes" alt="">
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="ensureDialog">确定</el-button>
    </div>
    
  </el-dialog>
</template>

<script lang="ts">
import { Component, Vue, PropSync, Emit, Prop } from 'vue-property-decorator'
import { Message } from 'element-ui'
import { constants } from 'fs';
import { getAppList } from '@/api/pay.ts'
import { getStoresData} from '@/api/organization.ts'
import { BscanC } from '@/api/pay.ts'
@Component({
  components:{ 
  }
})
export default class  extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean
  @PropSync('code',{type:String})
  codes!:string
  private pageNo:number = 1;
  private pageSize:number = 10;
  private appId:number = 0
  private storeId: number = 0
  private form = {
      appId	:'',
      authCode:'',
      subject:'',
      totalAmount:0
  }

  private list = []
  private storeList = []
  created () {
      this.getList()
      
  }

  private async opend () {
     
  }
  private async getList () {
     
  }
  private ensureDialog () {
      this.syncDialogVisible = false;
      
  }
}
</script>
