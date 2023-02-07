<template>
  <el-dialog title="支付设置" :visible.sync="visible" @open="opend" :append-to-body="true">
    <video ref="video" id="video" autoplay="autoplay" style="background: #ccc;" width="300px" height="300px" v-show="!isshow" ></video>
    
    <canvas ref="canvas" id="canvas" style="display:none;background-color:#F00;" width="300px" height="300px"></canvas>
    <img src="" alt="" ref="imgs" v-show="isshow">
    <div slot="footer" class="dialog-footer" ref="aa">
      <el-button type="primary"  @click="getCodes" >拍照</el-button>
      <el-button type="primary" @click="ensureDialog">确定</el-button>
    </div>
  </el-dialog>
</template>

<script>
import { Message } from 'element-ui'
import { constants } from 'fs';
import { getAppList } from '@/api/pay.ts'
import { getStoresData} from '@/api/organization.ts'
import { BscanC } from '@/api/pay.ts'
import QrcodeDecoder from 'qrcode-decoder';
export default {
    name:'scan',
    props:{
        visible:{
            type: Boolean,
            default: false
        }
    },
    data () {
        return {
            video:'',
            canvas:'',
            file:'',
            isshow:false,
            codes:''
        }
    },
    created () {
       

    },
    methods: {
        getVideo () {
            var errocb = function (code) {
                alert(code);
            };
            var _this = this
            if (navigator.getUserMedia) { // 标准的API
                navigator.getUserMedia({ "video": true }, function (stream) {
                    _this.video.srcObject = stream;
                    _this.video.play();
                }, errocb);
            } else if (navigator.webkitGetUserMedia) { // WebKit 核心的API
                console.log(navigator.webkitGetUserMedia);
                navigator.webkitGetUserMedia({ "video": true }, function (stream) {
                    _this.video.srcObject = window.webkitURL.createObjectURL(stream);
                    _this.video.play();
                }, errocb);
            }
        },
        opend () {
            
            this.$nextTick(() => {
                this.video = this.$refs.video;
                this.canvas = this.$refs.canvas;
                this.img = this.$refs.imgs
                this.context = this.canvas.getContext("2d");
                console.log(this.context)
            });

            this.getVideo()
           
        },
        getCodes () {
        
            this.isshow = true;
            this.catchCode()
            
        },
        ensureDialog () {
            this.visible = false;
            this.getCode()
        },
        catchCode () {
             if(this.canvas != null){
                this.context.drawImage(this.video, 0, 0, 640, 480);
                this.img.src = this.canvas.toDataURL("image/png");
                this.file = this.dataURLtoFile(this.img.src,"aaa")
                console.log(this.file)
            }
        },
        getObjectURL (file) {
            var url = null;
            if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
            } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
            } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
            }
            return url;
        },
        getCode () {
            // console.log(this.files[0]);
            // console.log(getObjectURL(this.files[0]));// newfile[0]是通过input file上传的二维码图片文件
            // qrcode.decode(getObjectURL(this.file));
            // qrcode.callback = function (imgMsg) {
            //     alert("二维码解析：" + imgMsg)
            // }
            var url = null;
            url = this.getObjectURL(this.file[0])
            qr.decodeFromImage(url).then((res) => {
				//打印结果为 解析出来的 二维码地址
                    console.log(res.data);
                    this.codes = res.data
            });
            console.log()
        },
        dataURLtoFile (dataurl, filename) { 
	    var arr = dataurl.split(','),
	        mime = arr[0].match(/:(.*?);/)[1],
	        bstr = atob(arr[1]),
	        n = bstr.length,
	        u8arr = new Uint8Array(n);
	    while (n--) {
	        u8arr[n] = bstr.charCodeAt(n);
	    }
	    return new File([u8arr], filename, { type: mime });
	}
    }

}
</script>
