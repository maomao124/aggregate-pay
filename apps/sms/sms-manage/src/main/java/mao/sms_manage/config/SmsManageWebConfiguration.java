package mao.sms_manage.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_common.config.BaseConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.config
 * Class(类名): SmsManageWebConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 20:57
 * Version(版本): 1.0
 * Description(描述)： 基础配置类
 */

@Slf4j
@Configuration
public class SmsManageWebConfiguration extends BaseConfig
{
    @PostConstruct
    public void init()
    {
        log.info("初始化 SmsManageWebConfiguration 基础配置");
    }
}
