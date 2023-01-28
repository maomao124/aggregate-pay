package mao.aggregate_pay_merchant_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_merchant_service.service.StoreService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.controller
 * Class(类名): StoreController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/28
 * Time(创建时间)： 22:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
@Api(tags = "门店")
@RequestMapping("/store")
public class StoreController extends BaseController
{

    @Resource
    private StoreService storeService;

    /**
     * 查询门店是否属于某商户
     *
     * @param storeId    门店id
     * @param merchantId 商户id
     * @return {@link R}<{@link Boolean}>
     */
    @ApiOperation("查询门店是否属于某商户")
    @GetMapping("/queryStoreInMerchant/{storeId}/{merchantId}")
    public R<Boolean> queryStoreInMerchant(@PathVariable Long storeId, @PathVariable Long merchantId)
    {
        return storeService.queryStoreInMerchant(storeId, merchantId);
    }

}
