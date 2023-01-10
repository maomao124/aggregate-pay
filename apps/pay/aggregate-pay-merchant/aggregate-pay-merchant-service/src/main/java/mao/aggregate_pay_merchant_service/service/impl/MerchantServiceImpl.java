package mao.aggregate_pay_merchant_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_service.entity.Merchant;
import mao.aggregate_pay_merchant_service.mapper.MerchantMapper;
import mao.aggregate_pay_merchant_service.service.MerchantService;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service.impl
 * Class(类名): MerchantServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/9
 * Time(创建时间)： 15:38
 * Version(版本): 1.0
 * Description(描述)： 商户服务实现类
 */

@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant> implements MerchantService
{

    @Resource
    private DozerUtils dozerUtils;

    @Override
    public MerchantDTO getMerchantById(Long merchantId)
    {
        //查询
        Merchant merchant = this.getById(merchantId);
        //转换，并返回
        return dozerUtils.map(merchant, MerchantDTO.class);
    }

    @Override
    public MerchantDTO createMerchant(MerchantDTO merchantDTO)
    {
        //构建商户
        Merchant merchant = new Merchant();
        //设置审核状态
        merchant.setAuditStatus("0");
        //设置手机号
        merchant.setMobile(merchantDTO.getMobile());
        //保存
        this.save(merchant);
        //保存id信息
        merchantDTO.setId(merchant.getId());
        //返回
        return merchantDTO;
    }
}
