package mao.tools_jwt.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.server.config
 * Class(类名): AuthServerConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 12:55
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@ConfigurationProperties(prefix = AuthServerConfigurationProperties.PREFIX)
public class AuthServerConfigurationProperties
{
    public static final String PREFIX = "authentication";

    private TokenInfo user;

    public AuthServerConfigurationProperties()
    {

    }

    public AuthServerConfigurationProperties(TokenInfo user)
    {
        this.user = user;
    }

    public TokenInfo getUser()
    {
        return user;
    }

    public void setUser(TokenInfo user)
    {
        this.user = user;
    }

    public static class TokenInfo
    {
        /**
         * 过期时间
         */
        private Integer expire = 7200;
        /**
         * 加密 服务使用
         */
        private String priKey;
        /**
         * 解密
         */
        private String pubKey;

        public TokenInfo()
        {

        }

        public TokenInfo(Integer expire, String priKey, String pubKey)
        {
            this.expire = expire;
            this.priKey = priKey;
            this.pubKey = pubKey;
        }

        public Integer getExpire()
        {
            return expire;
        }

        public void setExpire(Integer expire)
        {
            this.expire = expire;
        }

        public String getPriKey()
        {
            return priKey;
        }

        public void setPriKey(String priKey)
        {
            this.priKey = priKey;
        }

        public String getPubKey()
        {
            return pubKey;
        }

        public void setPubKey(String pubKey)
        {
            this.pubKey = pubKey;
        }
    }
}
