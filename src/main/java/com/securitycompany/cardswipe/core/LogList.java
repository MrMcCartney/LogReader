package com.securitycompany.cardswipe.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogList {
	private long id;
	
	private String content;
	
	public LogList() {
	
	}
	
	public LogList() {
		this.id = id;
		this.content = content;
	}
	
	@JsonProperty
	public long getId() {
		return id;
	}
	
	@JsonProperty
	public long getContent() {
		return content;
	}
}
