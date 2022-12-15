package mao.tools_log.entity;

import java.time.LocalDateTime;


/**
 * Project name(项目名称)：logback_spring_boot_starter_demo
 * Package(包名): mao.tools_log.entity
 * Class(类名): OptLogDTO
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/10/31
 * Time(创建时间)： 21:47
 * Version(版本): 1.0
 * Description(描述)： 无
 */
public class OptLogDTO
{

    private static final long serialVersionUID = 1L;

    /**
     * 操作IP
     */
    private String requestIp;

    /**
     * 日志类型
     * #LogType{OPT:操作类型;EX:异常类型}
     */
    private String type;

    /**
     * 操作人
     */
    private String userName;

    /**
     * 操作描述
     */
    private String description;

    /**
     * 类路径
     */
    private String classPath;

    /**
     * 请求类型
     */
    private String actionMethod;

    /**
     * 请求地址
     */
    private String requestUri;

    /**
     * 请求类型
     * #HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;
     * TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}
     */
    private String httpMethod;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 返回值
     */
    private String result;

    /**
     * 异常详情信息
     */
    private String exDesc;

    /**
     * 异常描述
     */
    private String exDetail;

    /**
     * 开始时间
     */
    private LocalDateTime startTime;

    /**
     * 完成时间
     */
    private LocalDateTime finishTime;

    /**
     * 消耗时间
     */
    private Long consumingTime;

    /**
     * 浏览器
     */
    private String ua;

    /**
     * 创建用户
     */
    private Long createUser;


    /**
     * Instantiates a new Opt log dto.
     */
    public OptLogDTO()
    {

    }

    /**
     * Instantiates a new Opt log dto.
     *
     * @param requestIp     the request ip
     * @param type          the type
     * @param userName      the user name
     * @param description   the description
     * @param classPath     the class path
     * @param actionMethod  the action method
     * @param requestUri    the request uri
     * @param httpMethod    the http method
     * @param params        the params
     * @param result        the result
     * @param exDesc        the ex desc
     * @param exDetail      the ex detail
     * @param startTime     the start time
     * @param finishTime    the finish time
     * @param consumingTime the consuming time
     * @param ua            the ua
     * @param createUser    the create user
     */
    public OptLogDTO(String requestIp, String type, String userName, String description,
                     String classPath, String actionMethod, String requestUri,
                     String httpMethod, String params, String result, String exDesc,
                     String exDetail, LocalDateTime startTime, LocalDateTime finishTime,
                     Long consumingTime, String ua, Long createUser)
    {
        this.requestIp = requestIp;
        this.type = type;
        this.userName = userName;
        this.description = description;
        this.classPath = classPath;
        this.actionMethod = actionMethod;
        this.requestUri = requestUri;
        this.httpMethod = httpMethod;
        this.params = params;
        this.result = result;
        this.exDesc = exDesc;
        this.exDetail = exDetail;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.consumingTime = consumingTime;
        this.ua = ua;
        this.createUser = createUser;
    }

    /**
     * Gets request ip.
     *
     * @return the request ip
     */
    public String getRequestIp()
    {
        return requestIp;
    }

    /**
     * Sets request ip.
     *
     * @param requestIp the request ip
     */
    public void setRequestIp(String requestIp)
    {
        this.requestIp = requestIp;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * Sets user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Gets class path.
     *
     * @return the class path
     */
    public String getClassPath()
    {
        return classPath;
    }

    /**
     * Sets class path.
     *
     * @param classPath the class path
     */
    public void setClassPath(String classPath)
    {
        this.classPath = classPath;
    }

    /**
     * Gets action method.
     *
     * @return the action method
     */
    public String getActionMethod()
    {
        return actionMethod;
    }

    /**
     * Sets action method.
     *
     * @param actionMethod the action method
     */
    public void setActionMethod(String actionMethod)
    {
        this.actionMethod = actionMethod;
    }

    /**
     * Gets request uri.
     *
     * @return the request uri
     */
    public String getRequestUri()
    {
        return requestUri;
    }

    /**
     * Sets request uri.
     *
     * @param requestUri the request uri
     */
    public void setRequestUri(String requestUri)
    {
        this.requestUri = requestUri;
    }

    /**
     * Gets http method.
     *
     * @return the http method
     */
    public String getHttpMethod()
    {
        return httpMethod;
    }

    /**
     * Sets http method.
     *
     * @param httpMethod the http method
     */
    public void setHttpMethod(String httpMethod)
    {
        this.httpMethod = httpMethod;
    }

    /**
     * Gets params.
     *
     * @return the params
     */
    public String getParams()
    {
        return params;
    }

    /**
     * Sets params.
     *
     * @param params the params
     */
    public void setParams(String params)
    {
        this.params = params;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public String getResult()
    {
        return result;
    }

    /**
     * Sets result.
     *
     * @param result the result
     */
    public void setResult(String result)
    {
        this.result = result;
    }

    /**
     * Gets ex desc.
     *
     * @return the ex desc
     */
    public String getExDesc()
    {
        return exDesc;
    }

    /**
     * Sets ex desc.
     *
     * @param exDesc the ex desc
     */
    public void setExDesc(String exDesc)
    {
        this.exDesc = exDesc;
    }

    /**
     * Gets ex detail.
     *
     * @return the ex detail
     */
    public String getExDetail()
    {
        return exDetail;
    }

    /**
     * Sets ex detail.
     *
     * @param exDetail the ex detail
     */
    public void setExDetail(String exDetail)
    {
        this.exDetail = exDetail;
    }

    /**
     * Gets start time.
     *
     * @return the start time
     */
    public LocalDateTime getStartTime()
    {
        return startTime;
    }

    /**
     * Sets start time.
     *
     * @param startTime the start time
     */
    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }

    /**
     * Gets finish time.
     *
     * @return the finish time
     */
    public LocalDateTime getFinishTime()
    {
        return finishTime;
    }

    /**
     * Sets finish time.
     *
     * @param finishTime the finish time
     */
    public void setFinishTime(LocalDateTime finishTime)
    {
        this.finishTime = finishTime;
    }

    /**
     * Gets consuming time.
     *
     * @return the consuming time
     */
    public Long getConsumingTime()
    {
        return consumingTime;
    }

    /**
     * Sets consuming time.
     *
     * @param consumingTime the consuming time
     */
    public void setConsumingTime(Long consumingTime)
    {
        this.consumingTime = consumingTime;
    }

    /**
     * Gets ua.
     *
     * @return the ua
     */
    public String getUa()
    {
        return ua;
    }

    /**
     * Sets ua.
     *
     * @param ua the ua
     */
    public void setUa(String ua)
    {
        this.ua = ua;
    }

    /**
     * Gets create user.
     *
     * @return the create user
     */
    public Long getCreateUser()
    {
        return createUser;
    }

    /**
     * Sets create user.
     *
     * @param createUser the create user
     */
    public void setCreateUser(Long createUser)
    {
        this.createUser = createUser;
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

        OptLogDTO optLogDTO = (OptLogDTO) o;

        if (getRequestIp() != null ? !getRequestIp().equals(optLogDTO.getRequestIp()) : optLogDTO.getRequestIp() != null)
        {
            return false;
        }
        if (getType() != null ? !getType().equals(optLogDTO.getType()) : optLogDTO.getType() != null)
        {
            return false;
        }
        if (getUserName() != null ? !getUserName().equals(optLogDTO.getUserName()) : optLogDTO.getUserName() != null)
        {
            return false;
        }
        if (getDescription() != null ? !getDescription().equals(optLogDTO.getDescription()) : optLogDTO.getDescription() != null)
        {
            return false;
        }
        if (getClassPath() != null ? !getClassPath().equals(optLogDTO.getClassPath()) : optLogDTO.getClassPath() != null)
        {
            return false;
        }
        if (getActionMethod() != null ? !getActionMethod().equals(optLogDTO.getActionMethod()) : optLogDTO.getActionMethod() != null)
        {
            return false;
        }
        if (getRequestUri() != null ? !getRequestUri().equals(optLogDTO.getRequestUri()) : optLogDTO.getRequestUri() != null)
        {
            return false;
        }
        if (getHttpMethod() != null ? !getHttpMethod().equals(optLogDTO.getHttpMethod()) : optLogDTO.getHttpMethod() != null)
        {
            return false;
        }
        if (getParams() != null ? !getParams().equals(optLogDTO.getParams()) : optLogDTO.getParams() != null)
        {
            return false;
        }
        if (getResult() != null ? !getResult().equals(optLogDTO.getResult()) : optLogDTO.getResult() != null)
        {
            return false;
        }
        if (getExDesc() != null ? !getExDesc().equals(optLogDTO.getExDesc()) : optLogDTO.getExDesc() != null)
        {
            return false;
        }
        if (getExDetail() != null ? !getExDetail().equals(optLogDTO.getExDetail()) : optLogDTO.getExDetail() != null)
        {
            return false;
        }
        if (getStartTime() != null ? !getStartTime().equals(optLogDTO.getStartTime()) : optLogDTO.getStartTime() != null)
        {
            return false;
        }
        if (getFinishTime() != null ? !getFinishTime().equals(optLogDTO.getFinishTime()) : optLogDTO.getFinishTime() != null)
        {
            return false;
        }
        if (getConsumingTime() != null ? !getConsumingTime().equals(optLogDTO.getConsumingTime()) : optLogDTO.getConsumingTime() != null)
        {
            return false;
        }
        if (getUa() != null ? !getUa().equals(optLogDTO.getUa()) : optLogDTO.getUa() != null)
        {
            return false;
        }
        return getCreateUser() != null ? getCreateUser().equals(optLogDTO.getCreateUser()) : optLogDTO.getCreateUser() == null;
    }

    @Override
    public int hashCode()
    {
        int result1 = getRequestIp() != null ? getRequestIp().hashCode() : 0;
        result1 = 31 * result1 + (getType() != null ? getType().hashCode() : 0);
        result1 = 31 * result1 + (getUserName() != null ? getUserName().hashCode() : 0);
        result1 = 31 * result1 + (getDescription() != null ? getDescription().hashCode() : 0);
        result1 = 31 * result1 + (getClassPath() != null ? getClassPath().hashCode() : 0);
        result1 = 31 * result1 + (getActionMethod() != null ? getActionMethod().hashCode() : 0);
        result1 = 31 * result1 + (getRequestUri() != null ? getRequestUri().hashCode() : 0);
        result1 = 31 * result1 + (getHttpMethod() != null ? getHttpMethod().hashCode() : 0);
        result1 = 31 * result1 + (getParams() != null ? getParams().hashCode() : 0);
        result1 = 31 * result1 + (getResult() != null ? getResult().hashCode() : 0);
        result1 = 31 * result1 + (getExDesc() != null ? getExDesc().hashCode() : 0);
        result1 = 31 * result1 + (getExDetail() != null ? getExDetail().hashCode() : 0);
        result1 = 31 * result1 + (getStartTime() != null ? getStartTime().hashCode() : 0);
        result1 = 31 * result1 + (getFinishTime() != null ? getFinishTime().hashCode() : 0);
        result1 = 31 * result1 + (getConsumingTime() != null ? getConsumingTime().hashCode() : 0);
        result1 = 31 * result1 + (getUa() != null ? getUa().hashCode() : 0);
        result1 = 31 * result1 + (getCreateUser() != null ? getCreateUser().hashCode() : 0);
        return result1;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("OptLogDTO{");
        sb.append("requestIp='").append(requestIp).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", classPath='").append(classPath).append('\'');
        sb.append(", actionMethod='").append(actionMethod).append('\'');
        sb.append(", requestUri='").append(requestUri).append('\'');
        sb.append(", httpMethod='").append(httpMethod).append('\'');
        sb.append(", params='").append(params).append('\'');
        sb.append(", result='").append(result).append('\'');
        sb.append(", exDesc='").append(exDesc).append('\'');
        sb.append(", exDetail='").append(exDetail).append('\'');
        sb.append(", startTime=").append(startTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", consumingTime=").append(consumingTime);
        sb.append(", ua='").append(ua).append('\'');
        sb.append(", createUser=").append(createUser);
        sb.append('}');
        return sb.toString();
    }
}
