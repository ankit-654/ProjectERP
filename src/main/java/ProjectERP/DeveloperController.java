
package ProjectERP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ProjectERP.Models.*;
import ProjectERP.ViewModels.Contents_View;
import ProjectERP.ViewModels.Course_Fees_View;
import ProjectERP.ViewModels.Course_Module_View;
import ProjectERP.ViewModels.Course_View;
import ProjectERP.ViewModels.Module_Topic_View;
import ProjectERP.ViewModels.Module_View;
import ProjectERP.ViewModels.Topic_View;
import ProjectERP.ViewRepository.Contents_View_Repository;
import ProjectERP.ViewRepository.Course_Fees_View_Repository;
import ProjectERP.ViewRepository.Course_Module_View_Repository;
import ProjectERP.ViewRepository.Course_ViewRepository;
import ProjectERP.ViewRepository.Module_Topic_View_Repository;
import ProjectERP.ViewRepository.Module_View_Repository;
import ProjectERP.ViewRepository.Topic_View_Repository;
import ProjectERP.repository.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class DeveloperController {
	///     **** tblTraining_Courses Controller
	@Autowired
	Training_Courses_Repository trcorepo;
	
	@Autowired
	Course_ViewRepository vw_trainingrepo;
	@GetMapping("/api/trainingcourses")
		public List<Course_View>GetTrainingCourse(){
		return (List<Course_View>)vw_trainingrepo.findAll();
	}
	/// Filter View Repo
		@GetMapping("/api/filtertrainingcourses/{ch}")
		public List<Course_View>FilterTrainingCourse(@PathVariable("ch") String ch){
			List<Course_View> lst=new ArrayList<Course_View>();
			List<Course_View>st=(List<Course_View>)vw_trainingrepo.findAll();
			for(Course_View c:st) {
				if(c.getCourse_name().toLowerCase().contains(ch.toLowerCase())) {
					Course_View cv=new Course_View(c.getCourse_id(),c.getCourse_name(), c.getCourse_code(), c.getTechnology_id(), c.getTechnology_name(),c.getCourse_fees(), c.getFee_mode_id(), c.getFee_mode());
					lst.add(cv);
				}
			}
			return lst;
	}
		///// FOR VIEW ////////////////////////////////////////////////////////////
		@GetMapping("/courseinfo")
		public List<Training_courses>getCourseInfo(){
			List<Training_courses>lst=new ArrayList<Training_courses>();

            for(Training_courses t:(List<Training_courses>)trcorepo.findAll()) {
            	t.setStudent_registration_details(null);
                          
            	lst.add(t);
            }
            return lst;
		}
	
	@PostMapping("/api/trainingcourses")
	public String AddTrainingCourses(@RequestBody Training_courses tc) {
		System.out.println("Inside Post Method");
		System.out.println(tc.getCourse_code()+" "+tc.getCourse_fees()+" "+tc.getCourse_name()+" "+tc.getTechnology().getTechnology_id()+" "+tc.getFeemode().getFee_mode_id());
//		Training_courses t1=new Training_courses(tc.getCourse_name(),tc.getCourse_code(),tc.getTechnology(),tc.getCourse_fees(),tc.getFeemode());
 		trcorepo.save(tc);
		return "added";
	}

	@GetMapping("/courseinfo/{id}")
	public Training_courses GetCourseById(@PathVariable("id") int id) {
		return trcorepo.findById(id).get();
	}



	///     **** tblTraining_Modules Controller
	@Autowired
	Training_Modules_Repository trmorepo;
	
	@Autowired
	Module_View_Repository moduleviewrepo;
	@RequestMapping("/trainingmodules")
	public List<Module_View>GetTrainingModules(){
		List<Module_View>lst=new ArrayList<>();
		List<Module_View>st=(List<Module_View>)moduleviewrepo.findAll();
		for (Module_View t:st) {
			lst.add(t);
		}
		return lst;
	}
	
	@GetMapping("/filtermodule/{ch}")
	public List<Module_View>FilterModule(@PathVariable ("ch") String ch){
		List<Module_View>lst=new ArrayList<Module_View>();
		for(Module_View m:(List<Module_View>)moduleviewrepo.findAll()) {
			if(m.getModule_name().toLowerCase().contains(ch.toLowerCase())) {
				Module_View mv=new Module_View(m.getModule_id(),m.getModule_name());
				lst.add(mv);
			}
			}
		return lst;
	}
	
	//// View Modules on Click 
	@RequestMapping("/moduletopics")
	public List<Training_Modules>GetTrainingModulesByName(){
		List<Training_Modules>lst=new ArrayList<>();

		for (Training_Modules t:(List<Training_Modules>)trmorepo.findAll()) {
			t.setCoursemodule(null);
			lst.add(t);
	   }
		return lst;
	}
	
//////////////////////////////////////////////////////////////////////////////
	
	 @PostMapping("/trainingmodules")
	 public String AddTrainingModules(@RequestBody Training_Modules trm) {
		 Training_Modules t1=new Training_Modules(trm.getModule_name());
		 trmorepo.save(t1);
		 return "Added";
	 }
	 @PutMapping("/trainingmodules")
	 public String UpdateTrainingModules(@RequestBody Training_Modules trm) {
		 trmorepo.save(trm);
		 return "Update";
	 }
	 @GetMapping("/trainingmodules/{id}")
	 public Optional<Training_Modules> GetTrainingModulesById(@PathVariable ("id") int id) {
		 return trmorepo.findById(id);
		 }
	 
	 @DeleteMapping("/deletemodules/{id}")
	 public String DeleteModules(@PathVariable ("id") int id) {
		 trmorepo.deleteById(id);
		 return "Deleted";
	 }
	 

	///     **** Training_Topics Controller
	@Autowired
	Training_Topics_Repository trtorepo;
	
	@Autowired
	Topic_View_Repository topicviewrepo;
	@RequestMapping("/trainingtopics")
	public List<Topic_View>GetTrainingTopics(){
		List<Topic_View>lst=new ArrayList<>();
		List<Topic_View>st=(List<Topic_View>)topicviewrepo.findAll();
		for(Topic_View t:st) {
//			t.setTrainingtopics(null);
			lst.add(t);
		}
		return lst;
	}
	///////View CLick /////////////////////////////////////////////////
	@GetMapping("/topic_content")
	public List<Training_Topics>gettopiccontent(){
		List<Training_Topics>lst=new ArrayList<Training_Topics>();
		for(Training_Topics t:(List<Training_Topics>)trtorepo.findAll()) {
		
			lst.add(t);
		}
		return lst;
	}
	
	@RequestMapping("/filtertopics/{ch}")
	public List<Topic_View>GetTrainingTopicsByName(@PathVariable("ch") String ch){
		List<Topic_View>lst=new ArrayList<>();
		List<Topic_View>st=(List<Topic_View>)topicviewrepo.findAll();
		for(Topic_View t:st) {
//			t.setTrainingtopics(null);
			if(t.getTopic_name().toLowerCase().contains(ch.toLowerCase())) {
				Topic_View t1=new Topic_View(t.getTopic_id(),t.getTopic_name()); 
				lst.add(t1);
			}
			
		}
		return lst;
	}
	  
	@RequestMapping("/content_topic")
	public List<Training_Topics>GetTopicContentByName(){
		List<Training_Topics>lst=new ArrayList<>();
		for(Training_Topics t:(List<Training_Topics>)trtorepo.findAll()) {
            t.setTraining_module_topic(null);			
				lst.add(t);
			}
		return lst;
	}
	
	@PostMapping("/trainingtopics")
	public String AddTrainingTopics(@RequestBody Training_Topics trt) {
		 Training_Topics t1=new Training_Topics(trt.getTopic_name());
		 trtorepo.save(t1);
		 return "Added";
	}
	@PutMapping("/trainingtopics")
	public String updateTrainingTpics(@RequestBody Training_Topics trt) {
		 trtorepo.save(trt);
		 return "Update";
	}
	@GetMapping("/trainingtopics/{id}")
	public Optional<Training_Topics> GetTrainingTopicsById(@PathVariable ("id") int id) {
		 return trtorepo.findById(id);
		 }

	@DeleteMapping("/deletetopics/{id}")
	public String DeleteTopics(@PathVariable ("id") int id) {
		 trtorepo.deleteById(id);
		 return "Deleted";
	}


	///     **** Topic Content Controller
@Autowired
Topic_Content_Repository tocorepo;

@Autowired
Contents_View_Repository contents_view_repo;
	@RequestMapping("/topiccontent")
	public List<Contents_View>GetTrainingTopic(){
		List<Contents_View>lst=new ArrayList<Contents_View>();
		List<Contents_View>st=(List<Contents_View>)contents_view_repo.findAll();
		for(Contents_View t:st) {
//			t.getTraining_topic().setTrainingtopics(null);
//            t.getTraining_topic().setTopicontents(null);
			lst.add(t);
		}
		return lst;
	}
	
	///// Topic Content View on Click
//	@GetMapping("/topic_content")
//	public List<Topic_Content>gettopiccontent(){
//		List<Topic_Content>lst=new ArrayList<Topic_Content>();
//		for(Topic_Content t:(List<Topic_Content>)tocorepo.findAll()) {
//			t.setTopic_content(null);
//			lst.add(t);
//		}
//		return lst;
//	}
	
	@RequestMapping("/filtercontent/{ch}")
	public List<Contents_View>GetTrainingTopicByName(@PathVariable("ch") String ch){
		List<Contents_View>lst=new ArrayList<Contents_View>();
		for(Contents_View t:(List<Contents_View>)contents_view_repo.findAll()) {
			if(t.getContent_name().toLowerCase().contains(ch.toLowerCase())) {
				Contents_View cv=new Contents_View(t.getContent_id(),t.getContent_name(),t.getTopic_id(),t.getTopic_name());
				lst.add(cv);
            }
		}
		return lst;
	}

	@PostMapping("/topiccontent")
	public String AddTopicContents(@RequestBody Topic_Content cv) {
		System.out.println("inside the post method");
		System.out.println(cv.getContent_id()+" "+cv.getContent_name()+" "+cv.getTopic_content().getTopic_name());
		tocorepo.save(cv);
		return "added";
	}
	
	// **** Training Course Module
	@Autowired
	Training_Course_Module_Repository trcomorepo;
	
	@Autowired
	Course_Module_View_Repository course_module_view_repo;
	@GetMapping("/coursemodule")
	public List<Course_Module_View>GetCourseModules(){	
	return (List<Course_Module_View>) course_module_view_repo.findAll();	
	}

	@GetMapping("/coursemodule/{id}")
	public Training_Course_Module GetCourseModuleById(@PathVariable("id") int id) {
		return trcomorepo.findById(id).get();
	}
    
	@GetMapping("/filter_course_module/{ch}")
	public List<Course_Module_View>GetCourseModulesByName(@PathVariable("ch") String ch){
	List<Course_Module_View>lst=new ArrayList<Course_Module_View>();
	for(Course_Module_View t:(List<Course_Module_View>)course_module_view_repo.findAll()) {
		if(t.getCourse_name().toLowerCase().contains(ch.toLowerCase())) {
			Course_Module_View t1=new Course_Module_View(t.getCourse_module_id(),t.getCourse_id(),t.getCourse_name(),t.getModule_id(),t.getModule_name());
 	    lst.add(t1);
		}
	}
	return lst;	
	}
    
	@PostMapping("/coursemodule")
	public String AddTrainingCourseModules(@RequestBody Training_Course_Module tcm) {
		System.out.println("inside post method");
		System.out.println(tcm.getCourse_code()+" "+tcm.getTraining_course_module().getCourse_id()+" "+tcm.getTraining_modules().getModule_id());;
//		 Training_Course_Module t1=new Training_Course_Module(tcm.getCourse_module_id(),tcm.getCourse_code(),tcm.getTraining_course_module(),tcm.getTraining_modules());
		 trcomorepo.save(tcm);
		 return "Added";
	}
	
	///     **** tblTraining_Module_topic Controller
	@Autowired
	Training_Module_Topic_Repository trmotorepo;
	
	@Autowired
	Module_Topic_View_Repository motopicviewrepo;
	@RequestMapping("/moduletopic")
	public List<Module_Topic_View>GetTrainingModuleTopic(){
		return (List<Module_Topic_View>)motopicviewrepo.findAll();
	}
	
	@GetMapping("/moduletopic/{id}")
	public Training_Module_topic GetModuleTopicById(@PathVariable("id") int id) {
		return trmotorepo.findById(id).get();
	}
	
	
	@PostMapping("/moduletopic")
	public String AddModuleTopic(@RequestBody Training_Module_topic tmt) {
		System.out.println("inside method");
		System.out.println(tmt.getModule_topic_id()+" "+tmt.getModules().getModule_name()+" "+tmt.getTraining_topic().getTopic_name());
		trmotorepo.save(tmt);
		return "added";
	}
	@RequestMapping("/filtermodule_topic/{ch}")
	public List<Module_Topic_View>GetFilterModuleTopic(@PathVariable("ch") String ch){
		List<Module_Topic_View>lst=new ArrayList<Module_Topic_View>();
		for(Module_Topic_View m:(List<Module_Topic_View>)motopicviewrepo.findAll()) {
			if(m.getTopic_name().toLowerCase().contains(ch.toLowerCase())) {
				Module_Topic_View mtv=new Module_Topic_View(m.getModule_topic_id(),m.getModule_id(),m.getModule_name(),m.getTopic_id(),m.getTopic_name());
				lst.add(mtv);
			}
		}
		return lst;
	}
	

	/// ** Training Course Fee
	
    @Autowired
    Training_Course_Fee_Repository trcoferepo;
    
    @Autowired
    Course_Fees_View_Repository course_fee_view_repo;

	@GetMapping("/coursefees")
	public List<Course_Fees_View>GetCourseFees(){
		return (List<Course_Fees_View>)course_fee_view_repo.findAll();
	}

	@PostMapping("/coursefees")
	public String AddCourseFees(@RequestBody Training_Course_Fees tcf) {
		System.out.println("inside the method");
		System.out.println(tcf.getCourse_fee_id()+" "+tcf.getAmount());
		trcoferepo.save(tcf);
		return "added";
	}
}
