<template>
  <div class="MarketSMSTotal">
    <h1>营销短信发送量趋势(条）</h1>
    <div class="num-message">
      <p>
        <span class="total">总量：&nbsp;</span>
        <span class="total tetails">{{dataInfo.count}}</span>
        <span class="success">成功：&nbsp;</span>
        <span class="success tetails">{{dataInfo.success}}</span>
        <span class="fail">失败：&nbsp;</span>
        <span class="fail">{{dataInfo.fail}}</span>
      </p>
    </div>
    <div id="smsTotalChart" style="height: 100%"></div>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator'
import echarts from 'echarts'

@Component
export default class MarketSMSTotal extends Vue {
  static componentName = 'MarketSMSTotal'
  private dataInfo = {} as any
  private dataObjList = {} as any

  @Prop([Array]) mounthArr !: Function

  get option () {
    return {
      color: ['#dae8ff', 'rgba(79,171,152,1)', 'rgba(255,94,32,1)'],
      legend: {
        data: ['总量', '成功', '失败'],
        icon: "circle",
        bottom: '34',
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
      this.getMarketSMSTotalChart(this.mounthArr)
    })
  }

  mounted () {
    this.getMarketSMSTotalChart(this.mounthArr)
  }

  getMarketSMSTotalChart (arr?: any) {
    const params = {
      startCreateTime: arr ? arr[0] : null,
      endCreateTime: arr ? arr[1] : null
    }
    this.$api.getStatisticsMarketingTrend(params).then(res => {
      if (res && res !== null) {
        this.dataObjList = {
          date: res.date,
          count: res.count,
          fail: res.fail,
          success: res.success
        }
        this.dataInfo = {
          ...res.dataInfo
        }
        const dom = document.getElementById("smsTotalChart")
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
  .MarketSMSTotal {
    width: 100%;
    height: 100%;
    position: relative;
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
    .num-message {
      position: absolute;
      right: 20px;
      top: 20px;
      p {
        font-size: 12px;
        .total {
          color: rgba(87,113,222,1);
        }
        .tetails {
          margin-right: 20px;
        }
        .success {
          color: rgba(79,171,152,1);
        }
        .fail {
          color: rgba(255,94,32,1);
        }
      }
    }
    #smsTotalChart {
      width: 100%;
      height: 380px;
    }
  }
</style>