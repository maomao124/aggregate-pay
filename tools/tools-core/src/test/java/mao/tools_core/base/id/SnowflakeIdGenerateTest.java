package mao.tools_core.base.id;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.base.id
 * Class(测试类名): SnowflakeIdGenerateTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 13:51
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class SnowflakeIdGenerateTest
{

    /**
     * Generate.
     */
    @Test
    void generate()
    {
        SnowflakeIdGenerate snowflakeIdGenerate = new SnowflakeIdGenerate(3);
        Long aLong = snowflakeIdGenerate.generate();
        System.out.println(aLong);
    }
}