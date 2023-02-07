<template>
  <div class="approve-container">
      <h2>资质申请</h2>
      <el-form ref="form" :model="form" label-width="140px" class="froms">
        <h3>基础信息</h3>
        <el-form-item label="企业名称">
            <el-input  v-model="form.merchantName" placeholder="请输入企业名称"></el-input>
        </el-form-item>
        <el-form-item label="企业营业执行编号">
            <el-input v-model="form.merchantNo"  placeholder="请输入执行编号"></el-input>
        </el-form-item>
        <el-form-item label="企业地址">
            <el-input  v-model="form.merchantAddress" type="textarea" rows="5" placeholder="请输入企业地址"></el-input>
        </el-form-item>
        <hr>
        <h3>行业类型</h3>
        <el-form-item label="行业类型">
            <el-select placeholder="请选择行业类型" v-model="form.merchantType">
            <el-option label="教育" value="教育"></el-option>
            <el-option label="科学研究" value="科学研究"></el-option>
            <el-option label="零售" value="零售"></el-option>
            </el-select>
        </el-form-item>
        <hr>
        <h3>证件上传</h3>
        <el-form-item label="上传企业证明" class="files">
            <el-upload
                class="avatar-uploader"
                action="#"
                :show-file-list="false"
                :on-success="handleAvatarSuccess"
                :http-request="uploadImg">
                <img v-if="imageUrl" :src="imageUrl" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </el-form-item>
        <el-form-item label="上传法人身份证" class="idCard">
            <el-upload
                class="avatar-uploader1"
                action="#"
                :show-file-list="false"
                :on-success="handleAvatarSuccess1"
                :http-request="uploadImg1">
                <img v-if="imageUrl1" :src="imageUrl1" class="avatar1">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <el-upload
                class="avatar-uploader2"
                action="#"
                :show-file-list="false"
                :on-success="handleAvatarSuccess2"
                :http-request="uploadImg2">
                <img v-if="imageUrl2" :src="imageUrl2" class="avatar2">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </el-form-item>
        <hr class="clear">
        <h3>联系人信息</h3>
         <el-form-item label="联系人">
            <el-input  v-model="form.username"  placeholder="请输入联系人"></el-input>
        </el-form-item>
        <el-form-item label="联系人地址">
            <el-input type="textarea"  rows="5" placeholder="请输入联系人地址" v-model="form.contactsAddress" ></el-input>
        </el-form-item>
        <el-form-item>
            <el-button>取消</el-button>
            <el-button @click="submit"  type="primary">提交</el-button>
        </el-form-item>
        </el-form>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from 'vue-property-decorator'
import { Route } from 'vue-router'
import { Dictionary } from 'vuex'
import { login } from '@/api/users'
import { Form as ElForm, Input } from 'element-ui'
import { UserModule } from '@/store/modules/user'
import { setApprove, upload } from '@/api/finance.ts'
import { getList } from '@/api/finance.ts'
@Component({
  name: 'Login'
})
export default class extends Vue {

    private form = {
        contactsAddress:'',
        merchantAddress:'',
        merchantName:'',
        merchantNo:0,   
        merchantType:'',
        password:'',
        tenantId:null,
        idCardAfterImg:'',
        idCardFrontImg:'',
        businessLicensesImg:'',
        auditStatus:'',
        username:'',
        id:0
    }
    private imageUrl:string = ''
    private imageUrl1:string = ''
    private imageUrl2:string = ''
    private id = 0

    created () {
        this.getLists()
    }

    private async approve () {

    }
    private async getLists () {
        let res = await getList()
        if (res) {
            this.form.contactsAddress = res.contactsAddress
            this.form.merchantAddress = res.merchantAddress
            this.form.merchantName = res.merchantName
            this.form.merchantNo = res.merchantNo
            this.form.merchantType = res.merchantType
            this.imageUrl1= res.idCardFrontImg
            this.imageUrl = res.businessLicensesImg
            this.imageUrl2 = res.idCardAfterImg
            this.form.username = res.username
        }
        console.log(res)
    }
    private handleAvatarSuccess(res:any, file:any) {
        this.imageUrl = URL.createObjectURL(file.raw);
    }

    private handleAvatarSuccess1(res:any, file:any) {
        this.imageUrl1 = URL.createObjectURL(file.raw);
    }

    private handleAvatarSuccess2(res:any, file:any) {
        this.imageUrl2 = URL.createObjectURL(file.raw);
    }

    private async uploadImg (params:any) {
         var formData = new FormData();
        formData.append("file", params.file);
        let res:any = await upload(formData);
        this.form.businessLicensesImg = res
    }

    private async uploadImg1 (params:any) {
         var formData = new FormData();
        formData.append("file", params.file);
        let res:any = await upload(formData);
        this.form.idCardFrontImg = res
    }

    private async uploadImg2 (params:any) {
         var formData = new FormData();
        formData.append("file", params.file);
        let res:any = await upload(formData);
        this.form.idCardAfterImg = res
    }

    private  async submit () {
        let res = await setApprove(this.form)
        
        this.$router.push('/finance/index')
    } 
}
</script>

<style lang="scss">
    .approve-container {
        width: 1200px;
        margin: 0 auto;
        background: white;
        padding: 42px 44px;

        .clear {
            clear: both;
        }
        .froms {
            padding: 40px 40px;
            input {
                width: 250px;
            }

            .el-textarea {
                width: 400px;
            }
        }

          .avatar-uploader .el-upload {
                border: 1px dashed #d9d9d9;
                border-radius: 6px;
                cursor: pointer;
                position: relative;
                overflow: hidden;
            }
            .avatar-uploader .el-upload:hover {
                border-color: #409EFF;
            }

            .avatar-uploader {
                width: 350px;
                 .avatar-uploader-icon {
                    font-size: 28px;
                    color: #8c939d;
                    width: 178px;
                    height: 370px;
                    line-height: 370px;
                    text-align: center;
                }
            }
           
            .avatar {
                width: 178px;
                height: 370px;
                display: block;
            }
             .avatar-uploader1 .el-upload {
                border: 1px dashed #d9d9d9;
                border-radius: 6px;
                cursor: pointer;
                position: relative;
                overflow: hidden;
            }
            .avatar-uploader1 .el-upload:hover {
                border-color: #409EFF;
            }
            .avatar-uploader-icon {
                font-size: 28px;
                color: #8c939d;
                width: 178px;
                height: 178px;
                line-height: 178px;
                text-align: center;
            }
            .avatar1 {
                width: 178px;
                height: 178px;
                display: block;
            }
             .avatar-uploader2 .el-upload {
                border: 1px dashed #d9d9d9;
                border-radius: 6px;
                cursor: pointer;
                position: relative;
                overflow: hidden;
            }
            .avatar-uploader2 .el-upload:hover {
                border-color: #409EFF;
            }
            .avatar-uploader-icon {
                font-size: 28px;
                color: #8c939d;
                width: 178px;
                height: 178px;
                line-height: 178px;
                text-align: center;
            }
            .avatar2 {
                width: 178px;
                height: 178px;
                display: block;
            }
        .files {
            float: left;
        }
        .idCard {
            float: left;
            margin-left: 10px;
            .upload-demo .el-upload-dragger {
                width: 326px;
                height: 222px;
            }
        }

        hr {
            display: block;
            margin: 50px 0 50px 0;
            color: rgb(248, 242, 242);
        }
    }
</style>

<style lang="scss" scoped>

</style>
