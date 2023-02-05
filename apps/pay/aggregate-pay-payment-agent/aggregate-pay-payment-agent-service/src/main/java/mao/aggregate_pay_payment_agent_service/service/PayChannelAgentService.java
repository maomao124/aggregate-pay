package mao.aggregate_pay_payment_agent_service.service;

import mao.aggregate_pay_payment_agent_api.dto.*;

import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_service.service
 * Interface(接口名): PayChannelAgentService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 20:17
 * Version(版本): 1.0
 * Description(描述)： 支付代理服务
 */

public interface PayChannelAgentService
{
    /**
     * 调用支付宝手机WAP下单接口
     *
     * @param aliConfigParam 支付渠道参数
     * @param alipayBean     请求支付参数
     * @return {@link PaymentResponseDTO}
     */
    PaymentResponseDTO<String> createPayOrderByAliWAP(AliConfigParam aliConfigParam, AlipayBean alipayBean);


    /**
     * 查询支付宝支付订单的状态
     *
     * @param aliConfigParam 阿里支付宝配置参数
     * @param outTradeNo     平台订单号
     * @return {@link PaymentResponseDTO}
     */
    PaymentResponseDTO<String> queryPayOrderByAli(AliConfigParam aliConfigParam, String outTradeNo);


    /**
     * 微信jsapi下单接口请求
     *
     * @param wxConfigParam 微信配置参数
     * @param weChatBean    weChatBean
     * @return {@link Map}<{@link String}, {@link String}> h5页面所需要的数据
     */
    Map<String, String> createPayOrderByWeChatJSAPI(WXConfigParam wxConfigParam, WeChatBean weChatBean);


    /**
     * 查询微信的支付订单
     *
     * @param wxConfigParam 微信配置参数
     * @param outTradeNo    平台订单号
     * @return {@link PaymentResponseDTO}<{@link String}>
     */
    public PaymentResponseDTO<String> queryPayOrderByWeChat(WXConfigParam wxConfigParam, String outTradeNo);
}
