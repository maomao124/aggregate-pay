package mao.auth_server.dao.common;

import mao.auth_entity.entity.common.OptLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.common
 * Class(测试类名): OptLogMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 22:34
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class OptLogMapperTest
{

    @Autowired
    private OptLogMapper optLogMapper;

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        List<OptLog> optLogList = optLogMapper.selectList(null);
        for (OptLog optLog : optLogList)
        {
            System.out.println(optLog);
            System.out.println();
        }
    }
}