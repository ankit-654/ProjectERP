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
@Table (name="tblstudent_payment_details")
public class Student_Payment_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int payment_id;
	
	//// Student Registration Details
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name = "registration_id",referencedColumnName = "registration_id")
	@JsonIgnoreProperties("student_payment_details")
	private Student_Registration_Details payment_details;
public Student_Payment_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
public Student_Payment_Details(int payment_id, Student_Registration_Details payment_details, String payment_date,
			String payment_for, int payment_amount, String payment_mode, String description, String status) {
		super();
		this.payment_id = payment_id;
		this.payment_details = payment_details;
		this.payment_date = payment_date;
		this.payment_for = payment_for;
		this.payment_amount = payment_amount;
		this.payment_mode = payment_mode;
		this.description = description;
		this.status = status;
	}
public Student_Registration_Details getPayment_details() {
		return payment_details;
	}
	public void setPayment_details(Student_Registration_Details payment_details) {
		this.payment_details = payment_details;
	}
private String payment_date;
private String payment_for;
private int payment_amount;
private String payment_mode;
private String description;
private String status;
public int getPayment_id() {
	return payment_id;
}
public void setPayment_id(int payment_id) {
	this.payment_id = payment_id;
}
public String getPayment_date() {
	return payment_date;
}
public void setPayment_date(String payment_date) {
	this.payment_date = payment_date;
}
public String getPayment_for() {
	return payment_for;
}
public void setPayment_for(String payment_for) {
	this.payment_for = payment_for;
}
public int getPayment_amount() {
	return payment_amount;
}
public void setPayment_amount(int payment_amount) {
	this.payment_amount = payment_amount;
}
public String getPayment_mode() {
	return payment_mode;
}
public void setPayment_mode(String payment_mode) {
	this.payment_mode = payment_mode;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

}
