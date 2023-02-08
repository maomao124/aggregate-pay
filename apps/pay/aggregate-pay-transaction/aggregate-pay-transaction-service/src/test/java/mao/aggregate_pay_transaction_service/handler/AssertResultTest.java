package mao.aggregate_pay_transaction_service.handler;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import mao.tools_core.base.R;
import mao.tools_core.exception.BizException;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AssertResultTest
{
    /**
     * Method under test: {@link AssertResult#handler(R)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandler()
    {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.util.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        AssertResult.handler(R.success());
    }

    /**
     * Method under test: {@link AssertResult#handler(R)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandler2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: Msg
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:37)
        //       at mao.aggregate_pay_transaction_service.handler.AssertResult.handler(AssertResult.java:33)
        //   In order to prevent handler(R)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handler(R).
        //   See https://diff.blue/R013 to resolve this issue.

        AssertResult.handler(new R<>(1, "Data", "Msg"));
    }

    /**
     * Method under test: {@link AssertResult#handler(R)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandler3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.aggregate_pay_transaction_service.handler.AssertResult.handler(AssertResult.java:30)
        //   In order to prevent handler(R)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handler(R).
        //   See https://diff.blue/R013 to resolve this issue.

        AssertResult.handler(null);
    }

    /**
     * Method under test: {@link AssertResult#handler(R)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testHandler4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   mao.tools_core.exception.BizException: Msg
        //       at mao.tools_core.exception.BizException.wrap(BizException.java:37)
        //       at mao.aggregate_pay_transaction_service.handler.AssertResult.handler(AssertResult.java:33)
        //   In order to prevent handler(R)
        //   from throwing BizException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   handler(R).
        //   See https://diff.blue/R013 to resolve this issue.

        R<Object> r = (R<Object>) mock(R.class);
        when(r.getCode()).thenReturn(1);
        when(r.getMsg()).thenReturn("Msg");
        when(r.getIsError()).thenReturn(true);
        when(r.getData()).thenReturn("Data");
        AssertResult.handler(r);
    }

    /**
     * Method under test: {@link AssertResult#handler(R)}
     */
    @Test
    void testHandler5()
    {
        R<Object> r = (R<Object>) mock(R.class);
        when(r.getCode()).thenThrow(new BizException("An error occurred"));
        when(r.getMsg()).thenThrow(new BizException("An error occurred"));
        when(r.getIsError()).thenReturn(true);
        when(r.getData()).thenReturn("Data");
        assertThrows(BizException.class, () -> AssertResult.handler(r));
        verify(r).getCode();
        verify(r).getIsError();
    }
}

