package com.securitycompany.cardswipe.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;

import com.securitycompany.cardswipe.core.LogEntry;
import com.securitycompany.cardswipe.dao.LogDAO;
import org.joda.time.DateTimeUtils;

@Path("/read-log")
@Produces(MediaType.APPLICATION_JSON)
public class LogReaderResource {
	
	LogDAO logDAO;
	
	public LogReaderResource(LogDAO logDAO) {
		this.logDAO = logDAO;
	}


	/* Old Path Parameter and No Path Method
	@GET
	public List<LogEntry> getAll() {
		return logDAO.getAll();
	}
	@GET
	@Path("/{time}")
	public List<LogEntry> getFrom(@PathParam("time") String timeString) {
		DateTime timeDT = new DateTime(timeString);
		return logDAO.getFrom(DateTimeUtils.getInstantMillis(timeDT));
	}
	*/

	// New Query Parameter Method
	@GET
	public List<LogEntry> get(@QueryParam("time") Optional<String> timeString) {
        if (timeString != null && timeString.isPresent()) {
            DateTime timeDT = new DateTime(timeString.get());
            return logDAO.getFrom(DateTimeUtils.getInstantMillis(timeDT));
        }
        else {
            return logDAO.getAll();
        }
	}
}
