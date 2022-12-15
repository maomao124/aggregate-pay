package mao.auth_server.controller.auth;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.auth_entity.dto.auth.LoginDTO;
import mao.auth_entity.dto.auth.LoginParamDTO;
import mao.auth_server.service.auth.AuthService;
import mao.auth_server.service.auth.ValidateCodeService;
import mao.tools_core.base.R;
import mao.tools_log.annotation.SysLog;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.auth
 * Class(类名): LoginController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:50
 * Version(版本): 1.0
 * Description(描述)： 登录Controller
 */


@RestController
@RequestMapping("/anno")
@Api(value = "LoginController", tags = "登录控制器")
public class LoginController
{
    @Resource
    private ValidateCodeService validateCodeService;

    @Resource
    private AuthService authService;


    @ApiOperation(value = "验证码", notes = "验证码")
    @GetMapping(value = "/captcha", produces = "image/png")
    public void captcha(@RequestParam(value = "key") String key,
                        HttpServletResponse response) throws IOException
    {
        this.validateCodeService.create(key, response);
    }


    /**
     * 登录认证
     *
     * @param loginParamDTO 登录参数dto
     * @return {@link R}<{@link LoginDTO}>
     */
    @SysLog("登录")
    @PostMapping("/login")
    @ApiOperation(notes = "登录", value = "登录")
    public R<LoginDTO> login(@Validated @RequestBody LoginParamDTO loginParamDTO)
    {
        //登录认证
        return authService.login(loginParamDTO.getAccount(), loginParamDTO.getPassword(),
                loginParamDTO.getKey(), loginParamDTO.getCode());
    }

    /**
     * 校验验证码是否正确
     *
     * @param loginParamDTO 登录参数dto
     * @return boolean
     */
    @PostMapping("/check")
    @ApiOperation(notes = "校验验证码", value = "校验验证码")
    public boolean check(@RequestBody LoginParamDTO loginParamDTO)
    {
        //校验验证码是否正确
        return validateCodeService.check(loginParamDTO.getKey(), loginParamDTO.getCode());
    }
}
