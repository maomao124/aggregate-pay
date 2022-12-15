package mao.tools_log.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog
{
    /**
     * 描述
     *
     * @return {String}
     */
    String value();

    /**
     * 记录执行参数
     *
     * @return boolean
     */
    boolean recordRequestParam() default true;

    /**
     * 记录返回参数
     *
     * @return boolean
     */
    boolean recordResponseParam() default true;
}
