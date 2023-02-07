<template>
  <div class="start-container">
      <h2>开启支付</h2>
      <el-row type="flex" justify="end" class="add">
    </el-row>
      <p>您好，如果您已正确配置支付参数，可以使用以下服务类型开启支付，请选择：</p>
      <el-button type="primary" size="medium" @click="openSkuDialog" id="addBtn">设置默认支付方式</el-button>
      <div class="content">
        <el-form ref="form" :model="form" label-width="140px">
        <el-form-item label="商品详情">
            <el-input placeholder="请输入商品详情" v-model="form.body"></el-input>
        </el-form-item>
        <el-form-item label="商品金额">
            <el-input placeholder="请输入金额" v-model="form.totalAmount" type="number" @input="BlurText"></el-input>
        </el-form-item>
    </el-form>
        <div class="stepOne">
            <p class="center">
              <img src="../../../public/img/ctob.png" alt="" v-if="!isCode"  class="imgs">
              <img :src="codes " alt="" v-if="isCode" class="imgs2">
            </p>
            <p>C扫B</p>
            <el-button type="primary" @click="cTob">生成门店二维码</el-button>
        </div>
        <div class="stepOne">
            <p class="center">
              <img src="../../../public/img/btoc.png" alt="" class="imgs">
            </p>
            <p>B扫C</p>
            <el-button type="primary" @click="bToc">下单开启扫码</el-button>
        </div>
      </div>
              
      <setMo :dialogVisible.sync="dialogVisible" @getAppId="getAppIds" @getStoreId="getStoreIds"></setMo>
      <cTob :dialogVisible.sync="dialogVisible1"  :code="codes"></cTob>
      <!-- <bToc :dialogVisible.sync="dialogVisible2"></bToc> -->
      <Scan :visible.sync="dialogVisible2"  @close-dialogStatus="Close_dialog"></Scan>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from 'vue-property-decorator'
import { Route } from 'vue-router'
import { Dictionary } from 'vuex'
import { login } from '@/api/users'
import { Form as ElForm, Input } from 'element-ui'
import { UserModule } from '@/store/modules/user'
import setMo from '@/views/pay/setMo.vue'
import bToc from '@/views/pay/bToc.vue'
import cTob from '@/views/pay/cTob.vue'
import {Message} from 'element-ui'
import { getStoresDataCode } from '@/api/pay.ts'
import Scan from '@/views/pay/scan.vue'
@Component({
  components: {
    setMo,
    cTob,
    bToc,
    Scan
  }
})
export default class extends Vue {

  private dialogVisible:boolean = false;
  private dialogVisible1:boolean = false;
  private dialogVisible2:boolean = false;
  private isCode:boolean = false;
  private appId:string = ''
  private storeId:string = ''
  private codes:string = ''
  private form = {
    totalAmount: '',
    body:''
    
  }
  private openSkuDialog () {
    this.dialogVisible = true;
  }
  private Close_dialog () {
    this.dialogVisible2 = false;
  }
  private BlurText(e:any) {
    if(Number(e) <0) {
      this.$message.warning('不能输入负数')
      this.form.totalAmount = ''
    }
  }
  private async cTob () {
    this.appId = localStorage.getItem('appId')!
    this.storeId = localStorage.getItem('storeId')!
    if (this.appId == null || this.storeId == null) {
      this.$message.error('请设置默认支付方式')
      return
    }
    if(this.form.body =='' || this.form.totalAmount == '') {
      this.$message({
          type: 'error',
          message: '必填项不能为空!'
      });
      // if (this.form.totalAmount) {
      //   this.$message({
      //     type: 'error',
      //     message: '必填项不能为空!'
      // });
      // }
      return;
    }
    this.isCode = true;
    this.codes =  await getStoresDataCode(this.appId,this.storeId,this.form.body,this.form.totalAmount)


  }

  private bToc () {
    this.dialogVisible2 = true;
  }

  private getAppIds (value:any) {
    this.appId = value;
  }
  private getStoreIds (value:any) {
    this.storeId = value;
  } 

}
</script>

<style lang="scss">
  .start-container {
    width: 1200px;
    margin: 00 auto;
    padding: 42px 44px;
    background: white;
    height: 1000px;
  }

  .content {
    margin-top: 20px;
    &>p {
      font-size: 14px;
      color: #303133;
      line-height: 40px;
    }
    input {
      width: 100%;
    }
    .el-form {
      width: 35%;
      margin: 0 auto;
    }
    .stepOne {
      float: left;
      width: 250px;                                                                                                                                                                      
      text-align: center;
      margin-left: 240px;
      margin-top: 50px;

      p {
        font-size: 14px;
        color: #909399;
        margin-top: 70px;
      }

      h4 {
        margin-top: 20px;
      }

      .center {
          margin-top: 20px;
          margin-left: 40px;
          width: 182px;
          height: 191px;
          background: #ECF5FF;
          .imgs {
            margin-top: 40px;
          }
      }
    }
  }
</style>

<style lang="scss" scoped>

</style>
