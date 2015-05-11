package com.securitycompany.cardswipe.resources;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.ClassRule;
import org.junit.Test;
import com.securitycompany.cardswipe.core.LogEntry;
import io.dropwizard.testing.junit.ResourceTestRule;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.core.GenericType;

import com.securitycompany.cardswipe.dao.LogDAO;

public class LogReaderResourceTest {

    // Given
    private static final LogDAO logDAO = mock(LogDAO.class);
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new LogReaderResource(logDAO))
            .build();

    @Test
    public void When_getAll_Gets_A_List_Then_The_List_Should_Not_Change() throws Exception {
        //When
        List<LogEntry> entries = new ArrayList<>();
        entries.add(new LogEntry(1430504951300L,"11223344","Front Desk"));
        entries.add(new LogEntry(1430504956300L, "11223366", "Managers Office"));
        when(logDAO.getAll()).thenReturn(entries);
        // Then
        List<LogEntry> results = resources.client().target("/read-log").request().get(new GenericType<List<LogEntry>>() {});
        assertEquals(2, results.size());
        assertEquals(1430504951300L, results.get(0).getTime());
        assertEquals(1430504956300L, results.get(1).getTime());
        assertEquals("11223344", results.get(0).getId());
        assertEquals("11223366", results.get(1).getId());
        assertEquals("Front Desk", results.get(0).getLocation());
        assertEquals("Managers Office", results.get(1).getLocation());
    }
    /* Path Parameters have changed to query parameters
    @Test
    public void When_getFrom_Gets_A_List_Then_The_List_Should_Be_Filtered(){
        //When
        List<LogEntry> entries = new ArrayList<>();
        entries.add(new LogEntry(DateTimeUtils.getInstantMillis(new DateTime("2016-12-13T21:39:45.618-08:00")),"11223344","Front Desk"));
        entries.add(new LogEntry(DateTimeUtils.getInstantMillis(new DateTime("2018-12-13T21:39:45.618-08:00")), "11223366", "Managers Office"));

        when(logDAO.getFrom(DateTimeUtils.getInstantMillis(new DateTime("2017-12-13T21:39:45.618-08:00"))))
                .thenReturn(entries.stream().filter(e -> e.getTime() > DateTimeUtils.getInstantMillis(new DateTime("2017-12-13T21:39:45.618-08:00")))
                        .collect(Collectors.toList()));
        // Then
        List<LogEntry> results = resources.client().target("/read-log/2017-12-13T21:39:45.618-08:00").request().get(new GenericType<List<LogEntry>>() {});

        assertEquals(1,results.size());
        assertEquals("11223366",results.get(0).getId());
    }
    */
}
