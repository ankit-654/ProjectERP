package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name="tbltraining_courses")
public class Training_courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int course_id;
	@NotNull
private String course_name;
private String course_code;
private String course_fees;
private int flag;

public Training_courses(String course_name, String course_code,
		Technology technology, String course_fees) {
	super();
	this.course_name = course_name;
	this.course_code = course_code;
	this.technology = technology;
	this.course_fees = course_fees;
}


@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
@JoinColumn(name = "technology_id",referencedColumnName = "technology_id")
@JsonIgnoreProperties("trainingcourses")
private Technology technology;
public Training_courses(String string, String string2, Technology technology, String string3, Fee_Mode feemode) {
	super();
	this.technology = technology;
	this.feemode = feemode;
}
public Technology getTechnology() {
	return technology;
}
public void setTechnology(Technology technology) {
	this.technology = technology;
}
public Fee_Mode getFeemode() {
	return feemode;
}
public void setFeemode(Fee_Mode feemode) {
	this.feemode = feemode;
}

@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
@JoinColumn(name = "fee_mode_id",referencedColumnName = "fee_mode_id")
@JsonIgnoreProperties("trainingcourses")
private Fee_Mode feemode;

public Training_courses() {
	super();
	// TODO Auto-generated constructor stub
}

public Training_courses(String course_name2, String course_code2) {
	// TODO Auto-generated constructor stub
}
public int getCourse_id() {
	return course_id;
}
public void setCourse_id(int course_id) {
	this.course_id = course_id;
}
public String getCourse_name() {
	return course_name;
}
public void setCourse_name(String course_name) {
	this.course_name = course_name;
}
public String getCourse_code() {
	return course_code;
}
public void setCourse_code(String course_code) {
	this.course_code = course_code;
}
public String getCourse_fees() {
	return course_fees;
}
public void setCourse_fees(String course_fees) {
	this.course_fees = course_fees;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
@OneToMany(fetch = FetchType.EAGER,mappedBy = "training_course_module",cascade = CascadeType.MERGE )
@JsonIgnoreProperties("training_course_module")
private Set<Training_Course_Module> coursemodule=new HashSet<Training_Course_Module>();

public Set<Training_Course_Module> getCoursemodule() {
	return coursemodule;
}
public void setCoursemodule(Set<Training_Course_Module> coursemodule) {
	this.coursemodule = coursemodule;
}

//@OneToMany(fetch = FetchType.EAGER,mappedBy = "training_course_fee",cascade = CascadeType.MERGE)
//@JsonIgnoreProperties("training_course_fee")
//private Set<Training_Course_Fees>trainingfee=new HashSet<Training_Course_Fees>();
//
//public Set<Training_Course_Fees> getTrainingfee() {
//	return trainingfee;
//}
//public void setCourse_fee_for_training(Set<Training_Course_Fees> trainingfee) {
//	this.trainingfee = trainingfee;
//}

/// Student Registartion Details
@OneToMany(fetch = FetchType.EAGER,mappedBy = "course_details",cascade = CascadeType.MERGE)
@JsonIgnoreProperties("course_details")
private Set<Student_Registration_Details>student_registration_details=new HashSet<Student_Registration_Details>();
public Set<Student_Registration_Details> getStudent_registration_details() {
	return student_registration_details;
}
public void setStudent_registration_details(Set<Student_Registration_Details> student_registration_details) {
	this.student_registration_details = student_registration_details;
}
}
