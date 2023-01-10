package mao.aggregate_pay_sms.config;


import mao.aggregate_pay_sms.common.cache.Cache;
import mao.aggregate_pay_sms.common.cache.RedisCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;


@Configuration
public class RedisConfig
{

	/**
	 * 缓存
	 *
	 * @param redisTemplate 复述,模板
	 * @return {@link Cache}
	 */
	@Bean
    public Cache cache(StringRedisTemplate redisTemplate)
    {
        return new RedisCache(redisTemplate);
    }


}
