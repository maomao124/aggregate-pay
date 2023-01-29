package mao.aggregate_pay_transaction_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_transaction_api.dto.QRCodeDto;
import mao.aggregate_pay_transaction_service.service.TransactionService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.controller
 * Class(类名): TransactionController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/29
 * Time(创建时间)： 14:43
 * Version(版本): 1.0
 * Description(描述)： 交易相关
 */

@Slf4j
@RestController
@RequestMapping("/transaction")
@Api(value = "交易相关", tags = "交易相关")
public class TransactionController extends BaseController
{

    @Resource
    private TransactionService transactionService;

    /**
     * 生成门店二维码的url
     *
     * @param qrCodeDto 二维码dto
     * @return {@link R}<{@link String}>
     */
    @ApiOperation("生成门店二维码的url")
    @PostMapping("/createStoreQRCode")
    public R<String> createStoreQRCode(@RequestBody QRCodeDto qrCodeDto)
    {
        String url = transactionService.createStoreQRCode(qrCodeDto);
        return success(url);
    }

}
