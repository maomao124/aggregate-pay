package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_user_api.dto.resource.ResourceDTO;
import mao.aggregate_pay_user_service.entity.ResourceButton;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): ResourceButtonMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 18:30
 * Version(版本): 1.0
 * Description(描述)： 菜单
 */

@Mapper
public interface ResourceButtonMapper extends BaseMapper<ResourceButton>
{

    /**
     * selectButtonByPrivilegeInApp
     *
     * @param privilegeCodes  特权代码
     * @param applicationCode 应用程序代码
     * @return {@link List}<{@link ResourceDTO}>
     */
    @Select("<script>" +
            "select a.`NAME`,a.`CODE`,b.* from resource_button b " +
            "LEFT JOIN resource_application a ON a.`CODE`=b.APPLICATION_CODE " +
            "where APPLICATION_CODE=#{applicationCode} " +
            "and PRIVILEGE_CODE in <foreach collection='privilegeCodes' item='item' open='(' separator=',' close=')'>#{item}</foreach> " +
            "</script>")
    List<ResourceDTO> selectButtonByPrivilegeInApp(@Param("privilegeCodes") List<String> privilegeCodes, @Param("applicationCode") String applicationCode);

}
