package mao.aggregate_pay_merchant_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
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

    /**
     * 根据商户id查询商户信息
     *
     * @param merchantId 商人id
     * @return {@link R}<{@link MerchantDTO}>
     */
    @ApiOperation("根据商户id查询商户信息")
    @GetMapping("/{merchantId}")
    public R<MerchantDTO> getById(@PathVariable Long merchantId)
    {
        return R.success(merchantService.getMerchantById(merchantId));
    }


    /**
     * 注册商户
     *
     * @param merchantDTO 商人dto
     * @return {@link R}<{@link MerchantDTO}>
     */
    @ApiOperation("注册商户")
    @PostMapping
    public R<MerchantDTO> createMerchant(@RequestBody MerchantDTO merchantDTO)
    {
        return R.success(merchantService.createMerchant(merchantDTO));
    }


    /**
     * 商户资质申请
     *
     * @param merchantId  商人id
     * @param merchantDTO 商人dto
     * @return {@link R}<{@link Boolean}>
     */
    @ApiOperation("商户资质申请")
    @PostMapping("/{merchantId}")
    public R<Boolean> applyMerchant(@PathVariable Long merchantId, @RequestBody MerchantDTO merchantDTO)
    {
        merchantService.applyMerchant(merchantId, merchantDTO);
        return R.success();
    }


    /**
     * 商户下新增门店
     *
     * @param storeDTO 商店dto
     * @return {@link R}<{@link StoreDTO}>
     */
    @ApiOperation("商户资质申请")
    @PostMapping("/createStore")
    public R<StoreDTO> createStore(@RequestBody StoreDTO storeDTO)
    {
        return success(merchantService.createStore(storeDTO));
    }


    /**
     * 商户新增员工
     *
     * @param staffDTO 员工dto
     * @return {@link R}<{@link StaffDTO}>
     */
    @ApiOperation("商户新增员工")
    @PostMapping("/createStaff")
    public R<StaffDTO> createStaff(@RequestBody StaffDTO staffDTO)
    {
        return success(merchantService.createStaff(staffDTO));
    }


    /**
     * 为门店设置管理员
     *
     * @param storeId 门店id
     * @param staffId 员工id
     * @return {@link R}<{@link Boolean}>
     */
    @ApiOperation("为门店设置管理员")
    @PostMapping("/bindStaffToStore/{storeId}/{staffId}")
    R<Boolean> bindStaffToStore(@PathVariable Long storeId, @PathVariable Long staffId)
    {
        merchantService.bindStaffToStore(storeId, staffId);
        return success();
    }


    /**
     * 根据租户id查询商户信息
     *
     * @param tenantId 租户id
     * @return {@link R}<{@link MerchantDTO}>
     */
    @ApiOperation("根据租户id查询商户信息")
    @GetMapping("/tenantId/{tenantId}")
    public R<MerchantDTO> getMerchantByTenantId(@PathVariable Long tenantId)
    {
        MerchantDTO merchantDTO = merchantService.getMerchantByTenantId(tenantId);
        return success(merchantDTO);
    }

    /**
     * 分页条件查询商户下门店
     *
     * @param storeDTO 商店dto
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return {@link R}<{@link PageVO}<{@link StoreDTO}>>
     */
    @ApiOperation("分页条件查询商户下门店")
    @PostMapping("/queryStoreByPage/{pageNo}/{pageSize}")
    public R<PageVO<StoreDTO>> queryStoreByPage(@RequestBody StoreDTO storeDTO,
                                                @PathVariable Integer pageNo,
                                                @PathVariable Integer pageSize)
    {
        return success(merchantService.queryStoreByPage(storeDTO, pageNo, pageSize));
    }
}
