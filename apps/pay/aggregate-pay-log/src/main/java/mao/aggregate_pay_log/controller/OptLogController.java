package mao.aggregate_pay_log.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_log.entity.OptLog;
import mao.aggregate_pay_log.service.OptLogService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.controller
 * Class(类名): OptLogController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 14:31
 * Version(版本): 1.0
 * Description(描述)： 操作日志
 */

@Api(tags = "操作日志")
@RestController
@RequestMapping("/log/opt")
public class OptLogController extends BaseController
{
    @Resource
    private OptLogService optLogService;

    /**
     * 保存操作日志
     *
     * @param optLog 操作日志
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping
    @ApiOperation("保存操作日志")
    public R<Boolean> save(@RequestBody OptLog optLog)
    {
        boolean save = optLogService.save(optLog);
        if (!save)
        {
            return fail("保存失败");
        }
        return success();
    }

}
