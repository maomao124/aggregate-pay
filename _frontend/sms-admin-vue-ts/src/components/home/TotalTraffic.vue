<template>
  <div class="total-traffic">
    <h1>总发送量趋势</h1>
    <TotalTrend :mounthArr="mounthArr" />
    <BarChartAndLineChart :mounthArr="mounthArr" />
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator'
// 顶部发送量信息展示
import TotalTrend from './TotalTrafficCom/TotalTrend.vue'
// 柱状图和折线图整合图表
import BarChartAndLineChart from './TotalTrafficCom/BarChartAndLineChart.vue'

@Component({
  components: {
    TotalTrend,
    BarChartAndLineChart
  }
})
export default class TotalTraffic extends Vue {
  static componentName = 'TotalTraffic'

  @Prop([Array]) mounthArr !: Function

  created () {
    // TODO
  }

  @Watch('mounthArr', { immediate: true })
  getMounthArr () {
    // TODO
  }
}
</script>

<style lang="scss" scoped>
  .total-traffic {
    width: 100%;
    height: 100%;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0px 2px 23px 0px rgba(159,195,177,0.12);
    h1 {
      margin: 0;
      height: 22px;
      font-size: 16px;
      font-family: PingFangSC, PingFangSC-Medium;
      font-weight: 700;
      text-align: left;
      color: #333333;
      line-height: 22px;
      padding-top: 27px;
      padding-left: 30px;
      box-sizing: border-box;
    }
  }
</style>