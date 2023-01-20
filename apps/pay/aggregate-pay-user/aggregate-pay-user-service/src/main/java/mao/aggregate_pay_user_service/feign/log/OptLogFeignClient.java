package mao.aggregate_pay_user_service.feign.log;

import mao.aggregate_pay_entity.entity.OptLog;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.feign.log
 * Interface(接口名): OptLogFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 15:36
 * Version(版本): 1.0
 * Description(描述)： 操作日志feign接口
 */

@FeignClient(value = "aggregate-pay-log", path = "/log/opt")
public interface OptLogFeignClient
{
    /**
     * 保存操作日志
     *
     * @param optLog 操作日志
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping
    R<Boolean> save(@RequestBody OptLog optLog);


    /**
     * 分页查询系统操作日志，返回值类型为R<Page<OptLog>>
     */

    @GetMapping("/page")
    String page(@RequestParam Long current, @RequestParam Long size);


    /**
     * 分页查询某个商户的系统操作日志，返回值类型为R<Page<OptLog>>
     */
    @GetMapping("/page/{merchantId}")
    String page(@RequestParam Long current, @RequestParam Long size, @PathVariable Long merchantId);

    /**
     * 分页查询某个商户的系统操作日志，给商户看的，返回值类型为R<Page<OptLog>>
     */
    @GetMapping("/page2/{merchantId}")
    String page2(@RequestParam Long current, @RequestParam Long size, @PathVariable Long merchantId);


    /**
     * 查询系统操作日志，返回值类型为R<Page<OptLog>>
     */
    @GetMapping("/{id}")
    String get(@PathVariable Long id);
}
