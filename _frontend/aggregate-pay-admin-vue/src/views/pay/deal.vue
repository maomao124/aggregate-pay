<template>
  <div class="bill-container">
      <h3>应用交易总览</h3>
         <el-date-picker
            v-model="value1"
            type="daterange"
            range-separator="~"
            value-format="yyyy-MM-dd"
            @change="changes"
            start-placeholder="开始日期"
            end-placeholder="结束日期">
        </el-date-picker>
    <div>

    </div>
    <p>汇总数据</p>
    <el-table
      :data="list"
      fit
      highlight-current-row
      border
      stripe
      style="width: 100%"
    >
      <el-table-column align="center" label="总交易额">
        <template slot-scope="scope">
          <span>{{scope.row.totalAmount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="退款金额">
        <template slot-scope="scope">
          <span>{{scope.row.refundAmount}}</span>
        </template>
      </el-table-column>

 
      <el-table-column align="center" label="成功交易金额">
        <template slot-scope="scope">
          <span>{{scope.row.successAmount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="手续费">
        <template slot-scope="scope">
          <span>{{scope.row.fee}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="净收入">
        <template slot-scope="scope">
          <span>{{scope.row.incomeAmount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="发起笔数">
        <template slot-scope="scope">
          <span>{{scope.row.requestNumber}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="退款笔数">
        <template slot-scope="scope">
          <span>{{scope.row.refundNumber}}</span>
        </template>
      </el-table-column>


        <el-table-column align="center" label="成功笔数">
            <template slot-scope="scope">
                <span>{{scope.row.successNumber}}</span>
            </template>
        </el-table-column>

        <el-table-column align="center" label="转化率">
            <template slot-scope="scope">
                <span>{{scope.row.conversion}}</span>
            </template>
        </el-table-column>

        <el-table-column align="center" label="平均订单金额">
            <template slot-scope="scope">
                <span>{{scope.row.avgAmount}}</span>
            </template>
        </el-table-column>

        <el-table-column align="center" label="平均费率">
            <template slot-scope="scope">
                <span>{{scope.row.avgRate}}</span>
            </template>
        </el-table-column>
    </el-table>
    <p>各渠道交易数据</p>
    <el-table
      :data="channelList"
      fit
      highlight-current-row
      border
      stripe
      style="width: 100%"
    >
    <el-table-column align="center" label="渠道名称">
        <template slot-scope="scope">
          <span>{{scope.row.channelName}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="总交易额">
        <template slot-scope="scope">
          <span>{{scope.row.totalAmount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="退款金额">
        <template slot-scope="scope">
          <span>{{scope.row.refundAmount}}</span>
        </template>
      </el-table-column>

 
      <el-table-column align="center" label="成功交易金额">
        <template slot-scope="scope">
          <span>{{scope.row.successAmount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="手续费">
        <template slot-scope="scope">
          <span>{{scope.row.fee}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="净收入">
        <template slot-scope="scope">
          <span>{{scope.row.incomeAmount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="发起笔数">
        <template slot-scope="scope">
          <span>{{scope.row.requestNumber}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="退款笔数">
        <template slot-scope="scope">
          <span>{{scope.row.refundNumber}}</span>
        </template>
      </el-table-column>


        <el-table-column align="center" label="成功笔数">
            <template slot-scope="scope">
                <span>{{scope.row.successNumber}}</span>
            </template>
        </el-table-column>

        <el-table-column align="center" label="转化率">
            <template slot-scope="scope">
                <span>{{scope.row.conversion}}</span>
            </template>
        </el-table-column>

        <el-table-column align="center" label="平均订单金额">
            <template slot-scope="scope">
                <span>{{scope.row.avgAmount}}</span>
            </template>
        </el-table-column>

        <el-table-column align="center" label="平均费率">
            <template slot-scope="scope">
                <span>{{scope.row.avgRate}}</span>
            </template>
        </el-table-column>
    </el-table>
    <p>各应用交易数据</p>
    <el-table
      :data="typeList"
      fit
      highlight-current-row
      border
      stripe
      style="width: 100%"
    >
    <el-table-column align="center" label="应用名称">
        <template slot-scope="scope">
          <span>{{scope.row.appName}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="总交易额">
        <template slot-scope="scope">
          <span>{{scope.row.totalAmount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="退款金额">
        <template slot-scope="scope">
          <span>{{scope.row.refundAmount}}</span>
        </template>
      </el-table-column>

 
      <el-table-column align="center" label="成功交易金额">
        <template slot-scope="scope">
          <span>{{scope.row.successAmount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="手续费">
        <template slot-scope="scope">
          <span>{{scope.row.fee}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="净收入">
        <template slot-scope="scope">
          <span>{{scope.row.incomeAmount}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="发起笔数">
        <template slot-scope="scope">
          <span>{{scope.row.requestNumber}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="退款笔数">
        <template slot-scope="scope">
          <span>{{scope.row.refundNumber}}</span>
        </template>
      </el-table-column>


        <el-table-column align="center" label="成功笔数">
            <template slot-scope="scope">
                <span>{{scope.row.successNumber}}</span>
            </template>
        </el-table-column>

        <el-table-column align="center" label="转化率">
            <template slot-scope="scope">
                <span>{{scope.row.conversion}}</span>
            </template>
        </el-table-column>

        <el-table-column align="center" label="平均订单金额">
            <template slot-scope="scope">
                <span>{{scope.row.avgAmount}}</span>
            </template>
        </el-table-column>

        <el-table-column align="center" label="平均费率">
            <template slot-scope="scope">
                <span>{{scope.row.avgRate}}</span>
            </template>
        </el-table-column>
    </el-table>

  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from 'vue-property-decorator'
import { Route } from 'vue-router'
import { Dictionary } from 'vuex'
import { login } from '@/api/users'
import { Form as ElForm, Input } from 'element-ui'
import { UserModule } from '@/store/modules/user'
import { getDealCollect, getAllDealFromAppType, getAllDealFromChannel } from '@/api/pay.ts'

@Component({
  name: 'bill'
})
export default class extends Vue {

    private list = []
    private typeList = []
    private channelList = []
    private form = {
        endTime:'',
        merchantId: 0,
        startTime:''
    }
    private value1:any[] = []
    created () {
        this.getList()
        this.getClassList()
    }

    private async getList () {
        this.list = []
        this.form.merchantId = Number(UserModule.tenantId)
        let res = await getDealCollect(this.form)
        this.list.push(res)

        this.value1 = []
        
    }

    private  async getClassList () {
        this.typeList = await getAllDealFromAppType()
        this.channelList = await getAllDealFromChannel()
    }

    private changes () {
        this.form.endTime = this.value1[1]
        this.form.startTime = this.value1[0]
        this.getList()


    }
}
</script>

<style lang="scss">
  .bill-container {
    width: 1200px;
    margin: 00 auto;
    padding: 42px 44px;
    background: white;
    height: 100%;
  }
</style>

<style lang="scss" scoped>

</style>
