package mao.sms_api.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import mao.sms_dao.mapper.TemplateMapper;
import mao.sms_entity.entity.TemplateEntity;
import mao.tools_j2cache.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TemplateServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TemplateServiceImplTest
{
    @MockBean
    private RedisUtils redisUtils;

    @MockBean
    private TemplateMapper templateMapper;

    @Autowired
    private TemplateServiceImpl templateServiceImpl;

    /**
     * Method under test: {@link TemplateServiceImpl#getByCode(String)}
     */
    @Test
    void testGetByCode()
    {
        TemplateEntity templateEntity = new TemplateEntity();
        templateEntity.setCode("Code");
        templateEntity.setContent("Not all who wander are lost");
        templateEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateEntity.setCreateUser("Create User");
        templateEntity.setId("42");
        templateEntity.setIsDelete(1);
        templateEntity.setName("Name");
        templateEntity.setRemark("Remark");
        templateEntity.setType(1);
        templateEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        templateEntity.setUpdateUser("2020-03-01");
        when(this.redisUtils.query((String) any(), (String) any(), (String) any(), (Class<TemplateEntity>) any(),
                (java.util.function.Function<String, TemplateEntity>) any(), (Long) any(),
                (java.util.concurrent.TimeUnit) any(), (Integer) any())).thenReturn(templateEntity);
        assertSame(templateEntity, this.templateServiceImpl.getByCode("Template"));
        verify(this.redisUtils).query((String) any(), (String) any(), (String) any(), (Class<TemplateEntity>) any(),
                (java.util.function.Function<String, TemplateEntity>) any(), (Long) any(),
                (java.util.concurrent.TimeUnit) any(), (Integer) any());
    }
}

