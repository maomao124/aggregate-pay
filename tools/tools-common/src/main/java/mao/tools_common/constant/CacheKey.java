package mao.tools_common.constant;

import cn.hutool.core.util.StrUtil;
import mao.tools_core.utils.StrPool;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.constant
 * Interface(接口名): CacheKey
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 14:50
 * Version(版本): 1.0
 * Description(描述)： 用于同一管理和生成缓存的region和key， 避免多个项目使用的key重复
 */

public interface CacheKey
{
    /**
     * 验证码 前缀
     * 完整key: captcha:{key} -> str
     */
    String CAPTCHA = "captcha";
    /**
     * 资源 前缀
     * 完整key: resource:{resourceId} -> obj
     */
    String RESOURCE = "resource";

    /**
     * 用户拥有的资源 前缀
     * 完整key: user_resource:{userId} -> [RESOURCE_ID, ...]
     */
    String USER_RESOURCE = "user_resource";
    /**
     * 所有需要鉴权的资源
     */
    String RESOURCE_NEED_TO_CHECK = "resource_need_to_check";

    /**
     * 构建key
     */
    static String buildKey(Object... args)
    {
        if (args.length == 1)
        {
            return String.valueOf(args[0]);
        }
        else if (args.length > 0)
        {
            return StrUtil.join(StrPool.COLON, args);
        }
        else
        {
            return "";
        }
    }
}
