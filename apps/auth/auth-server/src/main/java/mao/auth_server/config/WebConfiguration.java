package mao.auth_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_common.config.BaseConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.config
 * Class(类名): WebConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 12:44
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class WebConfiguration extends BaseConfig
{
    @PostConstruct
    public void init()
    {
        log.info("初始化 WebConfiguration");
    }
}
