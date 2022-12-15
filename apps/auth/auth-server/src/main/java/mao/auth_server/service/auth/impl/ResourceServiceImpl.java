package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import mao.auth_server.dao.auth.ResourceMapper;
import mao.auth_server.service.auth.ResourceService;
import mao.tools_core.base.id.CodeGenerate;
import mao.tools_core.exception.BizException;
import mao.tools_core.utils.StrHelper;
import mao.tools_databases.mybatis.conditions.Wraps;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): ResourceServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 22:22
 * Version(版本): 1.0
 * Description(描述)： 资源服务实现类
 */

@Slf4j
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService
{

    //@Autowired
    //private CacheChannel cacheChannel;

    @Autowired
    private CodeGenerate codeGenerate;


    @Override
    public List<Resource> findVisibleResource(ResourceQueryDTO resource)
    {
        return baseMapper.findVisibleResource(resource);
    }

    @Override
    public void removeByMenuId(List<Long> menuIds)
    {
        //查询这些资源，根据菜单id
        List<Resource> resourceList = this.list(Wraps.<Resource>lbQ().in(Resource::getMenuId, menuIds));
        //判断是否为空
        if (resourceList.isEmpty())
        {
            //为空，没必要移除，返回
            return;
        }
        //不为空
        //获得id列表
        List<Long> idList = resourceList.stream().mapToLong(Resource::getId).boxed().collect(Collectors.toList());
        //移除
        this.removeByIds(idList);
    }

    @Override
    public List<Long> findMenuIdByResourceId(List<Long> resourceIdList)
    {
        return baseMapper.findMenuIdByResourceId(resourceIdList);
    }

    /**
     * 保存
     * 覆盖框架里的save方法
     *
     * @param resource 资源
     * @return boolean
     */
    @Override
    public boolean save(Resource resource)
    {
        resource.setCode(StrHelper.getOrDef(resource.getCode(), codeGenerate.next()));
        if (super.count(Wraps.<Resource>lbQ().eq(Resource::getCode, resource.getCode())) > 0)
        {
            throw BizException.validFail("[%s]重复", resource.getCode());
        }
        super.save(resource);
        return true;
    }
}
