package mao.aggregate_pay_uaa_service.feign.log;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_entity.entity.LoginLog;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.feign.log
 * Interface(接口名): LoginLogFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 15:37
 * Version(版本): 1.0
 * Description(描述)： 登录日志feign接口
 */

@FeignClient(value = "aggregate-pay-log", path = "/log/login")
public interface LoginLogFeignClient
{
    /**
     * 保存登录日志
     *
     * @param loginLog 登录日志
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping
    @ApiOperation("保存登录日志")
    R<Boolean> save(@RequestBody LoginLog loginLog);

    /**
     * 分页查询系统操作日志
     */
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
                    @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
            })
    @ApiOperation(value = "分页查询系统登录日志", notes = "分页查询系统登录日志")
    @GetMapping("/page")
    String page(@RequestParam Long current, @RequestParam Long size);

    /**
     * 查询系统登录日志
     */
    @ApiOperation(value = "查询系统登录日志", notes = "查询系统登录日志")
    @GetMapping("/{id}")
    R<LoginLog> get(@PathVariable Long id);
}
