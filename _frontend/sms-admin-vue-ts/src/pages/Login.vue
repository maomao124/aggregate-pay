<template>
	<div class="login-wrap">
		<div class="continer">
			<div class="ms-logo"></div>
			<div class="ms-login">
				<!-- 登录框 -->
				<div class="login-frame">
					<div class="ms-title">
						<img src="@/assets/Login/title.png" alt="" />
					</div>
					<m-form :formData="ruleForm" :columns="formColumns" ref="ruleForm" @keyup.enter.native="submitForm" size="medium" />
					<el-button
            slot="btn"
            class="login-btn"
            size="medium"
            type="danger"
            @click="submitForm"
						:disabled="ruleForm.loginName !== '' && ruleForm.password !== '' ? false : true"
          >登<span style="margin-left:10px;">录</span></el-button>
				</div>
			</div>
		</div>
	</div>
</template>

<script lang='tsx'>
import { Component, Vue } from 'vue-property-decorator'

@Component
export default class Login extends Vue {
	private ruleForm = {
		loginName: '13800000000',
    password: '123456'
	}

	$refs!: {
		ruleForm: any;
	}
	get formColumns () {
		return [
			{
				prop: 'loginName',
				el: 'input',
				labelWidth: '0px',
				span: 22,
				offset: 1,
				placeholder: '请输入手机号',
				prefixIcon: 'iconfont icon-shouji',
				rules: {
					required: true,
					trigger: 'blur',
					validator: (rule: any, value: string, callback: Function) => {
						if (value === '') {
							callback(new Error('请输入手机号'))
						} else {
							const reg = /^[1][3,4,5,7,8][0-9]{9}$/
							if (!reg.test(value)) {
								callback(new Error('手机号格式数据有误'))
							} else {
								callback()
							}
						}
					}
				}
			},
			{
				prop: 'password',
				el: 'input',
				type: 'password',
				labelWidth: '0px',
				span: 22,
				offset: 1,
				placeholder: '请输入密码',
				prefixIcon: 'iconfont icon-suo',
				showPassword: true,
				rules: {
					required: true,
					message: '请输入密码',
					trigger: 'blur'
				}
			},
			{
				prop: 'btn',
				labelWidth: '0px',
				span: 24
			}
		]
	}

	submitForm () {
		this.$refs.ruleForm.validate().then((res: any) => {
			// this.$store.dispatch('login', this.ruleForm)
			if (this.ruleForm.loginName === '13800000000' && this.ruleForm.password === '123456') {
				this.$store.dispatch('login', this.ruleForm)
				// this.$store.dispatch('menuListForMessage')
				this.$router.push('/')
			}
		})
	}
}
</script>

<style lang="scss" scoped>
	.login-wrap {
		position: relative;
		width: 100%;
		height: 100%;
		display: flex;
		background: url(~@/assets/Login/background.png);
		background-size: cover;
		justify-content: center;
		align-items: center;
		.continer {
			width: 1600px;
			height: 773px;
			border-radius: 10px;
			box-shadow: 0px 2px 82px 0px #a8bab5;
			z-index: 1;
			display: flex;
			.ms-logo {
				width: 952px;
				height: 773px;
				background: url(~@/assets/Login/person.jpg);
				background-size: cover;
				justify-content: center;
			}
			.ms-login {
				border-radius: 6px;
				flex: 1;
				display: flex;
				justify-content: center;
				align-items: center;
				background-color: #fff;
				.login-frame {
					text-align: center;
					width: 450px;
					height: 384px;
					// border: 1px dashed #ccc;
					.ms-title {
						margin-top: 18px;
						margin-bottom: 37px;
						img {
							width: 170px;
							height: 55px;
						}
					}
				}
			}
		}

		/deep/ .el-input--medium .el-input__inner {
			height: 50px;
			line-height: 50px;
		}
		/deep/ .el-button  {
			width: 90%;
			border-radius: 12px;
			padding: 20px 20px;
			box-sizing: border-box;
			font-size: 18px;
			background: #0BB290;
			border-color: #0BB290;
		}

		/deep/ .el-input--medium .el-input__icon {
			line-height: 50px;
		}
	}
</style>