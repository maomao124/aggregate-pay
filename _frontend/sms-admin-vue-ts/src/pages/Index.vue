<template>
	<div class="index-home">
		<div class="container">
			<!-- 头部 -->
			<TitleIndex @sendTitleInd="getTitleNum" />
			<!-- 中间部分 -->
			<div class="toallAndPass">
				<!-- 中间-左边部分 -->
				<div class="toallAndPass-left">
					<TotalTraffic :mounthArr="thisOrLastOrcertainMonth" />
				</div>
				<!-- 中间-右边部分 -->
				<div class="toallAndPass-right">
					<SuccessAndRate :mounthArr="thisOrLastOrcertainMonth" />
				</div>
			</div>
			<!-- 底部 -->
			<div class="chart-bottom">
				<!-- 左边 -->
				<div class="chart-bottom-left">
					<ApplicateNum :mounthArr="thisOrLastOrcertainMonth" />
				</div>
				<!-- 右边 -->
				<div class="chart-bottom-right">
					<MarketSMSTotal :mounthArr="thisOrLastOrcertainMonth" />
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import { Component, Vue } from 'vue-property-decorator'
// 头部
import TitleIndex from '@/components/home/TitleIndex'
// 中间左侧部分
import TotalTraffic from '@/components/home/TotalTraffic'
// 中间右侧部分
import SuccessAndRate from '@/components/home/SuccessAndRate'
// 底部-左边部分
import ApplicateNum from '@/components/home/ApplicateNum'
// 底部-右边部分
import MarketSMSTotal from '@/components/home/MarketSMSTotal'
import { get1stAndToday, getLastMonthStartDateAndEndDate } from '@/utils/formValidate'

@Component({
	components: {
		TitleIndex,
		TotalTraffic,
		SuccessAndRate,
		ApplicateNum,
		MarketSMSTotal
	}
})
export default class Index extends Vue {
	// 本月、上月、自定义月份
	thisOrLastOrcertainMonth = [ ...get1stAndToday() ]

	getTitleNum (data) {
		this.thisOrLastOrcertainMonth = []
		if (typeof data === 'object' && data !== null) {
			// 自定义
			this.thisOrLastOrcertainMonth = [ ...data ]
		} else {
			switch (data) {
				case 0:
					// 本月
					this.thisOrLastOrcertainMonth = [ ...get1stAndToday() ]
					break;
				case 1:
					// 上月
					this.thisOrLastOrcertainMonth = [ ...getLastMonthStartDateAndEndDate() ]
					break;
				default:
					this.thisOrLastOrcertainMonth = []
			}
		}
	}
}
</script>

<style lang="scss" scoped>
	.index-home {
		width: 100%;
		height: 100%;
		// 新加的适应contaniter 10-28
		min-width: 1366px;
		overflow: auto;
		.container {
			width: 100%;
			height: 100%;
			min-width: 1366px;
			overflow: auto;
		}
		// 中间部分
		.toallAndPass {
			width: 100%;
			// height: 524px;
			height: 600px;
			margin-top: 20px;
			display: flex;
			// 中间-左边部分
			.toallAndPass-left {
				flex: 1;
				margin-right: 20px;
			}
			// 中间-右边部分
			.toallAndPass-right {
				width: 400px;
			}
		}
		// 底部
		.chart-bottom {
			width: 100%;
			height: 350px;
			margin-top: 20px;
			display: flex;
			.chart-bottom-left {
				flex: 1;
				background-color: #fff;
				margin-right: 10px;
				border-radius: 10px;
			}
			.chart-bottom-right {
				flex: 1;
				background-color: #fff;
				margin-left: 10px;
				border-radius: 10px;
			}
		}
	}
</style>