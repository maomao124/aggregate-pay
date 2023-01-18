package mao.aggregate_pay_uaa_service.repository;

import mao.aggregate_pay_uaa_service.domain.OauthClientDetails;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.repository
 * Interface(接口名): OauthRepository
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:06
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public interface OauthRepository
{

    /**
     * 找到oauth客户详细信息
     *
     * @param clientId 客户机id
     * @return {@link OauthClientDetails}
     */
    OauthClientDetails findOauthClientDetails(String clientId);

    /**
     * 找到所有oauth客户细节
     *
     * @return {@link List}<{@link OauthClientDetails}>
     */
    List<OauthClientDetails> findAllOauthClientDetails();

    /**
     * oauth更新客户档案细节
     *
     * @param clientId 客户机id
     * @param archive  存档
     */
    void updateOauthClientDetailsArchive(String clientId, boolean archive);

    /**
     * 保存oauth客户细节
     *
     * @param clientDetails 客户详细信息
     */
    void saveOauthClientDetails(OauthClientDetails clientDetails);


}
