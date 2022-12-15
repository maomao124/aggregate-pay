package mao.auth_server.controller.common;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import mao.auth_server.service.common.LoginLogService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_core.base.id.IdGenerate;
import mao.tools_user.annotation.LoginUser;
import mao.tools_user.entity.SysUser;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.common
 * Class(类名): DashboardController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/12
 * Time(创建时间)： 13:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Validated
@RestController
@Api(value = "dashboard", tags = "首页")
public class DashboardController extends BaseController
{

    @Resource
    private LoginLogService loginLogService;

    @Resource
    private IdGenerate<Long> idGenerate;

    /**
     * 最近10天访问记录
     */
    @GetMapping("/dashboard/visit")
    public R<Map<String, Object>> index(@ApiIgnore @LoginUser SysUser user)
    {
        Map<String, Object> data = new HashMap<>();
        // 获取系统访问记录
        data.put("totalVisitCount", loginLogService.findTotalVisitCount());
        data.put("todayVisitCount", loginLogService.findTodayVisitCount());
        data.put("todayIp", loginLogService.findTodayIp());
        data.put("lastTenVisitCount", loginLogService.findLastTenDaysVisitCount(null));
        data.put("lastTenUserVisitCount", loginLogService.findLastTenDaysVisitCount(user.getAccount()));
        data.put("browserCount", loginLogService.findByBrowser());
        data.put("operatingSystemCount", loginLogService.findByOperatingSystem());
        return success(data);
    }

    /**
     * 生成id
     */
    @GetMapping("/common/generateId")
    public R<Long> generate()
    {
        return success(idGenerate.generate());
    }

}
