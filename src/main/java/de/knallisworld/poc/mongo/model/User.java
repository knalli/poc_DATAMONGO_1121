package de.knallisworld.poc.mongo.model;


public class User {

	private final String id;
	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}

	public User(final String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
