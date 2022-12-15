package mao.auth_server.service.common;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.entity.common.LoginLog;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.common
 * Interface(接口名): LoginLogService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 20:07
 * Version(版本): 1.0
 * Description(描述)： 登录日志服务
 */

public interface LoginLogService extends IService<LoginLog>
{
    /**
     * 保存登录日志
     *
     * @param account     账号
     * @param ua          浏览器
     * @param ip          客户端IP
     * @param location    客户端地址
     * @param description 登陆描述消息
     * @return {@link LoginLog}
     */
    LoginLog save(String account, String ua, String ip, String location, String description);

    /**
     * 获取系统总访问次数
     *
     * @return Long
     */
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     *
     * @return Long
     */
    Long findTodayVisitCount();

    /**
     * 获取系统今日访问 IP数
     *
     * @return Long
     */
    Long findTodayIp();

    /**
     * 获取系统近十天来的访问记录
     *
     * @param account 账号
     * @return 系统近十天来的访问记录
     */
    List<Map<String, Object>> findLastTenDaysVisitCount(String account);

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
