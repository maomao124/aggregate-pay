package mao.aggregate_pay_uaa_service.config;

import lombok.extern.slf4j.Slf4j;
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

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Project name(????????????)???aggregate-pay
 * Package(??????): mao.aggregate_pay_uaa_service.config
 * Class(??????): AuthorizationServerConfig
 * Author(?????????: mao
 * Author QQ???1296193245
 * GitHub???https://github.com/maomao124/
 * Date(????????????)??? 2023/1/18
 * Time(????????????)??? 13:50
 * Version(??????): 1.0
 * Description(??????)??? ?????????????????????
 */

@Slf4j
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
     * ???????????????
     *
     * @return {@link PasswordEncoder}
     */
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }


    /**
     * ????????????????????????
     *
     * @param dataSource ?????????
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
     * jdbc??????
     *
     * @param dataSource ?????????
     * @return {@link JdbcTemplate}
     */
    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("masterDruidDataSource") DataSource dataSource)
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }


    /**
     * ??????
     *
     * @param clients ??????
     * @throws Exception ??????
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception
    {
        clients.withClientDetails(clientDetailsService);
    }


    /**
     * ??????????????????
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

        service.setAccessTokenValiditySeconds(7200); // ?????????????????????2??????
        service.setRefreshTokenValiditySeconds(259200); // ???????????????????????????3???
        return service;
    }


    /**
     * ???????????????token??????????????????
     *
     * @param dataSource ?????????
     * @return {@link AuthorizationCodeServices}
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices(@Qualifier("masterDruidDataSource") DataSource dataSource)
    {
        return new JdbcAuthorizationCodeServices(dataSource);
    }


    /**
     * ??????
     *
     * @param endpoints ??????
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
     * ??????????????????(Token Endpoint)???????????????
     *
     * @param security ??????
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security)
    {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients()//??????????????????
        ;
    }

    @PostConstruct
    public void init()
    {
        log.info("????????? AuthorizationServerConfig");
    }

}
