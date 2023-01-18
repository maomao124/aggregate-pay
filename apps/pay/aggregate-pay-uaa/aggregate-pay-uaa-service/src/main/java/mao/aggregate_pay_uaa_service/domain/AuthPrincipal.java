package mao.aggregate_pay_uaa_service.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.domain
 * Class(类名): AuthPrincipal
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 14:12
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
public class AuthPrincipal
{
    /**
     * 用户名
     */
    private String username;

    /**
     * 域
     */
    private String domain;

    /**
     * 认证的类型  password:用户名密码模式类型   sms:短信模式类型
     */
    private String authenticationType;

    /**
     * 附加数据，不同认证类型可拥有不同的附加数据
     */
    private Map<String,Object> payload = new HashMap<>();
}
