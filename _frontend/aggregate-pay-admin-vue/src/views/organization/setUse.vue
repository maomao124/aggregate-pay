<template>
  <el-dialog title="选择应用" :visible.sync="syncDialogVisible" @open="opend">
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
  created () {
      
  }

  opend () {
      this.getList()
  }
  private async getList () {
      this.list = await getAppList()
  }
  private ensureDialog () {
      this.syncDialogVisible = false;
      console.log(this.appId)
      this.$emit('getAppId',this.appId)
  }
}
</script>
