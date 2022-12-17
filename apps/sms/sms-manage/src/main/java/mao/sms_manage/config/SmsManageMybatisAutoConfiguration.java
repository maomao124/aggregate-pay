package mao.sms_manage.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.datasource.BaseMybatisConfiguration;
import mao.tools_databases.properties.DatabaseProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.config
 * Class(类名): SmsManageMybatisAutoConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 20:53
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Slf4j
@Configuration
public class SmsManageMybatisAutoConfiguration extends BaseMybatisConfiguration
{
    public SmsManageMybatisAutoConfiguration(@Autowired DatabaseProperties databaseProperties)
    {
        super(databaseProperties);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SmsManageMybatisAutoConfiguration");
    }
}
