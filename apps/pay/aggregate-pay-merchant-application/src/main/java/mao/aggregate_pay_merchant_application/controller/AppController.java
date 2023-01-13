package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_merchant_api.dto.AppDTO;
import mao.aggregate_pay_merchant_api.feign.AppFeignClient;
import mao.aggregate_pay_merchant_application.handler.AssertResult;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.apache.catalina.security.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.controller
 * Class(类名): AppController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/12
 * Time(创建时间)： 20:10
 * Version(版本): 1.0
 * Description(描述)： 应用管理
 */

@RestController
@Api(tags = "商户平台‐应用管理")
public class AppController
{
    @Resource
    private AppFeignClient appFeignClient;

    /**
     * 创建应用
     *
     * @param app {@link AppDTO}
     * @return {@link AppDTO}
     */
    @ApiOperation("商户创建应用")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "app", value = "应用信息", required = true, dataType = "AppDTO", paramType = "body")
            })
    @PostMapping(value = "/my/apps")
    public AppDTO createApp(@RequestBody AppDTO app)
    {
        //校验
        if (StringUtils.isBlank(app.getAppName()))
        {
            throw BizException.wrap("应用名称为空");
        }
        if (StringUtils.isBlank(app.getPublicKey()))
        {
            throw BizException.wrap("无法获取到公钥");
        }
        //todo：暂时
        //不能使用前端传过来的商户id
        Long merchantId = 124619633188667425L;

        //远程调用
        R<AppDTO> r = appFeignClient.createApp(merchantId, app);
        //断言
        AssertResult.handler(r);
        //返回
        return r.getData();
    }


    /**
     * 查询商户下的应用列表
     *
     * @return {@link List}<{@link AppDTO}>
     */
    @ApiOperation("查询商户下的应用列表")
    @GetMapping(value = "/my/apps")
    public List<AppDTO> queryMyApps()
    {
        //商户id
        //todo：暂时
        Long merchantId = 124619633188667425L;
        //远程调用
        R<List<AppDTO>> r = appFeignClient.queryAppByMerchantId(merchantId);
        //断言
        AssertResult.handler(r);
        //返回
        return r.getData();
    }

    /**
     * 根据应用id查询应用信息
     *
     * @param appId 应用id
     * @return {@link AppDTO}
     */
    @ApiOperation("根据应用id查询应用信息")
    @ApiImplicitParam(value = "应用id", name = "appId", dataType = "String", paramType = "path")
    @GetMapping(value = "/my/apps/{appId}")
    public AppDTO getApp(@PathVariable("appId") String appId)
    {
        //查询
        R<AppDTO> r = appFeignClient.getAppById(appId);
        //断言
        AssertResult.handler(r);
        //返回
        return r.getData();
    }
}