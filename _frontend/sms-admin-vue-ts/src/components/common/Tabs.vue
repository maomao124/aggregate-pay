<template>
  <div class="Tabs">
    <ul>
      <li class="li-tab" v-for="(item,index) in tabsParam" @click="toggleTabs(index)" :class="{ active: index === nowIndex }" :key="index">
        {{item}}
        <span></span>
      </li>
    </ul>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop } from 'vue-property-decorator'

@Component
export default class Tabs extends Vue {
  static componentName = 'Tabs'

  @Prop([Array]) tabsParam!: object
  @Prop([String]) type !: string

  private nowIndex = this.type === '营销' ? 1 : 0

  toggleTabs (index: number) {
    this.nowIndex = index
    this.$emit('toggleTabs', index)
  }
}
</script>

<style lang="scss" scoped>
  .Tabs {
    width: 100%;
    height: 48px;
    line-height: 48px;
    background-color: #fff;
    margin-bottom: 20px;
    border-radius: 10px;
    box-sizing: border-box;
    ul {
      height: 18px;
      line-height: 48px;
      // ul引起出现横向滚动条
      // width: 100%;
      padding: 0;
      display: flex;
      text-align: center;
      margin: 0;
      margin-left: 28px;
      li {
        position: relative;
        font-size: 16px;
        cursor: pointer;
        display:inline-block;
        text-align: center;
        color: #999999;
        margin-bottom: -20px;
        margin-left: 40px;
      }
      li:first-child {
        margin-left: 0;
      }
      li:last-child {
        margin-left: 40px;
      }
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
</style>