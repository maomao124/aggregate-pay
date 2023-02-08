package mao.aggregate_pay_merchant_application.service.Impl;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import mao.aggregate_pay_entity.entity.OptLog;
import mao.aggregate_pay_merchant_application.feign.log.OptLogFeignClient;
import mao.tools_log.entity.OptLogDTO;
import mao.toolsdozer.utils.DozerUtils;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OptLogServiceImpl.class})
@ExtendWith(SpringExtension.class)
class OptLogServiceImplTest
{
    @MockBean
    private DozerUtils dozerUtils;

    @MockBean
    private OptLogFeignClient optLogFeignClient;

    @Autowired
    private OptLogServiceImpl optLogServiceImpl;

    @MockBean
    private RocketMQTemplate rocketMQTemplate;

    /**
     * Method under test: {@link OptLogServiceImpl#save(OptLogDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.queryMerchantDtoByTenantId(SecurityUtil.java:73)
        //       at mao.aggregate_pay_merchant_application.utils.SecurityUtil.getMerchantIdThrowsException(SecurityUtil.java:124)
        //       at mao.aggregate_pay_merchant_application.service.Impl.OptLogServiceImpl.save(OptLogServiceImpl.java:79)
        //   In order to prevent save(OptLogDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   save(OptLogDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.dozerUtils.map((Object) any(), (Class<OptLog>) any())).thenReturn(new OptLog());
        this.optLogServiceImpl.save(new OptLogDTO());
    }
}

