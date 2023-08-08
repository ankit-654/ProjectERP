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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tblfees_mode")
public class Fee_Mode {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int fee_mode_id;
	@NotNull
private String fee_mode;
public Fee_Mode() {
		super();
		// TODO Auto-generated constructor stub
	}

private int flag;

	
public Fee_Mode(int fee_mode_id, String fee_mode, int flag) {
	super();
	this.fee_mode_id = fee_mode_id;
	this.fee_mode = fee_mode;
	this.flag = flag;
}
public int getFee_mode_id() {
	return fee_mode_id;
}
public void setFee_mode_id(int fee_mode_id) {
	this.fee_mode_id = fee_mode_id;
}
public String getFee_mode() {
	return fee_mode;
}
public void setFee_mode(String fee_mode) {
	this.fee_mode = fee_mode;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}

@OneToMany(fetch=FetchType.EAGER, mappedBy = "feemode", cascade = CascadeType.MERGE)
@JsonIgnoreProperties("feemode")
private Set<Training_courses> trainingcourses = new HashSet<>();
public Set<Training_courses> getTrainingcourses() {
	return trainingcourses;
}
public void setTrainingcourses(Set<Training_courses> trainingcourses) {
	this.trainingcourses = trainingcourses;
}

//@OneToMany(fetch = FetchType.EAGER,mappedBy = "coursefeemode",cascade = CascadeType.MERGE)
//@JsonIgnoreProperties("coursefeemode")
//private Set<Training_Course_Fees>trainingfee=new HashSet<Training_Course_Fees>();
//
//public Set<Training_Course_Fees> getTrainingfee() {
//	return trainingfee;
//}
//public void setCourse_fee_for_training(Set<Training_Course_Fees> trainingfee) {
//	this.trainingfee = trainingfee;
//}
}
