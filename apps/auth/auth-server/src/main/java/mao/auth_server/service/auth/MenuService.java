package mao.auth_server.service.auth;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.entity.auth.Menu;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth
 * Interface(接口名): MenuService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 22:03
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface MenuService extends IService<Menu>
{
    /**
     * 根据ID删除菜单
     *
     * @param ids id
     * @return boolean
     */
    boolean removeByIds(List<Long> ids);

    /**
     * 查询用户可用菜单
     *
     * @param group  组
     * @param userId 用户id
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> findVisibleMenu(String group, Long userId);
}
