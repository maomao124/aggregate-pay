package mao.sms_manage.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import mao.sms_dao.mapper.PlatformMapper;
import mao.sms_entity.entity.PlatformEntity;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PlatformServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PlatformServiceImplTest
{
    @MockBean
    private PlatformMapper platformMapper;

    @Autowired
    private PlatformServiceImpl platformServiceImpl;

    /**
     * Method under test: {@link PlatformServiceImpl#getByName(String)}
     */
    @Test
    void testGetByName()
    {
        PlatformEntity platformEntity = new PlatformEntity();
        platformEntity.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        platformEntity.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
        platformEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        platformEntity.setCreateUser("Create User");
        platformEntity.setId("42");
        platformEntity.setIpAddr("42 Main St");
        platformEntity.setIsActive(1);
        platformEntity.setIsDelete(1);
        platformEntity.setLevel(1);
        platformEntity.setName("Name");
        platformEntity.setNeedAuth(1);
        platformEntity.setRemark("Remark");
        platformEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        platformEntity.setUpdateUser("2020-03-01");
        when(this.platformMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PlatformEntity>) any()))
                .thenReturn(platformEntity);
        assertSame(platformEntity, this.platformServiceImpl.getByName("Name"));
        verify(this.platformMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PlatformEntity>) any());
    }

    /**
     * Method under test: {@link PlatformServiceImpl#getByName(String)}
     */
    @Test
    void testGetByName2()
    {
        PlatformEntity platformEntity = new PlatformEntity();
        platformEntity.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
        platformEntity.setAccessKeySecret("EXAMPLEakiAIOSFODNN7");
        platformEntity.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        platformEntity.setCreateUser("Create User");
        platformEntity.setId("42");
        platformEntity.setIpAddr("42 Main St");
        platformEntity.setIsActive(1);
        platformEntity.setIsDelete(1);
        platformEntity.setLevel(1);
        platformEntity.setName("Name");
        platformEntity.setNeedAuth(1);
        platformEntity.setRemark("Remark");
        platformEntity.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        platformEntity.setUpdateUser("2020-03-01");
        when(this.platformMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PlatformEntity>) any()))
                .thenReturn(platformEntity);
        assertSame(platformEntity, this.platformServiceImpl.getByName(""));
        verify(this.platformMapper).selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PlatformEntity>) any());
    }

    /**
     * Method under test: {@link PlatformServiceImpl#getByName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetByName3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: foo
        //       at com.baomidou.mybatisplus.extension.service.impl.ServiceImpl.getOne(ServiceImpl.java:254)
        //       at com.baomidou.mybatisplus.extension.service.IService.getOne(IService.java:192)
        //       at mao.sms_manage.service.impl.PlatformServiceImpl.getByName(PlatformServiceImpl.java:32)
        //   In order to prevent getByName(String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getByName(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.platformMapper.selectOne((com.baomidou.mybatisplus.core.conditions.Wrapper<PlatformEntity>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        this.platformServiceImpl.getByName("Name");
    }
}

