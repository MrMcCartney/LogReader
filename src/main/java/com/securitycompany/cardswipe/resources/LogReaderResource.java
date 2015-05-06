package com.securitycompany.cardswipe.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
}
