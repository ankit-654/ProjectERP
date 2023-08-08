package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vw_coursefees")
public class Course_Fees_View {
@Id
private int course_fee_id;
private Float amount;
public Course_Fees_View() {
	super();
	// TODO Auto-generated constructor stub
}
public Course_Fees_View(int course_fee_id, Float amount) {
	super();
	this.course_fee_id = course_fee_id;
	this.amount = amount;
}
public int getCourse_fee_id() {
	return course_fee_id;
}
public void setCourse_fee_id(int course_fee_id) {
	this.course_fee_id = course_fee_id;
}
public Float getAmount() {
	return amount;
}
public void setAmount(Float amount) {
	this.amount = amount;
}
}
