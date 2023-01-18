package mao.aggregate_pay_uaa_service.integration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.integration
 * Class(类名): RestOAuthExceptionJacksonSerializer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 14:02
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class RestOAuthExceptionJacksonSerializer extends StdSerializer<RestOAuth2Exception>
{
    protected RestOAuthExceptionJacksonSerializer()
    {
        super(RestOAuth2Exception.class);
    }


    /**
     * 序列化
     *
     * @param restOAuth2Exception 异常
     * @param jsonGenerator       json生成器
     * @param serializerProvider  序列化器供应商
     * @throws IOException ioexception
     */
    @Override
    public void serialize(RestOAuth2Exception restOAuth2Exception, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException
    {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("errCode", restOAuth2Exception.getHttpErrorCode());
        String errorMessage = restOAuth2Exception.getOAuth2ErrorCode();
        if (errorMessage != null)
        {
            errorMessage = HtmlUtils.htmlEscape(errorMessage);
        }
        jsonGenerator.writeStringField("errMessage", restOAuth2Exception.getMessage());
        //jsonGenerator.writeStringField("errMessage", errorMessage);
        //String summary = restOAuth2Exception.getSummary();
        //jsonGenerator.writeStringField("result", summary);

        if (restOAuth2Exception.getAdditionalInformation() != null)
        {
            for (Map.Entry<String, String> entry : restOAuth2Exception.getAdditionalInformation().entrySet())
            {
                String key = entry.getKey();
                String add = entry.getValue();
                jsonGenerator.writeStringField(key, add);
            }
        }
        jsonGenerator.writeEndObject();
    }
}
