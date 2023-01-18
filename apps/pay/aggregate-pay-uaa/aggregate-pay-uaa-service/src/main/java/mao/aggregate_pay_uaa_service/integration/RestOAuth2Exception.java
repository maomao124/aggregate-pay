package mao.aggregate_pay_uaa_service.integration;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.integration
 * Class(类名): RestOAuth2Exception
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 14:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@JsonSerialize(using = RestOAuthExceptionJacksonSerializer.class)
public class RestOAuth2Exception extends OAuth2Exception
{
    public RestOAuth2Exception(String msg, Throwable t) {
        super(msg, t);
    }

    public RestOAuth2Exception(String msg) {
        super(msg);
    }
}
