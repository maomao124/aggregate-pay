package mao.auth_server.dao.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.auth_entity.entity.common.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.common
 * Interface(接口名): LoginLogMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 21:06
 * Version(版本): 1.0
 * Description(描述)： 系统日志，不应该使用关系型数据库来做统计，如果条件允许，可以使用elasticsearch来存数据和统计，kibana来展示数据
 */

@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog>
{

    /**
     * 获取系统总访问次数
     *
     * @return {@link Long}
     */
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     *
     * @param today 今天
     * @return {@link Long}
     */
    Long findTodayVisitCount(@Param("today") LocalDate today);


    /**
     * 获取系统今日访问 IP数
     *
     * @param today 今天
     * @return {@link Long}
     */
    Long findTodayIp(@Param("today") LocalDate today);

    /**
     * 获取系统近十天来的访问记录
     *
     * @param tenDays 十天前
     * @param account 用户账号
     * @return {@link List}<{@link Map}<{@link String}, {@link Object}>>
     */
    List<Map<String, Object>> findLastTenDaysVisitCount(@Param("tenDays") LocalDate tenDays, @Param("account") String account);


    /**
     * 按浏览器来统计数量
     *
     * @return {@link List}<{@link Map}<{@link String}, {@link Object}>>
     */
    List<Map<String, Object>> findByBrowser();


    /**
     * 按造作系统内统计数量
     *
     * @return {@link List}<{@link Map}<{@link String}, {@link Object}>>
     */
    List<Map<String, Object>> findByOperatingSystem();
}
