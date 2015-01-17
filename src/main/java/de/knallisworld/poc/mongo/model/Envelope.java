package de.knallisworld.poc.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "activities")
@CompoundIndexes({
		@CompoundIndex(name = "stream_selection_by_user_idx", def = "{'user._id' : 1, 'activity.published' : 1}"),
		@CompoundIndex(name = "stream_selection_by_project_idx", def = "{'project._id' : 1, 'user._id' : 1, 'activity.published' : 1}")})
public class Envelope {

	@Id
	private String id;

	@Indexed
	private Project project;

	@Indexed
	private User user;

	private Activity activity;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(final Activity activity) {
		this.activity = activity;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(final Project project) {
		this.project = project;
	}
}
