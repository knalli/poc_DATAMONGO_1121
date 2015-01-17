package de.knallisworld.poc.mongo.model;


public class Project {

	private final String id;
	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(final String displayName) {
		this.displayName = displayName;
	}

	public Project(final String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}
