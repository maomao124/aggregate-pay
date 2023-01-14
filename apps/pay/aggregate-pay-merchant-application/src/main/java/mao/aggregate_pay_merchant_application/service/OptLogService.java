package mao.aggregate_pay_merchant_application.service;

import mao.tools_log.entity.OptLogDTO;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.service
 * Interface(接口名): OptLogService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/14
 * Time(创建时间)： 16:28
 * Version(版本): 1.0
 * Description(描述)： 操作日志服务
 */

public interface OptLogService
{
    /**
     * 保存操作日志到日志服务
     *
     * @param optLogDTO 操作日志dto
     */
    void save(OptLogDTO optLogDTO);
}
