<template>
  <div style="display:inline-block;" class="upload-btn">
    <input type="file" ref="upload" hidden @change="change" style="display:none;" />
    <el-button type="primary" v-bind="$attrs" @click="selectFile" v-on="$listeners" :disabled="disabled">
      <slot></slot>
      <div class="progress-fixed" v-show="show">
        <el-progress :text-inside="true" :stroke-width="18" :percentage="percentage" status="success"></el-progress>
      </div>
    </el-button>
    <ToastDialog title='' :dialogShow="dialogShow" @closeDialog="closeDialog">{{ commonTitle }}</ToastDialog>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop } from 'vue-property-decorator'

@Component
export default class UploadBtn extends Vue {
  static componentName = 'UploadBtn'

  private show = false
  private percentage = 0 as number
  private totalSize = 0
  private sizelist = []
  private dialogShow = false
  private commonTitle = '不支持此类文件！'

  @Prop([String]) fileName !: string
  @Prop([Boolean]) download !: boolean
  @Prop([Array]) fileSuffix !: Array<string>
  @Prop([String, Number]) maxSize !: string | number
  @Prop([String]) updateType !: string
  $refs !: {
    upload: any;
  }

  get disabled () {
    if (this.$attrs.disabled !== undefined) return this.$attrs.disabled
    if (this.download && !this.fileName) {
      return true
    }
    return false
  }
  
  change (e: any) {
    // TODO
    const fileItem = e.target.files[0]
      if (!fileItem) return
      const { name, size } = fileItem
      if (this.fileSuffix && this.fileSuffix.length) {
        const flag = this.fileSuffix.some(type =>
          name.toLocaleLowerCase().endsWith(type.toLocaleLowerCase())
        )
        if (!flag) {
          e.target.value = ''
          this.dialogShow = true
          return this.commonTitle = '不支持此类文件！'
        }
      }

    const uploadMethod = this.uploadFile
    if (this.maxSize && size / 1024 / 1024 > this.maxSize) {
      this.dialogShow = true
      return this.commonTitle = '文件过大'
    }

    this.show = true
    uploadMethod(fileItem).then((res: any) => {
      const newRes = {
        name: fileItem.name,
        size: (fileItem.size / 1024).toFixed(2),
        ...res
      }
      this.$emit('success', newRes)
      this.dialogShow = true
      this.commonTitle = '上传中，请稍后…'
      if (res && res.fail) {
        // 存在上传失败条数
        this.dialogShow = false
      }
    }).catch(() => {
      this.$message.error('文件上传失败，请重新上传！')
    }).finally(() => {
      this.show = false
      this.dialogShow = false
      e.target.value = ''
    })
  }

  uploadFile (fileItem: any, fileName = null, index = 0) {
    if (this.updateType === '营销') {
      return this.$api.uploadFile1({
        fileItem,
        fileName,
        onProgress: this.onUploadProgress.bind(this, index)
      })
    } else {
      return this.$api.uploadFile ({
        fileItem,
        fileName,
        onProgress: this.onUploadProgress.bind(this, index)
      })
    }
  }

  onUploadProgress (index: number, e: any) {
    if (this.totalSize) {
      this.$set(this.sizelist, index, e.loaded)
      this.percentage = Number((
        (this.sizelist.reduce((x, y) => {
          return x + (y || 0)
        }, 0) /
          this.totalSize) *
        100
      ).toFixed(1))
    } else {
      this.percentage = (e.loaded / e.total) * 100
    }
  }

  selectFile () {
    // TODO
    if (this.download) {
      // this.fileName && this.$api.downloadFile({ fileName: this.fileName })
    } else {
      this.$refs.upload.click()
    }
  }

  closeDialog () {
    this.dialogShow = false
  }
}
</script>

<style lang="scss" scoped>
  .progress-fixed {
    position: fixed;
    width: 600px;
    left: 50%;
    transform: translateX(-50%);
    // right: 20%;
    z-index: 9999999;
    top: 40%;

    /deep/ .el-button:first-child:hover {
      color: rgba(11,178,144,1);
      border-color: rgba(11,178,144,1);
    }
    /deep/ .el-button:first-child:focus {
      color: rgba(11,178,144,1);
      border-color: rgba(11,178,144,1);
    }

    /deep/ .el-message-box {
      width: 315px!important;
      height: 62px;
      background: #ffffff;
      border-radius: 10px;
    }
    /deep/ .el-message-box__message {
      text-align: center!important;
      .support {
        width: 100%;
        .not-support {
          height: 28px;
          font-size: 18px;
          font-family: PingFangSC, PingFangSC-Regular;
          font-weight: 400;
          text-align: center!important;
          color: #333333;
          line-height: 28px;
        }
      }
    }
    
    
  }
</style>