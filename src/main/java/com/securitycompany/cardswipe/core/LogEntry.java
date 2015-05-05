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
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location){
		this.location = location;
	}
}
