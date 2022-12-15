package net.oschina.j2cache.cache.support.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring 工具类
 */
public class SpringUtil implements ApplicationContextAware
{

    /**
     * 应用程序上下文
     */
    private static ApplicationContext applicationContext;

    /**
     * 获取applicationContext
     */
    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        if (net.oschina.j2cache.cache.support.util.SpringUtil.applicationContext == null)
        {
            net.oschina.j2cache.cache.support.util.SpringUtil.applicationContext = applicationContext;
        }
    }

    /**
     * 通过name获取 Bean.
     */
    public static Object getBean(String name)
    {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     */
    public static <T> T getBean(Class<T> clazz)
    {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     */
    public static <T> T getBean(String name, Class<T> clazz)
    {
        return getApplicationContext().getBean(name, clazz);
    }

}
