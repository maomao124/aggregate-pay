<!DOCTYPE HTML>
<#import "/spring.ftl" as spring/>
<html>
<head>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>授权</title>

    <!-- 引入自适应类库，不建议在main.js里引入 -->
    <script>
        !function (e)
        {
            var t = e.document
                , n = t.documentElement
                , i = "orientationchange" in e ? "orientationchange" : "resize"
                , a = function e()
            {
                var t = n.getBoundingClientRect().width;
                return n.style.fontSize = 5 * Math.max(Math.min(t / 750 * 20, 11.2), 8.55) + "px",
                    e
            }();
            n.setAttribute("data-dpr", e.navigator.appVersion.match(/iphone/gi) ? e.devicePixelRatio : 1),
            /iP(hone|od|ad)/.test(e.navigator.userAgent) && (t.documentElement.classList.add("ios"),
            parseInt(e.navigator.appVersion.match(/OS (\d+)_(\d+)_?(\d+)?/)[1], 10) >= 8 && t.documentElement.classList.add("hairline")),
            t.addEventListener && (e.addEventListener(i, a, !1),
                t.addEventListener("DOMContentLoaded", a, !1))
        }(window);
    </script>
    <style scoped>
        #app {
            font-family: Helvetica, Arial, sans-serif, 'Avenir';
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
            text-align: center;
            color: #2c3e50;
            margin-top: 20px;
        }

        .authImg img {
            width: 1.725rem;
            height: 1.725rem;
            border-radius: 0.2rem;
        }

        .top p {
            height: 0.5rem;
            font-size: 0.35rem;
            color: #595959;
            letter-spacing: 1px;
            margin-top: 0;
        }

        .form-submit {
            margin-top: 20px;
        }

        .prompt {
            background: #EBEBEB;
            padding: 10px;
            text-align: left;
        }

        .prompt h4 {
            line-height: 0.5rem;
            height: 0.5rem;
            font-size: 0.35rem;
            color: #595959;
            letter-spacing: 2px;
            margin-top: 0;
            font-weight: 400;
            margin-bottom: 10px;
        }

        .prompt ul {
            margin-top: 0;
            margin-bottom: 0;
            padding-left: 20px;
        }

        .prompt li {
            font-size: 0.325rem;
            color: #A6A6A6;
            line-height: 0.5rem;
        }

        #submit {
            width: 6.2rem;
            background: #39C467;
            height: 1rem;
            border: 0;
            color: white;
            font-size: 0.35rem;
            letter-spacing: 0.05rem;
            outline: none;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div id="app">
    <form id='confirmationForm' name='confirmationForm' action='${rc.contextPath}/oauth/authorize'
          method='post'>
        <div class="top text-center">
            <p>授权</p>
        </div>
        <div class="prompt">
            <h4>你将授权第三方以下权限：</h4>
            <ul>
                <li>权限1</li>
                <li>权限2</li>
                <li>权限3</li>
            </ul>
        </div>
        <div class="form-submit text-center">
            <input name='scope.read' value='true' type='hidden'/>
            <input name='user_oauth_approval' value='true' type='hidden'/>
            <input name='authorize' value='授权' id="submit" type='submit'/>
        </div>
    </form>
</div>
</body>
</html>
