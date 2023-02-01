package mao.aggregate_pay_transaction_service.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.vo
 * Class(类名): OrderConfirmVO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 20:59
 * Version(版本): 1.0
 * Description(描述)： 订单确认信息，由前端传入
 */

@Data
@ApiModel(value = "OrderConfirmVO", description = "订单确认信息")
public class OrderConfirmVO
{
    /**
     * 应用id
     */
    private String appId;

    /**
     * 交易单号
     */
    private String tradeNo;

    /**
     * 微信openid
     */
    private String openId;

    /**
     * 门店id
     */
    private String storeId;

    /**
     * 服务类型
     */
    private String channel;

    /**
     * 订单描述
     */
    private String body;

    /**
     * 订单标题
     */
    private String subject;

    /**
     * 金额
     */
    private String totalAmount;
}
