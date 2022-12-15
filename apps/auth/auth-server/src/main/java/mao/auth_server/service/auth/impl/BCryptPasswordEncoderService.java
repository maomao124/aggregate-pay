package mao.auth_server.service.auth.impl;

import lombok.extern.slf4j.Slf4j;
import mao.auth_server.service.auth.PasswordEncoderService;
import mao.auth_server.utils.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): BCryptPasswordEncoderService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 20:50
 * Version(版本): 1.0
 * Description(描述)： 密码加密和验证服务
 */

@Slf4j
@Service
public class BCryptPasswordEncoderService implements PasswordEncoderService
{

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public BCryptPasswordEncoderService()
    {
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
        log.info("密码加密和验证使用的是: BCrypt 算法");
    }

    @Override
    public String encoder(String rawPassword)
    {
        return bCryptPasswordEncoder.encode(rawPassword);
    }

    @Override
    public boolean verification(String rawPassword, String encodePassword)
    {
        return bCryptPasswordEncoder.matches(rawPassword, encodePassword);
    }
}
