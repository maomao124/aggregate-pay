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
     * 通道配置信息列表
     *
     * @return {@link List}<{@link ConfigEntity}>
     */
    List<ConfigEntity> listForConnect();

    /**
     * 新通道配置信息列表
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
