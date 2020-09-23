package com.pluralsight.security.model;

import java.util.Calendar;
import java.util.List;

public class SupportQueryDto {

	private final String id;
	private final String subject;
	private final Calendar creationTime;
	private final String username;
	private final boolean resolved;
	private final List<PostDto> posts;
	
	public SupportQueryDto(String id, String subject, Calendar creationTime, String username, boolean resolved,
			List<PostDto> posts) {
		this.id = id;
		this.subject = subject;
		this.creationTime = creationTime;
		this.username = username;
		this.resolved = resolved;
		this.posts = posts;
	}
	
	public Calendar getCreationTime() {
		return creationTime;
	}
	
	public String getId() {
		return id;
	}
	
	public List<PostDto> getPosts() {
		return posts;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean isResolved() {
		return resolved;
	}
	
}
