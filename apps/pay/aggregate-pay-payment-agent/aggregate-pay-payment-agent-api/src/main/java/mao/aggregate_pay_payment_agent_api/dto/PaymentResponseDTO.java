package mao.aggregate_pay_payment_agent_api.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mao.aggregate_pay_payment_agent_api.enums.TradeStatus;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): PaymentResponseDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 15:43
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "PaymentResponseDTO", description = "支付响应信息")
public class PaymentResponseDTO<T> implements Serializable
{
    /**
     * 系统状态 "0"代表请求成功
     */
    private String code = "0";

    /**
     * 消息
     */
    private String msg;

    /**
     * 原始渠道订单号() 聚合平台角度：原始交易号      商户应用角度：聚合平台的订单号
     */
    private String tradeNo;

    /**
     * 商户订单号   聚合平台角度：自己订单号       商户应用角度：自己订单号
     */
    private String outTradeNo;

    /**
     * 支付状态
     */
    private TradeStatus tradeState;

    /**
     * 内容
     */
    private T content;

    /**
     * 成功
     *
     * @param content 内容
     * @return {@link PaymentResponseDTO}<{@link T}>
     */
    public static <T> PaymentResponseDTO<T> success(T content)
    {
        PaymentResponseDTO<T> response = new PaymentResponseDTO<T>();
        response.setContent(content);
        return response;
    }

    /**
     * 失败
     *
     * @param msg 消息
     * @return {@link PaymentResponseDTO}<{@link T}>
     */
    public static <T> PaymentResponseDTO<T> validfail(String msg)
    {
        PaymentResponseDTO<T> response = new PaymentResponseDTO<T>();
        response.setCode("999999");
        response.setMsg(msg);
        return response;
    }

    /**
     * 失败
     *
     * @param msg        消息
     * @param outTradeNo 贸易没有
     * @param tradeState 支付状态
     * @return {@link PaymentResponseDTO}<{@link T}>
     */
    public static <T> PaymentResponseDTO<T> fail(String msg, String outTradeNo, TradeStatus tradeState)
    {
        PaymentResponseDTO<T> response = new PaymentResponseDTO<T>();
        response.setCode("999999");
        response.setMsg(msg);
        response.setOutTradeNo(outTradeNo);
        response.setTradeState(tradeState);
        return response;
    }

    /**
     * 成功
     *
     * @param msg        消息
     * @param tradeNo    原始渠道订单号
     * @param outTradeNo 商户订单号
     * @param tradeState 支付状态
     * @return {@link PaymentResponseDTO}<{@link T}>
     */
    public static <T> PaymentResponseDTO<T> success(String msg, String tradeNo, String outTradeNo, TradeStatus tradeState)
    {
        PaymentResponseDTO<T> response = new PaymentResponseDTO<T>();
        response.setMsg(msg);
        response.setTradeNo(tradeNo);
        response.setOutTradeNo(outTradeNo);
        response.setTradeState(tradeState);
        return response;
    }

    /**
     * 成功
     *
     * @param tradeNo    原始渠道订单号
     * @param outTradeNo 商户订单号
     * @param tradeState 支付状态
     * @param msg        消息
     * @return {@link PaymentResponseDTO}<{@link T}>
     */
    public static <T> PaymentResponseDTO<T> success(String tradeNo, String outTradeNo, TradeStatus tradeState, String msg)
    {
        PaymentResponseDTO<T> response = new PaymentResponseDTO<T>();
        switch (tradeState)
        {
            case SUCCESS:
                response.setMsg("业务交易支付 明确成功");
                break;
            case FAILED:
                response.setMsg("业务交易支付 明确失败 " + msg);
                break;
            case UNKNOWN:
                response.setMsg("业务交易 状态未知");
                break;
            case USERPAYING:
                response.setMsg("交易新建 等待支付");
                break;
            case REVOKED:
                response.setMsg("交易已撤销");
                break;
        }
        response.setTradeNo(tradeNo);
        response.setOutTradeNo(outTradeNo);
        response.setTradeState(tradeState);
        return response;
    }
}
