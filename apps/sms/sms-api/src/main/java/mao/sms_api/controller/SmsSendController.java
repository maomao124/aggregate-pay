package mao.sms_api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.sms_api.service.SmsSendService;
import mao.sms_entity.dto.SmsBatchParamsDTO;
import mao.sms_entity.dto.SmsParamsDTO;
import mao.sms_entity.exception.SmsException;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.controller
 * Class(类名): SmsSendController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/25
 * Time(创建时间)： 20:02
 * Version(版本): 1.0
 * Description(描述)： 短信发送接口
 */

@Slf4j
@RestController
@RequestMapping("/sms")
@Api(tags = "短信发送")
public class SmsSendController extends BaseController
{
    @Resource
    private SmsSendService smsSendService;

    /**
     * 发送短信
     *
     * @param smsParamsDTO {@link SmsParamsDTO}
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping("/send")
    @ApiOperation("发送短信")
    @Transactional
    public R<Boolean> send(@RequestBody SmsParamsDTO smsParamsDTO)
    {
        log.info("发送短信 params:{}", smsParamsDTO);
        try
        {
            smsSendService.send(smsParamsDTO);
        }
        catch (SmsException e)
        {
            log.error("发送异常", e);
            return R.fail(e.getMessage());
        }
        return R.success();
    }

    /**
     * 批量发送短信
     *
     * @param smsBatchParamsDTO {@link SmsBatchParamsDTO}
     * @return {@link R}<{@link Boolean}>
     */
    @PostMapping("/batchSend")
    @ApiOperation("批量发送短信")
    @Transactional
    public R<Boolean> batchSend(@RequestBody SmsBatchParamsDTO smsBatchParamsDTO)
    {
        log.info("批量发送短信 params:{}", smsBatchParamsDTO);
        try
        {
            smsSendService.batchSend(smsBatchParamsDTO);
        }
        catch (SmsException e)
        {
            log.error("批量发送异常", e);
            return R.fail(e.getMessage());
        }
        return R.success();
    }
}
