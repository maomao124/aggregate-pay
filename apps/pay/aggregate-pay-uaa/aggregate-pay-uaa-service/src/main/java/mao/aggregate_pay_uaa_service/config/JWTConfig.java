package mao.aggregate_pay_uaa_service.config;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_uaa_service.integration.ClientDefaultAccessTokenConverter;
import mao.aggregate_pay_uaa_service.integration.UnifiedUserAuthenticationConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.config
 * Class(类名): JWTConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class JWTConfig
{
    @Value("${siging-key}")
    private String SIGNING_KEY;

    @Bean
    public TokenStore tokenStore()
    {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter()
    {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //对称秘钥，资源服务器使用该秘钥来解密
        converter.setSigningKey(SIGNING_KEY);
        ClientDefaultAccessTokenConverter accessTokenConverter = new ClientDefaultAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(new UnifiedUserAuthenticationConverter());
        converter.setAccessTokenConverter(accessTokenConverter);
        return converter;
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 JWTConfig");
    }
}
