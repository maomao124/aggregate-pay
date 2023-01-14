package mao.aggregate_pay_log.service.impl;

import mao.aggregate_pay_log.service.OptLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.service.impl
 * Class(测试类名): OptLogServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 15:39
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class OptLogServiceImplTest
{

    @Autowired
    private OptLogService optLogService;

    @Test
    void list()
    {
        System.out.println(optLogService.list());
    }
}
