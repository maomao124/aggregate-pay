package mao.aggregate_pay_transaction_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.aggregate_pay_transaction_service.entity.AppPlatformChannel;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service
 * Interface(接口名): AppPlatformChannelService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/15
 * Time(创建时间)： 14:32
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface AppPlatformChannelService extends IService<AppPlatformChannel>
{
    /**
     * 应用是否已经绑定了某个服务类型
     *
     * @param appId           应用程序id
     * @param platformChannel 平台通道
     * @return boolean
     */
    boolean queryAppBindPlatformChannel(String appId, String platformChannel);
}
