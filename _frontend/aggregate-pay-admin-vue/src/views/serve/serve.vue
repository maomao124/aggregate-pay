<template>
  <div class="data-container">
      <h3>支付渠道管理</h3>
 
    <el-table
      v-loading="listLoading"
      :data="list"
      fit
      highlight-current-row
      :header-cell-style="{color:'#5373e0',background:'#f3f6fb'}"
      style="width: 100%"
    >
      <el-table-column align="center" label="支付ID">
        <template slot-scope="scope">
          <span>{{scope.row.id}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="支付名称">
        <template slot-scope="scope">
          <span>{{scope.row.channelName}}</span>
        </template>
      </el-table-column>

 
      <el-table-column align="center" label="支付编码">
        <template slot-scope="scope">
          <span>{{scope.row.channelCode}}</span>
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
import { Message } from 'element-ui'
import { Form as ElForm, Input } from 'element-ui'
import { UserModule } from '@/store/modules/user'
import { channelList} from '@/api/serve.ts'

@Component({
  name: 'audit'
})
export default class extends Vue {
  
  private list:any[] = []
  private pageNo:number = 1;
  private pageSize:number = 10;

  created () {
    this.getList()
  }


  private async getList () {
    this.list = await channelList()
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
