package ProjectERP.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "tblenviornment")

public class Enviornment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int activity_id;
	private String activity_name;
	private int total_group;
	private String activity_date;
	private int total_strength;
	private String status;
	public Enviornment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enviornment(int activity_id, String activity_name, int total_group, String activity_date, int total_strength,
			String status) {
		super();
		this.activity_id = activity_id;
		this.activity_name = activity_name;
		this.total_group = total_group;
		this.activity_date = activity_date;
		this.total_strength = total_strength;
		this.status = status;
	}
	public int getActivity_id() {
		return activity_id;
	}
	public void setActivity_id(int activity_id) {
		this.activity_id = activity_id;
	}
	public String getActivity_name() {
		return activity_name;
	}
	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}
	public int getTotal_group() {
		return total_group;
	}
	public void setTotal_group(int total_group) {
		this.total_group = total_group;
	}
	public String getActivity_date() {
		return activity_date;
	}
	public void setActivity_date(String activity_date) {
		this.activity_date = activity_date;
	}
	public int getTotal_strength() {
		return total_strength;
	}
	public void setTotal_strength(int total_strength) {
		this.total_strength = total_strength;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
