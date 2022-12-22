package mao.sms_manage.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import mao.sms_entity.vo.ReceiveLogVO;
import mao.sms_entity.vo.SendLogPageVO;
import mao.sms_entity.vo.SendLogVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class LogControllerTest
{
    /**
     * Method under test: {@link LogController#sendPage(SendLogVO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendPage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.LogController.sendPage(LogController.java:78)
        //   In order to prevent sendPage(SendLogVO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   sendPage(SendLogVO).
        //   See https://diff.blue/R013 to resolve this issue.

        LogController logController = new LogController();
        logController.sendPage(new SendLogVO());
    }

    /**
     * Method under test: {@link LogController#receivePage(ReceiveLogVO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testReceivePage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.LogController.receivePage(LogController.java:116)
        //   In order to prevent receivePage(ReceiveLogVO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   receivePage(ReceiveLogVO).
        //   See https://diff.blue/R013 to resolve this issue.

        LogController logController = new LogController();

        ReceiveLogVO receiveLogVO = new ReceiveLogVO();
        receiveLogVO.setApiLogId("42");
        receiveLogVO.setBusiness("Business");
        receiveLogVO.setConfigIds("Config Ids");
        receiveLogVO.setConfigName("Config Name");
        receiveLogVO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        receiveLogVO.setCreateUser("Create User");
        receiveLogVO.setError("An error occurred");
        receiveLogVO.setId("42");
        receiveLogVO.setIsDelete(1);
        receiveLogVO.setMobile("Mobile");
        receiveLogVO.setPlatformId("42");
        receiveLogVO.setPlatformName("Platform Name");
        receiveLogVO.setRemark("Remark");
        receiveLogVO.setRequest("Request");
        receiveLogVO.setSignature("Signature");
        receiveLogVO.setSignatureName("Signature Name");
        receiveLogVO.setStatus(1);
        receiveLogVO.setTemplate("Template");
        receiveLogVO.setTemplateName("Template Name");
        receiveLogVO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        receiveLogVO.setUpdateUser("2020-03-01");
        receiveLogVO.setUseTime(1L);
        logController.receivePage(receiveLogVO);
    }

    /**
     * Method under test: {@link LogController#receivePage(ReceiveLogVO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testReceivePage2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.LogController.receivePage(LogController.java:116)
        //   In order to prevent receivePage(ReceiveLogVO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   receivePage(ReceiveLogVO).
        //   See https://diff.blue/R013 to resolve this issue.

        LogController logController = new LogController();
        ReceiveLogVO receiveLogVO = mock(ReceiveLogVO.class);
        doNothing().when(receiveLogVO).setApiLogId((String) any());
        doNothing().when(receiveLogVO).setBusiness((String) any());
        doNothing().when(receiveLogVO).setConfigIds((String) any());
        doNothing().when(receiveLogVO).setError((String) any());
        doNothing().when(receiveLogVO).setMobile((String) any());
        doNothing().when(receiveLogVO).setPlatformId((String) any());
        doNothing().when(receiveLogVO).setPlatformName((String) any());
        doNothing().when(receiveLogVO).setRemark((String) any());
        doNothing().when(receiveLogVO).setRequest((String) any());
        doNothing().when(receiveLogVO).setSignature((String) any());
        doNothing().when(receiveLogVO).setStatus(anyInt());
        doNothing().when(receiveLogVO).setTemplate((String) any());
        doNothing().when(receiveLogVO).setUseTime((Long) any());
        doNothing().when(receiveLogVO).setCreateTime((LocalDateTime) any());
        doNothing().when(receiveLogVO).setCreateUser((String) any());
        doNothing().when(receiveLogVO).setId((String) any());
        doNothing().when(receiveLogVO).setIsDelete((Integer) any());
        doNothing().when(receiveLogVO).setUpdateTime((LocalDateTime) any());
        doNothing().when(receiveLogVO).setUpdateUser((String) any());
        doNothing().when(receiveLogVO).setConfigName((String) any());
        doNothing().when(receiveLogVO).setSignatureName((String) any());
        doNothing().when(receiveLogVO).setTemplateName((String) any());
        receiveLogVO.setApiLogId("42");
        receiveLogVO.setBusiness("Business");
        receiveLogVO.setConfigIds("Config Ids");
        receiveLogVO.setConfigName("Config Name");
        receiveLogVO.setCreateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        receiveLogVO.setCreateUser("Create User");
        receiveLogVO.setError("An error occurred");
        receiveLogVO.setId("42");
        receiveLogVO.setIsDelete(1);
        receiveLogVO.setMobile("Mobile");
        receiveLogVO.setPlatformId("42");
        receiveLogVO.setPlatformName("Platform Name");
        receiveLogVO.setRemark("Remark");
        receiveLogVO.setRequest("Request");
        receiveLogVO.setSignature("Signature");
        receiveLogVO.setSignatureName("Signature Name");
        receiveLogVO.setStatus(1);
        receiveLogVO.setTemplate("Template");
        receiveLogVO.setTemplateName("Template Name");
        receiveLogVO.setUpdateTime(LocalDateTime.of(1, 1, 1, 1, 1));
        receiveLogVO.setUpdateUser("2020-03-01");
        receiveLogVO.setUseTime(1L);
        logController.receivePage(receiveLogVO);
    }

    /**
     * Method under test: {@link LogController#get(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGet()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.controller.LogController.get(LogController.java:144)
        //   In order to prevent get(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   get(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new LogController()).get(123L);
    }

    /**
     * Method under test: {@link LogController#sendLogPage(SendLogPageVO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendLogPage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.LogController.sendLogPage(LogController.java:167)
        //   In order to prevent sendLogPage(SendLogPageVO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   sendLogPage(SendLogPageVO).
        //   See https://diff.blue/R013 to resolve this issue.

        LogController logController = new LogController();
        logController.sendLogPage(new SendLogPageVO());
    }
}

