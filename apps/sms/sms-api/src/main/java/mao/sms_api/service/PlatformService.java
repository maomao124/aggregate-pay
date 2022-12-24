package mao.sms_api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.PlatformEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service
 * Interface(接口名): PlatformService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:48
 * Version(版本): 1.0
 * Description(描述)： 平台
 */

public interface PlatformService extends IService<PlatformEntity>
{
    /**
     * 通过访问密钥id得到PlatformEntity
     *
     * @param accessKeyId 访问密钥id
     * @return {@link PlatformEntity}
     */
    PlatformEntity getByAccessKeyId(String accessKeyId);
}
