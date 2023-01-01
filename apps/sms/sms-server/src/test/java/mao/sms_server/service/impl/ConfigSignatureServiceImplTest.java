package mao.sms_server.service.impl;

import mao.sms_server.service.ConfigSignatureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(测试类名): ConfigSignatureServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/1
 * Time(创建时间)： 13:33
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class ConfigSignatureServiceImplTest
{
    @Autowired
    private ConfigSignatureService configSignatureService;

    @Test
    void list()
    {
        System.out.println(configSignatureService.list());
    }
}