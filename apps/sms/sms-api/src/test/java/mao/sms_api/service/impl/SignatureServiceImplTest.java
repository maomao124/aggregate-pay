package mao.sms_api.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import mao.sms_dao.mapper.SignatureMapper;
import mao.sms_entity.entity.SignatureEntity;
import mao.tools_j2cache.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SignatureServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SignatureServiceImplTest
{
    @MockBean
    private RedisUtils redisUtils;

    @MockBean
    private SignatureMapper signatureMapper;

    @Autowired
    private SignatureServiceImpl signatureServiceImpl;

    /**
     * Method under test: {@link SignatureServiceImpl#getByCode(String)}
     */
    @Test
    void testGetByCode()
    {
        SignatureEntity signatureEntity = new SignatureEntity();
        signatureEntity.setCode("Code");
        signatureEntity.setContent("Not all who wander are lost");
        signatureEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureEntity.setCreateUser("Create User");
        signatureEntity.setId("42");
        signatureEntity.setIsDelete(1);
        signatureEntity.setName("Name");
        signatureEntity.setRemark("Remark");
        signatureEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        signatureEntity.setUpdateUser("2020-03-01");
        when(this.redisUtils.query((String) any(), (String) any(), (String) any(), (Class<SignatureEntity>) any(),
                (java.util.function.Function<String, SignatureEntity>) any(), (Long) any(),
                (java.util.concurrent.TimeUnit) any(), (Integer) any())).thenReturn(signatureEntity);
        assertSame(signatureEntity, this.signatureServiceImpl.getByCode("Signature"));
        verify(this.redisUtils).query((String) any(), (String) any(), (String) any(), (Class<SignatureEntity>) any(),
                (java.util.function.Function<String, SignatureEntity>) any(), (Long) any(),
                (java.util.concurrent.TimeUnit) any(), (Integer) any());
    }
}

