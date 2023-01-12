package mao.aggregate_pay_merchant_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_merchant_api.dto.AppDTO;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.feign
 * Interface(接口名): AppFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/12
 * Time(创建时间)： 20:00
 * Version(版本): 1.0
 * Description(描述)： feign接口
 */

@FeignClient(value = "aggregate-pay-merchant-service", path = "/app")
public interface AppFeignClient
{
    /**
     * 创建应用
     *
     * @param merchantId 商户id
     * @param app        {@link AppDTO}
     * @return {@link R}<{@link AppDTO}>
     */
    @PostMapping("/{merchantId}")
    R<AppDTO> createApp(@PathVariable Long merchantId, @RequestBody AppDTO app);
}
