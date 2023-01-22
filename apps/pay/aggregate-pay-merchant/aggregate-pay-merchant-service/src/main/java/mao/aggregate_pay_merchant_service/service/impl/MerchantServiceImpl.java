package mao.aggregate_pay_merchant_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_service.entity.Merchant;
import mao.aggregate_pay_merchant_service.entity.Store;
import mao.aggregate_pay_merchant_service.mapper.MerchantMapper;
import mao.aggregate_pay_merchant_service.service.MerchantService;
import mao.aggregate_pay_merchant_service.service.StoreService;
import mao.tools_core.exception.BizException;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private StoreService storeService;

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
        //校验商户手机号的唯一性,根据商户的手机号查询商户表，如果存在记录则说明已有相同的手机号重复
        int count = this.count(Wraps.<Merchant>lbQ().eq(Merchant::getMobile, merchantDTO.getMobile()));
        if (count > 0)
        {
            throw BizException.wrap("手机号重复");
        }
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

    @Override
    @Transactional
    public void applyMerchant(Long merchantId, MerchantDTO merchantDTO)
    {
        //接收资质申请信息，更新到商户表
        if (merchantDTO == null || merchantId == null)
        {
            throw BizException.wrap("传入对象为空");
        }
        //根据id查询商户
        Merchant merchant = this.getById(merchantId);
        if (merchant == null)
        {
            throw BizException.wrap("商户不存在");
        }
        //对象转换
        Merchant merchant_update = dozerUtils.map(merchantDTO, Merchant.class);
        //已申请待审核
        merchant_update.setAuditStatus("1");
        //租户id
        merchant_update.setTenantId(merchant.getTenantId());
        //设置商户id
        merchant_update.setId(merchantId);
        //更新
        boolean update = this.updateById(merchant_update);
        if (!update)
        {
            throw BizException.wrap("商户资质申请失败");
        }
    }

    @Override
    public StoreDTO createStore(StoreDTO storeDTO)
    {
        //转换
        Store store = dozerUtils.map(storeDTO, Store.class);
        //去掉id
        store.setId(null);
        //新增
        boolean save = storeService.save(store);
        if (!save)
        {
            throw BizException.wrap("新增门店失败");
        }
        //设置id
        storeDTO.setId(store.getId());
        //返回
        return storeDTO;
    }
}
