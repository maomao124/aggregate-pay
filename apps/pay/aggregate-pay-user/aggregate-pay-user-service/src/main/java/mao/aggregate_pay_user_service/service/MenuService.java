package mao.aggregate_pay_user_service.service;

import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.menu.MenuDTO;
import mao.aggregate_pay_user_api.dto.menu.MenuQueryDTO;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.service
 * Interface(接口名): MenuService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 20:05
 * Version(版本): 1.0
 * Description(描述)： 菜单服务
 */

public interface MenuService
{

    /**
     * 根据ID查询菜单
     *
     * @param id id
     * @return {@link MenuDTO}
     */
    MenuDTO queryMenu(Long id);

    /**
     * 根据应用编码查询菜单列表
     *
     * @param applicationCode 应用程序代码
     * @return {@link List}<{@link MenuDTO}>
     */
    List<MenuDTO> queryMenuByApplicationCode(String applicationCode);

    /**
     * 根据条件查询菜单列表
     *
     * @param params   参数个数
     * @param pageNo   页面号码
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link MenuDTO}>
     */
    PageVO<MenuDTO> queryMenu(MenuQueryDTO params, Integer pageNo, Integer pageSize);

    /**
     * 根据权限编码列表获取菜单
     *
     * @param privileges 权限列表
     * @return {@link List}<{@link MenuDTO}>
     */
    List<MenuDTO> queryMenuByPrivileges(String[] privileges);

}
