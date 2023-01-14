package mao.aggregate_pay_transaction_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_service.entity.PlatformChannel;
import mao.tools_core.base.R;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.service
 * Interface(接口名): PlatformChannelService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 22:55
 * Version(版本): 1.0
 * Description(描述)： 服务类型
 */

public interface PlatformChannelService extends IService<PlatformChannel>
{
    /**
     * 获取平台的所有服务类型
     *
     * @return {@link R}<{@link List}<{@link PlatformChannelDTO}>>
     */
    R<List<PlatformChannelDTO>> queryAll();


    /**
     * 为app绑定平台服务类型
     *
     * @param appId                应用id
     * @param platformChannelCodes 平台服务类型
     */
    void bindPlatformChannelForApp(String appId, String platformChannelCodes);
}
