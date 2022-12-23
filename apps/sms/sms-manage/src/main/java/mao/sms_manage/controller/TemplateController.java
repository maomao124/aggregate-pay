package mao.sms_manage.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.sms_entity.dto.TemplateDTO;
import mao.sms_entity.entity.ReceiveLogEntity;
import mao.sms_entity.entity.TemplateEntity;
import mao.sms_manage.annotation.DefaultParams;
import mao.sms_manage.service.ReceiveLogService;
import mao.sms_manage.service.TemplateService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.controller
 * Class(类名): TemplateController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/23
 * Time(创建时间)： 14:11
 * Version(版本): 1.0
 * Description(描述)： 模板
 */

@RestController
@RequestMapping("/template")
@Api(tags = "模板")
public class TemplateController extends BaseController
{
    @Resource
    private TemplateService templateService;

    @Resource
    private ReceiveLogService receiveLogService;


    /**
     * 分页查询
     *
     * @param templateDTO {@link TemplateDTO}
     * @return {@link R}<{@link Page}<{@link TemplateEntity}>>
     */
    @GetMapping("/page")
    @ApiOperation("分页查询")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "排序字段", value = "排序字段", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "排序方式", value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "startCreateTime", value = "开始时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "endCreateTime", value = "结束时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String")
            })
    public R<Page<TemplateEntity>> page(TemplateDTO templateDTO)
    {
        Page<TemplateEntity> page = getPage();

        templateService.page(page, Wraps.<TemplateEntity>lbQ()
                .like(TemplateEntity::getName, templateDTO.getName())
                .like(TemplateEntity::getCode, templateDTO.getCode())
                .like(TemplateEntity::getContent, templateDTO.getContent())
                .orderByDesc(TemplateEntity::getCreateTime));

        return R.success(page);
    }


    /**
     * 自定义分页
     *
     * @param templateDTO {@link TemplateDTO}
     * @return {@link R}<{@link Page}<{@link TemplateDTO}>>
     */
    @GetMapping("/customPage")
    @ApiOperation("自定义分页")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "排序字段", value = "排序字段", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "排序方式", value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "startCreateTime", value = "开始时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "endCreateTime", value = "结束时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String")
            })
    public R<Page<TemplateDTO>> customPage(TemplateDTO templateDTO)
    {
        Page<TemplateDTO> page = getPage();

        Map<String, Object> params = new HashMap<>();
        params.put("name", templateDTO.getName());
        params.put("code", templateDTO.getCode());
        params.put("configId", templateDTO.getConfigId());

        templateService.customPage(page, params);
        return R.success(page);
    }


    /**
     * 查询全部
     *
     * @param templateDTO {@link TemplateDTO}
     * @return {@link R}<{@link List}<{@link TemplateEntity}>>
     */
    @GetMapping("/list")
    @ApiOperation("查询全部")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "排序字段", value = "排序字段", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "排序方式", value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
            })
    public R<List<TemplateEntity>> list(TemplateDTO templateDTO)
    {
        List<TemplateEntity> list = templateService.list(Wraps.<TemplateEntity>lbQ()
                .like(TemplateEntity::getName, templateDTO.getName())
                .like(TemplateEntity::getCode, templateDTO.getCode())
                .like(TemplateEntity::getContent, templateDTO.getContent())
                .orderByDesc(TemplateEntity::getCreateTime));
        return R.success(list);
    }


    /**
     * 根据id查询
     *
     * @param id id
     * @return {@link R}<{@link TemplateEntity}>
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询")
    public R<TemplateEntity> get(@PathVariable("id") String id)
    {
        TemplateEntity templateEntity = templateService.getById(id);
        return R.success(templateEntity);
    }


    /**
     * 获取参数信息
     *
     * @param code 代码
     * @return {@link R}<{@link Map}<{@link String}, {@link Object}>>
     */
    @GetMapping("/paramFields")
    @ApiOperation("获取参数信息")
    public R<Map<String, Object>> paramFields(@RequestParam String code)
    {
        TemplateEntity template = templateService.getByCode(code);
        char[] charArray = template.getContent().toCharArray();
        boolean flag = false;
        List<String> fields = new ArrayList<>();
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < charArray.length; i++)
        {
            if (charArray[i] == '{' && i >= 1 && charArray[i - 1] == '$')
            {
                flag = true;
                continue;
            }
            if (charArray[i] == '}' && flag)
            {
                fields.add(stringBuffer.toString());
                stringBuffer.setLength(0);
                flag = false;
                continue;
            }
            if (flag)
            {
                stringBuffer.append(charArray[i]);
            }
        }
        Map<String, Object> result = new HashMap<>();
        result.put("data", fields);
        result.put("content", template.getContent());
        return R.success(result);
    }


    /**
     * 保存
     *
     * @param entity {@link TemplateEntity}
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping
    @ApiOperation("保存")
    @DefaultParams
    @Transactional
    public R<Boolean> save(@RequestBody TemplateEntity entity)
    {
        String code = templateService.getNextCode();
        entity.setCode(code);
        if (templateService.getByName(entity.getName()) != null)
        {
            return R.fail("模板名称重复");
        }
        boolean save = templateService.save(entity);
        if (!save)
        {
            return R.fail("保存失败");
        }
        return R.success();
    }


    /**
     * 构建模板内容
     *
     * @param entity {@link TemplateEntity}
     * @return {@link R}<{@link String}>
     */
    @PostMapping("build")
    @ApiOperation("构建模板内容")
    @DefaultParams
    public R<String> build(@RequestBody TemplateEntity entity)
    {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNotBlank(entity.getContent()) && entity.getContent().startsWith("["))
        {
            JSONArray jsonArray = JSON.parseArray(entity.getContent());
            for (int i = 0; i < jsonArray.size(); i++)
            {
                jsonObject.putAll(jsonArray.getJSONObject(i));
            }
        }
        TemplateEntity templateEntity = templateService.getByCode(entity.getCode());
        if (templateEntity == null || CollectionUtils.isEmpty(jsonObject) || StringUtils.isBlank(templateEntity.getContent()))
        {
            return R.fail("参数异常");
        }
        String content = templateEntity.getContent();
        for (String key : jsonObject.keySet())
        {
            content = content.replaceAll("\\$\\{" + key + "}", jsonObject.getString(key));
        }
        return R.success(content);
    }


    /**
     * 更新
     *
     * @param entity {@link TemplateEntity}
     * @return {@link R}<{@link Boolean}>
     */
    @PutMapping
    @ApiOperation("修改")
    @DefaultParams
    @Transactional
    public R<Boolean> update(@RequestBody TemplateEntity entity)
    {
        TemplateEntity template = templateService.getByName(entity.getName());
        if (template != null && !template.getId().equals(entity.getId()))
        {
            return R.fail("模板名称重复");
        }
        boolean update = templateService.updateById(entity);
        if (!update)
        {
            return R.fail("更新失败");
        }
        return R.success();
    }


    /**
     * 删除
     *
     * @param ids id列表
     * @return {@link R}<{@link List}<{@link String}>>
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R<List<String>> delete(@RequestBody List<String> ids)
    {
        List<String> codes = new ArrayList<>();
        List<String> nids = new ArrayList<>();
        for (String id : ids)
        {
            TemplateEntity template = templateService.getById(id);
            if (template == null)
            {
                continue;
            }
            LambdaQueryWrapper<ReceiveLogEntity> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ReceiveLogEntity::getTemplate, template.getCode());
            List<ReceiveLogEntity> logs = receiveLogService.list(wrapper);
            if (logs.size() > 0)
            {
                codes.add(template.getCode());
            }
            else
            {
                nids.add(id);
            }
        }
        if (nids.size() > 0)
        {
            templateService.removeByIds(nids);
        }
        return R.success(codes);
    }

}
