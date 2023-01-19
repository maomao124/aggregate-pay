package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_user_service.entity.AccountRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): AccountRoleMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 13:16
 * Version(版本): 1.0
 * Description(描述)： 账号-角色关系
 */

@Mapper
public interface AccountRoleMapper extends BaseMapper<AccountRole>
{
    /**
     * 删除租户用户名
     *
     * @param tenantId 承租者id
     * @param username 用户名
     */
    @Delete("delete from account_role r where  r.TENANT_ID=#{tenantId} and a.username=#{username} ")
    void deleteByUsernameInTenant(@Param("tenantId") Long tenantId, @Param("username") String username);

    /**
     * 获取用户在多租户下的角色
     *
     * @param username 用户名
     * @param ids      id
     * @return {@link List}<{@link Long}>
     */
    @Select("<script> " +
            "SELECT r.id FROM " +
            "account_role ar, authorization_role r " +
            "WHERE r.`CODE` = ar.ROLE_CODE " +
            "AND r.`TENANT_ID` = ar.`TENANT_ID` " +
            "AND ar.username=#{username}  " +
            "and ar.TENANT_ID in <foreach collection='ids' item='id' open='(' separator=',' close=')'>#{id}</foreach> " +
            "</script>")
    List<Long> selectRoleByUsernameInTenants(@Param("username") String username, @Param("ids") List<Long> ids);

    /**
     * 绑定角色
     *
     * @param username 用户名
     * @param tenantId 承租者id
     * @param roleList 角色列表
     */
    @Insert("<script>" +
            "INSERT INTO account_role(USERNAME,ROLE_CODE,TENANT_ID) VALUES " +
            "<foreach collection='roleList' item='item' separator=','>(#{username},#{item},#{tenantId})</foreach> " +
            "</script>")
    //@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "ID")
    void insertAccountRole(@Param("username") String username, @Param("tenantId") Long tenantId, @Param("roleList") List<String> roleList);
}
