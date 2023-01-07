package mao.aggregate_pay_common.utils;

import java.util.Random;

/**
 * Project name(项目名称)：aggregate-pay
 * Package(包名): mao.aggregate_pay_common.utils
 * Class(类名): IdWorkerUtils
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/1/7
 * Time(创建时间)： 20:46
 * Version(版本): 1.0
 * Description(描述)： id生成器
 */

public class IdWorkerUtils
{
    /**
     * 随机
     */
    private static final Random RANDOM = new Random();

    /**
     * 工人id比特
     */
    private static final long WORKER_ID_BITS = 5L;

    /**
     * datacenteridbits
     */
    private static final long DATACENTERIDBITS = 5L;

    /**
     * 最大值工人id
     */
    private static final long MAX_WORKER_ID = ~(-1L << WORKER_ID_BITS);

    /**
     * 最大值数据中心id
     */
    private static final long MAX_DATACENTER_ID = ~(-1L << DATACENTERIDBITS);

    /**
     * 位序列
     */
    private static final long SEQUENCE_BITS = 12L;

    /**
     * 工人身份转变
     */
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;

    /**
     * 数据中心id转变
     */
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;

    /**
     * 时间戳左移
     */
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTERIDBITS;

    /**
     * 序列面具
     */
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    /**
     * id工人跑龙套
     */
    private static final IdWorkerUtils ID_WORKER_UTILS = new IdWorkerUtils();

    /**
     * 职工身份证
     */
    private final long workerId;

    /**
     * 数据中心id
     */
    private final long datacenterId;

    /**
     * idepoch
     */
    private final long idepoch;

    /**
     * 序列
     */
    private long sequence = '0';

    /**
     * 最后一个时间戳
     */
    private long lastTimestamp = -1L;

    /**
     * id工人跑龙套
     */
    private IdWorkerUtils()
    {
        this(RANDOM.nextInt((int) MAX_WORKER_ID), RANDOM.nextInt((int) MAX_DATACENTER_ID), 1288834974657L);
    }

    /**
     * id工人跑龙套
     *
     * @param workerId     职工身份证
     * @param datacenterId 数据中心id
     * @param idepoch      idepoch
     */
    private IdWorkerUtils(final long workerId, final long datacenterId, final long idepoch)
    {
        if (workerId > MAX_WORKER_ID || workerId < 0)
        {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        if (datacenterId > MAX_DATACENTER_ID || datacenterId < 0)
        {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", MAX_DATACENTER_ID));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.idepoch = idepoch;
    }

    /**
     * 获得实例
     * Gets instance.
     *
     * @return the instance
     */
    public static IdWorkerUtils getInstance()
    {
        return ID_WORKER_UTILS;
    }

    /**
     * 下一个id
     *
     * @return long
     */
    public synchronized long nextId()
    {
        long timestamp = timeGen();
        if (timestamp < lastTimestamp)
        {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp)
        {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0)
            {
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        else
        {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - idepoch) << TIMESTAMP_LEFT_SHIFT)
                | (datacenterId << DATACENTER_ID_SHIFT)
                | (workerId << WORKER_ID_SHIFT) | sequence;
    }

    /**
     * 直到下一个飞船
     *
     * @param lastTimestamp 最后一个时间戳
     * @return long
     */
    private long tilNextMillis(final long lastTimestamp)
    {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp)
        {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 时间创
     *
     * @return long
     */
    private long timeGen()
    {
        return System.currentTimeMillis();
    }

    /**
     * 建立零件号
     * Build part number string.
     *
     * @return the string
     */
    public String buildPartNumber()
    {
        return String.valueOf(ID_WORKER_UTILS.nextId());
    }

    /**
     * 创建uuid
     * Create uuid string.
     *
     * @return the string
     */
    public String createUUID()
    {
        return String.valueOf(ID_WORKER_UTILS.nextId());
    }

    /**
     * main方法
     *
     * @param args 参数
     */
    public static void main(String[] args)
    {
        System.out.println(IdWorkerUtils.getInstance().nextId());
    }
}
