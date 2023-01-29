package mao.aggregate_pay_transaction_service.handler;

import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.handler
 * Class(类名): AssertResult
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/29
 * Time(创建时间)： 14:28
 * Version(版本): 1.0
 * Description(描述)： 断言远程调用结果
 */

public class AssertResult
{
    /**
     * 处理结果
     *
     * @param data 数据
     * @return {@link T}
     */
    public static <T> T handler(R<T> data)
    {
        //如果远程调用结果为错误
        if (data.getIsError())
        {
            //抛出异常
            throw BizException.wrap(data.getCode(), data.getMsg());
        }
        //不是错误，返回数据
        return data.getData();
    }
}
