package ProjectERP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProjectERP.Models.Book;
import ProjectERP.Models.BooksRecord;
import ProjectERP.Models.Training_courses;
import ProjectERP.ViewModels.Book_Record_View;
import ProjectERP.ViewModels.Book_View;
import ProjectERP.ViewRepository.Book_Record_View_Repository;
import ProjectERP.ViewRepository.Book_View_Repository;
import ProjectERP.repository.BooksRepository;
import ProjectERP.repository.Books_Record_Repository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class BooksController {
	
	
	@Autowired
	BooksRepository bookrepo;
	@Autowired
	Books_Record_Repository bookrecordrepo;
	
	@Autowired
	Book_View_Repository bookviewrepo; 
	@GetMapping("/books")
	public List<Book_View>GetAllBooks(){
		return (List<Book_View>)bookviewrepo.findAll();
	}
	///////////// Crowded Apis For Books
	
	@GetMapping("/book")
	public List<Book> GetAllbooks(){
		List<Book>lst=new ArrayList<Book>();

		for(Book t:(List<Book>)bookrepo.findAll()) {
        	t.setBoooksrecord(null);
        	
                       
        	lst.add(t);
        }
        return lst;
	}
	
	@PostMapping("/books")
	public String AddBooks(@RequestBody Book b) {
		System.out.println("inside the post method");
		System.out.println(b.getBook_id()+" "+b.getBook_name()+" "+b.getAuthor_name());
		bookrepo.save(b);
		return "added";
		
	}
	
	
	//////////////////////////////////////
//	@GetMapping("/books_record")
//	public List<BooksRecord>GetAllRecord(){
//		return (List<BooksRecord>)bookrecordrepo.findAll();
//	}
//	
	
	
	@Autowired
	Book_Record_View_Repository bookviewrecordrepo;
	@GetMapping("/books_record")
	public List<Book_Record_View>GetAllBooksRecordasView(){
		return (List<Book_Record_View>)bookviewrecordrepo.findAll();
	}
	
	///////////// Crowded Apis 
	
	@Autowired
	Books_Record_Repository bookreporepo;
	@GetMapping("/bookrecord")
	public List<BooksRecord>getrecord(){
		List<BooksRecord>lst=new ArrayList<BooksRecord>();

        for(BooksRecord t:(List<BooksRecord>)bookreporepo.findAll()) {
//        	t.getRegd_details().setRegistration_details(null);
        	t.setRegd_details(null);
        
        	lst.add(t);
        }
        return lst;
	}
	
	@PostMapping("/api/books_record")
	public String AddRecordOfBooks(@RequestBody BooksRecord br) {
		System.out.println("inside the post method");
		System.out.println(br.getRecord_id()+" "+br.getBooks().getBook_id()+" "+br.getStudent_name()+" "+br.getStandard()+" "+br.getRegd_details().getRegistration_id()+" "+br.getIssue_date()+" "+br.getSubmit_date());
		bookrecordrepo.save(br);
		return "added";
	}
	
	}
