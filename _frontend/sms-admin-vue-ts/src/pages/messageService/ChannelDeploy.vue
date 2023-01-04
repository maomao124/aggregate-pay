<template>
  <div class="ChannelDeploy">
    <el-breadcrumb separator="/" style="margin-bottom: 20px;">
      <el-breadcrumb-item :to="{ path: '/messageService/PassagewayManage' }">通道管理</el-breadcrumb-item>
      <el-breadcrumb-item>通道配置</el-breadcrumb-item>
    </el-breadcrumb>
    <Tabs :tabsParam="['关联签名', '关联模板']" @toggleTabs="getToggleTabs" type="关联" />
    <RelationSign v-show="tabsIndex === 0" />
    <RelationTemplate v-show="tabsIndex === 1" />
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import RelationSign from '@/components/messageService/RelationSign.vue'
import RelationTemplate from '@/components/messageService/RelationTemplate.vue'

@Component({
  components: {
    RelationSign,
    RelationTemplate
  }
})
export default class ChannelDeploy extends Vue {
  private tabsIndex = 0
  getToggleTabs (index: number) {
    this.tabsIndex = index
  }
}
</script>

<style lang="scss" scoped>
  .ChannelDeploy {
    width: 100%;
    height: 100%;
  }
</style>