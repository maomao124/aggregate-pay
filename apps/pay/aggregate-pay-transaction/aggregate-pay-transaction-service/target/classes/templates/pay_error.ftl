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
    支付错误！<br/>
    请使用微信或支付宝重新扫码。
</div>

</body>

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
        font-size: 1.3em;
        color: red;
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
