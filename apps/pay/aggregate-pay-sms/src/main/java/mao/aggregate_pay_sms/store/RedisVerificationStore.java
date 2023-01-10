package mao.aggregate_pay_sms.store;

import mao.aggregate_pay_sms.common.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisVerificationStore implements VerificationStore
{

    /**
     * 缓存
     */
    @Autowired
    private Cache cache;

    /**
     * 集
     *
     * @param key    关键
     * @param value  价值
     * @param expire 到期
     */
    @Override
    public void set(String key, String value, Integer expire)
    {
        cache.set(key, value, expire);
    }

    /**
     * 得到
     *
     * @param key 关键
     * @return {@link String}
     */
    @Override
    public String get(String key)
    {
        return cache.get(key);
    }
}
