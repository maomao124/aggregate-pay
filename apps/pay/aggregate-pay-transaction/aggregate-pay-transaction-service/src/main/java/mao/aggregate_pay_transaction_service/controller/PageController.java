package mao.aggregate_pay_transaction_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.controller
 * Class(类名): PageController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/30
 * Time(创建时间)： 15:14
 * Version(版本): 1.0
 * Description(描述)： 静态页面
 */

@Slf4j
@Controller
@Api(value = "静态页面", tags = "静态页面")
public class PageController
{

    /**
     * 支付页面
     *
     * @param map 数据
     * @return {@link String}
     */
    @RequestMapping("/pay-page", method = RequestMethod.GET)
    @ApiOperation("支付页面")
    public String payPage(Map<String, Object> map, HttpServletRequest httpServletRequest)
    {
        log.debug("ip:" + httpServletRequest.getRemoteAddr() + " 访问支付页面");
        return "pay";
    }
}
