<template>
  <div class="data-container">
      <h3>成员管理</h3>
      <el-row type="flex" justify="end" class="add">
      <el-button type="primary" size="medium" @click="openSkuDialog" id="addBtn">新增</el-button>
    </el-row>

    <el-form :inline="true" size="medium" class="forms">
      <el-form-item label="账户/用户名:">
        <el-input placeholder="请输入" v-model="memberForm.username"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" id="searchBtn">查询</el-button>
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
      <el-table-column align="center" label="成员序号">
        <template slot-scope="scope">
          <span>{{scope.$index + 1}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="账号">
        <template slot-scope="scope">
          <span>{{scope.row.mobile}}</span>
        </template>
      </el-table-column>

 
      <el-table-column align="center" label="用户名">
        <template slot-scope="scope">
          <div v-if="scope.row.username">
            <span>{{scope.row.username}}</span>
          </div> 
        </template>
      </el-table-column>

      <el-table-column align="center" label="所属门店">
        <template slot-scope="scope">
          <span>{{scope.row.storeId}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="角色">
        <template slot-scope="scope">
          <span>{{scope.row.position}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="最后一次访问时间">
        <template slot-scope="scope">
          <span>{{scope.row.lastLoginTime}}</span>
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

     <addMember :dialogVisible.sync="dialogVisible" @refreshList="getList"></addMember>
     <updateMember :dialogVisible.sync="dialogVisible1" @refreshList="getList" :memberIds="memberId"></updateMember>

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
import { getMemberData, delMember} from '@/api/organization.ts'
import addMember from '@/views/organization/addMember.vue'
import Pagination from "@/components/Pagination/index.vue";
import updateMember from '@/views/organization/updateMember.vue'
@Component({
  components: {
    addMember, 
    Pagination,
    updateMember
  }
})
export default class extends Vue {
  
  private list:any[] = []
  private pageNo:number = 1;
  private pageSize:number = 10;
  private dialogVisible:boolean = false;
  private dialogVisible1:boolean = false;
  private total:number = 0
  private memberId:string = ''
  private memberForm = {
    username:''
  }
  created () {
    this.getList()
  }


  private async getList () {
    let data = await getMemberData(this.pageNo,this.pageSize,this.memberForm)
    this.list = data.items

    this.total = this.list.length;

    console.log(this.list)
  }

  private updateClick (value:any) {
    console.log(value)
    this.memberId  = value.id
    this.dialogVisible1 = true;
  }
  private openSkuDialog () {
    this.dialogVisible = true;
  }
  private async deleteClick (value:any) {
    let data = await delMember(value.id)

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
</style>

<style lang="scss" scoped>

</style>
