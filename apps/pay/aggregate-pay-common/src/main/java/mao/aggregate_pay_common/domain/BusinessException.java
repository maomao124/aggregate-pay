package mao.aggregate_pay_common.domain;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.domain
 * Class(类名): BusinessException
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 14:41
 * Version(版本): 1.0
 * Description(描述)： 聚合支付系统业务异常
 */

public class BusinessException extends RuntimeException
{
    /**
     * 错误代码
     */
    private ErrorCode errorCode;

    /**
     * 业务异常
     *
     * @param errorCode 错误代码
     */
    public BusinessException(ErrorCode errorCode)
    {
        super();
        this.errorCode = errorCode;
    }

    /**
     * 业务异常
     */
    public BusinessException()
    {
        super();
    }

    /**
     * 设置错误代码
     *
     * @param errorCode 错误代码
     */
    public void setErrorCode(ErrorCode errorCode)
    {
        this.errorCode = errorCode;
    }

    /**
     * 得到错误代码
     *
     * @return {@link ErrorCode}
     */
    public ErrorCode getErrorCode()
    {
        return errorCode;
    }
}
