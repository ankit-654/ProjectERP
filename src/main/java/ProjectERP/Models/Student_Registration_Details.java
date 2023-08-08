package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "tblstudent_registration_details")
public class Student_Registration_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

private int	registration_id;
private String registration_code;
/// Student Details
@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
@JoinColumn(name = "student_id",referencedColumnName = "student_id")
@JsonIgnoreProperties("student_registration_details")
private Student_Details registration_details;

/// Training_Courses
@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
@JoinColumn(name = "course_id",referencedColumnName = "course_id")
@JsonIgnoreProperties("student_registration_details")
private Training_courses course_details;

public Student_Registration_Details() {
	super();
	// TODO Auto-generated constructor stub
}
public Student_Registration_Details(int registration_id, String registration_code, Student_Details registration_details,
		Training_courses course_details, String joining_date, int discount, String discount_reason,
		String current_status, String status) {
	super();
	this.registration_id = registration_id;
	this.registration_code = registration_code;
	this.registration_details = registration_details;
	this.course_details = course_details;
	this.joining_date = joining_date;
	this.discount = discount;
	this.discount_reason = discount_reason;
	this.current_status = current_status;
	this.status = status;
}

public Student_Registration_Details(int registration_id2, String registration_code2, String first_name,
		String course_name, String joining_date2, int discount2, String discount_reason2, String current_status2,
		String status2) {
	// TODO Auto-generated constructor stub
}
public Student_Details getRegistration_details() {
	return registration_details;
}
public void setRegistration_details(Student_Details registration_details) {
	this.registration_details = registration_details;
}
public Training_courses getCourse_details() {
	return course_details;
}
public void setCourse_details(Training_courses course_details) {
	this.course_details = course_details;
}
private String joining_date;
private int discount;
private String	discount_reason;
private String	current_status;
private String	status;
public int getRegistration_id() {
	return registration_id;
}
public void setRegistration_id(int registration_id) {
	this.registration_id = registration_id;
}
public String getRegistration_code() {
	return registration_code;
}
public void setRegistration_code(String registration_code) {
	this.registration_code = registration_code;
}
public String getJoining_date() {
	return joining_date;
}
public void setJoining_date(String joining_date) {
	this.joining_date = joining_date;
}
public int getDiscount() {
	return discount;
}
public void setDiscount(int discount) {
	this.discount = discount;
}
public String getDiscount_reason() {
	return discount_reason;
}
public void setDiscount_reason(String discount_reason) {
	this.discount_reason = discount_reason;
}
public String getCurrent_status() {
	return current_status;
}
public void setCurrent_status(String current_status) {
	this.current_status = current_status;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

/// Student Payment Details
@OneToMany(fetch = FetchType.EAGER,mappedBy = "payment_details",cascade = CascadeType.MERGE)
@JsonIgnoreProperties("payment_details")
private Set<Student_Payment_Details>student_payment_details=new HashSet<Student_Payment_Details>();

public Set<Student_Payment_Details> getStudent_payment_details() {
	return student_payment_details;
}
public void setStudent_payment_details(Set<Student_Payment_Details> student_payment_details) {
	this.student_payment_details = student_payment_details;
}

//// Student Break Details 
@OneToMany(fetch = FetchType.EAGER,mappedBy = "break_details",cascade = CascadeType.MERGE)
@JsonIgnoreProperties("break_details")
private Set<Student_Break__Details>student_break_details=new HashSet<Student_Break__Details>();


public Set<Student_Break__Details> getStudent_break_details() {
	return student_break_details;
}
public void setStudent_break_details(Set<Student_Break__Details> student_break_details) {
	this.student_break_details = student_break_details;
}

////BooksRecord 
@OneToMany(fetch = FetchType.EAGER,mappedBy = "regd_details",cascade = CascadeType.MERGE)
@JsonIgnoreProperties("regd_details")
private Set<BooksRecord> boooksrecord;
public Set<BooksRecord> getBoooksrecord() {
	return boooksrecord;
}
public void setBoooksrecord(Set<BooksRecord> boooksrecord) {
	this.boooksrecord = boooksrecord;
}
}
