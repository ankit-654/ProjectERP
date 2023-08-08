package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_topics")
public class Topic_View {
	@Id
	private int topic_id;
	private String topic_name;
	public Topic_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Topic_View(int topic_id, String topic_name) {
		super();
		this.topic_id = topic_id;
		this.topic_name = topic_name;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	public String getTopic_name() {
		return topic_name;
	}
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

}
