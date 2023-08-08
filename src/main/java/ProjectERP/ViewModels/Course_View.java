package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vw_courses")
public class Course_View {

	@Id
	private int course_id;
	private String course_name;
	private String course_code;
	private int technology_id;
	private String technology_name;
	private float course_fees;
	private int fee_mode_id;
	private String fee_mode;
	public Course_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course_View(int course_id, String course_name, String course_code, int technology_id,
			String technology_name, float course_fees, int fee_mode_id, String fee_mode) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_code = course_code;
		this.technology_id = technology_id;
		this.technology_name = technology_name;
		this.course_fees = course_fees;
		this.fee_mode_id = fee_mode_id;
		this.fee_mode = fee_mode;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_code() {
		return course_code;
	}
	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}
	public int getTechnology_id() {
		return technology_id;
	}
	public void setTechnology_id(int technology_id) {
		this.technology_id = technology_id;
	}
	public String getTechnology_name() {
		return technology_name;
	}
	public void setTechnology_name(String technology_name) {
		this.technology_name = technology_name;
	}
	public float getCourse_fees() {
		return course_fees;
	}
	public void setCourse_fees(float course_fees) {
		this.course_fees = course_fees;
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
	
}
