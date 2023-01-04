<template>
  <div class="error-page">
		<div class="error-code">
			<!-- 4<span>0</span>4 -->
			<img src="@/assets/Error/404.png" alt="">
		</div>
		<div class="error-desc">抱歉，您访问的页面不存在</div>
		<div class="error-handle">
			<router-link to="/">
				<el-button size="large" class="go-back">返回首页</el-button>
			</router-link>
		</div>
  </div>
</template>

<script>
export default {
  methods: {
    goBack () {
      this.$router.back()
    }
  }
}
</script>

<style lang="scss" scoped>
	.error-page {
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
		width: 100%;
		height: 100%;
		background: #f3f3f3;
		box-sizing: border-box;
	}
	.error-code {
		line-height: 1;
		font-size: 250px;
		font-weight: bolder;
		img {
			border: 1px dashed #ccc;
			width: 760px;
			height: 280px;
		}
	}
	.error-handle {
		margin-top: 20px;
		.go-back {
			border-radius: 5px;
		}

		// 弹框按钮样式迭代
		// 朴素按钮样式迭代
		// hover
		/deep/ .el-button:first-child:hover {
			color: rgba(11,178,144,1);
			border-color: rgba(11,178,144,1);
		}
		/deep/ .el-button:first-child:focus {
			color: rgba(11,178,144,1);
			border-color: rgba(11,178,144,1);
		}
	}
</style>
