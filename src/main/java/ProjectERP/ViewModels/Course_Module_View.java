package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_coursemodules")
public class Course_Module_View {
	@Id
	private int course_module_id;
	private int course_id;
	private String course_name;
	private int module_id;
	private String module_name;
	public Course_Module_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course_Module_View(int course_module_id, int course_id, String course_name, int module_id,
			String module_name) {
		super();
		this.course_module_id = course_module_id;
		this.course_id = course_id;
		this.course_name = course_name;
		this.module_id = module_id;
		this.module_name = module_name;
	}
	public int getCourse_module_id() {
		return course_module_id;
	}
	public void setCourse_module_id(int course_module_id) {
		this.course_module_id = course_module_id;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
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
