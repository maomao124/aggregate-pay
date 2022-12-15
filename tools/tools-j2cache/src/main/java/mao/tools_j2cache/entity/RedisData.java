package mao.tools_j2cache.entity;

import java.time.LocalDateTime;

/**
 * Project name(项目名称)：j2cache_spring_boot_starter_demo
 * Package(包名): mao.tools_j2cache.entity
 * Class(类名): RedisData
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/5
 * Time(创建时间)： 22:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class RedisData
{
    /**
     * 数据
     */
    private Object data;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    /**
     * Instantiates a new Redis data.
     */
    public RedisData()
    {

    }

    /**
     * Instantiates a new Redis data.
     *
     * @param data       the data
     * @param expireTime the expire time
     */
    public RedisData(Object data, LocalDateTime expireTime)
    {
        this.data = data;
        this.expireTime = expireTime;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public Object getData()
    {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(Object data)
    {
        this.data = data;
    }

    /**
     * Gets expire time.
     *
     * @return the expire time
     */
    public LocalDateTime getExpireTime()
    {
        return expireTime;
    }

    /**
     * Sets expire time.
     *
     * @param expireTime the expire time
     */
    public void setExpireTime(LocalDateTime expireTime)
    {
        this.expireTime = expireTime;
    }

    @Override
    public String toString()
    {
        return "RedisData{" + "data=" + data +
                ", expireTime=" + expireTime +
                '}';
    }
}
