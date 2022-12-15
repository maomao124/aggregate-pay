package mao.auth_server.service.common.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.auth.User;
import mao.auth_entity.entity.common.LoginLog;
import mao.auth_server.dao.common.LoginLogMapper;
import mao.auth_server.service.auth.UserService;
import mao.auth_server.service.common.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.common.impl
 * Class(类名): LoginLogServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:08
 * Version(版本): 1.0
 * Description(描述)： 登录日志实现类
 */

@Slf4j
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService
{

    @Resource
    private UserService userService;

    /**
     * 浏览器
     */
    private final static String[] BROWSER = new String[]{
            "Chrome", "Firefox", "Microsoft Edge", "Safari", "Opera"
    };

    /**
     * 操作系统
     */
    private final static String[] OPERATING_SYSTEM = new String[]{
            "Android", "Linux", "Mac OS X", "Ubuntu", "Windows 10", "Windows 8", "Windows 7", "Windows XP", "Windows Vista"
    };


    /**
     * 简化操作系统
     *
     * @param operatingSystem 操作系统
     * @return {@link String}
     */
    private static String simplifyOperatingSystem(String operatingSystem)
    {
        for (String b : OPERATING_SYSTEM)
        {
            if (StrUtil.containsIgnoreCase(operatingSystem, b))
            {
                return b;
            }
        }
        return operatingSystem;
    }

    /**
     * 简化浏览器
     *
     * @param browser 浏览器
     * @return {@link String}
     */
    private static String simplifyBrowser(String browser)
    {
        for (String b : BROWSER)
        {
            if (StrUtil.containsIgnoreCase(browser, b))
            {
                return b;
            }
        }
        return browser;
    }


    @Override
    public LoginLog save(String account, String ua, String ip, String location, String description)
    {
        //获取用户信息
        User user = this.userService.getByAccount(account);
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        //浏览器
        Browser browser = userAgent.getBrowser();
        //操作系统
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        //构建登录日志
        LoginLog loginLog = LoginLog.builder()
                .account(account)
                .location(location)
                .loginDate(LocalDate.now())
                .requestIp(ip)
                .ua(ua)
                .userName(account)
                .browser(simplifyBrowser(browser.getName()))
                .browserVersion(userAgent.getBrowserVersion().getVersion())
                .operatingSystem(simplifyOperatingSystem(operatingSystem.getName()))
                .description(description)
                .build();
        //判断
        if (user != null)
        {
            //设置用户的id和用户性名
            loginLog.setUserId(user.getId()).setUserName(user.getName());
        }
        //保存
        this.save(loginLog);
        return loginLog;
    }

    @Override
    public Long findTotalVisitCount()
    {
        return this.baseMapper.findTotalVisitCount();
    }

    @Override
    public Long findTodayVisitCount()
    {
        LocalDate now = LocalDate.now();
        return this.baseMapper.findTodayVisitCount(now);
    }

    @Override
    public Long findTodayIp()
    {
        LocalDate now = LocalDate.now();
        return this.baseMapper.findTodayIp(now);
    }

    @Override
    public List<Map<String, Object>> findLastTenDaysVisitCount(String account)
    {
        //10天前的日期
        LocalDate tenDays = LocalDate.now().plusDays(-9);
        return this.baseMapper.findLastTenDaysVisitCount(tenDays, account);
    }

    @Override
    public List<Map<String, Object>> findByBrowser()
    {
        return this.baseMapper.findByBrowser();
    }

    @Override
    public List<Map<String, Object>> findByOperatingSystem()
    {
        return this.baseMapper.findByOperatingSystem();
    }
}
