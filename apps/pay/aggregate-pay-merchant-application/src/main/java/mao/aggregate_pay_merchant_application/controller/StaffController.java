package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_merchant_api.dto.StaffDTO;
import mao.aggregate_pay_merchant_api.dto.StoreDTO;
import mao.aggregate_pay_merchant_api.feign.StaffFeignClient;
import mao.aggregate_pay_merchant_application.handler.AssertResult;
import mao.aggregate_pay_merchant_application.utils.SecurityUtil;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
