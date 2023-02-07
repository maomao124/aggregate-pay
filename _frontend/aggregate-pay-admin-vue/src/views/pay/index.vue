<template>
  <div class="app-container">
      <h3>我的支付</h3>
    <el-row type="flex" justify="end" class="add">
      <el-button type="primary" size="medium" @click="openTaskDialog" id="addBtn">创建应用</el-button>
    </el-row>
    <el-table
      style="width: 100%"
      :data="list"
      :header-cell-style="{color:'#5373e0',background:'#f3f6fb'}"
    >
       <el-table-column width="center" align="center" label="应用ID">
        <template slot-scope="scope">
          <span>{{ scope.row. appId}}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="应用名称">
        <template slot-scope="scope">
          <span>{{ scope.row.appName }}</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="应用公钥">
        <template slot-scope="scope">
          <span>{{ scope.row.publicKey }}</span>
        </template>
      </el-table-column>
      <el-table-column
      fixed="right"
      label="获取支付参数"
      width="150"
      align="center">
      <template slot-scope="scope">
        <el-button @click="getDetail(scope.row)" type="text" size="small">获取</el-button>
      </template>
    </el-table-column>

     <el-table-column
      fixed="right"
      label="操作"
      width="150"
      align="center">
      <template slot-scope="scope">
        <el-button @click="handleClick(scope.row)" type="text" size="small">编辑</el-button>
        <el-button @click="setData(scope.row)" type="text" size="small">配置</el-button>
      </template>
    </el-table-column>
    </el-table>
      <getPayParams :dialogVisible.sync="dialogVisible" :appId="appIds"></getPayParams>
     <!-- <pagination
      v-show="total>0"
      :total="total"
      :page="1"
      :limit="10"
      @pagination="getList"
    /> -->
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator'
import Pagination from "@/components/Pagination/index.vue";
import { Message } from 'element-ui'
import { getAppList } from '@/api/pay.ts'
import getPayParams from '@/views/pay/getPayParams.vue'
import QrcodeDecoder from 'qrcode-decoder';
@Component({
  name: 'manage',
  components: {
      Pagination,
      getPayParams
  }
})
export default class extends Vue {
    private total:number = 0
    private list:any[] = []
    private dialogVisible: boolean = false;
    private appIds:string = ''
    created () {
        this.getList()
    }

    private async getList () {
        this.list = await getAppList()
        this.total = this.list.length
    }

    private openTaskDialog () {
      this.$router.push({
        path:`/pay/set/0/0`
      })
    }

    private handleClick (value:any) {
      this.$router.push({
        path:`/pay/set/${value.appId}/0`
      })
    }

    private  getDetail (value:any) {
      this.dialogVisible = true;
      this.appIds = value.appId;
    }

    private setData (value:any) {
      this.$router.push({
        path:`/pay/set/${value.appId}/1`
      })

    }
}
</script>

<style>
  .app-container #addBtn,#searchBtn{
    background: #5373e0;
    border-color: #5373e0;
  }

  .app-container {
       width: 1200px;
        margin: 00 auto;
        padding: 42px 44px;
        background: white;
        height: 100%;
    }
  
  .app-container #reset {
    background: #ff9540;
    border-color: #ff9540;
    color: white;
  }
  .app-container .forms {
    background: white;
    padding:20px 10px 0 10px;
  }
  .app-container .add {
    margin-bottom: 10px;
  }
</style>
