<template>
  <div class="data-container">
      <h3>审核管理</h3>
    <el-form :inline="true" size="medium" class="forms">
      <el-form-item label="账户/用户名:">
        <el-input v-model="skuName" placeholder="请输入"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchSku" id="searchBtn">查询</el-button>
      </el-form-item>
    </el-form>


    <el-table
      v-loading="listLoading"
      :data="list"
      fit
      highlight-current-row
      :header-cell-style="{color:'#5373e0',background:'#f3f6fb'}"
      style="width: 100%"
    >
      <el-table-column align="center" label="企业编号">
        <template slot-scope="scope">
          <span>{{scope.row.merchantNo}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="企业名称">
        <template slot-scope="scope">
          <span>{{scope.row.merchantName}}</span>
        </template>
      </el-table-column>

 
      <el-table-column align="center" label="企业营业执照号">
        <template slot-scope="scope">
          <span>{{scope.row.merchantNo}}</span>
        </template>
      </el-table-column>

       <el-table-column
      fixed="right"
      label="操作"
      width="120"
      align="center">
      <template slot-scope="scope">
        <el-button @click="searchDetail(scope.row)" type="text" size="small">查看</el-button>
      </template>
    </el-table-column>


      <el-table-column
      fixed="right"
      label="操作"
      width="120"
      align="center">
      <template slot-scope="scope">
        <el-button @click="itPass(scope.row)" type="text" size="small">通过</el-button>
        <el-button @click="itReject(scope.row)" type="text" size="small">驳回</el-button>
      </template>
    </el-table-column>
    </el-table>

    <detail :dialogVisible.sync="dialogVisible" @refreshList="getList" :tenantId="this.tenantId"></detail>

    <!-- <pagination
      v-show="total>0"
      :total="total"
      :page.sync="listQuery.pageIndex"
      :limit.sync="listQuery.pageSize"
      @pagination="getList"
    /> -->
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from 'vue-property-decorator'
import { Route } from 'vue-router'
import { Dictionary } from 'vuex'
import { login } from '@/api/users'
import { Message } from 'element-ui'
import { Form as ElForm, Input } from 'element-ui'
import { UserModule } from '@/store/modules/user'
import { getStoresData, delStore} from '@/api/organization.ts'
import detail from '@/views/firm/detail.vue'
import { OneApprove,storeList} from '@/api/firm.ts'
@Component({
  name: 'audit',
  components:{
    detail
  }
})
export default class extends Vue {
  
  private list:any[] = []
  private pageNo:number = 1;
  private pageSize:number = 10;
  private dialogVisible:boolean = false;
  private tenantId:number = 0
  created () {
    this.getList()
  }
   private form = {
    auditStatus:false,
    merchantName:'',
    merchantType:'',
    mobile:''
  }

  private async getList () {
    let data = await storeList(this.form,this.pageNo,this.pageSize)

    this.list = data.items
  }

  private searchDetail (value:any) {

    
    this.tenantId = value.id
    this.dialogVisible = true;
    
  }

  private async itPass (value:any) {
    let res = await OneApprove(2,value.id)

      if (!res) {
       Message({
        message: "通过失败",
        type: 'error',
        duration: 2 * 1000
      })
    } else {
       Message({
        message: "通过成功",
        type: 'info',
        duration: 2 * 1000
      })

       this.dialogVisible = false;
    }

   
  }

  private async itReject (value:any) {
    
    let res = await OneApprove(2,value.id)

      if (!res) {
       Message({
        message: "驳回失败",
        type: 'error',
        duration: 2 * 1000
      })
    } else {
       Message({
        message: "驳回成功",
        type: 'info',
        duration: 2 * 1000
      })

      this.dialogVisible = false;
    }

    
  }
  private async deleteClick (value:any) {
    let data = await delStore(value.id)

      if (!data) {
       Message({
        message: "删除失败",
        type: 'error',
        duration: 2 * 1000
      })
    } else {
       Message({
        message: "删除成功",
        type: 'info',
        duration: 2 * 1000
      })
    }
  }
}
</script>

<style lang="scss">
  .data-container {
    width: 1200px;
    margin: 00 auto;
    padding: 42px 44px;
    background: white;
    height: 100%;
  }
</style>

<style lang="scss" scoped>

</style>
