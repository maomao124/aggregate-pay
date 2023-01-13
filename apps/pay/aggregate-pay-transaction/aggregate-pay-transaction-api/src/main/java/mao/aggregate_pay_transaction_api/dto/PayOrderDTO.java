package mao.aggregate_pay_transaction_api.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.dto
 * Class(类名): PayOrderDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/13
 * Time(创建时间)： 21:57
 * Version(版本): 1.0
 * Description(描述)： 下单请求对象DTO
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PayOrderDTO implements Serializable
{
    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 商户下门店，如果未指定，默认是根门店
     */
    private Long storeId;

    /**
     * 此处使用业务id，服务内部使用主键id，服务与服务之间用业务id--appId
     */
    private String appId;

    /**
     * 聚合支付的渠道 此处使用渠道编码
     */
    private String channel;

    /**
     * 聚合支付平台订单号
     */
    private String tradeNo;

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
     * c端付款用户身份标识
     */
    private String openId;

    /**
     * 付款条码，支付宝或者微信点“付款”产生的付款条码。在b扫c时，应由前端传过来
     */
    private String authCode;

    /**
     * 设备,存放UA等信息
     */
    private String device;

    /**
     * 客户端iP
     */
    private String clientIp;

    /**
     * 支付渠道
     */
    private String payChannel;

    /**
     * 订单状态
     */
    private String tradeState;

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

}
