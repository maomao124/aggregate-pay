package mao.aggregate_pay_sms.sms;

import lombok.extern.slf4j.Slf4j;
import mao.sms_sdk.dto.R;
import mao.sms_sdk.dto.SmsParamsDTO;
import mao.sms_sdk.service.SmsSendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_sms.sms
 * Class(类名): SmsServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 14:23
 * Version(版本): 1.0
 * Description(描述)： 短信发送至短信服务
 */

@Slf4j
@Service
public class SmsServiceImpl implements SmsService
{

    @Resource
    private SmsSendService smsSendService;

    @Override
    public void send(String mobile, String code, int effectiveTime)
    {
        log.info("给手机号" + mobile + "发送验证码：" + code);
        //构建短信发送对象
        SmsParamsDTO smsParamsDTO = new SmsParamsDTO();
        //设置手机号
        smsParamsDTO.setMobile(mobile);
        //设置签名编码，聚合支付平台
        smsParamsDTO.setSignature("DXQM_000000002");
        //设置短信模板编码
        smsParamsDTO.setTemplate("DXMB_000000001");
        //设置参数
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        smsParamsDTO.setParams(map);
        //发送短信至短信接收服务
        R<Boolean> result = smsSendService.sendSms(smsParamsDTO);
        //查看短信发送结果
        if (result.getIsError())
        {
            log.warn("短信发送失败！手机号：" + mobile + "，失败信息：" + result.getMsg());
            return;
        }
        log.info("给手机号 " + mobile + " 发送短信成功");
    }

    @Override
    public void sendOnConsole(String mobile, String code, int effectiveTime)
    {
        log.info("给手机号" + mobile + "发送验证码：" + code);
    }
}
