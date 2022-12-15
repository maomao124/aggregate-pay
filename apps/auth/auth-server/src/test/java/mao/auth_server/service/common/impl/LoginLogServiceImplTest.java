package mao.auth_server.service.common.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.common.LoginLog;
import mao.auth_server.service.auth.UserService;
import mao.auth_server.service.common.LoginLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.common.impl
 * Class(测试类名): LoginLogServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:20
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@Transactional
@SpringBootTest
class LoginLogServiceImplTest
{

    @Autowired
    private LoginLogService loginLogService;

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        List<LoginLog> loginLogList = loginLogService.list();
        for (LoginLog loginLog : loginLogList)
        {
            System.out.println(loginLog);
            System.out.println();
        }
    }

    /**
     * 保存
     */
    @Test
    void save()
    {

    }

    /**
     * 发现总访问数
     */
    @Test
    void findTotalVisitCount()
    {
        System.out.println(loginLogService.findTotalVisitCount());
    }

    /**
     * 发现今天访问数
     */
    @Test
    void findTodayVisitCount()
    {
        System.out.println(loginLogService.findTodayVisitCount());
    }

    /**
     * 今天找到ip
     */
    @Test
    void findTodayIp()
    {
        System.out.println(loginLogService.findTodayIp());
    }

    /**
     * 找到最后一个十天访问
     */
    @Test
    void findLastTenDaysVisitCount()
    {
        System.out.println(loginLogService.findLastTenDaysVisitCount("123"));
    }

    /**
     * 发现通过浏览器
     */
    @Test
    void findByBrowser()
    {
        System.out.println(loginLogService.findByBrowser());
    }

    /**
     * 发现由操作系统
     */
    @Test
    void findByOperatingSystem()
    {
        System.out.println(loginLogService.findByOperatingSystem());
    }
}