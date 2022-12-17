package mao.sms_manage.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.excel
 * Class(类名): BlackListExcelDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 21:10
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlackListExcelDTO implements Serializable
{
    /**
     *手机号
     */
    @Excel(name = "手机号", orderNum = "1")
    private String mobile;

    /**
     * 备注
     */
    @Excel(name = "备注", orderNum = "2")
    private String remark;
}
