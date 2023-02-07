<template>
  <div class="box-container">
    <div class="box">
        <div class="logos">
          <img src="../../public/img/logo/logo.png" alt="" class="imgs" @click="goHome">
        </div>
        <sidebar  class="sidebar-container"/>
         <div class="right-menu">
           <img src="../../public/img/head.png" alt="" >
           <el-dropdown @command="handleCommand">
            <span class="el-dropdown-link">
              {{username}}<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="a">账户中心</el-dropdown-item>
              <el-dropdown-item command="b">切换用户</el-dropdown-item>
              <el-dropdown-item command="c">退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
    </div>
    <div
    :class="classObj"
    class="app-wrapper"
  >
    <div
      v-if="classObj.mobile && sidebar.opened"
      class="drawer-bg"
      @click="handleClickOutside"
    />
    
    <div class="main-container">
      <navbar />
      <app-main />
    </div>
  </div>
  </div>
</template>

<script lang="ts">
import { Component } from 'vue-property-decorator'
import { mixins } from 'vue-class-component'
import { DeviceType, AppModule } from '@/store/modules/app'
import { AppMain, Navbar, Sidebar } from './components'
import ResizeMixin from './mixin/resize'
import { UserModule } from '@/store/modules/user'
import Hamburger from '@/components/Hamburger/index.vue'

@Component({
  name: 'Layout',
  components: {
    AppMain,
    Navbar,
    Sidebar,
    Hamburger
  }
})
export default class extends mixins(ResizeMixin) {
  private username:string = ''
  created () {
    this.username = localStorage.getItem('username')!
  }
  get classObj() {
    return {
      hideSidebar: !this.sidebar.opened,
      openSidebar: this.sidebar.opened,
      withoutAnimation: this.sidebar.withoutAnimation,
      mobile: this.device === DeviceType.Mobile
    }
  }
  get avatar() {
    return UserModule.avatar
  }
  private async logout() {
    
    
  }
  private toggleSideBar() {
    AppModule.ToggleSideBar(false)
  }
  private handleClickOutside() {
    AppModule.CloseSideBar(false)
  }
    get sidebar() {
    return AppModule.sidebar
  }

  private goHome () {
    this.$router.push('/')
  }
  private async handleCommand (value:any) {

    if (value === 'c') {
      await UserModule.LogOut()
       this.$router.push(`/login?redirect=${this.$route.fullPath}`)
    } else if (value === 'a') {
      this.$router.push('/finance/index')
    } else{
      console.log(1)
    }
  }
}
</script>

<style lang="scss" scoped>
.box-container {
  width: 100%;
  height: 100%;
}
.box {
  height: 60px;
  width: 100%;
  position: fixed;
  top:0;
  right: 0;
  z-index: 1999;
  background: #2A2669;

  .sidebar-container {
    width: auto;
    margin-left: 500px;
  }

  .logos {
    width: 350px;
    height: 100%;
    display: inline-block;
    position: absolute;
    left: 0;
    top: 0;

    span {
      color: white;
      margin-left: 5px;
      font-size: 22px;
      float: left;
      margin-top: 20px;
    }
  }
  .imgs {
   
    margin-left: 50px;
    margin-top: 12px;
    float: left;
  }

}
.title {
  float: left;
  color: white;
  font-size: 28px;
  line-height: 50px;
  margin-left: 40px;
  font-family: "Microsoft YaHei"
}
.app-wrapper {
  @include clearfix;
  position: relative;
  height: 100%;
  width: 100%;
}

.drawer-bg {
  background: #000;
  opacity: 0.3;
  width: 100%;
  top: 0;
  height: 100%;
  position: absolute;
  z-index: 999;
}

.main-container {
  min-height: 100%;
  background-color: #f2f5fa;
}



.hideSidebar {
  .main-container {
    margin-left: 54px;
  }

  .sidebar-container {
    width: 54px !important;
  }
}

/* for mobile response 适配移动端 */
.mobile {
  .main-container {
    margin-left: 0px;
  }

  .sidebar-container {
    transition: transform .28s;
    width: 210px !important;
  }

  &.openSidebar {
    position: fixed;
    top: 0;
  }

  &.hideSidebar {
    .sidebar-container {
      pointer-events: none;
      transition-duration: 0.3s;
      transform: translate3d(-210px, 0, 0);
    }
  }
}

.withoutAnimation {
  .main-container,
  .sidebar-container {
    transition: none;
  }
}

.hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    padding: 0 20px;
    cursor: pointer;
    margin-left: 200px;
    transition: background .3s;
    -webkit-tap-highlight-color:transparent;

    &:hover {
      background: rgba(0, 0, 0, .025)
    }
  }
  
  .right-menu {
    white-space:nowrap;
    padding: 0 10px;
    position: absolute;
    right: 18px;
    top: 10px;;
    height: 100%;
    line-height: 60px;
    overflow: hidden;
    img {
      width: 30px;
      height: 30px;
      margin-right: 20px;
    }
    .el-dropdown-link {
      white-space:nowrap;
      position: relative;
      color: white;
      right: 15px;;
      z-index: 2500;
      display: inline-block;
      top: -10px;
      i {
        position: absolute;
        color: white;
        top: 25px;
        right: -15px;
        z-index: 2000;
      }
    }
    
  }

   
</style>
