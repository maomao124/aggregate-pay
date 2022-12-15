package mao.tools_j2cache.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import mao.tools_j2cache.entity.RedisData;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;


import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


/**
 * Project name(项目名称)：j2cache_spring_boot_starter_demo
 * Package(包名): mao.tools_j2cache.utils
 * Class(类名): RedisUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/5
 * Time(创建时间)： 22:25
 * Version(版本): 1.0
 * Description(描述)： 缓存工具类
 */


public class RedisUtils
{

    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedissonClient redissonClient;

    //线程池
    private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);

    /**
     * 向redis里添加数据
     *
     * @param redisKey   redis的key
     * @param value      数据
     * @param expireTime 过期时间
     * @param timeUnit   时间单位
     */
    public void set(String redisKey, Object value, Long expireTime, TimeUnit timeUnit)
    {
        stringRedisTemplate.opsForValue().set(redisKey, JSONUtil.toJsonStr(value), expireTime, timeUnit);
    }


    /**
     * 向redis里添加数据 设置逻辑过期
     *
     * @param redisKey   redis的key
     * @param value      数据
     * @param expireTime 过期时间
     * @param timeUnit   时间单位
     */
    public void setWithLogicalExpire(String redisKey, Object value, Long expireTime, TimeUnit timeUnit)
    {
        RedisData redisData = new RedisData();
        //添加数据
        redisData.setData(value);
        //设置过期时间
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(timeUnit.toSeconds(expireTime)));
        //放入redis
        stringRedisTemplate.opsForValue().set(redisKey, JSONUtil.toJsonStr(redisData));
    }


    /**
     * 查询数据，有缓存，解决缓存穿透问题，未解决缓存雪崩问题
     *
     * @param <R>        返回值的类型
     * @param <ID>       id的类型
     * @param keyPrefix  redisKey的前缀
     * @param id         id
     * @param type       返回值的类型
     * @param dbFallback 查询数据库的函数
     * @param expireTime 过期时间
     * @param timeUnit   时间单位
     * @return 泛型R r
     */
    public <R, ID> R queryWithPassThrough(String keyPrefix, ID id, Class<R> type,
                                          Function<ID, R> dbFallback, Long expireTime, TimeUnit timeUnit)
    {
        //获得前缀
        String redisKey = keyPrefix + id;
        //查询redis
        String json = stringRedisTemplate.opsForValue().get(redisKey);
        //判断是否为空
        if (StrUtil.isNotBlank(json))
        {
            //不为空，返回
            return JSONUtil.toBean(json, type);
        }
        //判断是否为空串
        if (json != null)
        {
            //空串
            return null;
        }
        //null
        //查数据库
        R r = dbFallback.apply(id);
        //判断
        if (r == null)
        {
            //数据库也为空，缓存空值
            this.set(redisKey, "", expireTime, timeUnit);
            return null;
        }
        //数据库存在，写入redis
        this.set(redisKey, r, expireTime, timeUnit);
        //返回
        return r;
    }

    /**
     * 查询数据，有缓存，解决缓存穿透问题，解决缓存雪崩问题
     *
     * @param <R>                            返回值的类型
     * @param <ID>                           id的类型
     * @param keyPrefix                      redisKey的前缀
     * @param id                             id
     * @param type                           返回值的类型
     * @param dbFallback                     查询数据库的函数
     * @param expireTime                     过期时间
     * @param timeUnit                       时间单位
     * @param maxTimeSecondsByCacheAvalanche this.set(redisKey, r,
     *                                       timeUnit.toSeconds(expireTime)+getIntRandom(0,maxTimeSecondsByCacheAvalanche),
     *                                       TimeUnit.SECONDS);
     * @return 泛型R r
     */
    public <R, ID> R queryWithPassThroughAndCacheAvalanche(String keyPrefix, ID id, Class<R> type,
                                                           Function<ID, R> dbFallback, Long expireTime, TimeUnit timeUnit,
                                                           Integer maxTimeSecondsByCacheAvalanche)
    {
        //获得前缀
        String redisKey = keyPrefix + id;
        //查询redis
        String json = stringRedisTemplate.opsForValue().get(redisKey);
        //判断是否为空
        if (StrUtil.isNotBlank(json))
        {
            //不为空，返回
            return JSONUtil.toBean(json, type);
        }
        //判断是否为空串
        if (json != null)
        {
            //空串
            return null;
        }
        //null
        //查数据库
        R r = dbFallback.apply(id);
        //判断
        if (r == null)
        {
            //数据库也为空，缓存空值
            this.set(redisKey, "",
                    timeUnit.toSeconds(expireTime) + getIntRandom(0, maxTimeSecondsByCacheAvalanche),
                    TimeUnit.SECONDS);
            return null;
        }
        //数据库存在，写入redis
        this.set(redisKey, r,
                timeUnit.toSeconds(expireTime) + getIntRandom(0, maxTimeSecondsByCacheAvalanche),
                TimeUnit.SECONDS);
        //返回
        return r;
    }

    /**
     * 查询数据，解决缓存穿透，互斥锁方法解决缓存击穿，解决缓存雪崩
     *
     * @param <R>                            返回值的类型
     * @param <ID>                           id的类型
     * @param keyPrefix                      redisKey的前缀
     * @param lockKeyPrefix                  锁的前缀
     * @param id                             id
     * @param type                           返回值的类型
     * @param dbFallback                     查询数据库的函数
     * @param expireTime                     过期时间
     * @param timeUnit                       时间单位
     * @param maxTimeSecondsByCacheAvalanche this.set(redisKey, r,
     *                                       timeUnit.toSeconds(expireTime)+getIntRandom(0,maxTimeSecondsByCacheAvalanche),                                       TimeUnit.SECONDS);
     * @return 泛型R r
     */
    public <R, ID> R query(String keyPrefix, String lockKeyPrefix, ID id, Class<R> type,
                           Function<ID, R> dbFallback, Long expireTime, TimeUnit timeUnit,
                           Integer maxTimeSecondsByCacheAvalanche)
    {
        //获取redisKey
        String redisKey = keyPrefix + id;
        //log.debug("查询：" + redisKey);
        //从redis中查询信息，根据id
        String json = stringRedisTemplate.opsForValue().get(redisKey);
        //判断取出的数据是否为空
        if (StrUtil.isNotBlank(json))
        {
            //log.debug(redisKey + " 缓存命中");
            //不是空，redis里有，返回
            return JSONUtil.toBean(json, type);
        }
        //是空串，不是null，返回
        if (json != null)
        {
            return null;
        }
        //锁的key
        String lockKey = lockKeyPrefix + id;

        R r = null;
        LockInfo lockInfo = null;
        try
        {
            //log.debug(redisKey + " 缓存未命中，尝试获取锁");
            //获取互斥锁
            lockInfo = tryLock(lockKey);
            //判断锁是否获取成功
            if (!lockInfo.isSuccess())
            {
                //没有获取到锁
                //200毫秒后再次获取
                Thread.sleep(200);
                //递归调用
                return query(keyPrefix, lockKeyPrefix, id, type, dbFallback,
                        expireTime, timeUnit, maxTimeSecondsByCacheAvalanche);
            }
            //得到了锁
            //从redis中查询信息，根据id
            json = stringRedisTemplate.opsForValue().get(redisKey);
            //判断取出的数据是否为空
            if (StrUtil.isNotBlank(json))
            {
                //log.debug(redisKey + " 获取分布式锁后，缓存命中");
                //不是空，redis里有，返回
                return JSONUtil.toBean(json, type);
            }

            //null，查数据库
            log.debug(redisKey + " 获取分布式锁后，缓存未命中，查询数据库");
            r = dbFallback.apply(id);
            //判断数据库里的信息是否为空
            if (r == null)
            {
                //数据库也为空，缓存空值
                this.set(redisKey, "",
                        timeUnit.toSeconds(expireTime) + getIntRandom(0, maxTimeSecondsByCacheAvalanche),
                        TimeUnit.SECONDS);
                return null;
            }
            //存在，回写到redis里，设置随机的过期时间
            this.set(redisKey, r,
                    timeUnit.toSeconds(expireTime) + getIntRandom(0, maxTimeSecondsByCacheAvalanche),
                    TimeUnit.SECONDS);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            //释放锁
            if (lockInfo != null)
            {
                this.unlock(lockInfo);
            }
        }
        //返回数据
        return r;
    }

    /**
     * 更新数据
     *
     * @param <T>        要更新的对象的泛型
     * @param <ID>       主键的类型
     * @param id         要更新的主键
     * @param data       要更新的对象
     * @param keyPrefix  redis的key前缀
     * @param dbFallback 更新数据库的函数，返回值要为Boolean类型
     * @return boolean boolean
     */
    public <T, ID> boolean update(ID id, T data, String keyPrefix, Function<T, Boolean> dbFallback)
    {
        //判断是否为空
        if (id == null)
        {
            return false;
        }
        //不为空
        //先更新数据库
        boolean b = dbFallback.apply(data);
        //更新失败，返回
        if (!b)
        {
            return false;
        }
        //更新没有失败
        //删除redis里的数据，下一次查询时自动添加进redis
        //redisKey
        String redisKey = keyPrefix + id;
        stringRedisTemplate.delete(redisKey);
        log.debug("更新：" + redisKey);
        //返回响应
        return true;
    }

    /**
     * Query with logical expire r.
     *
     * @param <R>           返回值的类型
     * @param <ID>          id的类型
     * @param keyPrefix     redisKey的前缀
     * @param lockKeyPrefix 锁的前缀
     * @param id            id
     * @param type          返回值的类型
     * @param dbFallback    查询数据库的函数
     * @param time          过期时间
     * @param timeUnit      时间单位
     * @return 泛型R r
     */
    public <R, ID> R queryWithLogicalExpire(String keyPrefix, String lockKeyPrefix, ID id, Class<R> type,
                                            Function<ID, R> dbFallback, Long time, TimeUnit timeUnit)
    {
        //获得前缀
        String redisKey = keyPrefix + id;
        //查询redis
        String json = stringRedisTemplate.opsForValue().get(redisKey);
        //判断是否为空
        if (StrUtil.isBlank(json))
        {
            //空，返回
            return null;
        }
        //不为空
        //json 反序列化为对象
        RedisData redisData = JSONUtil.toBean(json, RedisData.class);
        //获得过期时间
        LocalDateTime expireTime = redisData.getExpireTime();
        //获取数据
        R r = JSONUtil.toBean((JSONObject) redisData.getData(), type);
        //判断是否过期
        if (expireTime.isAfter(LocalDateTime.now()))
        {
            //未过期，返回
            return r;
        }
        //过期，缓存重建
        //获取互斥锁
        String lockKey = lockKeyPrefix + id;
        LockInfo lockInfo = tryLock(lockKey);
        if (lockInfo.isSuccess())
        {
            //获取锁成功
            // 开辟独立线程
            CACHE_REBUILD_EXECUTOR.submit(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        R r1 = dbFallback.apply(id);
                        setWithLogicalExpire(redisKey, r1, time, timeUnit);
                    }
                    catch (Exception e)
                    {
                        throw new RuntimeException(e);
                    }
                    finally
                    {
                        //释放锁
                        unlock(lockInfo);
                    }
                }
            });
        }
        //没有获取到锁，使用旧数据返回
        return r;
    }


    /**
     * 获取锁
     *
     * @param key redisKey
     * @return {@link LockInfo}
     */
    private LockInfo tryLock(String key)
    {
        // 获取锁（可重入），指定锁的名称
        RLock lock = redissonClient.getLock(key);
        try
        {
            // 尝试获取锁，参数分别是：获取锁的最大等待时间（期间会重试），锁自动释放时间，时间单位
            LockInfo lockInfo = new LockInfo();
            lockInfo.setLock(lock);
            lockInfo.setSuccess(lock.tryLock(1, 10, TimeUnit.SECONDS));
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

    /**
     * 释放锁
     *
     * @param lockInfo 锁信息
     */
    private void unlock(LockInfo lockInfo)
    {
        if (lockInfo.getLock().isHeldByCurrentThread())
        {
            //log.debug("尝试释放分布式锁");
            lockInfo.lock.unlock();
        }
    }


    /**
     * 获取一个随机数，区间包含min和max
     *
     * @param min 最小值
     * @param max 最大值
     * @return int 型的随机数
     */
    @SuppressWarnings("all")
    private int getIntRandom(int min, int max)
    {
        if (min > max)
        {
            min = max;
        }
        return min + (int) (Math.random() * (max - min + 1));
    }

    private static class LockInfo
    {
        /**
         * 获取锁是否成功
         */
        private boolean isSuccess;

        /**
         * 锁对象
         */
        private RLock lock;

        /**
         * Is success boolean.
         *
         * @return the boolean
         */
        public boolean isSuccess()
        {
            return isSuccess;
        }

        /**
         * Sets success.
         *
         * @param success the success
         */
        public void setSuccess(boolean success)
        {
            isSuccess = success;
        }

        /**
         * Gets lock.
         *
         * @return the lock
         */
        public RLock getLock()
        {
            return lock;
        }

        /**
         * Sets lock.
         *
         * @param lock the lock
         */
        public void setLock(RLock lock)
        {
            this.lock = lock;
        }
    }
}
