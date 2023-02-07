<template>
  <el-dialog :visible.sync="syncDialogVisible" @open="opend">
    <h3>C扫B调用成功</h3>
    <img :src="codes" alt="">
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
import { getStoresDataCode } from '@/api/pay.ts'
@Component({
  components:{ 
  }
})
export default class  extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean

  @PropSync('code', { type: String })
  codes!: string
  private pageNo:number = 1;
  private pageSize:number = 10;
  private appId:number = 0
  private storeId: number = 0
  private form = {
      mobile:'',
      password:'',
      storeId:0
  }

  private list = []
  private storeList = []
  created () {
      this.getList()
      
      
  }
//   private makeQRCode() {
//     QRCode.toDataURL("http://aaa.vv.com/erp/card?authkey="+this.companyId).then(imgData => {
//         if(imgData) {
//             let file = this.convertBase64UrlToBlob(imgData);
//             // 上传到服务器（这里是上传到阿里云，this.oss是直接把阿里云的oss连接作为Vue对象的属性来调用,put是上传文件的方法）
//             this.oss.put('qrcode' + Math.random()*10 + '.png', file).then(result => {
//                  this.qrcode = result.url; // 将已上传的图片的url赋值给img的src
//                  alert('生成成功')
//             })
//         }
//     });
// }
//   private convertBase64UrlToBlob(urlData:any) {
//     let bytes = window.atob(urlData.split(',')[1]); //去掉url的头，并转换为byte
//     //处理异常,将ascii码小于0的转换为大于0
//     let ab = new ArrayBuffer(bytes.length);
//     let ia = new Uint8Array(ab);
//     for (let i = 0; i < bytes.length; i++) {
//         ia[i] = bytes.charCodeAt(i);
//     }
//     return new Blob([ab] , {type : 'image/png'});
// }
  private async opend () {
    console.log(this.codes)
  }
  private async getList () {
     
  }
  private ensureDialog () {
      this.syncDialogVisible = false;
      
  }
}
</script>
