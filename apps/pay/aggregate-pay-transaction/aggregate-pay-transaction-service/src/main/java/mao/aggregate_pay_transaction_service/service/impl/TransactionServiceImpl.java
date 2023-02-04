package mao.aggregate_pay_transaction_service.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_common.utils.AmountUtil;
import mao.aggregate_pay_common.utils.EncryptUtil;
import mao.aggregate_pay_merchant_api.feign.AppFeignClient;
import mao.aggregate_pay_merchant_api.feign.MerchantFeignClient;
import mao.aggregate_pay_merchant_api.feign.StoreFeignClient;
import mao.aggregate_pay_payment_agent_api.dto.*;
import mao.aggregate_pay_payment_agent_api.feign.PayChannelAgentFeignClient;
import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import mao.aggregate_pay_transaction_api.dto.PayOrderDTO;
import mao.aggregate_pay_transaction_api.dto.QRCodeDto;
import mao.aggregate_pay_transaction_service.entity.PayOrder;
import mao.aggregate_pay_transaction_service.handler.AssertResult;
import mao.aggregate_pay_transaction_service.properties.WeiXinConfigurationProperties;
import mao.aggregate_pay_transaction_service.service.PayChannelParamService;
import mao.aggregate_pay_transaction_service.service.PayChannelService;
import mao.aggregate_pay_transaction_service.service.PayOrderService;
import mao.aggregate_pay_transaction_service.service.TransactionService;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.update.LbuWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(类名): TransactionServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/29
 * Time(创建时间)： 14:23
 * Version(版本): 1.0
 * Description(描述)： 交易相关的服务接口实现类
 */

@Slf4j
@Service
@RefreshScope
public class TransactionServiceImpl implements TransactionService
{

    @Value("${pay.payurl}")
    private String payUrl;

    @Resource
    private AppFeignClient appFeignClient;

    @Resource
    private StoreFeignClient storeFeignClient;

    @Resource
    private PayOrderService payOrderService;

    @Resource
    private PayChannelParamService payChannelParamService;

    @Resource
    private PayChannelAgentFeignClient payChannelAgentFeignClient;

    @Resource
    private WeiXinConfigurationProperties weiXinConfigurationProperties;


    @Override
    public String createStoreQRCode(QRCodeDto qrCodeDto)
    {
        //校验应用和门店是否属于当前登录商户
        verifyAppAndStore(qrCodeDto.getMerchantId(), qrCodeDto.getAppId(), qrCodeDto.getStoreId());
        //校验通过
        //生成支付信息
        PayOrderDTO payOrderDTO = new PayOrderDTO();
        payOrderDTO.setMerchantId(qrCodeDto.getMerchantId());
        payOrderDTO.setAppId(qrCodeDto.getAppId());
        payOrderDTO.setStoreId(qrCodeDto.getStoreId());
        if (qrCodeDto.getTotalAmount() != null)
        {
            //总金额
            payOrderDTO.setTotalAmount(Integer.valueOf(AmountUtil.changeY2F(qrCodeDto.getTotalAmount())));
        }
        //显示订单标题
        payOrderDTO.setSubject(qrCodeDto.getSubject());
        //服务类型
        payOrderDTO.setChannel("aggregate_pay_c2b");
        //订单内容
        payOrderDTO.setBody(qrCodeDto.getBody());
        //转json
        String jsonString = JSON.toJSONString(payOrderDTO);
        log.info("生成门店二维码的url PayOrderDTO:" + jsonString);

        //转码，将支付信息保存到票据中
        String ticket = EncryptUtil.encodeUTF8StringBase64(jsonString);
        //支付入口
        String payEntryUrl = payUrl + ticket;
        log.debug("payUrl:" + payEntryUrl);
        //返回
        return payEntryUrl;
    }

    /**
     * 校验应用和门店是否属于当前登录商户
     *
     * @param merchantId 商人id
     * @param appId      应用程序id
     * @param storeId    存储id
     */
    private void verifyAppAndStore(Long merchantId, String appId, Long storeId)
    {
        //判断应用是否属于当前商户
        R<Boolean> r = appFeignClient.queryAppInMerchant(appId, merchantId);
        //断言结果
        Boolean result = AssertResult.handler(r);
        //判断是否属于当前商户
        if (!result)
        {
            throw BizException.wrap("当前应用不属于当前商户");
        }
        //判断门店是否属于当前商户
        R<Boolean> r1 = storeFeignClient.queryStoreInMerchant(storeId, merchantId);
        //断言结果
        Boolean result1 = AssertResult.handler(r1);
        //判断是否属于当前商户
        if (!result1)
        {
            throw BizException.wrap("当前门店不属于当前商户");
        }
    }


    @Override
    public PaymentResponseDTO<String> submitOrderByAli(PayOrderDTO payOrderDTO)
    {
        payOrderDTO.setPayChannel("ALIPAY_WAP");
        //保存订单
        payOrderService.save(payOrderDTO);
        //请求代理服务调用支付宝下单
        return createPayOrderByAliWAP(payOrderDTO.getTradeNo());
    }


    /**
     * 请求代理服务调用支付宝下单
     *
     * @param tradeNo 订单号
     * @return {@link PaymentResponseDTO}<{@link String}>
     */
    private PaymentResponseDTO<String> createPayOrderByAliWAP(String tradeNo)
    {
        //构建支付实体
        AlipayBean alipayBean = new AlipayBean();
        //根据订单号查询订单详情
        PayOrderDTO payOrderDTO = payOrderService.queryPayOrderByTradeNo(tradeNo);
        //判断
        if (payOrderDTO == null)
        {
            throw BizException.wrap("查询的订单不存在");
        }
        //设置平台订单号
        alipayBean.setOutTradeNo(tradeNo);
        //设置商品标题
        alipayBean.setSubject(payOrderDTO.getSubject());
        //支付宝那边入参是元
        String totalAmount = null;
        try
        {
            //将分转成元
            totalAmount = AmountUtil.changeF2Y(payOrderDTO.getTotalAmount().toString());
        }
        catch (Exception e)
        {
            log.error("金额转换失败：", e);
            throw BizException.wrap("订单金额转换异常");
        }
        //设置总金额
        alipayBean.setTotalAmount(totalAmount);
        //设置订单描述
        alipayBean.setBody(payOrderDTO.getBody());
        //商户下门店，如果未指定，默认是根门店
        alipayBean.setStoreId(payOrderDTO.getStoreId());
        //过期时间，30分钟
        alipayBean.setExpireTime("30m");

        //根据应用、服务类型、支付渠道查询支付渠道参数
        PayChannelParamDTO payChannelParamDTO =
                payChannelParamService.queryParamByAppPlatformAndPayChannel(payOrderDTO.getAppId(),
                        payOrderDTO.getChannel(), "ALPAY_WEBP").getData();
        //判断
        if (payChannelParamDTO == null)
        {
            throw BizException.wrap("原始支付渠道为空");
        }
        //得到支付宝渠道参数，json转换为对象
        AliConfigParam aliConfigParam = JSON.parseObject(payChannelParamDTO.getParam(), AliConfigParam.class);
        //设置字符编码
        aliConfigParam.setCharset("utf-8");
        //构建请求体
        PayOrderByAliWAPBody payOrderByAliWAPBody = new PayOrderByAliWAPBody();
        payOrderByAliWAPBody.setAliConfigParam(aliConfigParam);
        payOrderByAliWAPBody.setAlipayBean(alipayBean);
        //远程调用
        R<PaymentResponseDTO<String>> r = payChannelAgentFeignClient.createPayOrderByAliWAP(payOrderByAliWAPBody);
        //判断是否错误
        if (r.getIsError())
        {
            //错误
            log.warn("远程调用错误：" + r.getMsg());
            throw BizException.wrap("支付宝确认支付失败");
        }
        //成功，取数据
        PaymentResponseDTO<String> paymentResponseDTO = r.getData();
        //打印
        log.debug("支付宝响应内容：" + paymentResponseDTO.getContent());
        //返回
        return paymentResponseDTO;
    }


    @Override
    public void updateOrderTradeNoAndTradeState(String tradeNo, String payChannelTradeNo, String state)
    {
        //更新订单状态
        LbuWrapper<PayOrder> lbuWrapper = Wraps.<PayOrder>lbU().eq(PayOrder::getTradeNo, tradeNo)
                //第三方外部订单号
                .set(PayOrder::getPayChannelTradeNo, payChannelTradeNo)
                //状态
                .set(PayOrder::getTradeState, state);

        //判断是否为成功状态
        if ("2".equals(state))
        {
            //设置支付成功的时间
            lbuWrapper.set(PayOrder::getPaySuccessTime, LocalDateTime.now());
        }
        //更新
        payOrderService.update(lbuWrapper);
    }


    @Override
    public String getWXOAuth2Code(PayOrderDTO order)
    {
        //将订单信息封装到state参数中
        String state = EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(order));
        //应用id
        String appId = order.getAppId();
        //服务类型
        String channel = order.getChannel();
        //获取微信支付渠道参数，根据应用、服务类型、支付渠道查询支付渠道参数
        R<PayChannelParamDTO> r = payChannelParamService.queryParamByAppPlatformAndPayChannel(appId, channel, "WX_JSAPI");
        PayChannelParamDTO channelParamDTO = AssertResult.handler(r);
        if (channelParamDTO == null)
        {
            throw BizException.wrap("原始支付渠道为空");
        }
        //支付渠道参数
        String payParam = channelParamDTO.getParam();
        //转换
        WXConfigParam wxConfigParam = JSON.parseObject(payParam, WXConfigParam.class);
        try
        {
            String url = String.format("%s?appid=%s&scope=snsapi_base&state=%s&redirect_uri=%s",
                    weiXinConfigurationProperties.getOauth2RequestUrl(),
                    wxConfigParam.getAppId(),
                    state,
                    URLEncoder.encode(weiXinConfigurationProperties.getOauth2CodeReturnUrl(),
                            "utf-8"));
            log.info("微信生成授权码url:{}", url);
            return "redirect:" + url;
        }
        catch (UnsupportedEncodingException e)
        {
            log.error("生成获取授权码链接失败：", e);
            //生成获取授权码链接失败
            return "forward:/pay‐page‐error";
        }
    }
}
