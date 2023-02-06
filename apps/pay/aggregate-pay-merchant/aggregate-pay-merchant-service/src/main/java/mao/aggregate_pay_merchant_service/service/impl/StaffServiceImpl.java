package mao.aggregate_pay_merchant_service.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_service.entity.Staff;
import mao.aggregate_pay_merchant_service.entity.Store;
import mao.aggregate_pay_merchant_service.mapper.StaffMapper;
import mao.aggregate_pay_merchant_service.service.StaffService;
import mao.tools_core.exception.BizException;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service.impl
 * Class(类名): StaffServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/23
 * Time(创建时间)： 13:31
 * Version(版本): 1.0
 * Description(描述)： 员工服务实现类
 */

@Slf4j
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService
{

    @Resource
    private DozerUtils dozerUtils;

    @Override
    public PageVO<StaffDTO> queryStaffByPage(StaffDTO staffDTO, Integer pageNo, Integer pageSize)
    {
        IPage<Staff> page = new Page<>(pageNo, pageSize);
        //查询
        if (staffDTO != null && staffDTO.getMerchantId() != null)
        {
            //查询
            IPage<Staff> iPage = this.page(page, Wraps.<Staff>lbQ()
                    .eq(Staff::getMerchantId, staffDTO.getMerchantId()));
            //转换
            List<StaffDTO> storeDTOList = dozerUtils.mapList(iPage.getRecords(), StaffDTO.class);
            //返回
            return new PageVO<>(storeDTOList, iPage.getTotal(), pageNo, pageSize);
        }
        else
        {
            //查询
            IPage<Staff> iPage = this.page(page);
            //转换
            List<StaffDTO> storeDTOList = dozerUtils.mapList(iPage.getRecords(), StaffDTO.class);
            //返回
            return new PageVO<>(storeDTOList, iPage.getTotal(), pageNo, pageSize);
        }
    }

    @Override
    public StaffDTO saveStaff(StaffDTO staffDTO)
    {
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
        //保存
        boolean save = this.save(staff);
        if (!save)
        {
            throw BizException.wrap("员工信息保存失败");
        }
        //转换
        dozerUtils.map(staff, staffDTO);
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
        int count = this.count(Wraps.<Staff>lbQ()
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
        int count = this.count(Wraps.<Staff>lbQ()
                .eq(Staff::getUsername, userName)
                .eq(Staff::getMerchantId, merchantId));
        return count > 0;
    }


    @Override
    public StaffDTO updateStaff(StaffDTO staffDTO)
    {
        throw BizException.wrap("功能未实现");
    }

    @Override
    public Boolean deleteStaff(StaffDTO staffDTO)
    {
        //得到id
        Long id = staffDTO.getId();
        //当前登录的商户id
        Long merchantId = staffDTO.getMerchantId();
        //查询员工信息
        Staff staff = this.getById(id);
        if (staff == null)
        {
            //查询结果为空，不需要删除
            return false;
        }
        //查询结果不为空
        //判断是否属于当前商户下的员工
        if (!merchantId.equals(staff.getMerchantId()))
        {
            throw BizException.wrap("当前员工不属于当前商户");
        }
        //删除
        this.removeById(id);
        return true;
    }
}
