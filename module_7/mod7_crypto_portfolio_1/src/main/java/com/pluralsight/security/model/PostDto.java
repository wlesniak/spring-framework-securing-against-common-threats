package com.pluralsight.security.model;

public class PostDto {

	private String queryId;
	private String content;
	private String username;
	private boolean resolve;
	
	public PostDto() {}
	
	public PostDto(String queryId, String content, String username, boolean resolve) {
		this.queryId = queryId;
		this.content = content;
		this.username = username;
		this.resolve = resolve;
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isResolve() {
		return resolve;
	}

	public void setResolve(boolean resolve) {
		this.resolve = resolve;
	}
	
}
