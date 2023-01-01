package mao.sms_server.sms;

import mao.sms_server.entity.SmsConfig;
import mao.sms_server.service.SignatureService;
import mao.sms_server.service.TemplateService;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.sms
 * Class(类名): AbstractSmsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/1
 * Time(创建时间)： 14:24
 * Version(版本): 1.0
 * Description(描述)： 短信发送的抽象类，不同渠道的服务都需要继承此抽象类
 */

public abstract class AbstractSmsService
{
    /**
     * 通道配置信息
     */
    protected SmsConfig config;

    /**
     * 签名
     */
    protected SignatureService signatureService;

    /**
     * 模板
     */
    protected TemplateService templateService;

    public SmsConfig getConfig()
    {
        return config;
    }

    /**
     * 发送短信
     *
     * @param mobile    手机号
     * @param params    参数
     * @param signature 短信签名
     * @param template  短信模板
     * @return {@link String}
     */
    public String send(String mobile, Map<String, String> params, String signature, String template)
    {
        return this.sendSms(mobile, params, signature, template);
    }

    /**
     * 送批
     * 批量发送短信
     *
     * @param mobiles    手机号
     * @param params     参数
     * @param signatures 短信签名
     * @param templates  短信模板
     * @return {@link String}
     */
    public String sendBatch(String[] mobiles, LinkedHashMap<String, String>[] params, String[] signatures, String[] templates)
    {
        return this.sendSmsBatch(mobiles, params, signatures, templates);
    }

    /**
     * 发送短信
     *
     * @param mobile    手机号
     * @param params    参数
     * @param signature 短信签名
     * @param template  短信模板
     * @return {@link String}
     */
    protected abstract String sendSms(String mobile, Map<String, String> params, String signature, String template);


    /**
     * 批量发送短信
     *
     * @param mobiles    手机号
     * @param params     参数
     * @param signatures 短信签名
     * @param templates  短信模板
     * @return {@link String}
     */
    protected abstract String sendSmsBatch(String[] mobiles, LinkedHashMap<String, String>[] params, String[] signatures, String[] templates);

    /**
     * 失败响应
     *
     * @param msg      消息
     * @param response 响应
     * @return {@link String}
     */
    protected String failResponse(String msg, String response)
    {
        return "FAIL@#@" + msg + "@#@" + response;
    }
}
