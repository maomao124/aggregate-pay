package mao.sms_manage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.sms_entity.dto.SignatureDTO;
import mao.sms_entity.entity.ReceiveLogEntity;
import mao.sms_entity.entity.SignatureEntity;
import mao.sms_manage.annotation.DefaultParams;
import mao.sms_manage.service.ReceiveLogService;
import mao.sms_manage.service.SignatureService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.controller
 * Class(类名): SignatureController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/22
 * Time(创建时间)： 21:08
 * Version(版本): 1.0
 * Description(描述)： 签名
 */

@RestController
@RequestMapping("/signature")
@Api(tags = "签名")
public class SignatureController extends BaseController
{
    /**
     * 签名服务
     */
    @Resource
    private SignatureService signatureService;

    /**
     * 接收日志服务
     */
    @Resource
    private ReceiveLogService receiveLogService;

    /**
     * 分页查询
     *
     * @param signatureDTO {@link SignatureDTO}
     * @return {@link R}<{@link Page}<{@link SignatureEntity}>>
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
    public R<Page<SignatureEntity>> page(SignatureDTO signatureDTO)
    {
        Page<SignatureEntity> page = getPage();
        LbqWrapper<SignatureEntity> wrapper = Wraps.lbQ();

        wrapper.like(SignatureEntity::getName, signatureDTO.getName())
                .like(SignatureEntity::getCode, signatureDTO.getCode())
                .like(SignatureEntity::getContent, signatureDTO.getContent())
                .orderByDesc(SignatureEntity::getCreateTime);

        signatureService.page(page, wrapper);
        return R.success(page);
    }


    /**
     * 自定义分页
     *
     * @param signatureDTO {@link SignatureDTO}
     * @return {@link R}<{@link Page}<{@link SignatureDTO}>>
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
    public R<Page<SignatureDTO>> customPage(SignatureDTO signatureDTO)
    {
        Page<SignatureDTO> page = getPage();
        Map<String, String> params = new HashMap<>();
        params.put("name", signatureDTO.getName());
        params.put("code", signatureDTO.getCode());
        params.put("configId", signatureDTO.getConfigId());
        signatureService.customPage(page, params);
        return R.success(page);
    }

    /**
     * 查询全部
     *
     * @param signatureDTO {@link SignatureDTO}
     * @return {@link R}<{@link List}<{@link SignatureEntity}>>
     */
    @GetMapping("/list")
    @ApiOperation("查询全部")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "排序字段", value = "排序字段", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "排序方式", value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String")
            })
    public R<List<SignatureEntity>> list(SignatureDTO signatureDTO)
    {
        LbqWrapper<SignatureEntity> wrapper = Wraps.lbQ();

        wrapper.like(SignatureEntity::getName, signatureDTO.getName())
                .like(SignatureEntity::getCode, signatureDTO.getCode())
                .like(SignatureEntity::getContent, signatureDTO.getContent())
                .orderByDesc(SignatureEntity::getCreateTime);

        List<SignatureEntity> list = signatureService.list(wrapper);
        return R.success(list);
    }

    /**
     * 根据id查询签名
     *
     * @param id id
     * @return {@link R}<{@link SignatureEntity}>
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询签名")
    public R<SignatureEntity> get(@PathVariable("id") String id)
    {
        SignatureEntity data = signatureService.getById(id);
        return R.success(data);
    }


    /**
     * 保存
     *
     * @param entity {@link SignatureEntity}
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping
    @ApiOperation("保存")
    @DefaultParams
    @Transactional
    public R<Boolean> save(@RequestBody SignatureEntity entity)
    {
        String code = signatureService.getNextCode();
        entity.setCode(code);
        entity.setContent(entity.getName());
        if (signatureService.getByName(entity.getName()) != null)
        {
            return R.fail("模板名称重复");
        }
        signatureService.save(entity);
        return R.success();
    }


    /**
     * 更新
     *
     * @param entity {@link SignatureEntity}
     * @return {@link R}<{@link Boolean}>
     */
    @PutMapping
    @ApiOperation("修改")
    @DefaultParams
    @Transactional
    public R<Boolean> update(@RequestBody SignatureEntity entity)
    {
        SignatureEntity signature = signatureService.getByName(entity.getName());
        if (signature != null && !signature.getId().equals(entity.getId()))
        {
            return R.fail("模板名称重复");
        }
        signatureService.updateById(entity);
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
    @Transactional
    public R<List<String>> delete(@RequestBody List<String> ids)
    {
        List<String> codes = new ArrayList<>();
        List<String> nids = new ArrayList<>();

        for (String id : ids)
        {
            SignatureEntity signature = signatureService.getById(id);
            if (signature == null)
            {
                continue;
            }
            List<ReceiveLogEntity> logs = receiveLogService.list(Wraps.<ReceiveLogEntity>lbQ()
                    .eq(ReceiveLogEntity::getSignature, signature.getCode()));
            if (logs.size() > 0)
            {
                codes.add(signature.getCode());
            }
            else
            {
                nids.add(id);
            }
        }
        if (nids.size() > 0)
        {
            signatureService.removeByIds(nids);
        }
        return R.success(codes);
    }

}
