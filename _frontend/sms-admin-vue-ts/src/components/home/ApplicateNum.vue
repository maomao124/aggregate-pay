<template>
  <div class="ApplicateNum">
    <h1>应用发送数量Top10(单位：个）</h1>
    <div class="num-message">
      <p>
        <!-- <span class="total">总量：&nbsp;</span> -->
        <!-- <span class="total tetails">{{dataInfo.count}}</span> -->
        <span class="success">成功：&nbsp;</span>
        <span class="success tetails">{{dataInfo.success}}</span>
        <span class="fail">失败：&nbsp;</span>
        <span class="fail">{{dataInfo.fail}}</span>
      </p>
    </div>
    <div id="erectBarChart" style="height: 100%"></div>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop, Watch } from 'vue-property-decorator'
import echarts from 'echarts'

@Component
export default class ApplicateNum extends Vue {
  static componentName = 'ApplicateNum'
  private dataInfo = {
    count: 1800,
    success: 1780,
    fail: 20
  } as any

  private dataApplicList = {} as any

  @Prop([Array]) mounthArr !: Function

  get option () {
    return {
      color: ['rgba(255,94,32,1)', 'rgba(11,178,144,1)', 'rgba(218,232,255,1)'],
      tooltip: {
        trigger: 'axis',
        axisPointer: {
          type: 'shadow'
        }
      },
      grid: {
        left: '3%',
        right: '4%',
        containLabel: true
      },
      xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01],
        splitLine: {
          lineStyle: {
            type: 'dashed'
          },
          show: true
        },
        axisLine: {
          show: false
        },
        axisLabel: {
          color: '#999999'
        }
      },
      yAxis: {
        type: 'category',
        data: this.dataApplicList.platformNames.reverse(),
        axisLabel: {
          color: '#999999'
        }
      },
      // series: this.dataApplicList.services
      series: [
        {
          name: '失败',
          type: 'bar',
          stack: '总量',
          label: {
            show: false,
            position: 'insideRight'
          },
          data: this.dataApplicList.fail.reverse()
        },
        {
          name: '成功',
          type: 'bar',
          stack: '总量',
          label: {
            show: false,
            position: 'insideRight'
          },
          data: this.dataApplicList.success.reverse()
        }
        // {
        //   name: '总量',
        //   type: 'bar',
        //   stack: '总量',
        //   label: {
        //     show: false,
        //     position: 'insideRight'
        //   },
        //   data: this.dataApplicList.count.reverse()
        // }
      ]
    }
  }

  @Watch('mounthArr')
  getMounthArr () {
    // 调用mounthArr更新图标数据
    this.$nextTick(() => {
      this.getErectBarChart(this.mounthArr)
    })
  }
  
  mounted () {
    this.getErectBarChart(this.mounthArr)
  }

  getErectBarChart (arr: any) {
    const params = {
      startCreateTime: arr ? arr[0] : null,
      endCreateTime: arr ? arr[1] : null
    }
    this.$api.getStatisticsTop10(params).then(res => {
      if (res && res !== null) {
        
        this.dataApplicList = {
          ...res
        }
        this.dataInfo = {
          ...res.dataInfo
        }
        const dom = document.getElementById("erectBarChart")
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
  .ApplicateNum {
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
    #erectBarChart {
      width: 100%;
      height: 340px;
    }
  }
</style>