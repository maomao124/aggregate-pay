<template>
  <div class="login-container">
    <div class="loginbox">

        <div class="rights"  v-if="!isRegistry">

            <p class="title"><span :class="flag?'':'active'" class="username" @click="goAccount">账户密码登录</span><span class="tel" :class="flag?'active':''" @click="goPhone">手机号登录</span></p>
            <el-form
            ref="loginForm"
            :model="loginForm" 
            class="login-form"
            autocomplete="on"
            label-position="left"
            v-if="!flag"
          >

            <el-form-item prop="username">
              <el-input
                ref="username"
                name="username"
                v-model="loginForm.usernames"
                type="text"
                autocomplete="on"
                placeholder="手机号/用户名"
              />
            </el-form-item>

            <el-form-item prop="password">
              <el-input
                :key="passwordType"
                ref="password"
                :type="passwordType"
                v-model="loginForm.password"
                placeholder="请输入密码"
                name="password"
                autocomplete="on"
                @keyup.enter.native="handleLogin"
              />
            </el-form-item>

            <el-button
              type="primary"
              style="width:100%; margin-top:24px;height:56px"
              @click.native.prevent="handleLogin"
            >
              登录
            </el-button>
          </el-form>
          <el-form
            ref="loginForm"
            :model="loginForm" 
            class="login-form"
            autocomplete="on"
            label-position="left"
            v-if="flag"
          >

            <el-form-item prop="username">
              <el-input
                ref="username"
                name="username"
                v-model="loginForms.phone"
                type="text"
                autocomplete="on"
                placeholder="请输入手机号"
              />
            </el-form-item>

            <el-form-item prop="password">
              <el-input
                :key="passwordType"
                ref="password"
                :type="passwordType"
                v-model="loginForms.code"
                placeholder="请输入验证码"
                name="password"
                autocomplete="on"
              />
              <span class="getCodes" @click="getCodes">{{codes}}</span>
            </el-form-item>

            <el-button
              type="primary"
              style="width:100%; margin-top:24px;height:56px"
              @click.native.prevent="handleLogins"
            >
              登录
            </el-button>
          </el-form>
          <p class="bottom" v-if="!isRegistry"><span @click="registry">注册账号</span></p>
        </div>
          <div class="registryFrom"  v-if="isRegistry">
            <p class="registrys">注册账户</p>
            <el-form
              label-position="left"
              v-if="isRegistry"
            >
              <el-form-item>
                <el-input
                  v-model="registryForm.username"
                  type="text" 
                  placeholder="请输入用户名"
                />
              </el-form-item>

              <el-form-item>
                <el-input
                  v-model="registryForm.password"
                  placeholder="请输入密码"
                  type="password"
                />
              </el-form-item>

              <el-form-item>
                <el-input
                  v-model="registryForm.mobile"
                  placeholder="请输入手机号"      
                />
              </el-form-item>

              <el-form-item>
                <el-input
                  v-model="registryForm.verifiyCode"
                  placeholder="请输入验证码"
                />
                <span class="getCode" @click="getCode">{{content}}</span>
              </el-form-item>

              <el-button
                type="primary"
                style="width:100%; margin-top:24px;height:56px"
                @click.native.prevent="goRegistry"
              >
                注册
              </el-button>
            </el-form>
          </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from 'vue-property-decorator'
import { Route } from 'vue-router'
import { Dictionary } from 'vuex'
import { login,getLoginCode,getMsgCode,registryData } from '@/api/users'
import { Form as ElForm, Input } from 'element-ui'
import { UserModule } from '@/store/modules/user'
import { Message } from 'element-ui'
import { setTimeout } from 'timers';

@Component({
  name: 'Login'
})
export default class extends Vue {

  private loginForm = {
    usernames: 'aaaa',
    password: '123456'
  }
  
  private loginForms = {
    phone:'',
    code:'',
    smsKey:''
  }

  private registryForm = {
    mobile:"",
    usernmae:'',
    password: '',
    verifiykey: '',
    verifiyCode: ''
  }
  private passwordType = 'password'
  private loading = false
  private showDialog = false
  private redirect?: string
  private otherQuery: Dictionary<string> = {}
  private flag: boolean = false;
  private isRegistry : boolean = false;
  private content:string = '获取验证码'
  private codes :string = '获取验证码'
  private canClick:boolean = true;
  private totalTime:number = 60
   private canClicks:boolean = true;
  private totalTimes:number = 60
  @Watch('$route', { immediate: true })
  private onRouteChange(route: Route) {
    // TODO: remove the "as Dictionary<string>" hack after v4 release for vue-router
    // See https://github.com/vuejs/vue-router/pull/2050 for details
    const query = route.query as Dictionary<string>
    if (query) {
      this.redirect = query.redirect
      this.otherQuery = this.getOtherQuery(query)
    }
  }

  mounted() {
    if (this.loginForm.usernames === '') {
      (this.$refs.username as Input).focus()
    } else if (this.loginForm.password === '') {
      (this.$refs.password as Input).focus()
    }
  }

  private goAccount () {
    this.flag = false;
    this.$forceUpdate()
  }

  private goPhone () {
    this.flag = true;
    this.$forceUpdate()
  }

  private registry () {
      this.isRegistry = true;
  }

  private  async getCodes () {
      if (this.loginForms.phone === '') {
        Message({
          message: "手机号不能为空",
          type: 'error',
          duration: 2 * 1000
        })
        return;
      }
      if (!this.canClicks) return  //改动的是这两行代码,限制点击
      this.canClicks = false
      this.codes = this.totalTimes + 's后重新发送' //这里解决60秒不见了的问题
      this.cloak = setInterval(() => {
        this.totalTimes--
        if (this.totalTimes > 0) {
          this.codes = this.totalTimes + 's后重新发送'
        }
        if (this.totalTimes <= 0) {     //当倒计时小于等于0时清除定时器
          window.clearInterval(this.cloak)
          this.codes = '重新发送验证码';
          this.totalTimes = 60;
          this.canClicks = true  //这里重新开启
        }
      },1000)

    let res = await getLoginCode(this.loginForms.phone)
    this.loginForms.smsKey = res
  }

  private async getCode () {
    if(this.registryForm.mobile === '') {
      Message({
        message: "手机号不能为空",
          type: 'error',
          duration: 2 * 1000
        })
        return;
    }
     if (!this.canClick) return  //改动的是这两行代码,限制点击
        this.canClick = false
        this.content = this.totalTime + 's后重新发送' //这里解决60秒不见了的问题
        this.cloak = setInterval(() => {
              this.totalTime--
          if (this.totalTime > 0) {
            this.content = this.totalTime + 's后重新发送'
          }
          if (this.totalTime <= 0) {     //当倒计时小于等于0时清除定时器
            window.clearInterval(this.cloak)
            this.content = '重新发送验证码';
            this.totalTime = 60;
            this.canClick = true  //这里重新开启
          }
          
        },1000)

       let res = await getMsgCode(this.registryForm.mobile)
       this.registryForm.verifiykey = res;
  }

  private async goRegistry () {

    let res = await registryData(this.registryForm)

    if (!res) {
        Message({
        message: "注册失败",
          type: 'error',
          duration: 2 * 1000
        })
      } else {
        Message({
          message: "注册成功",
          type: 'info',
          duration: 2 * 1000
        })

        setTimeout(() => {
           this.isRegistry = false;
        },2000)
      }
    
  }
  private showPwd() {
    if (this.passwordType === 'password') {
      this.passwordType = ''
    } else {
      this.passwordType = 'password'
    }
    this.$nextTick(() => {
      (this.$refs.password as Input).focus()
    })
  }

  private handleLogin() {
    localStorage.setItem('username',this.loginForm.usernames);
    localStorage.setItem('password',this.loginForm.password);
    if (this.loginForm.usernames === '' || this.loginForm.password === '') {
       Message({
        message: "账号或密码不能为空",
        type: 'error',
        duration: 2 * 1000
      })
      return;
    }
    (this.$refs.loginForm as ElForm).validate(async(valid: boolean) => {
      if (valid) {
        await UserModule.Login(this.loginForm)
        this.$router.push({
          path: '/',
          query: this.otherQuery
        })
        // Just to simulate the time of the request
        setTimeout(() => {
          this.loading = false
        }, 0.5 * 1000)
      } else {
        return false
      }
    })
  }

  private handleLogins() {
    (this.$refs.loginForm as ElForm).validate(async(valid: boolean) => {
      if (valid) {
        this.loading = true
        await UserModule.Logins(this.loginForms)
        this.$router.push({
          path: '/',
          query: this.otherQuery
        })
        // Just to simulate the time of the request
        setTimeout(() => {
          this.loading = false
        }, 0.5 * 1000)
      } else {
        return false
      }
    })
  }

  private getOtherQuery(query: Dictionary<string>) {
    return Object.keys(query).reduce((acc, cur) => {
      if (cur !== 'redirect') {
        acc[cur] = query[cur]
      }
      return acc
    }, {} as Dictionary<string>)
  }
}
</script>

<style lang="scss">
// References: https://www.zhangxinxu.com/wordpress/2018/01/css-caret-color-first-line/


.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 65%;
    input {
      height: 47px;
      border-radius: 0px;
      border: 0;
      padding: 12px 5px 12px 15px;
      -webkit-appearance: none;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $loginBg inset !important;
        -webkit-text-fill-color: #fff !important;
      } 
    }
  }
  .el-form-item:nth-child(2) {
    border-bottom: 1px solid rgb(238, 230, 230);
    color: #454545;
  }
  .el-form-item:nth-child(3) {
    border-bottom: 1px solid rgb(238, 230, 230);
    color: #454545;
  }
  .el-form-item:nth-child(4) {
    border-bottom: 1px solid rgb(238, 230, 230);
    color: #454545;
  }
  .el-form-item:nth-child(1) {
    border-bottom: 1px solid rgb(238, 230, 230);
    color: #454545;
    margin-top:15px;

    .code {
      color: #1565d5;
    }
  }
}
</style>

<style lang="scss" scoped>
.login-container {
  height: 100%;
  width: 100%;
  overflow: hidden;
  background-color: #385d8e;
  background: #212121 url('../../../public/img/denglu.jpg') no-repeat center center;
  .loginbox {
    width:100%;
    height: 100%;
    
  
    .rights {
      width:450px;
      height: 435px;
      background:#fff;
      margin:0 auto;
      margin-top:245px;
      padding:47px 40px;
      .bottom {
        margin-top:51px;
        span{
          float: left;
          font-size:16px;
          cursor:pointer;
        }

      }
      .title {
        .active {
          color:#1989FA;
        }
        .username {
          display:inline-block;
          width:108px;
          height:25px;
          margin-left:50px;
          font-size:18px;
        }

        .tel {
          display:inline-block;
          width:108px;
          height:25px;
          margin-left:66px;
          font-size:18px;
        }
      }
    }

    .registryFrom {
        width:450px;
        height: 510px;
        background:#fff;
        margin:0 auto;
        margin-top:245px;
        padding:47px 40px;
        p {
          text-align:center;
          color:#1989FA;
          font-size:20px;
        }

        .getCode {
          margin-left:10px;
          cursor:pointer;      
          outline: none;
          border: 0;
          background-color: transparent;
        }
    }
  }
  .login-form {
    width: 100%;
    max-width: 100%;
    margin-top:45px;
    margin: 0 auto;
    overflow: hidden;

    .getCodes {
      margin-left:30px;
      cursor: pointer;
    }
  }

  

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $darkGray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    .imgbox {
      width:100%;
      height: 100%;
      margin-left:85px;
      margin-bottom:10px;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $darkGray;
    cursor: pointer;
    user-select: none;
  }
}
</style>
