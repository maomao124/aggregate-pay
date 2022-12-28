package mao.sms_server.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.sms_server.entity.LockInfo;
import mao.sms_server.service.RedisLockService;
import mao.tools_j2cache.utils.RedisUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(类名): RedisLockServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/28
 * Time(创建时间)： 19:50
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class RedisLockServiceImpl implements RedisLockService
{

    @Resource
    private RedissonClient redissonClient;


    @Override
    public LockInfo lock(String key, long maximumWaitTime, TimeUnit timeUnit)
    {
        // 获取锁（可重入），指定锁的名称
        RLock lock = redissonClient.getLock(key);
        try
        {
            // 尝试获取锁，参数分别是：获取锁的最大等待时间（期间会重试），锁自动释放时间，时间单位
            LockInfo lockInfo = new LockInfo();
            lockInfo.setLock(lock);
            lock.lock(maximumWaitTime, timeUnit);
            lockInfo.setSuccess(true);
            //log.debug("尝试获取分布式锁：" + lockInfo.isSuccess());
            return lockInfo;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            LockInfo lockInfo = new LockInfo();
            lockInfo.setLock(lock);
            lockInfo.setSuccess(false);
            return lockInfo;
        }
    }

    @Override
    public LockInfo tryLock(String key, long maximumWaitTime, long automaticReleaseTime, TimeUnit timeUnit)
    {
        // 获取锁（可重入），指定锁的名称
        RLock lock = redissonClient.getLock(key);
        try
        {
            // 尝试获取锁，参数分别是：获取锁的最大等待时间（期间会重试），锁自动释放时间，时间单位
            LockInfo lockInfo = new LockInfo();
            lockInfo.setLock(lock);
            lockInfo.setSuccess(lock.tryLock(maximumWaitTime, automaticReleaseTime, timeUnit));
            //log.debug("尝试获取分布式锁：" + lockInfo.isSuccess());
            return lockInfo;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            LockInfo lockInfo = new LockInfo();
            lockInfo.setLock(lock);
            lockInfo.setSuccess(false);
            return lockInfo;
        }
    }

    @Override
    public void unlock(LockInfo lockInfo)
    {
        if (lockInfo.getLock().isHeldByCurrentThread())
        {
            //log.debug("尝试释放分布式锁");
            lockInfo.getLock().unlock();
        }
    }
}
