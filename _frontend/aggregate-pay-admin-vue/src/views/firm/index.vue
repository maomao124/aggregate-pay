<template>
  <div class="data-container">
      <h3>企业管理</h3>
      <el-row type="flex" justify="end" class="add">
      <el-button type="primary" size="medium" @click="openSkuDialog" id="addBtn">新增</el-button>
    </el-row>

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
        <el-button @click="searchClick(scope.row)" type="text" size="small">查看</el-button>
        <el-button @click="deleteClick(scope.row)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
    </el-table>

      <storeDetail :dialogVisible.sync="dialogVisible" @refreshList="getList" :tenantId="this.tenantId"></storeDetail>

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
import { getMsgFromMer,storeList,delMerchants} from '@/api/firm.ts'
import storeDetail from '@/views/firm/storeDetail.vue'

@Component({
  components:{
    storeDetail
  }
})
export default class extends Vue {
  
  private list:any[] = []
  private pageNo:number = 1;
  private pageSize:number = 10;
  private dialogVisible:boolean = false;
  private tenantId:number = 0;
  private form = {
    auditStatus:false,
    merchantName:'',
    merchantType:'',
    mobile:''
  }
  created () {
    this.getList()
  }


  private async getList () {
    let data = await storeList(this.form,this.pageNo,this.pageSize)

    this.list = data.items

    console.log(this.list)
  }


  private async searchClick (value:any) {
    this.dialogVisible = true;
    this.tenantId = value.id;
  }
  private async deleteClick (value:any) {
    
    console.log(value)
    let res = await delMerchants(value.id)
      if (!res) {
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

      this.getList()
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
