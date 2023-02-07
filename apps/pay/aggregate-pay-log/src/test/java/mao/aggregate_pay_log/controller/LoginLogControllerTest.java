package mao.aggregate_pay_log.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_entity.entity.LoginLog;
import mao.aggregate_pay_log.service.LoginLogService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {LoginLogController.class})
@ExtendWith(SpringExtension.class)
class LoginLogControllerTest
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @Autowired
    private LoginLogController loginLogController;

    @MockBean
    private LoginLogService loginLogService;

    /**
     * Method under test: {@link LoginLogController#page()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.aggregate_pay_log.controller.LoginLogController.page(LoginLogController.java:70)
        //   In order to prevent page()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page().
        //   See https://diff.blue/R013 to resolve this issue.

        (new LoginLogController()).page();
    }

    /**
     * Method under test: {@link LoginLogController#get(Long)}
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
        //       at mao.aggregate_pay_log.controller.LoginLogController.get(LoginLogController.java:84)
        //   In order to prevent get(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   get(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new LoginLogController()).get(123L);
    }

    /**
     * Method under test: {@link LoginLogController#save(LoginLog)}
     */
    @Test
    void testSave() throws Exception
    {
        LoginLog loginLog = new LoginLog();
        loginLog.setId(123L);
        loginLog.setLocation("Location");
        loginLog.setLoginDate(LocalDateTime.of(1, 1, 1, 1, 1));
        loginLog.setMobile("Mobile");
        loginLog.setRequestIp("Request Ip");
        loginLog.setTenants("Tenants");
        loginLog.setUserId(123L);
        loginLog.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(loginLog);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/log/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.loginLogController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

