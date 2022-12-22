package mao.sms_manage.mapper;

import mao.sms_dao.mapper.SendLogMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_dao.mapper
 * Class(测试类名): SendLogMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/22
 * Time(创建时间)： 15:09
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */
@Transactional
@SpringBootTest
class SendLogMapperTest
{
    @Autowired
    private SendLogMapper sendLogMapper;

    @Test
    void queryAll()
    {
        System.out.println(sendLogMapper.selectList(null));
    }

    @Test
    void selectLogPage()
    {
    }

    @Test
    void trend()
    {
    }

    @Test
    void countPage()
    {
    }

    @Test
    void countForConfig()
    {
    }

    @Test
    void getMarketingCount()
    {
    }

    @Test
    void sendLogPage()
    {
    }
}