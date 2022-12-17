package mao.sms_entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.vo
 * Class(类名): StatisticsCountVO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 20:16
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("数量统计")
public class StatisticsCountVO
{
    /**
     * 总数
     */
    @ApiModelProperty("总数")
    private int count;

    /**
     * 成功数
     */
    @ApiModelProperty("成功数")
    private int success;

    /**
     * 失败数
     */
    @ApiModelProperty("失败数")
    private int fail;

    /**
     * 日期
     */
    @ApiModelProperty("时间")
    private String date;

    /**
     * 成功率
     */
    @ApiModelProperty("成功率")
    private String successRate;
}
