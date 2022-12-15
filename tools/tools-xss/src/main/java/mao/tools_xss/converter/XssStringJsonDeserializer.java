package mao.tools_xss.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import com.fasterxml.jackson.databind.JsonDeserializer;
import mao.tools_xss.utils.XssUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project name(项目名称)：AntiSamy_spring_boot_starter_demo
 * Package(包名): mao.tools_xss.converter
 * Class(类名): XssStringJsonDeserializer
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/30
 * Time(创建时间)： 20:14
 * Version(版本): 1.0
 * Description(描述)： 过滤跨站脚本的 反序列化工具
 */

public class XssStringJsonDeserializer extends JsonDeserializer<String>
{

    private static final List<String> list = new ArrayList<>();

    static
    {
        list.add("<script>");
        list.add("</script>");
        list.add("<iframe>");
        list.add("</iframe>");
        list.add("<noscript>");
        list.add("</noscript>");
        list.add("<frameset>");
        list.add("</frameset>");
        list.add("<frame>");
        list.add("</frame>");
        list.add("<noframes>");
        list.add("</noframes>");
        list.add("<h1>");
        list.add("</h1>");
        list.add("<h2>");
        list.add("</h2>");
        list.add("<h3>");
        list.add("</h3>");
        list.add("<h4>");
        list.add("</h4>");
        list.add("<h5>");
        list.add("</h5>");
        list.add("<h6>");
        list.add("</h6>");
        list.add("<img>");
        list.add("</img>");
        list.add("<table>");
        list.add("</table>");
        list.add("<form>");
        list.add("</form>");
    }


    @Override
    public String deserialize(JsonParser p, DeserializationContext dc) throws IOException, JsonProcessingException
    {
        if (p.hasToken(JsonToken.VALUE_STRING))
        {
            String value = p.getValueAsString();

            if (value == null || "".equals(value))
            {
                return value;
            }
            boolean flag = list.stream().anyMatch(value::contains);
            if (flag)
            {
                return XssUtils.xssClean(value, null);
            }
            return value;
        }
        return null;
    }
}
