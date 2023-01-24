package mao.aggregate_pay_log.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_entity.entity.LoginLog;
import mao.aggregate_pay_entity.entity.OptLog;
import mao.aggregate_pay_log.service.LoginLogService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.controller
 * Class(类名): LoginLogController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 15:27
 * Version(版本): 1.0
 * Description(描述)： 登录日志
 */

@Api(tags = "登录日志")
@RestController
@RequestMapping("/log/login")
public class LoginLogController extends BaseController
{
    @Resource
    private LoginLogService loginLogService;

    /**
     * 保存登录日志
     *
     * @param loginLog 登录日志
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping
    @ApiOperation("保存登录日志")
    public R<Boolean> save(@RequestBody LoginLog loginLog)
    {
        boolean save = loginLogService.save(loginLog);
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
    @ApiOperation(value = "分页查询系统登录日志", notes = "分页查询系统登录日志")
    @GetMapping("/page")
    public R<IPage<LoginLog>> page()
    {
        IPage<LoginLog> page = getPage();
        LbqWrapper<LoginLog> query = Wraps.<LoginLog>lbQ()
                .orderByDesc(LoginLog::getId);
        loginLogService.page(page, query);
        return success(page);
    }

    /**
     * 查询系统登录日志
     */
    @ApiOperation(value = "查询系统登录日志", notes = "查询系统登录日志")
    @GetMapping("/{id}")
    public R<LoginLog> get(@PathVariable Long id)
    {
        return success(loginLogService.getById(id));
    }
}
