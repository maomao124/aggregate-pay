package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_user_api.dto.tenant.AccountRoleQueryDTO;
import mao.aggregate_pay_user_service.entity.TenantAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): TenantAccountMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 19:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Mapper
public interface TenantAccountMapper extends BaseMapper<TenantAccount>
{
    /**
     * 选择用户名租户帐户
     *
     * @param username 用户名
     * @return int
     */
    @Select("select count(*) from tenant_account where ACCOUNT_ID IN(select id from account where USERNAME=#{username})")
    int selectTenantByUsernameInAccount(@Param("username") String username);


    /**
     * 删除账户租户
     *
     * @param tenantId  承租者id
     * @param accountId 帐户id
     */
    @Delete("delete from tenant_account where TENANT_ID=#{tenantId} and ACCOUNT_ID=#{accountId} ")
    void deleteAccountInTenant(@Param("tenantId") Long tenantId, @Param("accountId") Long accountId);


    /**
     * 选择账户角色
     *
     * @param username 用户名
     * @param roleCode 角色代码
     * @param tenantId 承租者id
     * @return {@link AccountRoleQueryDTO}
     */
    @Select("select ar.USERNAME as username,r.`NAME` as roleName,r.TENANT_ID as tenantId，ar.ID as id " +
            "from account_role ar " +
            "join authorization_role r on ar.ROLE_CODE=r.`CODE` " +
            "and ar.TENANT_ID=r.TENANT_ID " +
            "where r.TENANT_ID=#{tenantId} " +
            "and r.`CODE`=#{roleCode} " +
            "and ar.USERNAME=#{username}")
    AccountRoleQueryDTO selectAccountRole(@Param("username") String username, @Param("roleCode") String roleCode, @Param("tenantId") Long tenantId);
}
