<template>
  <div class="template-dialog">
    <el-dialog :title="title" :visible.sync="dialogShow" :before-close="closeDialog" :close-on-click-modal="false" :show-close="true" width="660px" top="22vh">
      <m-form :formData="diaFormData" :columns="formColumns" ref="mform"></m-form>
      <div slot="footer" style="text-align:center;">
        <el-button @click="closeDialog" style="margin-right:30px;padding: 10px 20px;">取消</el-button>
        <el-button type="primary" style="margin-bottom:20px;padding: 10px 20px;" @click="addOrUpdateSign">确认</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop } from 'vue-property-decorator'

@Component
export default class TemplateDialog extends Vue {
  static componentName = 'TemplateDialog'

  @Prop([String]) title!: string
  @Prop([Boolean]) dialogShow!: boolean
  @Prop([Object]) diaFormData!: object

  $refs!: {
    mform: any;
  }

  get formColumns () {
    return [
      {
        label: '模板类型：',
        prop: 'type',
        el: 'radio-group',
        span: 22,
        list: [
          {
            label: '验证码',
            value: 1
          },
          {
            label: '通知',
            value: 2
          },
          {
            label: '推广',
            value: 3
          }
        ],
        rules: {
          required: true,
          trigger: 'change',
          message: '请勾选模板类型'
        }
      },
      {
        label: '模板名称：',
        prop: 'name',
        width: '100%',
        span: 22,
        el: 'input',
        placeholder: '长度限制1-30个字符，建议为用户真实应用名/公司名',
        rules: {
          required: true,
          trigger: 'blur',
          validator: (rules: any, value: string, callback: Function) => {
            if (!value) {
              callback(new Error('模板名称不能为空'))
            } else {
              if (value.length > 30 || value.length < 1) {
                callback(new Error('模板名称字符长度为1-30之间'))
              } else {
                callback()
              }
            }
          }
        }
      },
      {
        label: '模板内容：',
        prop: 'content',
        span: 22,
        el: 'input',
        type: 'textarea',
        maxlength: '200',
        'show-word-limit': true,
        clearable: true,
        height: 100,
        placeholder: '示例：您的验证码为：XXXXXX，该验证码5分钟内有 效，请勿泄露于他人。',
        rules: {
          required: true,
          trigger: 'blur',
          // message: '模板内容不能为空',
          validator: (rules: any, value: string, callback: Function) => {
            if (!value) {
              callback(new Error('模板内容不能为空'))
            } else {
              if (value.length > 200) {
                callback(new Error('模板内容输入小于等于200字符'))
              } else {
                callback()
              }
            }
          }
        }
      }
    ]
  }

  addOrUpdateSign () {
    this.$refs.mform.validate().then((value: boolean) => {
      if (value) {
        // TODO
        const params = {
          ...this.diaFormData
        }
        this.title === '添加模板' ? this.$api.addTemplate(params).then(res => {
          if (res === true || res !== null) {
            this.$message.success('新增模板成功')
            this.$emit('closeDialog')
          }
        }) : this.$api.editTemplate(params).then(res => {
          if (res === true || res !== null) {
            this.$message.success('修改模板成功')
            this.$emit('closeDialog')
          }
        })
      }
    })
  }

  closeDialog () {
    this.resetForm()
    this.$emit('closeDialog')
  }

  resetForm () {
    this.$refs.mform.resetFields()
  }
}
</script>

<style lang="scss" scoped>
  .template-dialog {
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

    /deep/ .el-radio-group {
      width: 100%;
    }
    // 单选框部分
    /deep/ .el-radio__input.is-checked .el-radio__inner {
      border-color: rgba(11,178,144,1);
      background: rgba(11,178,144,1);
    }
    /deep/ .el-radio__input.is-checked+.el-radio__label {
      color: rgba(11,178,144,1);
    }

    /deep/ .el-radio__inner:hover {
      border-color: rgba(11,178,144,1);
    }
    /deep/ .el-radio {
      margin-right: 50px;
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