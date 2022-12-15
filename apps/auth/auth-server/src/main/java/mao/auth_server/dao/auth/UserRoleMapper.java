package mao.auth_server.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.auth_entity.entity.auth.UserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Interface(接口名): UserRoleMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 21:01
 * Version(版本): 1.0
 * Description(描述)： 账号角色绑定
 */

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole>
{

}
