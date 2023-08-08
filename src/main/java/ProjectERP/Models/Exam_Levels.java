package ProjectERP.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblexam_levels")
public class Exam_Levels {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int level_id;
private String level_name;
private int flag;
public Exam_Levels() {
	super();
	// TODO Auto-generated constructor stub
}
public Exam_Levels(int level_id, String level_name, int flag) {
	super();
	this.level_id = level_id;
	this.level_name = level_name;
	this.flag = flag;
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
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
}
