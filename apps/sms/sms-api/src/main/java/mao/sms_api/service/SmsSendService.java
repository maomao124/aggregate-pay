package mao.sms_api.service;

import mao.sms_entity.dto.SmsBatchParamsDTO;
import mao.sms_entity.dto.SmsParamsDTO;
import mao.sms_entity.entity.SignatureEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service
 * Interface(接口名): SmsSendService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 15:00
 * Version(版本): 1.0
 * Description(描述)： 短信发送服务
 */

public interface SmsSendService
{
    /**
     * 发送
     *
     * @param smsParamsDTO {@link SmsParamsDTO}
     */
    void send(SmsParamsDTO smsParamsDTO);

    /**
     * 批量发送
     *
     * @param smsBatchParamsDTO {@link SmsBatchParamsDTO}
     */
    void batchSend(SmsBatchParamsDTO smsBatchParamsDTO);
}
