package mao.sms_sdk.service;

import mao.sms_sdk.dto.R;
import mao.sms_sdk.dto.SmsBatchParamsDTO;
import mao.sms_sdk.dto.SmsParamsDTO;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_sdk.service
 * Interface(接口名): SmsSendService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/27
 * Time(创建时间)： 20:05
 * Version(版本): 1.0
 * Description(描述)： 短信发送接口
 */

public interface SmsSendService
{
    /**
     * 发送短信
     *
     * @param smsParamsDTO {@link SmsParamsDTO}
     * @return {@link R}<{@link Boolean}>
     */
    R<Boolean> sendSms(SmsParamsDTO smsParamsDTO);

    /**
     * 批量发送短信
     *
     * @param smsBatchParamsDTO {@link SmsBatchParamsDTO}
     * @return {@link R}<{@link Boolean}>
     */
    R<Boolean> batchSendSms(SmsBatchParamsDTO smsBatchParamsDTO);
}
