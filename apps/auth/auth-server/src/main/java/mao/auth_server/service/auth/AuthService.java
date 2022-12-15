package mao.auth_server.service.auth;

import mao.auth_entity.dto.auth.LoginDTO;
import mao.auth_entity.entity.auth.User;
import mao.tools_core.base.R;
import mao.tools_jwt.entity.Token;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): AuthService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface AuthService
{
    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @param key      验证码的key
     * @param value    用户输入的验证码
     * @return {@link R}<{@link LoginDTO}>
     */
    R<LoginDTO> login(String account, String password, String key, String value);

}
