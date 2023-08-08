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
@Table(name = "tbltraining_modules")
public class Training_Modules {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int module_id;
private String module_name;
public Training_Modules(int module_id, String module_name) {
	super();
	this.module_id = module_id;
	this.module_name = module_name;
}

private int flag;
public Training_Modules() {
	super();
	// TODO Auto-generated constructor stub
}
public Training_Modules(String module_name) {
	super();
	this.module_name = module_name;
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
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
@OneToMany(fetch = FetchType.EAGER,mappedBy = "training_modules",cascade = CascadeType.MERGE)
@JsonIgnoreProperties("training_modules")
private Set<Training_Course_Module> coursemodule=new HashSet<Training_Course_Module>();

public Set<Training_Course_Module> getCoursemodule() {
	return coursemodule;
}
public void setCoursemodule(Set<Training_Course_Module> coursemodule) {
	this.coursemodule = coursemodule;
}

@OneToMany(fetch=FetchType.EAGER, mappedBy = "modules", cascade = CascadeType.MERGE)
@JsonIgnoreProperties("modules")
private Set<Training_Module_topic> training_module_topic=new HashSet<Training_Module_topic>();
public Set<Training_Module_topic> getTraining_module_topic() {
	return training_module_topic;
}
public void setTraining_module_topic(Set<Training_Module_topic> training_module_topic) {
	this.training_module_topic = training_module_topic;
}
}
