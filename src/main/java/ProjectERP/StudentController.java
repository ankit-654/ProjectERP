package ProjectERP;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ProjectERP.Models.Login_Activities;
import ProjectERP.Models.Student_Break__Details;
import ProjectERP.Models.Student_Details;
import ProjectERP.Models.Student_Payment_Details;
import ProjectERP.Models.Student_Qualifications;
import ProjectERP.Models.Student_Registration_Details;
import ProjectERP.Models.Training_courses;
import ProjectERP.repository.Login_Activities_Repository;
import ProjectERP.repository.Student_Break_Repository;
import ProjectERP.repository.Student_Details_Repository;
import ProjectERP.repository.Student_Payment_Repository;
import ProjectERP.repository.Student_Qualification_Repository;
import ProjectERP.repository.Student_Registration_Repository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class StudentController {
	
@Autowired
Student_Details_Repository studderepo;

@GetMapping("/api/details")
public List<Student_Details>GetStudentDetails(){
	List<Student_Details>lst=new ArrayList<Student_Details>();

    for(Student_Details t:(List<Student_Details>)studderepo.findAll()) {
    	t.setStudent_registration_details(null);
                   
    	lst.add(t);
    }
	
	
    // to stop looping with child
    
//    for(Student_Details t:studderepo.findAll()) {
//    	Student_Details st=new Student_Details(t.getStudent_id(),t.getStudent_code(),t.getFirst_name(),t.getMiddle_name(),t.getLast_name(),t.getEmail_address(),t.getMobile_number(),t.getAlternative_number(),t.getPhoto(),t.getBirth_date(),t.getPassword(),null, null, null, null);
//   lst.add(st);
//    }
//    
    
    
    return lst;
}
@PostMapping("/api/details")
public String AddStudentDetails(@RequestBody Student_Details st) {
	
	System.out.println("inside the post");
	System.out.println(st.getStudent_id()+" "+st.getStudent_code()+" "+st.getFirst_name()+" "+st.getMiddle_name()+" "+st.getLast_name()+" "+st.getEmail_address()+" "+st.getMobile_number()+" "+st.getAlternative_number()+" "+st.getPhoto()+" "+st.getBirth_date()+" "+st.getPassword()+" "+st.getStudent_location().getLocation_name()+" "+st.getLocal_Address()+" "+st.getPermanent_Address()+" "+st.getStatus());
	studderepo.save(st);
	return "added";
}

//// Student Qualifications
@Autowired Student_Qualification_Repository studqrepo;

@GetMapping("/api/studentqualifications")
public List<Student_Qualifications>GetStudentQualification(){
	return (List<Student_Qualifications>)studqrepo.findAll();
}
@PostMapping("/api/studentqualifications")
public String AddStudentQualifications(@RequestBody Student_Qualifications sq) {
	
	System.out.println("inside the post");
	System.out.println(sq.getStudent_qualification_id()+" "+sq.getStudent_details().getStudent_id()+" "+sq.getSpecialization().getSpecialization_id()+" "+sq.getMedium()+" "+sq.getPassing_year()+" "+sq.getPercentage()+" "+sq.getUniversity()+" "+sq.getStatus());
	studqrepo.save(sq);
	return "added";
}


//// Login Activities
@Autowired Login_Activities_Repository actirepo;

@GetMapping("/api/activities")
public List<Login_Activities>GetLoginActivities(){
return (List<Login_Activities>)actirepo.findAll();
}

@PostMapping("/api/activities")
public String AddActivityDetails(@RequestBody Login_Activities la) {

System.out.println("inside the post");
System.out.println(la.getActivity_id()+" "+la.getActivity_details().getStudent_id()+" "+la.getLogin_time()+" "+la.getLogout_time()+" "+la.getStatus());
actirepo.save(la);
return "added";
}

////Registration Details
@Autowired 
Student_Registration_Repository studrerepo;

@GetMapping("/api/registrations")
public List<Student_Registration_Details>GetRegistrationDetails(){
List<Student_Registration_Details>lst=new ArrayList<Student_Registration_Details>();
//for(Student_Registration_Details t:(List<Student_Registration_Details>)studrerepo.findAll()) {
//	t.getCourse_details().setCoursemodule(null);
//	t.getCourse_details().setTechnology(null);
//	t.getCourse_details().setFeemode(null);;
//	t.setStudent_break_details(null);
//	t.getRegistration_details().setStudent_location(null);
//	t.setBoooksrecord(null);
//	
//	lst.add(t);
//}

for(Student_Registration_Details t:studrerepo.findAll()) {
	Student_Registration_Details srd=new Student_Registration_Details(t.getRegistration_id(),t.getRegistration_code(),t.getRegistration_details().getFirst_name(),t.getCourse_details().getCourse_name(),t.getJoining_date(),t.getDiscount(),t.getDiscount_reason(),t.getCurrent_status(),t.getStatus());
lst.add(srd);
}

return lst;
}

@GetMapping("/api/registrations/{id}")
public Student_Registration_Details GetRegistrationDetailsByID(@PathVariable("id") int id){
	return studrerepo.findById(id).get();
}
@PostMapping("/api/registrations")
public String AddRegistrationDetails(@RequestBody Student_Registration_Details strd) {
	
	System.out.println("inside the post");
	System.out.println(strd.getRegistration_id()+" "+strd.getRegistration_code()+" "+strd.getRegistration_details().getStudent_id()+" "+strd.getCourse_details().getCourse_id()+" "+strd.getJoining_date()+" "+strd.getDiscount()+" "+strd.getDiscount_reason()+" "+strd.getCurrent_status()+" "+strd.getStatus());
	studrerepo.save(strd);
	return "added";
}

//// Payment Details
@Autowired 
Student_Payment_Repository studpayrepo;

@GetMapping("/api/payment")
public List<Student_Payment_Details>GetPaymentDetails(){
return (List<Student_Payment_Details>)studpayrepo.findAll();
}

@GetMapping("/api/payment/{id}")
public Student_Payment_Details GetPaymentDetailsByID(@PathVariable("id") int id){
return studpayrepo.findById(id).get();
}
//@PostMapping("/api/registrations")
//public String AddRegistrationDetails(@RequestBody Student_Registration_Details strd) {
//
//System.out.println("inside the post");
//System.out.println(strd.getRegistration_id()+" "+strd.getRegistration_details().getStudent_id()+" "+strd.getCourse_details().getCourse_id()+" "+strd.getJoining_date()+" "+strd.getDiscount()+" "+strd.getDiscount_reason()+" "+strd.getCurrent_status()+" "+strd.getStatus());
//studrerepo.save(strd);
//return "added";
//}


////Payment Details
@Autowired 
Student_Break_Repository studbrrepo;

@GetMapping("/api/breakdetails")
public List<Student_Break__Details>GetBreakDetails(){
return (List<Student_Break__Details>)studbrrepo.findAll();
}

@GetMapping("/api/breakdetails/{id}")
public Student_Break__Details GetBreakDetailsByID(@PathVariable("id") int id){
return studbrrepo.findById(id).get();
}
//@PostMapping("/api/registrations")
//public String AddRegistrationDetails(@RequestBody Student_Registration_Details strd) {
//
//System.out.println("inside the post");
//System.out.println(strd.getRegistration_id()+" "+strd.getRegistration_details().getStudent_id()+" "+strd.getCourse_details().getCourse_id()+" "+strd.getJoining_date()+" "+strd.getDiscount()+" "+strd.getDiscount_reason()+" "+strd.getCurrent_status()+" "+strd.getStatus());
//studrerepo.save(strd);
//return "added";
//}

}
