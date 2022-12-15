package mao.auth_server.controller.core;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.core.StationPageDTO;
import mao.auth_entity.dto.core.StationSaveDTO;
import mao.auth_entity.dto.core.StationUpdateDTO;
import mao.auth_entity.entity.core.Station;
import mao.auth_server.service.core.StationService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_core.base.entity.SuperEntity;
import mao.tools_log.annotation.SysLog;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.controller.core
 * Class(类名): StationController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/12
 * Time(创建时间)： 19:42
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@RestController
@Api(value = "StationController", tags = "岗位")
@RequestMapping("/station")
public class StationController extends BaseController
{

    @Resource
    private StationService stationService;

    @Resource
    private DozerUtils dozerUtils;

    /**
     * 分页查询岗位
     */
    @ApiOperation(value = "分页查询岗位", notes = "分页查询岗位")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "current", value = "当前页", dataType = "long", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "size", value = "每页显示几条", dataType = "long", paramType = "query", defaultValue = "10"),
    })
    @GetMapping("/page")
    @SysLog("分页查询岗位")
    public R<IPage<Station>> page(StationPageDTO data)
    {
        Page<Station> page = getPage();
        stationService.findStationPage(page, data);
        return success(page);
    }

    /**
     * 根据id查询岗位
     */
    @ApiOperation(value = "查询岗位", notes = "查询岗位")
    @GetMapping("/{id}")
    @SysLog("查询岗位")
    public R<Station> get(@PathVariable Long id)
    {
        return success(stationService.getById(id));
    }

    /**
     * 新增岗位
     */
    @Transactional
    @ApiOperation(value = "新增岗位", notes = "新增岗位不为空的字段")
    @PostMapping
    @SysLog("新增岗位")
    public R<Station> save(@RequestBody @Validated StationSaveDTO data)
    {
        Station station = dozerUtils.map(data, Station.class);
        stationService.save(station);
        return success(station);
    }

    /**
     * 修改岗位
     */
    @Transactional
    @ApiOperation(value = "修改岗位", notes = "修改岗位不为空的字段")
    @PutMapping
    @SysLog("修改岗位")
    public R<Station> update(@RequestBody @Validated(SuperEntity.Update.class) StationUpdateDTO data)
    {
        Station station = dozerUtils.map(data, Station.class);
        stationService.updateById(station);
        return success(station);
    }

    /**
     * 删除岗位
     */
    @Transactional
    @ApiOperation(value = "删除岗位", notes = "根据id物理删除岗位")
    @SysLog("删除岗位")
    @DeleteMapping
    public R<Boolean> delete(@RequestParam("ids[]") List<Long> ids)
    {
        stationService.removeByIds(ids);
        return success();
    }
}
