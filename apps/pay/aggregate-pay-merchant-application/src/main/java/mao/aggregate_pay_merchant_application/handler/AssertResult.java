package mao.aggregate_pay_merchant_application.handler;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_common.domain.ErrorCode;
import mao.tools_core.base.R;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.handler
 * Class(类名): AssertResult
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 22:32
 * Version(版本): 1.0
 * Description(描述)： 断言远程调用的结果
 */

@Slf4j
public class AssertResult
{
    public static void handler(R<?> r)
    {
        //如果响应结果为失败
        if (r.getIsError())
        {
            //抛出业务异常
            ErrorCode errorCode = new ErrorCode()
            {
                @Override
                public int getCode()
                {
                    return r.getCode();
                }

                @Override
                public String getDesc()
                {
                    return r.getMsg();
                }
            };
            throw new BusinessException(errorCode);
        }
    }
}
