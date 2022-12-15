package mao.tools_log.utils;

import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;


/**
 * Project name(项目名称)：logback_spring_boot_starter_demo
 * Package(包名): mao.tools_log.utils
 * Class(类名): AddressUtil
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/31
 * Time(创建时间)： 22:17
 * Version(版本): 1.0
 * Description(描述)： 解析ip地址的工具类
 */

public class AddressUtil
{
    private static final String JAVA_TEMP_DIR = "java.io.tmpdir";

    private static final Logger log = LoggerFactory.getLogger(AddressUtil.class);

    static DbConfig config = null;
    static DbSearcher searcher = null;


    /**
     * 根据ip查询地址
     *
     * @param ip ip地址
     * @return {@link String}
     */
    /*public static String getCityInfo(String ip)
    {
        DbSearcher searcher = null;
        try
        {
            String dbPath = AddressUtil.class.getResource("/ip2region/ip2region.db").getPath();
            File file = new File(dbPath);
            if (!file.exists())
            {
                String tmpDir = System.getProperties().getProperty(JAVA_TEMP_DIR);
                dbPath = tmpDir + "ip2region.db";
                file = new File(dbPath);
                String classPath = "classpath:ip2region/ip2region.db";
                InputStream resourceAsStream = ResourceUtil.getStreamSafe(classPath);
                if (resourceAsStream != null)
                {
                    FileUtils.copyInputStreamToFile(resourceAsStream, file);
                }
            }
            DbConfig config = new DbConfig();
            searcher = new DbSearcher(config, file.getPath());
            Method method = searcher.getClass().getMethod("btreeSearch", String.class);
            if (!Util.isIpAddress(ip))
            {
                log.error("Error: Invalid ip address");
            }
            DataBlock dataBlock = (DataBlock) method.invoke(searcher, ip);
            return dataBlock.getRegion();
        }
        catch (Exception e)
        {
            log.error("获取地址信息异常，", e);
            return StrUtil.EMPTY;
        }
        finally
        {
            if (searcher != null)
            {
                try
                {
                    searcher.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }*/

    /*
     * 初始化IP库
     */
    static
    {
        try
        {
            // 因为jar无法读取文件,复制创建临时文件
//            String tmpDir = System.getProperty("user.dir") + File.separator + "temp";
//            String dbPath = tmpDir + File.separator + "ip2region.db";
//            log.info("init ip region db path [{}]", dbPath);
//            File file = new File(dbPath);
//            FileUtils.copyInputStreamToFile(AddressUtil.class.getClassLoader().getResourceAsStream("ip2region/ip2region.db"), file);
            String dbPath = AddressUtil.class.getResource("/ip2region/ip2region.db").getPath();
            File file = new File(dbPath);
            if (!file.exists())
            {
                String tmpDir = System.getProperties().getProperty(JAVA_TEMP_DIR);
                dbPath = tmpDir + "ip2region.db";
                file = new File(dbPath);
                String classPath = "classpath:ip2region/ip2region.db";
                InputStream resourceAsStream = ResourceUtil.getStreamSafe(classPath);
                if (resourceAsStream != null)
                {
                    FileUtils.copyInputStreamToFile(resourceAsStream, file);
                }
            }
            config = new DbConfig();
            searcher = new DbSearcher(config, dbPath);
            log.info("bean [{}]", config);
            log.info("bean [{}]", searcher);
        }
        catch (Exception e)
        {
            log.error("init ip region error:", e);
        }
    }


    /**
     * 解析ip
     *
     * @param ip ip地址
     * @return {@link String}
     */
    public static String getRegion(String ip)
    {
        try
        {
            //db
            if (searcher == null || StrUtil.isEmpty(ip))
            {
                log.error("DbSearcher is null");
                return StrUtil.EMPTY;
            }
            long startTime = System.currentTimeMillis();
            //查询算法
            int algorithm = DbSearcher.MEMORY_ALGORITYM;
            Method method = null;
            switch (algorithm)
            {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
            }

            DataBlock dataBlock = null;
            if (!Util.isIpAddress(ip))
            {
                log.warn("warning: Invalid ip address");
            }
            dataBlock = (DataBlock) method.invoke(searcher, ip);
            String result = dataBlock.getRegion();
            long endTime = System.currentTimeMillis();
            log.debug("region use time[{}] result[{}]", endTime - startTime, result);
            return result;

        }
        catch (Exception e)
        {
            log.error("error:", e);
        }
        return StrUtil.EMPTY;
    }

    public static void main(String[] args)
    {
        System.out.println(AddressUtil.getRegion("113.222.142.84"));
        System.out.println(AddressUtil.getRegion("113.221.141.84"));
        System.out.println(AddressUtil.getRegion("113.192.142.84"));
        System.out.println(AddressUtil.getRegion("113.224.142.84"));
        System.out.println(AddressUtil.getRegion("114.222.142.84"));
        System.out.println(AddressUtil.getRegion("115.222.142.84"));
        System.out.println(AddressUtil.getRegion("117.222.142.84"));
        System.out.println(AddressUtil.getRegion("119.222.142.84"));
        System.out.println(AddressUtil.getRegion("13.222.142.84"));
        System.out.println(AddressUtil.getRegion("14.222.142.84"));
        System.out.println(AddressUtil.getRegion("15.222.142.84"));
        System.out.println(AddressUtil.getRegion("16.222.142.84"));
    }
}
