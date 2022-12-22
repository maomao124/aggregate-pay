package mao.sms_dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mao.sms_entity.entity.ManualProcessEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_dao.mapper
 * Interface(接口名): ManualProcessMapper
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/17
 * Time(创建时间)： 19:48
 * Version(版本): 1.0
 * Description(描述)： 人工处理
 */

@Mapper
public interface ManualProcessMapper extends BaseMapper<ManualProcessEntity>
{

}
