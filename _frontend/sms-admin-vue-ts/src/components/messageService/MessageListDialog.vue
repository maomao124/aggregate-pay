<template>
  <div class="dialog-item">
    <el-dialog :title="title" :visible.sync="dialogShow" :before-close="closeDialog" :close-on-click-modal="false" :show-close="true" width="660px" top="22vh">
      <m-form :formData="diaFormData" :columns="formColumns" ref="mform" />
      <div slot="footer" style="text-align:center;">
        <el-button @click="closeDialog" style="margin-right:30px;padding: 10px 20px;font-weight: 300;">取消</el-button>
        <el-button type="primary" style="margin-bottom:20px;padding: 10px 20px;font-weight: 300;" @click="addOrUpdateSign">确认</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop } from 'vue-property-decorator'

@Component
export default class MessageListDialog extends Vue {
  static componentName = 'MessageListDialog'
  
  @Prop([Boolean]) dialogShow!: boolean
  @Prop([String]) title!: string
  @Prop([Object]) diaFormData!: object
  
  $refs!: {
    mform: any;
  }

  get formColumns () {
    return [
      {
        label: '签名名称：',
        prop: 'name',
        placeholder: '长度限制2-12个字符，建议为用户真实应用名/公司名',
        el: 'input',
        span: 22,
        width: '100%',
        clearable: true,
        rules: {
          required: true,
          trigger: 'blur',
          validator: (rules: any, value: string, callback: Function) => {
            if (!value) {
              callback(new Error('签名名称不能为空'))
            } else {
              if (value.length > 12 || value.length < 2) {
                callback(new Error('签名名称字符长度为2-12之间'))
              } else {
                callback()
              }
            }
          }
        }
      },
      {
        label: '备注：',
        prop: 'remark',
        placeholder: '',
        el: 'input',
        span: 22,
        type: 'textarea',
        maxlength: '200',
        'show-word-limit': true,
        clearable: true,
        height: 100
      }
    ]
  }

  closeDialog () {
    this.resetForm()
    this.$emit('closeDialog')
  }
  
  resetForm () {
    this.$refs.mform.resetFields()
  }

  addOrUpdateSign () {
    this.$refs.mform.validate().then((value: boolean) => {
      const params = {
        ...this.diaFormData
      } as any
      if (this.title === '修改签名') {
        delete params.createTime
        delete params.updateTime
        delete params.createUser
        delete params.updateUser
        delete params.isDelete
      }
      if (value) {
        this.title === '添加签名' ? this.$api.addSignature(params).then(res => {
          if (res === true || res !== null) {
            this.$message.success('新增签名成功')
            this.$emit('closeDialog')
          }
        }) : this.$api.editSignature(params).then(res => {
          if (res === true || res !== null) {
            this.$message.success('修改签名成功')
            this.$emit('closeDialog')
          }
        })
      }
    })
  }
}
</script>

<style lang="scss" scoped>
  .dialog-item {
    /deep/ .el-dialog {
      border-radius: 10px;
    }
    /deep/ .el-dialog__title {
      font-size: 16px;
      font-family: PingFangSC, PingFangSC-Semibold;
      font-weight: 600;
      text-align: left;
      color: #333333;
      line-height: 22px;
    }
    /deep/ .el-textarea__inner {
      height: 134px!important;
    }
    /deep/ .el-input__inner:focus {
      border-color: rgba(11,178,144,1);
    }
    /deep/ .el-textarea__inner:focus {
      border-color: rgba(11,178,144,1);
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