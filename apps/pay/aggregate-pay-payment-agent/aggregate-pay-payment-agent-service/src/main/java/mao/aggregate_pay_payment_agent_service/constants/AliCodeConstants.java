package mao.aggregate_pay_payment_agent_service.constants;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_service.constants
 * Class(类名): AliCodeConstants
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 19:59
 * Version(版本): 1.0
 * Description(描述)： 支付宝查询返回状态码常量类
 */

public class AliCodeConstants
{
    /**
     * 支付成功或接口调用成功
     */
    public static final String SUCCESSCODE = "10000";

    /**
     * 用户支付中
     */
    public static final String PAYINGCODE  = "10003";

    /**
     * 失败
     */
    public static final String FAILEDCODE  = "40004";

    /**
     * 系统异常
     */
    public static final String ERRORCODE   = "20000";


    /*
     * 支付宝交易状态
     *      WAIT_BUYER_PAY（交易创建，等待买家付款）
     *     TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）
     *     TRADE_SUCCESS（交易支付成功）
     *     TRADE_FINISHED（交易结束，不可退款）
     */

    /**
     * 等待买家支付
     */
    public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";

    /**
     * 未付款交易超时关闭，或支付完成后全额退款
     */
    public static final String TRADE_CLOSED = "TRADE_CLOSED";

    /**
     * 交易支付成功
     */
    public static final String TRADE_SUCCESS = "TRADE_SUCCESS";

    /**
     * 交易结束，不可退款
     */
    public static final String TRADE_FINISHED = "TRADE_FINISHED";
}
