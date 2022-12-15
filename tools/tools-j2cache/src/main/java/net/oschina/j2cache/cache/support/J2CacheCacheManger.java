package net.oschina.j2cache.cache.support;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import net.oschina.j2cache.CacheChannel;
import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;
import org.springframework.util.CollectionUtils;

import java.util.*;


/**
 * {@link Cache} implementation for J2Cache.
 */
public class J2CacheCacheManger extends AbstractTransactionSupportingCacheManager
{

    private boolean allowNullValues = true;

    /**
     * 缓存名称
     */
    private Collection<String> cacheNames;

    private boolean dynamic = true;

    private CacheChannel cacheChannel;

    public J2CacheCacheManger(CacheChannel cacheChannel)
    {
        this.cacheChannel = cacheChannel;
    }

    /**
     * 加载缓存
     *
     * @return {@link Collection}<{@link ?} {@link extends} {@link Cache}>
     */
    @Override
    protected Collection<? extends Cache> loadCaches()
    {
        Collection<Cache> caches = new LinkedHashSet<>(cacheNames.size());
        for (String name : cacheNames)
        {
            J2CacheCache cache = new J2CacheCache(name, cacheChannel, allowNullValues);
            caches.add(cache);
        }
        return caches;
    }


    /**
     * 是允许空值
     *
     * @return boolean
     */
    public boolean isAllowNullValues()
    {
        return allowNullValues;
    }

    /**
     * 设置允许空值
     *
     * @param allowNullValues 允许空值
     */
    public void setAllowNullValues(boolean allowNullValues)
    {
        this.allowNullValues = allowNullValues;
    }

    @Override
    protected Cache getMissingCache(String name)
    {
        return this.dynamic ? new J2CacheCache(name, cacheChannel, allowNullValues) : null;
    }


    /**
     * 设置缓存名称
     *
     * @param cacheNames 缓存名称
     */
    public void setCacheNames(Collection<String> cacheNames)
    {
        Set<String> newCacheNames = CollectionUtils.isEmpty(cacheNames) ? Collections.emptySet()
                : new HashSet<>(cacheNames);
        this.cacheNames = newCacheNames;
        this.dynamic = newCacheNames.isEmpty();
    }

}
