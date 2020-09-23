package com.pluralsight.security.entity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class SupportQuery {
	@Id
	private String id;
	private final String username;
	private final String subject;
	private List<Post> posts = new ArrayList<>();
	private Calendar created = Calendar.getInstance();
	private boolean resolved;
	
	public SupportQuery(String username, String subject) {
		this.username = username;
		this.subject = subject;
	}
	
	
	public void addPost(Post post) {
		this.posts.add(post);
	}
	
	public void addPost(String post, String username) {
		posts.add(new Post(username, post, System.currentTimeMillis()));
	}
	
	public void resolve() {
		this.resolved=true;
	}
	
	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public Calendar getCreated() {
		return created;
	}
	
	public String getId() {
		return id;
	}
	
	public List<Post> getPosts() {
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SupportQuery other = (SupportQuery) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (resolved != other.resolved)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (resolved ? 1231 : 1237);
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
}
