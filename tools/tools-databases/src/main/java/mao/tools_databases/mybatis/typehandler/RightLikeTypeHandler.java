package mao.tools_databases.mybatis.typehandler;

import org.apache.ibatis.type.Alias;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.mybatis.typehandler
 * Class(类名): RightLikeTypeHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 13:46
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Alias("rightLike")
public class RightLikeTypeHandler extends BaseLikeTypeHandler
{
    public RightLikeTypeHandler()
    {
        super(false, true);
    }
}
