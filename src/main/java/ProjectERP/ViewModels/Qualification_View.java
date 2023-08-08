package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_qualifications")
public class Qualification_View {
	@Id
	private int qualification_id;
	private String qualification_name;
	public Qualification_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qualification_View(int qualification_id, String qualification_name) {
		super();
		this.qualification_id = qualification_id;
		this.qualification_name = qualification_name;
	}
	public int getQualification_id() {
		return qualification_id;
	}
	public void setQualification_id(int qualification_id) {
		this.qualification_id = qualification_id;
	}
	public String getQualification_name() {
		return qualification_name;
	}
	public void setQualification_name(String qualification_name) {
		this.qualification_name = qualification_name;
	}

}
