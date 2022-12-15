package mao.auth_server.controller.common;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.common.LoginLog;
import mao.auth_server.service.auth.UserService;
import mao.auth_server.service.common.LoginLogService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.tools_log.annotation.SysLog;
import mao.tools_log.utils.AddressUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.common
 * Class(类名): LoginLogController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/12
 * Time(创建时间)： 13:37
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/loginLog")
@Api(value = "LoginLog", tags = "登录日志")
public class LoginLogController extends BaseController
{
    @Resource
    private LoginLogService loginLogService;

    @Resource
    private UserService userService;

    /**
     * 分页查询登录日志
     */
    @ApiOperation(value = "分页查询登录日志", notes = "分页查询登录日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    public R<IPage<LoginLog>> page(LoginLog data)
    {
        IPage<LoginLog> page = this.getPage();
        LbqWrapper<LoginLog> query = Wraps.<LoginLog>lbQ()
                .eq(LoginLog::getUserId, data.getUserId())
                .likeRight(LoginLog::getAccount, data.getAccount())
                .likeRight(LoginLog::getRequestIp, data.getRequestIp())
                .like(LoginLog::getLocation, data.getLocation())
                .leFooter(LoginLog::getCreateTime, this.getEndCreateTime())
                .geHeader(LoginLog::getCreateTime, this.getStartCreateTime())
                .orderByDesc(LoginLog::getId);
        this.loginLogService.page(page, query);
        return this.success(page);
    }

    /**
     * 查询登录日志
     */
    @ApiOperation(value = "查询登录日志", notes = "查询登录日志")
    @GetMapping("/{id}")
    public R<LoginLog> get(@PathVariable Long id)
    {
        return this.success(this.loginLogService.getById(id));
    }

    /**
     * 新增登录日志
     */
    @Transactional
    @ApiOperation(value = "新增登录日志", notes = "新增登录日志不为空的字段")
    @GetMapping("/anno/login/{account}")
    public R<LoginLog> save(@NotBlank(message = "用户名不能为为空") @PathVariable String account, @RequestParam(required = false, defaultValue = "登陆成功") String description)
    {
        String ua = StrUtil.sub(this.request.getHeader("user-agent"), 0, 500);
        String ip = ServletUtil.getClientIP(this.request);
        String location = AddressUtil.getRegion(ip);
        // update last login time
        this.userService.updateLoginTime(account);
        LoginLog loginLog = this.loginLogService.save(account, ua, ip, location, description);
        return this.success(loginLog);
    }

    /**
     * 删除登录日志
     */
    @Transactional
    @ApiOperation(value = "删除日志", notes = "根据id物理删除登录日志")
    @DeleteMapping
    @SysLog("删除登录日志")
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids)
    {
        this.loginLogService.removeByIds(ids);
        return this.success(true);
    }
}
