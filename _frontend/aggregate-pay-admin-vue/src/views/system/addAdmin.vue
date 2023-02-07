<template>
  <el-dialog title="新增成员" :visible.sync="syncDialogVisible">
    <el-form :inline="false">
      <el-form-item label="手机号：" :label-width="formLabelWidth" :rules="[{required:true}]">
        <el-input v-model="form.mobile"></el-input>
      </el-form-item >

      <el-form-item label="密码：" :label-width="formLabelWidth">
        <el-input v-model="form.password"></el-input>
      </el-form-item>

      <el-form-item label="用户名：" :label-width="formLabelWidth">
        <el-input v-model="form.username"></el-input>
      </el-form-item>

      <el-form-item label="用户名：" :label-width="formLabelWidth">
        <el-input v-model="form.username"></el-input>
      </el-form-item>


    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="syncDialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="ensureDialog">确 定</el-button>
    </div>
    
  </el-dialog>
</template>

<script lang="ts">
import { Component, Vue, PropSync, Emit, Prop } from 'vue-property-decorator'
import { Message } from 'element-ui'
import { constants } from 'fs';
import { createAdmin } from '@/api/system.ts'
@Component({
  components:{ 
  }
})
export default class  extends Vue {
  @PropSync('dialogVisible', { type: Boolean, default: false })
  syncDialogVisible!: boolean
  private form = {
      mobile:'',
      password:'',
      storeId:0

  }
  private async ensureDialog () {
      let res = await createAdmin(this.form)
  }
}
</script>
