package mao.aggregate_pay_log.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_entity.entity.LogType;
import mao.aggregate_pay_entity.entity.OptLog;

import mao.aggregate_pay_log.service.OptLogService;
import mao.tools_common.enums.HttpMethod;
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

@ContextConfiguration(classes = {OptLogController.class})
@ExtendWith(SpringExtension.class)
class OptLogControllerTest
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @Autowired
    private OptLogController optLogController;

    @MockBean
    private OptLogService optLogService;

    /**
     * Method under test: {@link OptLogController#page()}
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
        //       at mao.aggregate_pay_log.controller.OptLogController.page(OptLogController.java:72)
        //   In order to prevent page()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page().
        //   See https://diff.blue/R013 to resolve this issue.

        (new OptLogController()).page();
    }

    /**
     * Method under test: {@link OptLogController#page(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPage2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.aggregate_pay_log.controller.OptLogController.page(OptLogController.java:96)
        //   In order to prevent page(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new OptLogController()).page(123L);
    }

    /**
     * Method under test: {@link OptLogController#page(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPage3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.aggregate_pay_log.controller.OptLogController.page(OptLogController.java:94)
        //   In order to prevent page(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new OptLogController()).page(null);
    }

    /**
     * Method under test: {@link OptLogController#page(Long)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPage4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.aggregate_pay_log.controller.OptLogController.page(OptLogController.java:94)
        //   In order to prevent page(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   page(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new OptLogController()).page(-1L);
    }

    /**
     * Method under test: {@link OptLogController#get(Long)}
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
        //       at mao.aggregate_pay_log.controller.OptLogController.get(OptLogController.java:137)
        //   In order to prevent get(Long)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   get(Long).
        //   See https://diff.blue/R013 to resolve this issue.

        (new OptLogController()).get(123L);
    }

    /**
     * Method under test: {@link OptLogController#page2(Long)}
     */
    @Test
    void testPage22() throws Exception
    {
        when(this.httpServletRequest.getParameter((String) any())).thenReturn("Parameter");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/log/opt/page2/{merchantId}", "Uri Vars",
                "Uri Vars");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.optLogController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link OptLogController#save(OptLog)}
     */
    @Test
    void testSave() throws Exception
    {
        OptLog optLog = new OptLog();
        optLog.setActionMethod("Action Method");
        optLog.setClassPath("Class Path");
        optLog.setConsumingTime(1L);
        optLog.setDescription("The characteristics of someone or something");
        optLog.setExDesc("Ex Desc");
        optLog.setExDetail("Ex Detail");
        optLog.setFinishTime(LocalDateTime.of(1, 1, 1, 1, 1));
        optLog.setHttpMethod(HttpMethod.GET);
        optLog.setId(123L);
        optLog.setParams("Params");
        optLog.setRequestIp("Request Ip");
        optLog.setRequestUri("Request Uri");
        optLog.setResult("Result");
        optLog.setStartTime(LocalDateTime.of(1, 1, 1, 1, 1));
        optLog.setType(LogType.OPT);
        optLog.setUa("Ua");
        optLog.setUserName(1L);
        String content = (new ObjectMapper()).writeValueAsString(optLog);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/log/opt")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.optLogController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

