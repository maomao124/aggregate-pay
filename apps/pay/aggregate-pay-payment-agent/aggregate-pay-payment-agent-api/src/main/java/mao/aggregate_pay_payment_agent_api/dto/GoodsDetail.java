package mao.aggregate_pay_payment_agent_api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_payment_agent_api.dto
 * Class(类名): GoodsDetail
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/31
 * Time(创建时间)： 14:38
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Data
public class GoodsDetail implements Serializable
{
    /**
     * 支付宝定义的统一商品编号
     */
    private String alipayGoodsId;

    /**
     * 商品描述信息
     */
    private String body;

    /**
     * 商品类目树，从商品类目根节点到叶子节点的类目id组成，类目id值使用|分割
     */
    private String categoriesTree;

    /**
     * 商品类目
     */
    private String goodsCategory;

    /**
     * 商品的编号
     */
    private String goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品单价，单位为元
     */
    private String price;

    /**
     * 商品数量
     */
    private Long quantity;

    /**
     * 商品的展示地址
     */
    private String showUrl;
}
