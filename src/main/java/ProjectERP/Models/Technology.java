package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tbltechnologies")
public class Technology {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int technology_id;
	@NotNull
	
private String technology_name;
private int flag;

public Technology() {
	super();
	// TODO Auto-generated constructor stub
}
public Technology(int technology_id, String technology_name, int flag) {
	super();
	this.technology_id = technology_id;
	this.technology_name = technology_name;
	this.flag = flag;
}
public int getTechnology_id() {
	return technology_id;
}
public void setTechnology_id(int technology_id) {
	this.technology_id = technology_id;
}
public String getTechnology_name() {
	return technology_name;
}
public void setTechnology_name(String technology_name) {
	this.technology_name = technology_name;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
@OneToMany(fetch=FetchType.EAGER, mappedBy = "technology", cascade = CascadeType.MERGE)
@JsonIgnoreProperties("technology")
private Set<Training_courses> trainingcourses = new HashSet<>();
}
