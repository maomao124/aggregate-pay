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
    private String merchantOrderNo;
    private String channelOrderNo;
    private String productName;
    private String createTime;
    private String posTime;
    private String equipmentNo;
    private String userAccount;
    private BigDecimal totalAmount;
    private BigDecimal tradeAmount;
    private BigDecimal discountAmount;
    private BigDecimal serviceFee;
    private String refundOrderNo;
    private BigDecimal refundMoney;
    private String platformChannel;
    //private String storeId;  //自己平台的商户编号，再根据该编号来确认是否是本平台的订单
    private String remark;
}
