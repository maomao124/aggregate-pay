package mao.aggregate_pay_uaa_api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_api.dto
 * Class(类名): MerchantLoginDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 13:41
 * Version(版本): 1.0
 * Description(描述)： 商户登录
 */

@Data
public class MerchantLoginDTO implements Serializable
{
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 名字
     */
    private String name;

    /**
     * 有效载荷
     */
    private Map<String,Object> payload;

    /**
     * 有效时间
     */
    private int effectiveTime;
}
