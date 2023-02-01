package mao.aggregate_pay_payment_agent_service.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_payment_agent_api.dto.AliConfigParam;
import mao.aggregate_pay_payment_agent_api.dto.AlipayBean;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_payment_agent_service.service.PayChannelAgentService;
import mao.tools_core.exception.BizException;
import org.springframework.stereotype.Service;

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

    @Override
    public PaymentResponseDTO<String> createPayOrderByAliWAP(AliConfigParam aliConfigParam, AlipayBean alipayBean)
    {
        log.debug("支付宝请求参数：" + alipayBean.toString());
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
        String charset = aliConfigParam.getCharset();
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
            return res;
        }
        catch (Exception e)
        {
            log.error("支付宝确认支付失败", e);
            //支付宝确认支付失败
            throw BizException.wrap("支付宝确认支付失败");
        }
    }
}
