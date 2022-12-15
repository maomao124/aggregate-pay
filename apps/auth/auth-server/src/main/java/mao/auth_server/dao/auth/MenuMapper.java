package mao.auth_server.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.auth_entity.entity.auth.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Interface(接口名): MenuMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 20:53
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Mapper
public interface MenuMapper extends BaseMapper<Menu>
{
    /**
     * 查询用户可用菜单
     *
     * @param group  组
     * @param userId 用户id
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> findVisibleMenu(@Param("group") String group, @Param("userId") Long userId);
}
