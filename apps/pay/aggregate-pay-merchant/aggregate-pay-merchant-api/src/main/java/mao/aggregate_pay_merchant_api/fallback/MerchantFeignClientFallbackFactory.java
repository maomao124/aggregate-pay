package mao.aggregate_pay_merchant_api.fallback;

import feign.hystrix.FallbackFactory;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_api.feign.AppFeignClient;
import mao.aggregate_pay_merchant_api.feign.MerchantFeignClient;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.fallback
 * Class(类名): MerchantFeignClientFallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/6
 * Time(创建时间)： 22:43
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class MerchantFeignClientFallbackFactory implements FallbackFactory<MerchantFeignClient>
{

    @Override
    public MerchantFeignClient create(Throwable throwable)
    {
        return new MerchantFeignClient()
        {
            @Override
            public R<MerchantDTO> getById(Long merchantId)
            {
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<MerchantDTO> createMerchant(MerchantDTO merchantDTO)
            {
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> applyMerchant(Long merchantId, MerchantDTO merchantDTO)
            {
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<StoreDTO> createStore(StoreDTO storeDTO)
            {
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<StaffDTO> createStaff(StaffDTO staffDTO)
            {
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> bindStaffToStore(Long storeId, Long staffId)
            {
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<MerchantDTO> getMerchantByTenantId(Long tenantId)
            {
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<PageVO<StoreDTO>> queryStoreByPage(StoreDTO storeDTO, Integer pageNo, Integer pageSize)
            {
                throw BizException.wrap("商户服务不可用或者服务异常");
            }
        };
    }
}
