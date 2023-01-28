package mao.aggregate_pay_transaction_service.service;

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
}
