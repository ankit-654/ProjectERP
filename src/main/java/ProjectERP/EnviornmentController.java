package ProjectERP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProjectERP.Models.Enviornment;
import ProjectERP.repository.Enviornment_Repository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class EnviornmentController {
	@Autowired
	Enviornment_Repository envrepo;

	@GetMapping("/enviornment")
	public List<Enviornment>GetActivityList(){
		return (List<Enviornment>)envrepo.findAll();
	}
	@PostMapping("/enviornment")
	public String AddACtivitiesofEnviornment(@RequestBody Enviornment e) {
		System.out.println("inside the post method");
		System.out.println(e.getActivity_id()+" "+e.getActivity_name()+" "+e.getTotal_group()+" "+e.getActivity_date()+" "+e.getTotal_strength()+" "+e.getStatus());
		envrepo.save(e);
		return "Added";
	}
}
