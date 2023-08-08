package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_examlevels")
public class Examlevel_View {
	@Id
	private int level_id;
	private String level_name;
	public Examlevel_View() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Examlevel_View(int level_id, String level_name) {
		super();
		this.level_id = level_id;
		this.level_name = level_name;
	}
	public int getLevel_id() {
		return level_id;
	}
	public void setLevel_id(int level_id) {
		this.level_id = level_id;
	}
	public String getLevel_name() {
		return level_name;
	}
	public void setLevel_name(String level_name) {
		this.level_name = level_name;
	}

}
