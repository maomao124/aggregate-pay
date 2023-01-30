package mao.aggregate_pay_transaction_service.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.utils.EncryptUtil;
import mao.aggregate_pay_common.utils.ParseURLPairUtil;
import mao.aggregate_pay_entity.enums.BrowserType;
import mao.aggregate_pay_transaction_api.dto.PayOrderDTO;
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
     * @param ticket  ticket
     * @param request 请求
     * @return {@link String}
     */
    @ApiOperation("解析ticket并获取支付页面")
    @RequestMapping(value = "/pay-entry/{ticket}", method = RequestMethod.GET)
    public String payEntry(@PathVariable("ticket") String ticket, HttpServletRequest request) throws Exception
    {
        try
        {
            //解析
            String ticketJson = EncryptUtil.decodeUTF8StringBase64(ticket);
            log.debug("ticketJson:" + ticketJson);
            //json转对象
            PayOrderDTO order = JSON.parseObject(ticketJson, PayOrderDTO.class);
            //将对象转成url格式，调用根据类
            String params = ParseURLPairUtil.parseURLPair(order);
            log.debug("url参数：" + params);
            String userAgent = request.getHeader("user-agent");
            log.debug("userAgent:" + userAgent);
            //解析浏览器类型
            BrowserType browserType = BrowserType.getBrowserTypeByUA(userAgent);
            switch (browserType)
            {
                //支付宝
                //直接跳转pay.html
                case ALIPAY:
                    log.debug("浏览器类型为支付宝");
                    return "forward:/pay‐page?" + params;
                //微信
                //获取授权码(待实现)
                case WECHAT:
                    log.debug("浏览器类型为微信");
                    return "forward:/pay‐page?" + params;
                default:
                    log.debug("浏览器不支持");
                    return "forward:/pay-error-page";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            log.error("错误：", e);
            return "forward:/pay-error-page";
        }
    }
}
