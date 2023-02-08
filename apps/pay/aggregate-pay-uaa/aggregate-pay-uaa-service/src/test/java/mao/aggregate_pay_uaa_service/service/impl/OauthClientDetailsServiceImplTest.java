package mao.aggregate_pay_uaa_service.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import mao.aggregate_pay_uaa_service.domain.OauthClientDetails;

import mao.aggregate_pay_uaa_service.repository.OauthRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OauthClientDetailsServiceImpl.class})
@ExtendWith(SpringExtension.class)
class OauthClientDetailsServiceImplTest
{
    @Autowired
    private OauthClientDetailsServiceImpl oauthClientDetailsServiceImpl;

    @MockBean
    private OauthRepository oauthRepository;

    /**
     * Method under test: {@link OauthClientDetailsServiceImpl#createClientDetails(java.util.Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateClientDetails()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_uaa_service.service.impl.OauthClientDetailsServiceImpl.createClientDetails(OauthClientDetailsServiceImpl.java:43)
        //   In order to prevent createClientDetails(Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createClientDetails(Map).
        //   See https://diff.blue/R013 to resolve this issue.

        this.oauthClientDetailsServiceImpl.createClientDetails(new HashMap<>());
    }

    /**
     * Method under test: {@link OauthClientDetailsServiceImpl#getClientDetailsByClientId(String)}
     */
    @Test
    void testGetClientDetailsByClientId()
    {
        when(this.oauthRepository.findOauthClientDetails((String) any())).thenReturn(new OauthClientDetails());
        Map<String, String> actualClientDetailsByClientId = this.oauthClientDetailsServiceImpl
                .getClientDetailsByClientId("42");
        assertEquals(2, actualClientDetailsByClientId.size());
        assertNull(actualClientDetailsByClientId.get("client_secret"));
        assertNull(actualClientDetailsByClientId.get("client_id"));
        verify(this.oauthRepository).findOauthClientDetails((String) any());
    }
}

