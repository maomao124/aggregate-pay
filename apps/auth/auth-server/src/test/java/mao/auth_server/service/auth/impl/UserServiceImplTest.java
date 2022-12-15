package mao.auth_server.service.auth.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.auth_entity.dto.auth.UserUpdatePasswordDTO;
import mao.auth_entity.entity.auth.User;
import mao.auth_entity.enumeration.auth.Sex;
import mao.auth_server.service.auth.UserService;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(测试类名): UserServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 21:51
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */


@Transactional
@SpringBootTest
class UserServiceImplTest
{

    @Autowired
    private UserService userService;

    /**
     * Query all.
     */
    @Test
    void queryAll()
    {
        List<User> userList = userService.query().list();
        for (User user : userList)
        {
            System.out.println(user);
            System.out.println();
        }
    }

    /**
     * Find user by role id.
     */
    @Test
    void findUserByRoleId()
    {
        List<User> userList = userService.findUserByRoleId(100L, null);
        for (User user : userList)
        {
            System.out.println(user);
            System.out.println();
        }
    }

    /**
     * Update password error num by id.
     */
    @Test
    void updatePasswordErrorNumById()
    {
        userService.updatePasswordErrorNumById(3L);
    }

    /**
     * Gets by account.
     */
    @Test
    void getByAccount()
    {
        User user = userService.getByAccount("test");
        System.out.println(user);
    }

    /**
     * Update login time.
     */
    @Test
    void updateLoginTime()
    {
        userService.updateLoginTime("test");
        userService.updateLoginTime("123");
    }

    /**
     * Save user.
     */
    @Test
    void saveUser()
    {
        User user = userService.saveUser(User.builder().id(4L).email("1234@qq.com")
                .password("123").sex(Sex.M).account("4")
                .name("测试用户").build());
        System.out.println(user);
    }

    /**
     * Reset.
     */
    @Test
    void reset()
    {
        List<Long> list = new ArrayList<>();
        list.add(4L);
        userService.reset(list);
    }

    /**
     * Update user.
     */
    @Test
    void updateUser()
    {
        User user = User.builder().id(3L).email("1234@qq.com")
                .password("123").sex(Sex.M).account("3")
                .name("测试用户").build();
        user.setEmail("123@qq.com");
        User updateUser = userService.updateUser(user);
        System.out.println(updateUser);
    }

    /**
     * Remove user.
     */
    @Test
    void removeUser()
    {
        List<Long> list = new ArrayList<>();
        list.add(4L);
        boolean b = userService.removeUser(list);
        System.out.println(b);
    }

    /**
     * Find page.
     */
    @Test
    void findPage()
    {
        IPage<User> page = new Page<>(1, 2);
        IPage<User> iPage = userService.findPage(page, Wraps.lbQ());
        System.out.println(iPage.getRecords());
    }

    /**
     * Update password 1.
     */
    @Test
    void updatePassword1()
    {
        try
        {
            Boolean aBoolean = userService.updatePassword(UserUpdatePasswordDTO.builder()
                    .id(4L).oldPassword("12345").password("1234567")
                    .confirmPassword("123456").build());
            System.out.println(aBoolean);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Update password 2.
     */
    @Test
    void updatePassword2()
    {
        try
        {
            Boolean aBoolean = userService.updatePassword(UserUpdatePasswordDTO.builder()
                    .id(4L).oldPassword("12345").password("1234567")
                    .confirmPassword("1234567").build());
            System.out.println(aBoolean);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Update password 3.
     */
    @Test
    void updatePassword3()
    {
        Boolean aBoolean = userService.updatePassword(UserUpdatePasswordDTO.builder()
                .id(3L).oldPassword("123").password("123456")
                .confirmPassword("123456").build());
        System.out.println(aBoolean);
    }

    /**
     * Reset pass error num.
     */
    @Test
    void resetPassErrorNum()
    {
        int i = userService.resetPassErrorNum(3L);
        System.out.println(i);
    }
}