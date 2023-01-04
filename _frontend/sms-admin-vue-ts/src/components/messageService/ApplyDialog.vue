<template>
  <div class="ApplyDialog">
    <el-dialog :title="title" :visible.sync="dialogShow" :before-close="closeDialog" :close-on-click-modal="false" :show-close="true" width="660px" top="22vh">
      <m-form :formData="dialogData" :columns="formColumns" ref="mform" />
      <div slot="footer" style="text-align:center;">
        <el-button @click="closeDialog" style="margin-right:30px;padding: 10px 20px;">取消</el-button>
        <el-button type="primary" style="margin-bottom:20px;padding: 10px 20px;" @click="addOrUpdateSign">确认</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script lang="tsx">
import { Component, Vue, Prop } from 'vue-property-decorator'
interface DataType {
  name: string;
  ipAddr: string;
  isActive: boolean;
  remark: string;
  id: string;
}

@Component
export default class ApplyDialog extends Vue {
  static componentName = 'ApplyDialog'
  private formData = {} as any
  
  @Prop([String]) title!: string
  @Prop([Object]) dialogData!: DataType
  @Prop([Boolean]) dialogShow!: boolean

  $refs!: {
    mform: any;
  }

  get formColumns () {
    return [
      {
        label: '应用名称：',
        prop: 'name',
        span: 22,
        el: 'input',
        placeholder: '请输入',
        // maxlength: '10',
        // 'show-word-limit': true,
        rules: {
          required: true,
          trigger: 'blur',
          // message: '应用名称不能为空'
          validator: (rules: any, value: string, callback: Function) => {
            if (!value) {
              callback(new Error('应用名称不能为空'))
            } else {
              if (value.length > 10 || value.length < 1) {
                callback(new Error('应用名称字符长度为1-10之间'))
              } else {
                callback()
              }
            }
          }
        }
      },
      {
        label: 'IP地址：',
        prop: 'ipAddr',
        span: 22,
        el: 'input',
        placeholder: '请输入',
        // maxlength: '30',
        // 'show-word-limit': true,
        rules: {
          required: true,
          trigger: 'blur',
          // message: 'IP地址不能为空'
          validator: (rules: any, value: string, callback: Function) => {
            if (!value) {
              callback(new Error('IP地址不能为空'))
            } else {
              if (value.length > 30 || value.length < 0) {
                callback(new Error('IP地址字符长度为0-30之间'))
              } else {
                callback()
              }
            }
          }
        }
      },
      {
        label: '是否开启：',
        prop: 'isActive',
        span: 22,
        el: 'radio-group',
        placeholder: '请选择',
        list: [
          {
            label: '是',
            value: 1
          },
          {
            label: '否',
            value: 0
          }
        ],
        rules: {
          required: true,
          trigger: 'blur',
          message: '请勾选是否开启'
        }
      },
      {
        label: '备注：',
        prop: 'remark',
        span: 22,
        el: 'input',
        type: 'textarea',
        maxlength: '200',
        'show-word-limit': true,
        clearable: true,
        height: 100,
        placeholder: '示例：不可用原因'
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
      if (value) {
        // TODO
        const addParams = {
          name: this.dialogData.name,
          ipAddr: this.dialogData.ipAddr,
          isActive: this.dialogData.isActive,
          remark: !this.dialogData.remark ? '' : this.dialogData.remark
        }
        const editParams = {
          id: this.dialogData.id,
          name: this.dialogData.name,
          ipAddr: this.dialogData.ipAddr,
          isActive: this.dialogData.isActive,
          remark: !this.dialogData.remark ? '' : this.dialogData.remark
        }
        this.title === '添加应用' ? this.$api.addPlatform(addParams).then(res => {
          if (res === true || res !== null) {
            this.$message.success('添加应用成功')
            this.$emit('closeDialog')
          }
        }) : this.$api.editPlatform(editParams).then(res => {
          if (res === true || res !== null) {
            this.$message.success('修改应用成功')
            this.$emit('closeDialog')
          }
        })
      }
    })
  }
}
</script>

<style lang="scss" scoped>
  .ApplyDialog {
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