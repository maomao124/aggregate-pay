package mao.aggregate_pay_merchant_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.feign
 * Interface(接口名): MerchantFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 21:26
 * Version(版本): 1.0
 * Description(描述)： 商户服务feign接口
 */

@FeignClient(value = "aggregate-pay-merchant-service", path = "/merchant")
public interface MerchantFeignClient
{
    /**
     * 根据商户id查询商户信息
     *
     * @param merchantId 商人id
     * @return {@link R}<{@link MerchantDTO}>
     */
    @GetMapping("/{merchantId}")
    R<MerchantDTO> getById(@PathVariable Long merchantId);

    /**
     * 创建商户
     *
     * @param merchantDTO 商人dto
     * @return {@link R}<{@link MerchantDTO}>
     */
    @PostMapping
    R<MerchantDTO> createMerchant(@RequestBody MerchantDTO merchantDTO);

    /**
     * 商户资质申请
     *
     * @param merchantId  商人id
     * @param merchantDTO 商人dto
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping("/{merchantId}")
    R<Boolean> applyMerchant(@PathVariable Long merchantId, @RequestBody MerchantDTO merchantDTO);

    /**
     * 商户下新增门店
     *
     * @param storeDTO 商店dto
     * @return {@link StoreDTO}
     */
    @PostMapping("/createStore")
    R<StoreDTO> createStore(@RequestBody StoreDTO storeDTO);


    /**
     * 商户新增员工
     *
     * @param staffDTO 员工dto
     * @return {@link StaffDTO}
     */
    @PostMapping("/createStaff")
    R<StaffDTO> createStaff(@RequestBody StaffDTO staffDTO);
}
