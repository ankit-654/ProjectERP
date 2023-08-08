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

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="student_sports_record")
public class Student_Sports_Record {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int student_sports_id;
@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
@JoinColumn(name = "sports_id",referencedColumnName = "sports_id")
@JsonIgnoreProperties("student_sports_record")
private sports sports_record;
private String student_name;
private String joining_date;
private String date_of_birth;
private String status;
public Student_Sports_Record() {
	super();
	// TODO Auto-generated constructor stub
}
public Student_Sports_Record(int student_sports_id, sports sports_record, String student_name, String joining_date,
		String date_of_birth, String status) {
	super();
	this.student_sports_id = student_sports_id;
	this.sports_record = sports_record;
	this.student_name = student_name;
	this.joining_date = joining_date;
	this.date_of_birth = date_of_birth;
	this.status = status;
}
public int getStudent_sports_id() {
	return student_sports_id;
}
public void setStudent_sports_id(int student_sports_id) {
	this.student_sports_id = student_sports_id;
}
public sports getSports_record() {
	return sports_record;
}
public void setSports_record(sports sports_record) {
	this.sports_record = sports_record;
}
public String getStudent_name() {
	return student_name;
}
public void setStudent_name(String student_name) {
	this.student_name = student_name;
}
public String getJoining_date() {
	return joining_date;
}
public void setJoining_date(String joining_date) {
	this.joining_date = joining_date;
}
public String getDate_of_birth() {
	return date_of_birth;
}
public void setDate_of_birth(String date_of_birth) {
	this.date_of_birth = date_of_birth;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}


}
