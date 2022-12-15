package mao.tools_log.utils;

import mao.tools_log.annotation.SysLog;
import org.aspectj.lang.JoinPoint;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

/**
 * Project name(项目名称)：logback_spring_boot_starter_demo
 * Package(包名): mao.tools_log.utils
 * Class(类名): LogUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/31
 * Time(创建时间)： 22:16
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class LogUtil
{
    /***
     * 获取操作信息
     * @param point JoinPoint对象
     * @return String
     */
    public static String getControllerMethodDescription(JoinPoint point)
    {
        try
        {
            // 获取连接点目标类名
            String targetName = point.getTarget().getClass().getName();
            // 获取连接点签名的方法名
            String methodName = point.getSignature().getName();
            //获取连接点参数
            Object[] args = point.getArgs();
            //根据连接点类的名字获取指定类
            Class targetClass = Class.forName(targetName);
            //获取类里面的方法
            Method[] methods = targetClass.getMethods();
            String description = "";
            for (Method method : methods)
            {
                if (method.getName().equals(methodName))
                {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == args.length)
                    {
                        description = method.getAnnotation(SysLog.class).value();
                        break;
                    }
                }
            }
            return description;
        }
        catch (Exception e)
        {
            return "";
        }
    }


    /**
     * 获取堆栈信息
     *
     * @param throwable throwable
     * @return {@link String}
     */
    public static String getStackTrace(Throwable throwable)
    {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw))
        {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }
}
