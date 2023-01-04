<template>
  <div class="SuccessAndRate">
    <PieChart :mounthArr="mounthArr" />
    <LineChart :mounthArr="mounthArr" />
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop } from 'vue-property-decorator'
// 饼图
import PieChart from './SuccessAndRateCom/PieChart.vue'
// 柱状图
import LineChart from './SuccessAndRateCom/LineChart.vue'

@Component({
  components: {
    PieChart,
    LineChart
  }
})
export default class SuccessAndRate extends Vue {
  static componentName = 'SuccessAndRate'

  @Prop([Array]) mounthArr !: Function
  
}
</script>

<style lang="scss" scoped>
  .SuccessAndRate {
    width: 100%;
    height: 100%;
    border-radius: 10px;
    box-shadow: 0px 2px 23px 0px rgba(159,195,177,0.12);
    h1 {
      margin: 0;
    }
  }
</style>