package mao.sms_manage.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.SendLogEntity;
import mao.sms_entity.vo.MarketingStatisticsCountVO;
import mao.sms_entity.vo.SendLogPageVO;
import mao.sms_entity.vo.SendLogVO;
import mao.sms_entity.vo.StatisticsCountVO;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service
 * Interface(接口名): SendLogService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 19:02
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface SendLogService extends IService<SendLogEntity>
{
    /**
     * 分页查询
     *
     * @param page   页面
     * @param params 参数个数
     * @return {@link Page}<{@link SendLogVO}>
     */
    Page<SendLogVO> pageLog(Page<SendLogVO> page, Map<String, Object> params);

    /**
     * 趋势
     *
     * @param params 参数
     * @return {@link List}<{@link StatisticsCountVO}>
     */
    List<StatisticsCountVO> trend(Map<?,?> params);

    /**
     * 统计页面
     *
     * @param page   页面
     * @param params 参数
     * @return {@link Page}<{@link StatisticsCountVO}>
     */
    Page<StatisticsCountVO> countPage(Page<StatisticsCountVO> page, Map<String, Object> params);

    /**
     * 配置计数
     *
     * @param params 参数
     * @return {@link List}<{@link Map}<{@link ?},{@link ?}>>
     */
    List<Map<?,?>> countForConfig(Map<?,?> params);

    /**
     * 配置
     *
     * @param params 参数
     * @return {@link List}<{@link Map}<{@link ?},{@link ?}>>
     */
    List<Map<?,?>> rateForConfig(Map<?,?> params);

    /**
     * 获得市场营销由业务id数
     *
     * @param id id
     * @return {@link MarketingStatisticsCountVO}
     */
    MarketingStatisticsCountVO getMarketingCountByBusinessId(String id);

    /**
     * 分页查询发送日志
     *
     * @param page          页面
     * @param sendLogPageVO SendLogPageVO
     * @return {@link Page}<{@link SendLogPageVO}>
     */
    Page<SendLogPageVO> sendLogPage(Page<SendLogPageVO> page, SendLogPageVO sendLogPageVO);
}
