package mao.aggregate_pay_transaction_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.aggregate_pay_transaction_api.dto.PayOrderDTO;
import mao.aggregate_pay_transaction_service.entity.PayOrder;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service
 * Interface(接口名): PayOrderService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 21:15
 * Version(版本): 1.0
 * Description(描述)： 订单服务接口
 */

public interface PayOrderService extends IService<PayOrder>
{
    /**
     * 保存订单
     *
     * @param payOrderDTO 支付订单dto
     * @return {@link PayOrderDTO}
     */
    PayOrderDTO save(PayOrderDTO payOrderDTO);

    /**
     * 根据订单号查询订单信息
     *
     * @param tradeNo 订单号
     * @return {@link PayOrderDTO}
     */
    PayOrderDTO queryPayOrderByTradeNo(String tradeNo);
}
