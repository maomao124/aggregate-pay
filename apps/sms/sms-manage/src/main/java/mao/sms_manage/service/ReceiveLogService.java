package mao.sms_manage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.ReceiveLogEntity;
import mao.sms_entity.vo.ReceiveLogVO;
import mao.sms_entity.vo.StatisticsCountVO;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service
 * Interface(接口名): ReceiveLogService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 19:00
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface ReceiveLogService extends IService<ReceiveLogEntity>
{
    /**
     * 分页查询
     *
     * @param page   页面
     * @param params 参数
     * @return {@link Page}<{@link ReceiveLogVO}>
     */
    Page<ReceiveLogVO> pageLog(Page<ReceiveLogVO> page, Map<String, Object> params);

    /**
     * 前10个
     *
     * @param params 参数
     * @return {@link List}<{@link StatisticsCountVO}>
     */
    List<StatisticsCountVO> top10(Map<?,?> params);

    /**
     * 趋势
     *
     * @param params 参数
     * @return {@link List}<{@link StatisticsCountVO}>
     */
    List<StatisticsCountVO> trend(Map<?,?> params);
}
