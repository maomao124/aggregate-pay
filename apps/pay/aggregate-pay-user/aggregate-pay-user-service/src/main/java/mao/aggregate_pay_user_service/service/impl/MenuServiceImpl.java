package mao.aggregate_pay_user_service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.menu.MenuDTO;
import mao.aggregate_pay_user_api.dto.menu.MenuQueryDTO;
import mao.aggregate_pay_user_service.entity.ResourceMenu;
import mao.aggregate_pay_user_service.mapper.ResourceMenuMapper;
import mao.aggregate_pay_user_service.service.MenuService;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.service.impl
 * Class(类名): MenuServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 20:22
 * Version(版本): 1.0
 * Description(描述)： 菜单服务实现类
 */

@Slf4j
@Service
public class MenuServiceImpl implements MenuService
{
    @Resource
    private ResourceMenuMapper resourceMenuMapper;

    @Resource
    private DozerUtils dozerUtils;


    /**
     * 根据ID查询菜单
     *
     * @param id id
     * @return {@link MenuDTO}
     */
    @Override
    public MenuDTO queryMenu(Long id)
    {
        ResourceMenu resourceMenu = resourceMenuMapper.selectById(id);
        MenuDTO menuDTO = dozerUtils.map(resourceMenu, MenuDTO.class);
        return menuDTO;
    }

    /**
     * 根据应用编码查询菜单列表
     *
     * @param applicationCode 应用程序代码
     * @return {@link List}<{@link MenuDTO}>
     */
    @Override
    public List<MenuDTO> queryMenuByApplicationCode(String applicationCode)
    {
        List<ResourceMenu> resourceMenus = resourceMenuMapper.selectList(new QueryWrapper<ResourceMenu>().lambda()
                .eq(ResourceMenu::getApplicationCode, applicationCode));
        List<MenuDTO> menuDTOS = dozerUtils.mapList(resourceMenus, MenuDTO.class);
        return menuDTOS;
    }

    /**
     * 根据条件查询菜单列表
     *
     * @param pageSize 页面大小
     * @param pageNo   页号
     * @param params   参数
     * @return {@link PageVO}<{@link MenuDTO}>
     */
    @Override
    public PageVO<MenuDTO> queryMenu(MenuQueryDTO params, Integer pageNo, Integer pageSize)
    {
        //参数 applicationCode（app表） title status（菜单表）
        pageSize = (pageSize == null ? 20 : pageSize);
        Page<MenuDTO> page = new Page<>(pageNo, pageSize);// 当前页，总条数 构造 page 对象
        List<MenuDTO> menus = resourceMenuMapper.selectByPage(page, params);
        return new PageVO<>(menus, page.getTotal(), pageNo, pageSize);
    }

    /**
     * 根据权限编码列表获取菜单
     *
     * @param privileges 权限列表
     * @return {@link List}<{@link MenuDTO}>
     */
    @Override
    public List<MenuDTO> queryMenuByPrivileges(String[] privileges)
    {
        List<String> privilege = Arrays.asList(privileges);
        List<ResourceMenu> resourceMenus = resourceMenuMapper.selectList(new QueryWrapper<ResourceMenu>().lambda()
                .in(ResourceMenu::getPrivilegeCode, privilege));
        List<MenuDTO> menuDTOS = dozerUtils.mapList(resourceMenus, MenuDTO.class);
        return menuDTOS;
    }
}
