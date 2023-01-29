package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_common.utils.QRCodeUtil;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_api.feign.MerchantFeignClient;
import mao.aggregate_pay_merchant_application.handler.AssertResult;
import mao.aggregate_pay_merchant_application.utils.SecurityUtil;
import mao.aggregate_pay_transaction_api.dto.QRCodeDto;
import mao.aggregate_pay_transaction_api.feign.TransactionFeignClient;
import mao.tools_core.base.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.controller
 * Class(类名): StoreController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/28
 * Time(创建时间)： 21:27
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@RestController
@Api(value = "商户平台‐门店管理", tags = "商户平台‐门店管理")
public class StoreController
{

    @Resource
    private MerchantFeignClient merchantFeignClient;

    @Resource
    private TransactionFeignClient transactionFeignClient;

    /**
     * 主题:"%s商品"
     */
    @Value("${pay.c2b.subject}")
    String subject;

    /**
     * 内容："向%s付款"
     */
    @Value("${pay.c2b.body}")
    String body;


    /**
     * 分页条件查询商户下门店
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link StoreDTO}>
     */
    @ApiOperation("分页条件查询商户下门店")
    @ApiImplicitParams
            (
                    {
                            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "int",
                                    paramType = "query"),
                            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType =
                                    "int", paramType = "query")
                    }
            )
    @PostMapping("/my/stores/merchants/page")
    public PageVO<StoreDTO> queryStoreByPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize)
    {
        //检查页面大小
        if (pageSize > 100)
        {
            //不能超过100
            pageSize = 100;
        }
        if (pageSize < 5)
        {
            //不能小于5
            pageSize = 5;
        }
        //获得商户id
        Long merchantId = SecurityUtil.getMerchantIdThrowsException();
        //StoreDTO是为未来预留
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setMerchantId(merchantId);
        //远程调用
        R<PageVO<StoreDTO>> r = merchantFeignClient.queryStoreByPage(storeDTO, pageNo, pageSize);
        //断言结果
        AssertResult.handler(r);
        //返回
        return r.getData();
    }


    /**
     * 生成商户应用门店的二维码
     *
     * @param storeId 商户门店id
     * @param appId   商户应用id
     * @return {@link String}
     */
    @SneakyThrows
    @ApiOperation("生成商户应用门店的二维码")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "appId", value = "商户应用id", required = true, dataType = "String", paramType = "path"),
                    @ApiImplicitParam(name = "storeId", value = "商户门店id", required = true, dataType = "String", paramType = "path"),
            })
    @GetMapping(value = "/my/apps/{appId}/stores/{storeId}/app-store-qrcode")
    public String createCScanBStoreQRCode(@PathVariable("storeId") Long storeId, @PathVariable("appId") String appId)
    {

        //获取商户信息
        MerchantDTO merchantDTO = SecurityUtil.getMerchantThrowsException();

        QRCodeDto qrCodeDto = new QRCodeDto();
        //设置商户id
        qrCodeDto.setMerchantId(merchantDTO.getId());
        //门店id
        qrCodeDto.setStoreId(storeId);
        //应用id
        qrCodeDto.setAppId(appId);
        //标题.用商户名称替换 %s
        String subjectFormat = String.format(subject, merchantDTO.getMerchantName());
        //主题
        qrCodeDto.setSubject(subjectFormat);
        //内容
        String bodyFormat = String.format(body, merchantDTO.getMerchantName());
        qrCodeDto.setBody(bodyFormat);

        //远程调用
        R<String> r = transactionFeignClient.createStoreQRCode(qrCodeDto);
        //断言结果
        AssertResult.handler(r);
        //获取二维码的URL
        String storeQRCodeURL = r.getData();

        //调用工具类生成二维码图片
        QRCodeUtil qrCodeUtil = new QRCodeUtil();
        //二维码图片base64编码
        return qrCodeUtil.createQRCode(storeQRCodeURL, 200, 200);
    }

}
