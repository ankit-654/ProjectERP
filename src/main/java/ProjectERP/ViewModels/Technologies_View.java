package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_technologies")
public class Technologies_View {
@Id
private int technology_id;
private String technology_name;
public Technologies_View() {
	super();
	// TODO Auto-generated constructor stub
}
public Technologies_View(int technology_id, String technology_name) {
	super();
	this.technology_id = technology_id;
	this.technology_name = technology_name;
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
}
