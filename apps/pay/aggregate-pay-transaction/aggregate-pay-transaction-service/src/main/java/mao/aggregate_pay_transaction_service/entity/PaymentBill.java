package mao.aggregate_pay_transaction_service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.entity
 * Class(类名): PaymentBill
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/13
 * Time(创建时间)： 22:30
 * Version(版本): 1.0
 * Description(描述)： 付款账单
 */

@Data
@TableName("payment_bill")
public class PaymentBill implements Serializable
{
    /**
     * 串行版本uid
     */
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 商户应用Id
     */
    private Long merchantAppId;

    /**
     * 商户订单号
     */
    private String merchantOrderNo;

    /**
     * 渠道订单号
     */
    private String channelOrderNo;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 交易时间
     */
    private String posTime;

    /**
     * 终端号
     */
    private String equipmentNo;

    /**
     * 用户账号/标识信息
     */
    private String userAccount;

    /**
     * 订单金额
     */
    private BigDecimal totalAmount;

    /**
     * 实际交易金额
     */
    private BigDecimal tradeAmount;

    /**
     * 折扣金额
     */
    private BigDecimal discountAmount;

    /**
     * 手续费
     */
    private BigDecimal serviceFee;

    /**
     * 退款单号
     */
    private String refundOrderNo;

    /**
     * 退款金额
     */
    private BigDecimal refundMoney;

    /**
     * 平台支付渠道
     */
    private String platformChannel;

    /**
     * 备注
     */
    private String remark;
}
