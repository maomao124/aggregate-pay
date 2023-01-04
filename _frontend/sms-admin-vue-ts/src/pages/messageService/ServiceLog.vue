<template>
  <div class="ServiceLog">
    <div class="title"></div>
    <Tabs :tabsParam="['接收日志', '发送日志']" @toggleTabs="getToggleTabs" type="日志" />
    <ReceiveLog v-show="tabsIndex === 0" />
    <SendOutLog v-show="tabsIndex === 1" />
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import ReceiveLog from '@/components/messageService/ReceiveLog.vue'
import SendOutLog from '@/components/messageService/SendOutLog.vue'

@Component({
  components: {
    ReceiveLog,
    SendOutLog
  }
})
export default class ServiceLog extends Vue {
  private tabsIndex = 0
  
  getToggleTabs (index: number) {
    this.tabsIndex = index
  }
}
</script>

<style lang="scss" scoped>
  .ServiceLog {
    width: 100%;
  }
</style>