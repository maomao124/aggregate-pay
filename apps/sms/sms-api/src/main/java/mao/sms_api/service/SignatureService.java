package mao.sms_api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.SignatureEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service
 * Interface(接口名): SignatureService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:59
 * Version(版本): 1.0
 * Description(描述)： 签名
 */

public interface SignatureService extends IService<SignatureEntity>
{
    /**
     * 通过code字段得到SignatureEntity
     *
     * @param signature 签名
     * @return {@link SignatureEntity}
     */
    SignatureEntity getByCode(String signature);
}
