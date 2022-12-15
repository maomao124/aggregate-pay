package mao.auth_server.dao.common;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.common
 * Class(测试类名): LoginLogMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 22:22
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class LoginLogMapperTest
{

    @Autowired
    private LoginLogMapper loginLogMapper;


    /**
     * 发现总访问数
     */
    @Test
    void findTotalVisitCount()
    {
        System.out.println(loginLogMapper.findTotalVisitCount());
    }

    /**
     * 发现今天访问数
     */
    @Test
    void findTodayVisitCount()
    {
        loginLogMapper.findTodayVisitCount(LocalDate.now());
    }

    /**
     * 今天找到ip
     */
    @Test
    void findTodayIp()
    {
        Long ip = loginLogMapper.findTodayIp(LocalDate.now());
        System.out.println(ip);
    }

    /**
     * 找到最后一个十天访问
     */
    @Test
    void findLastTenDaysVisitCount()
    {

    }

    /**
     * 发现通过浏览器
     */
    @Test
    void findByBrowser()
    {
        List<Map<String, Object>> byBrowser = loginLogMapper.findByBrowser();
        System.out.println(byBrowser);
    }

    /**
     * 发现由操作系统
     */
    @Test
    void findByOperatingSystem()
    {
        System.out.println(loginLogMapper.findByOperatingSystem());
    }
}