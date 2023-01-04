<template>
  <div class="RelationSign">
    <div class="search">
      <m-form :formData="formData" :columns="formColumns" />
    </div>
    <div class="">
      <el-button type="primary" @click="addRelSign('add')" style="margin-right: 26px;">关联更多签名</el-button>
    </div>
    <div class="data-list" v-if="cardLiStData.length > 0">
      <el-card class="box-card" v-for="(item, index) of cardLiStData" :key="index">
        <div class="card">
          <div class="card-word">
            <span class="word-text">{{item.code}}</span>
            <span class="card-img juli" @click="addRelSign('edit', item)">
              <el-tooltip class="item" effect="dark" content="修改其他配置" placement="top">
                <img src="@/assets/messageService/edit.png" alt="" />
              </el-tooltip>
            </span>
          </div>
          <div class="name-date">
            <p>
              <span class="name-label">签名名称：</span>
              <span class="name-label">{{ item.name }}</span>
            </p>
            <p>
              <span class="name-label">其他配置：</span>
              <span class="name-label">{{ item.configSignatureCode }}</span>
            </p>
          </div>
        </div>
      </el-card>
      <div class="pick"></div>
    </div>
    <!-- TODO 暂无数据处理-->
    <div v-else class="no-data">
      <div>
        <img src="@/assets/messageService/no-data.png" alt="" />
        <p>这里什么都没有哦～</p>
      </div>
    </div>
    <div class="paging" v-if="pageInfo.total > 16">
      <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="pageInfo.current" :page-size="pageInfo.size" layout="total, prev, pager, next, jumper" :total="pageInfo.total">
      </el-pagination>
    </div>
    <!-- 关联弹框动作 -->
    <SignOrTemRelateDialog :dialogShow="dialogShow" @closeDialog="closeDialog" :title="SignTitle" :diaFormData="signFormData" />
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import SignOrTemRelateDialog from './signOrTemRelate/SignOrTemRelateDialog.vue'
import { getList } from '@/api/ajax'

@Component({
  components: {
    SignOrTemRelateDialog
  }
})
export default class RelationSign extends Vue {
  private formData = {} as any
  private dialogShow = false
  private SignTitle = '关联更多签名'
  private signFormData = {}
  private pageInfo = {
    current: 1,
    size: 16,
    total: 0
  }
  private diaChoiceList = [] as any
  private cardLiStData = [] as any

  get formColumns () {
    return [
      {
        label: '签名编号：',
        prop: 'code',
        el: 'input',
        placeholder: '请输入',
        span: 6
      },
      {
        label: '签名名称：',
        prop: 'name',
        el: 'input',
        placeholder: '请输入',
        span: 6
      },
      {
        prop: 'btn',
        span: 6,
        render: () => {
          return <div>
            <el-button type="primary" icon="el-icon-search" onClick={this.getList} style="margin-left: 34px;margin-right: 17px;">搜索</el-button>
            <el-button icon="el-icon-edit" onClick={this.resetFun}>重置</el-button>
          </div>
        }
      }
    ]
  }

  created () {
    this.getList()
    this.getSignList()
  }
  getList () {
    const { size, current } = this.pageInfo
    const params = {
      current,
      size,
      name: this.formData.name,
      code: this.formData.code,
      configId: this.$route.query.id
    }
    this.$api.getSignatureCustomPage(params).then(res => {
      if (res && res !== null) {
        this.cardLiStData = [
          ...res.records
        ]
        this.pageInfo.total = Number(res.total)
      }
    })
  }
  // 获取签名管理所有数据
  getSignList () {
    const params = {}
    this.$api.getSignaturePage(params).then(res => {
      if (res && res !== null) {
        this.diaChoiceList = res.records.map((obj: any) => ({ label: obj.name, value: obj.id }))
      }
    })
  }

  resetFun () {
    this.formData = {}
  }

  addRelSign (type: string, item?: any) {
    // TODO
    this.SignTitle = type === 'add' ? '关联更多签名' : '修改其他配置'
    this.dialogShow = true
    // 请求mSelect数据传递子组件
    const params = {
      current: 1,
      size: 16
    }
    getList(`/config/${this.$route.query.id}`, params).then((res: any) => {
      if (res) {
        let newItem = {}
        newItem = {
          dataList: [ ...this.diaChoiceList ],
          signatureIds: res.signatureIds,
          ...item,
          formPassWayId: this.$route.query.id,
          title: '签名'
        }
        this.signFormData = {
          ...(newItem || {})
        }
      }
    })
  }

  handleSizeChange(val: any) {
    this.pageInfo.size = val
  }

  handleCurrentChange(val: any) {
    this.pageInfo.current = val
    this.getList()
  }

  closeDialog () {
    this.dialogShow = false
    this.getList()
  }
}
</script>

<style lang="scss" scoped>
  .RelationSign {
    width: 100%;
    height: 100%;
    position: relative;
    .data-list {
      // width: 100%;
      // height: 100%;
      margin-top: 20px;
      display: flex;
      flex-direction: row;
      flex-wrap: wrap;
      justify-content: space-between;
      .box-card {
        width: 24.3%;
        margin-top: 14px;
        border-radius: 10px;
        // min-width: 400px;
        .card {
          width: 100%;
          // margin-top: 20px;
          height: 128px;
          background-color: #fff;
          border-radius: 10px;
          overflow: hidden;
          .checkbox-style {
            margin-top: 10px;
            margin-left: 10px;
            /deep/ .el-checkbox__input.is-checked .el-checkbox__inner, .el-checkbox__input.is-indeterminate .el-checkbox__inner {
              background-color: #0bb290;
              border-color: #0bb290;
            }
          }
          .card-word {
            margin-left: 20px;
            margin-top: 20px;
            // text-align: center;
            overflow: hidden;
            position: relative;
            .word-text {
              font-size: 18px;
              font-family: PingFangSC, PingFangSC-Medium;
              font-weight: 700;
              text-align: left;
              color: #20232a;
              line-height: 25px;
              margin-right: 80px;
            }
            .card-img {
              cursor: pointer;
              display: inline-block;
              text-align: right;
              img {
                width: 18px;
                height: 18px;
                vertical-align: middle;
              }
            }
            .juli {
              // margin-left: 15px;
              position: absolute;
              right: 16px;
            }
          }
          .name-date {
            margin-left: 20px;
            margin-top: 18px;
            p {
              margin: 0;
              margin-top: 6px;
              .name-label {
                font-size: 14px;
                font-family: PingFangSC, PingFangSC-Light;
                font-weight: 300;
                text-align: left;
                color: #777777;
                line-height: 20px;
              }
            }
          }
        }
      }
      @media (max-width:1630px) {
        .box-card {
          float: left;
          width: 32.6%;
          box-sizing: border-box;
          padding: 10px;
          min-width: 150px;
        }
      }
      @media (max-width:1366px) {
        .box-card {
          float: left;
          width: 32.6%;
          box-sizing: border-box;
          padding: 10px;
          min-width: 150px;
        }
      }
      @media (max-width:1200px) {
        .box-card {
          float: left;
          width: 32.6%;
          box-sizing: border-box;
          padding: 10px;
          min-width: 150px;
        }
      }
      .pick {
        width: 24.3%;
        overflow: hidden;
      }
    }
    .data-list:after{
      content: '';
      width: 24.3%;
    }
    // no-data
    .no-data {
      margin-top: 100px;
      width: 100%;
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      div {
        img {
          display: block;
          width: 200px;
          height: 168px;
          border: 1px dashed #ccc;
        }
        p {
          margin: 0;
          margin-top: 32px;
          font-size: 16px;
          font-family: SourceHanSansCN, SourceHanSansCN-Normal;
          font-weight: Normal;
          text-align: center;
          color: #20232a;
          line-height: 24px;
        }
      }
    }
    
    .paging {
      position: absolute;
      margin-top: 40px;
      margin-bottom: 50px;
      text-align: right;
      bottom: -10px;
      right: 20px;
    }

    // 按钮样式修改
    .el-button–primary {
      color: rgba(11,178,144,1);
      background-color: #8B83D2;
      border-color: #8B83D2;
    }
    .el-button–primary:hover {
      background-color: rgba(11,178,144,1);
      border-color: rgba(11,178,144,1);
    }
    .el-button–primary:focus {
      background-color: rgba(11,178,144,1);
      border-color: rgba(11,178,144,1);
    }


    /deep/ .el-card__body {
      padding: 0px;
    }
  }
</style>