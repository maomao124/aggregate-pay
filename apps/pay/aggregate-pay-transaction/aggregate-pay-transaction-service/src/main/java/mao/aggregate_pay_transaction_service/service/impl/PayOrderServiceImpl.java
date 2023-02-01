package mao.aggregate_pay_transaction_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.utils.PaymentUtil;
import mao.aggregate_pay_transaction_api.dto.PayOrderDTO;
import mao.aggregate_pay_transaction_service.entity.PayOrder;
import mao.aggregate_pay_transaction_service.mapper.PayOrderMapper;
import mao.aggregate_pay_transaction_service.service.PayOrderService;
import mao.tools_core.exception.BizException;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service.impl
 * Class(类名): PayOrderServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/1
 * Time(创建时间)： 21:16
 * Version(版本): 1.0
 * Description(描述)： 订单服务接口实现类
 */

@Slf4j
@Service
public class PayOrderServiceImpl extends ServiceImpl<PayOrderMapper, PayOrder> implements PayOrderService
{

    @Resource
    private DozerUtils dozerUtils;


    @Override
    public PayOrderDTO save(PayOrderDTO payOrderDTO)
    {
        //转实体类
        PayOrder payOrder = dozerUtils.map(payOrderDTO, PayOrder.class);
        //构建订单号
        payOrder.setTradeNo(PaymentUtil.genUniquePayOrderNo());
        //设置订单创建时间
        payOrder.setCreateTime(LocalDateTime.now());
        //设置过期时间，30分钟后
        payOrder.setExpireTime(LocalDateTime.now().plus(30, ChronoUnit.MINUTES));
        //设置支付币种，人民币
        payOrder.setCurrency("CNY");
        //设置订单状态
        payOrder.setTradeState("0");
        //保存
        boolean save = this.save(payOrder);
        if (!save)
        {
            throw BizException.wrap("支付订单保存失败");
        }
        //转换
        dozerUtils.map(payOrder, payOrderDTO);
        //返回
        return payOrderDTO;
    }

    @Override
    public PayOrderDTO queryPayOrderByTradeNo(String tradeNo)
    {
        //查询
        PayOrder payOrder = this.getOne(Wraps.<PayOrder>lbQ().eq(PayOrder::getTradeNo, tradeNo));
        //返回
        return dozerUtils.map(payOrder, PayOrderDTO.class);
    }
}
