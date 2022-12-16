package mao.sms_entity.exception;


import mao.tools_core.exception.BaseExceptionCode;
import mao.tools_core.exception.BaseUncheckedException;


/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.exception
 * Class(类名): SmsException
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/16
 * Time(创建时间)： 21:43
 * Version(版本): 1.0
 * Description(描述)： 短信业务异常
 */

public class SmsException extends BaseUncheckedException
{
    public SmsException(String message)
    {
        super(-1, message);
    }

    public SmsException(int code, String message)
    {
        super(code, message);
    }

    public SmsException(int code, String message, Object... args)
    {
        super(code, message, args);
    }

    /**
     * 实例化异常
     *
     * @param code    自定义异常编码
     * @param message 自定义异常消息
     * @param args    已定义异常参数
     * @return {@link SmsException}
     */
    public static SmsException wrap(int code, String message, Object... args)
    {
        return new SmsException(code, message, args);
    }

    public static SmsException wrap(String message, Object... args)
    {
        return new SmsException(-1, message, args);
    }

    public static SmsException validFail(String message, Object... args)
    {
        return new SmsException(-9, message, args);
    }

    public static SmsException wrap(BaseExceptionCode ex)
    {
        return new SmsException(ex.getCode(), ex.getMsg());
    }

    @Override
    public String toString()
    {
        return "SmsException [message=" + message + ", code=" + code + "]";
    }
}
