package mao.tools_redis_cache.entity;

import org.redisson.api.RLock;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_redis_cache.entity
 * Class(类名): LockInfo
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/30
 * Time(创建时间)： 20:14
 * Version(版本): 1.0
 * Description(描述)： 无
 */


public class LockInfo
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
     * 锁的key
     */
    private String key;


    /**
     * Instantiates a new Lock info.
     */
    public LockInfo()
    {

    }

    /**
     * Instantiates a new Lock info.
     *
     * @param isSuccess the is success
     * @param lock      the lock
     * @param key       the key
     */
    public LockInfo(boolean isSuccess, RLock lock, String key)
    {
        this.isSuccess = isSuccess;
        this.lock = lock;
        this.key = key;
    }

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

    /**
     * Gets key.
     *
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /**
     * Sets key.
     *
     * @param key the key
     */
    public void setKey(String key)
    {
        this.key = key;
    }
}
