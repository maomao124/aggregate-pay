package mao.sms_manage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.PlatformEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service
 * Interface(接口名): PlatformService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 18:58
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface PlatformService extends IService<PlatformEntity>
{
    /**
     * 通过名字得到PlatformEntity类
     *
     * @param name 名字
     * @return {@link PlatformEntity}
     */
    PlatformEntity getByName(String name);
}
