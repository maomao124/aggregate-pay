package mao.aggregate_pay_merchant_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_service.service.MerchantService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.controller
 * Class(类名): MerchantController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:53
 * Version(版本): 1.0
 * Description(描述)： 商户Controller
 */

@RestController
@Api(tags = "商户")
@RequestMapping("/merchant")
public class MerchantController extends BaseController
{

    @Resource
    private MerchantService merchantService;

    @ApiOperation("根据商户id查询商户信息")
    @GetMapping("/{merchantId}")
    public R<MerchantDTO> getById(@PathVariable Long merchantId)
    {
        return R.success(merchantService.getMerchantById(merchantId));
    }

    @ApiOperation("注册商户")
    @PostMapping
    public R<MerchantDTO> getById(@RequestBody MerchantDTO merchantDTO)
    {
        return R.success(merchantService.createMerchant(merchantDTO));
    }
}
