package mao.aggregate_pay_merchant_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.aggregate_pay_merchant_api.dto.AppDTO;
import mao.aggregate_pay_merchant_service.entity.App;
import mao.tools_core.base.R;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service
 * Interface(接口名): AppService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/12
 * Time(创建时间)： 14:56
 * Version(版本): 1.0
 * Description(描述)： 应用
 */

public interface AppService extends IService<App>
{
    /**
     * 创建应用，基于某个商户
     *
     * @param merchantId 商户id
     * @param app        {@link AppDTO}
     * @return {@link AppDTO}
     */
    R<AppDTO> createApp(Long merchantId, AppDTO app);


    /**
     * 查询商户下的应用列表
     *
     * @param merchantId 商户id
     * @return {@link List}<{@link AppDTO}>
     */
    List<AppDTO> queryAppByMerchantId(Long merchantId);


    /**
     * 根据id查询应用
     *
     * @param id id
     * @return {@link R}<{@link AppDTO}>
     */
    R<AppDTO> getAppById(String id);


    /**
     * 查询应用是否属于某个商户
     *
     * @param appId      应用程序id
     * @param merchantId 商人id
     * @return {@link R}<{@link Boolean}>
     */
    R<Boolean> queryAppInMerchant(String appId, Long merchantId);
}
