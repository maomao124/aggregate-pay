package mao.sms_sdk.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.sms_sdk.config.SmsConfigurationProperties;
import mao.sms_sdk.dto.BaseParamsDTO;
import mao.sms_sdk.dto.R;
import mao.sms_sdk.dto.SmsBatchParamsDTO;
import mao.sms_sdk.dto.SmsParamsDTO;
import mao.sms_sdk.service.SmsSendService;
import mao.sms_sdk.utils.SmsEncryptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

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

    /**
     * 短信配置属性
     */
    private final SmsConfigurationProperties smsConfigurationProperties;

    /**
     * 短信发送服务impl
     *
     * @param smsConfigurationProperties 短信配置属性
     */
    public SmsSendServiceImpl(SmsConfigurationProperties smsConfigurationProperties)
    {
        this.smsConfigurationProperties = smsConfigurationProperties;
    }

    @Override
    public R<Boolean> sendSms(SmsParamsDTO smsParamsDTO)
    {
        String url = smsConfigurationProperties.getDomain() + smsConfigurationProperties.getSend();
        return send(smsParamsDTO,url);
    }

    @Override
    public R<Boolean> batchSendSms(SmsBatchParamsDTO smsBatchParamsDTO)
    {
        String url = smsConfigurationProperties.getDomain() + smsConfigurationProperties.getBatchSend();
        return send(smsBatchParamsDTO,url);
    }


    /**
     * 发送短信
     *
     * @param baseParamsDTO 基础参数dto
     * @param url           url
     * @return {@link R}<{@link Boolean}>
     */
    private R<Boolean> send(BaseParamsDTO baseParamsDTO, String url)
    {
        //设置accessKeyId
        baseParamsDTO.setAccessKeyId(smsConfigurationProperties.getAccessKeyId());
        if (smsConfigurationProperties.isAuth())
        {
            if (StringUtils.isBlank(smsConfigurationProperties.getAccessKeyId()) || StringUtils.isBlank(smsConfigurationProperties.getAccessKeySecret()))
            {
                R.fail("accessKey 不能为空");
            }
            baseParamsDTO.setTimestamp(String.valueOf(System.currentTimeMillis()));
            baseParamsDTO.setEncryption(SmsEncryptionUtils.encode(baseParamsDTO.getEncryption(), baseParamsDTO.getAccessKeyId(),
                    smsConfigurationProperties.getAccessKeySecret()));
        }

        if (StringUtils.isBlank(smsConfigurationProperties.getDomain()))
        {
            R.fail("domain 不能为空");
        }
        //HTTP客户端
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //Post请求对象
        HttpPost post = new HttpPost(url);
        //设置请求头
        post.setHeader("Content-Type", "application/json; charset=UTF-8");
        //构造请求体
        StringEntity stringEntity = new StringEntity(JSON.toJSONString(baseParamsDTO), "UTF-8");
        //设置请求体
        post.setEntity(stringEntity);

        try
        {
            //发送请求
            CloseableHttpResponse response = httpclient.execute(post);
            //获得响应信息
            HttpEntity entity = response.getEntity();
            //解析响应状态码
            if (200 == response.getStatusLine().getStatusCode())
            {
                log.info("httpRequest access success, StatusCode is:{}", response.getStatusLine()
                        .getStatusCode());
                String responseContent = EntityUtils.toString(entity);
                log.info("responseContent is :" + responseContent);
                return JSON.parseObject(responseContent, R.class);
            }
            else
            {
                log.error("httpRequest access fail ,StatusCode is:{}", response.getStatusLine().getStatusCode());
                return R.fail("status is " + response.getStatusLine().getStatusCode());
            }
        }
        catch (Exception e)
        {
            log.error("error :", e);
            return R.fail(e.getMessage());
        }
        finally
        {
            post.releaseConnection();
        }
    }
}
