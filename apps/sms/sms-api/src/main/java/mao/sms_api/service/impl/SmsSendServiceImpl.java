package mao.sms_api.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.sms_api.service.*;
import mao.sms_api.utils.ExceptionUtils;
import mao.sms_api.utils.SmsEncryptionUtils;
import mao.sms_dao.mapper.ReceiveLogMapper;
import mao.sms_entity.dto.SmsBatchParamsDTO;
import mao.sms_entity.dto.SmsParamsDTO;
import mao.sms_entity.dto.SmsSendDTO;
import mao.sms_entity.entity.*;
import mao.sms_entity.entity.base.BaseEntity;
import mao.sms_entity.entity.enumeration.TemplateType;
import mao.sms_entity.exception.SmsException;
import mao.sms_entity.utils.StringHelper;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service.impl
 * Class(类名): SmsSendServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/25
 * Time(创建时间)： 18:34
 * Version(版本): 1.0
 * Description(描述)： 短信发送服务实现类
 */

@Slf4j
@Service
public class SmsSendServiceImpl implements SmsSendService
{

    /**
     * 手机正则
     */
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[1]\\d{10}$");


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 平台服务
     */
    @Resource
    private PlatformService platformService;

    /**
     * 黑名单服务
     */
    @Resource
    private BlackListService blackListService;

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
     * 定时推送服务
     */
    @Resource
    private TimingPushService timingPushService;

    /**
     * 接收日志映射器
     */
    @Resource
    private ReceiveLogMapper receiveLogMapper;

    /**
     * DozerUtils
     */
    @Resource
    private DozerUtils dozerUtils;


    @Override
    public void send(SmsParamsDTO smsParamsDTO)
    {
        // 校验定时发送时间
        checkoutSendTime(smsParamsDTO.getSendTime());
        //校验系统是否注册
        PlatformEntity platformEntity = checkAccessKeyId(smsParamsDTO.getAccessKeyId());
        //判断是否需要鉴权
        if (platformEntity.getNeedAuth() == 1)
        {
            //校验秘钥是否通过
            checkAuth(smsParamsDTO.getTimestamp(), platformEntity.getAccessKeyId(),
                    platformEntity.getAccessKeySecret(), smsParamsDTO.getEncryption());
        }
        //构建SmsSendDTO
        SmsSendDTO smsSendDTO = new SmsSendDTO();
        //拷贝属性
        dozerUtils.map(smsParamsDTO, smsSendDTO);
        //发送
        sendSmsMessage(smsSendDTO, platformEntity);
    }

    @Override
    public void batchSend(SmsBatchParamsDTO smsBatchParamsDTO)
    {
        //校验系统是否注册
        PlatformEntity platformEntity = checkAccessKeyId(smsBatchParamsDTO.getAccessKeyId());
        //判断是否需要鉴权
        if (platformEntity.getNeedAuth() == 1)
        {
            //校验秘钥是否通过
            checkAuth(smsBatchParamsDTO.getTimestamp(), platformEntity.getAccessKeyId(),
                    platformEntity.getAccessKeySecret(), smsBatchParamsDTO.getEncryption());
        }
        //迭代器
        Iterator<String> mobileIt = smsBatchParamsDTO.getMobile().iterator();
        Iterator<String> signatureIt = smsBatchParamsDTO.getSignature().iterator();
        Iterator<String> templateIt = smsBatchParamsDTO.getTemplate().iterator();
        Iterator<LinkedHashMap<String, String>> paramsIt = smsBatchParamsDTO.getParams().iterator();

        String mobile = null;
        String signature = null;
        String template = null;
        LinkedHashMap<String, String> param = null;
        //错误信息字符串
        StringBuilder stringBuilder = new StringBuilder();
        //判断批次编码是否为空
        if (StringUtils.isBlank(smsBatchParamsDTO.getBatchCode()))
        {
            //为空，构建批次编码
            String batchCode = UUID.randomUUID().toString();
            smsBatchParamsDTO.setBatchCode(batchCode);
        }
        //迭代
        while (mobileIt.hasNext() || signatureIt.hasNext() || templateIt.hasNext() || paramsIt.hasNext())
        {
            //取数据
            if (mobileIt.hasNext())
            {
                mobile = mobileIt.next();
            }
            if (signatureIt.hasNext())
            {
                signature = signatureIt.next();
            }
            if (templateIt.hasNext())
            {
                template = templateIt.next();
            }
            if (paramsIt.hasNext())
            {
                param = paramsIt.next();
            }
            //构建SmsSendDTO
            SmsSendDTO smsSendDTO = new SmsSendDTO();
            //设置属性
            smsSendDTO.setMobile(mobile);
            smsSendDTO.setSignature(signature);
            smsSendDTO.setTemplate(template);
            smsSendDTO.setParams(param);
            smsSendDTO.setSendTime(smsBatchParamsDTO.getSendTime());
            smsSendDTO.setBatchCode(smsBatchParamsDTO.getBatchCode());
            try
            {
                //尝试发送
                sendSmsMessage(smsSendDTO, platformEntity);
            }
            catch (Exception e)
            {
                //发送失败，构建错误信息
                String message = e.getMessage();
                stringBuilder.append(mobile).append(":").append(message).append(";");
            }
        }
        //判断是否有错误信息
        if (stringBuilder.length() > 0)
        {
            throw new SmsException(stringBuilder.toString());
        }
    }


    /**
     * 校验系统是否注册
     *
     * @param accessKeyId 访问密钥id
     * @return {@link PlatformEntity}
     */
    private PlatformEntity checkAccessKeyId(String accessKeyId)
    {
        //通过accessKeyId查询平台
        PlatformEntity platformEntity = platformService.getByAccessKeyId(accessKeyId);
        //判断查询是否为空
        if (platformEntity == null)
        {
            //查询为空
            throw new SmsException("系统未注册");
        }
        //不为空，判断平台是否可用
        if (0 == platformEntity.getIsActive())
        {
            //平台不可用
            throw new SmsException("系统不可用");
        }
        //平台可用，返回
        return platformEntity;
    }

    /**
     * 检查身份验证（校验秘钥是否通过）
     *
     * @param timestamp        时间戳
     * @param accessKeyId      访问密钥id
     * @param accessKeySecret  访问密钥秘密
     * @param accessEncryption 访问加密
     */
    private void checkAuth(String timestamp, String accessKeyId, String accessKeySecret, String accessEncryption)
    {
        String encryption = SmsEncryptionUtils.encode(timestamp, accessKeyId, accessKeySecret);
        //相等，则通过
        if (accessEncryption.equals(encryption))
        {
            return;
        }
        throw new SmsException("鉴权失败");
    }


    /**
     * 校验手机号是否在黑名单
     *
     * @param phone 电话
     */
    private void checkBlack(String phone)
    {
        //判断输入的手机号是否为空
        if (StringUtils.isBlank(phone))
        {
            //为空
            throw new SmsException("手机号为空");
        }
        //判断是否为一个手机号
        if (!PHONE_PATTERN.matcher(phone).matches())
        {
            //不是一个手机号
            throw new SmsException("手机号格式不正确");
        }
        //查询类型为短信的黑名单列表
        List<String> blackList = blackListService.listByType("1");
        //判断是否包含此手机号
        if (blackList.contains(phone))
        {
            //包含
            throw new SmsException("黑名单手机号");
        }
    }

    /**
     * 检查模板和签名
     *
     * @param template  模板
     * @param signature 签名
     * @return {@link List}<{@link String}>
     */
    private List<String> checkTemplateAndSignature(String template, String signature)
    {
        //查询模板
        TemplateEntity templateEntity = templateService.getByCode(template);
        //查询签名
        SignatureEntity signatureEntity = signatureService.getByCode(signature);
        //判断是否为空
        if (templateEntity == null)
        {
            throw new SmsException("模板不存在");
        }
        //判断是否为空
        if (signatureEntity == null)
        {
            throw new SmsException("签名不存在");
        }
        //查询通道列表
        List<ConfigEntity> configs = configService.findByTemplateSignature(templateEntity.getId(), signatureEntity.getId());
        //判断是否为空
        if (CollectionUtils.isEmpty(configs))
        {
            throw new SmsException("未找到支持当前签名和模板的通道");
        }
        //返回id列表
        return configs.stream().map(BaseEntity::getId).collect(Collectors.toList());
    }


    /**
     * 校验参数 模板与参数是否匹配
     *
     * @param template 模板
     * @param params   参数个数
     * @return {@link TemplateEntity}
     */
    private TemplateEntity checkParams(String template, Map<String, String> params)
    {
        //查询模板
        TemplateEntity templateEntity = templateService.getByCode(template);
        //匹配参数
        String content = StringHelper.renderString(templateEntity.getContent(), params);
        if (content.indexOf("${") > 0)
        {
            throw new SmsException("参数不匹配" + content);
        }
        return templateEntity;
    }

    /**
     * 校验定时发送时间
     *
     * @param sendTime 发送时间
     */
    private void checkoutSendTime(String sendTime)
    {
        //判断发送时间是否为空
        if (StringUtils.isNotBlank(sendTime))
        {
            //发送时间不为空
            LocalDateTime localDateTime =
                    LocalDateTime.parse(sendTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            LocalDateTime nowDateTime = LocalDateTime.now().plusMinutes(1L).withSecond(0).minusSeconds(0).withNano(0);
            //定时是否小于一分钟
            if (localDateTime.compareTo(nowDateTime) <= 0)
            {
                throw new SmsException("发送时间过于接近当前时间，无法发送");
            }
        }
    }


    /**
     * 根据短信模板分类 并分发
     *
     * @param templateEntity 模板实体
     * @param smsSendDTO     短信发送dto
     * @param platformEntity 平台实体
     */
    private void pushSmsMessage(TemplateEntity templateEntity, SmsSendDTO smsSendDTO, PlatformEntity platformEntity)
    {
        //短信接收日志
        ReceiveLogEntity receiveLogEntity = new ReceiveLogEntity();
        //设置日志id
        receiveLogEntity.setApiLogId(UUID.randomUUID().toString());
        //开始时间
        long start = System.currentTimeMillis();
        try
        {
            //获得短信发送时间，如果为空表示实时发送
            String sendTime = smsSendDTO.getSendTime();
            //smsSendDTO转json
            String smsJson = JSON.toJSONString(smsSendDTO);
            //判断发送时间是否为空
            if (StringUtils.isNotEmpty(sendTime))
            {
                //定时发送，需要将信息保存到MySQL
                TimingPushEntity timingPushEntity = new TimingPushEntity();
                timingPushEntity.setMobile(smsSendDTO.getMobile());
                timingPushEntity.setTemplate(smsSendDTO.getTemplate());
                timingPushEntity.setSignature(smsSendDTO.getSignature());
                timingPushEntity.setTiming(sendTime);
                timingPushEntity.setRequest(smsJson);
                //保存
                timingPushService.save(timingPushEntity);
            }
            else
            {
                //实时发送，将信息保存到Redis队列
                if (templateEntity.getType() == TemplateType.VERIFICATION.getCode())
                {
                    //验证码类型的短信，保存到TOPIC_HIGH_SMS队列
                    stringRedisTemplate.opsForList().leftPush("TOPIC_HIGH_SMS", smsJson);
                }
                else
                {
                    //其他类型的短信，保存到TOPIC_GENERAL_SMS队列
                    stringRedisTemplate.opsForList().leftPush("TOPIC_GENERAL_SMS", smsJson);
                }
            }
            //设置状态为成功
            receiveLogEntity.setStatus(1);
        }
        catch (Exception e)
        {
            //设置状态为失败
            receiveLogEntity.setStatus(0);
            //设置异常信息
            receiveLogEntity.setError(ExceptionUtils.getErrorStackTrace(e));
        }
        finally
        {
            //继续构建接收日志对象
            receiveLogEntity.setPlatformId(platformEntity.getId());
            receiveLogEntity.setPlatformName(platformEntity.getName());
            receiveLogEntity.setConfigIds(StringUtils.join(smsSendDTO.getConfigIds(), ","));
            receiveLogEntity.setTemplate(smsSendDTO.getTemplate());
            receiveLogEntity.setSignature(smsSendDTO.getSignature());
            receiveLogEntity.setMobile(smsSendDTO.getMobile());
            receiveLogEntity.setRequest(JSON.toJSONString(smsSendDTO.getParams()));
            receiveLogEntity.setUseTime(System.currentTimeMillis() - start);
            receiveLogEntity.setBusiness(smsSendDTO.getBatchCode());
            //日志保存到数据库
            receiveLogMapper.insert(receiveLogEntity);
        }
    }


    /**
     * 发送短信
     *
     * @param smsSendDTO     短信发送dto
     * @param platformEntity 平台实体
     */
    private void sendSmsMessage(SmsSendDTO smsSendDTO, PlatformEntity platformEntity)
    {
        //校验手机号是否在黑名单
        checkBlack(smsSendDTO.getMobile());
        //校验签名和模板
        List<String> configs = checkTemplateAndSignature(smsSendDTO.getTemplate(), smsSendDTO.getSignature());
        smsSendDTO.setConfigIds(configs);
        //校验参数
        TemplateEntity templateEntity = checkParams(smsSendDTO.getTemplate(), smsSendDTO.getParams());
        // 调用发送接口
        pushSmsMessage(templateEntity, smsSendDTO, platformEntity);
    }
}
