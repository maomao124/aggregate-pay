package mao.aggregate_pay_sms.sms;


public interface SmsService
{

    /**
     * 发送短信
     *
     * @param mobile  手机号
     * @param content 内容
     */
    default void send(String mobile, String content)
    {
    }

    /**
     * 发送短信验证码
     *
     * @param mobile        手机号
     * @param code          代码
     * @param effectiveTime 有效时间
     */
    void send(String mobile, String code, int effectiveTime);

    /**
     * 在控制台输出验证码，模拟发送短信
     *
     * @param mobile        手机号
     * @param code          代码
     * @param effectiveTime 有效时间
     */
    void sendOnConsole(String mobile, String code, int effectiveTime);

}
