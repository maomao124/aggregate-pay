package mao.aggregate_pay_merchant_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_service.entity.Staff;
import mao.aggregate_pay_merchant_service.entity.Store;
import mao.aggregate_pay_merchant_service.entity.StoreStaff;
import mao.aggregate_pay_merchant_service.mapper.StoreMapper;
import mao.aggregate_pay_merchant_service.service.StaffService;
import mao.aggregate_pay_merchant_service.service.StoreService;
import mao.aggregate_pay_merchant_service.service.StoreStaffService;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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

    @Resource
    private DozerUtils dozerUtils;

    @Resource
    private StoreStaffService storeStaffService;

    @Resource
    private StaffService staffService;

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


    @Override
    public StoreDTO update(StoreDTO storeDTO)
    {
        //转换
        Store store = dozerUtils.map(storeDTO, Store.class);
        //检查门店编号是否唯一
        checkStoreNumber(store);
        //更新
        this.updateById(store);
        return dozerUtils.map(store, StoreDTO.class);
    }

    /**
     * 检查门店编号是否唯一
     *
     * @param store 门店
     */
    private void checkStoreNumber(Store store)
    {
        //如果有门店编号
        if (store.getStoreNumber() != null)
        {
            Long storeNumber = store.getStoreNumber();
            //查询门店编号在数据库中是否存在，唯一
            int count = this.count(Wraps.<Store>lbQ().eq(Store::getStoreNumber, storeNumber));
            if (count > 0)
            {
                //不唯一
                throw BizException.wrap("门店编号不唯一");
            }
        }
    }

    @Override
    @Transactional
    public StoreDTO save(StoreDTO storeDTO, String staffIds)
    {
        //转换
        Store store = dozerUtils.map(storeDTO, Store.class);
        //检查门店编号是否唯一
        checkStoreNumber(store);
        //保存
        boolean save = super.save(store);
        if (!save)
        {
            throw BizException.wrap("门店信息保存失败");
        }
        //更新门店与员工的关系
        String[] staffList = staffIds.split(",");
        for (String staff : staffList)
        {
            //查询员工信息
            Staff staff1 = staffService.getById(staff);
            //判断员工是否存在
            if (staff1 == null)
            {
                throw new BizException("员工不存在");
            }
            //判断员工是否属于当前商户
            if (!store.getMerchantId().equals(staff1.getMerchantId()))
            {
                throw new BizException("有员工不属于当前商户");
            }
            StoreStaff storeStaff = new StoreStaff();
            //员工id
            storeStaff.setStaffId(Long.valueOf(staff));
            //门店id
            storeStaff.setStoreId(store.getId());
            //保存
            boolean save1 = storeStaffService.save(storeStaff);
            if (!save1)
            {
                throw BizException.wrap("员工与门店的关系保存失败");
            }
        }
        return dozerUtils.map(store, StoreDTO.class);
    }


    @Override
    public Boolean delete(StoreDTO storeDTO)
    {
        //查询当前门店是否属于当前商户
        Store store = this.getById(storeDTO.getId());
        if (store == null)
        {
            //如果查询不到，就不需要删除
            return true;
        }
        //查询到了
        if (!storeDTO.getMerchantId().equals(store.getMerchantId()))
        {
            //当前登录的商户不是查询到的商户，证明当前门店不是属于当前商户
            throw BizException.wrap("当前门店不是属于当前登录的商户，无法删除");
        }
        //删除
        this.removeById(store.getId());
        return true;
    }
}
