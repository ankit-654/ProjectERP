package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_specializations")
public class Specialization_View {
	@Id
	private int specialization_id;
	private String specialization_name;
	private int qualification_id;
	private String qualification_name;
	public Specialization_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Specialization_View(int specialization_id, String specialization_name, int qualification_id,
			String qualification_name) {
		super();
		this.specialization_id = specialization_id;
		this.specialization_name = specialization_name;
		this.qualification_id = qualification_id;
		this.qualification_name = qualification_name;
	}
	public int getSpecialization_id() {
		return specialization_id;
	}
	public void setSpecialization_id(int specialization_id) {
		this.specialization_id = specialization_id;
	}
	public String getSpecialization_name() {
		return specialization_name;
	}
	public void setSpecialization_name(String specialization_name) {
		this.specialization_name = specialization_name;
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
