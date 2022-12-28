package mao.sms_server.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.entity
 * Class(类名): SmsConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/28
 * Time(创建时间)： 19:34
 * Version(版本): 1.0
 * Description(描述)： 短信配置信息
 */

@Data
@ApiModel(description = "短信配置信息")
public class SmsConfig implements Serializable
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * 域
     */
    private String domain;

    /**
     * 名字
     */
    private String name;

    /**
     * 平台
     */
    @ApiModelProperty(value = "平台 ali：阿里云  mengwang：梦网")
    private String platform;

    /**
     * 访问密钥id
     */
    @ApiModelProperty(value = "AccessKeyId")
    private String accessKeyId;

    /**
     * 访问密钥秘密
     */
    @ApiModelProperty(value = "AccessKeySecret")
    private String accessKeySecret;

    /**
     * 其他配置
     */
    private LinkedHashMap<String, String> otherConfig = new LinkedHashMap<>();

    /**
     * 得到
     *
     * @param key 关键
     * @return {@link String}
     */
    public String get(String key)
    {
        return otherConfig.get(key);
    }

    /**
     * 集
     *
     * @param key   关键
     * @param value 价值
     */
    public void set(String key, String value)
    {
        this.otherConfig.put(key, value);
    }
}
