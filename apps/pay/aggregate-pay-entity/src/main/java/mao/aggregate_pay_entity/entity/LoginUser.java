package mao.aggregate_pay_entity.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_entity.entity
 * Class(类名): LoginUser
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/23
 * Time(创建时间)： 22:09
 * Version(版本): 1.0
 * Description(描述)： 登录的用户
 */

@Data
public class LoginUser
{
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 有效载荷
     */
    private Map<String, Object> payload = new HashMap<>();

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 租户id
     */
    private Long tenantId;
}
