package mao.aggregate_pay_transaction_api.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_transaction_api.dto
 * Class(类名): QRCodeDto
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/13
 * Time(创建时间)： 22:01
 * Version(版本): 1.0
 * Description(描述)： 二维码DTO
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QRCodeDto implements Serializable
{
    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 应用程序id
     */
    private String appId;

    /**
     * 门店id
     */
    private Long storeId;

    /**
     * 商品标题
     */
    private String subject;

    /**
     * 订单描述
     */
    private String body;
}
