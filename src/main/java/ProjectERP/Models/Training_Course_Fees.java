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
@Table(name="tbltraining_course_fee")
public class Training_Course_Fees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_fee_id;
	public Training_Course_Fees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Training_Course_Fees(int course_fee_id, int amount) {
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	private int amount;
	private int flag;
}
