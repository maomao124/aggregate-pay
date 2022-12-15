package mao.auth_server.controller.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.common.OptLog;
import mao.auth_server.service.common.OptLogService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.tools_log.annotation.SysLog;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.common
 * Class(类名): OptLogController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/12
 * Time(创建时间)： 13:33
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/optLog")
@Api(value = "OptLog", tags = "系统操作日志")
public class OptLogController extends BaseController
{

    @Resource
    private OptLogService optLogService;

    /**
     * 分页查询系统操作日志
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @ApiOperation(value = "分页查询系统操作日志", notes = "分页查询系统操作日志")
    @GetMapping("/page")
    public R<IPage<OptLog>> page(OptLog data)
    {
        IPage<OptLog> page = getPage();
        LbqWrapper<OptLog> query = Wraps.lbQ(data)
                .leFooter(OptLog::getCreateTime, getEndCreateTime())
                .geHeader(OptLog::getCreateTime, getStartCreateTime())
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

    /**
     * 删除系统操作日志
     */
    @Transactional
    @ApiOperation(value = "删除系统操作日志", notes = "根据id物理删除系统操作日志")
    @DeleteMapping
    @SysLog("删除系统操作日志")
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids)
    {
        optLogService.removeByIds(ids);
        return success(true);
    }
}
