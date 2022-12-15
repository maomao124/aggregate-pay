package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.auth.Menu;
import mao.auth_server.dao.auth.MenuMapper;
import mao.auth_server.service.auth.MenuService;
import mao.auth_server.service.auth.ResourceService;
import mao.tools_core.utils.NumberHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static mao.tools_core.utils.StrPool.DEF_PARENT_ID;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): MenuServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 22:04
 * Version(版本): 1.0
 * Description(描述)： 菜单服务实现类
 */

@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService
{

    @Resource
    private ResourceService resourceService;

    @Override
    public boolean removeByIds(List<Long> ids)
    {
        //判断是否为空
        if (ids.isEmpty())
        {
            //为空，返回true
            return true;
        }
        //根据id移除菜单，注意，不要删掉super关键字，也不要用this
        boolean b = super.removeByIds(ids);
        if (b)
        {
            //删除成功
            //删除资源
            resourceService.removeByMenuId(ids);
        }
        return b;
    }

    @Override
    public List<Menu> findVisibleMenu(String group, Long userId)
    {
        return baseMapper.findVisibleMenu(group, userId);
    }

    /**
     * 保存，覆盖框架保存方法
     *
     * @param menu 菜单
     * @return boolean
     */
    @Override
    public boolean save(Menu menu)
    {
        menu.setIsEnable(NumberHelper.getOrDef(menu.getIsEnable(), true));
        menu.setIsPublic(NumberHelper.getOrDef(menu.getIsPublic(), false));
        menu.setParentId(NumberHelper.getOrDef(menu.getParentId(), DEF_PARENT_ID));

        super.save(menu);
        return true;
    }
}
