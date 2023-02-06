package mao.aggregate_pay_merchant_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_service.entity.Store;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service
 * Interface(接口名): StoreService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 23:00
 * Version(版本): 1.0
 * Description(描述)： 门店服务
 */

public interface StoreService extends IService<Store>
{
    /**
     * 查询门店是否属于某商户
     *
     * @param storeId    门店id
     * @param merchantId 商户id
     * @return {@link R}<{@link Boolean}>
     */
    R<Boolean> queryStoreInMerchant(Long storeId, Long merchantId);


    /**
     * 更新商户下的门店信息
     *
     * @param storeDTO 门店dto
     * @return {@link StoreDTO}
     */
    StoreDTO update(@RequestBody StoreDTO storeDTO);


    /**
     * 新增商户下的门店信息
     *
     * @param storeDTO 门店dto
     * @return {@link StoreDTO}
     */
    StoreDTO save(@RequestBody StoreDTO storeDTO, @RequestParam String staffIds);


    /**
     * 删除商户下的门店信息
     *
     * @param storeDTO 门店dto
     * @return {@link Boolean}
     */
    Boolean delete(@RequestBody StoreDTO storeDTO);
}
