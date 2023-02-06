package mao.aggregate_pay_merchant_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_service.service.StaffService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.controller
 * Class(类名): StaffController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/5
 * Time(创建时间)： 21:56
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
@Api(tags = "员工")
@RequestMapping("/staff")
public class StaffController extends BaseController
{

    @Resource
    private StaffService staffService;


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
    public R<PageVO<StaffDTO>> queryStaffByPage(@RequestBody StaffDTO staffDTO,
                                                @PathVariable Integer pageNo,
                                                @PathVariable Integer pageSize)
    {
        PageVO<StaffDTO> staffDTOPageVO = staffService.queryStaffByPage(staffDTO, pageNo, pageSize);
        return success(staffDTOPageVO);
    }


    /**
     * 保存员工信息
     *
     * @param staffDTO 员工dto
     * @return 员工dto
     */
    @ApiOperation("保存员工信息")
    @PostMapping("/my/staffs")
    public R<StaffDTO> saveStaff(@RequestBody StaffDTO staffDTO)
    {
        return success(staffService.saveStaff(staffDTO));
    }
}
