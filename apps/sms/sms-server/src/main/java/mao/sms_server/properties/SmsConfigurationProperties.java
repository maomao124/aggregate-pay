package mao.sms_server.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.properties
 * Class(类名): SmsConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/28
 * Time(创建时间)： 19:36
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@Component
@ConfigurationProperties(prefix = "sms")
@RefreshScope
public class SmsConfigurationProperties
{
    /**
     * 消息最大失败次数
     */
    private int messageErrorNum;

    /**
     * 通道最大失败次数
     */
    private int configLevelFailNum;

    /**
     * 通道选举算法启动比例
     */
    private double configBuildScale;
}
