package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "vw_leadsources")
public class Lead_Source_View {
	@Id
 private int source_id;
 private String source_name;
public Lead_Source_View() {
	super();
	// TODO Auto-generated constructor stub
}
public Lead_Source_View(int source_id, String source_name) {
	super();
	this.source_id = source_id;
	this.source_name = source_name;
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
}
