package mao.aggregate_pay_merchant_application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import mao.aggregate_pay_common.domain.RestResponse;
import mao.aggregate_pay_entity.dto.VerificationInfo;
import mao.aggregate_pay_merchant_api.feign.MerchantFeignClient;
import mao.aggregate_pay_merchant_application.feign.sms.VerificationFeignClient;
import mao.aggregate_pay_merchant_application.service.FileService;
import mao.aggregate_pay_merchant_application.service.SmsService;
import mao.aggregate_pay_merchant_application.vo.MerchantDetailVO;
import mao.aggregate_pay_merchant_application.vo.MerchantRegisterVO;
import mao.tools_core.base.R;
import mao.toolsdozer.utils.DozerUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MerchantController.class})
@ExtendWith(SpringExtension.class)
class MerchantControllerTest
{
    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private FileService fileService;

    @Autowired
    private MerchantController merchantController;

    @MockBean
    private MerchantFeignClient merchantFeignClient;

    @MockBean
    private SmsService smsService;

    @MockBean
    private VerificationFeignClient verificationFeignClient;

    /**
     * Method under test: {@link MerchantController#upload(org.springframework.web.multipart.MultipartFile)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpload() throws IOException
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.controller.MerchantController.upload(MerchantController.java:172)
        //   In order to prevent upload(MultipartFile)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   upload(MultipartFile).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantController merchantController = new MerchantController();
        merchantController.upload(new MockMultipartFile("Name", new ByteArrayInputStream("AAAAAAAA".getBytes("UTF-8"))));
    }

    /**
     * Method under test: {@link MerchantController#saveMerchant(MerchantDetailVO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveMerchant()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantId(SecurityUtil.java:105)
        //       at mao.aggregate_pay_merchant_application.controller.MerchantController.saveMerchant(MerchantController.java:192)
        //   In order to prevent saveMerchant(MerchantDetailVO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveMerchant(MerchantDetailVO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantController merchantController = new MerchantController();

        MerchantDetailVO merchantDetailVO = new MerchantDetailVO();
        merchantDetailVO.setBusinessLicensesImg("Business Licenses Img");
        merchantDetailVO.setContactsAddress("42 Main St");
        merchantDetailVO.setIdCardAfterImg("Id Card After Img");
        merchantDetailVO.setIdCardFrontImg("Id Card Front Img");
        merchantDetailVO.setMerchantAddress("42 Main St");
        merchantDetailVO.setMerchantName("Merchant Name");
        merchantDetailVO.setMerchantNo("Merchant No");
        merchantDetailVO.setMerchantType("Merchant Type");
        merchantDetailVO.setUsername("janedoe");
        merchantController.saveMerchant(merchantDetailVO);
    }

    /**
     * Method under test: {@link MerchantController#saveMerchant(MerchantDetailVO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveMerchant2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantId(SecurityUtil.java:105)
        //       at mao.aggregate_pay_merchant_application.controller.MerchantController.saveMerchant(MerchantController.java:192)
        //   In order to prevent saveMerchant(MerchantDetailVO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveMerchant(MerchantDetailVO).
        //   See https://diff.blue/R013 to resolve this issue.

        MerchantController merchantController = new MerchantController();
        MerchantDetailVO merchantDetailVO = mock(MerchantDetailVO.class);
        doNothing().when(merchantDetailVO).setBusinessLicensesImg((String) any());
        doNothing().when(merchantDetailVO).setContactsAddress((String) any());
        doNothing().when(merchantDetailVO).setIdCardAfterImg((String) any());
        doNothing().when(merchantDetailVO).setIdCardFrontImg((String) any());
        doNothing().when(merchantDetailVO).setMerchantAddress((String) any());
        doNothing().when(merchantDetailVO).setMerchantName((String) any());
        doNothing().when(merchantDetailVO).setMerchantNo((String) any());
        doNothing().when(merchantDetailVO).setMerchantType((String) any());
        doNothing().when(merchantDetailVO).setUsername((String) any());
        merchantDetailVO.setBusinessLicensesImg("Business Licenses Img");
        merchantDetailVO.setContactsAddress("42 Main St");
        merchantDetailVO.setIdCardAfterImg("Id Card After Img");
        merchantDetailVO.setIdCardFrontImg("Id Card Front Img");
        merchantDetailVO.setMerchantAddress("42 Main St");
        merchantDetailVO.setMerchantName("Merchant Name");
        merchantDetailVO.setMerchantNo("Merchant No");
        merchantDetailVO.setMerchantType("Merchant Type");
        merchantDetailVO.setUsername("janedoe");
        merchantController.saveMerchant(merchantDetailVO);
    }

    /**
     * Method under test: {@link MerchantController#getMyMerchantInfo()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMyMerchantInfo()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchant(SecurityUtil.java:145)
        //       at mao.aggregate_pay_merchant_application.controller.MerchantController.getMyMerchantInfo(MerchantController.java:211)
        //   In order to prevent getMyMerchantInfo()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMyMerchantInfo().
        //   See https://diff.blue/R013 to resolve this issue.

        (new MerchantController()).getMyMerchantInfo();
    }

    /**
     * Method under test: {@link MerchantController#transactions(String, String)}
     */
    @Test
    void testTransactions()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R015 Method may be nondeterministic.
        //   Diffblue Cover tried to run the created test twice, but it first passed the
        //   assertions and then failed.
        //   See https://diff.blue/R015 to resolve this issue.

        R<String> actualTransactionsResult = (new MerchantController()).transactions("Start Time", "End Time");
        assertEquals(-10, actualTransactionsResult.getCode());
        assertEquals("功能未实现", actualTransactionsResult.getMsg());
        assertNull(actualTransactionsResult.getData());
    }

    /**
     * Method under test: {@link MerchantController#transactionsApp()}
     */
    @Test
    void testTransactionsApp()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R015 Method may be nondeterministic.
        //   Diffblue Cover tried to run the created test twice, but it first passed the
        //   assertions and then failed.
        //   See https://diff.blue/R015 to resolve this issue.

        R<String> actualTransactionsAppResult = (new MerchantController()).transactionsApp();
        assertEquals(-10, actualTransactionsAppResult.getCode());
        assertEquals("功能未实现", actualTransactionsAppResult.getMsg());
        assertNull(actualTransactionsAppResult.getData());
    }

    /**
     * Method under test: {@link MerchantController#transactionsChannels()}
     */
    @Test
    void testTransactionsChannels()
    {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R015 Method may be nondeterministic.
        //   Diffblue Cover tried to run the created test twice, but it first passed the
        //   assertions and then failed.
        //   See https://diff.blue/R015 to resolve this issue.

        R<String> actualTransactionsChannelsResult = (new MerchantController()).transactionsChannels();
        assertEquals(-10, actualTransactionsChannelsResult.getCode());
        assertEquals("功能未实现", actualTransactionsChannelsResult.getMsg());
        assertNull(actualTransactionsChannelsResult.getData());
    }

    /**
     * Method under test: {@link MerchantController#getSMSCode(String)}
     */
    @Test
    void testGetSMSCode() throws Exception
    {
        RestResponse<VerificationInfo> restResponse = new RestResponse<>(1, "Msg");
        restResponse.setResult(new VerificationInfo("?", "Not all who wander are lost"));
        when(this.verificationFeignClient.generateVerificationInfo((String) any(), (java.util.Map<String, Object>) any(),
                anyInt())).thenReturn(restResponse);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/sms").param("phone", "13499999999");
        MockMvcBuilders.standaloneSetup(this.merchantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("?"));
    }

    /**
     * Method under test: {@link MerchantController#registerMerchant(MerchantRegisterVO)}
     */
    @Test
    void testRegisterMerchant() throws Exception
    {
        doNothing().when(this.smsService).checkVerifyCode((String) any(), (String) any());
        //when(this.merchantFeignClient.createMerchant((mao.aggregate_pay_merchant_api.dto.MerchantDTO) any())).thenReturn(R.success());

        MerchantRegisterVO merchantRegisterVO = new MerchantRegisterVO();
        merchantRegisterVO.setMobile("13499999999");
        merchantRegisterVO.setPassword("iloveyou");
        merchantRegisterVO.setUsername("janedoe");
        merchantRegisterVO.setVerifiyCode("Verifiy Code");
        merchantRegisterVO.setVerifiykey("Verifiykey");
        String content = (new ObjectMapper()).writeValueAsString(merchantRegisterVO);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/merchants/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.merchantController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"mobile\":\"13499999999\",\"username\":\"janedoe\",\"password\":\"iloveyou\",\"verifiykey\":\"Verifiykey\",\"verifiyCode"
                                        + "\":\"Verifiy Code\"}"));
    }
}

