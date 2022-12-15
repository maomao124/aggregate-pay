package net.oschina.j2cache.cache.support.redis;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import net.oschina.j2cache.Cache;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheExpiredListener;
import net.oschina.j2cache.CacheObject;
import net.oschina.j2cache.CacheProvider;
import net.oschina.j2cache.NullCache;
import net.oschina.j2cache.cache.support.util.SpringUtil;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * spring redis缓存
 */
public class SpringRedisProvider implements CacheProvider
{

    /**
     * 缓存
     */
    protected ConcurrentHashMap<String, Cache> caches = new ConcurrentHashMap<>();
    private RedisTemplate<String, Serializable> redisTemplate;
    /**
     * 配置
     */
    private net.oschina.j2cache.autoconfigure.J2CacheConfig config;
    /**
     * 名称空间
     */
    private String namespace;
    /**
     * 存储
     */
    private String storage;

    @Override
    public String name()
    {
        return "redis";
    }

    @Override
    public int level()
    {
        return CacheObject.LEVEL_2;
    }

    @Override
    public Collection<CacheChannel.Region> regions()
    {
        return Collections.emptyList();
    }

    /**
     * 建立缓存
     *
     * @param region   地区
     * @param listener 侦听器
     * @return {@link Cache}
     */
    @Override
    public Cache buildCache(String region, CacheExpiredListener listener)
    {
        if (config.getL2CacheOpen() == false)
        {
            return new NullCache();
        }
        Cache cache = caches.get(region);
        if (cache == null)
        {
            synchronized (net.oschina.j2cache.cache.support.redis.SpringRedisProvider.class)
            {
                cache = caches.get(region);
                if (cache == null)
                {
                    if ("hash".equalsIgnoreCase(this.storage))
                    {
                        cache = new SpringRedisCache(this.namespace, region, redisTemplate);
                    }
                    else
                    {
                        cache = new SpringRedisGenericCache(this.namespace, region, redisTemplate);
                    }
                    caches.put(region, cache);
                }
            }
        }
        return cache;
    }

    @Override
    public Cache buildCache(String region, long timeToLiveInSeconds, CacheExpiredListener listener)
    {
        return buildCache(region, listener);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Properties props)
    {
        this.namespace = props.getProperty("namespace");
        this.storage = props.getProperty("storage");
        this.config = SpringUtil.getBean(net.oschina.j2cache.autoconfigure.J2CacheConfig.class);
        if (config.getL2CacheOpen() == false)
        {
            return;
        }
        this.redisTemplate = SpringUtil.getBean("j2CacheRedisTemplate", RedisTemplate.class);
    }

    @Override
    public void stop()
    {
        // 由spring控制
    }

}
