package mao.sms_api.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import mao.sms_dao.mapper.ConfigMapper;
import mao.sms_entity.entity.ConfigEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ConfigServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ConfigServiceImplTest
{
    @MockBean
    private ConfigMapper configMapper;

    @Autowired
    private ConfigServiceImpl configServiceImpl;

    /**
     * Method under test: {@link ConfigServiceImpl#findByTemplateSignature(String, String)}
     */
    @Test
    void testFindByTemplateSignature()
    {
        ArrayList<ConfigEntity> configEntityList = new ArrayList<>();
        when(this.configMapper.findByTemplateSignature((java.util.Map<?, ?>) any())).thenReturn(configEntityList);
        List<ConfigEntity> actualFindByTemplateSignatureResult = this.configServiceImpl.findByTemplateSignature("Template",
                "Signature");
        assertSame(configEntityList, actualFindByTemplateSignatureResult);
        assertTrue(actualFindByTemplateSignatureResult.isEmpty());
        verify(this.configMapper).findByTemplateSignature((java.util.Map<?, ?>) any());
    }
}

