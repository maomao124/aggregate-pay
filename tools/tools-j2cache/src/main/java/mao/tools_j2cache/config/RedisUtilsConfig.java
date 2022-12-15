package mao.tools_j2cache.config;

import mao.tools_j2cache.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：j2cache_spring_boot_starter_demo
 * Package(包名): mao.tools_j2cache.config
 * Class(类名): RedisUtilsConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/5
 * Time(创建时间)： 23:30
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Configuration
@ConditionalOnClass(RedisUtils.class)
@Import(RedisUtils.class)
public class RedisUtilsConfig
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(RedisUtilsConfig.class);

    @PostConstruct
    public void init()
    {
        log.info("初始化 RedisUtilsConfig");
    }
}
