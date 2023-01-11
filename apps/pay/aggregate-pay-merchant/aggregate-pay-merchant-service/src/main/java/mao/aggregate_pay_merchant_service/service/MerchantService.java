package mao.aggregate_pay_merchant_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_service.entity.Merchant;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service
 * Interface(接口名): MerchantService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:29
 * Version(版本): 1.0
 * Description(描述)： 商户服务接口
 */

public interface MerchantService extends IService<Merchant>
{
    /**
     * 通过id获取商户信息
     *
     * @param merchantId 商户id
     * @return {@link MerchantDTO}
     */
    MerchantDTO getMerchantById(Long merchantId);


    /**
     * 商户注册
     *
     * @param merchantDTO {@link MerchantDTO} 商户dto
     * @return {@link MerchantDTO}
     */
    MerchantDTO createMerchant(MerchantDTO merchantDTO);

    /**
     * 资质申请
     *
     * @param merchantId  商户id
     * @param merchantDTO 资质申请信息
     */
    void applyMerchant(Long merchantId, MerchantDTO merchantDTO);

}
