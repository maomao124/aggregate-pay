package mao.sms_manage.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.sms_entity.dto.BlackListDTO;
import mao.sms_entity.entity.BlackListEntity;
import mao.sms_manage.annotation.DefaultParams;
import mao.sms_manage.service.BlackListService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

import static mao.tools_core.exception.ExceptionCode.BASE_VALID_PARAM;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.controller
 * Class(类名): BlackListController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/21
 * Time(创建时间)： 21:06
 * Version(版本): 1.0
 * Description(描述)： 黑名单
 */

@RestController
@RequestMapping("/blacklist")
@Api(tags = "黑名单")
public class BlackListController extends BaseController
{
    @Autowired
    private BlackListService blackListService;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 根据条件分页查询黑名单
     *
     * @param blackListDTO 黑名单dto
     * @return {@link R}<{@link Page}<{@link BlackListEntity}>>
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
    public R<Page<BlackListEntity>> page(BlackListDTO blackListDTO)
    {
        Page<BlackListEntity> page = getPage();
        LbqWrapper<BlackListEntity> wrapper = Wraps.lbQ();
        //构建查询条件
        wrapper.like(BlackListEntity::getContent, blackListDTO.getContent())
                .like(BlackListEntity::getType, blackListDTO.getType())
                .orderByDesc(BlackListEntity::getCreateTime);
        //执行查询
        blackListService.page(page, wrapper);
        return R.success(page);
    }

    /**
     * 根据id查询黑名单
     *
     * @param id id
     * @return {@link R}<{@link BlackListEntity}>
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询黑名单")
    public R<BlackListEntity> get(@PathVariable("id") String id)
    {
        BlackListEntity data = blackListService.getById(id);
        return R.success(data);
    }

    /**
     * 保存
     *
     * @param entity BlackListEntity
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping
    @ApiOperation("保存")
    @DefaultParams
    public R<Boolean> save(@RequestBody BlackListEntity entity)
    {
        blackListService.save(entity);
        redisTemplate.delete("Black_" + 1);
        return R.success();
    }

    /**
     * 更新
     *
     * @param entity BlackListEntity
     * @return {@link R}<{@link Boolean}>
     */
    @PutMapping
    @ApiOperation("修改")
    @DefaultParams
    public R<Boolean> update(@RequestBody BlackListEntity entity)
    {
        blackListService.updateById(entity);
        redisTemplate.delete("Black_" + 1);
        return R.success();
    }

    /**
     * 删除
     *
     * @param ids id列表
     * @return {@link R}
     */
    @DeleteMapping
    @ApiOperation("删除")
    public R<Boolean> delete(@RequestBody List<String> ids)
    {

        blackListService.removeByIds(ids);
        redisTemplate.delete("Black_" + 1);
        return R.success();
    }

    /**
     * 导入的方式添加
     *
     * @param file 文件
     * @return {@link R}<{@link ?}>
     */
    @PostMapping("/upload")
    @ApiOperation("导入")
    public R<?> upload(@RequestParam(value = "file") MultipartFile file)
    {
        if (file.isEmpty())
        {
            return fail(BASE_VALID_PARAM.build("导入内容为空"));
        }
        R<Map<String, Object>> upload = blackListService.upload(file);
        redisTemplate.delete("Black_" + 1);
        return upload;
    }


}
