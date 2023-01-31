package mao.aggregate_pay_payment_agent_api.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): OrderDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 14:43
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
public class OrderDTO implements Serializable
{
    /**
     * id
     */
    private Long id;

    /**
     * 贸易不
     */
    private String tradeNo;

    /**
     * 商人id
     */
    private Long merchantId;

    /**
     * 存储id
     */
    private Long storeId;

    /**
     * 此处使用业务id，服务内部使用主键id，服务与服务之间用业务id--appId
     */
    private String appId;

    /**
     * 原始支付渠道编码
     */
    private String payChannel;

    /**
     * 原始渠道商户id
     */
    private String payChannelMchId;

    /**
     * 原始渠道订单号
     */
    private String payChannelTradeNo;

    /**
     * 聚合支付的渠道 此处使用渠道编码
     */
    private String channel;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 商品标题
     */
    private String subject;

    /**
     * 订单描述
     */
    private String body;

    /**
     * 币种CNY
     */
    private String currency;

    /**
     * 订单总金额，单位为分
     */
    private Integer totalAmount;

    /**
     * 自定义数据
     */
    private String optional;

    /**
     * 用于统计分析的数据,用户自定义
     */
    private String analysis;

    /**
     * 特定渠道发起时额外参数
     */
    private String extra;

    /**
     * 交易状态支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成
     */
    private String tradeState;

    /**
     * 渠道支付错误码
     */
    private String errorCode;

    /**
     * 渠道支付错误信息
     */
    private String errorMsg;

    /**
     * 设备
     */
    private String device;

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 订单过期时间
     */
    private LocalDateTime expireTime;

    /**
     * 支付成功时间
     */
    private LocalDateTime paySuccessTime;

    /**
     * 开放id
     */
    private String openId;

    /**
     * 原始商家的应用id
     */
    private String payChannelMchAppId;

    /**
     * 产品编号，必填
     */
    private String productCode;
}
