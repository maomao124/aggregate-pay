package mao.aggregate_pay_transaction_service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_service.properties
 * Class(类名): WeiXinConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/4
 * Time(创建时间)： 21:05
 * Version(版本): 1.0
 * Description(描述)： 微信相关配置
 */

@Data
@Component
@ConfigurationProperties(prefix = "weixin")
public class WeiXinConfigurationProperties
{
    /**
     * oauth2请求url
     */
    private String oauth2RequestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize";

    /**
     * oauth2代码返回url
     */
    private String oauth2CodeReturnUrl;

    /**
     * oauth2令牌
     */
    private String oauth2Token = "https://api.weixin.qq.com/sns/oauth2/access_token";

}
