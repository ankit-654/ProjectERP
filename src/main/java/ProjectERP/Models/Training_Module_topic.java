package ProjectERP.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbltraining_module_topic")
public class Training_Module_topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int module_topic_id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name = "module_id",referencedColumnName = "module_id")
	@JsonIgnoreProperties("training_module_topic")
	private Training_Modules modules;
	
	public Training_Module_topic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Training_Module_topic(int module_topic_id, Training_Modules modules, Training_Topics training_topic) {
		super();
		this.module_topic_id = module_topic_id;
		this.modules = modules;
		this.training_topic = training_topic;
	}
	public int getModule_topic_id() {
		return module_topic_id;
	}
	public void setModule_topic_id(int module_topic_id) {
		this.module_topic_id = module_topic_id;
	}
	public Training_Modules getModules() {
		return modules;
	}
	public void setModules(Training_Modules modules) {
		this.modules = modules;
	}
	public Training_Topics getTraining_topic() {
		return training_topic;
	}
	public void setTraining_topic(Training_Topics training_topic) {
		this.training_topic = training_topic;
	}
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name="topic_id",referencedColumnName = "topic_id")
	@JsonIgnoreProperties("training_module_topic")
	private Training_Topics training_topic;
private int flag;
}
