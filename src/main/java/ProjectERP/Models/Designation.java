package ProjectERP.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbldesignations")
public class Designation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int designation_id;
private String designation_name;
private  int flag;
public Designation() {
	super();
	// TODO Auto-generated constructor stub
}
public Designation(int designation_id, String designation_name, int flag) {
	super();
	this.designation_id = designation_id;
	this.designation_name = designation_name;
	this.flag = flag;
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
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
}
