package mao.sms_manage.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.sms_entity.dto.PlatformDTO;
import mao.sms_entity.entity.PlatformEntity;
import mao.sms_manage.service.PlatformService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.controller
 * Class(类名): PlatformController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/22
 * Time(创建时间)： 20:52
 * Version(版本): 1.0
 * Description(描述)： 接入平台
 */

@RestController
@RequestMapping("platform")
@Api(tags = {"接入平台"})
public class PlatformController extends BaseController
{

    /**
     * 平台服务
     */
    @Resource
    private PlatformService platformService;

    @GetMapping("page")
    @ApiOperation("分页")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "排序字段", value = "排序字段", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "排序方式", value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "startCreateTime", value = "开始时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "endCreateTime", value = "结束时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String")
            })
    public R<Page<PlatformEntity>> page(PlatformDTO platformDTO)
    {
        Page<PlatformEntity> page = getPage();
        LbqWrapper<PlatformEntity> wrapper = Wraps.lbQ();

        wrapper.like(StringUtils.isNotEmpty(platformDTO.getAccessKeyId()), PlatformEntity::getAccessKeyId, platformDTO.getAccessKeyId())
                .like(StringUtils.isNotEmpty(platformDTO.getAccessKeySecret()), PlatformEntity::getAccessKeySecret, platformDTO.getAccessKeySecret())
                .like(StringUtils.isNotEmpty(platformDTO.getIpAddr()), PlatformEntity::getIpAddr, platformDTO.getIpAddr())
                .like(StringUtils.isNotEmpty(platformDTO.getName()), PlatformEntity::getName, platformDTO.getName())
                .eq(platformDTO.getNeedAuth() != null, PlatformEntity::getNeedAuth, platformDTO.getNeedAuth())
                .eq(platformDTO.getIsActive() != null, PlatformEntity::getIsActive, platformDTO.getIsActive())
                .orderByDesc(PlatformEntity::getIsActive, PlatformEntity::getCreateTime);

        platformService.page(page, wrapper);
        return success(page);
    }
}
