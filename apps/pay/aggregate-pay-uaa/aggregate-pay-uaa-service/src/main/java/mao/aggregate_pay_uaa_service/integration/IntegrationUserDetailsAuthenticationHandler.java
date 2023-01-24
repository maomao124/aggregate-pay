package mao.aggregate_pay_uaa_service.integration;

import java.time.LocalDateTime;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import mao.aggregate_pay_common.domain.BusinessException;
import mao.aggregate_pay_common.utils.StringUtil;
import mao.aggregate_pay_entity.entity.LoginLog;
import mao.aggregate_pay_uaa_service.domain.AuthPrincipal;
import mao.aggregate_pay_uaa_service.domain.UnifiedUserDetails;
import mao.aggregate_pay_uaa_service.feign.log.LoginLogFeignClient;
import mao.aggregate_pay_uaa_service.utils.IPUtils;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.resource.ResourceDTO;
import mao.aggregate_pay_user_api.dto.tenant.LoginInfoDTO;
import mao.aggregate_pay_user_api.dto.tenant.LoginRequestDTO;
import mao.aggregate_pay_user_api.dto.tenant.TenantDTO;
import mao.aggregate_pay_user_api.feign.TenantFeignClient;
import mao.aggregate_pay_user_api.feign.TenantFeignClientV2;
import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.integration
 * Class(类名): IntegrationUserDetailsAuthenticationHandler
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 19:52
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
public class IntegrationUserDetailsAuthenticationHandler
{
    private final TenantFeignClientV2 tenantFeignClient;

    private final LoginLogFeignClient loginLogFeignClient;


    public IntegrationUserDetailsAuthenticationHandler(TenantFeignClientV2 tenantFeignClient,
                                                       LoginLogFeignClient loginLogFeignClient)
    {
        this.tenantFeignClient = tenantFeignClient;
        this.loginLogFeignClient = loginLogFeignClient;
    }

    /**
     * 认证处理 简易判断，后期优化结构
     *
     * @param authPrincipal 认证用户的身份信息
     * @param credentials   认证用户的登录凭证
     * @return {@link UnifiedUserDetails}
     */
    public UnifiedUserDetails authentication(AuthPrincipal authPrincipal, String credentials)
    {
        /*
         * 1.调用TenantService.login(LoginRequestDTO loginRequest)获取应用、权限、资源，设置为UnifiedUserDetails.payload
         * 2.根据client_id获取当前接入应用所属租户ID(ResourceService.queryApplication(String applicationCode))，设置为UnifiedUserDetails.tenantId
         **/

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
        loginRequestDTO.setPrincipal(authPrincipal.getUsername());
        loginRequestDTO.setCertificate(credentials);
        loginRequestDTO.setAuthenticationType(authPrincipal.getAuthenticationType());
        if ("sms".equals(authPrincipal.getAuthenticationType()))
        {
            loginRequestDTO.setSmsKey(authPrincipal.getPayload().get("smsKey").toString());
        }
        LoginInfoDTO loginInfoDTO = null;
        try
        {
            R<LoginInfoDTO> r = tenantFeignClient.login(loginRequestDTO);
            if (r.getIsError())
            {
                throw BizException.wrap(r.getCode(), r.getMsg());
            }
            loginInfoDTO = r.getData();
            log.info("loginInfoDTO:{}", JSON.toJSONString(loginInfoDTO));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            if (ex instanceof BusinessException)
            {
                BusinessException be = (BusinessException) ex;
                log.info(JSON.toJSONString(be));
                throw new BadCredentialsException("登录错误: " + be.getErrorCode().getDesc());
            }
            else
            {
                throw new BadCredentialsException("登录错误: " + ex.getMessage());
            }
        }
        if (loginInfoDTO == null)
        {
            throw new BadCredentialsException("用户不存在");
        }

        //%%%%%%%%%%%%%%   上面是login返回的结构 自行格式化查看 需要组装成下面结构   %%%%%%%%%%%%%%%%%%
            /*"payload": {    //描述的是某账号在不同租户下的信息
                "租户A": { //登录账号所属租户id，每个登录账号可能从属多个租户
                    "user_authorities": { //账号在某租户下权限
                        "ROLE_DOMAIN": [ //角色
                            "P1",//角色下权限
                            "P2"
                        ]
                    },
                    "resources": { //账号在某租户下拥有的资源
                        "应用A": { //应用id，资源按应用分别描述
                            "menu": {}, //某资源类型下资源，如菜单类型、按钮类型
                            "button": {}
                        },
                        "应用B": {}
                    }
                },
                "租户B": {}
            }
            */
        UnifiedUserDetails userDetails = new UnifiedUserDetails(authPrincipal.getUsername(), credentials);
        userDetails.setMobile(loginInfoDTO.getMobile());
        Map<Long, Object> payload = new HashMap<>();//拼最后的payload结构
        Map<Long, AuthorizationInfoDTO> tenantAuthorizationInfoMap = loginInfoDTO.getTenantAuthorizationInfoMap();//得到权限信息
        Map<Long, List<ResourceDTO>> resources = loginInfoDTO.getResources();// 得到资源信息

        for (Map.Entry<Long, AuthorizationInfoDTO> entry : tenantAuthorizationInfoMap.entrySet())
        {
            Long tenantId = entry.getKey();
            Map map = new HashMap();
            map.put("user_authorities", entry.getValue().getRolePrivilegeMap());
            map.put("resources", resources.get(tenantId));

            payload.put(tenantId, map);
        }
        userDetails.setPayload(payload);

        Map detailsMap = authPrincipal.getPayload();
        String client_id = (String) detailsMap.get("client_id");

        //授权码模式 简化模式没有client_id  密码模式会传client_id
        if (StringUtil.isNotBlank(client_id))
        {
            R<ApplicationDTO> r = tenantFeignClient.getApplicationDTOByClientId(client_id);
            if (r.getIsError())
            {
                throw BizException.wrap(r.getCode(), r.getMsg());
            }
            ApplicationDTO applicationDTO = r.getData();
            Map tenantIdMap = new HashMap();
            tenantIdMap.put("tenantId", applicationDTO.getTenantId());
            userDetails.setTenant(tenantIdMap);
        }
        log.info("@@@@@@@@@@@:{}", JSON.toJSONString(userDetails));


        List<Long> tenants = new ArrayList<>(loginInfoDTO.getTenants().size());
        for (TenantDTO tenantDTO : loginInfoDTO.getTenants())
        {
            tenants.add(tenantDTO.getId());
        }
        //转json
        String json = JSON.toJSONString(tenants);

        //构建登录日志
        LoginLog loginLog = new LoginLog();
        loginLog.setRequestIp(IPUtils.getIP());
        loginLog.setUserId(loginInfoDTO.getId());
        loginLog.setUsername(loginInfoDTO.getUsername());
        loginLog.setMobile(loginInfoDTO.getMobile());
        loginLog.setTenants(json);
        loginLog.setLoginDate(LocalDateTime.now());
        //根据ip地址设置位置，CPU开销较大，暂时不填充此字段，可以参考tools-log模块的AddressUtil工具类
        //loginLog.setLocation("");
        //保存登录日志
        loginLogFeignClient.save(loginLog);

        return userDetails;
    }

}
