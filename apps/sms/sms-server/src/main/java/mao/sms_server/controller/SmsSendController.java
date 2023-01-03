package mao.sms_server.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.entity.*;
import mao.sms_entity.exception.SmsException;
import mao.sms_server.service.*;
import mao.tools_core.base.BaseController;
import mao.tools_core.base.R;
import mao.tools_core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.controller
 * Class(类名): SmsSendController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/3
 * Time(创建时间)： 21:01
 * Version(版本): 1.0
 * Description(描述)： 短信发送接口
 */

@Slf4j
@RestController
@RequestMapping("/sms")
@Api(tags = "短信发送接口")
public class SmsSendController extends BaseController
{
    /**
     * 签名服务
     */
    @Resource
    private SignatureService signatureService;

    /**
     * 模板服务
     */
    @Resource
    private TemplateService templateService;

    /**
     * 配置服务
     */
    @Resource
    private ConfigService configService;

    /**
     * 平台服务
     */
    @Resource
    private PlatformService platformService;

    /**
     * 接收日志服务
     */
    @Resource
    private ReceiveLogService receiveLogService;

    /**
     * 发送日志服务
     */
    @Resource
    private SendLogService sendLogService;

    /**
     * 签名实体列表
     */
    private List<SignatureEntity> signatureEntities;
    /**
     * 模板实体列表
     */
    private List<TemplateEntity> templateEntities;
    /**
     * 配置实体列表
     */
    private List<ConfigEntity> configEntities;
    /**
     * 平台实体列表
     */
    private List<PlatformEntity> platformEntities;


    /**
     * 签名实体
     */
    private SignatureEntity signatureEntity;
    /**
     * 模板实体
     */
    private TemplateEntity templateEntity;
    /**
     * 配置实体
     */
    private ConfigEntity configEntity;
    /**
     * 平台实体
     */
    private PlatformEntity platformEntity;


    @PostMapping("/simulation")
    @ApiOperation("模拟发送短信")
    public R<Boolean> send(@RequestParam("date") String date, @RequestParam Integer num)
    {
        //本地进程锁
        synchronized (this)
        {
            log.info("模拟发送 date:{}", date);
            if (num <= 0)
            {
                num = 1000;
            }
            Random rand = new Random();
            int count = rand.nextInt(num) + 1000;
            int fail = rand.nextInt(100);
            int success = count - fail;
            init();
            load();

            for (int i = 0; i < success; i++)
            {
                if (i % 9 == 0)
                {
                    load();
                }
                String apiLogId = UUID.randomUUID().toString();
                ReceiveLogEntity receiveLogEntity = new ReceiveLogEntity();
                receiveLogEntity.setPlatformId(platformEntity.getId());
                receiveLogEntity.setPlatformName(platformEntity.getName());
                receiveLogEntity.setBusiness("simulation");
                receiveLogEntity.setConfigIds(configEntity.getId());
                receiveLogEntity.setTemplate(templateEntity.getCode());
                receiveLogEntity.setSignature(signatureEntity.getCode());
                receiveLogEntity.setMobile("18" + (rand.nextInt(900000000) + 100000000));
                receiveLogEntity.setRequest("{\"code\":\"9009\"}");
                receiveLogEntity.setUseTime(Long.valueOf(rand.nextInt(50)));
                receiveLogEntity.setStatus(1);
                receiveLogEntity.setApiLogId(apiLogId);
                receiveLogEntity.setCreateTime(DateUtils.date2LocalDateTime(DateUtils.parseAsDate(date)));
                receiveLogEntity.setUpdateTime(receiveLogEntity.getCreateTime());
                receiveLogEntity.setCreateUser("simulation");
                receiveLogEntity.setUpdateUser("simulation");
                receiveLogService.save(receiveLogEntity);

                SendLogEntity sendLogEntity = new SendLogEntity();
                sendLogEntity.setConfigId(configEntity.getId());
                sendLogEntity.setConfigPlatform(configEntity.getPlatform());
                sendLogEntity.setConfigName(configEntity.getName());
                sendLogEntity.setTemplate(templateEntity.getCode());
                sendLogEntity.setSignature(signatureEntity.getCode());
                sendLogEntity.setMobile(receiveLogEntity.getMobile());
                sendLogEntity.setUseTime(Long.valueOf(rand.nextInt(50)));
                sendLogEntity.setStatus(1);
                sendLogEntity.setRequest(receiveLogEntity.getRequest());
                sendLogEntity.setResponse("{\"Message\":\"OK\",\"RequestId\":\"C56B73A4-6C90-4903-A969-008412C18144\",\"BizId\":\"539516503785026866^0\",\"Code\":\"OK\"}");
                sendLogEntity.setApiLogId(apiLogId);
                sendLogEntity.setCreateTime(DateUtils.date2LocalDateTime(DateUtils.parseAsDate(date)));
                sendLogEntity.setUpdateTime(receiveLogEntity.getCreateTime());
                sendLogEntity.setCreateUser("simulation");
                sendLogEntity.setUpdateUser("simulation");
                sendLogService.save(sendLogEntity);

            }

            for (int i = 0; i < fail; i++)
            {
                if (i % 9 == 0)
                {
                    load();
                }
                String apiLogId = UUID.randomUUID().toString();
                ReceiveLogEntity receiveLogEntity = new ReceiveLogEntity();
                receiveLogEntity.setPlatformId(platformEntity.getId());
                receiveLogEntity.setPlatformName(platformEntity.getName());
                receiveLogEntity.setBusiness("simulation");
                receiveLogEntity.setConfigIds(configEntity.getId());
                receiveLogEntity.setTemplate(templateEntity.getCode());
                receiveLogEntity.setSignature(signatureEntity.getCode());
                receiveLogEntity.setMobile("18" + (rand.nextInt(900000000) + 100000000));
                receiveLogEntity.setRequest("{\"code\":\"9009\"}");
                receiveLogEntity.setError("其他异常");
                receiveLogEntity.setUseTime(Long.valueOf(rand.nextInt(50)));
                receiveLogEntity.setStatus(0);
                receiveLogEntity.setApiLogId(apiLogId);
                receiveLogEntity.setCreateTime(DateUtils.date2LocalDateTime(DateUtils.parseAsDate(date)));
                receiveLogEntity.setUpdateTime(receiveLogEntity.getCreateTime());
                receiveLogEntity.setCreateUser("simulation");
                receiveLogEntity.setUpdateUser("simulation");
                receiveLogService.save(receiveLogEntity);

                SendLogEntity sendLogEntity = new SendLogEntity();
                sendLogEntity.setConfigId(configEntity.getId());
                sendLogEntity.setConfigPlatform(configEntity.getPlatform());
                sendLogEntity.setConfigName(configEntity.getName());
                sendLogEntity.setTemplate(templateEntity.getCode());
                sendLogEntity.setSignature(signatureEntity.getCode());
                sendLogEntity.setMobile(receiveLogEntity.getMobile());
                sendLogEntity.setUseTime(Long.valueOf(rand.nextInt(50)));
                sendLogEntity.setStatus(0);
                sendLogEntity.setRequest(receiveLogEntity.getRequest());
                sendLogEntity.setResponse("");
                sendLogEntity.setError("费用不足");
                sendLogEntity.setApiLogId(apiLogId);
                sendLogEntity.setCreateTime(DateUtils.date2LocalDateTime(DateUtils.parseAsDate(date)));
                sendLogEntity.setUpdateTime(receiveLogEntity.getCreateTime());
                sendLogEntity.setCreateUser("simulation");
                sendLogEntity.setUpdateUser("simulation");
                sendLogService.save(sendLogEntity);

            }

            return R.success().put("count", count).put("success", success).put("fail", fail);
        }
    }


    private void init()
    {
        signatureEntities = signatureService.list();
        templateEntities = templateService.list();

        LambdaQueryWrapper<ConfigEntity> configWrapper = new LambdaQueryWrapper<>();
        configWrapper.eq(ConfigEntity::getIsEnable, 1);
        configWrapper.eq(ConfigEntity::getIsActive, 1);
        configEntities = configService.list(configWrapper);
        if (configEntities == null || configEntities.size() == 0)
        {
            throw new SmsException("通道实例列表为空");
        }


        LambdaQueryWrapper<PlatformEntity> platformWrapper = new LambdaQueryWrapper<>();
        platformWrapper.eq(PlatformEntity::getIsActive, 1);
        platformEntities = platformService.list(platformWrapper);
    }

    private void load()
    {
        Random rand = new Random();
        signatureEntity = signatureEntities.get(rand.nextInt(signatureEntities.size()));
        templateEntity = templateEntities.get(rand.nextInt(templateEntities.size()));
        configEntity = configEntities.get(rand.nextInt(configEntities.size()));
        platformEntity = platformEntities.get(rand.nextInt(platformEntities.size()));
    }
}
