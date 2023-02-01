package mao.aggregate_pay_payment_agent_api.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): PaymentBillDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 15:41
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
public class PaymentBillDTO implements Serializable
{
    /*private Long merchantId;
        private String merchantName;
        private Long merchantAppId;*/

    /**
     * 商业订单
     */
    private String merchantOrderNo;
    /**
     * 频道订单没有
     */
    private String channelOrderNo;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * pos时间
     */
    private String posTime;
    /**
     * 设备没有
     */
    private String equipmentNo;
    /**
     * 用户帐户
     */
    private String userAccount;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
    /**
     * 贸易金额
     */
    private BigDecimal tradeAmount;
    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;
    /**
     * 服务费用
     */
    private BigDecimal serviceFee;
    /**
     * 退款订单没有
     */
    private String refundOrderNo;
    /**
     * 退款钱
     */
    private BigDecimal refundMoney;
    /**
     * 平台通道
     */
    private String platformChannel;

    //private String storeId;  //自己平台的商户编号，再根据该编号来确认是否是本平台的订单

    /**
     * 备注
     */
    private String remark;
}
