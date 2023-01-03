package mao.sms_server.job;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.job
 * Interface(接口名): SendTimingSms
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/3
 * Time(创建时间)： 14:15
 * Version(版本): 1.0
 * Description(描述)： 定时短信发送业务接口
 */

public interface SendTimingSms
{
    /**
     * 执行
     *
     * @param timing 时机
     * @throws InterruptedException 中断异常
     */
    void execute(String timing) throws InterruptedException;
}
