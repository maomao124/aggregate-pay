package mao.aggregate_pay_merchant_application.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.utils
 * Class(类名): ApplicationContextHelper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/23
 * Time(创建时间)： 22:17
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Component
public class ApplicationContextHelper implements ApplicationContextAware
{
    private static ApplicationContext applicationContext;

    public ApplicationContextHelper()
    {

    }

    /**
     * 设置应用程序上下文
     *
     * @param applicationContext 应用程序上下文
     * @throws BeansException 豆子例外
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        ApplicationContextHelper.applicationContext = applicationContext;
    }

    /**
     * getBean
     *
     * @param beanName bean名字
     * @return {@link Object}
     */
    public static Object getBean(String beanName)
    {
        return applicationContext != null ? applicationContext.getBean(beanName) : null;
    }

    /**
     * getBean
     *
     * @param c Class字节码
     * @return {@link T}
     */
    public static <T> T getBean(Class<T> c)
    {
        return applicationContext != null ? applicationContext.getBean(c) : null;
    }
}
