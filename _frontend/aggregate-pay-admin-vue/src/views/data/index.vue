<template>
  <div class="data-container">
      <h3>数据看板</h3>
      
    <el-table
      v-loading="listLoading"
      fit
      highlight-current-row
      :header-cell-style="{color:'#5373e0',background:'#f3f6fb'}"
      style="width: 100%"
    >
      <el-table-column align="center" label="总交易额">
        <template slot-scope="scope">
          <span>1</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="退款金额">
        <template slot-scope="scope">
          <span>2</span>
        </template>
      </el-table-column>

 
      <el-table-column align="center" label="成功交易金额">
        <template slot-scope="scope">
          <span>3</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="手续费">
        <template slot-scope="scope">
          <span>4</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="净收入">
        <template slot-scope="scope">
          <span>5</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="发起笔数">
        <template slot-scope="scope">
          <span>6</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="退款笔数">
        <template slot-scope="scope">
          <span>234</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="成功笔数">
        <template slot-scope="scope">
          <span>234</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="转化率">
        <template slot-scope="scope">
          <span>234</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="平均订单金额">
        <template slot-scope="scope">
          <span>234</span>
        </template>
      </el-table-column>

      <el-table-column align="center" label="平均费率">
        <template slot-scope="scope">
          <span>234</span>
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

@Component({
  name: 'data'
})
export default class extends Vue {

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
