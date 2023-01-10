package mao.aggregate_pay_sms.store;

/**
 * 验证信息存储 kv
 */
public interface VerificationStore
{
    /**
     * set
     *
     * @param key    关键
     * @param value  价值
     * @param expire 到期
     */
    void set(String key, String value, Integer expire);

    /**
     * 得到
     *
     * @param key 关键
     * @return {@link String}
     */
    String get(String key);


}
