package mao.sms_server.entity;

import org.redisson.api.RLock;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.entity
 * Class(类名): LockInfo
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/28
 * Time(创建时间)： 19:59
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
     */
    public LockInfo(boolean isSuccess, RLock lock)
    {
        this.isSuccess = isSuccess;
        this.lock = lock;
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

}
