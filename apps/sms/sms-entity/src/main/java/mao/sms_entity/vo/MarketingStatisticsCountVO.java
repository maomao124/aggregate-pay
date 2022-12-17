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
 * Class(类名): MarketingStatisticsCountVO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:54
 * Version(版本): 1.0
 * Description(描述)： 营销数量统计
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("营销数量统计")
public class MarketingStatisticsCountVO
{
    /**
     * id
     */
    @ApiModelProperty("主键")
    private String id;

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
     * 日期时间
     */
    @ApiModelProperty("时间")
    private String date;

    /**
     * 成功率
     */
    @ApiModelProperty("成功率")
    private String successRate;

    /**
     * 标题
     */
    @ApiModelProperty("主题")
    private String title;

    /**
     * 签名
     */
    @ApiModelProperty("签名")
    private String signatureName;
}
