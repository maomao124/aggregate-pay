package mao.tools_user.feign;

import lombok.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.feign
 * Class(类名): UserQuery
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:34
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserQuery
{
    /**
     * 是否查询SysUser对象所有信息，true则通过rpc接口查询
     */
    private Boolean full;

    /**
     * 是否只查询角色信息，true则通过rpc接口查询
     */
    private Boolean roles;

    /**
     * 是否只查询组织信息，true则通过rpc接口查询
     */
    private Boolean org;

    /**
     * 是否只查询岗位信息，true则通过rpc接口查询
     */
    private Boolean station;
}
