package mao.aggregate_pay_sms.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import mao.aggregate_pay_sms.common.domain.RestResponse;
import mao.aggregate_pay_sms.dto.VerificationInfo;
import mao.aggregate_pay_sms.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Api(tags = "验证码服务接口")
@RestController
public class VerificationController
{

    @Autowired
    private VerificationService verificationService;


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
    @ApiOperation(value = "生成验证信息", notes = "生成验证信息")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "name", value = "业务名称", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "payload", value = "业务携带参数，如手机号 ，邮箱", required = true, paramType = "body"),
                    @ApiImplicitParam(name = "effectiveTime", value = "验证信息有效期(秒)", required = false, dataType = "String", paramType = "query")
            })
    @PostMapping(value = "/generate")
    public RestResponse<VerificationInfo> generateVerificationInfo(@RequestParam("name") String name,
                                                                   @RequestBody Map<String, Object> payload,
                                                                   @RequestParam("effectiveTime") int effectiveTime)
    {
        VerificationInfo verificationInfo = verificationService.generateVerificationInfo(name, payload, effectiveTime);
        return RestResponse.success(verificationInfo);
    }


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
    @ApiOperation(value = "校验", notes = "校验")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "name", value = "业务名称", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "verificationKey", value = "验证key", required = true, dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "verificationCode", value = "验证码", required = true, dataType = "String", paramType = "query")
            })
    @PostMapping(value = "/verify")
    public RestResponse<Boolean> verify(String name, String verificationKey, String verificationCode)
    {
        Boolean isSuccess = verificationService.verify(name, verificationKey, verificationCode);
        return RestResponse.success(isSuccess);
    }


}
