package mao.auth_server.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.auth_entity.entity.auth.RoleAuthority;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Interface(接口名): RoleAuthorityMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 20:55
 * Version(版本): 1.0
 * Description(描述)： 角色的资源
 */

@Mapper
public interface RoleAuthorityMapper extends BaseMapper<RoleAuthority>
{

}
