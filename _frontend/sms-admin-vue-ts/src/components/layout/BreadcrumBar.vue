<template>
  <el-breadcrumb separator="/" style="margin-bottom:10px">
    <transition-group name="breadcrumb">
      <el-breadcrumb-item :to="main.path" :key="main.title">
        <i class="i-icon menuicon iconfont" style="font-size:14px;" :class="main.icon"></i> {{main.title}}
      </el-breadcrumb-item>
      <el-breadcrumb-item :to="getRoute(obj)" v-for="obj in breadcrumbList" :key="obj.id">
        <i class='menuicon iconfont' :class="obj.icon"></i> {{obj.title}}
      </el-breadcrumb-item>
    </transition-group>
  </el-breadcrumb>
</template>

<script>
export default {
  props: {
    breadcrumbList: {
      type: Array,
      required: true
    }
  },
  data () {
    return {
      main: {
        path: '/',
        title: '首页',
        access: 1,
        icon: "icon-zhuye-copy"
      }
    }
  },
  // watch: {
  //   $roue(to, from) {
  //   }
  // },
  methods: {
    getRoute (route) {
      if (Number(route.isRoute) === 1) return route
      return null
    }
  }
}
</script>

<style lang="scss" scoped>
  .i-icon {
	width: 16px!important;
	height: 16px!important;
  }
</style>
