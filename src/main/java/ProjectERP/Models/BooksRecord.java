package ProjectERP.Models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "books_record")
public class BooksRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int record_id;
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "book_id",referencedColumnName = "book_id")
	@JsonIgnoreProperties("booksrecord")
	private Book books;
	private String student_name;
	private int standard;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "registration_id",referencedColumnName = "registration_id")
	@JsonIgnoreProperties("booksrecord")
	private Student_Registration_Details regd_details;
	public BooksRecord(int record_id, Book books, String student_name, int standard,
			Student_Registration_Details regd_details, String issue_date, String submit_date) {
		super();
		this.record_id = record_id;
		this.books = books;
		this.student_name = student_name;
		this.standard = standard;
		this.regd_details = regd_details;
		this.issue_date = issue_date;
		this.submit_date = submit_date;
	}
	public Book getBooks() {
		return books;
	}
	public void setBooks(Book books) {
		this.books = books;
	}
	public Student_Registration_Details getRegd_details() {
		return regd_details;
	}
	public void setRegd_details(Student_Registration_Details regd_details) {
		this.regd_details = regd_details;
	}
	private String issue_date;
	private String submit_date;
	public BooksRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BooksRecord(int record_id, String student_name, int standard, String issue_date, String submit_date) {
		super();
		this.record_id = record_id;
		this.student_name = student_name;
		this.standard = standard;
		this.issue_date = issue_date;
		this.submit_date = submit_date;
	}
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getStandard() {
		return standard;
	}
	public void setStandard(int standard) {
		this.standard = standard;
	}
	public String getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}
	public String getSubmit_date() {
		return submit_date;
	}
	public void setSubmit_date(String submit_date) {
		this.submit_date = submit_date;
	}
	
}
