package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_user_service.entity.AuthorizationRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): AuthorizationRoleMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 18:03
 * Version(版本): 1.0
 * Description(描述)： 角色信息
 */

@Mapper
public interface AuthorizationRoleMapper extends BaseMapper<AuthorizationRole>
{
    /**
     * 某个角色的权限
     *
     * @param id id
     * @return {@link List}<{@link String}>
     */
    @Select("select p.`CODE` from authorization_privilege p\n" +
            "\tLEFT JOIN authorization_role_privilege rp on rp.PRIVILEGE_ID = p.ID\n" +
            "\tLEFT JOIN authorization_role r on rp.ROLE_ID = r.ID\n" +
            "\twhere r.ID=#{id}")
    List<String> selectPrivilegeByRole(@Param("id") Long id);

    /**
     * 在租户下创建角色
     *
     * @param tenantId 承租者id
     * @param roles    角色
     */
    @Insert("<script>" +
            "INSERT INTO authorization_role(NAME,CODE,TENANT_ID) VALUES " +
            "<foreach collection='roles' item='item'  separator=','>(#{item.name},#{item.code},#{tenantId})</foreach> " +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "roles.id")
    void createRoles(@Param("tenantId") Long tenantId, @Param("roles") List<AuthorizationRole> roles);

    /**
     * 判断某租户下角色code是否存在
     *
     * @param tenantId 承租者id
     * @param roleCode 角色代码
     * @return int
     */
    @Select("select count(*) from authorization_role r where r.TENANT_ID=#{tenantId} and r.`CODE` =#{roleCode}")
    int selectRoleCodeInTenant(@Param("tenantId") Long tenantId, @Param("roleCode") String roleCode);
}
