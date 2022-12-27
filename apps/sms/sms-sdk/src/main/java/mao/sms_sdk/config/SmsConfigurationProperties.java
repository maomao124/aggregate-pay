package mao.sms_sdk.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_sdk.config
 * Class(类名): SmsConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/27
 * Time(创建时间)： 21:33
 * Version(版本): 1.0
 * Description(描述)： 无
 */
@Slf4j
@ConfigurationProperties(value = "sms")
public class SmsConfigurationProperties
{
    /**
     * 是否需要身份验证
     */
    private boolean auth;

    /**
     * 域
     */
    private String domain;

    /**
     * 访问密钥id
     */
    private String accessKeyId;

    /**
     * 访问密钥秘密
     */
    private String accessKeySecret;

    /**
     * 发送uri
     */
    private String send = "/sms/send";

    /**
     * 批量发送uri
     */
    private String batchSend = "/sms/batchSend";


    /**
     * Instantiates a new Sms configuration properties.
     */
    public SmsConfigurationProperties()
    {

    }

    /**
     * 短信配置属性
     *
     * @param auth            是否需要身份验证
     * @param domain          域
     * @param accessKeyId     访问密钥id
     * @param accessKeySecret 访问密钥秘密
     * @param send            发送uri
     * @param batchSend       批量发送uri
     */
    public SmsConfigurationProperties(boolean auth, String domain, String accessKeyId, String accessKeySecret, String send, String batchSend)
    {
        this.auth = auth;
        this.domain = domain;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.send = send;
        this.batchSend = batchSend;
    }


    public boolean isAuth()
    {
        return auth;
    }

    public void setAuth(boolean auth)
    {
        this.auth = auth;
    }

    public String getDomain()
    {
        return domain;
    }

    public void setDomain(String domain)
    {
        this.domain = domain;
    }

    public String getAccessKeyId()
    {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId)
    {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret()
    {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret)
    {
        this.accessKeySecret = accessKeySecret;
    }

    public String getSend()
    {
        return send;
    }

    public void setSend(String send)
    {
        this.send = send;
    }

    public String getBatchSend()
    {
        return batchSend;
    }

    public void setBatchSend(String batchSend)
    {
        this.batchSend = batchSend;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        SmsConfigurationProperties that = (SmsConfigurationProperties) o;

        if (isAuth() != that.isAuth())
        {
            return false;
        }
        if (getDomain() != null ? !getDomain().equals(that.getDomain()) : that.getDomain() != null)
        {
            return false;
        }
        if (getAccessKeyId() != null ? !getAccessKeyId().equals(that.getAccessKeyId()) : that.getAccessKeyId() != null)
        {
            return false;
        }
        if (getAccessKeySecret() != null ? !getAccessKeySecret().equals(that.getAccessKeySecret()) : that.getAccessKeySecret() != null)
        {
            return false;
        }
        if (getSend() != null ? !getSend().equals(that.getSend()) : that.getSend() != null)
        {
            return false;
        }
        return getBatchSend() != null ? getBatchSend().equals(that.getBatchSend()) : that.getBatchSend() == null;
    }

    @Override
    public int hashCode()
    {
        int result = (isAuth() ? 1 : 0);
        result = 31 * result + (getDomain() != null ? getDomain().hashCode() : 0);
        result = 31 * result + (getAccessKeyId() != null ? getAccessKeyId().hashCode() : 0);
        result = 31 * result + (getAccessKeySecret() != null ? getAccessKeySecret().hashCode() : 0);
        result = 31 * result + (getSend() != null ? getSend().hashCode() : 0);
        result = 31 * result + (getBatchSend() != null ? getBatchSend().hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("SmsConfigurationProperties{");
        sb.append("auth=").append(auth);
        sb.append(", domain='").append(domain).append('\'');
        sb.append(", accessKeyId='").append(accessKeyId).append('\'');
        sb.append(", accessKeySecret='").append(accessKeySecret).append('\'');
        sb.append(", send='").append(send).append('\'');
        sb.append(", batchSend='").append(batchSend).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
