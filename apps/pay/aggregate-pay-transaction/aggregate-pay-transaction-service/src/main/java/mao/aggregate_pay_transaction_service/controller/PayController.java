package mao.aggregate_pay_transaction_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.controller
 * Class(类名): PayController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/30
 * Time(创建时间)： 15:19
 * Version(版本): 1.0
 * Description(描述)： 支付相关
 */

@Slf4j
@Controller
@Api(value = "支付相关", tags = "支付相关")
public class PayController
{

    /**
     * 解析ticket并获取支付页面
     *
     * @param ticket  票
     * @param request 请求
     * @return {@link String}
     */
    @ApiOperation("解析ticket并获取支付页面")
    @RequestMapping(value = "/pay-entry/{ticket}", method = RequestMethod.GET)
    public String payEntry(@PathVariable("ticket") String ticket, HttpServletRequest request)
    {
        return "forward:/pay‐page";
    }


}
