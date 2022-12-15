package mao.gateway.api;

import mao.auth_entity.dto.auth.ResourceQueryDTO;
import mao.auth_entity.entity.auth.Resource;
import mao.tools_core.base.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.gateway.api
 * Interface(接口名): ResourceApi
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/13
 * Time(创建时间)： 13:42
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@FeignClient(name = "${feign.authority-server:auth-server}",
        fallback = ResourceApiFallback.class)
public interface ResourceApi
{
    /**
     * 查询所有资源
     *
     * @return {@link R}<{@link List}>
     */
    @GetMapping("/resource/list")
    R<List> list();

    /**
     * 查询用户可用的所有资源
     *
     * @param resource 资源
     * @return {@link R}<{@link List}<{@link Resource}>>
     */
    @GetMapping("/resource")
    R<List<Resource>> visible(ResourceQueryDTO resource);
}
