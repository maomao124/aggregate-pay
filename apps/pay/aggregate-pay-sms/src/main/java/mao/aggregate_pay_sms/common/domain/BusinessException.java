package mao.aggregate_pay_sms.common.domain;


/**
 * 业务异常
 */
public class BusinessException extends RuntimeException
{

    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 5565760508056698922L;

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
     * 业务异常
     *
     * @param arg0 arg0
     * @param arg1 __arg1
     * @param arg2 最长
     * @param arg3 长度
     */
    public BusinessException(String arg0, Throwable arg1, boolean arg2, boolean arg3)
    {
        super(arg0, arg1, arg2, arg3);
    }

    /**
     * 业务异常
     *
     * @param errorCode 错误代码
     * @param arg0      arg0
     * @param arg1      __arg1
     * @param arg2      最长
     * @param arg3      长度
     */
    public BusinessException(ErrorCode errorCode, String arg0, Throwable arg1, boolean arg2, boolean arg3)
    {
        super(arg0, arg1, arg2, arg3);
        this.errorCode = errorCode;
    }

    /**
     * 业务异常
     *
     * @param arg0 arg0
     * @param arg1 __arg1
     */
    public BusinessException(String arg0, Throwable arg1)
    {
        super(arg0, arg1);
    }

    /**
     * 业务异常
     *
     * @param errorCode 错误代码
     * @param arg0      arg0
     * @param arg1      __arg1
     */
    public BusinessException(ErrorCode errorCode, String arg0, Throwable arg1)
    {
        super(arg0, arg1);
        this.errorCode = errorCode;
    }

    /**
     * 业务异常
     *
     * @param arg0 arg0
     */
    public BusinessException(String arg0)
    {
        super(arg0);
    }

    /**
     * 业务异常
     *
     * @param errorCode 错误代码
     * @param arg0      arg0
     */
    public BusinessException(ErrorCode errorCode, String arg0)
    {
        super(arg0);
        this.errorCode = errorCode;
    }

    /**
     * 业务异常
     *
     * @param arg0 arg0
     */
    public BusinessException(Throwable arg0)
    {
        super(arg0);
    }

    /**
     * 业务异常
     *
     * @param errorCode 错误代码
     * @param arg0      arg0
     */
    public BusinessException(ErrorCode errorCode, Throwable arg0)
    {
        super(arg0);
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

    /**
     * 设置错误代码
     *
     * @param errorCode 错误代码
     */
    public void setErrorCode(ErrorCode errorCode)
    {
        this.errorCode = errorCode;
    }

}
