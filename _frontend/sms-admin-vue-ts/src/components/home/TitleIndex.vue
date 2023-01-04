<template>
  <div class="title-index">
    <div class="month">
      <ul class="tabs">
        <li class="li-tab" v-for="(item,index) in tabsParam" @click="toggleTabs(index)" :class="{ active: index === nowIndex }" :key="index">
          {{item}}
          <span></span>
        </li>
      </ul>
    </div>
    <div class="date-picker">
      <el-date-picker v-model="value" type="daterange" range-separator="-" start-placeholder="开始日期" end-placeholder="结束日期" @change="getArrDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd HH:MM:SS"></el-date-picker>
    </div>
    <div class="get-time">
      <p>数据获取时间：{{ newDate }}</p>
    </div>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Watch } from 'vue-property-decorator'
import { formatDate } from '@/utils/formValidate'
import { get1stAndToday } from '@/utils/formValidate'

@Component
export default class TitleIndex extends Vue {
  nowIndex = 0
  value = []
  tabsParam = [ '本月', '上月' ]

  get newDate () {
    return formatDate()
  }

  @Watch('nowIndex', { immediate: true })
  getNowIndex () {
    this.newDate
  }

  toggleTabs (index: number) {
    this.nowIndex = index
    this.value = []
    this.$emit('sendTitleInd', index)
  }

  getArrDate () {
    this.nowIndex = 2
    this.$emit('sendTitleInd', this.value ? this.value : [ ...get1stAndToday() ])
  }

}
</script>

<style lang="scss" scoped>
  .title-index {
    width: 100%;
    height: 48px;
    background-color: #fff;
    border-radius: 10px;
    display: flex;
    .month {
      width: 200px;
      padding-left: 29px;
      box-sizing: border-box;
      // .active {
      //   border-bottom: 2px solid rgba(11,178,144,1);
      //   color: #333333;
      //   border-radius: 1px;
      // }
      ul {
        height: 18px;
        line-height: 48px;
        width: 100%;
        padding: 0;
        display: flex;
        text-align: center;
        margin: 0;
        li {
          position: relative;
          font-size: 16px;
          cursor: pointer;
          display:inline-block;
          text-align: center;
          color: #999999;
          margin-bottom: -20px;
        }
        li:last-child {
          margin-left: 40px;
        }
        .active {
          color: #333333;
          border-radius: 1px;
          span {
            position: absolute;
            left: 50%;
            bottom: 2%;
            transform: translateX(-50%);
            display: block;
            width: 20px;
            height: 2px;
            background-color: rgba(11,178,144,1);
            text-align: center;
          }
        }
      }
    }
    .date-picker {
      flex: 1;
      line-height: 48px;
      /deep/ .el-date-editor--daterange.el-input, .el-date-editor--daterange.el-input__inner, .el-date-editor--timerange.el-input, .el-date-editor--timerange.el-input__inner {
        width: 350px;
        border-radius: 40px;
      }
      /deep/ .el-input__inner {
        border: 1px solid #afd0bd;
      }
      /deep/ .el-input__inner:hover {
        border: 1px solid rgba(11,178,144,1);
      }
      /deep/ .el-date-editor--daterange:focus {
        border: 1px solid rgba(11,178,144,1);
      }
      /deep/ .el-date-editor .el-range__icon {
        color: #afd0bd;
      }
    }
    .get-time {
      flex: 1;
      line-height: 48px;
      p {
        line-height: 48px;
        margin: 0;
        text-align: right;
        margin-right: 16px;
        font-size: 14px;
        font-family: PingFangSC, PingFangSC-Regular;
        font-weight: 400;
        color: #9eaec5;
      }
    }
  }
</style>