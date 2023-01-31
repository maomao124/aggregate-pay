package mao.aggregate_pay_payment_agent_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): AlipayBean
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 14:40
 * Version(版本): 1.0
 * Description(描述)： 支付实体对象，根据支付宝接口协议
 */

@Data
public class AlipayBean implements Serializable
{
    /**
     * 商户订单号，必填
     */
    private String outTradeNo;

    /**
     * 订单名称，必填
     */
    private String subject;

    /**
     * 付款金额(元)，必填
     */
    private String totalAmount;

    /**
     * 产品编号，必填
     */
    private String productCode;

    /**
     * 商品描述，可空
     */
    private String body;

    /**
     * 超时时间参数
     */
    private String expireTime;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String timestamp;
    /**
     * 门店id
     */
    private Long storeId;

    /**
     * 订单附件数据， 格式为： SJPAY,平台商户号,Appid,门店,平台渠道编码
     */
    private String attach;
}
