package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "tblqualifications")
public class Qualification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qualification_id;
	private String qualification_name;
	private int flag;
	public Qualification(String qualification_name, int flag) {
		super();
		this.qualification_name = qualification_name;
		this.flag = flag;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Qualification(String qualification_name) {
		super();
		this.qualification_name = qualification_name;
	}
	
	public Qualification(int qualification_id, String qualification_name) {
		super();
		this.qualification_id = qualification_id;
		this.qualification_name = qualification_name;
	}
	public int getQualification_id() {
		return qualification_id;
	}
	public void setQualification_id(int qualification_id) {
		this.qualification_id = qualification_id;
	}
	public String getQualification_name() {
		return qualification_name;
	}
	public void setQualification_name(String qualification_name) {
		this.qualification_name = qualification_name;
	}
	public Qualification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Set<Specialization> getSpecializations() {
		return specializations;
	}
	public void setSpecializations(Set<Specialization> specializations) {
		this.specializations = specializations;
	}
	
    @OneToMany(mappedBy = "qualification", fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("qualification")
	private Set<Specialization>specializations=new HashSet<>();
	
}
