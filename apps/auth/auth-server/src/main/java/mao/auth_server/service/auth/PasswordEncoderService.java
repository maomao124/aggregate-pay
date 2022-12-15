package mao.auth_server.service.auth;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): PasswordEncoderService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:49
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface PasswordEncoderService
{
    /**
     * 将原始密码加密
     *
     * @param rawPassword 未进行加密的原始密码
     * @return {@link String} 加密后的密码
     */
    String encoder(String rawPassword);

    /**
     * 验证密码是否正确
     *
     * @param rawPassword    原始密码，未经加密的密码
     * @param encodePassword 加密后的密码
     * @return boolean
     */
    boolean verification(String rawPassword, String encodePassword);
}
