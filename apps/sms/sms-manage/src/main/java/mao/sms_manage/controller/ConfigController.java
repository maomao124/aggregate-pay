package mao.sms_manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.sms_entity.dto.ConfigDTO;
import mao.sms_entity.dto.ConfigUpdateOtherDTO;
import mao.sms_entity.dto.SignatureDTO;
import mao.sms_entity.dto.TemplateDTO;
import mao.sms_entity.entity.ConfigEntity;
import mao.sms_entity.entity.ConfigSignatureEntity;
import mao.sms_entity.entity.ConfigTemplateEntity;
import mao.sms_entity.entity.base.BaseEntity;
import mao.sms_manage.annotation.DefaultParams;
import mao.sms_manage.service.*;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.controller
 * Class(类名): ConfigController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/21
 * Time(创建时间)： 21:21
 * Version(版本): 1.0
 * Description(描述)： 通道配置
 */

@RestController
@RequestMapping("/config")
@Api(tags = "通道配置")
public class ConfigController extends BaseController
{

    @Resource
    private ConfigService configService;

    @Resource
    private ConfigSignatureService configSignatureService;

    @Resource
    private SignatureService signatureService;

    @Resource
    private ConfigTemplateService configTemplateService;

    @Resource
    private TemplateService templateService;

    @Resource
    private DozerUtils dozerUtils;

    /**
     * 分页查询
     *
     * @param configDTO {@link ConfigDTO}
     * @return {@link R}<{@link Page}<{@link ConfigEntity}>>
     */
    @GetMapping("/page")
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
    public R<Page<ConfigEntity>> page(ConfigDTO configDTO)
    {
        Page<ConfigEntity> page = getPage();
        LbqWrapper<ConfigEntity> wrapper = Wraps.lbQ();
        wrapper.like(ConfigEntity::getName, configDTO.getName())
                .like(ConfigEntity::getAccessKeyId, configDTO.getAccessKeyId())
                .like(ConfigEntity::getAccessKeySecret, configDTO.getAccessKeySecret())
                .eq(ConfigEntity::getChannelType, configDTO.getChannelType())
                .eq(ConfigEntity::getPlatform, configDTO.getPlatform())
                .eq(ConfigEntity::getDomain, configDTO.getDomain())
                .eq(ConfigEntity::getIsActive, configDTO.getIsActive())
                .eq(ConfigEntity::getIsEnable, configDTO.getIsEnable())
                .orderByAsc(ConfigEntity::getLevel);

        configService.page(page, wrapper);
        return success(page);
    }


    /**
     * 根据id查询通道信息
     *
     * @param id id
     * @return {@link R}<{@link ConfigDTO}>
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询通道信息")
    public R<ConfigDTO> get(@PathVariable("id") String id)
    {
        //查询
        ConfigEntity configEntity = configService.getById(id);
        //如果为空
        if (null == configEntity || StringUtils.isEmpty(configEntity.getId()))
        {
            //响应失败
            return R.fail("要查询的id不存在");
        }
        //不为空，转换
        ConfigDTO configDTO = dozerUtils.map(configEntity, ConfigDTO.class);

        Map<String, String> params = new HashMap<String, String>();
        params.put("configId", id);
        List<SignatureDTO> signatureDtos = signatureService.customList(params);
        //configDTO.setSignatureDTOS(signatureDtos);
        configDTO.setSignatureIds(signatureDtos.stream().map(BaseEntity::getId).collect(Collectors.toList()));

        List<TemplateDTO> templateDtos = templateService.customList(params);
        //configDTO.setTemplateDTOS(templateDtos);
        configDTO.setTemplateIds(templateDtos.stream().map(BaseEntity::getId).collect(Collectors.toList()));

        return R.success(configDTO);
    }

    /**
     * 保存
     *
     * @param entity {@link ConfigDTO}
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping
    @ApiOperation("保存")
    @DefaultParams
    @Transactional
    public R<Boolean> save(@RequestBody ConfigDTO entity)
    {
        //判断是否重复
        if (configService.getByName(entity.getName()) != null)
        {
            return R.fail("通道名称重复");
        }
        //获取通道优先级
        configService.getNewLevel(entity);

        //保存通道信息
        boolean save = configService.save(entity);
        if (!save)
        {
            return R.fail("保存失败");
        }
        //通知短信发送服务、更新通道优先级
        configService.sendUpdateMessage();
        //返回
        return R.success();
    }


    /**
     * 排序
     *
     * @param ids id列表
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping("/level")
    @ApiOperation("排序")
    @Transactional
    public R<Boolean> level(@RequestBody List<String> ids)
    {
        for (int i = 0; i < ids.size(); i++)
        {
            configService.update(Wraps.<ConfigEntity>lbU()
                    .eq(BaseEntity::getId, ids.get(i))
                    .eq(ConfigEntity::getIsEnable, 1)
                    .set(ConfigEntity::getLevel, (i + 1)));
        }
        configService.sendUpdateMessage();
        return R.success();
    }

    /**
     * 更新
     *
     * @param entity {@link ConfigDTO}
     * @return {@link R}<{@link Boolean}>
     */
    @PutMapping
    @ApiOperation("修改")
    @DefaultParams
    @Transactional
    public R<Boolean> update(@RequestBody ConfigDTO entity)
    {
        ConfigEntity configEntity = configService.getByName(entity.getName());
        if (configEntity != null && !configEntity.getId().equals(entity.getId()))
        {
            return R.fail("通道名称重复");
        }
        //根据id修改配置信息
        configService.updateById(entity);
        //更新通道和签名关系
        configSignatureService.merge(entity);
        //更新通道和短信模板关系
        configTemplateService.merge(entity);
        //通知短信发送服务修改通道优先级
        configService.sendUpdateMessage();
        //返回成功
        return R.success();
    }


    /**
     * 关联内修改
     *
     * @param dto {@link ConfigUpdateOtherDTO}
     * @return {@link R}<{@link Boolean}>
     */
    @Transactional
    @PutMapping("/other")
    @ApiOperation("关联内修改")
    public R<Boolean> updateOther(@RequestBody ConfigUpdateOtherDTO dto)
    {
        if (org.apache.commons.lang3.StringUtils.isNotBlank(dto.getSignatureId()))
        {
            configSignatureService.update(Wraps.<ConfigSignatureEntity>lbU()
                    .eq(ConfigSignatureEntity::getConfigId, dto.getConfigId())
                    .eq(ConfigSignatureEntity::getSignatureId, dto.getSignatureId())
                    .set(ConfigSignatureEntity::getConfigSignatureCode, dto.getConfigSignatureCode()));
        }
        if (org.apache.commons.lang3.StringUtils.isNotBlank(dto.getTemplateId()))
        {
            configTemplateService.update(Wraps.<ConfigTemplateEntity>lbU()
                    .eq(ConfigTemplateEntity::getConfigId, dto.getConfigId())
                    .eq(ConfigTemplateEntity::getTemplateId, dto.getTemplateId())
                    .set(ConfigTemplateEntity::getConfigTemplateCode, dto.getConfigTemplateCode()));
        }
        return R.success();
    }

    /**
     * 删除
     *
     * @param ids id列表
     * @return {@link R}<{@link Boolean}>
     */
    @Transactional
    @DeleteMapping
    @ApiOperation("删除")
    public R<Boolean> delete(@RequestBody List<String> ids)
    {
        //批量删除
        configService.removeByIds(ids);
        //删除关联表数据
        ids.forEach(item ->
        {
            LambdaQueryWrapper<ConfigSignatureEntity> signatureWrapper = new LambdaQueryWrapper<>();
            signatureWrapper.eq(ConfigSignatureEntity::getConfigId, item);
            configSignatureService.remove(signatureWrapper);

            LambdaQueryWrapper<ConfigTemplateEntity> templateWrapper = new LambdaQueryWrapper<>();
            templateWrapper.eq(ConfigTemplateEntity::getConfigId, item);
            configTemplateService.remove(templateWrapper);
        });

        configService.sendUpdateMessage();
        return R.success();
    }
}
