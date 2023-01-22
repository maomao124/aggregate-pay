package mao.aggregate_pay_uaa_service.service;

import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.service
 * Interface(接口名): OauthClientDetailsService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:11
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface OauthClientDetailsService
{
    /**
     * 创建客户细节
     *
     * @param map 地图
     */
     void createClientDetails(Map<String,String> map);

    /**
     * 根据appId查询 client信息  appId也就是client_id
     *
     * @param appId 应用程序id
     * @return {@link Map}
     */
     Map<String,String> getClientDetailsByClientId(String appId);
}
