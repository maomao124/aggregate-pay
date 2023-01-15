package mao.aggregate_pay_transaction_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.aggregate_pay_transaction_api.dto.PayChannelDTO;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_service.entity.PayChannel;
import mao.tools_core.base.R;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service
 * Interface(接口名): PayChannelService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 22:34
 * Version(版本): 1.0
 * Description(描述)： 支付聚道服务
 */

public interface PayChannelService extends IService<PayChannel>
{
    /**
     * 根据平台服务类型获取支付渠道列表
     *
     * @param platformChannelCode 平台渠道代码
     * @return {@link List}<{@link PayChannelDTO}>
     */
    List<PayChannelDTO> queryPayChannelByPlatformChannel(String platformChannelCode);
}
