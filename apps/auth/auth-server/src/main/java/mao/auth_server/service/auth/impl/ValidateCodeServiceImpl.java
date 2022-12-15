package mao.auth_server.service.auth.impl;

import com.wf.captcha.ChineseGifCaptcha;
import com.wf.captcha.base.Captcha;
import lombok.extern.slf4j.Slf4j;
import mao.auth_server.service.auth.ValidateCodeService;
import mao.tools_common.constant.CacheKey;
import mao.tools_core.exception.BizException;
import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.service.auth.impl
 * Class(类名): ValidateCodeServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/10
 * Time(创建时间)： 19:54
 * Version(版本): 1.0
 * Description(描述)： 验证码服务实现类
 */

@Slf4j
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService
{

    @Resource
    private CacheChannel cache;

    @Override
    public void create(String key, HttpServletResponse response) throws IOException
    {
        //判断key是否为空
        if (StringUtils.isBlank(key))
        {
            throw BizException.validFail("验证码key不能为空");
        }
        //可以不为空
        //生成验证码，中文gif验证码，6位
        Captcha captcha = new ChineseGifCaptcha(160, 80, 6);
        //设置响应类型为图片
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        //设置响应头
        response.setHeader(HttpHeaders.PRAGMA, "No-cache");
        response.setHeader(HttpHeaders.CACHE_CONTROL, "No-cache");
        response.setDateHeader(HttpHeaders.EXPIRES, 0L);
        //获取验证码字符串
        String text = captcha.text();
        log.debug("key：" + key + "  的验证码：" + text);
        //放入缓存里
        cache.set(CacheKey.CAPTCHA, key, text);
        //输出
        captcha.out(response.getOutputStream());
    }

    @Override
    public boolean check(String key, String value)
    {
        //判断用户是否输入了验证码
        if (value.isEmpty())
        {
            //没有输入
            throw BizException.validFail("请输入验证码");
        }
        //判断key是否为空
        if (key.isEmpty())
        {
            throw BizException.validFail("验证码key为空");
        }
        //从缓存获取
        CacheObject cacheObject = cache.get(CacheKey.CAPTCHA, key);
        //判断是否为空
        if (cacheObject.getValue() == null)
        {
            //为空，未获取验证码或者验证码已过期
            throw BizException.validFail("未获取验证码或者验证码已过期");
        }
        //不为空
        //验证验证码输入是否正确
        String cacheObjectValue = (String) cacheObject.getValue();
        log.debug("缓存里的验证码：" + cacheObjectValue + ",用户输入的验证码：" + value);
        if (!value.equals(cacheObjectValue))
        {
            //验证码输入不正确
            throw BizException.validFail("验证码不正确");
        }
        //验证码正确，验证通过
        //清除缓存
        cache.evict(CacheKey.CAPTCHA, key);
        return true;
    }
}
