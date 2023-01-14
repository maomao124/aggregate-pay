package mao.aggregate_pay_merchant_application.feign.sms;

import mao.aggregate_pay_common.domain.RestResponse;
import mao.aggregate_pay_entity.dto.VerificationInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.feign.sms
 * Class(类名): VerificationFeignClient
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 20:16
 * Version(版本): 1.0
 * Description(描述)： 通过feign去远程调用sms的VerificationController
 * FeignClient注解的value为服务名
 */

@FeignClient(value = "aggregate-pay-sms", path = "")
public interface VerificationFeignClient
{
    /**
     * 生成验证信息
     *
     * @param name          名字，这里的名字统一为sms
     * @param payload       有效载荷，位于请求体里。请求体示例：
     *                      {
     *                      "mobile":"18877888888"
     *                      }
     * @param effectiveTime 有效时间
     * @return {@link RestResponse}<{@link VerificationInfo}>
     * 响应示例：
     * <pre>
     * {
     *   "code": 0,
     *   "msg": "",
     *   "result":
     *   {
     *     "key": "sms:530a167172a24677a1cb0c44541b7be8",
     *     "content": null
     *   }
     * }
     * </pre>
     */
    @PostMapping(value = "/generate")
    RestResponse<VerificationInfo> generateVerificationInfo(@RequestParam("name") String name,
                                                            @RequestBody Map<String, Object> payload,
                                                            @RequestParam("effectiveTime") int effectiveTime);


    /**
     * 验证短信是否正确
     *
     * @param name             名字，这里的名字统一为sms
     * @param verificationKey  验证的key，例如：sms:530a167172a24677a1cb0c44541b7be8
     * @param verificationCode 验证码
     * @return {@link RestResponse}<{@link Boolean}>
     * 响应示例：
     * <pre>
     * {
     *   "code": 0,
     *   "msg": "",
     *   "result": false
     * }
     * </pre>
     */
    @PostMapping(value = "/verify")
    RestResponse<Boolean> verify(@RequestParam("name") String name, @RequestParam String verificationKey, @RequestParam String verificationCode);

}
