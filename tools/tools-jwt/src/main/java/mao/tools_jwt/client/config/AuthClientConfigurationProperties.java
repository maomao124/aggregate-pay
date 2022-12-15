package mao.tools_jwt.client.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import static mao.tools_jwt.client.config.AuthClientConfigurationProperties.PREFIX;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.client.config
 * Class(类名): AuthClientConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 12:42
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@ConfigurationProperties(prefix = PREFIX)
public class AuthClientConfigurationProperties
{
    public static final String PREFIX = "authentication";

    private TokenInfo user;

    public AuthClientConfigurationProperties()
    {

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
         * 请求头名称
         */
        private String headerName;
        /**
         * 解密 网关使用
         */
        private String pubKey;

        public TokenInfo()
        {

        }

        public TokenInfo(String headerName, String pubKey)
        {
            this.headerName = headerName;
            this.pubKey = pubKey;
        }

        public String getHeaderName()
        {
            return headerName;
        }

        public void setHeaderName(String headerName)
        {
            this.headerName = headerName;
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
