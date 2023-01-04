<template>
  <div class="sider-bar" :class="[ !isCollapse ? 'scole-bar': 'bar' ]">
    <el-menu :default-active="String($route.meta.id)" :collapse="isCollapse" unique-opened>
      <div class="logoTitle">
        <img src="@/assets/title_logo.png" alt="" @click='goto()' />
      </div>
      <template v-for="obj in menuList">
        <el-submenu :index="String(obj.id)" v-if='obj.children&&obj.children.length' :key="String(obj.id)">
            <div  slot="title" @click="goto(obj)">
              <i class='menuicon iconfont' :class="obj.icon||'el-icon-menu'"> &nbsp;</i>
              <span >{{obj.title}}</span>
            </div>
          <el-menu-item-group>
            <template v-for='item in obj.children'>
              <el-submenu :index="String(item.id)" :key='String(item.id)' v-if='item.children&&item.children.length'>
                  <div  slot="title" @click="goto(obj)">
                    <i class='menuicon iconfont' :class="item.icon" v-if="item.icon">&nbsp;</i>
                    <span >{{obj.title}}</span>
                  </div>
                <el-menu-item  @click.native="goto(child)" :index="String(child.id)" v-for="child in item.children" :key='String(child.id)'>
                  <i class='menuicon iconfont' :class="child.icon" v-if="child.icon">&nbsp;</i>
                  <span>{{child.title}}</span>
                </el-menu-item>
              </el-submenu>
              <el-menu-item   @click.native="goto(item)"  :index="String(item.id)" :key='String(item.id)' v-else>
                <i class='menuicon iconfont' :class="item.icon" v-if="item.icon">&nbsp;</i>
                <span slot="title">{{item.title}}</span>
              </el-menu-item>
          </template>
        </el-menu-item-group>
      </el-submenu>
      <el-menu-item @click.native="goto(obj)"   :index="String(obj.id)" v-else :key="String(obj.id)">
        <i class='menuicon iconfont' :class="obj.icon||'el-icon-menu'">&nbsp;</i>
        <span slot="title">{{obj.title}}</span>
      </el-menu-item>
    </template>
    <!-- <el-menu-item class="go-auth" index="权限系统">
      <i class="el-icon-s-promotion" style="color: #fff;"></i>
      <el-tooltip content="点击前往权限系统" placement="top" effect="light">
        <el-link href="http://68.79.7.219:8080/#/login" target="_blank" class="link-a" :underline="false">权限系统</el-link>
      </el-tooltip>
    </el-menu-item> -->
  </el-menu>
  <div class="user-info">
    <UserInfo />
  </div>
  
  <!-- 月牙部分 -->
  <div class="menu-space"></div>
</div>
</template>

<script>
import UserInfo from './UserInfo.vue'
export default {
  props: {
    isCollapse: Boolean,
    menuList: {
      type: Array,
      required: true
    }
  },
  components: {
    UserInfo
  },
  methods: {
    goto (route) {
      if (!route) {
        this.$router.push('/')
        return
      }
      if (route.component) {
        if (!route.path.startsWith('/')) route.path = '/' + route.path
        this.$router.push(route.path)
      }
    },
    getClick () {
      // TODO
    }
  }
}
</script>

<style lang="scss" scoped>
  .sider-bar {
    position: relative;
    min-height: 900px;
  }
	.scole-bar {
		transition: all 1s ease-in;
    min-width: 200px;
    width: 200px;
    // position: relative;
    // background: url(../../assets/2.png) no-repeat;
    // background-size: contain;
    // height: 100%;
  // z-index: 9;
  }
  .logoTitle {
    margin-top:27px;
    margin-bottom:34px;
    img {
      width:61px;
      height:73px;
      text-align:center;
      margin-left:50px;
      cursor: pointer;
    }
  }
	.bar {
		transition: all 1s ease-in;
  }
  .user-info {
    position: absolute;
    bottom: 30px;
    left: 0;
    width: 85%;
  }
  .menu-space {
    width: 30px;
    height: 100%;
    background-color: #f5f5f5;
    position: absolute;
    right: 0;
    top: 0;
    z-index: 10;
    border-top-left-radius: 40px;
    border-bottom-left-radius: 40px;
  }

  .el-menu-item, .el-submenu__title {
    height: 34px;
    line-height: 34px;
    position: relative;
    box-sizing: border-box;
    white-space: nowrap;
    list-style: none;
  }


  .go-auth {
    width: 100%;
    position: absolute;
    bottom: -10%;
    left: -7px;
    margin-left: 6px;
    .link-a {
      color: #fff;
      margin-right: 60px;
    }
  }
</style>