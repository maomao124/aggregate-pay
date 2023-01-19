package mao.aggregate_pay_user_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import mao.aggregate_pay_common.domain.PageVO;
import mao.aggregate_pay_user_api.dto.menu.MenuDTO;
import mao.aggregate_pay_user_api.dto.menu.MenuQueryDTO;
import mao.aggregate_pay_user_service.entity.ResourceMenu;
import mao.aggregate_pay_user_service.mapper.ResourceMenuMapper;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {MenuServiceImpl.class})
@ExtendWith(SpringExtension.class)
class MenuServiceImplTest
{
    @MockBean
    private DozerUtils dozerUtils;

    @Autowired
    private MenuServiceImpl menuServiceImpl;

    @MockBean
    private ResourceMenuMapper resourceMenuMapper;

    /**
     * Method under test: {@link MenuServiceImpl#queryMenu(Long)}
     */
    @Test
    void testQueryMenu()
    {
        ResourceMenu resourceMenu = new ResourceMenu();
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");
        when(this.resourceMenuMapper.selectById((java.io.Serializable) any())).thenReturn(resourceMenu);

        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setApplication("Application");
        menuDTO.setApplicationCode("Application Code");
        menuDTO.setCode("Code");
        menuDTO.setComment("Comment");
        menuDTO.setIcon("Icon");
        menuDTO.setId(123L);
        menuDTO.setParentId(123L);
        menuDTO.setPrivilegeCode("Privilege Code");
        menuDTO.setSort(1);
        menuDTO.setStatus(1);
        menuDTO.setTitle("Dr");
        menuDTO.setUrl("https://example.org/example");
        when(this.dozerUtils.map((Object) any(), (Class<MenuDTO>) any())).thenReturn(menuDTO);
        assertSame(menuDTO, this.menuServiceImpl.queryMenu(123L));
        verify(this.resourceMenuMapper).selectById((java.io.Serializable) any());
        verify(this.dozerUtils).map((Object) any(), (Class<MenuDTO>) any());
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenu(Long)}
     */
    @Test
    void testQueryMenu2()
    {
        ResourceMenu resourceMenu = new ResourceMenu();
        resourceMenu.setApplicationCode("Application Code");
        resourceMenu.setComment("Comment");
        resourceMenu.setIcon("Icon");
        resourceMenu.setId(123L);
        resourceMenu.setParentId(123L);
        resourceMenu.setPrivilegeCode("Privilege Code");
        resourceMenu.setSort(1);
        resourceMenu.setStatus(1);
        resourceMenu.setTitle("Dr");
        resourceMenu.setUrl("https://example.org/example");
        when(this.resourceMenuMapper.selectById((java.io.Serializable) any())).thenReturn(resourceMenu);
        when(this.dozerUtils.map((Object) any(), (Class<MenuDTO>) any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> this.menuServiceImpl.queryMenu(123L));
        verify(this.resourceMenuMapper).selectById((java.io.Serializable) any());
        verify(this.dozerUtils).map((Object) any(), (Class<MenuDTO>) any());
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenu(MenuQueryDTO, Integer, Integer)}
     */
    @Test
    void testQueryMenu3()
    {
        when(this.resourceMenuMapper.selectByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<MenuDTO>) any(), (MenuQueryDTO) any()))
                .thenReturn(new ArrayList<>());

        MenuQueryDTO menuQueryDTO = new MenuQueryDTO();
        menuQueryDTO.setApplicationCode("Application Code");
        menuQueryDTO.setStatus(1);
        menuQueryDTO.setTitle("Dr");
        PageVO<MenuDTO> actualQueryMenuResult = this.menuServiceImpl.queryMenu(menuQueryDTO, 1, 3);
        assertEquals(0L, actualQueryMenuResult.getCounts());
        assertFalse(actualQueryMenuResult.isFirst());
        assertFalse(actualQueryMenuResult.hasItems());
        assertEquals(3, actualQueryMenuResult.getPageSize());
        verify(this.resourceMenuMapper).selectByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<MenuDTO>) any(), (MenuQueryDTO) any());
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenu(MenuQueryDTO, Integer, Integer)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryMenu4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_user_service.service.impl.MenuServiceImpl.queryMenu(MenuServiceImpl.java:86)
        //   In order to prevent queryMenu(MenuQueryDTO, Integer, Integer)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryMenu(MenuQueryDTO, Integer, Integer).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.resourceMenuMapper.selectByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<MenuDTO>) any(), (MenuQueryDTO) any()))
                .thenReturn(new ArrayList<>());

        MenuQueryDTO menuQueryDTO = new MenuQueryDTO();
        menuQueryDTO.setApplicationCode("Application Code");
        menuQueryDTO.setStatus(1);
        menuQueryDTO.setTitle("Dr");
        this.menuServiceImpl.queryMenu(menuQueryDTO, null, 3);
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenu(MenuQueryDTO, Integer, Integer)}
     */
    @Test
    void testQueryMenu5()
    {
        when(this.resourceMenuMapper.selectByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<MenuDTO>) any(), (MenuQueryDTO) any()))
                .thenReturn(new ArrayList<>());

        MenuQueryDTO menuQueryDTO = new MenuQueryDTO();
        menuQueryDTO.setApplicationCode("Application Code");
        menuQueryDTO.setStatus(1);
        menuQueryDTO.setTitle("Dr");
        PageVO<MenuDTO> actualQueryMenuResult = this.menuServiceImpl.queryMenu(menuQueryDTO, 1, null);
        assertEquals(0L, actualQueryMenuResult.getCounts());
        assertFalse(actualQueryMenuResult.isFirst());
        assertFalse(actualQueryMenuResult.hasItems());
        assertEquals(20, actualQueryMenuResult.getPageSize());
        verify(this.resourceMenuMapper).selectByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<MenuDTO>) any(), (MenuQueryDTO) any());
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenu(MenuQueryDTO, Integer, Integer)}
     */
    @Test
    void testQueryMenu6()
    {
        when(this.resourceMenuMapper.selectByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<MenuDTO>) any(), (MenuQueryDTO) any()))
                .thenReturn(new ArrayList<>());

        MenuQueryDTO menuQueryDTO = new MenuQueryDTO();
        menuQueryDTO.setApplicationCode("Application Code");
        menuQueryDTO.setStatus(1);
        menuQueryDTO.setTitle("Dr");
        PageVO<MenuDTO> actualQueryMenuResult = this.menuServiceImpl.queryMenu(menuQueryDTO, 5, 3);
        assertEquals(0L, actualQueryMenuResult.getCounts());
        assertFalse(actualQueryMenuResult.isFirst());
        assertFalse(actualQueryMenuResult.hasItems());
        assertEquals(3, actualQueryMenuResult.getPageSize());
        verify(this.resourceMenuMapper).selectByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<MenuDTO>) any(), (MenuQueryDTO) any());
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenu(MenuQueryDTO, Integer, Integer)}
     */
    @Test
    void testQueryMenu7()
    {
        when(this.resourceMenuMapper.selectByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<MenuDTO>) any(), (MenuQueryDTO) any()))
                .thenThrow(new IllegalArgumentException("foo"));

        MenuQueryDTO menuQueryDTO = new MenuQueryDTO();
        menuQueryDTO.setApplicationCode("Application Code");
        menuQueryDTO.setStatus(1);
        menuQueryDTO.setTitle("Dr");
        assertThrows(IllegalArgumentException.class, () -> this.menuServiceImpl.queryMenu(menuQueryDTO, 1, 3));
        verify(this.resourceMenuMapper).selectByPage(
                (com.baomidou.mybatisplus.extension.plugins.pagination.Page<MenuDTO>) any(), (MenuQueryDTO) any());
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenuByPrivileges(String[])}
     */
    @Test
    void testQueryMenuByPrivileges()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any())).thenReturn(objectList);
        List<MenuDTO> actualQueryMenuByPrivilegesResult = this.menuServiceImpl
                .queryMenuByPrivileges(new String[]{"Privileges"});
        assertSame(objectList, actualQueryMenuByPrivilegesResult);
        assertTrue(actualQueryMenuByPrivilegesResult.isEmpty());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenuByPrivileges(String[])}
     */
    @Test
    void testQueryMenuByPrivileges2()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class,
                () -> this.menuServiceImpl.queryMenuByPrivileges(new String[]{"Privileges"}));
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenuByApplicationCode(String)}
     */
    @Test
    void testQueryMenuByApplicationCode()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any())).thenReturn(objectList);
        List<MenuDTO> actualQueryMenuByApplicationCodeResult = this.menuServiceImpl
                .queryMenuByApplicationCode("Application Code");
        assertSame(objectList, actualQueryMenuByApplicationCodeResult);
        assertTrue(actualQueryMenuByApplicationCodeResult.isEmpty());
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
    }

    /**
     * Method under test: {@link MenuServiceImpl#queryMenuByApplicationCode(String)}
     */
    @Test
    void testQueryMenuByApplicationCode2()
    {
        when(this.resourceMenuMapper.selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any()))
                .thenReturn(new ArrayList<>());
        when(this.dozerUtils.mapList((java.util.Collection<Object>) any(), (Class<Object>) any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class,
                () -> this.menuServiceImpl.queryMenuByApplicationCode("Application Code"));
        verify(this.resourceMenuMapper).selectList((com.baomidou.mybatisplus.core.conditions.Wrapper<ResourceMenu>) any());
        verify(this.dozerUtils).mapList((java.util.Collection<Object>) any(), (Class<Object>) any());
    }
}

