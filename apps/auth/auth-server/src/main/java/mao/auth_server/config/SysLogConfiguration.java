package mao.auth_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.auth_server.service.common.OptLogService;
import mao.tools_log.entity.OptLogDTO;
import mao.tools_log.event.SysLogListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.function.Consumer;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.config
 * Class(类名): SysLogConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 12:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
@EnableAsync
public class SysLogConfiguration
{
    @Resource
    private OptLogService optLogService;

    @Bean
    public SysLogListener sysLogListener()
    {
        return new SysLogListener(new Consumer<OptLogDTO>()
        {
            @Override
            public void accept(OptLogDTO optLogDTO)
            {
                boolean save = optLogService.save(optLogDTO);
                if (!save)
                {
                    log.warn("日志保存失败：" + optLogDTO);
                }
            }
        });
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SysLogConfiguration");
    }
}
