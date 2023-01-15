package mao.aggregate_pay_transaction_service.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_transaction_api.dto.PlatformChannelDTO;
import mao.aggregate_pay_transaction_service.service.AppPlatformChannelService;
import mao.aggregate_pay_transaction_service.service.PlatformChannelService;
import mao.tools_core.base.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.controller
 * Class(类名): PlatformChannelController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 23:06
 * Version(版本): 1.0
 * Description(描述)： 服务类型
 */

@Api(value = "服务类型", tags = "服务类型")
@RestController
@RequestMapping("/PlatformChannel")
public class PlatformChannelController
{
    @Resource
    private PlatformChannelService platformChannelService;

    @Resource
    private AppPlatformChannelService appPlatformChannelService;


    /**
     * 获取平台所有服务类型
     *
     * @return {@link R}<{@link List}<{@link PlatformChannelDTO}>>
     */
    @GetMapping
    @ApiOperation("获取平台所有服务类型")
    public R<List<PlatformChannelDTO>> queryAll()
    {
        return platformChannelService.queryAll();
    }


    /**
     * 为app绑定平台服务类型
     *
     * @param appId                应用id
     * @param platformChannelCodes 平台服务类型
     */
    @PutMapping("/bind")
    @ApiOperation("为app绑定平台服务类型")
    public R<Boolean> bindPlatformChannelForApp(@RequestParam String appId, @RequestParam String platformChannelCodes)
    {
        platformChannelService.bindPlatformChannelForApp(appId, platformChannelCodes);
        return R.success();
    }

    /**
     * 查询应用是否已经绑定了某个服务类型
     *
     * @param appId           应用程序id
     * @param platformChannel 平台通道
     * @return boolean
     */
    @GetMapping("/bind")
    @ApiOperation("查询应用是否已经绑定了某个服务类型")
    public R<Boolean> queryAppBindPlatformChannel(@RequestParam String appId, @RequestParam String platformChannel)
    {
        return R.success(appPlatformChannelService.queryAppBindPlatformChannel(appId, platformChannel));
    }
}
