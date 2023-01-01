package mao.sms_server.service.impl;

import mao.sms_entity.entity.ConfigEntity;
import mao.sms_server.service.ConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(测试类名): ConfigServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/1
 * Time(创建时间)： 13:16
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class ConfigServiceImplTest
{

    @Autowired
    private ConfigService configService;

    @Test
    void listForConnect()
    {
        List<ConfigEntity> configEntityList = configService.listForConnect();
        System.out.println(configEntityList);
    }

    @Test
    void listForNewConnect()
    {
        List<ConfigEntity> configEntityList = configService.listForNewConnect();
        System.out.println(configEntityList);
    }

    @Test
    void updateBatchById()
    {

    }
}