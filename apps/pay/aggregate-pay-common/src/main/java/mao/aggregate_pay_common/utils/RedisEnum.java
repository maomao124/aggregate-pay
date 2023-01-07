package mao.aggregate_pay_common.utils;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): RedisEnum
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 21:31
 * Version(版本): 1.0
 * Description(描述)： redis枚举工具类
 */

public enum RedisEnum
{
    /**
     * 数据字典Service - 根据字典类型查询字典数据
     */
    SJPAY_SERVICE_QUERYLISTBYENTITYREDIS(
            RedisUtil.KEY_PREFIX, "Service", "queryListByEntityRedis", "数据字典Redis缓存"),
    SJPAY_SERVICE_QUERYPARAMBYREDIS(RedisUtil.KEY_PREFIX, "appId", "channel", "描述缓存");

    /**
     * 系统标识
     */
    private String keyPrefix;
    /**
     * 模块名称
     */
    private String module;
    /**
     * 方法名称
     */
    private String func;
    /**
     * 描述
     */
    private String remark;

    RedisEnum()
    {
    }

    RedisEnum(String keyPrefix, String module, String func, String remark)
    {
        this.keyPrefix = keyPrefix;
        this.module = module;
        this.func = func;
        this.remark = remark;
    }

    public String getKeyPrefix()
    {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix)
    {
        this.keyPrefix = keyPrefix;
    }

    public String getModule()
    {
        return module;
    }

    public void setModule(String module)
    {
        this.module = module;
    }

    public String getFunc()
    {
        return func;
    }

    public void setFunc(String func)
    {
        this.func = func;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    @Override
    public String toString()
    {
        return "RedisEnum{" +
                "keyPrefix='" + keyPrefix + '\'' +
                ", module='" + module + '\'' +
                ", func='" + func + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
