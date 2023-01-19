package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.aggregate_pay_user_api.dto.tenant.AccountDTO;
import mao.aggregate_pay_user_api.dto.tenant.AccountQueryDTO;
import mao.aggregate_pay_user_service.entity.Account;
import mao.aggregate_pay_user_service.entity.TenantAccount;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): AccountMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 21:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Mapper
public interface AccountMapper extends BaseMapper<Account>
{

    /**
     * 在租户通过移动选择帐户
     *
     * @param tenantId 承租者id
     * @param mobile   移动
     * @return int
     */
    @Select("select count(*) from account where mobile = #{mobile} " +
            "and exists (select ACCOUNT_ID ID from tenant_account where TENANT_ID=#{tenantId})")
    int selectAccountInTenantByMobile(@Param("tenantId") Long tenantId, @Param("mobile") String mobile);

    /**
     * 在租户选择账户名字
     *
     * @param tenantId 承租者id
     * @param username 用户名
     * @return int
     */
    @Select("select count(*) from account where USERNAME = #{username} " +
            "and exists (select ACCOUNT_ID ID from tenant_account where TENANT_ID=#{tenantId})")
    int selectAccountInTenantByName(@Param("tenantId") Long tenantId, @Param("username") String username);


    /**
     * 选择账户通过手机
     *
     * @param mobile 移动
     * @return int
     */
    @Select("select count(*) from account where MOBILE=#{mobile}")
    int selectAccountByMobile(@Param("mobile") String mobile);


    /**
     * 选择账户名字
     *
     * @param username 用户名
     * @return int
     */
    @Select("select count(*) from account where USERNAME=#{username}")
    int selectAccountByName(@Param("username") String username);

    /**
     * 删除账户
     *
     * @param accountId 帐户id
     */
    @Delete("delete from account where ID=#{accountId}")
    void deleteAccount(@Param("accountId") Long accountId);

    /**
     * 选择不管理
     *
     * @param tenantId 承租者id
     * @param username 用户名
     * @return {@link List}<{@link TenantAccount}>
     */
    @Select("select t.* from account a,tenant_account t "
            + "where a.id=t.ACCOUNT_ID "
            + "and TENANT_ID=#{tenantId} "
            + "and a.USERNAME=#{username} "
            + "and t.IS_ADMIN!=1")
    List<TenantAccount> selectNotAdmin(@Param("tenantId") Long tenantId, @Param("username") String username);


    /**
     * 选择账户作用
     *
     * @param tenantId 承租者id
     * @param roleCode 角色代码
     * @return boolean
     */
    @Select("select * from account a " +
            "LEFT JOIN account_role ar ON a.USERNAME=ar.USERNAME " +
            "LEFT JOIN authorization_role r ON r.`CODE`=ar.ROLE_CODE " +
            "WHERE r.TENANT_ID=#{tenantId}  " +
            "AND r.`CODE`=#{roleCode} ")
    Boolean selectAccountByRole(@Param("tenantId") Long tenantId, @Param("roleCode") String roleCode);

    /**
     * 选择账户页面
     *
     * @param page         页面
     * @param accountQuery 账户查询
     * @param sortBy       排序
     * @param order        订单
     * @return {@link List}<{@link AccountDTO}>
     */
    @Select("<script>"
            + "select * from account a "
            + "left join tenant_account ta on ta.ACCOUNT_ID=a.ID "
            + "left join tenant t on ta.TENANT_ID=t.ID "
            + "<where>"
            + "<if test=\"accountQuery.username != null and accountQuery.username!=''\"> "
            + "and a.NAME= #{tenantQuery.name} "
            + "</if>"
            + "<if test=\"tenantQuery.mobile != null and tenantQuery.mobile!=''\"> "
            + "and a.MOBILE= #{tenantQuery.mobile} "
            + "</if>"
            + "<if test=\"tenantQuery.tenantId != null and tenantQuery.tenantId!=''\"> "
            + "and t.ID IN #{tenantQuery.tenantId} "
            + "</if>"
            + "</where>"
            + " ORDER BY #{sortBy} #{order} "
            + "</script>")
    List<AccountDTO> selectAccountByPage(@Param("page") Page<AccountDTO> page, @Param("accountQuery") AccountQueryDTO accountQuery,
                                         @Param("sortBy") String sortBy, @Param("order") String order);


    /**
     * 选择账户由承租者id
     *
     * @param tenantId 承租者id
     * @return {@link List}<{@link Long}>
     */
    @Select("select a.id from account a " +
            "left join tenant_account ta on ta.ACCOUNT_ID=a.ID " +
            "left join tenant t on t.ID=ta.TENANT_ID " +
            " where t.id =#{tenantId}")
    List<Long> selectAccountByTenantId(@Param("tenantId") Long tenantId);

    /**
     * 根据租户id查询账号的信息
     *
     * @param tenantId 承租者id
     * @return {@link Account}
     */
    @Select("select a.* from account a " +
            " join tenant_account ta on ta.ACCOUNT_ID=a.ID " +
            " join tenant t on t.ID=ta.TENANT_ID " +
            " where t.id =#{tenantId}" +
            " AND ta.`IS_ADMIN`= 1")
    Account selectAccountInfoByTenantId(@Param("tenantId") Long tenantId);
}
