package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_feemode")
public class Feemode_View {
	@Id
	private int fee_mode_id;
	private String fee_mode;
	public Feemode_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feemode_View(int fee_mode_id, String fee_mode) {
		super();
		this.fee_mode_id = fee_mode_id;
		this.fee_mode = fee_mode;
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
