package mao.sms_manage.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import mao.sms_dao.mapper.ReceiveLogMapper;
import mao.sms_entity.vo.ReceiveLogVO;
import mao.sms_entity.vo.StatisticsCountVO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ReceiveLogServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ReceiveLogServiceImplTest
{
    @MockBean
    private ReceiveLogMapper receiveLogMapper;

    @Autowired
    private ReceiveLogServiceImpl receiveLogServiceImpl;

    /**
     * Method under test: {@link ReceiveLogServiceImpl#pageLog(Page, java.util.Map)}
     */
    @Test
    void testPageLog()
    {
        when(this.receiveLogMapper.selectLogPage((Page<ReceiveLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn(new Page<>());
        Page<ReceiveLogVO> page = new Page<>();
        Page<ReceiveLogVO> actualPageLogResult = this.receiveLogServiceImpl.pageLog(page, new HashMap<>());
        assertSame(page, actualPageLogResult);
        assertTrue(actualPageLogResult.getRecords().isEmpty());
        verify(this.receiveLogMapper).selectLogPage((Page<ReceiveLogVO>) any(), (java.util.Map<String, Object>) any());
    }

    /**
     * Method under test: {@link ReceiveLogServiceImpl#pageLog(Page, java.util.Map)}
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
        //       at mao.sms_manage.service.impl.ReceiveLogServiceImpl.pageLog(ReceiveLogServiceImpl.java:39)
        //   In order to prevent pageLog(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pageLog(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.receiveLogMapper.selectLogPage((Page<ReceiveLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn(null);
        Page<ReceiveLogVO> page = new Page<>();
        this.receiveLogServiceImpl.pageLog(page, new HashMap<>());
    }

    /**
     * Method under test: {@link ReceiveLogServiceImpl#pageLog(Page, java.util.Map)}
     */
    @Test
    void testPageLog3()
    {
        IPage<ReceiveLogVO> iPage = (IPage<ReceiveLogVO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.receiveLogMapper.selectLogPage((Page<ReceiveLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn(iPage);
        Page<ReceiveLogVO> page = new Page<>();
        Page<ReceiveLogVO> actualPageLogResult = this.receiveLogServiceImpl.pageLog(page, new HashMap<>());
        assertSame(page, actualPageLogResult);
        assertTrue(actualPageLogResult.getRecords().isEmpty());
        verify(this.receiveLogMapper).selectLogPage((Page<ReceiveLogVO>) any(), (java.util.Map<String, Object>) any());
        verify(iPage).getRecords();
    }

    /**
     * Method under test: {@link ReceiveLogServiceImpl#pageLog(Page, java.util.Map)}
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
        //       at mao.sms_manage.service.impl.ReceiveLogServiceImpl.pageLog(ReceiveLogServiceImpl.java:39)
        //   In order to prevent pageLog(Page, Map)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   pageLog(Page, Map).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.receiveLogMapper.selectLogPage((Page<ReceiveLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn((IPage<ReceiveLogVO>) mock(IPage.class));
        this.receiveLogServiceImpl.pageLog(null, new HashMap<>());
    }

    /**
     * Method under test: {@link ReceiveLogServiceImpl#pageLog(Page, java.util.Map)}
     */
    @Test
    void testPageLog5()
    {
        IPage<ReceiveLogVO> iPage = (IPage<ReceiveLogVO>) mock(IPage.class);
        when(iPage.getRecords()).thenReturn(new ArrayList<>());
        when(this.receiveLogMapper.selectLogPage((Page<ReceiveLogVO>) any(), (java.util.Map<String, Object>) any()))
                .thenReturn(iPage);
        Page<ReceiveLogVO> page = (Page<ReceiveLogVO>) mock(Page.class);
        when(page.setRecords((List<ReceiveLogVO>) any())).thenReturn(new Page<>());
        this.receiveLogServiceImpl.pageLog(page, new HashMap<>());
        verify(this.receiveLogMapper).selectLogPage((Page<ReceiveLogVO>) any(), (java.util.Map<String, Object>) any());
        verify(iPage).getRecords();
        verify(page).setRecords((List<ReceiveLogVO>) any());
    }

    /**
     * Method under test: {@link ReceiveLogServiceImpl#top10(java.util.Map)}
     */
    @Test
    void testTop10()
    {
        ArrayList<StatisticsCountVO> statisticsCountVOList = new ArrayList<>();
        when(this.receiveLogMapper.top10((java.util.Map<?, ?>) any())).thenReturn(statisticsCountVOList);
        List<StatisticsCountVO> actualTop10Result = this.receiveLogServiceImpl.top10(new HashMap<>());
        assertSame(statisticsCountVOList, actualTop10Result);
        assertTrue(actualTop10Result.isEmpty());
        verify(this.receiveLogMapper).top10((java.util.Map<?, ?>) any());
    }

    /**
     * Method under test: {@link ReceiveLogServiceImpl#trend(java.util.Map)}
     */
    @Test
    void testTrend()
    {
        ArrayList<StatisticsCountVO> statisticsCountVOList = new ArrayList<>();
        when(this.receiveLogMapper.trend((java.util.Map<?, ?>) any())).thenReturn(statisticsCountVOList);
        List<StatisticsCountVO> actualTrendResult = this.receiveLogServiceImpl.trend(new HashMap<>());
        assertSame(statisticsCountVOList, actualTrendResult);
        assertTrue(actualTrendResult.isEmpty());
        verify(this.receiveLogMapper).trend((java.util.Map<?, ?>) any());
    }
}

