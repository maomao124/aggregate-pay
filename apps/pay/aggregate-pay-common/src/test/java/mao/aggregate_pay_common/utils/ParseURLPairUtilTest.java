package mao.aggregate_pay_common.utils;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(测试类名): ParseURLPairUtilTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:00
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class ParseURLPairUtilTest
{


    @SneakyThrows
    @Test
    void parseURLPair()
    {
        System.out.println(ParseURLPairUtil.parseURLPair(new Object()));
    }

    @SneakyThrows
    @Test
    void parseURLPair2()
    {
        List<String> list = new ArrayList<>();
        System.out.println(ParseURLPairUtil.parseURLPair(list));
    }
}
