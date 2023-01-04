<template>
  <div class="SignOrTemRelateDialog">
    <el-dialog :title="title" :visible.sync="dialogShow" :before-close="closeDialog" :close-on-click-modal="false" :show-close="true" width="660px" top="22vh" height="600px">
      <m-form ref="mform" :formData="diaFormData" :columns="formColumns"></m-form>
      <div slot="footer" style="text-align:center;">
        <el-button @click="closeDialog" style="margin-right:30px;padding: 10px 20px;">取消</el-button>
        <el-button type="primary" style="margin-bottom:20px;padding: 10px 20px;" @click="signOrTemplate">确认</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop } from 'vue-property-decorator'
interface DiaCom {
  dataList: Array<object>;
  signatureIds: Array<string>;
  templateIds: Array<string>;
  id: string;
  formPassWayId: string;
  configSignatureCode: string;
  configTemplateCode: string;
  title: string;
  formPassWayIdTem: string;
}

@Component
export default class SignOrTemRelateDialog extends Vue {
  @Prop([String]) title!: string
  @Prop([Boolean]) dialogShow!: boolean
  @Prop([Object]) diaFormData!: DiaCom
  $refs!: {
    mform: any;
  }

  get formColumns () {
    return [
      ...(this.title !== '修改其他配置' ? [
        {
          label: `${this.title.slice(this.title.length - 2)}名称`,
          prop: this.title === '关联更多签名' ? 'signatureIds' : 'templateIds',
          span: 22,
          el: 'mSelect',
          multiple: true,
          dataList: this.diaFormData.dataList,
          rules: {
            required: true,
            trigger: 'blur',
            message: `${this.title.slice(this.title.length - 2)}名称不能为空`
          }
        }
      ] : []),
      ...(this.title === '修改其他配置' ? [
        {
          label: '',
          labelWidth: '50px',
          prop: this.diaFormData.title === '签名' ? 'configSignatureCode' : 'configTemplateCode',
          span: 22,
          el: 'input',
          placeholder: '例如：第三方通道的签名id或内容，没有固定规则',
          type: 'textarea'
        }
      ] : []),
    ]
  }
  closeDialog () {
    this.$emit('closeDialog')
  }

  resetForm () {
    this.$refs.mform.resetFields()
  }

  signOrTemplate () {
    this.$refs.mform.validate().then((value: boolean) => {
      if (value) {
        // TODO
        if (this.title !== '修改其他配置') {
          const paramsSign = {
            id: this.diaFormData.formPassWayId,
            signatureIds: this.diaFormData.signatureIds
          }
          const paramsTem = {
            id: this.diaFormData.formPassWayIdTem,
            templateIds: this.diaFormData.templateIds
          }
          let params = {}
          this.title === '关联更多签名' ? params = { ...paramsSign } : params = { ...paramsTem }
          this.$api.editConfig(params).then(res => {
            if (res === true || res !== null) {
              this.$emit('closeDialog')
              this.$message.success(`关联更多${this.title.slice(this.title.length - 2)}成功`)
            }
          })
        } else {
          const sign = {
            configId: this.diaFormData.formPassWayId,
            signatureId: this.diaFormData.id,
            configSignatureCode: this.diaFormData.configSignatureCode
          }
          const tem = {
            configId: this.diaFormData.formPassWayIdTem,
            templateId: this.diaFormData.id,
            configTemplateCode: this.diaFormData.configTemplateCode
          }
          let params = {}
          this.diaFormData.title === '签名' ? params = { ...sign } : params = { ...tem }
          this.$api.editConfigOther(params).then(res => {
            if (res === true || res !== null) {
              this.$emit('closeDialog')
              this.$message.success(`${this.diaFormData.title}其他配置修改成功`)
            }
          })
        }
      }
    })
  }
}
</script>

<style lang="scss" scoped>
  .SignOrTemRelateDialog {
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


    // 覆盖多选框颜色样式
    /deep/ .el-select .el-input.is-focus .el-input__inner {
      border-color: rgba(11,178,144,1);
    }
  }
</style>