package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mao.aggregate_pay_user_api.dto.resource.ApplicationDTO;
import mao.aggregate_pay_user_api.dto.resource.ApplicationQueryParams;
import mao.aggregate_pay_user_service.entity.ResourceApplication;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): ResourceApplicationMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 18:27
 * Version(版本): 1.0
 * Description(描述)： 应用信息
 */

@Mapper
public interface ResourceApplicationMapper extends BaseMapper<ResourceApplication>
{

    /**
     * 分页查询应用
     *
     * @param page  页面
     * @param query 查询
     * @return {@link List}<{@link ApplicationDTO}>
     */
    @Select("<script>"
            + "select * from resource_application a "
            + "<where>"
            + "<if test=\"query.name != null and query.name!=''\"> "
            + "and a.NAME like CONCAT('%',#{query.name},'%') "
            + "</if>"
            + "</where>" +
            "</script>")
    List<ApplicationDTO> selectAppByPage(@Param("page") Page<ApplicationDTO> page, @Param("query") ApplicationQueryParams query);

}
