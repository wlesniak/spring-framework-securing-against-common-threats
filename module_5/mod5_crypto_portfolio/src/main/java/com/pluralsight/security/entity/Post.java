package com.pluralsight.security.entity;

import org.bson.types.ObjectId;

public class Post {

	private String id;
	private final String username;
	private final String content;
	private final long timestamp;

	public Post(String username, String content, long timestamp) {
		this.username=username;
		this.content=content;
		this.timestamp=timestamp;
		this.id = new ObjectId().toHexString();
	}

	public String getContent() {
		return content;
	}
	
	public String getId() {
		return id;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public String getUsername() {
		return username;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (timestamp != other.timestamp)
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
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	
	
	
	
}


