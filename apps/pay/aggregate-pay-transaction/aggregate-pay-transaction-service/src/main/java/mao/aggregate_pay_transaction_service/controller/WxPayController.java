package mao.aggregate_pay_transaction_service.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_service.properties.WxPayConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.controller
 * Class(类名): WxPayController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/28
 * Time(创建时间)： 14:17
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Controller
@Api(value = "微信支付测试", tags = "微信支付测试")
@RequestMapping("/wxpay")
public class WxPayController
{
    @Resource
    private WxPayConfigurationProperties wxPayConfigurationProperties;

    /**
     * 申请授权码
     *
     * @param httpResponse http响应
     * @return {@link String}
     * @throws UnsupportedEncodingException 不支持编码异常
     */
    @ApiOperation("申请授权码")
    @RequestMapping(value = "/getWXOAuth2Code", method = RequestMethod.GET)
    public String getWXOAuth2Code(HttpServletResponse httpResponse)
            throws UnsupportedEncodingException
    {
        String state = "";
        // https://open.weixin.qq.com/connect/oauth2/authorize?appid = APPID & redirect_uri = REDIRECT_URI & response_type = code & scope = SCOPE & state = STATE#wechat_redirect
        String url = String.format("%s?appid=%s&scope=snsapi_base&state=%s&redirect_uri=%s",
                wxPayConfigurationProperties.getWxOAuth2RequestUrl(),
                wxPayConfigurationProperties.getAppID(),
                state,
                URLEncoder.encode(wxPayConfigurationProperties.getWxOAuth2CodeReturnUrl(), "UTF-8"));
        return "redirect:" + url;
    }


    /**
     * 获取openid，注意：此接口必须要在公网能够访问到，至少要微信支付能够调用，内网穿透、公网IP+端口映射都行，我家用的是公网IP
     *
     * @param code  代码
     * @param state 状态
     * @return {@link String}
     */
    @ApiOperation("获取openid")
    @RequestMapping(value = "/wx‐oauth‐code‐return‐test", method = RequestMethod.GET)
    public String wxOAuth2CodeReturn(@RequestParam String code, @RequestParam String state, HttpServletRequest httpServletRequest)
    {
        //https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code
        //申请openid
        String tokenUrl = String.format("https://api.weixin.qq.com/sns/oauth2/access_token? appid=%s&secret=%s&code=%s&grant_type=authorization_code",
                wxPayConfigurationProperties.getAppID(),
                wxPayConfigurationProperties.getAppSecret(), code, "utf‐8");
        ResponseEntity<String> exchange = new RestTemplate().exchange(tokenUrl, HttpMethod.GET, null, String.class);
        String response = exchange.getBody();
        String openid = JSONObject.parseObject(response).getString("openid");
        //携带openid跳转至统一下单地址
        //todo：更改IP地址
        return "redirect:http://175.7.164.59:49827/wxpay/wxjspay?openid=" + openid;
    }


    /**
     * 微信jsapi下单接口
     *
     * @param request  请求
     * @param response 响应
     * @return {@link ModelAndView}
     * @throws Exception 异常
     */
    @ApiOperation("微信jsapi下单接口")
    @RequestMapping(value = "/wxjspay", method = RequestMethod.GET)
    public ModelAndView wxjspay(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        //创建sdk客户端
        WXPay wxPay = new WXPay(new WXPayConfigCustom());
        //构造请求的参数
        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("out_trade_no", "10029293889");//订单号
        requestParam.put("body", "iphone8");//订单描述
        requestParam.put("fee_type", "CNY");//人民币
        requestParam.put("total_fee", String.valueOf(1)); //金额
        requestParam.put("spbill_create_ip", "127.0.0.1");//客户端ip
        requestParam.put("notify_url", "none");//微信异步通知支付结果接口，暂时不用
        requestParam.put("trade_type", "JSAPI");
        //从请求中获取openid
        String openid = request.getParameter("openid");
        requestParam.put("openid", openid);
        //调用统一下单接口
        Map<String, String> resp = wxPay.unifiedOrder(requestParam);

        //准备h5网页需要的数据
        Map<String, String> jsapiPayParam = new HashMap<>();
        jsapiPayParam.put("appId", wxPayConfigurationProperties.getAppID());
        jsapiPayParam.put("timeStamp", System.currentTimeMillis() / 1000 + "");
        jsapiPayParam.put("nonceStr", UUID.randomUUID().toString());//随机字符串
        jsapiPayParam.put("package", "prepay_id=" + resp.get("prepay_id"));
        jsapiPayParam.put("signType", "HMAC-SHA256");
        //将h5网页响应给前端
        jsapiPayParam.put("paySign", WXPayUtil.generateSignature(jsapiPayParam, wxPayConfigurationProperties.getKey(),
                WXPayConstants.SignType.HMACSHA256));

        return new ModelAndView("/wxpay", jsapiPayParam);
    }


    class WXPayConfigCustom extends WXPayConfig
    {

        @Override
        protected String getAppID()
        {
            return wxPayConfigurationProperties.getAppID();
        }

        @Override
        protected String getMchID()
        {
            return wxPayConfigurationProperties.getMchID();
        }

        @Override
        protected String getKey()
        {
            return wxPayConfigurationProperties.getKey();
        }

        @Override
        protected InputStream getCertStream()
        {
            return null;
        }

        @Override
        protected IWXPayDomain getWXPayDomain()
        {
            return new IWXPayDomain()
            {
                @Override
                public void report(String s, long l, Exception e)
                {

                }

                @Override
                public DomainInfo getDomain(WXPayConfig wxPayConfig)
                {
                    return new DomainInfo(WXPayConstants.DOMAIN_API, true);
                }
            };
        }
    }

}
