package com.securitycompany.cardswipe.core;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LogEntryTest {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void When_Log_Entry_Is_Initialized_Then_Log_Entry_Should_Properly_Serialize() throws Exception {
        //When
        final LogEntry logEntry = new LogEntry(1430504951300L,"11223344","Front Desk");
        //Then
        assertEquals(fixture("fixtures/logEntry.json"), MAPPER.writeValueAsString(logEntry));
    }

    @Test
    public void When_Log_Entry_Is_Initialized_Then_Log_Entry_Should_Properly_Deserialize() throws Exception {
        //When
        final LogEntry logEntry = new LogEntry(1430504951300L,"11223344","Front Desk");
        //Then
        assertEquals(logEntry, MAPPER.readValue(fixture("fixtures/person.json"), LogEntry.class));
    }

}
