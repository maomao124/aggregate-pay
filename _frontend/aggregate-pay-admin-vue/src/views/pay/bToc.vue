<template>
  <el-dialog title="支付设置" :visible.sync="syncDialogVisible" @open="opend">
    <h3>B扫C调用成功</h3>
    <p>调用摄像头/采集设备成功</p>
    <div slot="footer" class="dialog-footer">
      <el-button type="primary" @click="ensureDialog">开始扫描</el-button>
    </div>
    <Scan :visible.sync="dialogVisibles"></Scan>
  </el-dialog>
</template>

<script lang="ts">
import { Component, Vue, PropSync, Emit, Prop } from 'vue-property-decorator'
import { Message } from 'element-ui'
import { constants } from 'fs';
import { getAppList } from '@/api/pay.ts'
import { getStoresData} from '@/api/organization.ts'
import { BscanC } from '@/api/pay.ts'
import Scan from '@/views/pay/scan.vue'
@Component({
  components:{ 
    Scan
  }
})
export default class  extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean
  private pageNo:number = 1;
  private pageSize:number = 10;
  private appId:number = 0
  private storeId: number = 0
  private dialogVisibles:boolean = false;
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
      // let res = await BscanC(this.form)
  }
  private async getList () {
     
  }
  private ensureDialog () {
    this.dialogVisibles = true;
    this.syncDialogVisible = false;
      
  }
}
</script>
