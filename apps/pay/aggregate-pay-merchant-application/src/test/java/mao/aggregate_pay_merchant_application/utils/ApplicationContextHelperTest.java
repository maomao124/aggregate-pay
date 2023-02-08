package mao.aggregate_pay_merchant_application.utils;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ApplicationContextHelperTest
{
    /**
     * Method under test: default or parameterless constructor of {@link ApplicationContextHelper}
     */
    @Test
    void testConstructor()
    {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ApplicationContextHelper.applicationContext

        new ApplicationContextHelper();
    }

    /**
     * Method under test: {@link ApplicationContextHelper#getBean(Class)}
     */
    @Test
    void testGetBean()
    {
        assertNull(ApplicationContextHelper.getBean(Object.class));
        assertNull(ApplicationContextHelper.getBean("Bean Name"));
    }
}

