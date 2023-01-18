package mao.aggregate_pay_uaa_service.repository;

import mao.aggregate_pay_uaa_service.domain.OauthClientDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_uaa_service.repository
 * Class(类名): OauthClientDetailsRowMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/18
 * Time(创建时间)： 20:05
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class OauthClientDetailsRowMapper implements RowMapper<OauthClientDetails>
{
    public OauthClientDetailsRowMapper()
    {

    }

    @Override
    public OauthClientDetails mapRow(ResultSet rs, int i) throws SQLException
    {
        OauthClientDetails clientDetails = new OauthClientDetails();

        clientDetails.clientId(rs.getString("client_id"));
        clientDetails.resourceIds(rs.getString("resource_ids"));
        clientDetails.clientSecret(rs.getString("client_secret"));

        clientDetails.scope(rs.getString("scope"));
        clientDetails.authorizedGrantTypes(rs.getString("authorized_grant_types"));
        clientDetails.webServerRedirectUri(rs.getString("web_server_redirect_uri"));

        clientDetails.authorities(rs.getString("authorities"));
        clientDetails.accessTokenValidity(getInteger(rs, "access_token_validity"));
        clientDetails.refreshTokenValidity(getInteger(rs, "refresh_token_validity"));

        clientDetails.additionalInformation(rs.getString("additional_information"));
        clientDetails.createTime(rs.getTimestamp("create_time").toLocalDateTime());
        clientDetails.archived(rs.getBoolean("archived"));

        clientDetails.trusted(rs.getBoolean("trusted"));
        clientDetails.autoApprove(rs.getString("autoapprove"));

        return clientDetails;
    }


    private Integer getInteger(ResultSet rs, String columnName) throws SQLException
    {
        final Object object = rs.getObject(columnName);
        if (object != null)
        {
            return (Integer) object;
        }
        return null;
    }
}
