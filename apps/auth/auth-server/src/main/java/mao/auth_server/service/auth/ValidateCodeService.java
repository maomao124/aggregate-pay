package mao.auth_server.service.auth;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): ValidateCodeService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:53
 * Version(版本): 1.0
 * Description(描述)： 验证码Service接口
 */

public interface ValidateCodeService
{
    /**
     * 生成验证码
     *
     * @param key      这个key为缓存的key
     * @param response HttpServletResponse
     * @throws IOException IOException
     */
    void create(String key, HttpServletResponse response) throws IOException;


    /**
     * 校验验证码是否正确
     *
     * @param key   这个key为缓存的key
     * @param value 前端传过来的值
     * @return boolean
     */
    boolean check(String key, String value);
}
