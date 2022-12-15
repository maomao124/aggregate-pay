package mao.tools_databases.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static mao.tools_databases.properties.DatabaseProperties.PREFIX;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.tools_databases.properties
 * Class(类名): DatabaseProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/8
 * Time(创建时间)： 14:01
 * Version(版本): 1.0
 * Description(描述)： 无
 */
@ConfigurationProperties(prefix = PREFIX)
@Data
@NoArgsConstructor
public class DatabaseProperties
{
    public static final String PREFIX = "database";
    /**
     * 攻击 SQL 阻断解析器
     */
    public Boolean isBlockAttack = false;

    /**
     * 是否启用数据权限
     */
    //private Boolean isDataScope = true;
    /**
     * 事务超时时间
     */
    private int txTimeout = 60 * 60;
    /**
     * 统一管理事务的方法名
     */
    private List<String> transactionAttributeList = new ArrayList<>(Arrays.asList("add*", "save*", "insert*",
            "create*", "update*", "edit*", "upload*", "delete*", "remove*",
            "clean*", "recycle*", "batch*", "mark*", "disable*", "enable*", "handle*", "syn*",
            "reg*", "gen*", "*Tx"
    ));
    /**
     * 事务扫描基础包
     */
    private String transactionScanPackage = "mao";
}
