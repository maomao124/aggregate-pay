package mao.tools_log.event;

import mao.tools_log.entity.OptLogDTO;
import org.springframework.context.ApplicationEvent;

/**
 * Project name(项目名称)：logback_spring_boot_starter_demo
 * Package(包名): mao.tools_log.event
 * Class(类名): SysLogEvent
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/31
 * Time(创建时间)： 21:44
 * Version(版本): 1.0
 * Description(描述)： 系统日志事件
 */

public class SysLogEvent extends ApplicationEvent
{
    public SysLogEvent(OptLogDTO source)
    {
        super(source);
    }
}
