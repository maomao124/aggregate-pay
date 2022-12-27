package mao.sms_sdk.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_sdk.dto
 * Class(类名): SmsBatchParamsDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/27
 * Time(创建时间)： 19:55
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class SmsBatchParamsDTO extends BaseParamsDTO
{
    /**
     * 手机号集合
     */
    private List<String> mobile = new ArrayList<>();

    /**
     * 模板编码集合
     */
    private List<String> template = new ArrayList<>();

    /**
     * 签名编码集合
     */
    private List<String> signature = new ArrayList<>();

    /**
     * 参数集合
     */
    private List<LinkedHashMap<String, String>> params = new ArrayList<>();

    /**
     * 批次编码
     */
    private String batchCode;

    /**
     * 添加手机号
     *
     * @param mobile 手机号
     * @return {@link SmsBatchParamsDTO}
     */
    public SmsBatchParamsDTO addMobile(String mobile)
    {
        this.mobile.add(mobile);
        return this;
    }

    /**
     * 添加模板
     *
     * @param template 模板
     * @return {@link SmsBatchParamsDTO}
     */
    public SmsBatchParamsDTO addTemplate(String template)
    {
        this.template.add(template);
        return this;
    }

    /**
     * 添加签名
     *
     * @param signature 签名
     * @return {@link SmsBatchParamsDTO}
     */
    public SmsBatchParamsDTO addSignature(String signature)
    {
        this.signature.add(signature);
        return this;
    }

    /**
     * 添加参数
     *
     * @param params 参数
     * @return {@link SmsBatchParamsDTO}
     */
    public SmsBatchParamsDTO addParams(LinkedHashMap<String, String> params)
    {
        this.params.add(params);
        return this;
    }
}
