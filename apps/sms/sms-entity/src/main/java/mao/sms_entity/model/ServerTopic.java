package mao.sms_entity.model;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.model
 * Class(类名): ServerTopic
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 20:24
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerTopic
{
    /**
     * 初始化连接
     */
    public static final String INIT_CONNECT = "INIT_CONNECT";
    /**
     * 使用新连接
     */
    public static final String USE_NEW_CONNECT = "USE_NEW_CONNECT";

    /**
     * 选项
     */
    private String option;

    /**
     * value
     */
    private String value;

    /**
     * 加载
     *
     * @param deserialize 反序列化
     * @return {@link ServerTopic}
     */
    public static ServerTopic load(String deserialize)
    {
        return JSON.parseObject(deserialize, ServerTopic.class);
    }

    public String toString()
    {
        return JSON.toJSONString(this);
    }
}
