package mao.sms_api.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.datasource.BaseMybatisConfiguration;
import mao.tools_databases.properties.DatabaseProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.config
 * Class(类名): SmsApiMybatisAutoConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:13
 * Version(版本): 1.0
 * Description(描述)： mybatis配置
 */

@Slf4j
@Configuration
public class SmsApiMybatisAutoConfiguration extends BaseMybatisConfiguration
{

    public SmsApiMybatisAutoConfiguration(DatabaseProperties databaseProperties)
    {
        super(databaseProperties);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SmsApiMybatisAutoConfiguration 配置");
    }
}
