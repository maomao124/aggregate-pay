package mao.gateway.api;

import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import mao.tools_core.base.R;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.api
 * Class(类名): ResourceApiFallback
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 13:45
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Component
public class ResourceApiFallback implements ResourceApi
{

    @Override
    public R<List> list()
    {
        return null;
    }

    @Override
    public R<List<Resource>> visible(ResourceQueryDTO resource)
    {
        return null;
    }
}
