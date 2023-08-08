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
@Table(name = "tbltraining_course_modules")
public class Training_Course_Module {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int course_module_id;
public Training_Course_Module(int course_module_id, String course_code, Training_courses training_course_module,
			Training_Modules coursemodule) {
		super();
		this.course_module_id = course_module_id;
		this.course_code = course_code;
        	}
public Training_Course_Module(int course_module_id) {
		super();
		this.course_module_id = course_module_id;
	}
private String course_code;

private int flag;
public Training_Course_Module(int i, String string) {
	super();
	// TODO Auto-generated constructor stub
}

public Training_Course_Module() {
	super();
	// TODO Auto-generated constructor stub
}
public int getCourse_module_id() {
	return course_module_id;
}
public void setCourse_module_id(int course_module_id) {
	this.course_module_id = course_module_id;
}
public String getCourse_code() {
	return course_code;
}
public void setCourse_code(String course_code) {
	this.course_code = course_code;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}

@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
@JoinColumn(name="course_id",referencedColumnName = "course_id")
@JsonIgnoreProperties("coursemodule")
private Training_courses training_course_module;

@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
@JoinColumn(name = "module_id",referencedColumnName = "module_id")
@JsonIgnoreProperties("coursemodule")
private Training_Modules training_modules;
public Training_Modules getTraining_modules() {
	return training_modules;
}
public void setTraining_modules(Training_Modules training_modules) {
	this.training_modules = training_modules;
}
public Training_courses getTraining_course_module() {
	return training_course_module;
}
public void setTraining_course_module(Training_courses training_course_module) {
	this.training_course_module = training_course_module;
}

}
