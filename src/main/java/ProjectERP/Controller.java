	package ProjectERP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ProjectERP.uploads.FileStorageService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class Controller {
	@RequestMapping("/first")
	public String App() {
		return "welcome";
	}

	
	 private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	 @Autowired
	    private FileStorageService fileStorageService;
	 
	 @PostMapping("/uploadFile")
	    public String uploadFile(@RequestParam("file") MultipartFile file) {
	        String fileName = fileStorageService.storeFile(file);
return "File Uplaoded Successfully";
	    }
	 
	 //// 
//	 @Autowired
//	 DataRepository data;	
	 @RequestMapping("/data")
	 
//	 public List<Data> GetData() {
//		 List<Data>lst=new ArrayList<Data>();
////		 Data d1=new Data();
//		return lst;
//	 }
	 
//	  Hardcoded Data
	 @PostMapping("/upload")
	 public String AddData(@RequestParam("file") MultipartFile uploadfile,@RequestParam("address")String address,@RequestParam("name")String name) {
		 	System.out.println("Hi Hello");
	        String fileName = fileStorageService.storeFile(uploadfile);
	        System.out.println(fileName);
	        System.out.println(name+" "+address);
	        return "File Uplaoded Successfully";
		 

	 }
//	 
//	 @PostMapping("/data")
//	 public String AddData(@RequestParam("file") MultipartFile file,@RequestBody Data d) {
//		 	System.out.println("Hi Hello");
//	        String fileName = fileStorageService.storeFile(file);
//	        System.out.println(fileName);
//	        System.out.println(d.getName()+" "+d.getAddress());
//	        return "File Uplaoded Successfully";
//		 
//
//	 }
	 
}
