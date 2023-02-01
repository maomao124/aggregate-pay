package mao.aggregate_pay_transaction_service.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_service.properties.AliPayConfigurationProperties;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.controller
 * Class(类名): PayTestController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/27
 * Time(创建时间)： 21:12
 * Version(版本): 1.0
 * Description(描述)： 支付测试
 */

@Slf4j
@Controller
@Api(value = "支付宝支付测试", tags = "支付宝支付测试")
@RequestMapping("/alipay")
public class PayTestController
{

    @Resource
    private AliPayConfigurationProperties aliPayConfigurationProperties;


    @ApiOperation(value = "支付宝下单测试", notes = "支付宝下单测试")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "out_trade_no", value = "订单号", dataType = "String")
            }
    )

    @RequestMapping("/test")
    @ResponseBody
    public R<String> alipayTest(@RequestParam String out_trade_no)
    {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfigurationProperties.getServerUrl(),
                aliPayConfigurationProperties.getAppId(),
                aliPayConfigurationProperties.getAppPrivateKey(),
                "json",
                aliPayConfigurationProperties.getCharSet(),
                aliPayConfigurationProperties.getAlipayPublicKey(),
                aliPayConfigurationProperties.getEncryptionMethod());
        //创建API对应的request
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        //在公共参数中设置回跳和通知地址
        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");

        alipayRequest.setBizContent("{" +
                " \"out_trade_no\":\"" + out_trade_no + "\"," +
                " \"total_amount\":\"50.58\"," +
                " \"subject\":\"Iphone14\"," +
                " \"product_code\":\"QUICK_WAP_PAY\"" +
                " }");//填充业务参数


        try
        {
            //调用SDK生成表单
            String form = alipayClient.pageExecute(alipayRequest).getBody();
            return R.success(form);
        }
        catch (AlipayApiException e)
        {
            throw new BizException(e.getErrMsg());
        }

    }


    @ApiOperation(value = "支付宝下单测试-支付宝调用", notes = "支付宝下单测试-支付宝调用")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "out_trade_no", value = "订单号", dataType = "String")
            }
    )

    @RequestMapping(value = "/test2")
    @ResponseBody
    public String alipayTest2(@RequestParam String out_trade_no, HttpServletResponse httpServletResponse)
    {
        //设置响应头
        httpServletResponse.setHeader("content-type", "text/html;charset=UTF-8");
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfigurationProperties.getServerUrl(),
                aliPayConfigurationProperties.getAppId(),
                aliPayConfigurationProperties.getAppPrivateKey(),
                "json",
                aliPayConfigurationProperties.getCharSet(),
                aliPayConfigurationProperties.getAlipayPublicKey(),
                aliPayConfigurationProperties.getEncryptionMethod());
        //创建API对应的request
        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();
        //在公共参数中设置回跳和通知地址
        alipayRequest.setReturnUrl("http://domain.com/CallBack/return_url.jsp");
        alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");

        alipayRequest.setBizContent("{" +
                " \"out_trade_no\":\"" + out_trade_no + "\"," +
                " \"total_amount\":\"50.58\"," +
                " \"subject\":\"Iphone14\"," +
                " \"product_code\":\"QUICK_WAP_PAY\"" +
                " }");//填充业务参数


        try
        {
            //调用SDK生成表单
            return alipayClient.pageExecute(alipayRequest).getBody();
        }
        catch (AlipayApiException e)
        {
            throw new BizException(e.getErrMsg());
        }

    }
}
