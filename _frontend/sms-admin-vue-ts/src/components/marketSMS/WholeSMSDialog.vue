<template>
  <div class="WholeSMSDialog">
    <el-dialog :title="title" :visible.sync="dialogShow" :before-close="closeDialog" :close-on-click-modal="false" :show-close="true" width="660px" top="22vh">
      <m-form ref="mform" :formData="formData" :columns="formColumns">
        <div slot="template">
          <m-select v-model="formData.template"  :get-list="getTemplateSelect" @change="getItemTemplate"></m-select>
        </div>
        <div slot="wordText" class="wordText">
          <p>{{ formData.content }}</p>
        </div>
        <div slot="value">
          <el-radio-group v-model="formData.value" @change="getValue">
            <el-radio :label="0">导入收信人</el-radio>
            <el-radio :label="1">添加收信人</el-radio>
          </el-radio-group>
        </div>
        <div slot="fileUpdate" v-if="formData.value === 0">
          <UploadBtn :disabled="fileName.length >= 1" type="primary" style="margin-left: 15px;vertical-align: middle;" :fileSuffix="fileSuffixXls" maxSize="10" icon="iconfont icon-wenjian" @success="wholeSMSSuccess" updateType="营销">选择文件</UploadBtn>
          <div class="change-position">
            <el-button type="text" class="btn-style" @click="downLoadFile">下载模板</el-button>
            <span>（仅支持Excel文件，小于2M）</span>
          </div>
          <!-- 展示上传文件名部分 -->
          <div style="margin-top: 6px;margin-left: 15px;">
            <p v-for="(item, index) in fileName" :key="index" style="color: #20232a;">
              <span>{{ item.name }}</span>（<span>{{ item.size }}</span>）
              <el-button @click="deleteUpdateFiles(item, index)" type="text" style="margin-left: 20px;color: rgba(255,90,90,1);">删除</el-button>
              <el-button v-if="item.errormsgs.length > 0" @click="detailsUpdateFiles(index)" type="text" style="margin-left: 20px;color: #0bb290;">失败详情</el-button>
            </p>
          </div>
        </div>
      </m-form>
      <div slot="footer" style="text-align:center;">
        <el-button @click="closeDialog" style="margin-right:30px;padding: 10px 20px;">取消</el-button>
        <el-button type="primary" style="margin-bottom:20px;padding: 10px 20px;" @click="addOrUpdateSign">确认</el-button>
      </div>
    </el-dialog>
    <el-dialog title="失败详情" :visible.sync="centerDialogVisible" width="435px" center :show-close="true" top="32vh" class="dia-fail-black">
      <div class="over-info">
        <div class="fail-content">
          <h3 style="color: #ff5a5a;text-align: center;">导入失败，格式错误!</h3>
          <p>
            <span>{{fileName.length > 0 && fileName[this.failIndex].errormsgs.join(',')}}</span>
          </p>
        </div>
      </div>
      <span slot="footer" class="dialog-footer">
        <el-button type="primary" @click="centerDialogVisible = false" style="padding: 10px 20px;">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script lang="tsx">

import { Component, Vue, Prop, Watch } from 'vue-property-decorator'
interface ListType {
  signature: string;
}

@Component
export default class WholeSMSDialog extends Vue {
  static componentName = 'WholeSMSDialog'

  private centerDialogVisible = false
  private failIndex = 0

  @Prop([String]) title!: string
  @Prop([Boolean]) dialogShow!: boolean
  @Prop([Object]) dialogData !: object

  private formData = {
    ...this.dialogData,
    value: 0,
    template: '',
    list: [] as any,
    paramFieldsList: [] as any,
    content: ''
  } as any

  private fileSuffixXls = ['xlsx', 'xls']
  private fileName = [] as any

  @Watch('dialogData', { immediate: true })
  watchDialogData () {
    this.formData = {
      ...this.dialogData,
      value: 0,
      list: [{
        inputValue: ''
      }],
      paramFieldsList: []
    } as any
  }

  @Watch('dialogData.template', { deep: true })
  getEditTemplate () {
    this.fileName = []
    if ((this as any).dialogData.template) {
      const newList = []
      const newJsonContent = JSON.parse((this as any).dialogData.content)
      for (const item in newJsonContent) {
        newList.push({
          objKey: item,
          objValue: newJsonContent[item]
        })
      }
      this.formData.paramFieldsList = [
        ...newList
      ]
      this.formData.content = (this as any).dialogData.contentText
      this.formData.value = (this as any).dialogData.mobileFile ? 0 : 1
      if (!(this as any).dialogData.mobileFile) this.formData.list = (this as any).dialogData.mobiles.split(',').map((obj: any) => ({ inputValue: obj }))
      if ((this as any).dialogData.mobileFile) this.fileName.push({ name: (this as any).dialogData.mobileFile, size: 0 }) 
      // this.getItemTemplate(this.formData.template)
      this.formData.content = this.formData.contentText
      // this.postTemplateBuild({ code: this.formData.template, content: JSON.stringify(this.formData.paramFieldsList.map((obj: any) => ({ [obj.objKey]: obj.objValue }))) })
    }
  }

  get formColumns () {
    return [
      {
        label: '主题：',
        prop: 'title',
        placeholder: '请输入',
        span: 22,
        el: 'input',
        rules: {
          required: true,
          trigger: 'blur',
          message: '主题不能为空'
        }
      },
      {
        label: '签名名称：',
        prop: 'signature',
        placeholder: '请选择',
        span: 22,
        el: 'mSelect',
        getList: this.$api.getSignatureSelect,
        clearable: true,
        rules: {
          required: true,
          trigger: 'blur',
          message: '签名名称不能为空'
        }
      },
      {
        label: '模板：',
        prop: 'template',
        placeholder: '请选择',
        span: 22,
        el: 'mSelect',
        clearable: true,
        rules: {
          required: true,
          trigger: 'blur',
          message: '模板不能为空'
        }
      },
      ...this.getFieldsColumns(),
      {
        label: '预览：',
        prop: 'wordText',
        span: 19
      },
      {
        label: '收信人：',
        prop: 'value',
        span: 22,
        rules: {
          required: true,
          trigger: 'change',
          message: ''
        }
      },
      {
        prop: 'fileUpdate',
        span: 19,
        offset: 3
      },
      ...(this.formData.value === 1 ? [
        ...this.getOtherColumns()
      ] : [])
    ]
  }

  $refs!: {
    mform: any;
  }

  created () {
    // TODO
  }

  getTemplateSelect () {
    return this.$api.getTemplateSelect()
  }

  // 模板改变取值
  getItemTemplate (code: string) {
    // TODO
    code && this.$api.getTemplateParamFields({ code }).then(res => {
      if (res && res !== null) {
        this.formData.paramFieldsList = res.data.map((obj: any) => {
          return {
            objKey: obj,
            objValue: ''
          }
        })
        this.formData.content = res.content
      }
    })
  }

  closeDialog () {
    this.resetForm()
    this.fileName = []
    this.$emit('closeDialog')
  }

  getValue (data: number) {
    if (data === 1) this.formData.list = [{inputValue: ''}]
    else {
      this.fileName = []
    }
  }

  // 获取返回数据
  wholeSMSSuccess (data: any) {
    this.fileName.push({
      name: data.name,
      size: data.size,
      mobiles: data.mobiles,
      errormsgs: data.errormsgs
    })
    const vnode = (
      <div style="border-radius: 10px;">
        <h1 style="text-align:center;font-size: 20px;">导入完毕！</h1>
        <p style="text-align:center;margin-bottom: 17px;">
          <span style="color: #333333;font-size: 16px;font-weight: 500;">成功导入</span> <span style="color: #0bb290;font-weight: 700;font-size: 16px;">{ data.count - data.fail }</span>&nbsp;&nbsp;
          <span style="color: #333333;font-size: 16px;font-weight: 500;">失败</span> <span style="color:red;font-weight: 700;font-size: 16px;">{ data.fail }</span>
        </p>
      </div>
    )
    this.$msgbox({
      message: vnode,
      confirmButtonText: '确定'
    })
  }
  
  resetForm () {
    this.$refs.mform.resetFields()
    this.fileName = []
  }

  downLoadFile () {
    window.location.href = '/static/导入收信人模板.xlsx'
  }

  addOrUpdateSign () {
    this.$refs.mform.validate().then((value: boolean) => {
      if (value) {
        if (this.formData.value === 0 && this.fileName.length === 0) {
          this.$message.error('文件导入不能为空')
        } else {
          const selectList = this.formData.paramFieldsList.map((obj: any) => ({ [obj.objKey]: obj.objValue }))
          const moreMobiles = this.formData.value === 0 ? this.fileName.map((obj: any) => (obj.mobiles)).join().split(',').join(',') : this.formData.list.map((obj: any) => (obj.inputValue)).join(',')
          const params = {
            ...this.formData,
            content: JSON.stringify(selectList),
            mobiles: moreMobiles,
            mobileFile: this.formData.value === 0 ? this.fileName[0].name : null
          }
          delete params.list
          delete params.paramFieldsList
          // 文件上传类
          if (this.formData.value === 0 && this.fileName !== []) {
            this.title === '新建短信' ? this.updateOrAdd(params) : this.editMarketing(params)
          } else if (this.formData.value === 1) {
            this.title === '新建短信' ? this.updateOrAdd(params) : this.editMarketing(params)
          } else {
            this.$message.error('文件导入不能为空')
            return
          }
        }
        
      } else {
        // this.$message.error()
      }
    })
  }

  updateOrAdd (params: any) {
    this.$api.addMarketing(params).then(res => {
      if (res === true || res !== null) {
        this.$emit('closeDialog')
        this.$message.success('新建短信成功')
        this.fileName = []
      }
    })
  }

  editMarketing (params: any) {
    this.$api.editMarketing(params).then(res => {
      if (res === true || res !== null) {
        this.$emit('closeDialog')
        this.$message.success('修改短信成功')
        this.fileName = []
      }
    })
  }

  addDomain () {
    if (this.formData.list.length >= 10) {
      this.$message.error('收信人手机号最多添加十个')
      return
    }
    this.formData.list.push({
      inputValue: ''
    })
  }

  postTemplateBuild (params: any) {
    this.$api.postTemplateBuild(params).then(res => {
      if (res) {
        this.formData.content = res
        // this.$forceUpdate()
      }
    })
  }

  getFieldsColumns () {
    return this.formData.paramFieldsList.map((obj: any, index: number) => {
      return [
        {
          label: obj ? `${obj.objKey}：` : `变量${index + 1}：`,
          prop: `paramFieldsList[${index}].objValue`,
          el: 'input',
          span: 22,
          placeholder: `请输入${obj.objKey}`,
          listeners: {
            change: () => {
              this.formData.paramFieldsList.forEach((obj: any) => {
                if (obj.objValue && this.formData.content) {
                  // this.formData.content = this.formData.content.replace('$', '').replace('{', '').replace('}', '').replace(`${obj.objKey}`, obj.objValue)
                  this.postTemplateBuild({ code: this.formData.template, content: JSON.stringify(this.formData.paramFieldsList.map((obj: any) => ({ [obj.objKey]: obj.objValue })))})
                  // this.$forceUpdate()
                }
              })
            }
          },
          rules: {
            required: true,
            trigger: 'blur',
            message: `${obj.objKey}不能为空`
          }
        }
      ]
    }).flat()
  }  

  getOtherColumns () {
    return this.formData.list.map((obj: any, index: number) => {
      return [
        {
          prop: `list[${index}].inputValue`,
          el: 'input',
          span: 16,
          offset: 3,
          placeholder: `请输入手机号${index + 1}`,
          rules: {
            required: true,
            trigger: 'blur',
            validator: (rule: any, value: string, callback: Function) => {
              if (!value) {
                callback(new Error('手机号不能为空'))
              } else {
                const reg = /^[1][3,4,5,7,8][0-9]{9}$/
                if (!reg.test(value)) {
                  callback(new Error('手机号格式不正确'))
                } else {
                  callback()
                }
              }
            }
          }
        },
        {
          prop: `del${index}`,
          span: 2,
          render: 
            this.formData.list.length !== 1 &&  index !== 0 ? (
            <el-button type="text" onClick={() => { this.formData.list.splice(index, 1) }} class="render-style">
              <el-tooltip class="item" effect="dark" content={`点击删除第${index + 1}收信人手机号`} placement="top">
                <img src={require('@/assets/marketSMS/del.png')} alt="" />
              </el-tooltip>
            </el-button>
          ) : null
        },
        {
          prop: `add${index}`,
          span: 2,
          render: index === 9 ? null :
          (
            <el-button type="text" onClick={this.addDomain} class="render-style">
              <el-tooltip class="item" effect="dark" content="点击新增" placement="top">
                <img src={require('@/assets/marketSMS/add.png')} alt="" />
              </el-tooltip>
            </el-button>
          )
        }
      ]
    }).flat()
  }

  // 删除上传文件操作
  deleteUpdateFiles (item: string, index: number) {
    // TODO
    this.fileName.splice(index, 1)
    this.$message.success('文件删除成功')
  }

  detailsUpdateFiles (index: number) {
    this.centerDialogVisible = true
    this.failIndex = index
  }
}
</script>

<style lang="scss" scoped>
  .WholeSMSDialog {

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

    .render-style {
      img {
        width: 18px;
        height: 18px;
      }
    }

    // 设置短信模板样式
    .wordText {
      font-size: 14px;
      font-family: PingFangSC, PingFangSC-Regular;
      font-weight: 400;
      text-align: left;
      color: #bac0cd;
      line-height: 20px;
      p {
        margin: 0;
        margin-top: 6px;
      }
    }
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


    // 弹框按钮样式迭代
    // 朴素按钮样式迭代
    // hover
    /deep/ .el-button:first-child:hover {
      color: rgba(11,178,144,1);
      // border-color: rgba(11,178,144,1);
      border-color: none;
    }
    /deep/ .el-button:first-child:focus {
      color: rgba(11,178,144,1);
      // border-color: rgba(11,178,144,1);
      border-color: none;
    }


    .dia-fail-black {
      .over-info {
        width: 380px;
        height: 200px;
        overflow: auto;
        z-index: 1;
        .fail-content {
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
  }
</style>