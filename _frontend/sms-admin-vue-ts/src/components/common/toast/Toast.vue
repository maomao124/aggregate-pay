<template>
  <transition name="fade">
    <div class="toast-container">
      <div class="toast" :class="type">
        <div class="content">
          <i class="iconfont" :class="'icon-' + type"></i>
          <span>{{ content }}</span>
        </div>
        <i v-if="hasClose" class="el-icon-circle-close" @click="visible = false"></i>
      </div>
    </div>
  </transition>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'

@Component
export default class Toast extends Vue {
  static componentName = 'Toast'

  private content = ''
  private time = 3000
  private visible = false
  private type = 'error'
  private hasClose = false

  mounted () {
    this.close()
  }

  close () {
    setTimeout(() => {
      this.visible = false
    }, this.time)
  }
}
</script>

<style lang="scss" scoped>
  .fade-enter-active,
  .fade-leave-active {
    transition: all 0.5s ease;
  }
  .fade-enter,
  .fade-leave-active {
    opacity: 0;
  }

  .toast-container {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 9999;
    .toast {
      width: 340px;
      padding: 20px;
      border-radius: 6px;
      font-size: 16px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      .content {
        span {
          padding-left: 10px;
        }
      }
      &.info {
        background: #edf2fc;
        border: 1px solid #e0eafc;
        color: #909399;
      }
      &.success {
        background: #f0f9eb;
        border: 1px solid #e7f9de;
        color: #67c23a;
      }
      &.warning {
        background: #fdf6ec;
        border: 1px solid #f9ecda;
        color: #e6a23c;
      }
      &.error {
        background: #fef0f0;
        border: 1px solid #fbdfdf;
        color: #f56c6c;
      }
      .close {
        cursor: pointer;
        color: #909399;
      }
    }
  }
</style>