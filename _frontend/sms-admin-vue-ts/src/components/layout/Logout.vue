<template>
  <div class="Logout">
    <ul class="logout-ul" >
      <li @click.stop="changePassWord">
        <img src="@/assets/Logout/password.png" alt="" />
        <span>修改密码</span>
      </li>
      <li @click.stop="goLogin">
        <img src="@/assets/Logout/logout.png" alt="" />
        <span>退出登录</span>
      </li>
      <li>
        <i class="iconfont icon-quanxianguanli" style="color: rgba(11,178,144,1);"></i>
        <el-link href="http://68.79.7.219:8080/#/login" target="_blank" class="link-a" :underline="false">权限系统</el-link>
      </li>
    </ul>
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'

@Component
export default class Logout extends Vue {
  static componentName = 'Logout'

  changePassWord () {
    // TODO
    this.$emit('sendLogout', '修改密码')
  }

  goLogin () {
    // TODO
    this.$emit('sendLogout', '退出登录')
  }

}
</script>

<style lang="scss" scoped>
  .Logout {
    position: absolute;
    right: -50px;
    top: -80px;
    z-index: 100;
    width: 104px;
    // height: 84px;
    height: 115px;
    background-color: #fff;
    border-radius: 10px;
    .logout-ul {
      margin: 0;
      padding: 0;
      list-style: none;
      height: 60px;
      margin-top: 12px;
      // box-sizing: border-box;
      // padding-left: 12px;
      li {
        // padding-left: 6px;
        box-sizing: border-box;
        line-height: 30px;
        cursor: pointer;
        width: 100%;
        height: 30px;
        text-align: center;
        img {
          display: inline-block;
          line-height: 42px;
          vertical-align: middle;
          width: 14px;
          height: 14px;
        }
        span {
          height: 30px;
          line-height: 30px;
          display: inline-block;
          margin-left: 8px;
          font-size: 12px;
          font-family: PingFangSC, PingFangSC-Regular;
          font-weight: 400;
          color: #666666;
        }
        .link-a {
          color: #666666;
          font-size: 12px;
          margin-left: 8px;
        }
      }
      li:hover {
        background: #e3f5e9;
        border-radius: 20px;
      }
    }

    /deep/ .el-dialog {
      border-radius: 10px;
    }
    .diaLog-span {
      display: block;
      width: 100%;
      font-size: 20px;
      font-family: PingFangSC, PingFangSC-Semibold;
      font-weight: 600;
      text-align: center;
      color: #333333;
      line-height: 28px;
    }
    .dialog-footer {
      .btn-sty {
        margin-right: 30px;
        margin-bottom: 30px;
        padding: 10px 20px;
      }
    }

  }
</style>