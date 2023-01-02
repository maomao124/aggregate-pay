package mao.sms_server.sms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.undertow.util.StatusCodes;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.entity.SignatureEntity;
import mao.sms_entity.entity.TemplateEntity;
import mao.sms_entity.utils.StringHelper;
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
 * Class(类名): LeXinSmsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/2
 * Time(创建时间)： 14:14
 * Version(版本): 1.0
 * Description(描述)： 乐信
 * https://webv2.lx198.com/index.html
 */

@Slf4j
public class LeXinSmsService extends AbstractSmsService
{
    public LeXinSmsService(SmsConfig config)
    {
        this.config = config;
    }

    @Override
    protected String sendSms(String mobile, Map<String, String> params, String signature, String template)
    {
        // 获取 签名内容 和模板id
        SignatureEntity signatureEntity = signatureService.getByCode(signature);
        TemplateEntity templateEntity = templateService.getByCode(template);

        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpPost post = new HttpPost(config.getDomain() + config.get("single_send"));

        post.setHeader("Content-Type", "application/x-www-form-urlencoded");

        try
        {

            List<BasicNameValuePair> postParams = new ArrayList<>();
            postParams.add(new BasicNameValuePair("accName", config.getAccessKeyId()));
            postParams.add(new BasicNameValuePair("accPwd", config.getAccessKeySecret()));
            postParams.add(new BasicNameValuePair("aimcodes", mobile));
            postParams.add(new BasicNameValuePair("content", "【" + signatureEntity.getContent() + "】" +
                    StringHelper.renderString(templateEntity.getContent(), params)));

            HttpEntity httpEntity = new UrlEncodedFormEntity(postParams, "UTF-8");
            post.setEntity(httpEntity);

            CloseableHttpResponse response = httpclient.execute(post);

            HttpEntity entity = response.getEntity();

            if (StatusCodes.OK == response.getStatusLine().getStatusCode())
            {
                log.info("httpRequest access success, StatusCode is:{}", response.getStatusLine()
                        .getStatusCode());
                String responseContent = EntityUtils.toString(entity);
                JSONObject jsonObject = JSON.parseObject(responseContent);
                if (jsonObject.containsKey("replyCode") && jsonObject.getInteger("replyCode") == 1)
                {
                    return responseContent;
                }
                else
                {
                    return failResponse(jsonObject.getString("replyMsg"), responseContent);
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
    }

    @Override
    protected String sendSmsBatch(String[] mobiles, LinkedHashMap<String, String>[] params, String[] signatures, String[] templates)
    {
        return null;
    }
}
