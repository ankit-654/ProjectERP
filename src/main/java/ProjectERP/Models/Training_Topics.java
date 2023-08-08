package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbltraining_topics")
public class Training_Topics {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

private int topic_id;
private String topic_name;

public Training_Topics(int topic_id, String topic_name) {
	super();
	this.topic_id = topic_id;
	this.topic_name = topic_name;

}

private int flag;


//*****one to many for Topic Content
@OneToMany(mappedBy = "topic_content",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
@JsonIgnoreProperties("topic_content")

private Set<Topic_Content> topicontents;
public Set<Topic_Content> getTopicontents() {
	return topicontents;
}
public void setTopicontents(Set<Topic_Content> topicontents) {
	this.topicontents = topicontents;
}
public Training_Topics() {
	super();
	// TODO Auto-generated constructor stub
}
public Training_Topics(String topic_name) {
	super();
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
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
@OneToMany(fetch=FetchType.EAGER, mappedBy = "training_topic", cascade = CascadeType.MERGE)
@JsonIgnoreProperties("training_topic")
private Set<Training_Module_topic> training_module_topic=new HashSet<Training_Module_topic>();

public Set<Training_Module_topic> getTraining_module_topic() {
	return training_module_topic;
}
public void setTraining_module_topic(Set<Training_Module_topic> training_module_topic) {
	this.training_module_topic = training_module_topic;
}

}
