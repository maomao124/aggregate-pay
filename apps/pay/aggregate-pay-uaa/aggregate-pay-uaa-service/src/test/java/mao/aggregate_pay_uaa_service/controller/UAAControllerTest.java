package mao.aggregate_pay_uaa_service.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.aggregate_pay_uaa_service.service.OauthClientDetailsService;
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

@ContextConfiguration(classes = {UAAController.class})
@ExtendWith(SpringExtension.class)
class UAAControllerTest
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
    private UAAController uAAController;

    /**
     * Method under test: {@link UAAController#checkToken(String)}
     */
    @Test
    void testCheckToken() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/oauth/check_token")
                .param("value", "foo");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.uAAController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    /**
     * Method under test: {@link UAAController#getClientDetailsByClientId(String)}
     */
    @Test
    void testGetClientDetailsByClientId() throws Exception
    {
        when(this.oauthClientDetailsService.getClientDetailsByClientId((String) any())).thenReturn(new HashMap<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/oauth/getClientDetailsByClientId")
                .param("appId", "foo");
        MockMvcBuilders.standaloneSetup(this.uAAController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{}"));
    }

    /**
     * Method under test: {@link UAAController#createClientDetails(java.util.Map)}
     */
    @Test
    void testCreateClientDetails() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/oauth/createClientDetails");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.uAAController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

