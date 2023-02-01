package mao.aggregate_pay_payment_agent_api.dto;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): WeChatBean
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 19:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
public class WeChatBean implements Serializable
{
    /**
     * 公众号
     */
    private String appid;

    /**
     * 商户号
     */
    private String mchId;

    /**
     * 随机字符串
     */
    private String nonceStr;

    /**
     * 签名
     */
    private String sign;

    /**
     * 商品描述
     */
    private String body;

    /**
     * 商户订单号
     */
    private String outTradeNo;

    /**
     * 标价金额
     */
    private Integer totalFee;

    /**
     * 终端IP
     */
    private String spbillCreateIp;

    /**
     * 通知地址
     */
    private String notifyUrl;

    /**
     * 交易类型
     */
    private String tradeType;

    /**
     * 开放id
     */
    private String openId;

    /**
     * 自定义字段，门店id
     */
    private Long storeId;

    /**
     * 附加数据 attach 否
     */
    private String attach;

    /**
     * 得到随机字符串
     *
     * @return {@link String}
     */
    public String getNonceStr()
    {
        return nonceStr;
    }

    /**
     * 设置随机字符串
     *
     * @param nonceStr nonce str
     */
    public void setNonceStr(String nonceStr)
    {
        nonceStr = RandomStringUtils.random(10, "1234567890");
        this.nonceStr = nonceStr;
    }
}
