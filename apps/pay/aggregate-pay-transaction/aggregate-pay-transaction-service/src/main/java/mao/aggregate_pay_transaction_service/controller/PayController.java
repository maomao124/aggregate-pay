package mao.aggregate_pay_transaction_service.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_common.utils.AmountUtil;
import mao.aggregate_pay_common.utils.EncryptUtil;
import mao.aggregate_pay_common.utils.IPUtil;
import mao.aggregate_pay_common.utils.ParseURLPairUtil;
import mao.aggregate_pay_entity.enums.BrowserType;
import mao.aggregate_pay_merchant_api.dto.AppDTO;
import mao.aggregate_pay_merchant_api.feign.AppFeignClient;
import mao.aggregate_pay_payment_agent_api.dto.PaymentResponseDTO;
import mao.aggregate_pay_transaction_api.dto.PayOrderDTO;
import mao.aggregate_pay_transaction_service.handler.AssertResult;
import mao.aggregate_pay_transaction_service.service.TransactionService;
import mao.aggregate_pay_transaction_service.vo.OrderConfirmVO;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
@RequestMapping("/pay")
@Api(value = "支付相关", tags = "支付相关")
public class PayController
{

    @Resource
    private DozerUtils dozerUtils;

    @Resource
    private TransactionService transactionService;

    @Resource
    private AppFeignClient appFeignClient;


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
            //单位为元的总金额
            if (order.getTotalAmount() != null)
            {
                String totalAmountY = AmountUtil.changeF2Y(order.getTotalAmount().toString());
                params = params + "&totalAmountY=" + totalAmountY;
            }
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
                    return "forward:/pay-page?" + params;
                //微信
                //获取授权码
                case WECHAT:
                    log.debug("浏览器类型为微信");
                    return transactionService.getWXOAuth2Code(order);
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

    @SneakyThrows
    @ApiOperation("支付宝门店下单付款")
    @RequestMapping(value = "/createAliPayOrder", method = {RequestMethod.POST, RequestMethod.GET})
    public void createAlipayOrderForStore(OrderConfirmVO orderConfirmVO, HttpServletRequest request,
                                          HttpServletResponse response)
    {
        log.debug("前端支付数据:" + orderConfirmVO);
        //判断appId为是否空
        if (StringUtils.isBlank(orderConfirmVO.getAppId()))
        {
            throw BizException.wrap(30003, "appId为空");
        }
        //获得总金额，单位为元
        String totalAmountY = orderConfirmVO.getTotalAmount();
        //清空总金额，否则会抛出异常
        orderConfirmVO.setTotalAmount(null);
        //转换
        PayOrderDTO payOrderDTO = dozerUtils.map(orderConfirmVO, PayOrderDTO.class);
        //总金额
        payOrderDTO.setTotalAmount(Integer.valueOf(AmountUtil.changeY2F(totalAmountY)));
        //设置请求的IP
        payOrderDTO.setClientIp(IPUtil.getIpAddr(request));
        //远程调用，获取下单应用信息
        R<AppDTO> r = appFeignClient.getAppById(payOrderDTO.getAppId());
        //断言结果
        AppDTO appDTO = AssertResult.handler(r);
        //设置所属商户
        payOrderDTO.setMerchantId(appDTO.getMerchantId());
        //调用交易服务
        //保存支付宝订单，并调用支付渠道代理服务调用支付宝的接口
        PaymentResponseDTO<String> payOrderResult = transactionService.submitOrderByAli(payOrderDTO);
        //取内容
        String content = payOrderResult.getContent();
        //往前端写页面
        log.debug("支付宝H5支付响应的结果：" + content);
        response.setContentType("text/html;charset=UTF‐8");
        //直接将完整的表单html输出到页面
        response.getWriter().write(content);
        response.getWriter().flush();
        response.getWriter().close();
    }

}
