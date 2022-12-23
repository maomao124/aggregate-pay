package mao.sms_manage.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mao.sms_entity.vo.SendLogVO;
import mao.sms_manage.service.ReceiveLogService;
import mao.sms_manage.service.SendLogService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StatisticsController.class})
@ExtendWith(SpringExtension.class)
class StatisticsControllerTest
{
    @MockBean
    private HttpServletRequest httpServletRequest;

    @MockBean
    private HttpServletResponse httpServletResponse;

    @MockBean
    private ReceiveLogService receiveLogService;

    @MockBean
    private SendLogService sendLogService;

    /**
     * Method under test: {@link StatisticsController#countPage(SendLogVO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCountPage()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getPageNo(BaseController.java:230)
        //       at mao.tools_core.base.BaseController.getPage(BaseController.java:251)
        //       at mao.sms_manage.controller.StatisticsController.countPage(StatisticsController.java:72)
        //   In order to prevent countPage(SendLogVO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   countPage(SendLogVO).
        //   See https://diff.blue/R013 to resolve this issue.

        StatisticsController statisticsController = new StatisticsController();
        statisticsController.countPage(new SendLogVO());
    }

    /**
     * Method under test: {@link StatisticsController#count()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCount()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getLocalDateTime(BaseController.java:319)
        //       at mao.tools_core.base.BaseController.getStartCreateTime(BaseController.java:298)
        //       at mao.sms_manage.controller.StatisticsController.count(StatisticsController.java:103)
        //   In order to prevent count()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   count().
        //   See https://diff.blue/R013 to resolve this issue.

        (new StatisticsController()).count();
    }

    /**
     * Method under test: {@link StatisticsController#trend()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTrend()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getLocalDateTime(BaseController.java:319)
        //       at mao.tools_core.base.BaseController.getStartCreateTime(BaseController.java:298)
        //       at mao.sms_manage.controller.StatisticsController.trend(StatisticsController.java:131)
        //   In order to prevent trend()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   trend().
        //   See https://diff.blue/R013 to resolve this issue.

        (new StatisticsController()).trend();
    }

    /**
     * Method under test: {@link StatisticsController#getDays(LocalDateTime, LocalDateTime, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDays()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Illegal pattern character 'o'
        //       at java.text.SimpleDateFormat.compile(SimpleDateFormat.java:826)
        //       at java.text.SimpleDateFormat.initialize(SimpleDateFormat.java:634)
        //       at java.text.SimpleDateFormat.<init>(SimpleDateFormat.java:605)
        //       at java.text.SimpleDateFormat.<init>(SimpleDateFormat.java:580)
        //       at mao.sms_manage.controller.StatisticsController.getDays(StatisticsController.java:187)
        //   In order to prevent getDays(LocalDateTime, LocalDateTime, String)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getDays(LocalDateTime, LocalDateTime, String).
        //   See https://diff.blue/R013 to resolve this issue.

        LocalDateTime startTime = LocalDateTime.of(1, 1, 1, 1, 1);
        StatisticsController.getDays(startTime, LocalDateTime.of(1, 1, 1, 1, 1), "Format");
    }

    /**
     * Method under test: {@link StatisticsController#getDays(LocalDateTime, LocalDateTime, String)}
     */
    @Test
    void testGetDays2()
    {
        LocalDateTime startTime = LocalDateTime.of(1, 1, 1, 1, 1);
        assertTrue(StatisticsController.getDays(startTime, LocalDateTime.of(1, 1, 1, 1, 1), "42").isEmpty());
    }

    /**
     * Method under test: {@link StatisticsController#getDays(LocalDateTime, LocalDateTime, String)}
     */
    @Test
    void testGetDays3()
    {
        LocalDateTime startTime = LocalDateTime.of(0, 1, 1, 1, 1);
        List<String> actualDays = StatisticsController.getDays(startTime, LocalDateTime.of(1, 1, 1, 1, 1), "42");
        assertEquals(366, actualDays.size());
        assertEquals("42", actualDays.get(0));
        assertEquals("42", actualDays.get(1));
        assertEquals("42", actualDays.get(2));
        assertEquals("42", actualDays.get(3));
        assertEquals("42", actualDays.get(4));
        assertEquals("42", actualDays.get(5));
        assertEquals("42", actualDays.get(360));
        assertEquals("42", actualDays.get(361));
        assertEquals("42", actualDays.get(362));
        assertEquals("42", actualDays.get(363));
        assertEquals("42", actualDays.get(364));
        assertEquals("42", actualDays.get(365));
    }

    /**
     * Method under test: {@link StatisticsController#getDays(LocalDateTime, LocalDateTime, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDays4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.controller.StatisticsController.getDays(StatisticsController.java:189)
        //   In order to prevent getDays(LocalDateTime, LocalDateTime, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getDays(LocalDateTime, LocalDateTime, String).
        //   See https://diff.blue/R013 to resolve this issue.

        StatisticsController.getDays(null, LocalDateTime.of(1, 1, 1, 1, 1), "42");
    }

    /**
     * Method under test: {@link StatisticsController#getDays(LocalDateTime, LocalDateTime, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetDays5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.controller.StatisticsController.getDays(StatisticsController.java:190)
        //   In order to prevent getDays(LocalDateTime, LocalDateTime, String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getDays(LocalDateTime, LocalDateTime, String).
        //   See https://diff.blue/R013 to resolve this issue.

        StatisticsController.getDays(LocalDateTime.of(1, 1, 1, 1, 1), null, "42");
    }

    /**
     * Method under test: {@link StatisticsController#countForConfig()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCountForConfig()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getLocalDateTime(BaseController.java:319)
        //       at mao.tools_core.base.BaseController.getStartCreateTime(BaseController.java:298)
        //       at mao.sms_manage.controller.StatisticsController.countForConfig(StatisticsController.java:223)
        //   In order to prevent countForConfig()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   countForConfig().
        //   See https://diff.blue/R013 to resolve this issue.

        (new StatisticsController()).countForConfig();
    }

    /**
     * Method under test: {@link StatisticsController#rateForConfig()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRateForConfig()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getLocalDateTime(BaseController.java:319)
        //       at mao.tools_core.base.BaseController.getStartCreateTime(BaseController.java:298)
        //       at mao.sms_manage.controller.StatisticsController.rateForConfig(StatisticsController.java:252)
        //   In order to prevent rateForConfig()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   rateForConfig().
        //   See https://diff.blue/R013 to resolve this issue.

        (new StatisticsController()).rateForConfig();
    }

    /**
     * Method under test: {@link StatisticsController#top10()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testTop10()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getLocalDateTime(BaseController.java:319)
        //       at mao.tools_core.base.BaseController.getStartCreateTime(BaseController.java:298)
        //       at mao.sms_manage.controller.StatisticsController.top10(StatisticsController.java:285)
        //   In order to prevent top10()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   top10().
        //   See https://diff.blue/R013 to resolve this issue.

        (new StatisticsController()).top10();
    }

    /**
     * Method under test: {@link StatisticsController#marketingTrend()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testMarketingTrend()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.tools_core.base.BaseController.getLocalDateTime(BaseController.java:319)
        //       at mao.tools_core.base.BaseController.getStartCreateTime(BaseController.java:298)
        //       at mao.sms_manage.controller.StatisticsController.marketingTrend(StatisticsController.java:348)
        //   In order to prevent marketingTrend()
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   marketingTrend().
        //   See https://diff.blue/R013 to resolve this issue.

        (new StatisticsController()).marketingTrend();
    }
}

