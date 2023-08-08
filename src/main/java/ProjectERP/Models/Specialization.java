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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "tblspecializations")
public class Specialization {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int specialization_id;
	private String specialization_name;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinColumn(name = "qualification_id",referencedColumnName = "qualification_id")
	@JsonIgnoreProperties("qualification")
	private Qualification qualification;

	
	public Specialization(int specialization_id, String specialization_name, Qualification qualification) {
		super();
		this.specialization_id = specialization_id;
		this.specialization_name = specialization_name;
		this.qualification = qualification;
	}
	public Qualification getQualification() {
		return qualification;
	}
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}
	private int flag;
	public Specialization() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Specialization(String specialization_name, Qualification qualification, int flag) {
		super();
		this.specialization_name = specialization_name;
		this.qualification = qualification;
		this.flag = flag;
	}
	public int getSpecialization_id() {
		return specialization_id;
	}
	public void setSpecialization_id(int specialization_id) {
		this.specialization_id = specialization_id;
	}
	public String getSpecialization_name() {
		return specialization_name;
	}
	public void setSpecialization_name(String specialization_name) {
		this.specialization_name = specialization_name;
	}

	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "specialization",cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("specialization")
	private Set<Student_Qualifications>studentqualifications=new HashSet<Student_Qualifications>();
	public Set<Student_Qualifications> getStudentqualifications() {
		return studentqualifications;
	}
	public void setStudentqualifications(Set<Student_Qualifications> studentqualifications) {
		this.studentqualifications = studentqualifications;
	}
}
