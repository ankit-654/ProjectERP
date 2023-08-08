package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_moduletopics")
public class Module_Topic_View {

	@Id
	private int module_topic_id;
	private int module_id;
	private String module_name;
	private int topic_id;
	private String topic_name;
	public Module_Topic_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Module_Topic_View(int module_topic_id, int module_id, String module_name, int topic_id, String topic_name) {
		super();
		this.module_topic_id = module_topic_id;
		this.module_id = module_id;
		this.module_name = module_name;
		this.topic_id = topic_id;
		this.topic_name = topic_name;
	}
	public int getModule_topic_id() {
		return module_topic_id;
	}
	public void setModule_topic_id(int module_topic_id) {
		this.module_topic_id = module_topic_id;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
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
