package mao.sms_entity.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.entity.enumeration
 * Class(类名): TemplateType
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:24
 * Version(版本): 1.0
 * Description(描述)： 枚举类-模板类型字段
 */

@Getter
@AllArgsConstructor
public enum TemplateType
{


    /**
     * 验证码
     */
    VERIFICATION(1, "验证码"),
    /**
     * 通知
     */
    NOTICE(2, "通知"),
    /**
     * 推广
     */
    MARKETING(3, "推广"),
    ;

    /**
     * 代码
     */
    private int code;

    /**
     * 描述
     */
    private String desc;


    /**
     * 得到描述
     *
     * @param code 代码
     * @return {@link TemplateType}
     */
    public static TemplateType getDesc(int code)
    {
        for (TemplateType it : TemplateType.values())
        {
            if (it.getCode() == code)
            {
                return it;
            }
        }
        return null;
    }
}
