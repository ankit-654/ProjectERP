package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name="tblsports")
public class sports {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int sports_id;
private String sports_name;
public sports() {
	super();
	// TODO Auto-generated constructor stub
}
public sports(int sports_id, String sports_name) {
	super();
	this.sports_id = sports_id;
	this.sports_name = sports_name;
}
public int getSports_id() {
	return sports_id;
}
public void setSports_id(int sports_id) {
	this.sports_id = sports_id;
}
public String getSports_name() {
	return sports_name;
}
public void setSports_name(String sports_name) {
	this.sports_name = sports_name;
}

@OneToMany(cascade = CascadeType.MERGE,mappedBy = "sports_record",fetch = FetchType.EAGER)
@JsonIgnoreProperties("sports_record")
private Set<Student_Sports_Record>student_sports_record=new HashSet<Student_Sports_Record>();
public Set<Student_Sports_Record> getStudent_sports_record() {
	return student_sports_record;
}
public void setStudent_sports_record(Set<Student_Sports_Record> student_sports_record) {
	this.student_sports_record = student_sports_record;
}
}
