package mao.auth_server.dao.auth;

import mao.auth_entity.entity.auth.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.auth
 * Class(测试类名): UserMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 21:58
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@SpringBootTest
class UserMapperTest
{

    @Autowired
    private UserMapper userMapper;

    /**
     * 找到用户角色id
     */
    @Test
    void findUserByRoleId()
    {
        List<User> userList = userMapper.findUserByRoleId(100L, null);
        for (User user : userList)
        {
            System.out.println(user);
            System.out.println();
        }
    }

    /**
     * 增加num通过id密码错误
     */
    @Test
    void incrPasswordErrorNumById()
    {
        int i = userMapper.incrPasswordErrorNumById(3L);
        System.out.println(i);
    }

    /**
     * 找到页面
     */
    @Test
    void findPage()
    {

    }

    /**
     * 重置通过错误num
     */
    @Test
    void resetPassErrorNum()
    {
        int i = userMapper.resetPassErrorNum(3L);
        System.out.println(i);
    }

    /**
     * 更新最后登录时间
     */
    @Test
    void updateLastLoginTime()
    {

    }

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        List<User> userList = userMapper.selectList(null);
        for (User user : userList)
        {
            System.out.println(user);
            System.out.println();
        }
    }
}