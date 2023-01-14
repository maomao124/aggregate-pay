package mao.aggregate_pay_transaction_service.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.mapper
 * Class(测试类名): PlatformChannelMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 22:11
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class PlatformChannelMapperTest
{

    @Autowired
    private PlatformChannelMapper platformChannelMapper;

    @Test
    void selectPayChannelByPlatformChannel()
    {
        System.out.println(platformChannelMapper.selectPayChannelByPlatformChannel("test"));
    }

    @Test
    void list()
    {
        System.out.println(platformChannelMapper.selectList(null));
    }
}
