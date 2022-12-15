package mao.auth_server.dao.core;

import mao.auth_entity.entity.core.Station;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.core
 * Class(测试类名): StationMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 22:37
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@SpringBootTest
class StationMapperTest
{

    @Autowired
    private StationMapper stationMapper;

    /**
     * 找到站页面
     */
    @Test
    void findStationPage()
    {

    }

    /**
     * 查询所有
     */
    @Test
    void queryAll()
    {
        List<Station> stationList = stationMapper.selectList(null);
        for (Station station : stationList)
        {
            System.out.println(station);
            System.out.println();
        }
    }
}