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
}
