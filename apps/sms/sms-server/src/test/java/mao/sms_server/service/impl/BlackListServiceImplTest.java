package mao.sms_server.service.impl;

import mao.sms_server.service.BlackListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(测试类名): BlackListServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/31
 * Time(创建时间)： 22:56
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class BlackListServiceImplTest
{

    @Autowired
    private BlackListService blackListService;

    @Test
    void list()
    {
        System.out.println(blackListService.list());
    }
}