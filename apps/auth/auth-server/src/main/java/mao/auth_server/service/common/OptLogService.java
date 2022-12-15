package mao.auth_server.service.common;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.auth_entity.entity.common.OptLog;
import mao.tools_log.entity.OptLogDTO;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.common
 * Interface(接口名): OptLogService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 19:33
 * Version(版本): 1.0
 * Description(描述)： 操作日志服务
 */

public interface OptLogService extends IService<OptLog>
{
    /**
     * 保存日志
     *
     * @param optLogDTO 选择日志dto
     * @return boolean
     */
    boolean save(OptLogDTO optLogDTO);
}
