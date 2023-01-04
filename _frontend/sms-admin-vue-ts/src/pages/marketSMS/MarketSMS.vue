<template>
  <div class="MarketSMS">
    <Tabs :tabsParam="['全部', '审核中', '已拒绝', '已通过']" @toggleTabs="getToggleTabs" type="营销" />
    <!-- 0---全部 1---审核中 2---已拒绝 3---已通过 -->
    <!-- <WholeSMS :tabsIndex="tabsIndex" /> -->
    <WholeSMS v-show="tabsIndex === 0" :tabsIndex="tabsIndex" />
    <UnderReviewWholeSMS v-show="tabsIndex === 1" :tabsIndex="tabsIndex" />
    <RefuseWholeSMS v-show="tabsIndex === 2" :tabsIndex="tabsIndex" />
    <AdoptWholeSMS v-show="tabsIndex === 3" :tabsIndex="tabsIndex" />
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import WholeSMS from '@/components/marketSMS/WholeSMS.vue'
import UnderReviewWholeSMS from '@/components/marketSMS/UnderReviewWholeSMS.vue'
import RefuseWholeSMS from '@/components/marketSMS/RefuseWholeSMS.vue'
import AdoptWholeSMS from '@/components/marketSMS/AdoptWholeSMS.vue'

@Component({
  components: {
    WholeSMS,
    UnderReviewWholeSMS,
    RefuseWholeSMS,
    AdoptWholeSMS
  }
})
export default class MarketSMS extends Vue {
  private tabsIndex = 1
  
  getToggleTabs (index: number) {
    this.tabsIndex = index
  }
}
</script>

<style lang="scss" scoped>
  .MarketSMS {
  }
</style>