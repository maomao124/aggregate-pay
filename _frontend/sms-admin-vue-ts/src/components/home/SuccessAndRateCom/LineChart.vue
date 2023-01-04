<template>
  <div class="LineChart">
    <h1>各通道送达率（%）</h1>
    <div id="lineChart" style="height: 100%"></div>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator'
import echarts from 'echarts'

@Component
export default class LineChart extends Vue {
  static componentName = 'LineChart'

  private dataLineList = {} as any

  @Prop([Array]) mounthArr !: Function

  get option () {
    return {
      legend: {
        icon: "circle",
        bottom: '15',
        itemWidth: 6,
        itemHeight: 6
      },
      tooltip: {},
      grid: {
        left: '3%',
        width: '94%',
        containLabel: true
      },
      xAxis: [
        {
          type: 'category',
          data: this.dataLineList.name,
          axisLabel: {
            color: '#999999'
          }
        }
      ],
      yAxis: [
        {
          type: 'value',
          axisTick: {
            show: false
          },
          axisLine: {
            show: false
          },
          // 网格线
          splitLine: {
            lineStyle: {
              type: 'dashed'
            },
            show: true
          },
          axisLabel: {
            color: '#999999'
          }
        }
      ],
      series: [
        {
          barWidth: 30,
          type: 'bar',
          itemStyle: {
            emphasis: {
              barBorderRadius: 30
            },
            normal: {
              barBorderRadius: [10, 10, 0, 0],
              color: function (params: any) {
                const colorList = ['rgba(255,94,32,1)', 'rgba(158,174,197,1)', 'rgba(31,159,133,1)', 'rgba(87,113,222,1)', 'rgba(249,179,82,1)', 'rgba(96,159,74,1)']
                return colorList[params.dataIndex]
              }
            }
          },
          data: this.dataLineList.rate ? this.dataLineList.rate : [10, 10, 10]
        }
      ]
    }
  }

  @Watch('mounthArr')
  getMounthArr () {
    // 调用mounthArr更新图标数据
    this.$nextTick(() => {
      this.getLineChart(this.mounthArr)
    })
  }

  mounted () {
    this.getLineChart(this.mounthArr)
  }

  getLineChart (arr: any) {
    const params = {
      startCreateTime: arr ? arr[0] : null,
      endCreateTime: arr ? arr[1] : null
    }
    this.$api.getStatisticsRateForConfig(params).then(res => {
      if (res && res !== null) {
        this.dataLineList = {
          ...res
        }
        const dom = document.getElementById("lineChart")
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
  .LineChart {
    width: 100%;
    margin-top: 20px;
    background-color: #fff;
    border-radius: 10px;
    height: 290px;
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
    #lineChart {
      width: 400px;
      height: 200px;
    }
  }
</style>