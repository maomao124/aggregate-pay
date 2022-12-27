package mao.sms_sdk.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_sdk.dto
 * Class(类名): SmsParamsDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/27
 * Time(创建时间)： 19:57
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class SmsParamsDTO extends BaseParamsDTO
{
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 模板编码
     */
    private String template;

    /**
     * 签名编码
     */
    private String signature;

    /**
     * 参数
     */
    private Map<String, String> params;

}
