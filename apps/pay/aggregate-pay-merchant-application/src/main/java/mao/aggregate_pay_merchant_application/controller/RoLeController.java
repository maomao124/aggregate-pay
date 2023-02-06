package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.Api;
import mao.tools_core.exception.BizException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.controller
 * Class(类名): RoLeController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/6
 * Time(创建时间)： 20:41
 * Version(版本): 1.0
 * Description(描述)： 商户平台‐角色管理
 */

@RestController
@Api(tags = "商户平台‐角色管理")
public class RoLeController
{
    /**
     * 得到当前角色列表
     *
     * @param tenantId 租户id
     * @return json
     */
    @GetMapping("/my/roles/tenants/{tenantId}")
    public String getRoleList(@PathVariable String tenantId)
    {
        throw BizException.wrap("功能未实现");
    }
}
