package mao.aggregate_pay_log.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_log.entity.OptLog;
import mao.aggregate_pay_log.service.OptLogService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 分页查询系统操作日志
     */
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
                    @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
            })
    @ApiOperation(value = "分页查询系统操作日志", notes = "分页查询系统操作日志")
    @GetMapping("/page")
    public R<IPage<OptLog>> page()
    {
        IPage<OptLog> page = getPage();
        LbqWrapper<OptLog> query = Wraps.<OptLog>lbQ()
                .orderByDesc(OptLog::getId);
        optLogService.page(page, query);
        return success(page);
    }


    /**
     * 分页查询某个商户的系统操作日志
     */
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
                    @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
            })
    @ApiOperation(value = "分页查询某个商户的系统操作日志", notes = "分页查询某个商户的系统操作日志")
    @GetMapping("/page/{merchantId}")
    public R<IPage<OptLog>> page(@PathVariable Long merchantId)
    {
        if (merchantId == null || merchantId < 0)
        {
            return R.success(getPage());
        }
        IPage<OptLog> page = getPage();
        LbqWrapper<OptLog> query = Wraps.<OptLog>lbQ()
                .eq(OptLog::getUserName, merchantId)
                .orderByDesc(OptLog::getId);
        optLogService.page(page, query);
        return success(page);
    }

    /**
     * 分页查询某个商户的系统操作日志，给商户看的
     */
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
                    @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
            })
    @ApiOperation(value = "商户分页查询的系统操作日志", notes = "商户分页查询的系统操作日志")
    @GetMapping("/page2/{merchantId}")
    public R<IPage<OptLog>> page2(@PathVariable Long merchantId)
    {
        if (merchantId == null || merchantId < 0)
        {
            return R.success(getPage());
        }
        IPage<OptLog> page = getPage();
        LbqWrapper<OptLog> query = Wraps.<OptLog>lbQ()
                .select(OptLog::getDescription, OptLog::getId, OptLog::getFinishTime, OptLog::getRequestIp, OptLog::getType)
                .eq(OptLog::getUserName, merchantId)
                .orderByDesc(OptLog::getId);
        optLogService.page(page, query);
        return success(page);
    }


    /**
     * 查询系统操作日志
     */
    @ApiOperation(value = "查询系统操作日志", notes = "查询系统操作日志")
    @GetMapping("/{id}")
    public R<OptLog> get(@PathVariable Long id)
    {
        return success(optLogService.getById(id));
    }

}
