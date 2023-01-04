<template>
  <div class="layout">
		<SiderBar :menuList="menuList" :isCollapse="isCollapse">
			<template slot="logo">
				<!-- <img :src="isCollapse ? require() : require()" alt="" /> -->
			</template>
		</SiderBar>
		<div class="layout-right">
			<!-- <HeaderBar @toggleClick='toggleClick'>
				<div class="bar">
					<el-dropdown>
						<span class="el-dropdown-link">
							欢迎您，{{ sysInfoName }} <i class="el-icon-arrow-down el-icon--right"></i>
						</span>
						<el-dropdown-menu slot="dropdown" class="dropdown">
							<el-dropdown-item @click.native="logout">退出</el-dropdown-item>
							<el-dropdown-item @click.native="showModifyPass">修改密码</el-dropdown-item>
						</el-dropdown-menu>
					</el-dropdown>
				</div>
			</HeaderBar> -->
			<div class="main-router" :style="routeStyle" v-loading.fullscreen="$store.state.loading" element-loading-spinner="el-icon-loading" element-loading-text="拼命加载中" element-loading-background="rgba(255, 255, 255, 0.7)">
				<!-- <BreadcrumBar :breadcrumbList='breadcrumbList' /> -->
				<transition name="fade-transform" mode="out-in">
					<router-view class="router"></router-view>
				</transition>
			</div>
		</div>
	</div>
</template>

<script>
// import HeaderBar from '@/components/layout/HeaderBar.vue'
// import BreadcrumBar from '@/components/layout/BreadcrumBar.vue'
import SiderBar from '@/components/layout/SiderBar.vue'

export default {
	components: {
		// HeaderBar,
		// BreadcrumBar,
		SiderBar
	},
	data () {
		return {
			name: '张三'
		}
	},
	computed: {
		menuList () {
			return this.$store.state.menuList
		},
		isCollapse () {
			return this.$store.state.isCollapse
		},
		routeStyle () {
			const { height, width } = this.$store.state.windowSize || {}
			return {
				height: height ? height - 56 + 'px' : '100%',
				width: width ? (this.isCollapse ? width - 54 + 'px' : width - 200 + 'px') : '100%'
			}
		},
		breadcrumbList () {
			return this.$store.getters.breadcrumbList
		}
	},
	methods: {
		toggleClick () {
			this.$store.commit('updateIsCollapse', !this.$store.state.isCollapse)
		},
		// eslint-disable-next-line @typescript-eslint/no-empty-function
		logout () {},
		// eslint-disable-next-line @typescript-eslint/no-empty-function
		showModifyPass () {}
	}


	

	
}
</script>

<style lang="scss" scoped>
	.layout {
		display: flex;
		height: 100%;
		.layout-right {
			overflow: auto;
			width: 100%;
			min-width: 1200px;
			.bar {
				display: flex;
				align-items: center;
			}
			.el-dropdown-link {
				color: #fff;
			}
		}
		.main-router {
			// padding: 10px;
			padding-top: 20px;
			padding-right: 20px;
			padding-bottom: 20px;
			border-radius: 5px;
			box-sizing: border-box;
			transition: all 0.5s;
			// overflow: auto;
			background-color: #f5f5f5;
			// 处理一些分页数据不够不能统一展示问题
			// position: relative;
		}
	}
</style>