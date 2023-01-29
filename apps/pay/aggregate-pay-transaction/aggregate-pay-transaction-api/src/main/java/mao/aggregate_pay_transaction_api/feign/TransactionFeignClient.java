package mao.aggregate_pay_transaction_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_transaction_api.dto.QRCodeDto;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.feign
 * Interface(接口名): TransactionFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/29
 * Time(创建时间)： 14:58
 * Version(版本): 1.0
 * Description(描述)： 交易相关 feign接口
 */

@FeignClient(value = "aggregate-pay-transaction-service", path = "/transaction")
public interface TransactionFeignClient
{
    /**
     * 生成门店二维码的url
     *
     * @param qrCodeDto 二维码dto
     * @return {@link R}<{@link String}>
     */
    @PostMapping("/createStoreQRCode")
    R<String> createStoreQRCode(@RequestBody QRCodeDto qrCodeDto);
}
