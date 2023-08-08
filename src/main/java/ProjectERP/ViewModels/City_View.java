package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vw_city")
public class City_View {
@Id
	private int city_id;
	private String city_name;
	private int state_id;
	private String state_name;
	public City_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City_View(int city_id, String city_name, int state_id, String state_name) {
		super();
		this.city_id = city_id;
		this.city_name = city_name;
		this.state_id = state_id;
		this.state_name = state_name;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
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
}
