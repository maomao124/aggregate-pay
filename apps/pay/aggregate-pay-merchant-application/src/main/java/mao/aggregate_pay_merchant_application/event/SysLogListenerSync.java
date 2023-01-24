package mao.aggregate_pay_merchant_application.event;

import mao.tools_log.entity.OptLogDTO;
import mao.tools_log.event.SysLogEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import java.util.function.Consumer;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.event
 * Class(类名): SysLogListenerSync
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/24
 * Time(创建时间)： 20:48
 * Version(版本): 1.0
 * Description(描述)： 同步保存，因为如果使用异步保存，不在同一线程里，就无法获取到request里的数据，也就无法获取到租户id和商户id
 */

public class SysLogListenerSync
{
    private final Consumer<OptLogDTO> consumer;

    public SysLogListenerSync(Consumer<OptLogDTO> consumer)
    {
        this.consumer = consumer;
    }

    //@Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event)
    {
        OptLogDTO optLog = (OptLogDTO) event.getSource();
        //BaseContextHandler.setDatabase(database);
        consumer.accept(optLog);
    }
}
