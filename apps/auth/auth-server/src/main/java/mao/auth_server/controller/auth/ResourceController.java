package mao.auth_server.controller.auth;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.dto.auth.ResourceSaveDTO;
import mao.auth_entity.dto.auth.ResourceUpdateDTO;
import mao.auth_entity.entity.auth.Resource;
import mao.auth_server.service.auth.ResourceService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_core.base.entity.SuperEntity;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.tools_log.annotation.SysLog;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.auth
 * Class(类名): ResourceController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/12
 * Time(创建时间)： 20:25
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Validated
@RestController
@RequestMapping("/resource")
@Api(value = "ResourceController", tags = "资源")
public class ResourceController extends BaseController
{
    @javax.annotation.Resource
    private ResourceService resourceService;

    @javax.annotation.Resource
    private DozerUtils dozerUtils;

    /**
     * 分页查询资源
     */
    @ApiOperation(value = "分页查询资源", notes = "分页查询资源")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询资源")
    public R<IPage<Resource>> page(Resource data)
    {
        IPage<Resource> page = getPage();
        // 构建值不为null的查询条件
        LbqWrapper<Resource> query = Wraps.lbQ(data);
        resourceService.page(page, query);
        return success(page);
    }

    /**
     * 查询资源
     */
    @ApiOperation(value = "查询资源", notes = "查询资源")
    @GetMapping("/{id}")
    @SysLog("查询资源")
    public R<Resource> get(@PathVariable Long id)
    {
        return success(resourceService.getById(id));
    }

    /**
     * 新增资源
     */
    @Transactional
    @ApiOperation(value = "新增资源", notes = "新增资源不为空的字段")
    @PostMapping
    @SysLog("新增资源")
    public R<Resource> save(@RequestBody @Validated ResourceSaveDTO data)
    {
        Resource resource = dozerUtils.map(data, Resource.class);
        resourceService.save(resource);
        return success(resource);
    }

    /**
     * 修改资源
     */
    @Transactional
    @ApiOperation(value = "修改资源", notes = "修改资源不为空的字段")
    @PutMapping
    @SysLog("修改资源")
    public R<Resource> update(@RequestBody @Validated(SuperEntity.Update.class) ResourceUpdateDTO data)
    {
        Resource resource = dozerUtils.map(data, Resource.class);
        resourceService.updateById(resource);
        return success(resource);
    }

    /**
     * 删除资源
     * 链接类型的资源 只清空 menu_id
     * 按钮和数据列 则物理删除
     */
    @Transactional
    @ApiOperation(value = "删除资源", notes = "根据id物理删除资源")
    @DeleteMapping
    @SysLog("删除资源")
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids)
    {
        return success(resourceService.removeByIds(ids));
    }

    /**
     * 查询用户可用的所有资源
     */
    @ApiOperation(value = "查询用户可用的所有资源", notes = "查询用户可用的所有资源")
    @GetMapping
    @SysLog("查询用户可用的所有资源")
    public R<List<Resource>> visible(ResourceQueryDTO resource)
    {
        if (resource == null)
        {
            resource = new ResourceQueryDTO();
        }

        if (resource.getUserId() == null)
        {
            resource.setUserId(getUserId());
        }
        return success(resourceService.findVisibleResource(resource));
    }

    /**
     * 查询所有资源
     */
    @ApiOperation(value = "查询所有资源", notes = "查询所有资源")
    @GetMapping("/list")
    @SysLog("查询所有资源")
    public R<List> list()
    {
        List<Resource> list = resourceService.list();
        List<String> resourceList = list.stream().map((Resource r) ->
                r.getMethod() + r.getUrl()).collect(Collectors.toList());
        return success(resourceList);
    }
}
