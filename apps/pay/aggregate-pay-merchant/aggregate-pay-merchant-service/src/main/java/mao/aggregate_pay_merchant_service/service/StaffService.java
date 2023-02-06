package mao.aggregate_pay_merchant_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_service.entity.Staff;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.service
 * Interface(接口名): StaffService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/23
 * Time(创建时间)： 13:31
 * Version(版本): 1.0
 * Description(描述)： 员工服务
 */

public interface StaffService extends IService<Staff>
{
    /**
     * 分页条件查询商户下员工
     *
     * @param staffDTO 员工dto
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link StaffDTO}>
     */
    PageVO<StaffDTO> queryStaffByPage(StaffDTO staffDTO, Integer pageNo, Integer pageSize);


    /**
     * 保存员工信息
     *
     * @param staffDTO 员工dto
     * @return 员工dto
     */
    StaffDTO saveStaff(StaffDTO staffDTO);
}
