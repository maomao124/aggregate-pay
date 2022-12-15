package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.auth.RoleOrg;
import mao.auth_server.dao.auth.RoleOrgMapper;
import mao.auth_server.service.auth.RoleOrgService;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): RoleOrgServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 21:08
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Service
public class RoleOrgServiceImpl extends ServiceImpl<RoleOrgMapper, RoleOrg> implements RoleOrgService
{

    @Override
    public List<Long> listOrgByRoleId(Long id)
    {
        //查询
        List<RoleOrg> list = super.list(Wraps.<RoleOrg>lbQ().eq(RoleOrg::getRoleId, id));
        return list.stream().mapToLong(RoleOrg::getOrgId).boxed().collect(Collectors.toList());
    }
}
