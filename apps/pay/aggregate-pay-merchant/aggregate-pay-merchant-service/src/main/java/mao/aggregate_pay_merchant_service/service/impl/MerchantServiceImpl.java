package mao.aggregate_pay_merchant_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_service.entity.Merchant;
import mao.aggregate_pay_merchant_service.entity.Staff;
import mao.aggregate_pay_merchant_service.entity.Store;
import mao.aggregate_pay_merchant_service.entity.StoreStaff;
import mao.aggregate_pay_merchant_service.mapper.MerchantMapper;
import mao.aggregate_pay_merchant_service.service.MerchantService;
import mao.aggregate_pay_merchant_service.service.StaffService;
import mao.aggregate_pay_merchant_service.service.StoreService;
import mao.aggregate_pay_merchant_service.service.StoreStaffService;
import mao.aggregate_pay_user_api.dto.tenant.CreateTenantRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenantDTO;
import mao.aggregate_pay_user_api.feign.TenantFeignClientV2;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_redis_cache.utils.RedisUtils;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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

    @Resource
    private StaffService staffService;

    @Resource
    private StoreStaffService storeStaffService;

    @Resource
    private TenantFeignClientV2 tenantFeignClient;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public MerchantDTO getMerchantById(Long merchantId)
    {
        return redisUtils.query("pay:MerchantDTO:getMerchantById:",
                "pay:MerchantDTO:getMerchantById:lock:",
                merchantId, MerchantDTO.class, new Function<Long, MerchantDTO>()
                {
                    @Override
                    public MerchantDTO apply(Long aLong)
                    {
                        //查询
                        Merchant merchant = getById(merchantId);
                        //转换，并返回
                        return dozerUtils.map(merchant, MerchantDTO.class);
                    }
                }, 180L, TimeUnit.MINUTES, 120);

    }

//    @Override
//    public MerchantDTO createMerchant(MerchantDTO merchantDTO)
//    {
//        //校验商户手机号的唯一性,根据商户的手机号查询商户表，如果存在记录则说明已有相同的手机号重复
//        int count = this.count(Wraps.<Merchant>lbQ().eq(Merchant::getMobile, merchantDTO.getMobile()));
//        if (count > 0)
//        {
//            throw BizException.wrap("手机号重复");
//        }
//        //构建商户
//        Merchant merchant = new Merchant();
//        //设置审核状态
//        merchant.setAuditStatus("0");
//        //设置手机号
//        merchant.setMobile(merchantDTO.getMobile());
//        //保存
//        this.save(merchant);
//        //保存id信息
//        merchantDTO.setId(merchant.getId());
//        //返回
//        return merchantDTO;
//    }


    @Override
    @Transactional
    public MerchantDTO createMerchant(MerchantDTO merchantDTO)
    {
        //校验商户手机号的唯一性,根据商户的手机号查询商户表，如果存在记录则说明已有相同的手机号重复
        int count = this.count(Wraps.<Merchant>lbQ().eq(Merchant::getMobile, merchantDTO.getMobile()));
        if (count > 0)
        {
            throw BizException.wrap("手机号重复");
        }
        //构建调用参数
        CreateTenantRequestDTO createTenantRequestDTO = new CreateTenantRequestDTO();
        //手机号
        createTenantRequestDTO.setMobile(merchantDTO.getMobile());
        //用户名
        createTenantRequestDTO.setUsername(merchantDTO.getUsername());
        //密码
        createTenantRequestDTO.setPassword(merchantDTO.getPassword());
        //租户类型
        createTenantRequestDTO.setTenantTypeCode("aggregate-pay-merchant");
        //套餐，根据套餐进行分配权限
        createTenantRequestDTO.setBundleCode("aggregate-pay-merchant");
        //租户名称，和账号名一样
        createTenantRequestDTO.setName(merchantDTO.getUsername());
        //调用SaaS接口
        //如果租户在SaaS已经存在，SaaS直接 返回此租户的信息，否则进行添加
        R<TenantDTO> r = tenantFeignClient.createTenantAndInit(createTenantRequestDTO);
        if (r.getIsError())
        {
            //错误，抛出异常
            throw BizException.wrap(r.getCode(), r.getMsg());
        }
        //无错误，取数据
        TenantDTO tenantDTO = r.getData();
        //获取租户的id
        if (tenantDTO == null || tenantDTO.getId() == null)
        {
            //空
            throw BizException.wrap("租户不存在");
        }
        //租户的id
        Long tenantId = tenantDTO.getId();
        //租户id在商户表唯一
        //根据租户id从商户表查询，如果存在记录则不允许添加商户
        int count1 = this.count(Wraps.<Merchant>lbQ().eq(Merchant::getTenantId, tenantId));
        //判断结果
        if (count1 > 0)
        {
            //存在
            throw BizException.wrap("商户在当前租户下已经注册，不可重复注册");
        }
        //对象转换
        Merchant merchant = dozerUtils.map(merchantDTO, Merchant.class);
        //设置所对应的租户的Id
        merchant.setTenantId(tenantId);
        //审核状态为0-未进行资质申请
        merchant.setAuditStatus("0");
        //去掉id
        merchant.setId(null);
        //插入数据
        boolean save = this.save(merchant);
        //判断结果
        if (!save)
        {
            //保存失败
            throw BizException.wrap("商户数据保存失败");
        }
        //新增门店
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStoreName("根门店");
        //商户id
        storeDTO.setMerchantId(merchant.getId());
        StoreDTO store = createStore(storeDTO);

        //新增员工
        StaffDTO staffDTO = new StaffDTO();
        //手机号
        staffDTO.setMobile(merchantDTO.getMobile());
        //账号
        staffDTO.setUsername(merchantDTO.getUsername());
        //员所属门店id
        staffDTO.setStoreId(store.getId());
        //商户id
        staffDTO.setMerchantId(merchant.getId());
        //创建
        StaffDTO staff = createStaff(staffDTO);

        //为门店设置管理员
        bindStaffToStore(store.getId(), staff.getId());

        //转换
        dozerUtils.map(merchant, merchantDTO);
        //返回
        //让缓存过期
        String redisKey = "pay:MerchantDTO:getMerchantById:" + merchant.getId();
        stringRedisTemplate.delete(redisKey);
        String redisKey2 = "pay:MerchantDTO:getMerchantByTenantId:" + tenantId;
        stringRedisTemplate.delete(redisKey2);
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
        //让缓存过期
        String redisKey = "pay:MerchantDTO:getMerchantById:" + merchant.getId();
        stringRedisTemplate.delete(redisKey);
        String redisKey2 = "pay:MerchantDTO:getMerchantByTenantId:" + merchant.getTenantId();
        stringRedisTemplate.delete(redisKey2);
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

    @Override
    public StaffDTO createStaff(StaffDTO staffDTO)
    {
        //判断是否为空
        if (StringUtils.isBlank(staffDTO.getMobile()))
        {
            //空
            throw BizException.wrap("手机号为空");
        }
        //判断是否为空
        if (StringUtils.isBlank(staffDTO.getUsername()))
        {
            //空
            throw BizException.wrap("用户名为空");
        }
        //根据手机号和商户id判断员工是否已在指定商户存在
        if (isExistStaffByMobile(staffDTO.getMobile(), staffDTO.getMerchantId()))
        {
            //已经存在
            throw BizException.wrap("手机号已经存在");
        }
        //根据账号判断员工是否已在指定商户存在
        if (isExistStaffByUserName(staffDTO.getUsername(), staffDTO.getMerchantId()))
        {
            //存在
            throw BizException.wrap("用户名已经存在");
        }
        //转换
        Staff staff = dozerUtils.map(staffDTO, Staff.class);
        //去掉id
        staff.setId(null);
        //保存
        staffService.save(staff);
        //设置id
        staffDTO.setId(staff.getId());
        //返回
        return staffDTO;
    }

    /**
     * 根据手机号和商户id判断员工是否已在指定商户存在
     *
     * @param mobile     手机号
     * @param merchantId 商人id
     * @return boolean
     */
    private boolean isExistStaffByMobile(String mobile, Long merchantId)
    {
        int count = staffService.count(Wraps.<Staff>lbQ()
                .eq(Staff::getMobile, mobile)
                .eq(Staff::getMerchantId, merchantId));
        return count > 0;
    }

    /**
     * 根据账号判断员工是否已在指定商户存在
     *
     * @param userName   用户名
     * @param merchantId 商人id
     * @return boolean
     */
    private boolean isExistStaffByUserName(String userName, Long merchantId)
    {
        int count = staffService.count(Wraps.<Staff>lbQ()
                .eq(Staff::getUsername, userName)
                .eq(Staff::getMerchantId, merchantId));
        return count > 0;
    }


    @Override
    public void bindStaffToStore(Long storeId, Long staffId)
    {
        //构建实体类对象
        StoreStaff storeStaff = new StoreStaff();
        storeStaff.setStaffId(staffId);
        storeStaff.setStoreId(storeId);
        //保存
        boolean save = storeStaffService.save(storeStaff);
        if (!save)
        {
            throw BizException.wrap("为门店设置管理员失败");
        }
    }

    @Override
    public MerchantDTO getMerchantByTenantId(Long tenantId)
    {
        MerchantDTO merchantDTO = redisUtils.query("pay:MerchantDTO:getMerchantByTenantId:",
                "pay:MerchantDTO:getMerchantByTenantId:lock:",
                tenantId, MerchantDTO.class, new Function<Long, MerchantDTO>()
                {
                    @Override
                    public MerchantDTO apply(Long aLong)
                    {
                        //查询
                        Merchant merchant = getOne(Wraps.<Merchant>lbQ().eq(Merchant::getTenantId, tenantId));
                        //转换
                        MerchantDTO merchantDTO = dozerUtils.map(merchant, MerchantDTO.class);
                        //返回
                        return merchantDTO;
                    }
                }, 180L, TimeUnit.MINUTES, 120);
        //返回
        return merchantDTO;
    }
}
