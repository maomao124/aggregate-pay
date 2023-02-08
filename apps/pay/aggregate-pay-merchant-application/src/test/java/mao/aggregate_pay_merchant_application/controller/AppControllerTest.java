package mao.aggregate_pay_merchant_application.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import mao.aggregate_pay_merchant_api.dto.AppDTO;
import mao.aggregate_pay_merchant_api.feign.AppFeignClient;
import mao.aggregate_pay_transaction_api.feign.PlatformChannelFeignClient;
import mao.tools_core.base.R;
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

@ContextConfiguration(classes = {AppController.class})
@ExtendWith(SpringExtension.class)
class AppControllerTest
{
    @Autowired
    private AppController appController;

    @MockBean
    private AppFeignClient appFeignClient;

    @MockBean
    private PlatformChannelFeignClient platformChannelFeignClient;

    /**
     * Method under test: {@link AppController#queryMyApps()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testQueryMyApps()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantId(SecurityUtil.java:105)
        //       at mao.aggregate_pay_merchant_application.controller.AppController.queryMyApps(AppController.java:92)
        //   In order to prevent queryMyApps()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   queryMyApps().
        //   See https://diff.blue/R013 to resolve this issue.

        (new AppController()).queryMyApps();
    }

    /**
     * Method under test: {@link AppController#bindPlatformForApp(String, String)}
     */
    @Test
    void testBindPlatformForApp() throws Exception
    {
        when(this.platformChannelFeignClient.bindPlatformChannelForApp((String) any(), (String) any()))
                .thenReturn(R.success());
        //when(this.appFeignClient.getAppById((String) any())).thenReturn(R.success());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/my/apps/{appId}/platform-channels", "42")
                .param("platformChannelCodes", "foo");
        MockMvcBuilders.standaloneSetup(this.appController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link AppController#getApp(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetApp()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.controller.AppController.getApp(AppController.java:113)
        //   In order to prevent getApp(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getApp(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new AppController()).getApp("42");
    }

    /**
     * Method under test: {@link AppController#queryAppBindPlatformChannel(String, String)}
     */
    @Test
    void testQueryAppBindPlatformChannel() throws Exception
    {
        when(this.platformChannelFeignClient.queryAppBindPlatformChannel((String) any(), (String) any()))
                .thenReturn(R.success());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/my/merchants/apps/platformchannels")
                .param("appId", "foo")
                .param("platformChannel", "foo");
        MockMvcBuilders.standaloneSetup(this.appController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("1"));
    }

    /**
     * Method under test: {@link AppController#createApp(AppDTO)}
     */
    @Test
    void testCreateApp() throws Exception
    {
        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/my/apps");
        postResult.characterEncoding("Encoding");

        AppDTO appDTO = new AppDTO();
        appDTO.setAppId("42");
        appDTO.setAppName("App Name");
        appDTO.setMerchantId(123L);
        appDTO.setNotifyUrl("https://example.org/example");
        appDTO.setPublicKey("Public Key");
        String content = (new ObjectMapper()).writeValueAsString(appDTO);
        MockHttpServletRequestBuilder requestBuilder = postResult.contentType(MediaType.APPLICATION_JSON).content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.appController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(415));
    }
}

