package mao.sms_api.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ExceptionUtilsTest
{
    /**
     * Method under test: {@link ExceptionUtils#getErrorStackTrace(Exception)}
     */
    @Test
    void testGetErrorStackTrace()
    {
        assertEquals("java.lang.Exception: foo\r\n"
                        + "\tat sun.reflect.GeneratedConstructorAccessor18.newInstance(Unknown Source)\r\n"
                        + "\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)"
                        + "\r\n" + "\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n"
                        + "\tat com.diffblue.tir.a.f.a(SourceFile:75)\r\n" + "\tat com.diffblue.tir.a.a.c.a(SourceFile:599)\r\n"
                        + "\tat com.diffblue.tir.a.a.c.a(SourceFile:531)\r\n" + "\tat com.diffblue.tir.a.d.b(SourceFile:425)\r\n"
                        + "\tat com.diffblue.tir.a.d.a(SourceFile:77)\r\n" + "\tat com.diffblue.tir.d.c.a(SourceFile:25)\r\n"
                        + "\tat com.diffblue.tir.a.e.a(SourceFile:221)\r\n" + "\tat com.diffblue.tir.a.e.b(SourceFile:85)\r\n"
                        + "\tat com.diffblue.cover.sandbox.execution.TimedCallableExecutor$CallableFuture.executeTask(SourceFile:27)"
                        + "\r\n" + "\tat com.diffblue.cover.sandbox.execution.TimedExecutor$TaskQueueRunner.run(SourceFile:66)\r\n"
                        + "\tat com.diffblue.cover.sandbox.execution.WorkerThread.run(SourceFile:207)\r\n",
                ExceptionUtils.getErrorStackTrace(new Exception("foo")));
    }

    /**
     * Method under test: {@link ExceptionUtils#getErrorStackTrace(Exception)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetErrorStackTrace2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_api.utils.ExceptionUtils.getErrorStackTrace(ExceptionUtils.java:36)
        //   In order to prevent getErrorStackTrace(Exception)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getErrorStackTrace(Exception).
        //   See https://diff.blue/R013 to resolve this issue.

        ExceptionUtils.getErrorStackTrace(null);
    }
}

