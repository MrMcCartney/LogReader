package com.securitycompany.cardswipe.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

import com.securitycompany.cardswipe.core.LogEntry;
import com.securitycompany.cardswipe.core.mapper.LogMapper;

@RegisterMapper(LogMapper.class)
public interface LogDAO {
	@SqlQuery("SELECT * FROM ACCESS_LOG")
	List<LogEntry> getAll();

	@SqlQuery("SELECT * FROM ACCESS_LOG WHERE TIME > :time")
	List<LogEntry> getFrom(@Bind("time") long time);
}
