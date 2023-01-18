package mao.aggregate_pay_uaa_service.service;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.service
 * Interface(接口名): ClientDetailsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface ClientDetailsService
{
    /**
     * 创建接入客户端，用于用户中心应用的关联创建
     */
    void createClientDetails();
}
