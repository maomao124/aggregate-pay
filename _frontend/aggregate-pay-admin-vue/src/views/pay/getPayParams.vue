<template>
  <el-dialog :visible.sync="syncDialogVisible" @open="opend">
    <el-form :inline="false">
      <el-form-item label="客户ID：" >
        <span>{{data.clientId}}</span>
      </el-form-item >

      <el-form-item label="客户端秘钥：" >
        <span>{{data.clientSecret}}</span>
      </el-form-item>

      <el-form-item label="闪聚平台公钥：" >
        <span>{{data.platformPublickey}}</span>
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
import { getAppList } from '@/api/pay.ts'
import { getStoresData} from '@/api/organization.ts'
import { getPayParams } from '@/api/pay.ts'
@Component({
  components:{ 
  }
})
export default class  extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean

   @PropSync('appId', { type: String })
    appIds!: string
  private pageNo:number = 1;
  private pageSize:number = 10;
  private storeId: number = 0
  private data = {}
  created () {
      this.getList()
      
  }

  private async opend () {
    let res = await getPayParams(this.appIds)
    this.data = res
  }
  private async getList () {
     
  }
  private ensureDialog () {
      this.syncDialogVisible = false;
      
  }
}
</script>
