package com.securitycompany.cardswipe.core.mapper;

import com.securitycompany.cardswipe.core.LogEntry;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LogMapper implements ResultSetMapper<LogEntry> {
	public LogEntry map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException
	{
        return new LogEntry()
        	.setTime(resultSet.getTime("TIME"))
                .setId(resultSet.getInt("ID"))
                .setLocation(resultSet.getString("LOCATION"));
        }
}
