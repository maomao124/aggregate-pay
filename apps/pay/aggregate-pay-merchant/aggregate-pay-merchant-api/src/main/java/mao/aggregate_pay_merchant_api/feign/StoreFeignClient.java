package mao.aggregate_pay_merchant_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_api.fallback.StoreFeignClientFallbackFactory;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.feign
 * Interface(接口名): StoreFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/28
 * Time(创建时间)： 22:12
 * Version(版本): 1.0
 * Description(描述)： feign接口
 */

@FeignClient(value = "aggregate-pay-merchant-service", path = "/store", fallbackFactory = StoreFeignClientFallbackFactory.class)
public interface StoreFeignClient
{
    /**
     * 查询门店是否属于某商户
     *
     * @param storeId    门店id
     * @param merchantId 商户id
     * @return {@link R}<{@link Boolean}>
     */
    @GetMapping("/queryStoreInMerchant/{storeId}/{merchantId}")
    R<Boolean> queryStoreInMerchant(@PathVariable Long storeId, @PathVariable Long merchantId);


    /**
     * 更新商户下的门店信息
     *
     * @param storeDTO 门店dto
     * @return {@link StoreDTO}
     */
    @ApiOperation("更新商户下的门店信息")
    @PutMapping("my/stores")
    R<StoreDTO> update(@RequestBody StoreDTO storeDTO);


    /**
     * 新增商户下的门店信息
     *
     * @param storeDTO 门店dto
     * @return {@link StoreDTO}
     */
    @ApiOperation("新增商户下的门店信息")
    @PostMapping("my/stores")
    R<StoreDTO> save(@RequestBody StoreDTO storeDTO, @RequestParam String staffIds);


    /**
     * 删除商户下的门店信息
     *
     * @param storeDTO 门店dto
     * @return {@link Boolean}
     */
    @ApiOperation("删除商户下的门店信息")
    @DeleteMapping("my/stores")
    R<Boolean> delete(@RequestBody StoreDTO storeDTO);
}
