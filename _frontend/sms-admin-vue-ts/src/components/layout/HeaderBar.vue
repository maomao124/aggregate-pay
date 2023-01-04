<template>
  <div class="layout-header">
    <slot name="icon">
      <i class="iconfont icon-zhedie" :class="$store.state.isCollapse ? 'rote90' : ''" @click="toggleClick" />
    </slot>
    <slot></slot>
  </div>
</template>

<script>
  export default {
    methods: {
      toggleClick () {
        this.$emit('toggleClick')
      }
    }
  }
</script>

<style lang="scss">
  .layout-header {
    min-height: 57px;
    width: 100%;
    background: #355ebe;
    // background-color: #fff;
    display: flex;
    align-items: center;
    padding: 0 20px;
    justify-content: space-between;
    box-sizing: border-box;
    box-shadow: 0 3px 12px 0 rgba(0,0,0,.3);
    color: #fff;
    .icon-zhedie {
      cursor: pointer;
      transition: all 1s ease;
      font-size: 14px !important;
    }
    .rote90 {
      transition: all 1s ease;
      transform: rotateZ(-90deg);
    }
  }
</style>