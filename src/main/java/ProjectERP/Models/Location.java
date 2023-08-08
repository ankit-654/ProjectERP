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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="tbllocation")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int location_id;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
	@JoinColumn(name="city_id",referencedColumnName = "city_id")
	@JsonIgnoreProperties("location")
	private City city_location;
public Location(int location_id, City city_location, String location_name, Set<Student_Details> student_details) {
		super();
		this.location_id = location_id;
		this.city_location = city_location;
		this.location_name = location_name;
		this.student_details = student_details;
	}
public City getCity_location() {
		return city_location;
	}
	public void setCity_location(City city_location) {
		this.city_location = city_location;
	}

private String location_name;
private int flag;
public Location() {
	super();
	// TODO Auto-generated constructor stub
}
public Location(int location_id, String location_name) {
	super();
	this.location_id = location_id;
	this.location_name = location_name;
}
public int getLocation_id() {
	return location_id;
}
public void setLocation_id(int location_id) {
	this.location_id = location_id;
}
public String getLocation_name() {
	return location_name;
}
public void setLocation_name(String location_name) {
	this.location_name = location_name;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}

@OneToMany(fetch = FetchType.EAGER,mappedBy = "student_location",cascade = CascadeType.MERGE )
@JsonIgnoreProperties("student_location")
private Set<Student_Details>student_details=new HashSet<Student_Details>();
public Set<Student_Details> getStudent_details() {
	return student_details;
}
public void setStudent_details(Set<Student_Details> student_details) {
	this.student_details = student_details;
}
}
