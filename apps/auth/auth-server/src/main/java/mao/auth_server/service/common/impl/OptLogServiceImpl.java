package mao.auth_server.service.common.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mao.auth_entity.entity.common.OptLog;
import mao.auth_server.dao.common.OptLogMapper;
import mao.auth_server.service.common.OptLogService;
import mao.tools_log.entity.OptLogDTO;
import mao.toolsdozer.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.common.impl
 * Class(类名): OptLogServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/11
 * Time(创建时间)： 19:34
 * Version(版本): 1.0
 * Description(描述)： 操作日志服务实现类
 */

@Service
public class OptLogServiceImpl extends ServiceImpl<OptLogMapper, OptLog> implements OptLogService
{
    @Resource
    private DozerUtils dozerUtils;

    @Override
    public boolean save(OptLogDTO optLogDTO)
    {
        return this.save(dozerUtils.map(optLogDTO, OptLog.class));
    }
}
