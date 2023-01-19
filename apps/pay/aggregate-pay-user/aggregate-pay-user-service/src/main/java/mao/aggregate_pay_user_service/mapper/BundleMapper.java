package mao.aggregate_pay_user_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.aggregate_pay_user_service.entity.Bundle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_user_service.mapper
 * Interface(接口名): BundleMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/19
 * Time(创建时间)： 18:22
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Mapper
public interface BundleMapper extends BaseMapper<Bundle>
{
    /**
     * 查询套餐包
     *
     * @param bundleCode 套餐包代码
     * @return {@link Bundle}
     */
    @Select("select * from bundle where CODE=#{bundleCode}")
    Bundle selectBundleByCode(@Param("bundleCode") String bundleCode);
}
