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
@Table(name = "tblstudent_login_activities")
public class Login_Activities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int activity_id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name = "student_id",referencedColumnName = "student_id")
	@JsonIgnoreProperties("login_activities")
	private Student_Details activity_details;

public Login_Activities(int activity_id, Student_Details activity_details, String login_time, String logout_time,
			String status) {
		super();
		this.activity_id = activity_id;
		this.activity_details = activity_details;
		this.login_time = login_time;
		this.logout_time = logout_time;
		this.status = status;
	}
public Student_Details getActivity_details() {
		return activity_details;
	}
	public void setActivity_details(Student_Details activity_details) {
		this.activity_details = activity_details;
	}
private String login_time;
private String logout_time;
private String status;

public Login_Activities() {
	super();
	// TODO Auto-generated constructor stub
}
public Login_Activities(int activity_id, Login_Activities student_activities, String login_time, String logout_time,
		String status) {
	super();
	this.activity_id = activity_id;
	this.login_time = login_time;
	this.logout_time = logout_time;
	this.status = status;
}
public int getActivity_id() {
	return activity_id;
}
public void setActivity_id(int activity_id) {
	this.activity_id = activity_id;
}
public String getLogin_time() {
	return login_time;
}
public void setLogin_time(String login_time) {
	this.login_time = login_time;
}
public String getLogout_time() {
	return logout_time;
}
public void setLogout_time(String logout_time) {
	this.logout_time = logout_time;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
