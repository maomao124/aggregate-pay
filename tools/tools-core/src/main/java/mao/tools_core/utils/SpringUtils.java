package mao.tools_core.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

import java.util.Map;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_core.utils
 * Class(类名): SpringUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 21:38
 * Version(版本): 1.0
 * Description(描述)： 获取spring容器里面的bean
 */

public class SpringUtils
{
    private static ApplicationContext applicationContext;
    private static ApplicationContext parentApplicationContext;

    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext)
    {
        Assert.notNull(applicationContext, "SpringUtil injection ApplicationContext is null");
        SpringUtils.applicationContext = applicationContext;
        parentApplicationContext = applicationContext.getParent();
    }

    /**
     * 获取spring容器里面的bean
     *
     * @param name 名字
     * @return {@link Object}
     */
    public static Object getBean(String name)
    {
        Assert.hasText(name, "SpringUtil name is null or empty");
        try
        {
            return applicationContext.getBean(name);
        }
        catch (Exception e)
        {
            return parentApplicationContext.getBean(name);
        }
    }

    /**
     * 获取spring容器里面的bean
     *
     * @param name 名字
     * @param type 类型
     * @return {@link T}
     */
    public static <T> T getBean(String name, Class<T> type)
    {
        Assert.hasText(name, "SpringUtil name is null or empty");
        Assert.notNull(type, "SpringUtil type is null");
        try
        {
            return applicationContext.getBean(name, type);
        }
        catch (Exception e)
        {
            return parentApplicationContext.getBean(name, type);
        }
    }

    /**
     * 获取spring容器里面的bean
     *
     * @param type 类型
     * @return {@link T}
     */
    public static <T> T getBean(Class<T> type)
    {
        Assert.notNull(type, "SpringUtil type is null");
        try
        {
            return applicationContext.getBean(type);
        }
        catch (Exception e)
        {
            return parentApplicationContext.getBean(type);
        }
    }

    /**
     * 获取spring容器里面的bean
     *
     * @param type 类型
     * @return {@link Map}<{@link String}, {@link T}>
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> type)
    {
        Assert.notNull(type, "SpringUtil type is null");
        try
        {
            return applicationContext.getBeansOfType(type);
        }
        catch (Exception e)
        {
            return parentApplicationContext.getBeansOfType(type);
        }
    }
}
