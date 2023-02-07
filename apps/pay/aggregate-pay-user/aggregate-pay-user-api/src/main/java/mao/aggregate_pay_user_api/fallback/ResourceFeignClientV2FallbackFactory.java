package mao.aggregate_pay_user_api.fallback;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.menu.MenuDTO;
import mao.aggregate_pay_user_api.dto.menu.MenuQueryDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationQueryParams;
import mao.aggregate_pay_user_api.dto.resource.ResourceDTO;
import mao.aggregate_pay_user_api.feign.ResourceFeignClientV2;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.fallback
 * Class(类名): ResourceFeignClientV2FallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class ResourceFeignClientV2FallbackFactory implements FallbackFactory<ResourceFeignClientV2>
{

    @Override
    public ResourceFeignClientV2 create(Throwable throwable)
    {
        return new ResourceFeignClientV2()
        {
            @Override
            public R<Boolean> createApplication(ApplicationDTO application)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> modifyApplication(ApplicationDTO application)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> removeApplication(String applicationCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<ApplicationDTO> queryApplication(String applicationCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<PageVO<ApplicationDTO>> pageApplicationByConditions(ApplicationQueryParams query, Integer pageNo, Integer pageSize)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<ResourceDTO>> loadResources(List<String> privileageCodes, String applicationCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Map<Long, List<ResourceDTO>>> loadResources(Map<Long, AuthorizationInfoDTO> tenantAuthorizationInfoMap)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<MenuDTO> queryMenu(Long id)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<MenuDTO>> queryMenuByApplicationCode(String applicationCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<PageVO<MenuDTO>> queryMenu(MenuQueryDTO params, Integer pageNo, Integer pageSize)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<MenuDTO>> queryMenuByPrivileges(String[] privileges)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }
        };
    }
}
