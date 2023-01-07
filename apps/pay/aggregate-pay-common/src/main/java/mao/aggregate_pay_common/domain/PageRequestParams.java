package mao.aggregate_pay_common.domain;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.domain
 * Class(类名): PageRequestParams
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 14:46
 * Version(版本): 1.0
 * Description(描述)： 页面请求参数
 */

public class PageRequestParams
{
    /**
     * 开始行
     */
    private long startRow;

    /**
     * 限制
     */
    private long limit;

    /**
     * 页面请求参数
     *
     * @param startRow 开始行
     * @param limit    限制
     */
    private PageRequestParams(Long startRow, Long limit)
    {
        this.startRow = startRow;
        this.limit = limit;
    }

    /**
     * @param pageNo   页面号码
     * @param pageSize 页面大小
     * @return {@link PageRequestParams}
     */
    public static PageRequestParams of(Integer pageNo, Integer pageSize)
    {
        Long startRow = (long) ((long) (pageNo - 1) * pageSize);
        Long limit = Long.valueOf((pageSize));
        return new PageRequestParams(startRow, limit);
    }

    /**
     * 开始行
     *
     * @return long
     */
    public long getStartRow()
    {
        return startRow;
    }

    /**
     * 设置开始行
     *
     * @param startRow 开始行
     */
    public void setStartRow(long startRow)
    {
        this.startRow = startRow;
    }

    /**
     * 得到限制
     *
     * @return long
     */
    public long getLimit()
    {
        return limit;
    }

    /**
     * 设置限制
     *
     * @param limit 限制
     */
    public void setLimit(long limit)
    {
        this.limit = limit;
    }

}
