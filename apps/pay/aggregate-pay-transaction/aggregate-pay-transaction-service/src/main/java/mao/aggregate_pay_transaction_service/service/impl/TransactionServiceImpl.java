package mao.aggregate_pay_transaction_service.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.utils.EncryptUtil;
import mao.aggregate_pay_merchant_api.feign.AppFeignClient;
import mao.aggregate_pay_merchant_api.feign.MerchantFeignClient;
import mao.aggregate_pay_merchant_api.feign.StoreFeignClient;
import mao.aggregate_pay_payment_agent_api.dto.AlipayBean;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_transaction_api.dto.PayOrderDTO;
import mao.aggregate_pay_transaction_api.dto.QRCodeDto;
import mao.aggregate_pay_transaction_service.handler.AssertResult;
import mao.aggregate_pay_transaction_service.service.PayOrderService;
import mao.aggregate_pay_transaction_service.service.TransactionService;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        R<Boolean> r = appFeignClient.queryAppInMerchant(appId, storeId);
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
        return null;
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
    }

}
