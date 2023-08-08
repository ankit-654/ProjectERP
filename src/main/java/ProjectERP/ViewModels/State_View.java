package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "vw_states")
public class State_View {
	@Id
	private int state_id;
	private String state_name;
	private int flag;
	public State_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public State_View(int state_id, String state_name) {
		super();
		this.state_id = state_id;
		this.state_name = state_name;
	}
	public int getState_id() {
		return state_id;
	}
	public void setState_id(int state_id) {
		this.state_id = state_id;
	}
	public String getState_name() {
		return state_name;
	}
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

}
