package ProjectERP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProjectERP.Models.City;
import ProjectERP.Models.Designation;
import ProjectERP.Models.Exam_Levels;
import ProjectERP.Models.Fee_Mode;
import ProjectERP.Models.Lead_Source;
import ProjectERP.Models.Location;
import ProjectERP.Models.Qualification;
import ProjectERP.Models.Specialization;
import ProjectERP.Models.State;
import ProjectERP.Models.Technology;
import ProjectERP.ViewModels.City_View;
import ProjectERP.ViewModels.Designation_View;
import ProjectERP.ViewModels.Examlevel_View;
import ProjectERP.ViewModels.Feemode_View;
import ProjectERP.ViewModels.Lead_Source_View;
import ProjectERP.ViewModels.Location_View;
import ProjectERP.ViewModels.Qualification_View;
import ProjectERP.ViewModels.Specialization_View;
import ProjectERP.ViewModels.State_View;
import ProjectERP.ViewModels.Technologies_View;
import ProjectERP.ViewRepository.City_View_Repository;
import ProjectERP.ViewRepository.Designation_View_Repository;
import ProjectERP.ViewRepository.Examlevels_View_Repository;
import ProjectERP.ViewRepository.Feemode_View_Repository;
import ProjectERP.ViewRepository.Lead_Source_View_Repository;
import ProjectERP.ViewRepository.Location_View_Repository;
import ProjectERP.ViewRepository.Qualification_View_Repository;
import ProjectERP.ViewRepository.Specialization_View_Repository;
import ProjectERP.ViewRepository.State_View_Repository;
import ProjectERP.ViewRepository.Technologies_View_Repository;
import ProjectERP.repository.CityRepository;
import ProjectERP.repository.Designation_Repository;
import ProjectERP.repository.Exam_Level_Repository;
import ProjectERP.repository.Fee_Mode_Repository;
import ProjectERP.repository.Lead_Source_Repository;
import ProjectERP.repository.Location_Repository;
import ProjectERP.repository.Qualification_Repository;
import ProjectERP.repository.Specialization_Repository;
import ProjectERP.repository.StateRepository;
import ProjectERP.repository.Technology_Repository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
	
public class MasterController {
	@Autowired
	Specialization_Repository tblspecrepo;

	@Autowired
	Qualification_Repository qualrepo;

	@Autowired
	StateRepository strepo;
	@Autowired
	CityRepository ctrepo;

	@Autowired
	Lead_Source_Repository lsrepo;



	///     **** StateCity Controller
//	@RequestMapping("/state")
//	public List<State>GetState(){
//		return (List<State>)strepo.findAll();
//	}

	@RequestMapping("/filterstate/{ch}")
	public List<State>GetStateByName(@PathVariable("ch") String ch){
		
		List<State>lst=new ArrayList<>();
		List<State>allst=(List<State>) staterepo.findAll();
		for(State s:allst) {
			if(s.getState_name().toLowerCase().contains(ch.toLowerCase())) {
			State s1=new State(s.getState_id(),s.getState_name(),0);
			lst.add(s1);
			}
		}
		return lst;
	}


	@PostMapping("/state")
	public String AddState(@RequestBody State st) {
		State s=new State(st.getState_id(),st.getState_name(),0);
		strepo.save(s);
		for(City c:st.getCities())
		{
			City c1=new City(c.getCity_name(), 0, s);
			ctrepo.save(c1);
		}
		return "Added Succesfully";
	}

	@GetMapping("/state/{id}")
	public State GetStateById(@PathVariable("id") int id) {
		return strepo.findById(id).get();
	}

	@DeleteMapping("/deletestate/{id}")
	public String DeleteState(@PathVariable("id") int id) {
		State s=strepo.findById(id).get();
		strepo.delete(s);
		return "Deleted Succesfully";
	}


	///     **** Qualification-Specialization Controller

	@Autowired
	Qualification_View_Repository qualviewrepo;
	@RequestMapping("/qualification")
	public List<Qualification_View>GetQualification(){
		return (List<Qualification_View>)qualviewrepo.findAll();
	}
	
	@RequestMapping("/filterqualification/{ch}")
	public List<Qualification>GetQualificationByName(@PathVariable ("ch") String ch){
		List<Qualification>lst=new ArrayList<>();
		List<Qualification>st=(List<Qualification>)qualrepo.findAll();
		for(Qualification q:st) {
			if(q.getQualification_name().toLowerCase().contains(ch.toLowerCase())) {
				Qualification q1=new Qualification(q.getQualification_id(),q.getQualification_name());
				lst.add(q1);
			}
		}
		return lst;
		
		//return (List<Qualification>)qualrepo.findAll();
	}
	
	@PostMapping("/qualification")
	public String AddQualification(@RequestBody Qualification qu) 
	    {
		Qualification q=new Qualification(qu.getQualification_name());
	    qualrepo.save(q);
	    for(Specialization s:qu.getSpecializations()) 
	    {
	    	Specialization s1=new Specialization(s.getSpecialization_name(), q, 0);
	    	tblspecrepo.save(s1);
	    }
	    return "data added succesfully";
	}

	@GetMapping("/qualification/{id}")
	public Qualification GetById(@PathVariable("id") int id) {
		return qualrepo.findById(id).get();
	}

	@DeleteMapping("/deletequalification/{id}")
	public String Delete(@PathVariable("id") int id) {
	    Qualification q=qualrepo.findById(id).get();
		qualrepo.delete(q);
	return "Deleted Successfully";
	}
	@PutMapping("/qualification")
	public String UpdateQualification(@RequestBody Qualification qu) {
		Qualification q=qualrepo.save(qu);
		qualrepo.save(qu);
		return "Qualification Updated";
	}


	/// *** Lead Source Repository
	
	@Autowired
	Lead_Source_View_Repository leadrepo;
	@RequestMapping("/sources")
	public List<Lead_Source_View>GetSources(){
		return (List<Lead_Source_View>)leadrepo.findAll();
	}
	
	@GetMapping("/filtersoures/{ch}")
	public List<Lead_Source>getSourceByName(@PathVariable ("ch") String ch){
		List<Lead_Source>lst=new ArrayList<Lead_Source>();
		List<Lead_Source>st=(List<Lead_Source>)lsrepo.findAll();
		for(Lead_Source l:st) {
			if(l.getSource_name().toLowerCase().contains(ch.toLowerCase())) {
				Lead_Source l1=new Lead_Source(l.getSource_id(),l.getSource_name(),0);
				lst.add(l1);
			}
		}
		return lst;
	}
	
	@PostMapping("/sources")
	public String AddSources(@RequestBody Lead_Source ls) {
		Lead_Source l=new Lead_Source(0, ls.getSource_name(), 0);
		lsrepo.save(l);
		return "Added Succesfully";
	}
	@GetMapping("/sources/{id}")
	public Lead_Source GetSourceById(@PathVariable("id") int id) {
		return lsrepo.findById(id).get();
	}

	@DeleteMapping("/sources/{id}")
	public String DeleteSource(@PathVariable("id") int id) {
		lsrepo.deleteById(id);
		return "Deleted succesfully";
	}
	 
	@PutMapping("/sources")
	public String UpdateStudent(@RequestBody Lead_Source ls) {
		lsrepo.save(ls);
		
		return "Updated Succesfully";
	}

	/// *** Technologies Repository
	@Autowired
	Technology_Repository techrepo;
	
	@Autowired
	Technologies_View_Repository techviewrepo;
	@RequestMapping("/technologies")
	public List<Technologies_View>GetTechnology(){
		List<Technologies_View>lst=new ArrayList<>();
		List<Technologies_View>st=(List<Technologies_View>)techviewrepo.findAll();
		for(Technologies_View t:st) {
			lst.add(t);
		}
		return lst;
	}
	
	@RequestMapping("/filtertechnology/{ch}")
	public List<Technology>GetTechnologyByName(@PathVariable ("ch") String ch){
		List<Technology>lst=new ArrayList<>();
		List<Technology>st=(List<Technology>)techrepo.findAll();
		
		for(Technology t:st) {
			if(t.getTechnology_name().toLowerCase().contains(ch.toLowerCase())) {
				Technology t1=new Technology(t.getTechnology_id(),t.getTechnology_name(),0); 
//			t.setTraining_courses(null);
			lst.add(t1);
			}
		}
		return lst;
	}


	@PostMapping("/technologies")
	public String AddTechnologies(@RequestBody Technology tech) {
		Technology t=new Technology(0,tech.getTechnology_name(), 0);
		techrepo.save(t);
		return "added";
	}
	@GetMapping("/technologies/{id}")
	public Optional<Technology> GetTechById(@PathVariable("id") int id) {
		return techrepo.findById(id);
	}

	@DeleteMapping("/deletetechnologies/{id}")
	public String DeleteTechnologies(@PathVariable("id") int id) {
		techrepo.deleteById(id);
		return "Deleted succesfully";
	}
	 
	@PutMapping("/technologies")
	public String UpdateTechnologies(@RequestBody Technology t) {
		techrepo.save(t);
		
		return "Updated Succesfully";
	}

	/// *** Fee_Mode Repository
	@Autowired
	Fee_Mode_Repository feerepo;
	@Autowired
	Feemode_View_Repository feeviewrepo;
	@GetMapping("/feemode")
	public List<Feemode_View>GetFeemode(){
		return (List<Feemode_View>)feeviewrepo.findAll();
				
	}

	@RequestMapping("/filterfeemode/{ch}")
	public List<Fee_Mode>GetFeeModeByName(@PathVariable ("ch") String ch){
		List<Fee_Mode>lst=new ArrayList<>();
		List<Fee_Mode>st=(List<Fee_Mode>)feerepo.findAll();
		for (Fee_Mode f:st) {
			if(f.getFee_mode().toLowerCase().contains(ch.toLowerCase())) {
				Fee_Mode f1=new Fee_Mode(f.getFee_mode_id(),f.getFee_mode(),0);
				lst.add(f1);
			}
		}
		return lst;
	}
	
	@PostMapping("/feemode")
	public String AddFeeMode(@RequestBody Fee_Mode fm) {
		Fee_Mode f=new Fee_Mode(0,fm.getFee_mode(),0);
		feerepo.save(f);
		return "Added";
	}
	@GetMapping("/feemode/{id}")
	public Optional<Fee_Mode> GetModeById(@PathVariable ("id") int id) {
		return feerepo.findById(id);
	}
	@DeleteMapping("/delete_fee_mode/{id}")
	public String Delete_Fee_Mode(@PathVariable ("id") int id) {
		feerepo.deleteById(id);
		return "Deleted";
	}

	@PutMapping("/feemode")
	public String UpdateFeeMode(@RequestBody Fee_Mode fm) {
		feerepo.save(fm);
		return "updated";
	}

	/// *** Designations Repository
	@Autowired
	Designation_Repository desigrepo;
	
	@Autowired
	Designation_View_Repository desigviewrepo;
	@RequestMapping("/designation")
	public List<Designation_View>GetDesignations(){
		return (List<Designation_View>)desigviewrepo.findAll();
	}
	
	@RequestMapping("/filterdesignation/{ch}")
	public List<Designation>GetDesignationsByName(@PathVariable ("ch") String ch){
		List<Designation>lst=new ArrayList<Designation>();
		List<Designation>st=(List<Designation>)desigrepo.findAll();
		for(Designation d:st) {
			if(d.getDesignation_name().toLowerCase().contains(ch.toLowerCase())) {
				Designation d1=new Designation(d.getDesignation_id(),d.getDesignation_name(),d.getFlag());
				lst.add(d1);
			}
		}
		
		return lst;
	}
	
	@PostMapping("/designation")
	public String AddDesignation(@RequestBody Designation desig) {
		Designation d1=new Designation(0,desig.getDesignation_name(),0);
		desigrepo.save(d1);
		return "Added";
	}

	@GetMapping("/designation/{id}")
	public Optional<Designation> GetDesignationById(@PathVariable ("id") int id) {
		return desigrepo.findById(id);
	}
	@DeleteMapping("/deletedesignation/{id}")
	public String DeleteDesigantion(@PathVariable ("id") int id) {
		desigrepo.deleteById(id);
		return "deleted";
	}
	@PutMapping("/designation")
		public String UpdateDesigantion(@RequestBody Designation d) {
			desigrepo.save(d);
			return "Updated";
		
	}
	/// *** Exam_Levels Repository
	@Autowired
	Exam_Level_Repository examlevelrepo;
	
	@Autowired
	Examlevels_View_Repository levelviewrepo;
	@RequestMapping("/examlevels")
	public List<Examlevel_View>GetExamLevels(){
		return (List<Examlevel_View>)levelviewrepo.findAll();
	}
	
	@RequestMapping("/filterexamlevels/{ch}")
	public List<Exam_Levels>GetExamLevelsByName(@PathVariable("ch") String ch){
		List<Exam_Levels>lst=new ArrayList<Exam_Levels>();
		List<Exam_Levels>st=(List<Exam_Levels>)examlevelrepo.findAll();
		for(Exam_Levels e:st) {
			if(e.getLevel_name().toLowerCase().contains(ch.toLowerCase())) {
				Exam_Levels e1=new Exam_Levels(e.getLevel_id(),e.getLevel_name(),e.getFlag());
				lst.add(e1);
			}
		}
		return lst;
	}
	
	@PostMapping("/examlevels")
	public String AddExamLevels(@RequestBody Exam_Levels ex) {
		Exam_Levels e1=new Exam_Levels(0,ex.getLevel_name(),0);
		examlevelrepo.save(ex);
		return "added";
	}
	@GetMapping("/examlevels/{id}")
	public Optional<Exam_Levels> GetExamLevelById(@PathVariable ("id") int id) {
		return examlevelrepo.findById(id);
	}
	@DeleteMapping("/deleteexamlevel")
	public String DeleteExamLeves(@PathVariable ("id") int id) {
		examlevelrepo.deleteById(id);
		return "deleted";
	}
	@PutMapping("/examlevels")
	public String UpdateExamLevels(@RequestBody Exam_Levels ex) {
		examlevelrepo.save(ex);
		return "updated";
	}


	/// *** Specialization Repository


	@Autowired
	Specialization_Repository specirepo;
    @Autowired
    Specialization_View_Repository specviewrepo;


	@PostMapping("/specialization")
	public String AddSpecialization(@RequestBody Specialization sp) {
		Specialization sp1=new  Specialization(sp.getSpecialization_name(),sp.getQualification(),0);
		specirepo.save(sp1);
		return "added";
	}


	@GetMapping("/specialization")
	public List<Specialization_View>GetSpecializations(){
	
		return (List<Specialization_View>)specviewrepo.findAll();
	}
	@GetMapping("/filterspecialization/{ch}")
	public List<Specialization>GetSpecializationsByName(@PathVariable ("ch") String ch){
		
		List<Specialization>lst=new ArrayList<>();
		List<Specialization>allsp=(List<Specialization>) specirepo.findAll();
		for(Specialization s :allsp)
			{
			if(s.getSpecialization_name().toLowerCase().contains(ch.toLowerCase())) {
			Qualification q=new Qualification(s.getQualification().getQualification_id(), s.getQualification().getQualification_name());
			Specialization sp=new Specialization(s.getSpecialization_id(), s.getSpecialization_name(),q);
			lst.add(sp);
			}	
			}
		return lst;
	}

	/// *** State Repository
	@Autowired
	StateRepository staterepo;
	@Autowired
	State_View_Repository stateviewrepo;
	@GetMapping("/states")
	public List<State_View>Getstate(){
		return (List<State_View>) stateviewrepo.findAll();
	}

	/// *** City Repository
	@Autowired
	CityRepository citiesrepo;

	@Autowired 
	City_View_Repository cityviewrepo;
	@GetMapping("/cities")
	public List<City_View>Getcities(){
		
		List<City_View>lst=new ArrayList<>();
		List<City_View>allsp=(List<City_View>) cityviewrepo.findAll();
		for(City_View c :allsp)
			{
			lst.add(c);
				
			}
		return lst;
	}

	@GetMapping("/filtercities/{ch}")
	public List<City>GetcitieByName(@PathVariable("ch") String ch){
		
		System.out.println(ch);
		List<City>lst=new ArrayList<>();
		List<City>allsp=(List<City>) citiesrepo.findAll();
		for(City c :allsp)
			{
			if(c.getCity_name().toLowerCase().contains(ch.toLowerCase()))
			{
			State s=new State(c.getState().getState_id(),c.getState().getState_name(),0);
			City c1=new City(c.getCity_id(),c.getCity_name(),s);
			lst.add(c1);
			}	
			}
		return lst;
	}

	@PostMapping("/cities")
	public String AddCities(@RequestBody City c) {
		City c1=new  City(c.getCity_name(),0,c.getState());
		citiesrepo.save(c1);

		return "added";
	}
	
	/// Location REpository
	@Autowired
	Location_Repository lorepo;
	
	///for view
	@Autowired
	Location_View_Repository loviewrepo;
	
	@GetMapping("/location")
	public List<Location_View> GetLocations(){
		return (List<Location_View>)loviewrepo.findAll();
	}
	@PostMapping("/location")
	public String AddLocation(@RequestBody Location l) {
		System.out.println("inside Post Method");
		System.out.println(l.getLocation_id()+" "+l.getLocation_name());
		lorepo.save(l);

		return "added";
	}

}
