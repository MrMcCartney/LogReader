package com.securitycompany.cardswipe.resources;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.securitycompany.cardswipe.LogReaderApplication;
import com.securitycompany.cardswipe.LogReaderConfiguration;
import com.securitycompany.cardswipe.core.LogEntry;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.JerseyClientBuilder;
import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.List;

public class FullStackTest {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @ClassRule
    public static DropwizardAppRule<LogReaderConfiguration> rule = new
            DropwizardAppRule<>(LogReaderApplication.class, ResourceHelpers.resourceFilePath("configtest.yml"));

    /* Old Path Parameter Test
    @Test
    public void When_getFrom_Gets_A_List_Then_The_List_Should_Be_Filtered() throws Exception {
        Client client = new JerseyClientBuilder().build();
        ObjectMapper mapper = new ObjectMapper();

        Response response = client.target(
                String.format("http://localhost:%d/read-log", rule.getLocalPort())).path("2016-12-25T07:00:00-05:00").request().get();

        String responsebody = response.readEntity(String.class);
        log.warn(responsebody);
        List<LogEntry> entries = mapper.readValue(responsebody, new TypeReference<List<LogEntry>>() {});

        assertEquals(1, entries.size());
        assertEquals(DateTimeUtils.getInstantMillis(new DateTime("2017-12-25T07:00:00-05:00")), entries.get(0).getTime());
    }
    */

    // New Query Parameter Test
    @Test
    public void When_getFrom_Gets_A_List_Then_The_List_Should_Be_Filtered() throws Exception {
        Client client = new JerseyClientBuilder().build();
        ObjectMapper mapper = new ObjectMapper();

        Response response = client.target(String.format("http://localhost:%d/read-log", rule.getLocalPort()))
                .queryParam("time", "2016-12-25T07:00:00-05:00").request().get();
        String responsebody = response.readEntity(String.class);
        log.warn(responsebody);
        List<LogEntry> entries = mapper.readValue(responsebody, new TypeReference<List<LogEntry>>() {});

        assertEquals(1, entries.size());
        assertEquals(DateTimeUtils.getInstantMillis(new DateTime("2017-12-25T07:00:00-05:00")), entries.get(0).getTime());
    }
}
