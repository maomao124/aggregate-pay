package mao.aggregate_pay_merchant_application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.config
 * Class(类名): QNFileConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/11
 * Time(创建时间)： 20:19
 * Version(版本): 1.0
 * Description(描述)： 七牛云配置属性类
 */

@Component
@ConfigurationProperties(prefix = "qn")
public class QNFileConfigurationProperties
{
    /**
     * 七牛云文件地址url的前缀
     */
    private String Url;

    /**
     * 访问密钥
     */
    private String accessKey;

    /**
     * 秘密密钥
     */
    private String secretKey;

    /**
     * 桶
     */
    private String bucket;


    /**
     * 构造方法
     */
    public QNFileConfigurationProperties()
    {

    }

    /**
     * 构造方法
     *
     * @param url       url
     * @param accessKey 访问密钥
     * @param secretKey 秘密密钥
     * @param bucket    桶
     */
    public QNFileConfigurationProperties(String url, String accessKey, String secretKey, String bucket)
    {
        Url = url;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucket = bucket;
    }

    public String getUrl()
    {
        return Url;
    }

    public void setUrl(String url)
    {
        Url = url;
    }

    public String getAccessKey()
    {
        return accessKey;
    }

    public void setAccessKey(String accessKey)
    {
        this.accessKey = accessKey;
    }

    public String getSecretKey()
    {
        return secretKey;
    }

    public void setSecretKey(String secretKey)
    {
        this.secretKey = secretKey;
    }

    public String getBucket()
    {
        return bucket;
    }

    public void setBucket(String bucket)
    {
        this.bucket = bucket;
    }
}
