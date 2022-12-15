package mao.tools_jwt.server.utils;

import mao.tools_core.exception.BizException;
import mao.tools_jwt.entity.JwtUserInfo;
import mao.tools_jwt.entity.Token;
import mao.tools_jwt.server.config.AuthServerConfigurationProperties;
import mao.tools_jwt.utils.JwtHelper;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.server.utils
 * Class(类名): JwtTokenServerUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 12:58
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class JwtTokenServerUtils
{
    /**
     * 认证服务端使用，如 authority-server
     * 生成和 解析token
     */
    private final AuthServerConfigurationProperties authServerConfigurationProperties;

    public JwtTokenServerUtils(AuthServerConfigurationProperties authServerConfigurationProperties)
    {
        this.authServerConfigurationProperties = authServerConfigurationProperties;
    }


    /**
     * 生成token
     *
     * @param jwtInfo jwt信息
     * @param expire  到期时间
     * @return {@link Token}
     * @throws BizException 业务异常
     */
    public Token generateUserToken(JwtUserInfo jwtInfo, Integer expire) throws BizException
    {
        AuthServerConfigurationProperties.TokenInfo userTokenInfo = authServerConfigurationProperties.getUser();
        if (expire == null || expire <= 0)
        {
            expire = userTokenInfo.getExpire();
        }
        return JwtHelper.generateUserToken(jwtInfo, userTokenInfo.getPriKey(), expire);
    }


    /**
     * 解析token
     *
     * @param token 令牌
     * @return {@link JwtUserInfo}
     * @throws BizException 业务异常
     */
    public JwtUserInfo getUserInfo(String token) throws BizException
    {
        AuthServerConfigurationProperties.TokenInfo userTokenInfo = authServerConfigurationProperties.getUser();
        return JwtHelper.getJwtFromToken(token, userTokenInfo.getPubKey());
    }
}
