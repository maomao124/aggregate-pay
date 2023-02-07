package mao.aggregate_pay_user_api.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeTreeDTO;
import mao.aggregate_pay_user_api.dto.auth.RoleDTO;
import mao.aggregate_pay_user_api.feign.AuthorizationFeignClientV2;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.fallback
 * Class(类名): AuthorizationFeignClientV2FallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:29
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class AuthorizationFeignClientV2FallbackFactory implements FallbackFactory<AuthorizationFeignClientV2>
{

    @Override
    public AuthorizationFeignClientV2 create(Throwable throwable)
    {
        return new AuthorizationFeignClientV2()
        {
            @Override
            public R<Map<Long, AuthorizationInfoDTO>> authorize(String username, Long[] tenantIds)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<PrivilegeDTO>> queryPrivilege(Long tenantId, String[] roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<PrivilegeDTO>> queryPrivilegeByGroupId(Long privilegeGroupId)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<PrivilegeTreeDTO> queryPrivilegeTree(Long tenantId, String[] roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> createRole(Long tenantId, RoleDTO role)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> removeRole(Long tenantId, String roleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> modifyRole(RoleDTO role)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> roleBindPrivilege(Long tenantId, String roleCode, String[] privilegeCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<RoleDTO>> queryRole(Long tenantId)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<RoleDTO>> queryRole(Long tenantId, String... roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<RoleDTO> queryTenantRole(Long tenantId, String roleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> bindAccountRole(String username, Long tenantId, String[] roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> unbindAccountRole(String username, Long tenantId, String[] roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }
        };
    }
}
