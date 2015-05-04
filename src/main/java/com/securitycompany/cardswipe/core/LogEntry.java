package com.securitycompany.cardswipe.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

public class LogEntry {
	
	@NotNull
	@JsonProperty
	private long time;
	
	@NotNull
	@JsonProperty
	private String id;
	
	@NotNull
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
	
	public void setId(String location){
		this.location = location;
	}
}
