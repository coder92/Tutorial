package com.tutorial.testing.mockito.tddmockito;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.util.Calendar;

import static junit.framework.Assert.assertEquals;

public class ReportGeneratorServiceTest {
    /**
     * @InjectMocks mark a field on which injection should be performed.
     * It allows shorthand mock and spy injection. Mockito will
     * try to inject mocks only either by constructor injection, setter injection,
     * or property injection in order and as described below.
     */
    @InjectMocks
    private ReportGeneratorService reportGeneratorService;
    @Mock
    private IReportGenerator reportGenerator;

    /**
     * The ArgumentCaptor class is used to capture argument values for further assertions.
     * Mockito verifies argument values in natural java style: by using an equals() method.
     */
    @Captor
    private ArgumentCaptor<ReportEntity> reportCaptor;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @SuppressWarnings("deprecation")
    @Test
    public void test() {
        Calendar startDate = Calendar.getInstance();
        startDate.set(2016, 11, 25);
        Calendar endDate = Calendar.getInstance();
        endDate.set(9999, 12, 31);
        String reportContent = "Report Content";
        reportGeneratorService.generateReport(startDate.getTime(), endDate.getTime(),
                reportContent.getBytes());
        Mockito.verify(reportGenerator).generateReport(reportCaptor.capture());
        ReportEntity report = reportCaptor.getValue();
        assertEquals(116, report.getStartDate().getYear());
        assertEquals(11, report.getStartDate().getMonth());
        assertEquals(25, report.getStartDate().getDate());
        assertEquals(8100, report.getEndDate().getYear());
        assertEquals(0, report.getEndDate().getMonth());
        assertEquals(31, report.getEndDate().getDate());
        assertEquals("Report Content", new String(report.getContent()));
    }
}
