<template>
  <div class="pay-container">
    <h3>应用设置</h3>
    <el-steps :active="step" simple style="margin-top: 20px">
      <el-step title="基础信息" @click.native="goOne"></el-step>
      <el-step title="服务类型" @click.native="goTwo"></el-step>
      <el-step title="配置参数" @click.native="goThree"></el-step>
    </el-steps>
    <div class="oneStep" v-show="step === 0">
      <el-form ref="form" :model="forms" label-width="120px">
        <el-form-item label="应用名称：">
          <el-input placeholder="请输入应用名称" v-model="forms.appName"></el-input>
        </el-form-item>
        <el-form-item label="应用公钥：">
          <el-input placeholder="请输入应用公钥" v-model="forms.publicKey"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="save" round>保存</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div v-show="step === 1 && godeploy===true" class="twoStep">
      <el-table
        :data="serveList"
        fit
        border=""
        stripe
        highlight-current-row
        :header-cell-style="{color:'#5373e0',background:'#f3f6fb'}"
        style="width: 100%"
      >
        <el-table-column align="center" label="支付ID">
          <template slot-scope="scope">
            <span>{{scope.row.id}}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" label="支付名称">
          <template slot-scope="scope">
            <span>{{scope.row.channelName}}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" label="支付编码">
          <template slot-scope="scope">
            <span>{{scope.row.channelCode}}</span>
          </template>
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="300" align="center">
          <template slot-scope="scope">
            <el-button @click="startService(scope.row)" type="text" size="small" :disabled="scope.row.state">开启服务</el-button>
            <el-button @click="setRealParams(scope.row)" type="text" size="small" :disabled="!scope.row.state">配置实际支付渠道</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="threeStep" v-show="step === 2">
      <el-table
        :data="realList"
        fit
        border=""
        stripe
        highlight-current-row
        :header-cell-style="{color:'#5373e0',background:'#f3f6fb'}"
        style="width: 100%"
      >
        <el-table-column align="center" label="支付ID">
          <template slot-scope="scope">
            <span>{{scope.row.id}}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" label="支付名称">
          <template slot-scope="scope">
            <span>{{scope.row.channelName}}</span>
          </template>
        </el-table-column>
        <el-table-column align="center" label="支付编码">
          <template slot-scope="scope">
            <span>{{scope.row.channelCode}}</span>
          </template>
        </el-table-column>
        <el-table-column fixed="right" label="操作" width="150" align="center">
          <template slot-scope="scope">
            <el-button @click="setParam(scope.row)" type="text" size="small">配置参数</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="setParams">
        <el-form ref="form" :model="form" label-width="140px" v-show="!isWx && showParam">
          <el-form-item label="配置名称：" class="firstItem">
            <el-input placeholder="请输入配置名称" v-model="setName"></el-input>
            <el-select v-model="values" placeholder="调用配置" class="elSelect">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="支付宝公钥：">
            <el-input placeholder="请输入支付宝公钥" v-model="form.alipayPublicKey"></el-input>
          </el-form-item>
          <el-form-item label="APP私钥：">
            <el-input placeholder="请输入APP私钥" v-model="form.rsaPrivateKey"></el-input>
          </el-form-item>
          <el-form-item label="支付宝APPID：">
            <el-input placeholder="请输入支付宝APPID" v-model="form.appId"></el-input>
          </el-form-item>
          <el-form-item label="同步通知地址">
            <el-input placeholder="请输入同步通知地址" v-model="form.returnUrl"></el-input>
          </el-form-item>
          <el-form-item label="异步通知地址">
            <el-input placeholder="请输入异步通知地址" v-model="form.notifyUrl"></el-input>
          </el-form-item>
          <el-form-item class="btnParent">
            <el-button type="primary" @click="onSubmit" round class="btn">保存</el-button>
          </el-form-item>
        </el-form>
        <el-form ref="form" :model="wxform" label-width="140px" v-show="isWx && showParam">
          <el-form-item label="配置名称：" class="firstItem">
            <el-input placeholder="请输入配置名称" v-model="setNames"></el-input>
            <el-select v-model="values" placeholder="调用配置" class="elSelect">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="微信appId：">
            <el-input placeholder="请输入appId" v-model="wxform.appID"></el-input>
          </el-form-item>
          <el-form-item label="应用秘钥：">
            <el-input placeholder="请输入应用秘钥" v-model="wxform.appSecret"></el-input>
          </el-form-item>
          <el-form-item label="微信安全码Key：">
            <el-input placeholder="请输入安全码" v-model="wxform.key"></el-input>
          </el-form-item>
          <el-form-item label="异步通知地址：">
            <el-input placeholder="请输入同步通知地址" v-model="wxform.returnUrl"></el-input>
          </el-form-item>
          <el-form-item label="商户ID：">
            <el-input placeholder="请输入合作者PID" v-model="wxform.mchID"></el-input>
          </el-form-item>
          <el-form-item label="支付秘钥：">
            <el-input placeholder="请输入支付秘钥" v-model="wxform.payKey"></el-input>
          </el-form-item>
          <el-form-item class="btnParent">
            <el-button type="primary" @click="wxSubmit" round class="btn">保存</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
    <div v-show="step===3 && !open" class="openBox">
      <el-button @click="opens" type="danger">确认开启</el-button>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from "vue-property-decorator";
import { Route } from "vue-router";
import { Dictionary } from "vuex";
import { login } from "@/api/users";
import { Form as ElForm, Input } from "element-ui";
import { UserModule } from "@/store/modules/user";
import { setTimeout } from "timers";
import { Message } from 'element-ui'
import {
  createApp,
  getServiceType,
  getAllDealFromChannel,
  boundRoad,
  getAppList,
  updateApp,
  searchIsBindService
} from "@/api/pay.ts";
import {
  setParams,
  getAllPayChannel,
  getPayChannelFromPayCode,
  getPayChannelIncludeOnlyPayParams,
  updateRealPayParam
} from "@/api/channel.ts";
import Setparams from "@/views/pay/setParams.vue";
import { locales } from 'moment';

@Component({
  name: "set",
  components: {
    Setparams
  }
})
export default class extends Vue {
  private step: number = 0;
  private open: boolean = false;
  private setName: string = "";
  private setNames: string = "";
  private godeploy: boolean = true;
  private godeploys: boolean = false;
  private options: any[] = [
    {
      value: "选项1",
      label: "支付宝web"
    },
    {
      value: "选项2",
      label: "微信移动端"
    }
  ];
  private serveList: any[] = [];
  private filterData: any = [];
  private values: string = "";
  private dialogVisible: boolean = false;
  private realParam:boolean = false;
  private form = {
    appId: "",
    rsaPrivateKey: "",
    notifyUrl: "",
    returnUrl: "",
    url: "https://openapi.alipaydev.com/gateway.do",
    chareset: "UTF-8",
    format: "json",
    alipayPublicKey: "",
    signtype: "RSA2"
  };
  private wxform = {
    appID:'',
    appSecret:'',
    key:'',
    mchID: '',
    payKey: '',
    returnUrl: ''
  }
  private realList: any[] = [];
  private code: string = "";
  private appIds: string = "";
  private payCodes: any[] = [];
  private setParasData = {
    channelName: "",
    param: "",
    payChannel: "",
    platformChannelCode: "",
    appId:'',
    id:null
  };
  private forms  = {
    appName: "",
    publicKey:'',
    merchantId:'',
    notifyUrl:'',
    appId:''
  };
  private realForm = {
    appId:'',
    platformChannel:'',
    payChannel:''
  }
  private realParams = {}
  private isWx:boolean = false;
  private showParam:boolean = false;
  private paramId:string = ''
  private paramStep:string = ''
  private AllData: any[] = []
  private filterDatas: any[] = []
  private isB2c:boolean = false;
  private isC2b:boolean = false;
  created() {
    this.paramId = this.$route.params.id
    this.paramStep = this.$route.params.step
    this.step = Number(this.paramStep)
    if(this.paramId == '0') {
    } else {
      this.getAppLists()
      this.appIds = this.paramId
      this.getHigh()
      
    } 
  }
  private async getHigh () {
      let ret = await searchIsBindService(this.paramId,'shanju_b2c')
      if (ret === 0) {
        this.isB2c = false;
      } else {
        this.isB2c = true;
      }
      let rets = await searchIsBindService(this.paramId,'shanju_c2b')
      if (rets === 0) {
        this.isC2b = false;
      } else {
        this.isC2b = true;
      }
      this.serveList = await getAllPayChannel();
      this.serveList.forEach((item:any) => {
        if (item.channelCode === 'shanju_b2c') {
          item.state = this.isB2c;
        } else {
          item.state = this.isC2b;
        }
      });
  }
  private async getAppLists () {
    this.AllData = await getAppList()
    
    this.filterDatas = this.AllData.filter((item:any) => {
      return item.appId == this.paramId;
    });
    console.log(this.filterDatas)
    this.forms.appName = this.filterDatas[0].appName;
    this.forms.publicKey = this.filterDatas[0].publicKey;
    this.forms.appId = this.filterDatas[0].appId;
    this.forms.notifyUrl = this.filterDatas[0].notifyUrl;
    this.forms.merchantId = this.filterDatas[0].merchantId;
    
    this.$forceUpdate()
  }
  private async onSubmit() {
    this.setParasData.channelName = this.setName;
    this.setParasData.appId = this.appIds;
    this.setParasData.payChannel = this.code;
     this.setParasData.param = JSON.stringify(this.form);
    if (this.form.appId === '' || this.form.rsaPrivateKey === '' || this.form.notifyUrl === '' || this.form.returnUrl === '' || this.form.alipayPublicKey === '') {
       this.$message({
          type: 'error',
          message: '必填项不能为空!'
        });
        return;
    }
    if (this.paramId === '0') {
      let res = await setParams(this.setParasData);
        this.$message({
          type: 'success',
          message: '添加成功!'
        });
        this.$router.push('/pay/index')
    } else {
      if (Object.keys(this.realParams).length == 0) {
        let res = await setParams(this.setParasData);
          this.$message({
            type: 'success',
            message: '添加成功!'
          });
          this.$router.push('/pay/index')
      } else {
        this.setParasData.id= this.realParams.id 
         let res = await updateRealPayParam(this.setParasData)
            this.$message({
              type: 'success',
              message: '修改成功!'
            });
            this.$router.push('/pay/index')
      } 
    }
  }

  private async wxSubmit () {
    this.setParasData.channelName = this.setNames;
    this.setParasData.appId = this.appIds;
    this.setParasData.payChannel = this.code;
    if (this.wxform.appID === '' || this.wxform.appSecret === '' || this.wxform.key === '' || this.wxform.mchID === '' || this.wxform.payKey === '' || this.wxform.returnUrl === '') {
      this.$message({
          type: 'error',
          message: '必填项不能为空!'
        });

        return;
    }
    this.setParasData.param = JSON.stringify(this.wxform);
    if (this.paramId === '0') {
      let res = await setParams(this.setParasData);
        this.$message({
          type: 'success',
          message: '添加成功!'
        });
        this.$router.push('/pay/index')
    } else {
      if (Object.keys(this.realParams).length == 0) {
        let res = await setParams(this.setParasData);
          this.$message({
            type: 'success',
            message: '添加成功!'
          });
          this.$router.push('/pay/index')
      } else {
         this.setParasData.id= this.realParams.id 
         let res = await updateRealPayParam(this.setParasData)
            this.$message({
              type: 'success',
              message: '修改成功!'
            });
          this.$router.push('/pay/index')
      }
     
    } 
  }
  private async startService (value:any) {
    value.state = true;
    this.payCodes = []
    this.payCodes.push(value.channelCode);
    let res = boundRoad(this.appIds, this.payCodes);
      
    this.$forceUpdate()

  }
  private async setParam (value:any) {
    this.showParam = true;
    this.code = value.channelCode;
  
    if (this.paramId!= '0') {
         this.realForm.appId = this.appIds;
        this.realForm.payChannel = this.code;
        this.realParams = await getPayChannelIncludeOnlyPayParams(this.realForm.appId,this.realForm.platformChannel,this.realForm.payChannel)
    }
    
    setTimeout(() => {
      if (value.channelCode == 'WX_JSAPI' || value.channelCode == 'WX_MICROPAY') {
        if (Object.keys(this.realParams).length !=0) {
          if (value.channelCode == this.realParams.payChannel) {
            this.setNames = this.realParams.channelName;
            this.wxform.appID = JSON.parse(this.realParams.param).appID;
            this.wxform.appSecret = JSON.parse(this.realParams.param).appSecret;
            this.wxform.key = JSON.parse(this.realParams.param).key;
            this.wxform.mchID = JSON.parse(this.realParams.param).mchID;
            this.wxform.payKey = JSON.parse(this.realParams.param).payKey;
            this.wxform.returnUrl = JSON.parse(this.realParams.param).returnUrl;
          }
          
        }
        this.$forceUpdate()
        this.isWx = true;
      } else {
        console.log(this.realParams)
        if (Object.keys(this.realParams).length != 0) {
          
          if(value.channelCode == this.realParams.payChannel) {
            this.setName = this.realParams.channelName;
            this.form.appId = JSON.parse(this.realParams.param).appId;
            this.form.rsaPrivateKey = JSON.parse(this.realParams.param).rsaPrivateKey;
            this.form.notifyUrl = JSON.parse(this.realParams.param).notifyUrl;
            this.form.returnUrl = JSON.parse(this.realParams.param).returnUrl;
            this.form.alipayPublicKey = JSON.parse(this.realParams.param).alipayPublicKey;   
          }
        }
        this.isWx = false;
        this.$forceUpdate()
      }
    },10);
  }
  private async updateRealPrarms () {
   
    
  }
  private opens() {
    this.open = true;
  }

  private async save() {
    if (this.paramId === '0') {
      let res = await createApp(this.forms);
      this.appIds = res.appId;
      this.getServeType();
    } else {
      let res = await updateApp(this.forms)
      this.appIds = res.appId;
      let ret = await searchIsBindService(this.paramId,'shanju_b2c')
      if (ret === 0) {
        this.isB2c = false;
      } else {
        this.isB2c = true;
      }
      let rets = await searchIsBindService(this.paramId,'shanju_c2b')
      if (rets === 0) {
        this.isC2b = false;
      } else {
        this.isC2b = true;
      }
      this.serveList = await getAllPayChannel();
      this.serveList.forEach((item:any) => {
        if (item.channelCode === 'shanju_b2c') {
          item.state = this.isB2c;
        } else {
          item.state = this.isC2b;
        }
      });
    }
    
    this.step = 1;
  }
  private handleClicks() {
    this.step = 2;
  }
  private goOne() {
    this.step = 0;
  }

  private async goTwo() {
    this.step = 1;
    this.godeploy = true;
    this.showParam = false;

    if (this.paramId != '0') {
      let ret = await searchIsBindService(this.paramId,'shanju_b2c')
      if (ret === 0) {
        this.isB2c = false;
      } else {
        this.isB2c = true;
      }
      let rets = await searchIsBindService(this.paramId,'shanju_c2b')
      if (rets === 0) {
        this.isC2b = false;
      } else {
        this.isC2b = true;
      }
      this.serveList = await getAllPayChannel();
      this.serveList.forEach((item:any) => {
        if (item.channelCode === 'shanju_b2c') {
          item.state = this.isB2c;
        } else {
          item.state = this.isC2b;
        }
      });

    }
  }

  private goThree() {
    this.step = 2;
    this.godeploy = false;
  }

  private async getServeType() {
    this.serveList = await getAllPayChannel();
    this.serveList.forEach((item: any) => {
      item.state = false;
    });

  }

  private async setRealParams(value: any) {
    this.setParasData.platformChannelCode = value.channelCode;
    this.realForm.platformChannel = value.channelCode;
    this.step = 2;

    this.realList = await getPayChannelFromPayCode (value.channelCode)

    if (value.channelCode == 'shanju_c2b') {
      this.realParam = true;
    }
    
  }
}
</script>

<style lang="scss">
.pay-container {
  width: 1200px;
  margin: 0 auto;
  padding: 42px 44px;
  background: white;
  height: auto;

  .oneStep {
    width: 330px;
    margin: 0 auto;
    margin-top: 125px;

    button {
      width: 120px;
      margin-top: 50px;
    }
  }

  .twoStep {
    margin-top: 30px;
  }

  .threeStep {
    width: 100%;
    margin: 0 auto;
    margin-top: 30px;
    input {
      width: 340px;
    }
    h3 {
      text-align: center;
      margin: 50px 0 60px 0;
    }
    .firstItem {
      position: relative;
      .elSelect {
        position: absolute;
        right: 60px;
        top: 0px;
        input {
          width: 100px;
        }
      }
    }
  }

  .fourStep {
    width: 700px;
    margin: 0 auto;
    margin-top: 40px;
    h3 {
      text-align: center;
      margin-bottom: 60px;
    }

    p {
      text-align: center;
      margin-top: 35px;
    }
    .first {
      margin-left: 50px;
      position: relative;
      button {
        position: absolute;
        right: 200px;
        top: 0;
      }
    }

    .second {
      position: relative;
      margin-left: 50px;
      button {
        position: absolute;
        right: 200px;
        top: 0;
      }
    }

    .third {
      margin-left: 120px;
      margin-top: 60px;
      button {
        width: 150px;
      }
    }

    input {
      width: 260px;
    }

    .elForm {
      margin-left: 50px;
    }
  }

  .openBox {
    button {
      width: 150px;
      height: 50px;
      display: block;
      margin: 0 auto;
      margin-top: 200px;
    }
  }
}

.setParams {
  width: 650px;
  margin: 0 auto;
  margin-top: 35px;
}

.btnParent {
  .btn {
    margin-left: 100px;
  }
}
</style>

<style lang="scss" scoped>
</style>
