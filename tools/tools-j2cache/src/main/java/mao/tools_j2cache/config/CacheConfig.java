package mao.tools_j2cache.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：j2cache_spring_boot_starter_demo
 * Package(包名): mao.tools_j2cache.config
 * Class(类名): CacheConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/5
 * Time(创建时间)： 21:22
 * Version(版本): 1.0
 * Description(描述)：  覆盖 SpringCache 相关配置
 */

public class CacheConfig extends CachingConfigurerSupport
{
    private static final Logger log = LoggerFactory.getLogger(CacheConfig.class);

    /**
     * 解决注解：Cacheable 没有指定key时，会将key生成为 ${value}:SimpleKey []
     * eg： @Cacheable(value = "pinda") ->  pinda:SimpleKey []
     *
     * @return {@link KeyGenerator}
     */
    @Override
    public KeyGenerator keyGenerator()
    {
        return (target, method, objects) ->
        {
            /*StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(StrPool.COLON);
            sb.append(method.getName());
            for (Object obj : objects) {
                if (obj != null) {
                    sb.append(StrPool.COLON);
                    sb.append(obj.toString());
                }
            }
            return sb.toString();*/
            return "";
        };
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 CacheConfig");
    }
}
