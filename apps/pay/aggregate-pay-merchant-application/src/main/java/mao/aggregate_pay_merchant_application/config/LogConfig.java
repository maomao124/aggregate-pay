package mao.aggregate_pay_merchant_application.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_log.entity.OptLogDTO;
import mao.tools_log.event.SysLogListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.config
 * Class(类名): LogConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 13:31
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class LogConfig
{
    @Bean
    public SysLogListener sysLogListener()
    {
        return new SysLogListener(new Consumer<OptLogDTO>()
        {
            @Override
            public void accept(OptLogDTO optLogDTO)
            {
                log.info(optLogDTO.toString());
            }
        });
    }
}
