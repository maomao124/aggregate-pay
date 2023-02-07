package mao.aggregate_pay_user_api.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.tenant.*;
import mao.aggregate_pay_user_api.feign.TenantFeignClientV2;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.fallback
 * Class(类名): TenantFeignClientV2FallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:54
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class TenantFeignClientV2FallbackFactory implements FallbackFactory<TenantFeignClientV2>
{

    @Override
    public TenantFeignClientV2 create(Throwable throwable)
    {
        return new TenantFeignClientV2()
        {
            @Override
            public R<TenantDTO> createTenantAndInit(CreateTenantRequestDTO createTenantRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<TenantDTO> createTenantRelateAccount(CreateTenantRequestDTO createTenantRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<TenantDTO> getTenant(Long id)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<PageVO<TenantDTO>> queryTenants(TenantQueryDTO tenantQuery, Integer pageNo, Integer pageSize, String sortBy, String order)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<BundleDTO>> queryBundleByTenantType(String tenantType)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<BundleDTO> getBundle(String bundleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<BundleDTO>> queryAllBundle()
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> changeBundle(Long tenantId, String bundleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> initBundle(Long tenantId, String bundleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> createBundle(BundleDTO bundleDTO)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> modifyBundle(BundleDTO bundleDTO)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<AccountDTO> createAccount(CreateAccountRequestDTO createAccountRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> createAccount(ChangeAccountPwdDTO accountPwdRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> createAccountInTenant(CreateAccountRequestDTO createAccountRequest, Long tenantId)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> bindTenant(Long tenantId, String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> unbindTenant(Long tenantId, String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> isExistAccountByUsername(String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> isExistAccountByMobile(String mobile)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<AccountDTO> getAccountByUsername(String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<AccountDTO> getAccountByMobile(String mobile)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> isExistAccountInTenantByUsername(Long tenantId, String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<Boolean> isExistAccountInTenantByMobile(Long tenantId, String mobile)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<PageVO<AccountDTO>> queryAccount(AccountQueryDTO accountQuery, Integer pageNo, Integer pageSize, String sortBy, String order)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<List<TenantDTO>> queryAccountInTenant(String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<String> sendMessage(String phone)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<AccountDTO> authentication(AuthenticationInfo authenticationInfo)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<LoginInfoDTO> login(LoginRequestDTO loginRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public R<ApplicationDTO> getApplicationDTOByClientId(String clientId)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }
        };
    }
}
