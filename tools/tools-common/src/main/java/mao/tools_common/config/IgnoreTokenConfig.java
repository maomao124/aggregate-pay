package mao.tools_common.config;

import org.springframework.util.AntPathMatcher;

import java.util.Arrays;
import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_common.config
 * Class(类名): IgnoreTokenConfig
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/4
 * Time(创建时间)： 14:38
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class IgnoreTokenConfig
{
    public static final List<String> LIST = Arrays.asList(
            "/error",
            "/actuator/**",
            "/gate/**",
            "/static/**",
            "/anno/**",
            "/**/anno/**",
            "/**/swagger-ui.html",
            "/**/doc.html",
            "/**/webjars/**",
            "/**/v2/api-docs/**",
            "/**/v2/api-docs-ext/**",
            "/**/swagger-resources/**",
            "/menu/router/**"
    );
    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    /**
     * 是否是忽略令牌认证的路径
     *
     * @param currentUri 当前uri
     * @return boolean
     */
    public static boolean isIgnoreToken(String currentUri)
    {
        return isIgnore(LIST, currentUri);
    }

    /**
     * 是否是忽略令牌认证的路径
     *
     * @param list       列表
     * @param currentUri 当前uri
     * @return boolean
     */
    public static boolean isIgnore(List<String> list, String currentUri)
    {
        if (list.isEmpty())
        {
            return false;
        }
        return list.stream().anyMatch((url) ->
                currentUri.startsWith(url) || ANT_PATH_MATCHER.match(url, currentUri)
        );
    }
}
