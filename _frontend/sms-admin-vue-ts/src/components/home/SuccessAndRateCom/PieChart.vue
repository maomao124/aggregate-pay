<template>
  <div class="PieChart">
    <h1>各通道成功量（条）</h1>
    <div id="pieChart" style="height: 100%"></div>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator'
import echarts from 'echarts'

@Component
export default class PieChart extends Vue {
  static componentName = 'PieChart'
  private dataPieList = [] as any
  
  @Prop([Array]) mounthArr !: Function

  get option () {
    return {
      color: ['rgba(255,94,32,1)', 'rgba(158,174,197,1)', 'rgba(31,159,133,1)', 'rgba(87,113,222,1)', 'rgba(249,179,82,1)', 'rgba(96,159,74,1)'],
      title: {
        left: 'center'
      },
      tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c} ({d}%)'
      },
      series: [
        {
          name: '各通道成功量（条）',
          type: 'pie',
          radius: [30, 90],
          center: ['50%', '50%'],
          roseType: 'radius',
          data: this.dataPieList ? this.dataPieList : [0, 0, 0],
           itemStyle: {
             normal: {
              borderWidth: 4,
              borderColor: '#ffffff'
            }
          }
        }
      ]
    }
  }

  @Watch('mounthArr')
  getMounthArr () {
    // 调用mounthArr更新图标数据
    this.$nextTick(() => {
      this.getPieChart(this.mounthArr)
    })
  }
  
  mounted () {
    this.getPieChart(this.mounthArr)
  }

  getPieChart (arr: any) {
    const params = {
      startCreateTime: arr ? arr[0] : null,
      endCreateTime: arr ? arr[1] : null
    }
    this.$api.getStatisticsCountForConfig(params).then(res => {
      if (res && res !== null) {
        this.dataPieList = [
          ...res
        ]
        const dom = document.getElementById("pieChart")
        const myChart = echarts.init(dom)
        myChart.setOption(this.option, true)
        window.addEventListener('resize', () => {
          myChart.resize()
        })
        this.$once('hook:beforeDestroy', () => {
          window.removeEventListener('resize', () => {
            myChart.resize()
          })
        })
      }
    })
  }
}
</script>

<style lang="scss" scoped>
  .PieChart {
    h1 {
      margin: 0;
      height: 22px;
      font-size: 16px;
      font-family: PingFangSC, PingFangSC-Medium;
      font-weight: 700;
      text-align: left;
      color: #333333;
      line-height: 22px;
      padding: 30px 0 0 30px;
      box-sizing: border-box;
    }
    width: 100%;
    height: 290px;
    background-color: #fff;
    border-radius: 10px;
    #pieChart {
      width: 400px;
      height: 200px;
    }
  }
</style>