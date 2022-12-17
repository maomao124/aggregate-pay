package mao.sms_entity.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_entity.vo
 * Class(类名): SendLogPageVO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:57
 * Version(版本): 1.0
 * Description(描述)： 发送记录
 */

@Data
@ApiModel(description = "发送记录")
public class SendLogPageVO
{
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;

    /**
     * 签名名字
     */
    @ApiModelProperty("签名名称")
    private String signatureName;

    /**
     * 模板名称
     */
    @ApiModelProperty("模板名称")
    private String templateName;

    /**
     * 模板类型
     */
    @ApiModelProperty("模板类型")
    private String templateType;

    /**
     * 模板内容
     */
    @ApiModelProperty("模板内容")
    private String templateContent;

    /**
     * 平台名称
     */
    @ApiModelProperty("发信方")
    private String platformName;

    /**
     * 内容文本
     */
    @ApiModelProperty(value = "短信内容")
    private String contentText;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态：0失败，1成功")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 日期
     */
    @ApiModelProperty(value = "时间 精确到日")
    private String date;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    /**
     * 营销短信主键
     */
    @ApiModelProperty(value = "营销短信主键")
    private String marketingId;

    /**
     * 响应
     */
    @ApiModelProperty(value = "响应")
    private String response;

    /**
     * 错误
     */
    @ApiModelProperty(value = "错误")
    private String error;

    /**
     * 配置平台
     */
    @ApiModelProperty(value = "配置平台")
    private String configPlatform;


    /**
     * 构建标注
     */
    public void buildRemark()
    {
        //如果状态为成功，则直接返回
        if (status == 1)
        {
            return;
        }
        //状态为失败
        switch (configPlatform)
        {
            case "未找到":
                remark = "未找到合适配置";
                break;
                //梦网平台
            case "MengWang":
                //阿里云平台
            case "Aliyun":
                //Feige
            case "Feige":
                //判断响应是否为空
                if (StringUtils.isNotEmpty(response))
                {
                    //不为空，json转类
                    JSONObject jsonObject = JSON.parseObject(response);
                    //是否包含Message
                    if (jsonObject.containsKey("Message"))
                    {
                        //获取Message字段值
                        remark = jsonObject.getString("Message");
                    }
                }
                //响应为空
                else
                {
                    remark = error;
                }
                break;
                //华为平台
            case "Huawei":
                //判断响应是否为空
                if (StringUtils.isNotEmpty(response))
                {
                    //不为空，json转类
                    JSONObject jsonObject = JSON.parseObject(response);
                    //是否包含description
                    if (jsonObject.containsKey("description"))
                    {
                        //获取description字段值
                        remark = jsonObject.getString("description");
                    }
                }
                //响应为空
                else
                {
                    remark = error;
                }
                break;
                //京东云
            case "Jd":
                //判断响应是否为空
                if (StringUtils.isNotEmpty(response))
                {
                    //不为空，json转类
                    JSONObject jsonObject = JSON.parseObject(response);
                    //是否包含result
                    if (jsonObject.containsKey("result"))
                    {
                        //获取result的message字段值
                        remark = jsonObject.getJSONObject("result").getString("message");
                    }
                }
                //响应为空
                else
                {
                    remark = error;
                }
                break;
                //乐信平台
            case "Lexin":
                //判断响应是否为空
                if (StringUtils.isNotEmpty(response))
                {
                    //不为空，json转类
                    JSONObject jsonObject = JSON.parseObject(response);
                    //是否包含replyMsg
                    if (jsonObject.containsKey("replyMsg"))
                    {
                        //获取replyMsg字段值
                        remark = jsonObject.getString("replyMsg");
                    }
                }
                //响应为空
                else
                {
                    remark = error;
                }
                break;
                //默认
            default:
                remark = error;
                break;
        }
    }


    public void cleanBigField()
    {
        response = null;
        error = null;
    }
}
