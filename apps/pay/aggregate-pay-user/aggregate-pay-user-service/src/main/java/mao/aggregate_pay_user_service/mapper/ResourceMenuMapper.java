package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.aggregate_pay_user_api.dto.menu.MenuDTO;
import mao.aggregate_pay_user_api.dto.menu.MenuQueryDTO;
import mao.aggregate_pay_user_api.dto.resource.ResourceAPPDTO;
import mao.aggregate_pay_user_api.dto.resource.ResourceDTO;
import mao.aggregate_pay_user_service.entity.ResourceMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): ResourceMenuMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 18:35
 * Version(版本): 1.0
 * Description(描述)： 菜单
 */

@Mapper
public interface ResourceMenuMapper extends BaseMapper<ResourceMenu>
{

    /**
     * 通过application代码查询资源
     *
     * @param applicationCode 应用程序代码
     * @return int
     */
    @Select("select count(*) from resource_menu m where m.APPLICATION_CODE=#{applicationCode}")
    int selectResourceByApplicationCode(@Param("applicationCode") String applicationCode);


    /**
     * 在应用程序查询资源特权
     *
     * @param privilegeCodes  特权代码
     * @param applicationCode 应用程序代码
     * @return {@link List}<{@link ResourceDTO}>
     */
    @Select("<script>" +
            "select a.`NAME`,a.`CODE`,m.* from resource_menu m " +
            "LEFT JOIN resource_application a ON a.`CODE`=m.APPLICATION_CODE " +
            "where APPLICATION_CODE=#{applicationCode} " +
            "and PRIVILEGE_CODE in <foreach collection='privilegeCodes' item='item' open='(' separator=',' close=')'>#{item}</foreach> " +
            "</script>")
    List<ResourceDTO> selectResourceByPrivilegeInApp(@Param("privilegeCodes") List<String> privilegeCodes, @Param("applicationCode") String applicationCode);

    /**
     * 分页查询
     *
     * @param page   页面
     * @param params 参数个数
     * @return {@link List}<{@link MenuDTO}>
     */
    @Select("<script>"
            + "select * from resource_menu m "
            + "LEFT JOIN resource_application a ON a.`CODE`=m.APPLICATION_CODE "
            + "<where>"
            + "<if test=\"params.applicationCode != null and params.applicationCode!=''\"> "
            + "and a.`CODE`= #{params.applicationCode} "
            + "</if>"
            + "<if test=\"params.title != null and params.title!=''\"> "
            + "and m.TITLE= #{params.title} "  //and m.TITLE like "%"#{params.title}"%"
            + "</if>"
            + "<if test=\"params.status != null and params.status!=''\"> "
            + "and m.STATUS= #{params.status} "
            + "</if>"
            + "</where>" +
            "</script>")
    List<MenuDTO> selectByPage(@Param("page") Page<MenuDTO> page, @Param("params") MenuQueryDTO params);


    /**
     * 查询资源
     *
     * @param pcodes pcodes
     * @return {@link List}<{@link ResourceAPPDTO}>
     */
    @Select("<script>" +
            "select * from  resource_menu m " +
            "left join resource_application a on a.`CODE`= m.APPLICATION_CODE " +
            "where m.PRIVILEGE_CODE in <foreach collection='pcodes' item='item' open='(' separator=',' close=')'>#{item}</foreach> " +
            "</script>")
    List<ResourceAPPDTO> selectResource(@Param("pcodes") List<String> pcodes);

}
