package mao.aggregate_pay_merchant_application.service.Impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import mao.aggregate_pay_common.domain.RestResponse;
import mao.aggregate_pay_merchant_application.feign.sms.VerificationFeignClient;
import mao.tools_core.exception.BizException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SmsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SmsServiceImplTest
{
    @Autowired
    private SmsServiceImpl smsServiceImpl;

    @MockBean
    private VerificationFeignClient verificationFeignClient;

    /**
     * Method under test: {@link SmsServiceImpl#checkVerifyCode(String, String)}
     */
    @Test
    void testCheckVerifyCode()
    {
        when(this.verificationFeignClient.verify((String) any(), (String) any(), (String) any()))
                .thenReturn(new RestResponse<>(1, "Msg"));
        assertThrows(BizException.class, () -> this.smsServiceImpl.checkVerifyCode("Verify Key", "Verify Code"));
        verify(this.verificationFeignClient).verify((String) any(), (String) any(), (String) any());
    }

    /**
     * Method under test: {@link SmsServiceImpl#checkVerifyCode(String, String)}
     */
    @Test
    void testCheckVerifyCode2()
    {
        RestResponse<Boolean> restResponse = new RestResponse<>(1, "Msg");
        restResponse.setResult(true);
        when(this.verificationFeignClient.verify((String) any(), (String) any(), (String) any())).thenReturn(restResponse);
        this.smsServiceImpl.checkVerifyCode("Verify Key", "Verify Code");
        verify(this.verificationFeignClient).verify((String) any(), (String) any(), (String) any());
    }

    /**
     * Method under test: {@link SmsServiceImpl#checkVerifyCode(String, String)}
     */
    @Test
    void testCheckVerifyCode3()
    {
        when(this.verificationFeignClient.verify((String) any(), (String) any(), (String) any())).thenReturn(null);
        assertThrows(BizException.class, () -> this.smsServiceImpl.checkVerifyCode("Verify Key", "Verify Code"));
        verify(this.verificationFeignClient).verify((String) any(), (String) any(), (String) any());
    }

    /**
     * Method under test: {@link SmsServiceImpl#checkVerifyCode(String, String)}
     */
    @Test
    void testCheckVerifyCode4()
    {
        when(this.verificationFeignClient.verify((String) any(), (String) any(), (String) any()))
                .thenThrow(new BizException("An error occurred"));
        assertThrows(BizException.class, () -> this.smsServiceImpl.checkVerifyCode("Verify Key", "Verify Code"));
        verify(this.verificationFeignClient).verify((String) any(), (String) any(), (String) any());
    }

    /**
     * Method under test: {@link SmsServiceImpl#checkVerifyCode(String, String)}
     */
    @Test
    void testCheckVerifyCode5()
    {
        RestResponse<Boolean> restResponse = new RestResponse<>(1, "Msg");
        restResponse.setResult(false);
        when(this.verificationFeignClient.verify((String) any(), (String) any(), (String) any())).thenReturn(restResponse);
        assertThrows(BizException.class, () -> this.smsServiceImpl.checkVerifyCode("Verify Key", "Verify Code"));
        verify(this.verificationFeignClient).verify((String) any(), (String) any(), (String) any());
    }
}

