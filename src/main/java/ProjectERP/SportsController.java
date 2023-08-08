package ProjectERP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProjectERP.Models.Student_Sports_Record;
import ProjectERP.Models.sports;
import ProjectERP.ViewModels.Course_View;
import ProjectERP.repository.Sports_Repository;
import ProjectERP.repository.Student_Sports_Record_Repository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class SportsController {
	@Autowired Sports_Repository sportsrepo;
	
	@RequestMapping("/sports")
    public List<sports>GetSports(){
		return (List<sports>)sportsrepo.findAll();
    }

    @Autowired Student_Sports_Record_Repository studentsportsrepo;
    @RequestMapping("/student/sports_record")
    public List<Student_Sports_Record>GetStudentRecord(){
    	return (List<Student_Sports_Record>)studentsportsrepo.findAll();
    }
    @PostMapping("/student/sports_record")
    public String AddData(@RequestBody Student_Sports_Record ssr) {
    	System.err.println("inside the post method");
    	System.out.println(ssr.getStudent_sports_id()+" "+ssr.getSports_record().getSports_id()+" "+ssr.getStudent_name()+" "+ssr.getJoining_date()+" "+ssr.getDate_of_birth()+" "+ssr.getStatus());
    	studentsportsrepo.save(ssr);
    	return "added";
    }
    
}
