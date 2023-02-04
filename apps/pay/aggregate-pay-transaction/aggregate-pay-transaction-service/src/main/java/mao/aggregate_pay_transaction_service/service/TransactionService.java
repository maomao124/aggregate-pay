package mao.aggregate_pay_transaction_service.service;

import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_transaction_api.dto.PayOrderDTO;
import mao.aggregate_pay_transaction_api.dto.QRCodeDto;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service
 * Interface(接口名): TransactionService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/28
 * Time(创建时间)： 21:44
 * Version(版本): 1.0
 * Description(描述)： 交易相关的服务接口
 */

public interface TransactionService
{
    /**
     * 生成门店二维码的url
     *
     * @param qrCodeDto 二维码dto
     * @return {@link String} 支付入口，用base64编码
     */
    String createStoreQRCode(QRCodeDto qrCodeDto);

    /**
     * 保存支付宝订单，并调用支付渠道代理服务调用支付宝的接口
     *
     * @param payOrderDTO 支付订单dto
     * @return {@link PaymentResponseDTO}<{@link String}>
     */
    PaymentResponseDTO<String> submitOrderByAli(PayOrderDTO payOrderDTO);


    /**
     * 更新订单支付状态
     *
     * @param tradeNo           平台订单号
     * @param payChannelTradeNo 支付宝或微信的交易流水号
     * @param state             订单状态 交易状态支付状态,
     *                          0‐订单生成,
     *                          1‐支付中(目前未使用),
     *                          2‐支付成功,
     *                          4‐关闭,
     *                          5‐失败
     */
    void updateOrderTradeNoAndTradeState(String tradeNo, String payChannelTradeNo, String state);


}
