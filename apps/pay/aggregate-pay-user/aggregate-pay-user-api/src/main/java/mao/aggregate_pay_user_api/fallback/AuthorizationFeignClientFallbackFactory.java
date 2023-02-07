package mao.aggregate_pay_user_api.fallback;

import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeDTO;
import mao.aggregate_pay_user_api.dto.auth.PrivilegeTreeDTO;
import mao.aggregate_pay_user_api.dto.auth.RoleDTO;
import mao.aggregate_pay_user_api.feign.AuthorizationFeignClient;
import mao.tools_core.exception.BizException;
import org.springframework.cloud.openfeign.FallbackFactory;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.fallback
 * Class(类名): AuthorizationFeignClientFallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:25
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class AuthorizationFeignClientFallbackFactory implements FallbackFactory<AuthorizationFeignClient>
{

    @Override
    public AuthorizationFeignClient create(Throwable throwable)
    {
        return new AuthorizationFeignClient()
        {
            @Override
            public Map<Long, AuthorizationInfoDTO> authorize(String username, Long[] tenantIds)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public List<PrivilegeDTO> queryPrivilege(Long tenantId, String[] roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public List<PrivilegeDTO> queryPrivilegeByGroupId(Long privilegeGroupId)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public PrivilegeTreeDTO queryPrivilegeTree(Long tenantId, String[] roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void createRole(Long tenantId, RoleDTO role)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void removeRole(Long tenantId, String roleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void modifyRole(RoleDTO role)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void roleBindPrivilege(Long tenantId, String roleCode, String[] privilegeCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public List<RoleDTO> queryRole(Long tenantId)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public List<RoleDTO> queryRole(Long tenantId, String... roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public RoleDTO queryTenantRole(Long tenantId, String roleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void bindAccountRole(String username, Long tenantId, String[] roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void unbindAccountRole(String username, Long tenantId, String[] roleCodes)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }
        };
    }
}
