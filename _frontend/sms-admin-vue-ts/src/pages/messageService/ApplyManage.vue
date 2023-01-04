<template>
  <div class="ApplyManage">
    <div class="search">
      <m-form :formData="formData" :columns="formColumns" />
    </div>
    <div class="">
      <el-button type="primary" @click="addApply('add')" style="margin-left: 0px;">
        <i class="el-icon-circle-plus-outline icon-sign"></i>
        添加应用
      </el-button>
    </div>
    <div class="data-list" v-if="cardLiStData.length > 0">
      <el-card class="box-card" v-for="(item, index) of cardLiStData" :key="index"> <!--  :class="{ 'active': item.isActive === 1 }" -->
        <div class="card">
          <div class="card-title">
            <span>{{ item.name }}</span>
            <el-tooltip class="item" effect="dark" content="点击切换通道状态" placement="top">
              <!-- :disabled="item.needAuth === 1" -->
              <el-switch style="margin-left:15px;width: 32px;height:16px;" v-model="item.isActive" active-color="rgba(11,178,144,1)" @change="getSwitchValue(item)"></el-switch>
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="点击修改应用" placement="top">
              <img class="img-edit" src="@/assets/messageService/edit.png" alt="" @click="addApply('edit', item)" />
            </el-tooltip>
            <el-tooltip class="item" effect="dark" content="点击删除当前签名模板" placement="top">
              <img class="img-del" src="@/assets/messageService/delete.png" alt="" @click="deleteApply(item)" />
            </el-tooltip> 
          </div>
          <div class="card-content">
            <p>
              <span class="name-label">IP：</span>
              <span class="name-label-span">{{ item.ipAddr }}</span>
            </p>
            <p>
              <span class="name-label">认证Key： </span>
              <span class="name-label-span">{{ item.accessKeyId }}</span>
            </p>
            <p>
              <span class="name-label">认证秘钥：  </span>
              <span class="name-label-span">{{ item.accessKeySecret }}</span>
            </p>
            <p>
              <span class="name-label">创建时间：  </span>
              <span class="name-date">{{ item.createTime }}</span>
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
    <!-- 弹框部分 -->
    <ApplyDialog :title="applyTitle" :dialogShow="dialogShow" @closeDialog="closeDialog" :dialogData="sendApplyDiaData" />
    <!-- 删除动作 -->
    <el-dialog :visible.sync="centerDialogVisible" width="322px" center :show-close="false" top="22vh" class="dia-apply">
      <span class="diaLog-span" style="text-align:center;">确认删除?</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="centerDialogVisible = false" class="btn-sty">取 消</el-button>
        <el-button type="primary" @click="deteleApplyDialog" style="padding: 10px 20px;">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script lang="tsx">
import { Component, Vue } from 'vue-property-decorator'
import ApplyDialog from '@/components/messageService/ApplyDialog.vue'

@Component({
  components: {
    ApplyDialog
  }
})
export default class ApplyManage extends Vue {
  private formData = {} as any
  private applyTitle = '添加应用'
  private dialogShow = false
  private sendApplyDiaData = {} as any
  private centerDialogVisible = false
  private ids = [] as any
  // private cardLiStData = []
  private pageInfo = {
    current: 1,
    size: 16,
    total: 0
  }
  private cardLiStData = [] as any

  get formColumns () {
    return [
      {
        label: '模板名称：',
        prop: 'name',
        span: 6,
        el: 'input',
        placeholder: '请输入'
      },
      {
        prop: 'btn',
        span: 6,
        render: () => {
          return <div>
            <el-button type="primary" icon="el-icon-search" style="margin-left: 34px;margin-right: 17px;" onClick={this.getList}>搜索</el-button>
            <el-button icon="el-icon-edit" onClick={this.resetFun}>重置</el-button>
          </div>
        }
      }
    ]
  }

  created () {
    this.getList()
  }

  getList () {
    const { current, size } = this.pageInfo
    const params = {
      current,
      size,
      name: this.formData.name
    }
    this.$api.getPlatformPage(params).then(res => {
      if (res && res !== null) {
        this.cardLiStData = res.records.map((obj: any) => ({ choseCheck: false, ...obj, isActive: obj.isActive === 0 ? false : true  }))
        this.pageInfo.total = Number(res.total)
      }
    })
  }

  getSwitchValue (item: any) {
    const { id, isActive } = item
    const params = {
      id,
      isActive: isActive === true ? 1 : 0
    }
    this.$api.editPlatform(params).then(res => {
      if (res === true || res !== null) {
        const title = isActive === false ? '关闭应用成功' : '开启应用成功'
        this.$message.success(title)
        this.getList()
      }
    })
  }
  
  resetFun () {
    this.formData = {}
  }

  handleSizeChange(val: any) {
    this.pageInfo.size = val
  }

  handleCurrentChange(val: any) {
    this.pageInfo.current = val
    this.getList()
  }

  addApply (type: string, item?: any) {
    this.applyTitle = type === 'add' ? '添加应用' : '修改应用'
    this.dialogShow = true
    let newItem = {}
    if (type === 'edit') {
      newItem = {
        ...item,
        isActive: item.isActive === true ? 1 : 0
      }
    }
    this.sendApplyDiaData = {
      ...(newItem || {})
    }
  }

  deleteApply (item: any) {
    this.ids = []
    this.centerDialogVisible = true
    this.ids.push(item.id)
  }

  closeDialog () {
    this.dialogShow = false
    this.getList()
  }

  deteleApplyDialog () {
    // TODO
    const params = [
      ...this.ids
    ]
    this.$api.deletePlatform(params).then(res => {
      if (res === true || res !== null) {
        this.$message.success('删除成功')
        this.centerDialogVisible = false
        this.getList()
      }
    })
  }
}
</script>

<style lang="scss" scoped>
  .ApplyManage {
    width: 100%;
    height: 100%;
    position: relative;
    // min-width: 1000px;
    // min-height: 800px;
    .data-list {
      // width: 100%;
      // height: 100%;
      // margin-top: 20px;
      margin-top: 6px;
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
          height: 172px;
          background-color: #fff;
          border-radius: 10px;
          .card-title {
            span {
              margin-left: 20px;
              font-size: 18px;
              font-family: PingFangSC, PingFangSC-Medium;
              font-weight: 700;
              text-align: left;
              color: #20232a;
              line-height: 25px;
            }
            position: relative;
            width: 100%;
            height: 40px;
            line-height: 40px;
            margin-top: 10px;
            .title-logo {
              width: 70px;
              height: 33px;
              vertical-align: middle;
              margin-left: 30px;
              
            }
            .img-edit {
              cursor: pointer;
              position: absolute;
              right: 12%;
              top: 50%;
              transform: translateY(-50%);
              width: 19px;
              height: 19px;
              display: inline-block;
              vertical-align: middle;
            }

            .img-del {
              cursor: pointer;
              position: absolute;
              right: 4%;
              top: 50%;
              transform: translateY(-50%);
              width: 19px;
              height: 19px;
              display: inline-block;
              vertical-align: middle;
            }
          }
          .card-content {
            width: 100%;
            margin-left: 20px;
            margin-top: 12px;
            p {
              margin: 0;
              margin-top: 6px;
              .name-label {
                display: inline-block;
                width: 80px;
                font-size: 14px;
                font-family: PingFangSC, PingFangSC-Light;
                font-weight: 300;
                text-align: left;
                color: #777777;
                line-height: 20px;
              }
              .name-label-span {
                font-size: 14px;
                font-family: PingFangSC, PingFangSC-Light;
                font-weight: 300;
                text-align: left;
                color: #20232a;
                line-height: 20px;
              }
              .name-date {
                font-size: 14px;
                font-family: PingFangSC, PingFangSC-Light;
                font-weight: 300;
                text-align: left;
                color: #a2a5ac;
                line-height: 20px;
              }
            }
          }
          // &.active {
          //   background: #ebf1f0;
          // }
        }
      }
      @media (max-width:1720px) {
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
      .active {
        background: #ebf1f0;
        .card {
          background: #ebf1f0;
        }
      }
    }
    .data-list:after{
      content: '';
      width: 24.3%;
    }
    // no-data
    .no-data {
      // margin-top: 100px;
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
      // position: absolute;
      margin-top: 40px;
      margin-bottom: 50px;
      text-align: right;
      // bottom: -220px;
      // margin-top: 20px;
      right: 20px;
    }

    /deep/ .el-dialog {
      border-radius: 10px;
    }

    .dia-apply {
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
          margin-right: 20px;
          margin-bottom: 30px;
          padding: 10px 20px;
        }
      }
    }

    /deep/ .el-card__body {
      padding: 0px;
    }
  }
</style>