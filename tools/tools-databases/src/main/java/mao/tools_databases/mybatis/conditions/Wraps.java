package mao.tools_databases.mybatis.conditions;

import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.tools_databases.mybatis.conditions.update.LbuWrapper;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.conditions
 * Class(类名): Wraps
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:40
 * Version(版本): 1.0
 * Description(描述)： Wrappers 工具类， 该方法的主要目的是为了 缩短代码长度
 */

public class Wraps
{
    private Wraps()
    {
        // ignore
    }

    /**
     * 获取 HyLambdaQueryWrapper&lt;T&gt;
     *
     * @param <T> 实体类泛型
     * @return LambdaQueryWrapper&lt;T&gt;
     */
    public static <T> LbqWrapper<T> lbQ()
    {
        return new LbqWrapper<>();
    }

    /**
     * 获取 HyLambdaQueryWrapper&lt;T&gt;
     *
     * @param entity 实体类
     * @param <T>    实体类泛型
     * @return LambdaQueryWrapper&lt;T&gt;
     */
    public static <T> LbqWrapper<T> lbQ(T entity)
    {
        return new LbqWrapper<>(entity);
    }

    /**
     * 获取 HyLambdaQueryWrapper&lt;T&gt;
     *
     * @param <T> 实体类泛型
     * @return LambdaUpdateWrapper&lt;T&gt;
     */
    public static <T> LbuWrapper<T> lbU()
    {
        return new LbuWrapper<>();
    }

    /**
     * 获取 HyLambdaQueryWrapper&lt;T&gt;
     *
     * @param entity 实体类
     * @param <T>    实体类泛型
     * @return LambdaUpdateWrapper&lt;T&gt;
     */
    public static <T> LbuWrapper<T> lbU(T entity)
    {
        return new LbuWrapper<>(entity);
    }
}
