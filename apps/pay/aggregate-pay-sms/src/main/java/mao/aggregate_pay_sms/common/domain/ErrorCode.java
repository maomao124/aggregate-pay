package mao.aggregate_pay_sms.common.domain;

public interface ErrorCode
{

    /**
     * 获取代码
     *
     * @return int
     */
    int getCode();

    /**
     * 得到desc
     *
     * @return {@link String}
     */
    String getDesc();

}
