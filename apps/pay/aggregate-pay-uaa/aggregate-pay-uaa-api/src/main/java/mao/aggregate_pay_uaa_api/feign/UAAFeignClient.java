package mao.aggregate_pay_uaa_api.feign;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_api.feign
 * Interface(接口名): UAAFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/22
 * Time(创建时间)： 19:17
 * Version(版本): 1.0
 * Description(描述)： feign接口
 */

@FeignClient(value = "aggregate-pay-uaa-service", path = "")
public interface UAAFeignClient
{
    /**
     * 检查令牌
     *
     * @param value 令牌
     * @return {@link Map}<{@link String}, {@link ?}>
     */
    @PostMapping(value = "/oauth/check_token")
    @ApiOperation(value = "检查令牌")
    Map<String, ?> checkToken(@RequestParam("token") String value);


    /**
     * 创建客户细节
     *
     * @param map 地图
     */
    @ApiOperation(value = "创建客户细节")
    @PostMapping("/oauth/createClientDetails")
    void createClientDetails(@RequestBody Map<String, String> map);


    /**
     * 根据appId查询client信息  appId也就是client_id
     *
     * @param appId 应用程序id
     * @return {@link Map}<{@link String},{@link String}>
     */
    @ApiOperation(value = "根据client_id查询client信息")
    @GetMapping("/oauth/getClientDetailsByClientId")
    Map<String, String> getClientDetailsByClientId(@RequestParam String appId);
}
