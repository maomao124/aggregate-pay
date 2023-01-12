package mao.aggregate_pay_merchant_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_merchant_api.dto.AppDTO;
import mao.aggregate_pay_merchant_service.service.AppService;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_service.controller
 * Class(类名): AppController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/12
 * Time(创建时间)： 19:56
 * Version(版本): 1.0
 * Description(描述)： app
 */

@RestController
@Api(tags = "应用")
@RequestMapping("/app")
public class AppController
{

    @Resource
    private AppService appService;

    /**
     * 创建应用
     *
     * @param merchantId 商户id
     * @param app        {@link AppDTO}
     * @return {@link R}<{@link AppDTO}>
     */
    @PostMapping("/{merchantId}")
    @ApiOperation("创建应用")
    public R<AppDTO> createApp(@PathVariable Long merchantId, @RequestBody AppDTO app)
    {
        return appService.createApp(merchantId, app);
    }
}
