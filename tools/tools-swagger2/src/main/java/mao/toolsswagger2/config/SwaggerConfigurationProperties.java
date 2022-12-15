package mao.toolsswagger2.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Project name(项目名称)：swagger_knife4j_demo
 * Package(包名): mao.swagger_knife4j_demo.config
 * Class(类名): SwaggerConfigurationProperties
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/27
 * Time(创建时间)： 13:16
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Component("swaggerConfigurationProperties")
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfigurationProperties
{
    /**
     * 标题
     */
    private String title = "在线文档";

    /**
     * 自定义组名
     */
    private String group = "";

    /**
     * 描述
     */
    private String description = "在线文档";

    /**
     * 版本
     */
    private String version = "1.0";

    /**
     * 联系人
     */
    private Contact contact = new Contact();

    /**
     * swagger会解析的包路径
     */
    private String basePackage = "";

    /**
     * swagger会解析的url规则
     */
    private List<String> basePath = new ArrayList<>();

    /**
     * 在basePath基础上需要排除的url规则
     */
    private List<String> excludePath = new ArrayList<>();

    /**
     * 分组文档
     */
    private Map<String, DocketInfo> docket = new LinkedHashMap<>();


    public SwaggerConfigurationProperties()
    {

    }

    /**
     * 构造方法
     *
     * @param title       标题
     * @param group       组
     * @param description 描述
     * @param version     版本
     * @param contact     联系
     * @param basePackage 基本包
     * @param basePath    基本路径
     * @param excludePath 排除路径
     * @param docket      摘要
     */
    public SwaggerConfigurationProperties(String title, String group, String description,
                                          String version, Contact contact, String basePackage,
                                          List<String> basePath, List<String> excludePath,
                                          Map<String, DocketInfo> docket)
    {
        this.title = title;
        this.group = group;
        this.description = description;
        this.version = version;
        this.contact = contact;
        this.basePackage = basePackage;
        this.basePath = basePath;
        this.excludePath = excludePath;
        this.docket = docket;
    }

    /**
     * 获得组
     *
     * @return {@link String}
     */
    public String getGroup()
    {
        if (group == null || "".equals(group))
        {
            return title;
        }
        return group;
    }


    /**
     * 获得标题
     *
     * @return {@link String}
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * 设置组
     *
     * @param group 组
     */
    public void setGroup(String group)
    {
        this.group = group;
    }

    /**
     * 得到描述
     *
     * @return {@link String}
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * 获得版本
     *
     * @return {@link String}
     */
    public String getVersion()
    {
        return version;
    }

    /**
     * 设置版本
     *
     * @param version 版本
     */
    public void setVersion(String version)
    {
        this.version = version;
    }

    /**
     * 得到联系
     *
     * @return {@link Contact}
     */
    public Contact getContact()
    {
        return contact;
    }

    /**
     * 建立联系
     *
     * @param contact 联系
     */
    public void setContact(Contact contact)
    {
        this.contact = contact;
    }

    /**
     * 获得基础包
     *
     * @return {@link String}
     */
    public String getBasePackage()
    {
        return basePackage;
    }

    /**
     * 设置基础包
     *
     * @param basePackage 基本包
     */
    public void setBasePackage(String basePackage)
    {
        this.basePackage = basePackage;
    }

    /**
     * 得到基本路径
     *
     * @return {@link List}<{@link String}>
     */
    public List<String> getBasePath()
    {
        return basePath;
    }

    /**
     * 设置基本路径
     *
     * @param basePath 基本路径
     */
    public void setBasePath(List<String> basePath)
    {
        this.basePath = basePath;
    }

    /**
     * 得到排除路径
     *
     * @return {@link List}<{@link String}>
     */
    public List<String> getExcludePath()
    {
        return excludePath;
    }

    /**
     * 设置排除路径
     *
     * @param excludePath 排除路径
     */
    public void setExcludePath(List<String> excludePath)
    {
        this.excludePath = excludePath;
    }

    /**
     * 得到摘要
     *
     * @return {@link Map}<{@link String}, {@link DocketInfo}>
     */
    public Map<String, DocketInfo> getDocket()
    {
        return docket;
    }

    /**
     * 设置摘要
     *
     * @param docket 摘要
     */
    public void setDocket(Map<String, DocketInfo> docket)
    {
        this.docket = docket;
    }

    public static class DocketInfo
    {
        /**
         * 标题
         */
        private String title = "在线文档";

        /**
         * 自定义组名
         */
        private String group = "";

        /**
         * 描述
         */
        private String description = "在线文档";

        /**
         * 版本
         */
        private String version = "1.0";

        /**
         * 联系人
         */
        private Contact contact = new Contact();

        /**
         * swagger会解析的包路径
         */
        private String basePackage = "";

        /**
         * swagger会解析的url规则
         */
        private List<String> basePath = new ArrayList<>();

        /**
         * 在basePath基础上需要排除的url
         */
        private List<String> excludePath = new ArrayList<>();


        public DocketInfo()
        {

        }

        /**
         * 构造方法
         *
         * @param title       标题
         * @param group       组
         * @param description 描述
         * @param version     版本
         * @param contact     联系
         * @param basePackage 基本包
         * @param basePath    基本路径
         * @param excludePath 排除路径
         */
        public DocketInfo(String title, String group, String description,
                          String version, Contact contact, String basePackage,
                          List<String> basePath, List<String> excludePath)
        {
            this.title = title;
            this.group = group;
            this.description = description;
            this.version = version;
            this.contact = contact;
            this.basePackage = basePackage;
            this.basePath = basePath;
            this.excludePath = excludePath;
        }

        /**
         * 获得组
         *
         * @return {@link String}
         */
        public String getGroup()
        {
            if (group == null || "".equals(group))
            {
                return title;
            }
            return group;
        }

        /**
         * 获得标题
         *
         * @return {@link String}
         */
        public String getTitle()
        {
            return title;
        }

        /**
         * 设置标题
         *
         * @param title 标题
         */
        public void setTitle(String title)
        {
            this.title = title;
        }

        /**
         * 设置组
         *
         * @param group 组
         */
        public void setGroup(String group)
        {
            this.group = group;
        }

        /**
         * 得到描述
         *
         * @return {@link String}
         */
        public String getDescription()
        {
            return description;
        }

        /**
         * 设置描述
         *
         * @param description 描述
         */
        public void setDescription(String description)
        {
            this.description = description;
        }

        /**
         * 获得版本
         *
         * @return {@link String}
         */
        public String getVersion()
        {
            return version;
        }

        /**
         * 设置版本
         *
         * @param version 版本
         */
        public void setVersion(String version)
        {
            this.version = version;
        }

        /**
         * 得到联系
         *
         * @return {@link Contact}
         */
        public Contact getContact()
        {
            return contact;
        }

        /**
         * 建立联系
         *
         * @param contact 联系
         */
        public void setContact(Contact contact)
        {
            this.contact = contact;
        }

        /**
         * 获得基础包
         *
         * @return {@link String}
         */
        public String getBasePackage()
        {
            return basePackage;
        }

        /**
         * 设置基础包
         *
         * @param basePackage 基本包
         */
        public void setBasePackage(String basePackage)
        {
            this.basePackage = basePackage;
        }

        /**
         * 得到基本路径
         *
         * @return {@link List}<{@link String}>
         */
        public List<String> getBasePath()
        {
            return basePath;
        }

        /**
         * 设置基本路径
         *
         * @param basePath 基本路径
         */
        public void setBasePath(List<String> basePath)
        {
            this.basePath = basePath;
        }

        /**
         * 得到排除路径
         *
         * @return {@link List}<{@link String}>
         */
        public List<String> getExcludePath()
        {
            return excludePath;
        }

        /**
         * 设置排除路径
         *
         * @param excludePath 排除路径
         */
        public void setExcludePath(List<String> excludePath)
        {
            this.excludePath = excludePath;
        }

        @Override
        public String toString()
        {
            final StringBuffer sb = new StringBuffer("DocketInfo{");
            sb.append("title='").append(title).append('\'');
            sb.append(", group='").append(group).append('\'');
            sb.append(", description='").append(description).append('\'');
            sb.append(", version='").append(version).append('\'');
            sb.append(", contact=").append(contact);
            sb.append(", basePackage='").append(basePackage).append('\'');
            sb.append(", basePath=").append(basePath);
            sb.append(", excludePath=").append(excludePath);
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Contact
    {
        /**
         * 联系人名称
         */
        private String name = "";

        /**
         * url
         */
        private String url = "";

        /**
         * 电子邮件
         */
        private String email = "";


        public Contact()
        {

        }

        /**
         * 构造方法
         *
         * @param name  名字
         * @param url   url
         * @param email 电子邮件
         */
        public Contact(String name, String url, String email)
        {
            this.name = name;
            this.url = url;
            this.email = email;
        }

        /**
         * 得到名字
         *
         * @return {@link String}
         */
        public String getName()
        {
            return name;
        }

        /**
         * 设置名字
         *
         * @param name 名字
         */
        public void setName(String name)
        {
            this.name = name;
        }

        /**
         * 获取url
         *
         * @return {@link String}
         */
        public String getUrl()
        {
            return url;
        }

        /**
         * 设置url
         *
         * @param url url
         */
        public void setUrl(String url)
        {
            this.url = url;
        }

        /**
         * 获得电子邮件
         *
         * @return {@link String}
         */
        public String getEmail()
        {
            return email;
        }

        /**
         * 设置电子邮件
         *
         * @param email 电子邮件
         */
        public void setEmail(String email)
        {
            this.email = email;
        }

        @Override
        public String toString()
        {
            final StringBuffer sb = new StringBuffer("Contact{");
            sb.append("name='").append(name).append('\'');
            sb.append(", url='").append(url).append('\'');
            sb.append(", email='").append(email).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        SwaggerConfigurationProperties that = (SwaggerConfigurationProperties) o;

        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null)
        {
            return false;
        }
        if (getGroup() != null ? !getGroup().equals(that.getGroup()) : that.getGroup() != null)
        {
            return false;
        }
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
        {
            return false;
        }
        if (getVersion() != null ? !getVersion().equals(that.getVersion()) : that.getVersion() != null)
        {
            return false;
        }
        if (getContact() != null ? !getContact().equals(that.getContact()) : that.getContact() != null)
        {
            return false;
        }
        if (getBasePackage() != null ? !getBasePackage().equals(that.getBasePackage()) : that.getBasePackage() != null)
        {
            return false;
        }
        if (getBasePath() != null ? !getBasePath().equals(that.getBasePath()) : that.getBasePath() != null)
        {
            return false;
        }
        if (getExcludePath() != null ? !getExcludePath().equals(that.getExcludePath()) : that.getExcludePath() != null)
        {
            return false;
        }
        return getDocket() != null ? getDocket().equals(that.getDocket()) : that.getDocket() == null;
    }

    @Override
    public int hashCode()
    {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getGroup() != null ? getGroup().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        result = 31 * result + (getContact() != null ? getContact().hashCode() : 0);
        result = 31 * result + (getBasePackage() != null ? getBasePackage().hashCode() : 0);
        result = 31 * result + (getBasePath() != null ? getBasePath().hashCode() : 0);
        result = 31 * result + (getExcludePath() != null ? getExcludePath().hashCode() : 0);
        result = 31 * result + (getDocket() != null ? getDocket().hashCode() : 0);
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString()
    {
        final StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("title：").append(title).append('\n');
        stringbuilder.append("group：").append(group).append('\n');
        stringbuilder.append("description：").append(description).append('\n');
        stringbuilder.append("version：").append(version).append('\n');
        stringbuilder.append("contact：").append(contact).append('\n');
        stringbuilder.append("basePackage：").append(basePackage).append('\n');
        stringbuilder.append("basePath：").append(basePath).append('\n');
        stringbuilder.append("excludePath：").append(excludePath).append('\n');
        stringbuilder.append("docket：").append(docket).append('\n');
        return stringbuilder.toString();
    }
}
