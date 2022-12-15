package mao.auth_server.controller.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.auth_entity.entity.auth.User;
import mao.auth_entity.enumeration.auth.Sex;
import mao.auth_server.service.auth.UserService;
import mao.tools_core.base.R;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.common
 * Class(类名): TestController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/12
 * Time(创建时间)： 12:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Api(value = "TestController" ,tags = "测试")
@RestController
@RequestMapping("/test")
public class TestController
{
    @Resource
    private UserService userService;

    @ApiOperation(value = "ping服务", notes = "ping服务")
    @GetMapping("/ping")
    public R<String> ping()
    {
        return R.success("ok");
    }

    @Transactional
    @ApiOperation(value = "测试事务", notes = "测试事务")
    @GetMapping("/test")
    public Boolean test()
    {
        User user1 = User.builder().id(5L).email("1234@qq.com")
                .password("123").sex(Sex.M).account("333")
                .name("测试用户")
                .email("123@qq.com").build();
        User user2 = User.builder().id(6L).email("1234@qq.com")
                .password("123").sex(Sex.M).account("334")
                .name("测试用户")
                .email("123@qq.com").build();
        User user3 = User.builder().id(5L).email("1234@qq.com")
                .password("123").sex(Sex.M).account("335")
                .name("测试用户")
                .email("123@qq.com").build();

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        return true;
    }

}
