package mao.aggregate_pay_gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_gateway.config
 * Class(类名): ResourceServerConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 22:23
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Configuration
public class ResourceServerConfig
{
    /**
     * 资源id
     */
    public static final String RESOURCE_ID = "aggregate-pay-resource";

    private final AuthenticationEntryPoint restOAuth2AuthExceptionEntryPoint = new RestOAuth2AuthExceptionEntryPoint();
    private final RestAccessDeniedHandler restAccessDeniedHandler = new RestAccessDeniedHandler();

    /**
     * 统一认证中心 资源拦截
     */
    @Configuration
    @EnableResourceServer
    public class UAAServerConfig extends ResourceServerConfigurerAdapter
    {
        @Resource
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources)
        {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception
        {

            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/uaa/druid/**").denyAll()
                    .antMatchers("/uaa/**").permitAll();
        }

    }


    /**
     * 运营平台
     */
    @Configuration
    @EnableResourceServer
    public class OperationServerConfig extends ResourceServerConfigurerAdapter
    {

        @Resource
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources)
        {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
            resources.authenticationEntryPoint(restOAuth2AuthExceptionEntryPoint).accessDeniedHandler(restAccessDeniedHandler);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception
        {

            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/operation/swagger-ui.html").denyAll()
                    .antMatchers("/operation/doc.html").denyAll()
                    .antMatchers("/operation/doc.html/**").denyAll()
                    .antMatchers("/operation/webjars/**").denyAll()
                    .antMatchers("/operation/druid/**").denyAll()
                    .antMatchers("/operation/m/**").access("#oauth2.hasScope('read') and #oauth2.clientHasRole('ROLE_OPERATION')")
                    .antMatchers("/operation/**").permitAll();

        }

    }


    /**
     * 商户平台
     */
    @Configuration
    @EnableResourceServer
    public class MerchantServerConfig extends ResourceServerConfigurerAdapter
    {

        @Resource
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources)
        {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
            resources.authenticationEntryPoint(restOAuth2AuthExceptionEntryPoint).accessDeniedHandler(restAccessDeniedHandler);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception
        {

            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/merchant/druid/**").denyAll()
                    .antMatchers("/merchant/my/**").access("#oauth2.hasScope('read') and #oauth2.clientHasRole('ROLE_MERCHANT')")
                    .antMatchers("/merchant/swagger-ui.html").permitAll()
                    .antMatchers("/merchant/doc.html").permitAll()
                    .antMatchers("/merchant/doc.html/**").permitAll()
                    .antMatchers("/merchant/webjars/**").permitAll()
                    .antMatchers("/merchant/**").permitAll();

        }

    }


    /**
     * 门户网站
     */
    @Configuration
    @EnableResourceServer
    public class PortalServerConfig extends ResourceServerConfigurerAdapter
    {

        @Resource
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources)
        {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
            resources.authenticationEntryPoint(restOAuth2AuthExceptionEntryPoint).accessDeniedHandler(restAccessDeniedHandler);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception
        {

            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/portal/swagger-ui.html").denyAll()
                    .antMatchers("/portal/webjars/**").denyAll()
                    .antMatchers("/portal/druid/**").denyAll()
                    .antMatchers("/portal/doc.html").denyAll()
                    .antMatchers("/portal/doc.html/**").denyAll()
                    .antMatchers("/portal/m/**").access("#oauth2.hasScope('read') and #oauth2.clientHasRole('ROLE_PORTAL')")
                    .antMatchers("/portal/**").permitAll();

        }

    }


    /**
     * 开放API
     */
    @Configuration
    @EnableResourceServer
    public class APIServerConfig extends ResourceServerConfigurerAdapter
    {

        @Resource
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources)
        {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
            resources.authenticationEntryPoint(restOAuth2AuthExceptionEntryPoint).accessDeniedHandler(restAccessDeniedHandler);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception
        {

            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/api/swagger-ui.html").denyAll()
                    .antMatchers("/api/doc.html").denyAll()
                    .antMatchers("/api/doc.html/**").denyAll()
                    .antMatchers("/api/webjars/**").denyAll()
                    .antMatchers("/api/druid/**").denyAll()
                    .antMatchers("/api/**").access("#oauth2.hasScope('read') and #oauth2.clientHasRole('ROLE_API')");
        }

    }


    /**
     * 第三方支付代理服务
     */
    @Configuration
    @EnableResourceServer
    public class PaymentAgentReceiverServerConfig extends ResourceServerConfigurerAdapter
    {

        @Resource
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources)
        {
            resources.tokenStore(tokenStore).resourceId(RESOURCE_ID).stateless(true);
            resources.authenticationEntryPoint(restOAuth2AuthExceptionEntryPoint).accessDeniedHandler(restAccessDeniedHandler);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception
        {

            http.sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/api/swagger-ui.html").denyAll()
                    .antMatchers("/api/doc.html").denyAll()
                    .antMatchers("/api/doc.html/**").denyAll()
                    .antMatchers("/api/webjars/**").denyAll()
                    .antMatchers("/api/druid/**").denyAll()
                    .antMatchers("/payment-receiver/**").permitAll();

        }

    }
}
