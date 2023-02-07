<template>
  <div class="work-container">
    <div class="bg">

        <div class="personalInfo">
            <img src="../../../public/img/head.png" alt="">
             <div>
                 <p>你好，{{username}}</p>
                 <p>账号：{{mobile}}</p>
                 <p><span>服务到期时间:2025.12.30</span><button>续费</button><button>升级</button></p>
             </div>
        </div>
    </div>
    <div class="content">
        <div class="deal">
            <div><p class="tables"><span class="active">本日交易数据</span><span>昨日交易数据</span></p><p class="more"><span><img src="../../../public/img/more.png" alt="">更多</span><span><img src="../../../public/img/circle.png" alt="">更新</span></p></div>
            <ul>
                <li>    &nbsp; </li>
                <li>成功交易金额</li>
                <li>成功交易金额</li>
                <li>转换率</li>
                <li>退款笔数</li>
                <li>手续费</li>
            </ul>
            <ul class="seoncd">
                <li>收款数据</li>
                <li>7.288.00</li>
                <li>2134</li>
                <li>13%</li>
                <li>2</li>
                <li>123.00</li>
            </ul>
            <ul class="third">
                <li>打款业务数据</li>
                <li>0.00</li>
                <li>0.00</li>
                <li>0.00</li>
                <li>一</li>
                <li>一</li>
            </ul>
        </div>
        <div class="list">
            <div class="detail lefts">
                <p>基础模块</p>
                <div class="modules">
                    <div class="system" @click="goPay">
                        <img src="../../../public/img/list_1.png" alt="">
                        <p>支付应用系统</p>
                    </div>
                    <div class="appliaction">
                        <img src="../../../public/img/list_2.png" alt="">
                        <p>渠道待申请</p>
                    </div>
                    <div class="morethan">
                        <img src="../../../public/img/list_3.png" alt="">
                        <p>更多</p>
                    </div>
                </div>
            </div>
            <div class="detail">
                <p>高级模块</p>
                <div class="modules">
                    <div class="system">
                        <img src="../../../public/img/list_1.png" alt="">
                        <p>CEO看板</p>
                    </div>
                    <div class="appliaction">
                        <img src="../../../public/img/list_2.png" alt="">
                        <p>用户系统</p>
                    </div>
                    <div class="morethan">
                        <img src="../../../public/img/list_3.png" alt="">
                        <p>更多</p>
                    </div>
                </div>
            </div>
            <div class="detail lefts">
                <p>支付场景</p>
                <div class="modules">
                    <div class="system">
                        <img src="../../../public/img/list_1.png" alt="">
                        <p>跨境收款</p>
                    </div>
                    <div class="appliaction">
                        <img src="../../../public/img/list_2.png" alt="">
                        <p>企业打款</p>
                    </div>
                    <div class="morethan">
                        <img src="../../../public/img/list_3.png" alt="">
                        <p>更多</p>
                    </div>
                </div>
            </div>
            <div class="detail">
                <p>账户相关</p>
                <div class="modules">
                    <div class="system">
                        <img src="../../../public/img/list_1.png" alt="">
                        <p>财务中心</p>
                    </div>
                    <div class="appliaction">
                        <img src="../../../public/img/list_2.png" alt="">
                        <p>账户中心</p>
                    </div> 
                    <div class="morethan">
                        <img src="../../../public/img/list_3.png" alt="">
                        <p>更多</p>
                    </div>
                </div>
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
import { UserModule } from '@/store/modules/user'
import { getList } from '@/api/finance.ts'
@Component({
  name: 'Login'
})
export default class extends Vue {
    private username :string = ''
    private mobile : string = ''
    private list = {}
 
    created () {
        this.getLists()
        this.username = localStorage.getItem('username')!
        this.mobile = localStorage.getItem('mobile')!
    } 
    goPay () {
        if (this.list.auditStatus === '0') {
            this.$router.push('/finance/approve')
        } else {
            this.$router.push('/finance/index')
        }
        
    }
    private async getLists () {
        this.list = await getList()
        console.log(this.list)
    }
}
</script>

<style lang="scss">
html {
    width: 100%;
    height: 100%;
    background:rgba(245,247,250,1);
}
    .work-container {
        width: 100%;
        height: 100%;
        background:rgba(245,247,250,1);
        .bg {
            width: 100%;
            height: 289px;
            background: #212121 url('../../../public/img/bg.png') no-repeat center center;
            overflow: hidden;
            position: relative;
            .head {
                margin-left: 108px;
                margin-top: 98px;
                position: relative;
                overflow: hidden;

                p{
                    position: absolute;
                    width: 100px;
                    height: 100px;
                    left: 0px;
                    top:-15px;
                    color:white;
                    line-height: 100px;
                    text-align: center;
                    background: rgba(0,0,0,0.2);
                    border-radius: 50px;
                    
                }
            }
            .personalInfo {
                position: absolute;
                width: 600px;
                height: 145px;
                left: 457px;;
                top: 98px;
                img {
                    float: left;
                }

                div {
                    float: left;
                    color: white;
                    margin-left: 31px;
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
        .content {
            width: 1200px;
            height: 11px;
            margin: 0 auto;
            margin-top: 20px;
            background:rgba(245,247,250,1);
            .deal {
                width: 100%;
                height: 299px;
                background: white;
                padding: 36px 46px;
                &>div {
                    p {
                        display: inline-block;
                    }

                    .tables {
                        width:234px;
                        height:36px;
                        border-radius:4px;
                        border:1px solid rgba(228,231,237,1);
                        span {
                            display: inline-block;
                            width: 50%;
                            height: 100%;
                            background:rgba(240,242,245,1);
                            text-align: center;
                            line-height: 36px;
                            font-size: 14px;
                        }

                          .active {
                            color:rgba(25,137,250,1);
                            background:rgba(255,255,255,1);
                        }
                    }

                  
                    .more {
                        float: right;
                        font-family:PingFangSC-Regular,PingFangSC;
                        font-weight:400;
                        color:rgba(25,137,250,1);
                        font-size: 14px;
                        span {
                            margin-left: 60px;
                            position: relative;
                            img {
                                position: absolute;
                                top: 0;
                                left: -23px;
                            }
                        }
                    }
                }
                ul {
                    width: 100%;;
                    height: 30px;
                    margin-top: 25px;
                    margin-left: -40px;
                }
                ul li {
                    width: 170px;
                    font-size: 14px;
                    float: left;
                    list-style: none;
                }

                .seoncd {
                    li:not(:nth-of-type(1)) {
                        font-family:Poppins;
                        color:rgba(255,96,96,1);
                        font-size: 16px;
                    }
                }

                .third {
                    li:not(:nth-of-type(1)) {
                        font-family:Poppins;
                        color:rgba(255,96,96,1);
                        font-size: 16px;
                    }
                }
            }
            .list {
                width: 100%;
                height: 600px;
                .detail {
                    width: 589px;
                    float: left;
                    margin-top: 15px;
                    &>p {
                        font-size: 18px;
                    }
                    .modules {
                        width: 100%;
                        height: 194px;
                        background:white;

                        div {
                            width: 196px;
                            height: 194px;
                            float: left;
                            padding: 40px 50px;
                            img {
                                margin-left: 12px;
                            }

                            p {
                                margin-top: 20px;
                                width: 100px;
                                font-size: 14px;
                                text-align: center;
                            }
                        }

                        .appliaction {
                            border-right: 0.5px solid rgba(228,231,237,1);
                            border-left: 0.5px solid rgba(228,231,237,1);
                        }
                    }
                }

                .lefts {
                    margin-right: 22px;
                }
            }
        }
    }
</style>
