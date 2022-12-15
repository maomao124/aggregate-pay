package mao.auth_server.dao.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.auth_entity.entity.common.OptLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project name(项目名称)：authority
 * Package(包名): mao.auth_server.dao.common
 * Interface(接口名): OptLogMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/11/9
 * Time(创建时间)： 21:12
 * Version(版本): 1.0
 * Description(描述)： 系统日志
 */

@Mapper
public interface OptLogMapper extends BaseMapper<OptLog>
{

}
