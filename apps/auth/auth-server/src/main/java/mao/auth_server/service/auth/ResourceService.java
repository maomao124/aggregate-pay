package mao.auth_server.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): ResourceService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 22:21
 * Version(版本): 1.0
 * Description(描述)： 资源Service
 */

public interface ResourceService extends IService<Resource>
{
    /**
     * 查询 拥有的资源
     *
     * @param resource 资源
     * @return {@link List}<{@link Resource}>
     */
    List<Resource> findVisibleResource(ResourceQueryDTO resource);

    /**
     * 根据菜单id删除资源
     *
     * @param menuIds 菜单id
     */
    void removeByMenuId(List<Long> menuIds);

    /**
     * 根据资源id 查询菜单id
     *
     * @param resourceIdList 资源id列表
     * @return {@link List}<{@link Long}>
     */
    List<Long> findMenuIdByResourceId(List<Long> resourceIdList);
}
