package mao.sms_manage.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.sms_entity.entity.SendLogEntity;
import mao.sms_entity.vo.ReceiveLogVO;
import mao.sms_entity.vo.SendLogPageVO;
import mao.sms_entity.vo.SendLogVO;
import mao.sms_manage.service.ReceiveLogService;
import mao.sms_manage.service.SendLogService;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_core.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.controller
 * Class(类名): LogController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/22
 * Time(创建时间)： 20:33
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@RestController
@RequestMapping("/log")
@Api(tags = "日志")
public class LogController extends BaseController
{
    /**
     * 发送日志服务
     */
    @Resource
    private SendLogService sendLogService;

    /**
     * 接收日志服务
     */
    @Resource
    private ReceiveLogService receiveLogService;

    /**
     * 分页查询发送日志
     *
     * @param sendLogVO {@link SendLogVO}
     * @return {@link R}<{@link Page}<{@link SendLogVO}>>
     */
    @GetMapping("/sendPage")
    @ApiOperation("分页查询发送日志")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "排序字段", value = "排序字段", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "排序方式", value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "startCreateTime", value = "开始时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "endCreateTime", value = "结束时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String")
            })
    public R<Page<SendLogVO>> sendPage(SendLogVO sendLogVO)
    {
        Page<SendLogVO> page = getPage();
        Map<String, Object> params = new HashMap<>();
        if (getStartCreateTime() != null)
        {
            params.put("startCreateTime", DateUtils.format(getStartCreateTime(), DateUtils.DEFAULT_DATE_TIME_FORMAT));
        }
        if (getEndCreateTime() != null)
        {
            params.put("endCreateTime", DateUtils.format(getEndCreateTime(), DateUtils.DEFAULT_DATE_TIME_FORMAT));
        }
        params.put("signatureName", sendLogVO.getSignatureName());
        params.put("templateName", sendLogVO.getTemplateName());
        params.put("mobile", sendLogVO.getMobile());
        params.put("platformName", sendLogVO.getPlatformName());
        Page<SendLogVO> sendLogVOPage = sendLogService.pageLog(page, params);
        return R.success(sendLogVOPage);
    }


    /**
     * 分页查询接收日志
     *
     * @param receiveLogVO {@link ReceiveLogVO}
     * @return {@link R}<{@link Page}<{@link ReceiveLogVO}>>
     */
    @GetMapping("/receivePage")
    @ApiOperation("分页查询接收日志")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "排序字段", value = "排序字段", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "排序方式", value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "startCreateTime", value = "开始时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "endCreateTime", value = "结束时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String")
            })
    public R<Page<ReceiveLogVO>> receivePage(ReceiveLogVO receiveLogVO)
    {
        Page<ReceiveLogVO> page = getPage();
        Map<String, Object> params = new HashMap<>();
        if (getStartCreateTime() != null)
        {
            params.put("startCreateTime", DateUtils.format(getStartCreateTime(), DateUtils.DEFAULT_DATE_TIME_FORMAT));
        }
        if (getEndCreateTime() != null)
        {
            params.put("endCreateTime", DateUtils.format(getEndCreateTime(), DateUtils.DEFAULT_DATE_TIME_FORMAT));
        }
        params.put("platformName", receiveLogVO.getPlatformName());
        params.put("signatureName", receiveLogVO.getSignatureName());
        params.put("templateName", receiveLogVO.getTemplateName());
        Page<ReceiveLogVO> receiveLogVOPage = receiveLogService.pageLog(page, params);
        return R.success(receiveLogVOPage);
    }


    /**
     * 根据id查询发送日志
     *
     * @param id id
     * @return {@link R}<{@link SendLogEntity}>
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询发送日志")
    public R<SendLogEntity> get(@PathVariable("id") Long id)
    {
        SendLogEntity data = sendLogService.getById(id);
        return R.success(data);
    }


    /**
     * 发送记录
     *
     * @param sendLogPageVO {@link SendLogPageVO}
     * @return {@link R}<{@link Page}<{@link SendLogPageVO}>>
     */
    @GetMapping("/sendLogPage")
    @ApiOperation("发送记录")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "current", value = "当前页码，从1开始", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "size", value = "每页显示记录数", paramType = "query", required = true, dataType = "int"),
                    @ApiImplicitParam(name = "排序字段", value = "排序字段", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "排序方式", value = "排序方式，可选值(asc、desc)", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "startCreateTime", value = "开始时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String"),
                    @ApiImplicitParam(name = "endCreateTime", value = "结束时间（yyyy-MM-dd HH:mm:ss）", paramType = "query", dataType = "String")
            })
    public R<Page<SendLogPageVO>> sendLogPage(SendLogPageVO sendLogPageVO)
    {
        Page<SendLogPageVO> page = getPage();
        Page<SendLogPageVO> sendLogVOPage = sendLogService.sendLogPage(page, sendLogPageVO);
        List<SendLogPageVO> record = sendLogVOPage.getRecords().stream().map(item ->
        {
            if (StringUtils.isNotBlank(item.getTemplateContent()))
            {
                String content = item.getTemplateContent().replaceAll("(\\$\\{)([\\w]+)(\\})", "******");
                item.setContentText(content);
                item.buildRemark();
                item.cleanBigField();
            }
            return item;
        }).collect(Collectors.toList());
        page.setRecords(record);
        return R.success(page);
    }
}
