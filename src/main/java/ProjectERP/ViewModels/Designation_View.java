package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_designations")
public class Designation_View {
	@Id
	private int designation_id;
	private String designation_name;
	public Designation_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Designation_View(int designation_id, String designation_name) {
		super();
		this.designation_id = designation_id;
		this.designation_name = designation_name;
	}
	public int getDesignation_id() {
		return designation_id;
	}
	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}
	public String getDesignation_name() {
		return designation_name;
	}
	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}

}
