package com.securitycompany.cardswipe.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class LogEntry {
	
	@NotEmpty
	@JsonProperty
	private long time;
	
	@NotEmpty
	@JsonProperty
	private String id;
	
	@NotEmpty
	@JsonProperty
	private String location;
	
	public long getTime() {
		return time;
	}
	
	public String getId() {
		return id;
	}
	
	public String getLocation() {
		return location;
	}

	public LogEntry() {
		// Jackson deserialization
	}
	
	public LogEntry(long time,String id,String location) {
		this.time = time;
		this.id = id;
		this.location = location;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntry)) return false;

        LogEntry that = (LogEntry) o;

        if (getTime() != that.getTime()) return false;
        if (!getId().equals(that.getId())) return false;
        if (!getLocation().equals(that.getLocation())) return false;

        return true;
    }
	/*
	public void setTime(long time) {
		this.time = time;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setLocation(String location){
		this.location = location;
	}
	*/
}
