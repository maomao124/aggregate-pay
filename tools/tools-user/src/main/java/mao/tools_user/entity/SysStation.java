package mao.tools_user.entity;

import lombok.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_user.entity
 * Class(类名): SysStation
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 12:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class SysStation
{
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 名称
     */
    private String name;

    /**
     * 组织ID
     * #pd_core_org
     */
    private Long orgId;

    /**
     * 排序
     */
    private Integer sortValue;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 描述
     */
    private String describe;
}
