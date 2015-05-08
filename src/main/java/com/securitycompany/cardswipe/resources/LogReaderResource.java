package com.securitycompany.cardswipe.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.GregorianCalendar;
import java.util.List;
import org.joda.time.DateTime;

import com.securitycompany.cardswipe.core.LogEntry;
import com.securitycompany.cardswipe.dao.LogDAO;

@Path("/read-log")
@Produces(MediaType.APPLICATION_JSON)
public class LogReaderResource {
	
	LogDAO logDAO;
	
	public LogReaderResource(LogDAO logDAO) {
		this.logDAO = logDAO;
	}

	@GET
	public List<LogEntry> getAll() {
		return logDAO.getAll();
	}

	@GET
	@Path("/{time}")
	public List<LogEntry> getFrom(@PathParam("time") String timeString) {
		DateTime timeDT = new DateTime(timeString);
		GregorianCalendar timeGC = timeDT.toGregorianCalendar();
		long time = timeGC.getTimeInMillis();
		return logDAO.getFrom(time);
	}
}
