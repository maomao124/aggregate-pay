package mao.aggregate_pay_payment_agent_api.dto;

import lombok.Data;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): PayOrderByAliWAPBody
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 20:39
 * Version(版本): 1.0
 * Description(描述)： 支付代理服务controller 的 createPayOrderByAliWAP方法的请求体
 */

@Data
public class PayOrderByAliWAPBody
{
    /**
     * 阿里配置参数
     */
    private AliConfigParam aliConfigParam;

    /**
     * 支付实体对象，根据支付宝接口协议
     */
    private AlipayBean alipayBean;
}
