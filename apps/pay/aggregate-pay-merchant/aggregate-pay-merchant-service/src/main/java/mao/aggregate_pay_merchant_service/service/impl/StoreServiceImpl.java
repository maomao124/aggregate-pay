package mao.aggregate_pay_merchant_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_merchant_service.entity.Store;
import mao.aggregate_pay_merchant_service.mapper.StoreMapper;
import mao.aggregate_pay_merchant_service.service.StoreService;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service.impl
 * Class(类名): StoreServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 23:00
 * Version(版本): 1.0
 * Description(描述)： 门店服务实现类
 */

@Slf4j
@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService
{

    @Override
    public R<Boolean> queryStoreInMerchant(Long storeId, Long merchantId)
    {
        //查询
        int count = this.count(Wraps.<Store>lbQ()
                .eq(Store::getMerchantId, merchantId)
                .eq(Store::getId, storeId));
        if (count > 0)
        {
            return R.success(true);
        }
        else
        {
            //无论查询是否成功，都要返回R.success
            return R.success(false);
        }
    }
}
