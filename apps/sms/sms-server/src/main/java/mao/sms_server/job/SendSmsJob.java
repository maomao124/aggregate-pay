package mao.sms_server.job;

import lombok.extern.slf4j.Slf4j;
import mao.tools_core.utils.DateUtils;
import mao.tools_redis_cache.entity.LockInfo;
import mao.tools_redis_cache.service.RedisLockService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.job
 * Class(类名): SendSmsJob
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/3
 * Time(创建时间)： 14:22
 * Version(版本): 1.0
 * Description(描述)： 定时任务，用于发送定时短信
 */

@Slf4j
@Component
public class SendSmsJob
{
    @Resource
    private SendTimingSms sendTimingSms;

    @Resource
    private RedisLockService redisLockService;

    /**
     * 定时发送短信
     * 每分钟的第10秒检查一次是否有定时短信需要发送
     *
     * @throws InterruptedException 中断异常
     */
    @Scheduled(cron = "10 0/1 * * * ?")
    public void sendTimingSms() throws InterruptedException
    {
        //定时任务，每分钟检查一次是否有定时短信需要发送

        //2、为了防止短信重复发送，需要使用分布式锁
        LockInfo lockInfo = redisLockService.tryLock("SEND_TIMING_SMS", 30, 30, TimeUnit.SECONDS);

        if (lockInfo.isSuccess())
        {
            log.info("准备执行定时发送短信任务");
            //当前实例抢到锁，可以执行定时短信的发送
            //3、调用SendTimingSmsImpl发送定时短信
            sendTimingSms.execute(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm"));
            //释放锁
            redisLockService.unlock(lockInfo);
        }
    }
}
