package mao.aggregate_pay_merchant_application.feign.log;

import mao.aggregate_pay_entity.entity.OptLog;
import mao.tools_core.base.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.feign.log
 * Class(测试类名): OptLogFeignClientTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 15:45
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class OptLogFeignClientTest
{
    @Autowired
    private OptLogFeignClient optLogFeignClient;

    @Test
    void save()
    {
    }

    @Test
    void page()
    {
    }

    @Test
    void testPage()
    {
    }

    @Test
    void page2()
    {
    }

    @Test
    void get()
    {
        R<OptLog> optLogR = optLogFeignClient.get(0L);
        System.out.println(optLogR.getData());
    }
}
