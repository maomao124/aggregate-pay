package mao.sms_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.dto.ConfigDTO;
import mao.sms_entity.entity.ConfigEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service
 * Interface(接口名): ConfigService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 18:53
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface ConfigService extends IService<ConfigEntity>
{
    /**
     * 通过名字得到ConfigEntity对象
     *
     * @param name 名字
     * @return {@link ConfigEntity}
     */
    ConfigEntity getByName(String name);

    /**
     * 得到新水平
     *
     * @param entity 实体
     */
    void getNewLevel(ConfigDTO entity);

    /**
     * 发送更新消息
     */
    void sendUpdateMessage();
}
