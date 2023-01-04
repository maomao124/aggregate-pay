<template>
  <div class="barAndLine">
    <div id="container" style="height: 100%"></div>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator'
import echarts from 'echarts'

@Component
export default class BarChartAndLineChart extends Vue {
static componentName = 'BarChartAndLineChart'

  private dataObjList = {} as any

  @Prop([Array]) mounthArr !: Function

  get option () {
    return {
      color: ['#dae8ff', 'rgba(79,171,152,1)', 'rgba(255,94,32,1)'],
      legend: {
        data: ['总量', '成功', '失败'],
        icon: "circle",
        bottom: '15',
        itemWidth: 6,
        itemHeight: 6
      },
      tooltip: {
        // formatter: (value: any) => {
        //   return '总量：' + value[0].value + '<br/>' + '成功：' + value[1].value + '<br/>' + '失败：' + value[1].value
        // }
      },
      grid: {
        left: '3%',
        width: '94%',
        containLabel: true
      },
      xAxis: [
        {
          type: 'category',
          data: this.dataObjList.date,
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
          barWidth: 15,
          name: '总量',
          type: 'bar',
          data: this.dataObjList.count
        },
        {
          name: '成功',
          type: 'line',
          data: this.dataObjList.success,
          symbol:'circle',
          itemStyle: {
            normal: {  
              color: 'rgba(79,171,152,1)',
              borderColor: 'rgba(79,171,152,1)',
              lineStyle: {  
                color: 'rgba(79,171,152,1)'  
              }  
            }
          }
        },
        {
          name: '失败',
          type: 'line',
          data: this.dataObjList.fail,
          symbol:'circle',
          itemStyle: {
            normal: { 
              color: 'rgba(255,94,32,1)',
              borderColor: 'rgba(255,94,32,1)',
              lineStyle: {
                color: 'rgba(255,94,32,1)'
              }
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
      this.getBarAndLineChart(this.mounthArr)
    })
  }
  mounted () {
    this.getBarAndLineChart(this.mounthArr)
  }
  getBarAndLineChart (arr?: any) {
    const params = {
      startCreateTime: arr ? arr[0] : null,
      endCreateTime: arr ? arr[1] : null
    }
    this.$api.getStatisticsTrend(params).then(res => {
      if (res && res !== null) {
        this.dataObjList = {
          date: res.date,
          count: res.count,
          fail: res.fail,
          success: res.success
        }
        const dom = document.getElementById("container")
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
  .barAndLine {
    width: 100%;
    height: 380px;
  }
</style>