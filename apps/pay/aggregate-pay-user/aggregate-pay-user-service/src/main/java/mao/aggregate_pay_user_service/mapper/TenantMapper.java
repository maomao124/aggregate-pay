package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.aggregate_pay_user_api.dto.tenant.AccountRoleDTO;
import mao.aggregate_pay_user_api.dto.tenant.AccountRoleQueryDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenantDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenantQueryDTO;
import mao.aggregate_pay_user_service.entity.Tenant;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): TenantMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 19:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Mapper
public interface TenantMapper extends BaseMapper<Tenant>
{

    /**
     * 向租户-账号中间表插入数据
     *
     * @param id1     id1
     * @param id2     id2
     * @param isAdmin 是管理
     */
    @Insert("insert into tenant_account(TENANT_ID,ACCOUNT_ID,IS_ADMIN) values(#{id1},#{id2},#{isAdmin})")
    void insertTenantAccount(@Param("id1") Long id1, @Param("id2") Long id2, @Param("isAdmin") Boolean isAdmin);


    /**
     * 在租户选择账户
     *
     * @param id id
     * @return {@link List}<{@link TenantDTO}>
     */
    @Select("select t.* from tenant t \n" +
            "left join tenant_account ta ON t.ID=ta.TENANT_ID \n" +
            "left join account a on a.ID =ta.ACCOUNT_ID \n" +
            "where ta.ACCOUNT_ID=#{id}")
    List<TenantDTO> selectAccountInTenant(@Param("id") Long id);

    /**
     * 分页检索租户
     *
     * @param page        页面
     * @param tenantQuery 房客查询
     * @param sortBy      排序
     * @param order       订单
     * @return {@link List}<{@link TenantDTO}>
     */
    @Select("<script>"
            + "select * from tenant t "
            + "<where>"
            + "<if test=\"tenantQuery.name != null and tenantQuery.name!=''\"> "
            + "and t.NAME= #{tenantQuery.name} "
            + "</if>"
            + "<if test=\"tenantQuery.tenantTypeCode != null and tenantQuery.tenantTypeCode!=''\"> "
            + "and t.TENANT_TYPE_CODE= #{tenantQuery.tenantTypeCode} "
            + "</if>"
            + "</where>"
            + " ORDER BY #{sortBy} #{order} "
            + "</script>")
    List<TenantDTO> selectTenantByPage(@Param("page") Page<TenantDTO> page, @Param("tenantQuery") TenantQueryDTO tenantQuery,
                                       @Param("sortBy") String sortBy, @Param("order") String order);


    /**
     * 查询管理员页面
     *
     * @param page  页面
     * @param query 查询
     * @return {@link List}<{@link AccountRoleQueryDTO}>
     */
    @Select("select ar.USERNAME as username,ar.TENANT_ID as tenantId,r.`NAME` as roleName from account_role ar " +
            "join account a on ar.USERNAME = a.USERNAME " +
            "join authorization_role r on ar.TENANT_ID= r.TENANT_ID and ar.ROLE_CODE=r.`CODE` " +
            "where a.USERNAME=#{query.username} " +
            "and r.TENANT_ID=#{query.tenantId}")
    List<AccountRoleQueryDTO> queryAdministratorByPage(@Param("page") Page<AccountRoleQueryDTO> page, @Param("query") AccountRoleDTO query);
}
