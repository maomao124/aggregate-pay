package mao.aggregate_pay_log.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.datasource.BaseMybatisConfiguration;
import mao.tools_databases.properties.DatabaseProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_log.config
 * Class(类名): MybatisConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 14:24
 * Version(版本): 1.0
 * Description(描述)： Mybatis配置
 */

@Slf4j
@Configuration
public class MybatisConfig extends BaseMybatisConfiguration
{
    public MybatisConfig(DatabaseProperties databaseProperties)
    {
        super(databaseProperties);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 MybatisConfig");
    }
}
