package mao.tools_jwt.client.utils;

import mao.tools_core.exception.BizException;
import mao.tools_jwt.client.config.AuthClientConfigurationProperties;
import mao.tools_jwt.entity.JwtUserInfo;
import mao.tools_jwt.utils.JwtHelper;

/**
 * Project name(项目名称)：jwt_spring_boot_starter
 * Package(包名): mao.tools_jwt.client.utils
 * Class(类名): JwtTokenClientUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/3
 * Time(创建时间)： 12:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class JwtTokenClientUtils
{
    /**
     * 用于 认证服务的 客户端使用（如 网关） ， 在网关获取到token后，
     * 调用此工具类进行token 解析。
     * 客户端一般只需要解析token 即可
     */
    private final AuthClientConfigurationProperties authClientConfigurationProperties;

    public JwtTokenClientUtils(AuthClientConfigurationProperties authClientConfigurationProperties)
    {
        this.authClientConfigurationProperties = authClientConfigurationProperties;
    }

    /**
     * 解析token，获取用户信息
     *
     * @param token 令牌
     * @return {@link JwtUserInfo}
     * @throws BizException 业务异常
     */
    public JwtUserInfo getUserInfo(String token) throws BizException
    {
        AuthClientConfigurationProperties.TokenInfo userTokenInfo = authClientConfigurationProperties.getUser();
        return JwtHelper.getJwtFromToken(token, userTokenInfo.getPubKey());
    }
}
