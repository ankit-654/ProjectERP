package ProjectERP.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbllead_sources")
public class Lead_Source {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int source_id;
private String source_name;
private int flag;
public Lead_Source() {
	super();
	// TODO Auto-generated constructor stub
}
public Lead_Source(int source_id, String source_name, int flag) {
	super();
	this.source_id = source_id;
	this.source_name = source_name;
	this.flag = flag;
}
public int getSource_id() {
	return source_id;
}
public void setSource_id(int source_id) {
	this.source_id = source_id;
}
public String getSource_name() {
	return source_name;
}
public void setSource_name(String source_name) {
	this.source_name = source_name;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
}
