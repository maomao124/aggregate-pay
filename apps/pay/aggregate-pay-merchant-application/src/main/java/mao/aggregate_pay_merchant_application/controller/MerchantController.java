package mao.aggregate_pay_merchant_application.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_common.domain.CommonErrorCode;
import mao.aggregate_pay_common.utils.PhoneUtil;
import mao.aggregate_pay_common.utils.RandomUuidUtil;
import mao.aggregate_pay_merchant_api.dto.MerchantDTO;
import mao.aggregate_pay_merchant_api.feign.MerchantFeignClient;
import mao.aggregate_pay_merchant_application.feign.sms.VerificationFeignClient;
import mao.aggregate_pay_merchant_application.handler.AssertResult;
import mao.aggregate_pay_merchant_application.service.FileService;
import mao.aggregate_pay_merchant_application.service.SmsService;
import mao.aggregate_pay_merchant_application.utils.SecurityUtil;
import mao.aggregate_pay_merchant_application.vo.MerchantDetailVO;
import mao.aggregate_pay_merchant_application.vo.MerchantRegisterVO;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import mao.tools_log.annotation.SysLog;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_merchant_application.controller
 * Class(类名): MerchantController
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/10
 * Time(创建时间)： 21:49
 * Version(版本): 1.0
 * Description(描述)： 商户
 */

@Slf4j
@RestController
@Api(tags = "商户平台应用接口")
public class MerchantController
{

    @Resource
    private VerificationFeignClient verificationFeignClient;

    @Resource
    private SmsService smsService;

    @Resource
    private MerchantFeignClient merchantFeignClient;

    @Resource
    private FileService fileService;

    @Resource
    private DozerUtils dozerUtils;

    /**
     * 发送验证码
     *
     * @param phone 电话
     * @return {@link String} 验证码的key
     */
    @ApiOperation("获取手机验证码")
    @GetMapping("/sms")
    @ApiImplicitParam(value = "手机号", name = "phone", required = true, dataType = "string", paramType = "query")
    public String getSMSCode(@RequestParam("phone") String phone)
    {
        //判断非空
        if (StringUtils.isBlank(phone))
        {
            throw new BusinessException(CommonErrorCode.E_100112);
        }
        //校验手机号的合法性
        if (!PhoneUtil.isMatches(phone))
        {
            throw new BusinessException(CommonErrorCode.E_100109);
        }
        log.info("向手机号:{}发送验证码", phone);
        //向验证码服务请求发送验证码
        Map<String, Object> map = new HashMap<>();
        map.put("mobile", phone);
        return verificationFeignClient.generateVerificationInfo("sms", map, 20 * 60).getResult().getKey();
    }

    /**
     * 注册商户
     *
     * @param merchantRegisterVO MerchantRegisterVO
     * @return {@link MerchantRegisterVO}
     */
    //@SysLog(value = "商户注册", recordResponseParam = false)
    @PostMapping("/merchants/register")
    @ApiOperation("商户注册")
    @ApiImplicitParam(value = "商户注册信息", name = "merchantRegisterVO", required = true, dataType = "MerchantRegisterVO", paramType = "body")
    public MerchantRegisterVO registerMerchant(@RequestBody MerchantRegisterVO merchantRegisterVO)
    {

        if (merchantRegisterVO.getVerifiykey() == null || merchantRegisterVO.getVerifiykey().equals(""))
        {
            throw BizException.wrap("验证码的key为空");
        }
        if (merchantRegisterVO.getVerifiyCode() == null || merchantRegisterVO.getVerifiyCode().equals(""))
        {
            throw BizException.wrap("请输入验证码");
        }
        smsService.checkVerifyCode(merchantRegisterVO.getVerifiykey(), merchantRegisterVO.getVerifiyCode());

        //注册商户
        MerchantDTO merchantDTO = new MerchantDTO();
        merchantDTO.setUsername(merchantRegisterVO.getUsername());
        merchantDTO.setMobile(merchantRegisterVO.getMobile());
        merchantDTO.setPassword(merchantRegisterVO.getPassword());

        if (StringUtils.isBlank(merchantDTO.getMobile()))
        {
            throw new BusinessException(CommonErrorCode.E_100112);
        }
        //校验手机号的合法性
        if (!PhoneUtil.isMatches(merchantDTO.getMobile()))
        {
            throw new BusinessException(CommonErrorCode.E_100109);
        }
        //联系人非空校验
        if (StringUtils.isBlank(merchantDTO.getUsername()))
        {
            throw new BusinessException(CommonErrorCode.E_100110);
        }
        //密码非空校验
        if (StringUtils.isBlank(merchantDTO.getPassword()))
        {
            throw new BusinessException(CommonErrorCode.E_100111);
        }

        //远程调用
        R<MerchantDTO> result = merchantFeignClient.createMerchant(merchantDTO);
        //断言结果
        AssertResult.handler(result);
        //返回
        return merchantRegisterVO;

    }

    /**
     * 上传证件照
     *
     * @param multipartFile 多部分文件
     * @return {@link String}
     * @throws IOException io异常
     */
    @ApiOperation("上传证件照")
    @PostMapping("/upload")
    @SysLog(value = "上传证件照", recordResponseParam = false)
    public String upload(@ApiParam(value = "证件照", required = true) @RequestParam("file") MultipartFile multipartFile)
            throws IOException
    {
        //调用fileService上传文件
        //生成的文件名称fileName，要保证它的唯一
        //文件原始名称
        String originalFilename = multipartFile.getOriginalFilename();
        //文件名称
        String fileName = RandomUuidUtil.getUUID() + "_" + originalFilename;
        //byte[] bytes,String fileName
        return fileService.upload(multipartFile.getBytes(), fileName);
    }


    /**
     * 商户资质申请
     *
     * @param merchantDetailVO MerchantDetailVO
     */
    @ApiOperation("商户资质申请")
    @ApiImplicitParams
            ({
                    @ApiImplicitParam(name = "merchantDetailVO", value = "商户认证资料", required = true,
                            dataType = "MerchantDetailVO", paramType = "body")
            })
    @SysLog(value = "商户资质申请", recordResponseParam = false)
    @PostMapping("/my/merchants/save")
    public void saveMerchant(@RequestBody MerchantDetailVO merchantDetailVO)
    {
        //Long merchantId = 124619633188667425L;
        Long merchantId = SecurityUtil.getMerchantId();
        //转换
        MerchantDTO merchantDTO = dozerUtils.map(merchantDetailVO, MerchantDTO.class);
        //发起远程调用
        R<Boolean> result = merchantFeignClient.applyMerchant(merchantId, merchantDTO);
        //断言结果
        AssertResult.handler(result);
    }


    /**
     * 获取登录用户的商户信息
     *
     * @return {@link MerchantDTO}
     */
    @ApiOperation("获取登录用户的商户信息")
    @GetMapping(value = "/my/merchants")
    public MerchantDTO getMyMerchantInfo()
    {
        return SecurityUtil.getMerchant();
    }

    /**
     * 查询交易总览
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return {@link R}<{@link String}>
     */
    @ApiOperation("查询交易总览")
    @PostMapping("/my/merchants/transactions")
    public R<String> transactions(@RequestParam String startTime, @RequestParam String endTime)
    {
        return R.fail("功能未实现");
    }


    /**
     * 查询各个app下的交易总览
     *
     * @return {@link R}<{@link String}>
     */
    @ApiOperation("查询各个app下的交易总览")
    @PostMapping("/my/merchants/transactions/apps")
    public R<String> transactionsApp()
    {
        return R.fail("功能未实现");
    }

    /**
     * 查询各个支付聚道下的交易总览
     *
     * @return {@link R}<{@link String}>
     */
    @ApiOperation("查询各个支付聚道下的交易总览")
    @PostMapping("/my/merchants/transactions/channels")
    public R<String> transactionsChannels()
    {
        return R.fail("功能未实现");
    }

}
