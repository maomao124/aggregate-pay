package mao.auth_server.controller.core;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.core.OrgSaveDTO;
import mao.auth_entity.dto.core.OrgTreeDTO;
import mao.auth_entity.dto.core.OrgUpdateDTO;
import mao.auth_entity.entity.core.Org;
import mao.auth_server.service.core.OrgService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_core.base.entity.SuperEntity;
import mao.tools_core.utils.BizAssert;
import mao.tools_core.utils.TreeUtil;
import mao.tools_databases.mybatis.conditions.Wraps;
import mao.tools_databases.mybatis.conditions.query.LbqWrapper;
import mao.tools_log.annotation.SysLog;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static mao.tools_core.utils.StrPool.DEF_PARENT_ID;
import static mao.tools_core.utils.StrPool.DEF_ROOT_PATH;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.core
 * Class(类名): OrgController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/12
 * Time(创建时间)： 13:43
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@RestController
@RequestMapping("/org")
@Api(value = "OrgController", tags = "组织")
public class OrgController extends BaseController
{
    @Resource
    private OrgService orgService;

    @Resource
    private DozerUtils dozerUtils;

    /**
     * 分页查询组织
     */
    @ApiOperation(value = "分页查询组织", notes = "分页查询组织")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询组织")
    public R<IPage<Org>> page(Org data)
    {
        IPage<Org> page = this.getPage();
        LbqWrapper<Org> query = Wraps.lbQ(data);
        this.orgService.page(page, query);
        return this.success(page);
    }

    /**
     * 查询组织
     */
    @ApiOperation(value = "查询组织", notes = "查询组织")
    @GetMapping("/{id}")
    @SysLog("查询组织")
    public R<Org> get(@PathVariable Long id)
    {
        return this.success(this.orgService.getById(id));
    }

    /**
     * 新增组织
     */
    @Transactional
    @ApiOperation(value = "新增组织", notes = "新增组织不为空的字段")
    @PostMapping
    @SysLog("新增组织")
    public R<Org> save(@RequestBody @Validated OrgSaveDTO data)
    {
        Org org = this.dozerUtils.map(data, Org.class);
        if (org.getParentId() == null || org.getParentId() <= 0)
        {
            org.setParentId(DEF_PARENT_ID);
            org.setTreePath(DEF_ROOT_PATH);
        }
        else
        {
            Org parent = this.orgService.getById(org.getParentId());
            BizAssert.notNull(parent, "父组织不能为空");

            org.setTreePath(StringUtils.join(parent.getTreePath(), parent.getId(), DEF_ROOT_PATH));
        }
        this.orgService.save(org);
        return this.success(org);
    }

    /**
     * 修改组织
     */
    @Transactional
    @ApiOperation(value = "修改组织", notes = "修改组织不为空的字段")
    @PutMapping
    @SysLog("修改组织")
    public R<Org> update(@RequestBody @Validated(SuperEntity.Update.class) OrgUpdateDTO data)
    {
        Org org = this.dozerUtils.map(data, Org.class);
        this.orgService.updateById(org);
        return this.success(org);
    }

    /**
     * 删除组织
     */
    @Transactional
    @ApiOperation(value = "删除组织", notes = "根据id物理删除组织")
    @SysLog("删除组织")
    @DeleteMapping
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids)
    {
        this.orgService.remove(ids);
        return this.success(true);
    }

    /**
     * 查询系统所有的组织树
     */
    @ApiOperation(value = "查询系统所有的组织树", notes = "查询系统所有的组织树")
    @GetMapping("/tree")
    @SysLog("查询系统所有的组织树")
    public R<List<OrgTreeDTO>> tree(@RequestParam(value = "name", required = false) String name,
                                    @RequestParam(value = "status", required = false) Boolean status)
    {
        List<Org> list = this.orgService.list(Wraps.<Org>lbQ().like(Org::getName, name)
                .eq(Org::getStatus, status).orderByAsc(Org::getSortValue));
        List<OrgTreeDTO> treeList = this.dozerUtils.mapList(list, OrgTreeDTO.class);
        return this.success(TreeUtil.build(treeList));
    }
}
