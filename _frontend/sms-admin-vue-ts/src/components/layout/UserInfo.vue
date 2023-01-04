<template>
	<div class="user-info">
		<div class="user-content">
			<img :src="getSrc" alt="用户头像" />
			<h3>{{ $store.state.userInfo.userName }}</h3>
			<div class="modalDiaLog">
				<!-- v-if="getLogout" -->
				<Logout @sendLogout="getLogout" />
			</div>
    </div>
		<ChangePassword :dialogShow="dialogShow" :title="passTitle" @closeDialog="closeDialog" />
		<!-- 退出动作 -->
    <el-dialog :visible.sync="centerDialogVisible" width="322px" center :show-close="false" top="22vh" :modal-append-to-body="false" class="dia-logout">
      <span class="diaLog-span" style="text-align:center;">确认退出系统?</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="logoutDia" class="btn-sty">取 消</el-button>
        <el-button type="primary" @click="clearToken" style="padding: 10px 20px;">确 定</el-button>
      </span>
    </el-dialog>
	</div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import Logout from './Logout.vue'
import ChangePassword from './ChangePassword.vue'

@Component({
	components: {
		Logout,
		ChangePassword
	}
})
export default class UserInfo extends Vue {

	private toggleLogout = false

	private dialogShow = false
  private centerDialogVisible = false
	private passTitle = '修改密码'
	
	get getSrc () {
			return this.$store.state.userInfo.avatar 
	}

	get newContent () {
		return `${this.$store.state.userInfo.userName}，欢迎您登录短信平台系统`
	}

	// get getLogout () {
	// 	return this.$store.state.toggleLogout
	// }

	// changeAvatar () {
	// 	// this.$store.commit('updateLogout', !this.getLogout)
	// }
	
	mounted () {
		// const UserInfo = document.getElementById('UserInfo')
		// UserInfo.addEventListener('click', this.clickUpdate)

		// this.$once('hook:beforeDestroy', () => {
		// 	UserInfo.removeEventListener('click', this.clickUpdate)
		// })
	}

	getLogout (data: any) {
		// TODO
		if (data === '修改密码') {
			this.dialogShow = true
		} else if (data === '退出登录') {
			this.centerDialogVisible = true
		}
	}

	closeDialog () {
		// TODO
		this.dialogShow = false
	}

	logoutDia () {
    this.centerDialogVisible = false
    this.$store.commit('updateToken', '')
	}

	clearToken () {
    // TODO
    this.$store.commit('updateLogout', false)
    this.$router.push('/login')
  }
}
</script>

<style lang="scss" scoped>
  .user-content {
		text-align: center;
    img {
			display: inline-block;
			width: 36px;
			height: 36px;
			text-align: center;
			vertical-align: middle;
			border-radius: 50%;
			cursor: pointer;
		}
		h3 {
			font-size: 14px;
			color: #fff;
			margin: 10px 0 0 0;
			font-weight: 400;
		}
  }

	.modalDiaLog {
		display: none;
	}
	.user-content:hover {
		.modalDiaLog {
			display: block;
		}
	}

	/deep/ .el-dialog {
		border-radius: 10px;
	}
	
	.diaLog-span {
		display: block;
		width: 100%;
		font-size: 20px;
		font-family: PingFangSC, PingFangSC-Semibold;
		font-weight: 600;
		text-align: center;
		color: #333333;
		line-height: 28px;
	}
	.dialog-footer {
		.btn-sty {
			margin-right: 30px;
			margin-bottom: 30px;
			padding: 10px 20px;
		}
	}
		
	.dia-logout {
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