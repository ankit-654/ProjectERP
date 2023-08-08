package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tblcities")

public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int city_id;
private String city_name;


public City() {
	super();
	// TODO Auto-generated constructor stub
}
public City(int city_id, String city_name, State state) {
	super();
	this.city_id = city_id;
	this.city_name = city_name;
	this.state = state;
}

public City(State state) {
	super();
	this.state = state;
}

public City(int city_id, String city_name) {
	super();
	this.city_id = city_id;
	this.city_name = city_name;
}
private int flag; 

@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
@JoinColumn(name = "state_id",referencedColumnName = "state_id")
@JsonIgnoreProperties("cities")
private State state;

public City(String city_name, int flag, State state) {
	super();
	this.city_name = city_name;
	this.flag = flag;
	this.state = state;
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
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
public State getState() {
	return state;
}
public void setState(State state) {
	this.state = state;
}

//@OneToMany(fetch = FetchType.EAGER,mappedBy = "city_location",cascade = CascadeType.MERGE)
//@JsonIgnoreProperties("city_location")
//private Set<Location>location=new HashSet<Location>();
//
//
//public Set<Location> getLocation() {
//	return location;
//}
//
//public void setLocation(Set<Location> location) {
//	this.location = location;
//}


}
