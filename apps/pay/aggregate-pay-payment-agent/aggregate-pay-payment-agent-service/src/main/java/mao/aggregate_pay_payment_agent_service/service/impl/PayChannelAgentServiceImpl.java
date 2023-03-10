package mao.aggregate_pay_payment_agent_service.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_payment_agent_api.dto.*;
import mao.aggregate_pay_payment_agent_api.enums.TradeStatus;
import mao.aggregate_pay_payment_agent_service.config.WXSDKConfig;
import mao.aggregate_pay_payment_agent_service.constants.AliCodeConstants;
import mao.aggregate_pay_payment_agent_service.consumer.PayConsumer;
import mao.aggregate_pay_payment_agent_service.producer.PayProducer;
import mao.aggregate_pay_payment_agent_service.service.PayChannelAgentService;
import mao.tools_core.exception.BizException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_service.service.impl
 * Class(类名): PayChannelAgentServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 20:21
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class PayChannelAgentServiceImpl implements PayChannelAgentService
{

    @Resource
    private PayProducer payProducer;

    @Override
    public PaymentResponseDTO<String> createPayOrderByAliWAP(AliConfigParam aliConfigParam, AlipayBean alipayBean)
    {
        log.debug("支付宝请求参数：" + alipayBean.toString());
        //log.debug("支付聚道参数：" + aliConfigParam.toString());
        //支付宝渠道参数
        //支付宝下单接口地址(网关)
        String gateway = aliConfigParam.getUrl();
        //appid
        String appId = aliConfigParam.getAppId();
        //私钥
        String rsaPrivateKey = aliConfigParam.getRsaPrivateKey();
        //数据格式json
        String format = aliConfigParam.getFormat();
        //字符编码
        //String charset = aliConfigParam.getCharset().toUpperCase();
        String charset = "UTF-8";
        //公钥
        String alipayPublicKey = aliConfigParam.getAlipayPublicKey();
        //签名算法类型
        String signType = aliConfigParam.getSignType();
        //支付结果通知地址
        String notifyUrl = aliConfigParam.getNotifyUrl();
        //支付完成返回商户地址
        String returnUrl = aliConfigParam.getReturnUrl();

        //支付宝sdk客户端
        AlipayClient client = new DefaultAlipayClient(gateway, appId, rsaPrivateKey, format, charset, alipayPublicKey, signType);
        // 封装请求支付信息
        AlipayTradeWapPayRequest alipayTradeWapPayRequest = new AlipayTradeWapPayRequest();
        AlipayTradeWapPayModel alipayTradeWapPayModel = new AlipayTradeWapPayModel();
        //平台订单
        alipayTradeWapPayModel.setOutTradeNo(alipayBean.getOutTradeNo());
        //订单标题
        alipayTradeWapPayModel.setSubject(alipayBean.getSubject());
        //订单金额
        alipayTradeWapPayModel.setTotalAmount(alipayBean.getTotalAmount());
        //订单内容
        alipayTradeWapPayModel.setBody(alipayBean.getBody());
        //订单过期时间
        alipayTradeWapPayModel.setTimeoutExpress(alipayBean.getExpireTime());
        //商户与支付宝签定的产品码，固定为QUICK_WAP_WAY
        alipayTradeWapPayModel.setProductCode(alipayBean.getProductCode());
        //请求参数集合
        alipayTradeWapPayRequest.setBizModel(alipayTradeWapPayModel);
        String jsonString = JSON.toJSONString(alipayBean);
        log.debug("alipayBean:" + jsonString);
        //设置异步通知地址
        alipayTradeWapPayRequest.setNotifyUrl(notifyUrl);
        //设置同步地址
        alipayTradeWapPayRequest.setReturnUrl(returnUrl);

        try
        {
            // 调用SDK提交表单
            AlipayTradeWapPayResponse alipayTradeWapPayResponse = client.pageExecute(alipayTradeWapPayRequest);
            log.info("支付宝手机网站支付预支付订单信息：" + alipayTradeWapPayResponse);
            PaymentResponseDTO<String> res = new PaymentResponseDTO<>();
            res.setContent(alipayTradeWapPayResponse.getBody());
            log.debug("下单成功");

            //发送支付结果查询延迟消息
            PaymentResponseDTO<String> notice = new PaymentResponseDTO<>();
            notice.setOutTradeNo(alipayBean.getOutTradeNo());
            notice.setContent(JSON.toJSONString(aliConfigParam));
            notice.setMsg("ALIPAY_WAP");
            //发送延迟消息
            payProducer.payOrderNotice(notice);

            return res;
        }
        catch (Exception e)
        {
            log.error("支付宝确认支付失败", e);
            //支付宝确认支付失败
            throw BizException.wrap("支付宝确认支付失败");
        }
    }


    @Override
    public PaymentResponseDTO<String> queryPayOrderByAli(AliConfigParam aliConfigParam, String outTradeNo)
    {
        log.debug("查询订单：" + outTradeNo);
        //支付接口网关地址
        String gateway = aliConfigParam.getUrl();
        //appid
        String appId = aliConfigParam.getAppId();
        //私钥
        String rsaPrivateKey = aliConfigParam.getRsaPrivateKey();
        //json格式
        String format = aliConfigParam.getFormat();
        //编码
        String charset = aliConfigParam.getCharset().toUpperCase();
        //公钥
        String alipayPublicKey = aliConfigParam.getAlipayPublicKey();
        //签名算法类型
        String signType = aliConfigParam.getSignType();

        //构建sdk客户端
        AlipayClient defaultAlipayClient = new DefaultAlipayClient(gateway, appId, rsaPrivateKey, format, charset, alipayPublicKey, signType);
        //请求
        AlipayTradeQueryRequest queryRequest = new AlipayTradeQueryRequest();
        AlipayTradePayModel alipayTradePayModel = new AlipayTradePayModel();
        //平台订单号
        alipayTradePayModel.setOutTradeNo(outTradeNo);
        //封装请求参数
        queryRequest.setBizModel(alipayTradePayModel);
        PaymentResponseDTO<String> stringPaymentResponseDTO;
        try
        {
            //请求支付宝接口
            AlipayTradeQueryResponse alipayTradeQueryResponse = defaultAlipayClient.execute(queryRequest);
            //接口调用成功
            if (AliCodeConstants.SUCCESSCODE.equals(alipayTradeQueryResponse.getCode()))
            {
                //将支付宝响应的状态转换为平台的状态
                TradeStatus tradeStatus = covertAliTradeStatusToCode(alipayTradeQueryResponse.getTradeStatus());
                //调用success方法
                stringPaymentResponseDTO = PaymentResponseDTO.success(alipayTradeQueryResponse.getTradeNo(),
                        alipayTradeQueryResponse.getOutTradeNo(),
                        tradeStatus,
                        alipayTradeQueryResponse.getMsg() + " " + alipayTradeQueryResponse.getSubMsg());
                log.debug("查询支付宝支付结果" + JSON.toJSONString(stringPaymentResponseDTO));
                return stringPaymentResponseDTO;
            }
        }
        catch (AlipayApiException e)
        {
            log.warn(e.getMessage(), e);
        }
        stringPaymentResponseDTO = PaymentResponseDTO.fail("查询支付宝支付结果异常", outTradeNo, TradeStatus.UNKNOWN);
        return stringPaymentResponseDTO;
    }


    /**
     * 将支付宝查询时订单状态trade_status 转换为 平台订单状态
     *
     * @param aliTradeStatus 支付宝交易状态
     *                       WAIT_BUYER_PAY（交易创建，等待买家付款）
     *                       TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）
     *                       TRADE_SUCCESS（交易支付成功）
     *                       TRADE_FINISHED（交易结束，不可退款）
     * @return {@link TradeStatus}
     */
    private TradeStatus covertAliTradeStatusToCode(String aliTradeStatus)
    {
        switch (aliTradeStatus)
        {
            case AliCodeConstants.WAIT_BUYER_PAY:
                return TradeStatus.USERPAYING;
            case AliCodeConstants.TRADE_SUCCESS:
            case AliCodeConstants.TRADE_FINISHED:
                return TradeStatus.SUCCESS;
            default:
                return TradeStatus.FAILED;
        }
    }


    @Override
    public Map<String, String> createPayOrderByWeChatJSAPI(WXConfigParam wxConfigParam, WeChatBean weChatBean)
    {
        //微信支付参数
        WXSDKConfig config = new WXSDKConfig(wxConfigParam);
        try
        {
            //微信支付
            WXPay wxpay = new WXPay(config);
            //按照微信统一下单接口要求构造请求参数
            Map<String, String> requestParam = new HashMap<>();
            //商品描述
            requestParam.put("body", weChatBean.getBody());
            //商户订单号
            requestParam.put("out_trade_no", weChatBean.getOutTradeNo());
            //人民币
            requestParam.put("fee_type", "CNY");
            //标价金额
            requestParam.put("total_fee", String.valueOf(weChatBean.getTotalFee()));
            //终端IP
            requestParam.put("spbill_create_ip", weChatBean.getSpbillCreateIp());
            //通知地址
            requestParam.put("notify_url", weChatBean.getNotifyUrl());
            //JSAPI
            requestParam.put("trade_type", "JSAPI");
            //openId
            requestParam.put("openid", weChatBean.getOpenId());
            //调用微信统一下单API
            Map<String, String> resp = wxpay.unifiedOrder(requestParam);
            //返回h5网页需要的数据
            String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
            String key = wxConfigParam.getKey();
            Map<String, String> jsapiPayParam = new HashMap<>();
            jsapiPayParam.put("appId", resp.get("appid"));
            jsapiPayParam.put("package", "prepay_id=" + resp.get("prepay_id"));
            jsapiPayParam.put("timeStamp", timestamp);
            jsapiPayParam.put("nonceStr", UUID.randomUUID().toString());
            jsapiPayParam.put("signType", "HMAC‐SHA256");
            jsapiPayParam.put("paySign", WXPayUtil.generateSignature(jsapiPayParam, key, WXPayConstants.SignType.HMACSHA256));
            log.info("微信JSAPI支付响应内容：" + jsapiPayParam);

            //向消息队列发送支付结果查询消息
            PaymentResponseDTO<String> notice = new PaymentResponseDTO<>();
            notice.setOutTradeNo(weChatBean.getOutTradeNo());
            notice.setContent(JSON.toJSONString(wxConfigParam));
            notice.setMsg("WX_JSAPI");
            //发送
            payProducer.payOrderNotice(notice);

            return jsapiPayParam;
        }
        catch (Exception e)
        {
            log.error(e.getMessage(), e);
            throw BizException.wrap("微信下单失败");
        }
    }

    @Override
    public PaymentResponseDTO<String> queryPayOrderByWeChat(WXConfigParam wxConfigParam, String outTradeNo)
    {

        WXSDKConfig wxsdkConfig = new WXSDKConfig(wxConfigParam);
        Map<String, String> resp = null;
        try
        {
            WXPay wxpay = new WXPay(wxsdkConfig);
            Map<String, String> data = new HashMap<>();
            data.put("out_trade_no", outTradeNo);
            //发起请求，查询订单
            resp = wxpay.orderQuery(data);
        }
        catch (Exception e)
        {
            log.warn(e.getMessage(), e);
            return PaymentResponseDTO.fail("调用微信查询订单异常", outTradeNo, TradeStatus.UNKNOWN);
        }
        String returnCode = resp.get("return_code");
        String resultCode = resp.get("result_code");
        String tradeState = resp.get("trade_state");
        String transactionId = resp.get("transaction_id");
        String tradeType = resp.get("trade_type");
        String returnMsg = resp.get("return_msg");

        if ("SUCCESS".equals(returnCode) && "SUCCESS".equals(resultCode))
        {
            // 接口调用成功
            if ("SUCCESS".equals(tradeState))
            {
                //交易成功
                return PaymentResponseDTO.success(transactionId, outTradeNo, TradeStatus.SUCCESS, "交易成功");
            }
            else if ("USERPAYING".equals(tradeState))
            {
                //等待用户支付
                return PaymentResponseDTO.success(transactionId, outTradeNo, TradeStatus.USERPAYING, "等待支付");
            }
            else if ("PAYERROR".equals(tradeState))
            {
                //交易失败
                return PaymentResponseDTO.success(transactionId, outTradeNo, TradeStatus.FAILED, returnMsg);
            }
            else if ("CLOSED".equals(tradeState))
            {
                //交易关闭
                return PaymentResponseDTO.success(transactionId, outTradeNo, TradeStatus.REVOKED, returnMsg);
            }
        }
        //暂不支持其他状态
        return PaymentResponseDTO.success("暂不支持其他状态", transactionId, outTradeNo, TradeStatus.UNKNOWN);
    }
}
