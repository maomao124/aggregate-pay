package mao.auth_server.service.core;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.dto.core.StationPageDTO;
import mao.auth_entity.entity.core.Station;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.core
 * Interface(接口名): StationService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:40
 * Version(版本): 1.0
 * Description(描述)： 岗位
 */

public interface StationService extends IService<Station>
{
    /**
     * 分页
     */
    IPage<Station> findStationPage(Page page, StationPageDTO data);
}
