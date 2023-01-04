<template>
  <div class="blacklistManage-dialog">
    <el-dialog :title="title" :visible.sync="dialogShow" :before-close="closeDialog" :close-on-click-modal="false" :show-close="true" width="660px" top="32vh" class="info-dialog">
      <m-form :columns="formColumns" :data="formData" ref="mform">
        <div slot="addressBook">
          <UploadBtn :fileSuffix="['xlsx', 'xls']" maxSize="10" icon="iconfont icon-wenjian" @success="getBlackList" updateType="黑名单">导入文件</UploadBtn>
          <div class="change-position">
            <el-button type="text" class="btn-style" @click="downLoadFile">下载模板</el-button>
            <span>（仅支持Excel文件，小于2M）</span>
          </div>
        </div>
        <!-- 展示上传文件名部分 -->
        <div slot="fileList">
          <div style="margin-top: 6px;margin-left: 50px;">
            <p v-for="(item, index) in fileName" :key="index" style="color: #20232a;">
              <span>{{ item.name }}</span>（<span>{{ item.size }}</span>）
              <el-button @click="deleteUpdateFiles(item, index)" type="text" style="margin-left: 20px;color: rgba(255,90,90,1);">删除</el-button>
              <el-button v-if="fileName[index].isShow" @click="detailsUpdateFiles(index)" type="text" style="margin-left: 20px;color: #0bb290;">失败详情</el-button>
            </p>
          </div>
        </div>
      </m-form>
      <div slot="footer" style="text-align:center;" class="footer-btn">
        <el-button @click="closeDialog" style="margin-right:30px;padding: 10px 20px;">取消</el-button>
        <el-button type="primary" style="margin-bottom:20px;padding: 10px 20px;" @click="importExcel">确认</el-button>
      </div>
    </el-dialog>
    <el-dialog title="失败详情" :visible.sync="centerDialogVisible" width="435px" center :show-close="true" top="32vh" class="dia-fail-black">
      <div class="over-info">
        <div class="all-info">
          <div class="fail-content" v-if="fileName.length > 0 && fileName[this.failIndex].matchErrorMsg.length > 0">
            <h3 style="color: #ff5a5a;text-align: center;">导入失败，格式错误!</h3>
            <p>
              <span>{{fileName[this.failIndex].matchErrorMsg && fileName[this.failIndex].matchErrorMsg.join(',')}}</span>
            </p>
          </div>
          <div class="fail-content" v-if="fileName.length > 0 && fileName[this.failIndex].nullErrorMsg.length > 0">
            <h3 style="color: #ff5a5a;text-align: center;">导入失败，数据为空!</h3>
            <p>
              <span>{{fileName[this.failIndex].nullErrorMsg && fileName[this.failIndex].nullErrorMsg.join(',')}}</span>
            </p>
          </div>
          <div class="fail-content" v-if="fileName.length > 0 && fileName[this.failIndex].duplicateErrorMsg.length > 0">
            <h3 style="color: #ff5a5a;text-align: center;">导入失败，数据重复!</h3>
            <p>
              <span>{{fileName[this.failIndex].duplicateErrorMsg && fileName[this.failIndex].duplicateErrorMsg.join(',')}}</span>
            </p>
          </div>
        </div>
      </div>
      
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="centerDialogVisible = false" style="padding: 10px 20px;">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script lang="tsx">
import { Vue, Component, Prop } from 'vue-property-decorator'

@Component
export default class BlacklistManageDialog extends Vue {
  static componentName = 'BlacklistManageDialog'

  private formData = {} as any
  private centerDialogVisible = false
  private fileName = [] as any
  private failIndex = 0

  @Prop([Boolean]) dialogShow!: boolean
  @Prop([String]) title !: string

  $refs!: {
    mform: any;
  }

  get formColumns () {
    return [
      {
        label: '通信录：',
        prop: 'addressBook',
        span: 22,
        rules: {
          required: true,
          trigger: 'blur',
          message: '通信录不能为空'
        }
      },
      {
        prop: 'fileList',
        span: 22,
        labelWidth: '50px'
      }
    ]
  }

  closeDialog () {
    this.$emit('closeDialog')
    this.fileName = []
  }

  deleteUpdateFiles (item: string, index: number) {
    this.fileName.splice(index, 1)
    this.$message.success('文件删除成功')
  }

  detailsUpdateFiles (index: number) {
    this.failIndex = index
    this.centerDialogVisible = true
  }

  getBlackList (data: any) {
    // TODO
    this.fileName.push({
      name: data.name,
      size: data.size,
      duplicateErrorMsg: data.duplicateErrorMsg ? data.duplicateErrorMsg : [],
      matchErrorMsg: data.matchErrorMsg ? data.matchErrorMsg : [],
      nullErrorMsg: data.nullErrorMsg ? data.nullErrorMsg : [],
      isShow: data.duplicateErrorMsg.length === 0 && data.matchErrorMsg.length === 0 && data.nullErrorMsg.length === 0 ? false : true
    })
    const vnode = (
      <div style="border-radius: 10px;top:18%">
        <h1 style="text-align:center;font-size: 20px;">导入完毕！</h1>
        <p style="text-align:center;margin-bottom: 17px;">
          <span style="color: #333333;font-size: 16px;font-weight: 500;">成功导入</span> <span style="color: #0bb290;font-weight: 700;font-size: 16px;">{ data.total - data.fail }</span>&nbsp;&nbsp;
          <span style="color: #333333;font-size: 16px;font-weight: 500;">失败</span> <span style="color:red;font-weight: 700;font-size: 16px;">{ data.fail }</span>
        </p>
      </div>
    )
    this.$msgbox({
      message: vnode,
      confirmButtonText: '确定'
    })
  }

  downLoadFile () {
    window.location.href = '/static/导入黑名单模板.xlsx'
  }

  importExcel () {
    if (this.fileName.length === 0) {
      this.$message.error('通讯录不能为空')
      return
    } else {
      this.$message.success('黑名单导入完毕')
      this.$emit('closeDialog')
      this.fileName = []
    }
  }
}
</script>

<style lang="scss" scoped>
  .blacklistManage-dialog {
    position: relative;
    // 改变下载模板位置
    .change-position {
      position: absolute;
      right: 0;
      display: inline-block;
      .btn-style {
        font-size: 14px;
        font-family: PingFangSC, PingFangSC-Regular;
        font-weight: 400;
        text-align: left;
        color: #0bb290;
        line-height: 20px;
      }
      span {
        font-size: 14px;
        font-family: PingFangSC, PingFangSC-Regular;
        font-weight: 400;
        text-align: left;
        color: #bac0cd;
        line-height: 20px;
      }
    }

    .dia-fail-black {
      .over-info {
        width: 380px;
        height: 200px;
        overflow: auto;
        z-index: 1;
        // overflow-x: hidden;
        .all-info {
          padding-left: 20px;
          margin: 0 auto;
          // padding-left: 10px;
          // padding-right: 20px;
          // box-sizing: border-box;
          overflow: auto;
          
          .fail-content {
            // padding-left: 10px;
            p {
            }
          }
        }

        
      }

      .over-info::-webkit-scrollbar {
        width: 5px;
        height: 1px;
      }
      .over-info::-webkit-scrollbar-thumb {
        border-radius: 10px;
        background-color: #ccc;
      }
      .over-info::-webkit-scrollbar-track {
        box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.2);
        background: #ededed;
        border-radius: 10px;
      }
    }

    /deep/ .el-dialog__title {
      font-size: 16px;
      font-family: PingFangSC, PingFangSC-Semibold;
      font-weight: 600;
      text-align: left;
      color: #333333;
      line-height: 22px;
    }
    // 弹框按钮样式迭代
    // 朴素按钮样式迭代
    // hover
    .footer-btn {
      /deep/ .el-button:first-child:hover {
        // color: rgba(11,178,144,1);
        color: rgba(11,178,144,1);
        border-color: rgba(11,178,144,1);
      }
      /deep/ .el-button:first-child:focus {
        // color: rgba(11,178,144,1);
        color: #ffffff;
        border-color: rgba(11,178,144,1);
      }
    }



    /deep/ .el-message-box {
      top: 18%;
      vertical-align: none!important;
    }

    // /deep/ .el-message-box__btns {
    //   /deep/ .el-button--default {
    //     color: #fff!important;
    //   }
    // }
  }
</style>