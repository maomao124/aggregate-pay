package mao.sms_server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.ConfigEntity;

import java.util.Collection;
import java.util.List;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service
 * Interface(接口名): ConfigService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/28
 * Time(创建时间)： 21:43
 * Version(版本): 1.0
 * Description(描述)： 配置
 */

public interface ConfigService extends IService<ConfigEntity>
{
    /**
     * 获取Redis中的可用通道，如果redis中没有，从数据库中查找
     *
     * @return {@link List}<{@link ConfigEntity}>
     */
    List<ConfigEntity> listForConnect();

    /**
     * 通道选举，选举策略：
     * 1、剔除掉第一级通道
     * 2、查询最近一小时内通道发送短信数量，按数量排序通道
     * 3、如果最近一小时没有发送短信，按最后发送成功排序
     *
     * @return {@link List}<{@link ConfigEntity}>
     */
    List<ConfigEntity> listForNewConnect();

    /**
     * 通过id批量更新
     *
     * @param entityList 实体列表
     * @return boolean
     */
    boolean updateBatchById(Collection<ConfigEntity> entityList);
}
