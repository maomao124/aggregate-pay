package mao.aggregate_pay_sms.common.cache;

import java.util.Set;

public interface Cache
{

    /**
     * 列出所有的key
     *
     * @return {@link Set}<{@link String}>
     */
    Set<String> getKeys();


    /**
     * 得到钥匙
     *
     * @param pattern 模式
     * @return {@link Set}<{@link String}>
     */
    Set<String> getKeys(String pattern);

    /**
     * 检查给定key是否存在
     *
     * @param key 关键
     * @return {@link Boolean}
     */
    Boolean exists(String key);


    /**
     * 移除给定的一个或多个key。如果key不存在，则忽略该命令。
     *
     * @param key 关键
     */
    void del(String key);


    /**
     * 简单的字符串设置
     *
     * @param key   关键
     * @param value 价值
     */
    void set(String key, String value);

    /**
     * @param key        关键
     * @param value      价值
     * @param expiration 过期
     */
    void set(String key, String value, Integer expiration);

    /**
     * 返回key所关联的字符串值
     *
     * @param key 关键
     * @return {@link String}
     */
    String get(String key);


    /**
     * key seconds 为给定key设置生存时间。当key过期时，它会被自动删除。
     *
     * @param key    关键
     * @param expire 到期
     */
    void expire(String key, int expire);


    /**
     * 如果key已经存在并且是一个字符串，APPEND命令将value追加到key原来的值之后。
     *
     * @param key   关键
     * @param value 价值
     */
    void append(String key, String value);


    /**
     * 获取旧值返回新值，不存在返回nil
     *
     * @param key      关键
     * @param newValue 新值
     * @return 旧值
     */
    String getset(String key, String newValue);

    /**
     * 分布锁
     *
     * @param key   关键
     * @param value 价值
     * @return boolean
     */
    boolean setnx(String key, String value);


    /**
     * 计数器
     *
     * @param key   关键
     * @param delta δ
     * @return {@link Long}
     */
    Long incrBy(String key, Long delta);


}
