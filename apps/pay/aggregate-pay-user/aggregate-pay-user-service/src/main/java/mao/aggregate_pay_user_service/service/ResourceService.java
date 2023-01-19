package mao.aggregate_pay_user_service.service;

import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.auth.AuthorizationInfoDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationQueryParams;
import mao.aggregate_pay_user_api.dto.resource.ResourceDTO;

import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.service
 * Interface(接口名): ResourceService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 20:07
 * Version(版本): 1.0
 * Description(描述)： 资源服务
 */

public interface ResourceService
{
    /**
     * 创建应用
     * 会关联创建uaa服务中的接入客户端，其中code为clientId
     *
     * @param application 应用程序
     */
    void createApplication(ApplicationDTO application);

    /**
     * 修改应用
     * 仅仅可以修改名称
     *
     * @param application 应用程序
     */
    void modifyApplication(ApplicationDTO application);

    /**
     * 删除应用
     * 关联删除uaa服务中的接入客户端，若应用下有资源，禁止删除
     *
     * @param applicationCode 应用程序代码
     */
    void removeApplication(String applicationCode);

    /**
     * 根据应用编码查找应用
     *
     * @param applicationCode 应用程序代码
     * @return {@link ApplicationDTO}
     */
    ApplicationDTO queryApplication(String applicationCode);

    /**
     * 条件分页查找应用
     *
     * @param query    查询
     * @param pageNo   页面号码
     * @param pageSize 页面大小
     * @return {@link PageVO}<{@link ApplicationDTO}>
     */
    PageVO<ApplicationDTO> pageApplicationByConditions(ApplicationQueryParams query,
                                                       Integer pageNo, Integer pageSize);

    /**
     * 根据权限加载指定应用的资源
     *
     * @param privileageCodes privileage代码
     * @param applicationCode 应用程序代码
     * @return {@link List}<{@link ResourceDTO}>
     */
    List<ResourceDTO> loadResources(List<String> privileageCodes, String applicationCode);


    /**
     * 获取多个租户下权限所对应的的资源信息，并按应用拆分
     *
     * @param tenantAuthorizationInfoMap 多个租户下的权限信息，key为租户id  value为租户下的角色权限信息
     * @return 多个租户下的资源信息，key为租户id  value为租户下多个应用的资源信息
     * 如：{租户A:[{应用1权限信息},{应用2权限信息}],租户B:[{},{}...]}
     */
    Map<Long, List<ResourceDTO>> loadResources(Map<Long, AuthorizationInfoDTO> tenantAuthorizationInfoMap);
}
