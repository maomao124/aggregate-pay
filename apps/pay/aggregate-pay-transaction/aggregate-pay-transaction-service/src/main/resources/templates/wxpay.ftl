<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>同步通知</title>
    <script>

        function onBridgeReady()
        {
            WeixinJSBridge.invoke(
                'getBrandWCPayRequest', {
                    "appId": "${appId}",     //公众号名称，由商户传入
                    "timeStamp": "${timeStamp}",         //时间戳，自1970年以来的秒数
                    "nonceStr": "${nonceStr}", //随机串
                    "package": "${package}",
                    "signType": "${signType}",         //微信签名方式：
                    "paySign": "${paySign}" //微信签名,paySign 采用统一的微信支付 Sign 签名生成方法，注意这里 appId 也要参与签名，appId 与 config 中传入的 appId 一致，即最后参与签名的参数有appId, timeStamp, nonceStr, package, signType。
                },
                function (res)
                {
                    if (res.err_msg == "get_brand_wcpay_request:ok")
                    {     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                        alert('支付成功！');
                    }
                    else
                    {
                        alert('支付失败：' + res.err_msg);
                    }
                    WeixinJSBridge.call('closeWindow');
                }
            );
        }

        if (typeof WeixinJSBridge == "undefined")
        {
            if (document.addEventListener)
            {
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            }
            else if (document.attachEvent)
            {
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        }
        else
        {
            onBridgeReady();
        }
    </script>

</head>
<body>
<div id="app">

</div>
</body>
</html>
