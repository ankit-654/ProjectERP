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
@Table(name="tblstudent_qualifications")
public class Student_Qualifications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int	student_qualification_id;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name="student_id",referencedColumnName = "student_id")
	@JsonIgnoreProperties("studentqualifications")
	private Student_Details student_details;
	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name="specialization_id",referencedColumnName = "specialization_id")
	@JsonIgnoreProperties("studentqualifications")
	private Specialization specialization;
public Student_Qualifications() {
		super();
		// TODO Auto-generated constructor stub
	}
public Student_Qualifications(int student_qualification_id, Student_Details student_details,
			Specialization specialization, String medium, int passing_year, float percentage, String university,
			String status) {
		super();
		this.student_qualification_id = student_qualification_id;
		this.student_details = student_details;
		this.specialization = specialization;
		this.medium = medium;
		this.passing_year = passing_year;
		this.percentage = percentage;
		this.university = university;
		this.status = status;
	}
public Student_Details getStudent_details() {
		return student_details;
	}
	public void setStudent_details(Student_Details student_details) {
		this.student_details = student_details;
	}
	public Specialization getSpecialization() {
		return specialization;
	}
	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}
private String	medium;
private int	passing_year;
private float	percentage;
private String	university;
private String	status;
public int getStudent_qualification_id() {
	return student_qualification_id;
}
public void setStudent_qualification_id(int student_qualification_id) {
	this.student_qualification_id = student_qualification_id;
}
public String getMedium() {
	return medium;
}
public void setMedium(String medium) {
	this.medium = medium;
}
public int getPassing_year() {
	return passing_year;
}
public void setPassing_year(int passing_year) {
	this.passing_year = passing_year;
}
public float getPercentage() {
	return percentage;
}
public void setPercentage(float percentage) {
	this.percentage = percentage;
}
public String getUniversity() {
	return university;
}
public void setUniversity(String university) {
	this.university = university;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
