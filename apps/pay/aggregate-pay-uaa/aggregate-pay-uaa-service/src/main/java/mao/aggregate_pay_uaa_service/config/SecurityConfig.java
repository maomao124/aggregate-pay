package mao.aggregate_pay_uaa_service.config;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_uaa_service.feign.log.LoginLogFeignClient;
import mao.aggregate_pay_uaa_service.integration.IntegrationUserDetailsAuthenticationHandler;
import mao.aggregate_pay_uaa_service.integration.IntegrationUserDetailsAuthenticationProvider;
import mao.aggregate_pay_user_api.feign.AuthorizationFeignClient;
import mao.aggregate_pay_user_api.feign.AuthorizationFeignClientV2;
import mao.aggregate_pay_user_api.feign.TenantFeignClientV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.config
 * Class(类名): SecurityConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:20
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

    @Resource
    private TenantFeignClientV2 tenantFeignClient;

    @Resource
    private LoginLogFeignClient loginLogFeignClient;


    public SecurityConfig()
    {
    }

    /**
     * 集成用户身份验证处理器细节
     *
     * @return {@link IntegrationUserDetailsAuthenticationHandler}
     */
    @Bean
    public IntegrationUserDetailsAuthenticationHandler integrationUserDetailsAuthenticationHandler()
    {
        return new IntegrationUserDetailsAuthenticationHandler(tenantFeignClient, loginLogFeignClient);
    }

    /**
     * 集成用户身份验证提供者细节
     *
     * @return {@link IntegrationUserDetailsAuthenticationProvider}
     */
    @Bean
    public IntegrationUserDetailsAuthenticationProvider integrationUserDetailsAuthenticationProvider()
    {
        IntegrationUserDetailsAuthenticationProvider provider =
                new IntegrationUserDetailsAuthenticationProvider(integrationUserDetailsAuthenticationHandler());
        return provider;
    }


    /**
     * 配置
     *
     * @param auth 身份验证
     * @throws Exception 异常
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.authenticationProvider(integrationUserDetailsAuthenticationProvider());
    }


    /**
     * 身份验证管理器bean
     *
     * @return {@link AuthenticationManager}
     * @throws Exception 异常
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception
    {
        return super.authenticationManagerBean();
    }

    /**
     * 配置
     *
     * @param web 网络
     * @throws Exception 异常
     */
    @Override
    public void configure(WebSecurity web) throws Exception
    {
        web.ignoring().antMatchers("/public/**",
                "/webjars/**",
                "/v2/**",
                "/swagger**",
                "/static/**",
                "/resources/**",
                "/doc.html",
                "/doc.html/**",
                "/oauth/createClientDetails",
                "/oauth/getClientDetailsByClientId");
        //web.httpFirewall(new DefaultHttpFirewall());//StrictHttpFirewall 去除验url非法验证防火墙
    }

    /**
     * 配置
     *
     * @param http http
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/login*",
                        "/logout*",
                        "/druid",
                        "/druid/**",
                        "/doc.html",
                        "/doc.html/**")
                .permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .loginPage("/login") // 登录页面
                .loginProcessingUrl("/login.do") // 登录处理url
                .failureUrl("/login?authentication_error=1")
                .defaultSuccessUrl("/oauth/authorize")
                .usernameParameter("username")
                .passwordParameter("password")
                .and().logout()
                .logoutUrl("/logout.do")
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")
                .and().csrf().disable()
                .exceptionHandling()
                .accessDeniedPage("/login?authorization_error=2");

    }


    @PostConstruct
    public void init()
    {
        log.info("初始化 SecurityConfig");
    }

}
