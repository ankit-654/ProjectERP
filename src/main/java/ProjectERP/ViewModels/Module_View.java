package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_modules")
public class Module_View {
@Id
private int module_id;
private String module_name;
public Module_View() {
	super();
	// TODO Auto-generated constructor stub
}
public Module_View(int module_id, String module_name) {
	super();
	this.module_id = module_id;
	this.module_name = module_name;
}
public int getModule_id() {
	return module_id;
}
public void setModule_id(int module_id) {
	this.module_id = module_id;
}
public String getModule_name() {
	return module_name;
}
public void setModule_name(String module_name) {
	this.module_name = module_name;
}
}
