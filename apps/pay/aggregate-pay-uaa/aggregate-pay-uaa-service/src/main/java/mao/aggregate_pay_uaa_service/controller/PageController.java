package mao.aggregate_pay_uaa_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.controller
 * Class(类名): PageController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 14:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Controller
@Api(value = "页面", tags = "页面")
public class PageController
{

    /**
     * 登录页面
     *
     * @return {@link String}
     */
    @ApiOperation("登录页面")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        log.info("获取登录页面");
        return "login";
    }

}
