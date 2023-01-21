package mao.aggregate_pay_uaa_service.config;

import mao.aggregate_pay_uaa_service.integration.RestOAuth2WebResponseExceptionTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.config
 * Class(类名): AuthorizationServerConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 13:50
 * Version(版本): 1.0
 * Description(描述)： 认证和授权配置
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter
{
    @Resource
    private TokenStore tokenStore;

    @Resource
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Resource
    private ClientDetailsService clientDetailsService;

    @Resource
    private AuthorizationCodeServices authorizationCodeServices;

    @Resource
    private AuthenticationManager authenticationManager;


    /**
     * 密码编码器
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }


    /**
     * 客户详细信息服务
     *
     * @param dataSource 数据源
     * @return {@link ClientDetailsService}
     */
    @Bean
    public ClientDetailsService clientDetailsService(@Qualifier("masterDruidDataSource") DataSource dataSource)
    {
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService) clientDetailsService).setPasswordEncoder(passwordEncoder());
        return clientDetailsService;
    }


    /**
     * jdbc模板
     *
     * @param dataSource 数据源
     * @return {@link JdbcTemplate}
     */
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("masterDruidDataSource") DataSource dataSource)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }


    /**
     * 配置
     *
     * @param clients 客户
     * @throws Exception 异常
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception
    {
        clients.withClientDetails(clientDetailsService);
    }


    /**
     * 配置令牌服务
     *
     * @return {@link AuthorizationServerTokenServices}
     */
    @Bean
    public AuthorizationServerTokenServices tokenService()
    {
        DefaultTokenServices service = new DefaultTokenServices();
        service.setClientDetailsService(clientDetailsService);
        service.setSupportRefreshToken(true);
        service.setTokenStore(tokenStore);

        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(/*tokenEnhancer(),*/ jwtAccessTokenConverter));
        service.setTokenEnhancer(tokenEnhancerChain);

        service.setAccessTokenValiditySeconds(7200); // 令牌默认有效期2小时
        service.setRefreshTokenValiditySeconds(259200); // 刷新令牌默认有效期3天
        return service;
    }


    /**
     * 配置令牌（token）的访问端点
     *
     * @param dataSource 数据源
     * @return {@link AuthorizationCodeServices}
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(@Qualifier("masterDruidDataSource") DataSource dataSource)
    {
        return new JdbcAuthorizationCodeServices(dataSource);
    }


    /**
     * 配置
     *
     * @param endpoints 端点
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
    {
        endpoints.authenticationManager(authenticationManager)
                .authorizationCodeServices(authorizationCodeServices)
                .tokenServices(tokenService())
                .pathMapping("/oauth/confirm_access", "/confirm_access")
                .pathMapping("/oauth/error", "/oauth_error")
                .allowedTokenEndpointRequestMethods(HttpMethod.POST)
                .exceptionTranslator(new RestOAuth2WebResponseExceptionTranslator());
    }


    /**
     * 配置令牌端点(Token Endpoint)的安全约束
     *
     * @param security 安全
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)
    {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients()//允许表单认证
        ;
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 AuthorizationServerConfig");
    }

}
