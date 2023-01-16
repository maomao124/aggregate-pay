package mao.aggregate_pay_transaction_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import mao.aggregate_pay_transaction_service.entity.PayChannelParam;
import mao.tools_core.base.R;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service
 * Interface(接口名): PayChannelParamService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/16
 * Time(创建时间)： 20:08
 * Version(版本): 1.0
 * Description(描述)： 原始的支付聚道参数服务
 */

public interface PayChannelParamService extends IService<PayChannelParam>
{
    /**
     * 保存支付通道参数
     *
     * @param payChannelParam 原始的支付通道参数
     * @return {@link R}<{@link Boolean}>
     */
    R<Boolean> savePayChannelParam(PayChannelParamDTO payChannelParam);
}
