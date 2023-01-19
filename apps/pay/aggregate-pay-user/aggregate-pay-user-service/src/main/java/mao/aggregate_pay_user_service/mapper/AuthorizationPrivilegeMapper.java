package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_user_api.dto.tenant.TenRolePrivilegeDTO;
import mao.aggregate_pay_user_service.entity.AuthorizationPrivilege;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): AuthorizationPrivilegeMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 13:31
 * Version(版本): 1.0
 * Description(描述)： 权限
 */

@Mapper
public interface AuthorizationPrivilegeMapper extends BaseMapper<AuthorizationPrivilege>
{
    /**
     * select权限角色
     *
     * @param roleIds 角色id
     * @return {@link List}<{@link AuthorizationPrivilege}>
     */
    @Select("<script>" +
            "SELECT  p.* FROM authorization_privilege p \n" +
            "\tLEFT JOIN authorization_role_privilege arp ON arp.PRIVILEGE_ID=p.ID\n" +
            "\tLEFT JOIN authorization_role r ON arp.ROLE_ID=r.ID\n" +
            "\tWHERE r.ID IN <foreach collection='roleIds' item='item' open='(' separator=',' close=')'>#{item}</foreach> " +
            "</script>")
    List<AuthorizationPrivilege> selectPrivilegeByRole(@Param("roleIds") List<Long> roleIds);


    /**
     * 在租户select权限角色
     *
     * @param roleIds 角色id
     * @return {@link List}<{@link TenRolePrivilegeDTO}>
     */
    @Select("<script>" +
            "select r.TENANT_ID,r.`CODE` ROLE_CODE,p.`CODE` PRIVILEGE_CODE from authorization_privilege p " +
            "LEFT JOIN authorization_role_privilege arp ON arp.PRIVILEGE_ID=p.ID " +
            "LEFT JOIN authorization_role r ON arp.ROLE_ID = r.ID " +
            "where r.ID IN <foreach collection='roleIds' item='item' open='(' separator=',' close=')'>#{item}</foreach> " +
            "ORDER BY r.TENANT_ID " +
            "</script>")
    List<TenRolePrivilegeDTO> selectPrivilegeRoleInTenant(@Param("roleIds") List<Long> roleIds);
}
