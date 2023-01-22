package mao.aggregate_pay_uaa_service.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_uaa_service.service.OauthClientDetailsService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UAAControllerV2.class})
@ExtendWith(SpringExtension.class)
class UAAControllerV2Test
{
    @MockBean
    private AccessTokenConverter accessTokenConverter;

    @MockBean
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @MockBean
    private OauthClientDetailsService oauthClientDetailsService;

    @Autowired
    private UAAControllerV2 uAAControllerV2;

    /**
     * Method under test: {@link UAAControllerV2#checkToken(String)}
     */
    @Test
    void testCheckToken() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v2/oauth/check_token")
                .param("value", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.uAAControllerV2)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UAAControllerV2#getClientDetailsByClientId(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetClientDetailsByClientId()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_uaa_service.controller.UAAControllerV2.getClientDetailsByClientId(UAAControllerV2.java:113)
        //   In order to prevent getClientDetailsByClientId(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getClientDetailsByClientId(String).
        //   See https://diff.blue/R013 to resolve this issue.

        (new UAAControllerV2()).getClientDetailsByClientId("42");
    }

    /**
     * Method under test: {@link UAAControllerV2#createClientDetails(java.util.Map)}
     */
    @Test
    void testCreateClientDetails() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/v2/oauth/createClientDetails");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.uAAControllerV2)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

