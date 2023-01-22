package mao.aggregate_pay_gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_gateway.config
 * Class(类名): SecurityConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 22:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */


@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .and().csrf().disable();

    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SecurityConfig");
    }
}
