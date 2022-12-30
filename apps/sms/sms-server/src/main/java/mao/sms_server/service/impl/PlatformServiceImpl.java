package mao.sms_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_dao.mapper.PlatformMapper;
import mao.sms_entity.entity.PlatformEntity;
import mao.sms_server.service.PlatformService;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.stereotype.Service;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.service.impl
 * Class(类名): PlatformServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/30
 * Time(创建时间)： 22:23
 * Version(版本): 1.0
 * Description(描述)： 接入平台
 */

@Slf4j
@Service
public class PlatformServiceImpl extends ServiceImpl<PlatformMapper, PlatformEntity> implements PlatformService
{
    @Override
    public PlatformEntity getByName(String name)
    {
        return this.getOne(Wraps.<PlatformEntity>lbQ().eq(PlatformEntity::getName, name));
    }
}
