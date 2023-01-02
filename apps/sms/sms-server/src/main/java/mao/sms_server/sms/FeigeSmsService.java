package mao.sms_server.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.undertow.util.StatusCodes;
import lombok.extern.slf4j.Slf4j;
import mao.sms_server.entity.SmsConfig;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.sms
 * Class(类名): FeigeSmsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/2
 * Time(创建时间)： 14:01
 * Version(版本): 1.0
 * Description(描述)： 飞鸽
 * http://sms.feige.ee/
 */

@Slf4j
public class FeigeSmsService extends AbstractSmsService
{
    public FeigeSmsService(SmsConfig config)
    {
        this.config = config;
    }

    @Override
    protected String sendSms(String mobile, Map<String, String> params, String signature, String template)
    {
        // 获取 签名内容 和模板id
        String signatureCode = signatureService.getConfigCodeByCode(config.getId(), signature);
        String templateCode = templateService.getConfigCodeByCode(config.getId(), template);

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost post = new HttpPost(config.getDomain());

        post.setHeader("Content-Type", "application/x-www-form-urlencoded");

        try
        {
            StringBuilder contentSbf = new StringBuilder();
            for (String value : params.values())
            {
                contentSbf.append(value).append("||");
            }
            if (contentSbf.length() >= 2)
            {
                contentSbf.deleteCharAt(contentSbf.length() - 1);
                contentSbf.deleteCharAt(contentSbf.length() - 1);
            }

            List<BasicNameValuePair> postParams = new ArrayList<>();
            postParams.add(new BasicNameValuePair("Account", config.getAccessKeyId()));
            postParams.add(new BasicNameValuePair("Pwd", config.getAccessKeySecret()));
            postParams.add(new BasicNameValuePair("Content", contentSbf.toString()));
            postParams.add(new BasicNameValuePair("Mobile", mobile));
            postParams.add(new BasicNameValuePair("TemplateId", templateCode));
            postParams.add(new BasicNameValuePair("SignId", signatureCode));

            HttpEntity httpEntity = new UrlEncodedFormEntity(postParams, "UTF-8");
            post.setEntity(httpEntity);

            CloseableHttpResponse response = httpclient.execute(post);

            HttpEntity entity = response.getEntity();

            if (StatusCodes.OK == response.getStatusLine().getStatusCode())
            {
                log.info("httpRequest access success, StatusCode is:{}", response.getStatusLine()
                        .getStatusCode());
                String responseContent = EntityUtils.toString(entity);
                //log.info("responseContent is :" + responseContent);
                JSONObject jsonObject = JSON.parseObject(responseContent);
                if (jsonObject.containsKey("Code") && jsonObject.getInteger("Code") == 0)
                {
                    return responseContent;
                }
                else
                {
                    return failResponse(jsonObject.getString("Message"), responseContent);
                }
            }
            else
            {
                log.error("httpRequest access fail ,StatusCode is:{}", response.getStatusLine().getStatusCode());
            }
        }
        catch (Exception e)
        {
            log.error("error :", e);
        }
        finally
        {
            post.releaseConnection();
        }
        return null;
        //{"SendId":"","InvalidCount":0,"SuccessCount":0,"BlackCount":0,"Code":10008,"Message":"模板Id不能为空"}
    }

    @Override
    protected String sendSmsBatch(String[] mobiles, LinkedHashMap<String, String>[] params, String[] signatures, String[] templates)
    {
        return null;
    }
}
