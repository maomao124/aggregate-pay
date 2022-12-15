package mao.auth_server.service.common.impl;

import mao.auth_entity.entity.common.OptLog;
import mao.auth_server.service.common.OptLogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.common.impl
 * Class(测试类名): OptLogServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 19:40
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Transactional
@SpringBootTest
class OptLogServiceImplTest
{
    @Autowired
    private OptLogService optLogService;

    /**
     * 保存
     */
    @Test
    void save()
    {
        optLogService.save(OptLog.builder().build());
    }

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        List<OptLog> optLogList = optLogService.list();
        for (OptLog optLog : optLogList)
        {
            System.out.println(optLog);
            System.out.println();
        }
    }
}