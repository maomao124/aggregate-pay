package mao.aggregate_pay_transaction_service.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PageController.class})
@ExtendWith(SpringExtension.class)
class PageControllerTest
{
    @Autowired
    private PageController pageController;

    /**
     * Method under test: {@link PageController#payErrorPage(java.util.Map, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testPayErrorPage() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pay-error-page");
        MockMvcBuilders.standaloneSetup(this.pageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("pay_error"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("pay_error"));
    }

    /**
     * Method under test: {@link PageController#payErrorPage(java.util.Map, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testPayErrorPage2() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pay-error-page", "Uri Vars");
        MockMvcBuilders.standaloneSetup(this.pageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("pay_error"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("pay_error"));
    }

    /**
     * Method under test: {@link PageController#payPage(java.util.Map, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testPayPage() throws Exception
    {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/pay-page");
        MockMvcBuilders.standaloneSetup(this.pageController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("pay"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("pay"));
    }

    /**
     * Method under test: {@link PageController#payPage(java.util.Map, javax.servlet.http.HttpServletRequest)}
     */
    @Test
    void testPayPage2() throws Exception
    {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/pay-page");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.pageController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("pay"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("pay"));
    }
}

