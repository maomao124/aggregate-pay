package mao.aggregate_pay_transaction_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.feign
 * Interface(接口名): PlatformChannelFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 23:10
 * Version(版本): 1.0
 * Description(描述)： 服务类型 FeignClient
 */

@FeignClient(value = "aggregate-pay-transaction-service", path = "/PlatformChannel")
public interface PlatformChannelFeignClient
{
    /**
     * 获取平台所有服务类型
     *
     * @return {@link R}<{@link List}<{@link PlatformChannelDTO}>>
     */
    @GetMapping
    R<List<PlatformChannelDTO>> queryAll();
}
