package mao.auth_server.service.core.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import mao.auth_entity.dto.core.StationPageDTO;
import mao.auth_entity.entity.core.Station;
import mao.auth_server.service.core.StationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.core.impl
 * Class(测试类名): StationServiceImplTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:43
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

@Slf4j
@Transactional
@SpringBootTest
class StationServiceImplTest
{

    @Autowired
    private StationService stationService;

    @Test
    void queryAll()
    {
        for (Station station : stationService.list())
        {
            System.out.println(station);
            System.out.println();
        }
    }

    @Test
    void findStationPage()
    {
        Page<Station> page = new Page<>(2, 2);
        IPage<Station> stationPage = stationService.findStationPage(page, StationPageDTO.builder().name("经理").build());
        List<Station> stationList = stationPage.getRecords();
        for (Station station : stationList)
        {
            System.out.println(station);
            System.out.println();
        }
    }
}