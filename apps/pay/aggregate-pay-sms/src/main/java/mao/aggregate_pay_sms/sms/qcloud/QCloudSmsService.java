package mao.aggregate_pay_sms.sms.qcloud;


import com.github.qcloudsms.SmsSingleSenderResult;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_sms.common.domain.BusinessException;
import mao.aggregate_pay_sms.common.domain.CommonErrorCode;
import mao.aggregate_pay_sms.sms.SmsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * <P>
 * 腾讯云短信服务
 * </p>
 *
 * @author zhupeiyuan
 * @since 2019-07-12
 */
@Slf4j
public class QCloudSmsService implements SmsService
{

    /**
     * 应用程序id
     */
    @Value("${sms.qcloud.appId}")
    private int appId;

    /**
     * 应用关键
     */
    @Value("${sms.qcloud.appKey}")
    private String appKey;

    /**
     * 模板id
     */
    @Value("${sms.qcloud.templateId}")
    private int templateId;

    /**
     * 标志
     */
    @Value("${sms.qcloud.sign}")
    private String sign;

    /**
     * 发送
     *
     * @param mobile        移动
     * @param code          代码
     * @param effectiveTime 有效时间
     */
    @Override
    public void send(String mobile, String code, int effectiveTime)
    {
        log.info("给手机号" + mobile + "发送验证码：" + code);
        SmsSingleSenderResult senderResult;
        try
        {
            QCloudSmsSingleSender qCloudSmsSingleSender = new QCloudSmsSingleSender(appId, appKey);
            senderResult = qCloudSmsSingleSender
                    .sendWithParam("86", mobile, templateId, new String[]{code, String.valueOf(effectiveTime / 60)},
                            sign, "", "");
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
            throw new BusinessException(CommonErrorCode.UNKNOWN, e.getMessage());
        }
        if (senderResult.result != CommonErrorCode.SUCCESS.getCode())
        {
            log.warn("QCloud return: {}", senderResult.toString());
            throw new BusinessException(CommonErrorCode.CUSTOM, senderResult.errMsg);
        }
    }

    /**
     * 发送在控制台
     *
     * @param mobile        移动
     * @param code          代码
     * @param effectiveTime 有效时间
     */
    @Override
    public void sendOnConsole(String mobile, String code, int effectiveTime)
    {
        log.info("给手机号" + mobile + "发送验证码：" + code);
    }
}
