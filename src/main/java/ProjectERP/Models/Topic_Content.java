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
@Table(name = "tbltopic_contents")
public class Topic_Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int content_id;
private String content_name;
private int flag;



@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
@JoinColumn(name = "topic_id",referencedColumnName = "topic_id")
@JsonIgnoreProperties("topicontents")
private Training_Topics topic_content;
public int getContent_id() {
	return content_id;
}



public Topic_Content() {
	super();
	// TODO Auto-generated constructor stub
}



public Topic_Content(int content_id, String content_name, Training_Topics topic_content) {
	super();
	this.content_id = content_id;
	this.content_name = content_name;
	this.topic_content = topic_content;
}



public void setContent_id(int content_id) {
	this.content_id = content_id;
}



public String getContent_name() {
	return content_name;
}



public void setContent_name(String content_name) {
	this.content_name = content_name;
}



public int getFlag() {
	return flag;
}



public void setFlag(int flag) {
	this.flag = flag;
}



public Training_Topics getTopic_content() {
	return topic_content;
}



public void setTopic_content(Training_Topics topic_content) {
	this.topic_content = topic_content;
}

}
