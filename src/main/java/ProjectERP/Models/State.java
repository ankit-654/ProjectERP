package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tblstates")
public class State {

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int state_id;
private String state_name;
private int flag;


@OneToMany(mappedBy = "state",fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
@JsonIgnoreProperties("state")
private Set<City>cities=new HashSet<City>();
public State() {
	super();
	// TODO Auto-generated constructor stub
}
public State(int state_id,String state_name, int flag) {
	super();
	this.state_id= state_id;
	this.state_name = state_name;
	this.flag = flag;
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
public Set<City> getCities() {
	return cities;
}
public void setCities(Set<City> cities) {
	this.cities = cities;
}
}
