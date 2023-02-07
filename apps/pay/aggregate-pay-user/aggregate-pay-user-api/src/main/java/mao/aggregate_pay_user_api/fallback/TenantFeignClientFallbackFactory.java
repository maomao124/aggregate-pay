package mao.aggregate_pay_user_api.fallback;

import org.springframework.cloud.openfeign.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.tenant.*;
import mao.aggregate_pay_user_api.feign.TenantFeignClient;
import mao.tools_core.exception.BizException;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_api.fallback
 * Class(类名): TenantFeignClientFallbackFactory
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/2/7
 * Time(创建时间)： 14:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class TenantFeignClientFallbackFactory implements FallbackFactory<TenantFeignClient>
{

    @Override
    public TenantFeignClient create(Throwable throwable)
    {
        return new TenantFeignClient()
        {
            @Override
            public TenantDTO createTenantAndInit(CreateTenantRequestDTO createTenantRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public TenantDTO createTenantRelateAccount(CreateTenantRequestDTO createTenantRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public TenantDTO getTenant(Long id)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public PageVO<TenantDTO> queryTenants(TenantQueryDTO tenantQuery, Integer pageNo, Integer pageSize, String sortBy, String order)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public List<BundleDTO> queryBundleByTenantType(String tenantType)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public BundleDTO getBundle(String bundleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public List<BundleDTO> queryAllBundle()
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void changeBundle(Long tenantId, String bundleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void initBundle(Long tenantId, String bundleCode)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void createBundle(BundleDTO bundleDTO)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void modifyBundle(BundleDTO bundleDTO)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public AccountDTO createAccount(CreateAccountRequestDTO createAccountRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public Boolean createAccount(ChangeAccountPwdDTO accountPwdRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void createAccountInTenant(CreateAccountRequestDTO createAccountRequest, Long tenantId)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void bindTenant(Long tenantId, String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public void unbindTenant(Long tenantId, String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public boolean isExistAccountByUsername(String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public boolean isExistAccountByMobile(String mobile)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public AccountDTO getAccountByUsername(String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public AccountDTO getAccountByMobile(String mobile)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public boolean isExistAccountInTenantByUsername(Long tenantId, String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public boolean isExistAccountInTenantByMobile(Long tenantId, String mobile)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public PageVO<AccountDTO> queryAccount(AccountQueryDTO accountQuery, Integer pageNo, Integer pageSize, String sortBy, String order)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public List<TenantDTO> queryAccountInTenant(String username)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public String sendMessage(String phone)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public AccountDTO authentication(AuthenticationInfo authenticationInfo)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public LoginInfoDTO login(LoginRequestDTO loginRequest)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }

            @Override
            public ApplicationDTO getApplicationDTOByClientId(String clientId)
            {
                log.error("用户服务不可用或者服务异常：", throwable);
                throw BizException.wrap("用户服务不可用或者服务异常");
            }
        };
    }
}
