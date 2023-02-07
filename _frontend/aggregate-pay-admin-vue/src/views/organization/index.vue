<template>
  <div class="data-container">
      <h3>门店管理</h3>
      <el-row type="flex" justify="end" class="add">
      <el-button type="primary" size="medium" @click="checkUse" id="addBtn">选择应用</el-button>
      <el-button type="primary" size="medium" @click="openSkuDialog" id="addBtn">新增</el-button>
    </el-row>

    <!-- <el-form :inline="true" size="medium" class="forms">
      <el-form-item label="账户/用户名:">
        <el-input v-model="skuName" placeholder="请输入"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="searchSku" id="searchBtn">查询</el-button>
      </el-form-item>
    </el-form> -->


    <el-table
      :data="list"
      fit
      highlight-current-row
      :header-cell-style="{color:'#5373e0',background:'#f3f6fb'}"
      style="width: 100%"
    >
      <el-table-column align="center" label="门店编号">
        <template slot-scope="scope">
          <span>{{scope.row.storeNumber}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="门店名称">
        <template slot-scope="scope">
          <span>{{scope.row.storeName}}</span>
        </template>
      </el-table-column>

 
      <el-table-column align="center" label="地址">
        <template slot-scope="scope">
          <span>{{scope.row.storeAddress}}</span>
        </template>
      </el-table-column>

       <el-table-column
      fixed="right"
      label="二维码"
      width="150"
      align="center">
      <template slot-scope="scope">
        <el-button @click="setCode(scope.row)" type="text" size="small">生成二维码</el-button>
      </template>
    </el-table-column>


      <el-table-column
      fixed="right"
      label="操作"
      width="120"
      align="center">
      <template slot-scope="scope">
        <el-button @click="updateClick(scope.row)" type="text" size="small">编辑</el-button>
        <el-button @click="deleteClick(scope.row)" type="text" size="small">删除</el-button>
      </template>
    </el-table-column>
    </el-table>

     <addStore :dialogVisible.sync="dialogVisible" @refreshList="getList"></addStore>
     <setCode :dialogVisible.sync="dialogVisible1" @refreshList="getList" :code="codes"></setCode>
     <updateStore :dialogVisible.sync="dialogVisible2" @refreshList="getList" :storeIds="storeId"></updateStore>
     <setUse :dialogVisible.sync="dialogVisible3" @refreshList="getList" @getAppId="getAppIds"></setUse>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="pageNo"
      :limit.sync="pageSize"
      @pagination="getList"
    />
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
import { getStoresDataCode } from '@/api/pay.ts'
import { getStoresData, delStore} from '@/api/organization.ts'
import addStore from '@/views/organization/addStore.vue'
import Pagination from "@/components/Pagination/index.vue";
import setCode from '@/views/organization/setCode.vue'
import updateStore from '@/views/organization/updateStore.vue'
import setUse from '@/views/organization/setUse.vue'
@Component({
  components:{
    addStore,
    Pagination,
    setCode,
    updateStore,
    setUse
  }
})
export default class extends Vue {
  
  private list:any[] = []
  private pageNo:number = 1;
  private pageSize:number = 10;
  private total:number = 0
  private dialogVisible:boolean = false;
  private dialogVisible1:boolean = false;
  private dialogVisible2:boolean = false;
  private dialogVisible3:boolean = false;
  private appId:string = ''
  private codes:string = ''
  private storeId:string = ''
  private storeForm = {
    storeName:'',
    storeNumber:''
  }
   private form = {
    totalAmount: '',
    body:''
    
  }
  created () {
    this.getList()
  }


  private async getList () {
    let data = await getStoresData(this.pageNo,this.pageSize,this.storeForm)

    this.list = data.items

    this.total = this.list.length
  }
  private checkUse () {
    this.dialogVisible3 = true;
  }
  private openSkuDialog () {
    this.dialogVisible = true;
  }
  private getAppIds (value:any) {
    
    this.appId = value
  }
  private updateClick (value:any) {
    console.log(value)
    this.storeId = value.id
    this.dialogVisible2 = true;
  }
  private async setCode (value:any) {
    if (this.appId === '') {
      this.$message.error('请先选择应用');return

    }
    this.codes = await getStoresDataCode(this.appId,value.id,this.form.body,this.form.totalAmount)
    this.dialogVisible1 = true;
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
  .add {
    margin-bottom:10px;
  }
</style>

