package mao.tools_redis_cache.service;

import mao.tools_redis_cache.entity.LockInfo;

import java.util.concurrent.TimeUnit;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_redis_cache.service
 * Interface(接口名): RedisLockService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/30
 * Time(创建时间)： 20:17
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface RedisLockService
{
    /**
     * 加锁
     *
     * @param key 锁的key
     * @return {@link LockInfo}
     */
    LockInfo lock(String key);

    /**
     * 加锁
     *
     * @param key             锁的key
     * @param maximumWaitTime 最大等待时间
     * @param timeUnit        时间单位
     * @return {@link LockInfo}
     */
    LockInfo lock(String key, long maximumWaitTime, TimeUnit timeUnit);


    /**
     * 加锁
     *
     * @param key                  锁的key
     * @param maximumWaitTime      获取锁的最大等待时间
     * @param automaticReleaseTime 锁自动释放时间
     * @param timeUnit             时间单位
     * @return {@link LockInfo}
     */
    LockInfo tryLock(String key, long maximumWaitTime, long automaticReleaseTime, TimeUnit timeUnit);


    /**
     * 释放锁
     *
     * @param lockInfo 锁信息
     */
    void unlock(LockInfo lockInfo);
}
