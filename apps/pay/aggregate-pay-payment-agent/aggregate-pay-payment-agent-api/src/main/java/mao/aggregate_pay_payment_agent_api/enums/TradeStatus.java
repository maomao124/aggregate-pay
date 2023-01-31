package mao.aggregate_pay_payment_agent_api.enums;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.enums
 * Class(类名): TradeStatus
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 15:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public enum TradeStatus
{
    /**
     * 业务交易支付 明确成功
     */
    SUCCESS,

    /**
     * 业务交易支付 明确失败，
     */
    FAILED,

    /**
     * 业务交易状态未知，
     */
    UNKNOWN,

    /**
     * 交易新建，等待支付
     */
    USERPAYING,

    /**
     * 交易已撤销
     */
    REVOKED,
}
