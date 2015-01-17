package de.knallisworld.poc.mongo.model;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.index.Indexed;

public class Activity implements Serializable {

	private static final long serialVersionUID = 4341515397654490137L;

	private String id;

	@Indexed
	private DateTime published;

	private String verb;

	@Indexed
	private Project project;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public DateTime getPublished() {
		return published;
	}

	public void setPublished(final DateTime published) {
		this.published = published;
	}

	public String getVerb() {
		return verb;
	}

	public void setVerb(final String verb) {
		this.verb = verb;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(final Project project) {
		this.project = project;
	}

}
