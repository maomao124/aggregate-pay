package mao.auth_server.service.core;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.entity.core.Org;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.core
 * Interface(接口名): OrgService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:31
 * Version(版本): 1.0
 * Description(描述)： 组织
 */

public interface OrgService extends IService<Org>
{
    /**
     * 查询指定id集合下的所有子集
     *
     * @param ids id
     * @return {@link List}<{@link Org}>
     */
    List<Org> findChildren(List<Long> ids);

    /**
     * 批量删除以及删除其子节点
     *
     * @param ids id
     * @return boolean
     */
    boolean remove(List<Long> ids);
}
