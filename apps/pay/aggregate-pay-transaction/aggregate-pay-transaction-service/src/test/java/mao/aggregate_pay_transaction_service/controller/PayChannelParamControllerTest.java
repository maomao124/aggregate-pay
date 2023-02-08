package mao.aggregate_pay_transaction_service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import mao.aggregate_pay_transaction_api.dto.PayChannelParamDTO;
import mao.aggregate_pay_transaction_service.service.PayChannelParamService;
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

@ContextConfiguration(classes = {PayChannelParamController.class})
@ExtendWith(SpringExtension.class)
class PayChannelParamControllerTest
{
    @Autowired
    private PayChannelParamController payChannelParamController;

    @MockBean
    private PayChannelParamService payChannelParamService;

    /**
     * Method under test: {@link PayChannelParamController#queryPayChannelParamByAppAndPlatform(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryPayChannelParamByAppAndPlatform()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayChannelParamController.queryPayChannelParamByAppAndPlatform(PayChannelParamController.java:62)
        //   In order to prevent queryPayChannelParamByAppAndPlatform(String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryPayChannelParamByAppAndPlatform(String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PayChannelParamController()).queryPayChannelParamByAppAndPlatform("42", "Platform Channel");
    }

    /**
     * Method under test: {@link PayChannelParamController#queryParamByAppPlatformAndPayChannel(String, String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryParamByAppPlatformAndPayChannel()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.controller.PayChannelParamController.queryParamByAppPlatformAndPayChannel(PayChannelParamController.java:80)
        //   In order to prevent queryParamByAppPlatformAndPayChannel(String, String, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryParamByAppPlatformAndPayChannel(String, String, String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new PayChannelParamController()).queryParamByAppPlatformAndPayChannel("42", "Platform Channel", "Pay Channel");
    }

    /**
     * Method under test: {@link PayChannelParamController#savePayChannelParam(PayChannelParamDTO)}
     */
    @Test
    void testSavePayChannelParam() throws Exception
    {
        PayChannelParamDTO payChannelParamDTO = new PayChannelParamDTO();
        payChannelParamDTO.setAppId("42");
        payChannelParamDTO.setAppPlatformChannelId(123L);
        payChannelParamDTO.setChannelName("Channel Name");
        payChannelParamDTO.setId(123L);
        payChannelParamDTO.setMerchantId(123L);
        payChannelParamDTO.setParam("Param");
        payChannelParamDTO.setPayChannel("Pay Channel");
        payChannelParamDTO.setPlatformChannelCode("Platform Channel Code");
        String content = (new ObjectMapper()).writeValueAsString(payChannelParamDTO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/PayChannelParam")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.payChannelParamController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(405));
    }
}

