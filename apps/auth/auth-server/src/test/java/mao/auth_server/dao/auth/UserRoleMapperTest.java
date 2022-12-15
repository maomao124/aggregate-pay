package mao.auth_server.dao.auth;

import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.entity.auth.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Class(测试类名): UserRoleMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 22:11
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@SpringBootTest
class UserRoleMapperTest
{
    @Autowired
    private UserRoleMapper userRoleMapper;

    /**
     * 查询所有
     */
    @Test
    void QueryAll()
    {
        List<UserRole> userRoleList = userRoleMapper.selectList(null);
        for (UserRole userRole : userRoleList)
        {
            log.debug(userRole.toString());
        }
        log.info(userRoleList.size() + "");
    }
}