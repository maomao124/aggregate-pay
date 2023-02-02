<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>向商家付款</title>
</head>
<body>

<div class="content">
    <!--	<img src="./logo.png" alt="">-->
    <p class="name">${RequestParameters['subject']!}</p>
</div>
<div class="form-container">
    <form id="form" action="" method="get">

        <input type="hidden" id="appId" name="appId" value="${RequestParameters['appId']!}"/>
        <input type="hidden" id="openId" name="openId" value="${RequestParameters['openId']!}"/>
        <input type="hidden" id="channel" name="channel" value="${RequestParameters['channel']!}"/>
        <#if RequestParameters['outTradeNo']?? >
            <p><span>订单号 :</span><input type="text" name="outTradeNo" value="${RequestParameters['outTradeNo']!}"
                                        readonly="readonly" maxlength="5" size="25"/></p>
        </#if>
        <p><span>商品名称 :</span><input type="text" name="subject" value="${RequestParameters['subject']!}"
                                     readonly="readonly"
                                     maxlength="5" size="25"/></p>
        <p><span>订单描述 :</span><input type="text" name="body" value="${RequestParameters['body']!}" readonly="readonly"
                                     maxlength="5" size="25"/></p>
        <#if RequestParameters['totalAmount']?? >
            <p><span>付款金额(元) :</span><input type="text" name="totalAmount"
                                            value="${(RequestParameters['totalAmount']!0 ? number/100) ? string('0.00')}"
                                            readonly="readonly" maxlength="5" size="25"/></p>
        <#else>
            <p id="text" style="width: auto"><span>付款金额(元) :</span><input id="inp" type="text" name="totalAmount"
                                                                          maxlength="5"
                                                                          size="20"/></p>
        </#if>
        <input type="hidden" name="storeId" value="${RequestParameters['storeId']!}" readonly="readonly" maxlength="5"
               size="25"/>
        <input type="hidden" name="tradeNo" value="${RequestParameters['tradeNo']!}" readonly="readonly" maxlength="5"
               size="25"/>

        <input type="button" value="立即支付" onclick="IsWeixinOrAlipay()" class="pay">

    </form>
</div>
</body>

<script type="text/javascript" src="./keybord.js"></script>
<script type="text/javascript">

    // 需要判断UA，传入appId到不同的controller
    function IsWeixinOrAlipay()
    {
        var totalAmount = document.getElementsByName("totalAmount")[0];
        if (!totalAmount.value)
        {
            alert("付款金额不能为空");
            return;
        }
        var action;
        <#if RequestParameters['openId'] ?? >
        action = "${rc.contextPath}/pay/wxjspay"
        {
            ;
        }
        <#else>
        action = "${rc.contextPath}/pay/createAliPayOrder";
        </#if>

        document.getElementById("form").action = action;
        document.getElementById("form").submit();
        return "false";
    }
</script>
<script type="text/javascript">
    (function ()
    {
        var text = document.getElementById('text');
        var input = document.getElementById('inp');
        text.onclick = function ()
        {
            new KeyBoard(input);
        };
    })();
</script>
<style>
    .form-container {
        padding: 0 10px;;
    }

    input {
        margin-top: 10px;
        border: 0;
    }

    img {
        width: 100px;
        height: 50px;;
        margin-left: 25%;
    }

    .content .name {
        margin-top: 30px;
    }

    .pay {
        width: 100%;
        height: 50px;;
        font-size: 20px;;
        text-align: center;
        background: rgb(26, 132, 231);;
        border-radius: 5px;
        border: 1px solid #ccc;
        color: white;
        margin: 0 auto;
    }

    .content {
        width: 100%;
        height: 150px;
        background: skyblue;
        text-align: center;
        overflow: hidden;
    }

    .content p {
        margin: 0;
        padding: 0;
    }

    .price input {
        text-align: center;
        background: rgb(26, 132, 231);
        color: white;
        outline: none;;
        font-size: 20px;;
    }

    #form p {
        width: 100%;
        height: 40px;;
        border-bottom: 1px solid #ccc;
        font-size: 14px;;
        display: flex;
        justify-content: space-between;
    }

    #form p span {
        float: left;
        display: block;;
        font-size: 13px;
        line-height: 40px;
        flex-shrink: 0;
    }

    #form p input {
        flex-shrink: 0;
        height: 20px;
        float: right;;
        line-height: 30px;
        text-align: right;
        outline: none;
    }

    #text {
        border: 2px solid rgb(196, 184, 184);
        padding: 0 10px;
        border-radius: 5px;
        height: 50px;;
        line-height: 50px;
        font-size: 20px;
    }

    #inp {
        border: 0;
        outline: none;;
        width: 62%;
        font-size: 20px;;
    }
</style>
</html>
