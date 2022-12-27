package mao.sms_sdk.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.sms_sdk.dto.R;
import mao.sms_sdk.dto.SmsBatchParamsDTO;
import mao.sms_sdk.dto.SmsParamsDTO;
import mao.sms_sdk.service.SmsSendService;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_sdk.service.impl
 * Class(类名): SmsSendServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/27
 * Time(创建时间)： 21:42
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class SmsSendServiceImpl implements SmsSendService
{

    @Override
    public R<Boolean> sendSms(SmsParamsDTO smsParamsDTO)
    {
        return null;
    }

    @Override
    public R<Boolean> batchSendSms(SmsBatchParamsDTO smsBatchParamsDTO)
    {
        return null;
    }
}
