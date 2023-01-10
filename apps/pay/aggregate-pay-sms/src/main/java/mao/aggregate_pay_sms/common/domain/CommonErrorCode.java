package mao.aggregate_pay_sms.common.domain;


public enum CommonErrorCode implements ErrorCode
{

    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 自定义
     */
    CUSTOM(999998, "自定义异常"),

    /**
     * 未知
     */
    UNKNOWN(999999, "未知错误");


    /**
     * 代码
     */
    private int code;

    /**
     * desc
     */
    private String desc;

    /**
     * 获取代码
     *
     * @return int
     */
    public int getCode()
    {
        return code;
    }

    /**
     * 得到desc
     *
     * @return {@link String}
     */
    public String getDesc()
    {
        return desc;
    }

    /**
     * 常见错误代码
     *
     * @param code 代码
     * @param desc desc
     */
    CommonErrorCode(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 设置错误代码
     *
     * @param code 代码
     * @return {@link CommonErrorCode}
     */
    public static CommonErrorCode setErrorCode(int code)
    {
        for (CommonErrorCode errorCode : CommonErrorCode.values())
        {
            if (errorCode.getCode() == code)
            {
                return errorCode;
            }
        }
        return null;
    }
}
