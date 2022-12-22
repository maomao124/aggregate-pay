package mao.sms_manage.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mao.sms_entity.entity.BlackListEntity;
import mao.sms_dao.mapper.BlackListMapper;
import mao.sms_manage.excel.BlackListExcelDTO;
import mao.sms_manage.service.BlackListService;
import mao.tools_core.base.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_manage.service.impl
 * Class(类名): BlackListServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/20
 * Time(创建时间)： 19:13
 * Version(版本): 1.0
 * Description(描述)： 黑名单
 */

@Slf4j
@Service
public class BlackListServiceImpl extends ServiceImpl<BlackListMapper, BlackListEntity> implements BlackListService
{

    /**
     * 手机号码正则表达式
     */
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[1]\\d{10}$");

    @Override
    @SneakyThrows
    public R<Map<String, Object>> upload(MultipartFile file)
    {
        //从上传的表中得到数据
        ImportParams importParams = new ImportParams();
        List<BlackListExcelDTO> blackListExcelDTOs = ExcelImportUtil.importExcel(file.getInputStream(), BlackListExcelDTO.class, importParams);
        //得到总数
        int total = blackListExcelDTOs.size();
        log.debug("黑名单导入 解析文件:{} 条", total);
        //列表
        List<String> nullErrorMsg = new ArrayList<>();
        List<String> matchErrorMsg = new ArrayList<>();
        //重复
        List<String> duplicateErrorMsg = new ArrayList<>();

        //遍历
        for (int i = 0; i < blackListExcelDTOs.size(); i++)
        {
            //得到blackListExcelDTOs中的第i个
            BlackListExcelDTO blackListExcelDTO = blackListExcelDTOs.get(i);
            //手机号是否为空
            if (StringUtils.isBlank(blackListExcelDTO.getMobile()))
            {
                //手机号为空
                nullErrorMsg.add("第" + (i + 1) + "条");
                continue;
            }
            //正则表达式匹配手机号
            if (!PHONE_PATTERN.matcher(blackListExcelDTO.getMobile()).matches())
            {
                //正则表达式匹配手机号失败
                matchErrorMsg.add("第" + (i + 1) + "条");
                continue;
            }
            try
            {
                //尝试往数据库里插入
                int flag = super.baseMapper.insert(BlackListEntity.builder().type("1").content(blackListExcelDTO.getMobile()).remark(blackListExcelDTO.getRemark()).build());
                //判断结果
                if (flag <= 0)
                {
                    //插入失败
                    duplicateErrorMsg.add("第" + (i + 1) + "条");
                }
                //插入成功，什么都不做
            }
            catch (Exception e)
            {
                if (e.getClass().getName().equals("org.springframework.dao.DuplicateKeyException"))
                {
                    //DuplicateKeyException异常
                    duplicateErrorMsg.add("第" + (i + 1) + "条");
                }
                else
                {
                    log.warn("入库异常 {} ：", e.getClass().getName(), e);
                }
            }
        }

        //统计失败的总数据
        int fail = nullErrorMsg.size() + matchErrorMsg.size() + duplicateErrorMsg.size();
        log.debug("黑名单导入 入库成功:{} 条", (total - fail));

        Map<String, Object> result = new HashMap<>();
        //总数
        result.put("total", total);
        //成功的数量
        result.put("success", total - fail);
        //失败的数量
        result.put("fail", fail);
        //空的信息
        result.put("nullErrorMsg", nullErrorMsg);
        //不是手机号的信息
        result.put("matchErrorMsg", matchErrorMsg);
        //已重复的信息
        result.put("duplicateErrorMsg", duplicateErrorMsg);
        return R.success(result);
    }
}
