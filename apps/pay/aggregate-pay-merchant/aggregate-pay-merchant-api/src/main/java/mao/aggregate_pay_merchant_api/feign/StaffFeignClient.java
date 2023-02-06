package mao.aggregate_pay_merchant_api.feign;

import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_api.feign
 * Interface(接口名): StaffFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/5
 * Time(创建时间)： 22:02
 * Version(版本): 1.0
 * Description(描述)： feign接口
 */

@FeignClient(value = "aggregate-pay-merchant-service", path = "/staff")
public interface StaffFeignClient
{
    /**
     * 分页条件查询商户下员工
     *
     * @param staffDTO 员工dto
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link StaffDTO}>
     */
    @ApiOperation("分页条件查询商户下员工")
    @PostMapping("/queryStaffByPage/{pageNo}/{pageSize}")
    R<PageVO<StaffDTO>> queryStaffByPage(@RequestBody StaffDTO staffDTO,
                                         @PathVariable Integer pageNo,
                                         @PathVariable Integer pageSize);


    /**
     * 保存员工信息
     *
     * @param staffDTO 员工dto
     * @return 员工dto
     */
    @ApiOperation("保存员工信息")
    @PostMapping("/my/staffs")
    R<StaffDTO> saveStaff(@RequestBody StaffDTO staffDTO);
}
