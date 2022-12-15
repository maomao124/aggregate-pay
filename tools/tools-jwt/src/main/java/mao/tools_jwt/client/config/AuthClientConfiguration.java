package mao.tools_jwt.client.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_jwt.client.utils.JwtTokenClientUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.client.config
 * Class(类名): AuthClientConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 12:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@EnableConfigurationProperties(AuthClientConfigurationProperties.class)
public class AuthClientConfiguration
{
    @Bean
    public JwtTokenClientUtils jwtTokenClientUtils(@Autowired AuthClientConfigurationProperties authClientConfigurationProperties)
    {
        return new JwtTokenClientUtils(authClientConfigurationProperties);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 AuthClientConfiguration");
    }
}
