package com.pluralsight.security.model;

public class CreateSupportQueryDto {
	
	private String subject;
	private String content;
	private boolean resolved;
	
	public CreateSupportQueryDto() {
	}
	
	public CreateSupportQueryDto(String subject, String content, boolean resolved) {
		this.subject = subject;
		this.content = content;
		this.resolved = resolved;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}
	
	
	
}
