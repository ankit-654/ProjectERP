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
@Table(name="tblstudent_break_details")
public class Student_Break__Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int break_id;
	
	//// Student Registration Details
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name = "registration_id",referencedColumnName = "registration_id")
	@JsonIgnoreProperties("student_break_details")
	private Student_Registration_Details break_details;
public Student_Break__Details() {
		super();
		// TODO Auto-generated constructor stub
	}
public Student_Break__Details(int break_id, Student_Registration_Details break_details, String from_date,
			String to_date, String break_reason, String status) {
		super();
		this.break_id = break_id;
		this.break_details = break_details;
		this.from_date = from_date;
		this.to_date = to_date;
		this.break_reason = break_reason;
		this.status = status;
	}
public Student_Registration_Details getBreak_details() {
		return break_details;
	}
	public void setBreak_details(Student_Registration_Details break_details) {
		this.break_details = break_details;
	}
private String from_date;
private String to_date;
private String break_reason;
private String status;
public int getBreak_id() {
	return break_id;
}
public void setBreak_id(int break_id) {
	this.break_id = break_id;
}
public String getFrom_date() {
	return from_date;
}
public void setFrom_date(String from_date) {
	this.from_date = from_date;
}
public String getTo_date() {
	return to_date;
}
public void setTo_date(String to_date) {
	this.to_date = to_date;
}
public String getBreak_reason() {
	return break_reason;
}
public void setBreak_reason(String break_reason) {
	this.break_reason = break_reason;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
