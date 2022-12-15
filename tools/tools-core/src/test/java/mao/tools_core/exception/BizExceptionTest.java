package mao.tools_core.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.exception
 * Class(测试类名): BizExceptionTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 22:47
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class BizExceptionTest
{

    /**
     * Wrap.
     */
    @Test
    void wrap()
    {
        try
        {
            BizException bizException = BizException.wrap(201, "测试");
            throw bizException;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}