package mao.aggregate_pay_merchant_api.fallback;


import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.feign.StaffFeignClient;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.fallback
 * Class(类名): StaffFeignClientFallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/6
 * Time(创建时间)： 22:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class StaffFeignClientFallbackFactory implements FallbackFactory<StaffFeignClient>
{

    @Override
    public StaffFeignClient create(Throwable throwable)
    {
        return new StaffFeignClient()
        {
            @Override
            public R<PageVO<StaffDTO>> queryStaffByPage(StaffDTO staffDTO, Integer pageNo, Integer pageSize)
            {
                log.error("商户服务不可用或者服务异常", throwable);
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<StaffDTO> saveStaff(StaffDTO staffDTO)
            {
                log.error("商户服务不可用或者服务异常", throwable);
                throw BizException.wrap("商户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> deleteStaff(StaffDTO staffDTO)
            {
                log.error("商户服务不可用或者服务异常", throwable);
                throw BizException.wrap("商户服务不可用或者服务异常");
            }
        };
    }
}
