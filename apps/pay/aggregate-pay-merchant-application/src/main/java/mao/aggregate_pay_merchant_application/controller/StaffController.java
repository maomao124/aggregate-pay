package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_common.utils.PhoneUtil;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_api.feign.StaffFeignClient;
import mao.aggregate_pay_merchant_application.handler.AssertResult;
import mao.aggregate_pay_merchant_application.utils.SecurityUtil;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_log.annotation.SysLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.controller
 * Class(类名): StaffController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/5
 * Time(创建时间)： 21:42
 * Version(版本): 1.0
 * Description(描述)： 商户平台‐员工管理
 */

@Slf4j
@RestController
@Api(tags = "商户平台‐员工管理")
public class StaffController
{

    @Resource
    private StaffFeignClient staffFeignClient;

    /**
     * 分页条件查询商户下员工
     *
     * @param pageNo   页号
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link StaffDTO}>
     */
    @ApiOperation("分页条件查询商户下员工")
    @ApiImplicitParams
            (
                    {
                            @ApiImplicitParam(name = "pageNo", value = "页码", required = true, dataType = "int",
                                    paramType = "query"),
                            @ApiImplicitParam(name = "pageSize", value = "每页记录数", required = true, dataType =
                                    "int", paramType = "query")
                    }
            )
    @PostMapping("/my/staffs/page")
    public PageVO<StaffDTO> queryStaffByPage(@RequestParam Integer pageNo, @RequestParam Integer pageSize)
    {
        //检查页面大小
        if (pageSize > 100)
        {
            //不能超过100
            pageSize = 100;
        }
        if (pageSize < 5)
        {
            //不能小于5
            pageSize = 5;
        }
        //获得商户id
        Long merchantId = SecurityUtil.getMerchantIdThrowsException();
        //StoreDTO是为未来预留
        StaffDTO staffDTO = new StaffDTO();
        staffDTO.setMerchantId(merchantId);
        //远程调用
        R<PageVO<StaffDTO>> r = staffFeignClient.queryStaffByPage(staffDTO, pageNo, pageSize);
        //断言结果
        AssertResult.handler(r);
        //返回
        return r.getData();
    }


    /**
     * 保存员工信息
     *
     * @param staffDTO 员工dto
     * @return 员工dto
     */
    @SysLog(value = "保存员工信息", recordResponseParam = false)
    @ApiOperation("保存员工信息")
    @PostMapping("/my/staffs")
    public StaffDTO saveStaff(@RequestBody StaffDTO staffDTO)
    {
        //得到当前登录的商户id
        Long id = SecurityUtil.getMerchantIdThrowsException();
        //设置商户id
        staffDTO.setMerchantId(id);

        if (StringUtils.isBlank(staffDTO.getUsername()))
        {
            throw BizException.wrap("用户名不能为空");
        }
        if (StringUtils.isBlank(staffDTO.getMobile()))
        {
            throw BizException.wrap("手机号不能为空");
        }
        if (StringUtils.isBlank(staffDTO.getFullName()))
        {
            throw BizException.wrap("姓名不能为空");
        }
        if (StringUtils.isBlank(staffDTO.getPosition()))
        {
            throw BizException.wrap("职位不能为空");
        }
        if (PhoneUtil.isMatches(staffDTO.getMobile()))
        {
            throw BizException.wrap("手机号格式不正确");
        }
        //远程调用
        R<StaffDTO> r = staffFeignClient.saveStaff(staffDTO);
        //断言结果
        AssertResult.handler(r);
        //返回
        return r.getData();
    }


    /**
     * 更新员工信息，前端并没有传递id过来，功能暂时未实现
     *
     * @param staffDTO 员工dto
     * @return 员工dto
     */
    @SysLog(value = "更新员工信息")
    @ApiOperation("更新员工信息")
    @PutMapping("/my/staffs")
    public StaffDTO updateStaff(@RequestBody StaffDTO staffDTO)
    {
        throw BizException.wrap("功能未实现");
    }


    /**
     * 删除员工信息
     *
     * @return 员工dto
     */
    @SysLog(value = "删除员工信息")
    @ApiOperation("删除员工信息")
    @DeleteMapping("/my/staffs/{staffId}")
    public Boolean deleteStaff(@PathVariable Long staffId)
    {
        StaffDTO staffDTO = new StaffDTO();
        //得到当前登录的商户id
        Long id = SecurityUtil.getMerchantIdThrowsException();
        //设置商户id
        staffDTO.setMerchantId(id);
        //设置id
        staffDTO.setId(staffId);
        //远程调用
        R<Boolean> r = staffFeignClient.deleteStaff(staffDTO);
        //断言结果
        AssertResult.handler(r);
        //返回
        return r.getData();
    }
}
