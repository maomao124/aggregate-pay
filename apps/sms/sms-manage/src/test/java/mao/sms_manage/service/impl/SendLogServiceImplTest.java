package mao.sms_manage.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mao.sms_entity.vo.MarketingStatisticsCountVO;
import mao.sms_entity.vo.SendLogPageVO;
import mao.sms_entity.vo.SendLogVO;

import mao.sms_entity.vo.StatisticsCountVO;

import mao.sms_dao.mapper.SendLogMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ContextConfiguration(classes = {SendLogServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SendLogServiceImplTest
{
    @MockBean
    private SendLogMapper sendLogMapper;

    @Autowired
    private SendLogServiceImpl sendLogServiceImpl;

    /**
     * Method under test: {@link SendLogServiceImpl#pageLog(Page, java.util.Map)}
     */
    @Test
    void testPageLog()
    {
        when(this.sendLogMapper.selectLogPage((Page<SendLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn(new Page<>());
        Page<SendLogVO> page = new Page<>();
        Page<SendLogVO> actualPageLogResult = this.sendLogServiceImpl.pageLog(page, new HashMap<>());
        assertSame(page, actualPageLogResult);
        assertTrue(actualPageLogResult.getRecords().isEmpty());
        verify(this.sendLogMapper).selectLogPage((Page<SendLogVO>) any(), (java.util.Map<String, Object>) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#pageLog(Page, java.util.Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPageLog2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.SendLogServiceImpl.pageLog(SendLogServiceImpl.java:46)
        //   In order to prevent pageLog(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pageLog(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.sendLogMapper.selectLogPage((Page<SendLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn(null);
        Page<SendLogVO> page = new Page<>();
        this.sendLogServiceImpl.pageLog(page, new HashMap<>());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#pageLog(Page, java.util.Map)}
     */
    @Test
    void testPageLog3()
    {
        IPage<SendLogVO> iPage = (IPage<SendLogVO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.sendLogMapper.selectLogPage((Page<SendLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn(iPage);
        Page<SendLogVO> page = new Page<>();
        Page<SendLogVO> actualPageLogResult = this.sendLogServiceImpl.pageLog(page, new HashMap<>());
        assertSame(page, actualPageLogResult);
        assertTrue(actualPageLogResult.getRecords().isEmpty());
        verify(this.sendLogMapper).selectLogPage((Page<SendLogVO>) any(), (java.util.Map<String, Object>) any());
        verify(iPage).getRecords();
    }

    /**
     * Method under test: {@link SendLogServiceImpl#pageLog(Page, java.util.Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPageLog4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.SendLogServiceImpl.pageLog(SendLogServiceImpl.java:46)
        //   In order to prevent pageLog(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pageLog(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.sendLogMapper.selectLogPage((Page<SendLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn((IPage<SendLogVO>) mock(IPage.class));
        this.sendLogServiceImpl.pageLog(null, new HashMap<>());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#pageLog(Page, java.util.Map)}
     */
    @Test
    void testPageLog5()
    {
        IPage<SendLogVO> iPage = (IPage<SendLogVO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.sendLogMapper.selectLogPage((Page<SendLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn(iPage);
        Page<SendLogVO> page = (Page<SendLogVO>) mock(Page.class);
        when(page.setRecords((List<SendLogVO>) any())).thenReturn(new Page<>());
        this.sendLogServiceImpl.pageLog(page, new HashMap<>());
        verify(this.sendLogMapper).selectLogPage((Page<SendLogVO>) any(), (java.util.Map<String, Object>) any());
        verify(iPage).getRecords();
        verify(page).setRecords((List<SendLogVO>) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#trend(java.util.Map)}
     */
    @Test
    void testTrend()
    {
        ArrayList<StatisticsCountVO> statisticsCountVOList = new ArrayList<>();
        when(this.sendLogMapper.trend((java.util.Map<?, ?>) any())).thenReturn(statisticsCountVOList);
        List<StatisticsCountVO> actualTrendResult = this.sendLogServiceImpl.trend(new HashMap<>());
        assertSame(statisticsCountVOList, actualTrendResult);
        assertTrue(actualTrendResult.isEmpty());
        verify(this.sendLogMapper).trend((java.util.Map<?, ?>) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#countPage(Page, java.util.Map)}
     */
    @Test
    void testCountPage()
    {
        when(this.sendLogMapper.countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any()))
                .thenReturn(new Page<>());
        Page<StatisticsCountVO> page = new Page<>();
        Page<StatisticsCountVO> actualCountPageResult = this.sendLogServiceImpl.countPage(page, new HashMap<>());
        assertSame(page, actualCountPageResult);
        assertTrue(actualCountPageResult.getRecords().isEmpty());
        verify(this.sendLogMapper).countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#countPage(Page, java.util.Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCountPage2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.SendLogServiceImpl.countPage(SendLogServiceImpl.java:60)
        //   In order to prevent countPage(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   countPage(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.sendLogMapper.countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any())).thenReturn(null);
        Page<StatisticsCountVO> page = new Page<>();
        this.sendLogServiceImpl.countPage(page, new HashMap<>());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#countPage(Page, java.util.Map)}
     */
    @Test
    void testCountPage3()
    {
        IPage<StatisticsCountVO> iPage = (IPage<StatisticsCountVO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.sendLogMapper.countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any())).thenReturn(iPage);
        Page<StatisticsCountVO> page = new Page<>();
        Page<StatisticsCountVO> actualCountPageResult = this.sendLogServiceImpl.countPage(page, new HashMap<>());
        assertSame(page, actualCountPageResult);
        assertTrue(actualCountPageResult.getRecords().isEmpty());
        verify(this.sendLogMapper).countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any());
        verify(iPage, atLeast(1)).getRecords();
    }

    /**
     * Method under test: {@link SendLogServiceImpl#countPage(Page, java.util.Map)}
     */
    @Test
    void testCountPage4()
    {
        ArrayList<StatisticsCountVO> statisticsCountVOList = new ArrayList<>();
        statisticsCountVOList.add(new StatisticsCountVO(3, 1, 1, "2020-03-01", "Success Rate"));
        IPage<StatisticsCountVO> iPage = (IPage<StatisticsCountVO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(statisticsCountVOList);
        when(this.sendLogMapper.countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any())).thenReturn(iPage);
        Page<StatisticsCountVO> page = new Page<>();
        Page<StatisticsCountVO> actualCountPageResult = this.sendLogServiceImpl.countPage(page, new HashMap<>());
        assertSame(page, actualCountPageResult);
        List<StatisticsCountVO> records = actualCountPageResult.getRecords();
        assertEquals(1, records.size());
        StatisticsCountVO getResult = records.get(0);
        assertEquals("33.33", getResult.getSuccessRate());
        assertEquals(2, getResult.getFail());
        verify(this.sendLogMapper).countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any());
        verify(iPage, atLeast(1)).getRecords();
    }

    /**
     * Method under test: {@link SendLogServiceImpl#countPage(Page, java.util.Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCountPage5()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.SendLogServiceImpl.countPage(SendLogServiceImpl.java:71)
        //   In order to prevent countPage(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   countPage(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.sendLogMapper.countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any()))
                .thenReturn((IPage<StatisticsCountVO>) mock(IPage.class));
        this.sendLogServiceImpl.countPage(null, new HashMap<>());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#countPage(Page, java.util.Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCountPage6()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.SendLogServiceImpl.countPage(SendLogServiceImpl.java:71)
        //   In order to prevent countPage(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   countPage(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.sendLogMapper.countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any()))
                .thenReturn((IPage<StatisticsCountVO>) mock(IPage.class));
        this.sendLogServiceImpl.countPage(null, new HashMap<>());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#countPage(Page, java.util.Map)}
     */
    @Test
    void testCountPage7()
    {
        IPage<StatisticsCountVO> iPage = (IPage<StatisticsCountVO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.sendLogMapper.countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any())).thenReturn(iPage);
        Page<StatisticsCountVO> page = (Page<StatisticsCountVO>) mock(Page.class);
        when(page.setRecords((List<StatisticsCountVO>) any())).thenReturn(new Page<>());
        this.sendLogServiceImpl.countPage(page, new HashMap<>());
        verify(this.sendLogMapper).countPage((Page<StatisticsCountVO>) any(), (java.util.Map<?, ?>) any());
        verify(iPage, atLeast(1)).getRecords();
        verify(page).setRecords((List<StatisticsCountVO>) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#countForConfig(Map)}
     */
    @Test
    void testCountForConfig()
    {
        ArrayList<Map<?, ?>> mapList = new ArrayList<>();
        when(this.sendLogMapper.countForConfig((Map<?, ?>) any())).thenReturn(mapList);
        List<Map<?, ?>> actualCountForConfigResult = this.sendLogServiceImpl.countForConfig(new HashMap<>());
        assertSame(mapList, actualCountForConfigResult);
        assertTrue(actualCountForConfigResult.isEmpty());
        verify(this.sendLogMapper).countForConfig((Map<?, ?>) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#rateForConfig(Map)}
     */
    @Test
    void testRateForConfig()
    {
        ArrayList<Map<?, ?>> mapList = new ArrayList<>();
        when(this.sendLogMapper.countForConfig((Map<?, ?>) any())).thenReturn(mapList);
        List<Map<?, ?>> actualRateForConfigResult = this.sendLogServiceImpl.rateForConfig(new HashMap<>());
        assertSame(mapList, actualRateForConfigResult);
        assertTrue(actualRateForConfigResult.isEmpty());
        verify(this.sendLogMapper).countForConfig((Map<?, ?>) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#rateForConfig(Map)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testRateForConfig2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.SendLogServiceImpl.rateForConfig(SendLogServiceImpl.java:87)
        //   In order to prevent rateForConfig(Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   rateForConfig(Map).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<Map<?, ?>> mapList = new ArrayList<>();
        mapList.add(new HashMap<>());
        when(this.sendLogMapper.countForConfig((Map<?, ?>) any())).thenReturn(mapList);
        this.sendLogServiceImpl.rateForConfig(new HashMap<>());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#getMarketingCountByBusinessId(String)}
     */
    @Test
    void testGetMarketingCountByBusinessId()
    {
        MarketingStatisticsCountVO marketingStatisticsCountVO = new MarketingStatisticsCountVO("42", 3, 1, 1, "2020-03-01",
                "Success Rate", "Dr", "Signature Name");

        when(this.sendLogMapper.getMarketingCount((java.util.Map<?, ?>) any())).thenReturn(marketingStatisticsCountVO);
        MarketingStatisticsCountVO actualMarketingCountByBusinessId = this.sendLogServiceImpl
                .getMarketingCountByBusinessId("42");
        assertSame(marketingStatisticsCountVO, actualMarketingCountByBusinessId);
        assertEquals("33.33", actualMarketingCountByBusinessId.getSuccessRate());
        assertEquals(2, actualMarketingCountByBusinessId.getFail());
        verify(this.sendLogMapper).getMarketingCount((java.util.Map<?, ?>) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#getMarketingCountByBusinessId(String)}
     */
    @Test
    void testGetMarketingCountByBusinessId2()
    {
        MarketingStatisticsCountVO marketingStatisticsCountVO = new MarketingStatisticsCountVO("42", 0, 1, 1, "2020-03-01",
                "Success Rate", "Dr", "Signature Name");

        when(this.sendLogMapper.getMarketingCount((java.util.Map<?, ?>) any())).thenReturn(marketingStatisticsCountVO);
        MarketingStatisticsCountVO actualMarketingCountByBusinessId = this.sendLogServiceImpl
                .getMarketingCountByBusinessId("42");
        assertSame(marketingStatisticsCountVO, actualMarketingCountByBusinessId);
        assertEquals("100", actualMarketingCountByBusinessId.getSuccessRate());
        assertEquals(-1, actualMarketingCountByBusinessId.getFail());
        verify(this.sendLogMapper).getMarketingCount((java.util.Map<?, ?>) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#getMarketingCountByBusinessId(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetMarketingCountByBusinessId3()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.SendLogServiceImpl.getMarketingCountByBusinessId(SendLogServiceImpl.java:106)
        //   In order to prevent getMarketingCountByBusinessId(String)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   getMarketingCountByBusinessId(String).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.sendLogMapper.getMarketingCount((java.util.Map<?, ?>) any())).thenReturn(null);
        this.sendLogServiceImpl.getMarketingCountByBusinessId("42");
    }

    /**
     * Method under test: {@link SendLogServiceImpl#sendLogPage(Page, SendLogPageVO)}
     */
    @Test
    void testSendLogPage()
    {
        when(this.sendLogMapper.sendLogPage((Page<SendLogPageVO>) any(), (SendLogPageVO) any())).thenReturn(new Page<>());
        Page<SendLogPageVO> page = new Page<>();
        Page<SendLogPageVO> actualSendLogPageResult = this.sendLogServiceImpl.sendLogPage(page, new SendLogPageVO());
        assertSame(page, actualSendLogPageResult);
        assertTrue(actualSendLogPageResult.getRecords().isEmpty());
        verify(this.sendLogMapper).sendLogPage((Page<SendLogPageVO>) any(), (SendLogPageVO) any());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#sendLogPage(Page, SendLogPageVO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendLogPage2()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.SendLogServiceImpl.sendLogPage(SendLogServiceImpl.java:128)
        //   In order to prevent sendLogPage(Page, SendLogPageVO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   sendLogPage(Page, SendLogPageVO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.sendLogMapper.sendLogPage((Page<SendLogPageVO>) any(), (SendLogPageVO) any())).thenReturn(null);
        Page<SendLogPageVO> page = new Page<>();
        this.sendLogServiceImpl.sendLogPage(page, new SendLogPageVO());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#sendLogPage(Page, SendLogPageVO)}
     */
    @Test
    void testSendLogPage3()
    {
        IPage<SendLogPageVO> iPage = (IPage<SendLogPageVO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.sendLogMapper.sendLogPage((Page<SendLogPageVO>) any(), (SendLogPageVO) any())).thenReturn(iPage);
        Page<SendLogPageVO> page = new Page<>();
        Page<SendLogPageVO> actualSendLogPageResult = this.sendLogServiceImpl.sendLogPage(page, new SendLogPageVO());
        assertSame(page, actualSendLogPageResult);
        assertTrue(actualSendLogPageResult.getRecords().isEmpty());
        verify(this.sendLogMapper).sendLogPage((Page<SendLogPageVO>) any(), (SendLogPageVO) any());
        verify(iPage).getRecords();
    }

    /**
     * Method under test: {@link SendLogServiceImpl#sendLogPage(Page, SendLogPageVO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSendLogPage4()
    {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at mao.sms_manage.service.impl.SendLogServiceImpl.sendLogPage(SendLogServiceImpl.java:128)
        //   In order to prevent sendLogPage(Page, SendLogPageVO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   sendLogPage(Page, SendLogPageVO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.sendLogMapper.sendLogPage((Page<SendLogPageVO>) any(), (SendLogPageVO) any()))
                .thenReturn((IPage<SendLogPageVO>) mock(IPage.class));
        this.sendLogServiceImpl.sendLogPage(null, new SendLogPageVO());
    }

    /**
     * Method under test: {@link SendLogServiceImpl#sendLogPage(Page, SendLogPageVO)}
     */
    @Test
    void testSendLogPage5()
    {
        IPage<SendLogPageVO> iPage = (IPage<SendLogPageVO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.sendLogMapper.sendLogPage((Page<SendLogPageVO>) any(), (SendLogPageVO) any())).thenReturn(iPage);
        Page<SendLogPageVO> page = (Page<SendLogPageVO>) mock(Page.class);
        when(page.setRecords((List<SendLogPageVO>) any())).thenReturn(new Page<>());
        this.sendLogServiceImpl.sendLogPage(page, new SendLogPageVO());
        verify(this.sendLogMapper).sendLogPage((Page<SendLogPageVO>) any(), (SendLogPageVO) any());
        verify(iPage).getRecords();
        verify(page).setRecords((List<SendLogPageVO>) any());
    }
}

