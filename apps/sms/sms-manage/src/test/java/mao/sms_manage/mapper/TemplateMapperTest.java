package mao.sms_manage.mapper;

import mao.sms_dao.mapper.TemplateMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_dao.mapper
 * Class(测试类名): TemplateMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/22
 * Time(创建时间)： 15:10
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */
@Transactional
@SpringBootTest
class TemplateMapperTest
{
    @Autowired
    private TemplateMapper templateMapper;

    @Test
    void queryAll()
    {
        System.out.println(templateMapper.selectList(null));
    }

    @Test
    void custom()
    {
    }

    @Test
    void testCustom()
    {
    }
}