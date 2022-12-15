package mao.auth_server.dao.auth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Interface(接口名): ResourceMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 20:54
 * Version(版本): 1.0
 * Description(描述)： 资源
 */

@Mapper
public interface ResourceMapper extends BaseMapper<Resource>
{
    /**
     * 查询用户拥有的资源
     *
     * @param resource 资源
     * @return {@link List}<{@link Resource}>
     */
    List<Resource> findVisibleResource(ResourceQueryDTO resource);

    /**
     * 通过资源id找到菜单id
     *
     * @param resourceIdList 资源id列表
     * @return {@link List}<{@link Long}>
     */
    List<Long> findMenuIdByResourceId(@Param("resourceIdList") List<Long> resourceIdList);
}
