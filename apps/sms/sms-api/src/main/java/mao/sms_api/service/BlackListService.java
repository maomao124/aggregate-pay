package mao.sms_api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.BlackListEntity;

import java.util.List;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service
 * Interface(接口名): BlackListService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 14:45
 * Version(版本): 1.0
 * Description(描述)： 黑名单
 */

public interface BlackListService extends IService<BlackListEntity>
{
    /**
     * 根据类型得到列表
     *
     * @param type 类型
     * @return {@link List}<{@link String}>
     */
    List<String> listByType(String type);
}
