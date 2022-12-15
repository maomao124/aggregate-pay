package mao.auth_server.service.core.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.core.Org;
import mao.auth_server.dao.core.OrgMapper;
import mao.auth_server.service.core.OrgService;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.core.impl
 * Class(类名): OrgServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class OrgServiceImpl extends ServiceImpl<OrgMapper, Org> implements OrgService
{

    @Override
    public List<Org> findChildren(List<Long> ids)
    {
        //判断参数是否为空
        if (CollectionUtil.isEmpty(ids))
        {
            //参数为空，返回空集合
            return Collections.emptyList();
        }
        //步为空
        String applySql = String.format(" MATCH(tree_path) AGAINST('%s' IN BOOLEAN MODE) ", StringUtils.join(ids, " "));
        return super.list(Wraps.<Org>lbQ().in(Org::getId, ids).or(query -> query.apply(applySql)));
    }

    @Override
    public boolean remove(List<Long> ids)
    {
        List<Org> list = this.findChildren(ids);
        List<Long> idList = list.stream().mapToLong(Org::getId).boxed().collect(Collectors.toList());
        return idList.isEmpty() || super.removeByIds(idList);
    }
}
