package mao.sms_server.service.impl;

import mao.sms_entity.entity.TemplateEntity;
import mao.sms_server.service.TemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(测试类名): TemplateServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/1
 * Time(创建时间)： 13:53
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class TemplateServiceImplTest
{

    @Autowired
    private TemplateService templateService;

    @Test
    void getByCode()
    {
        TemplateEntity template = templateService.getByCode("DXMB_000000001");
        System.out.println(template);
    }

    @Test
    void getConfigCodeByCode()
    {
        String configCodeByCode = templateService.getConfigCodeByCode("12", "3");
        System.out.println(configCodeByCode);
    }
}