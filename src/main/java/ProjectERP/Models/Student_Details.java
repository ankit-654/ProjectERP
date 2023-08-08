package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;
import ProjectERP.Models.*;
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
@Table(name="tblstudent_details")
public class Student_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int	student_id;
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}
public String getStudent_code() {
	return student_code;
}
public void setStudent_code(String student_code) {
	this.student_code = student_code;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getMiddle_name() {
	return middle_name;
}
public void setMiddle_name(String middle_name) {
	this.middle_name = middle_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getEmail_address() {
	return email_address;
}
public void setEmail_address(String email_address) {
	this.email_address = email_address;
}
public String getMobile_number() {
	return mobile_number;
}
public void setMobile_number(String mobile_number) {
	this.mobile_number = mobile_number;
}
public String getAlternative_number() {
	return alternative_number;
}
public void setAlternative_number(String alternative_number) {
	this.alternative_number = alternative_number;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}
public String getBirth_date() {
	return birth_date;
}
public void setBirth_date(String birth_date) {
	this.birth_date = birth_date;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getLocal_Address() {
	return Local_Address;
}
public void setLocal_Address(String local_Address) {
	Local_Address = local_Address;
}
public String getPermanent_Address() {
	return Permanent_Address;
}
public void setPermenant_Address(String permanent_Address) {
	Permanent_Address = permanent_Address;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
private String student_code;
private String	first_name;
private String	middle_name;
private String	last_name;
private String	email_address;
private String	mobile_number;
private String	alternative_number;
private String	photo;
private String	birth_date;
private String	password;


/// Location Many to One
@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
@JoinColumn(name = "location_id",referencedColumnName = "location_id")
@JsonIgnoreProperties("student_details")
private Location student_location;


public Student_Details() {
	super();
	// TODO Auto-generated constructor stub
}
public Student_Details(int student_id, String student_code, String first_name, String middle_name, String last_name,
		String email_address, String mobile_number, String alternative_number, String photo, String birth_date,
		String password, Location student_location, String local_Address, String permanent_Address, String status) {
	super();
	this.student_id = student_id;
	this.student_code = student_code;
	this.first_name = first_name;
	this.middle_name = middle_name;
	this.last_name = last_name;
	this.email_address = email_address;
	this.mobile_number = mobile_number;
	this.alternative_number = alternative_number;
	this.photo = photo;
	this.birth_date = birth_date;
	this.password = password;
	this.student_location = student_location;
	this.Local_Address = local_Address;
	this.Permanent_Address = permanent_Address;
	this.status = status;
}
public Location getStudent_location() {
	return student_location;
}
public void setStudent_location(Location student_location) {
	this.student_location = student_location;
}
private String	Local_Address;
private String Permanent_Address;
public void setPermanent_Address(String permanent_Address) {
	Permanent_Address = permanent_Address;
}
private String	status;

@OneToMany(fetch = FetchType.EAGER,mappedBy = "student_details",cascade = CascadeType.MERGE)
@JsonIgnoreProperties("student_details")
private Set<Student_Qualifications>studentqualifications=new HashSet<Student_Qualifications>();
public Set<Student_Qualifications> getStudentqualifications() {
	return studentqualifications;
}
public void setStudentqualifications(Set<Student_Qualifications> studentqualifications) {
	this.studentqualifications = studentqualifications;
}

@OneToMany(fetch = FetchType.EAGER,mappedBy = "activity_details",cascade = CascadeType.MERGE)
@JsonIgnoreProperties("activity_details")
private Set<Login_Activities>login_activities=new HashSet<Login_Activities>();
public Set<Login_Activities> getLogin_activities() {
	return login_activities;
}
public void setLogin_activities(Set<Login_Activities> login_activities) {
	this.login_activities = login_activities;
}

/// Student Registration Details
@OneToMany(fetch = FetchType.EAGER,mappedBy = "registration_details",cascade = CascadeType.MERGE)
@JsonIgnoreProperties("registration_details")
private Set<Student_Registration_Details>student_registration_details=new HashSet<Student_Registration_Details>();
public Set<Student_Registration_Details> getStudent_registration_details() {
	return student_registration_details;
}
public void setStudent_registration_details(Set<Student_Registration_Details> student_registration_details) {
	this.student_registration_details = student_registration_details;
}

}
