package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_user_service.entity.AuthorizationRolePrivilege;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): AuthorizationRolePrivilegeMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 18:16
 * Version(版本): 1.0
 * Description(描述)： 角色-权限关系
 */

@Mapper
public interface AuthorizationRolePrivilegeMapper extends BaseMapper<AuthorizationRolePrivilege>
{
    /**
     * 插入角色权限
     *
     * @param rid  ROLE_ID
     * @param pids PRIVILEGE_ID
     */
    @Insert("<script>" +
            "INSERT INTO authorization_role_privilege(ROLE_ID,PRIVILEGE_ID) VALUES " +
            "<foreach collection='pids' item='item'  separator=','>(#{rid},#{item})</foreach> " +
            "</script>")
        //@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "ID")
    void insertRolePrivilege(@Param("rid") Long rid, @Param("pids") List<Long> pids);
}
