package mao.tools_redis_cache.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_redis_cache.service.RedisLockService;
import mao.tools_redis_cache.service.impl.RedisLockServiceImpl;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_redis_cache.config
 * Class(类名): RedisLockServiceConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/30
 * Time(创建时间)： 20:28
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Slf4j
@Configuration
@ConditionalOnMissingBean(RedisLockService.class)
@ConditionalOnClass(RedisLockService.class)
public class RedisLockServiceConfig
{
    @Bean
    public RedisLockService redisLockService(@Autowired RedissonClient redissonClient)
    {
        return new RedisLockServiceImpl(redissonClient);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 RedisLockServiceConfig");
    }
}
