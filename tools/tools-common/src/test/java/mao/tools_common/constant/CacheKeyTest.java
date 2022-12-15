package mao.tools_common.constant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.constant
 * Class(测试类名): CacheKeyTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 14:51
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */
class CacheKeyTest
{

    /**
     * Build key.
     */
    @Test
    void buildKey()
    {
        System.out.println(CacheKey.buildKey("123", 456));
    }

    /**
     * Build key 2.
     */
    @Test
    void buildKey2()
    {
        System.out.println(CacheKey.buildKey("123", 456, "789"));
    }

    /**
     * Build key 3.
     */
    @Test
    void buildKey3()
    {
        System.out.println(CacheKey.buildKey(CacheKey.CAPTCHA, "123", 456));
    }


}