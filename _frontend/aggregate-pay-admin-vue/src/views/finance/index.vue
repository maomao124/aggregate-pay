<template>
  <div class="finance-container">
      <div class="bg">
        <div class="personalInfo">
            <img src="../../../public/img/head.png" alt="">
             <div>
                 <p>你好，{{username}}</p>
                 <p>账号：{{mobile}}</p>
                 <p><span>服务到期时间:2025.12.30</span><button>续费</button><button>升级</button></p>
             </div>
        </div>

        <div class="content">
            <div>
                <h3>基础信息</h3>
                <p><span>企业名称：</span><span>{{list.merchantName}}</span></p>
                <p><span>企业营业执照号：</span><span>{{list.merchantNo}}</span></p>
                <p><span>企业地址：</span><span>{{list.merchantAddress}}</span></p>
            </div>
            <div>
                <h3>行业类型</h3>
                <p><span>行业类型：</span><span>{{list.merchantType}}</span></p>
            </div>

            <div>
                <h3>证件上传</h3>
                <div>
                    <div class="firm">
                        <p>企业营业执照</p>
                        <img :src="list.businessLicensesImg" alt="">
                    </div>
                    <div class="card">
                        <p>企业法人身份证</p>
                        <img :src="list.idCardAfterImg" alt="">
                        <img :src="list.idCardFrontImg" alt="">
                    </div>
                </div>
            </div>
            <div>
                <h4>联系人信息</h4>
                <p><span>联系人：</span><span>{{list.username}}</span></p>
                <p><span>联系人电话：</span><span>{{list.mobile}}</span></p>
                <p><span>联系人地址：</span><span>{{list.contactsAddress}}</span></p>
            </div>
        </div>
    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue, Watch } from 'vue-property-decorator'
import { Route } from 'vue-router'
import { Dictionary } from 'vuex'
import { login } from '@/api/users'
import { Form as ElForm, Input } from 'element-ui'
import { UserModule } from '@/store/modules/user'
import { getList } from '@/api/finance.ts'
@Component({
  name: 'Login'
})
export default class extends Vue {

    private list = {}
    private username :string = ''
    private mobile : string = ''
 
    created () {
        this.username = localStorage.getItem('username')!
        this.mobile = localStorage.getItem('mobile')!
         this.getLists()
    } 
    private async getLists () {
        this.list = await getList()
        console.log(this.list)
    }
}
</script>


<style lang="scss">
    .finance-container {
        width: 100%;
        height: 100%;
        .bg {
            width: 1200px;
            height: 100%;
            margin: 0 auto;
            background: white url('../../../public/img/bg.png') no-repeat top center;
            overflow: hidden;
            .content {
                padding: 0 100px;
                div {
                    width: 100%;
                    margin-top: 20px;
                }
                div:not(:nth-of-type(1)) {
                    border-top:1px solid rgba(228,231,237,1);
                }

                .firm {
                    img {
                        width: 200px;
                        height: 100;
                    }
                }

                .card {
                    img {
                        width: 200px;
                        height: 100;
                        margin-right: 10px;
                    }
                }
            }
            .personalInfo {
                width: 100%;
                height: 289px;
                img {
                    float: left;
                    margin-left: 150px;
                    margin-top: 98px;
                }

                div {
                    float: left;
                    color: white;
                    margin-left: 31px;
            
                    margin-top: 98px;
                    p:nth-child(1) {
                        font-size: 24px;
                        line-height: 0;
                    }
                    p:nth-child(2) {
                        font-size: 16px;
                    }
                    p:nth-child(3) {
                        font-size: 16px;
                       
                        margin-top: 39px;
                        span {
                            opacity: 0.6;
                        }
                        button:nth-child(2) {
                            width:84px;
                            height:36px;
                            background:rgba(243,41,113,1);
                            border-radius:18px;
                            margin-left: 30px;
                            border: none;
                            opacity: 1;
                            color: white;
                        }

                        button:nth-child(3) {
                            width:84px;
                            height:36px;
                            background:rgba(25,137,250,1);
                            border-radius:18px;
                            margin-left: 20px;
                            border: none;
                            opacity: 1;
                            color: white;
                        }
                    }
                }
            }
        }
    }
</style>

