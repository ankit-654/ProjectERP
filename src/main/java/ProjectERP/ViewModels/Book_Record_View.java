package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_booksrecord")
public class Book_Record_View {
	@Id
private int record_id;
private int book_id;
private String book_name;
private String student_name;
private int standard;
private int registration_id;
public Book_Record_View(int record_id, int book_id, String book_name, String student_name, int standard,
		int registration_id, String issue_date, String submit_date) {
	super();
	this.record_id = record_id;
	this.book_id = book_id;
	this.book_name = book_name;
	this.student_name = student_name;
	this.standard = standard;
	this.registration_id = registration_id;
	this.issue_date = issue_date;
	this.submit_date = submit_date;
}
public int getRegistration_id() {
	return registration_id;
}
public void setRegistration_id(int registration_id) {
	this.registration_id = registration_id;
}
private String issue_date;
private String submit_date;
public Book_Record_View() {
	super();
	// TODO Auto-generated constructor stub
}
public Book_Record_View(int record_id, int book_id, String book_name, String student_name, int standard,
		String issue_date, String submit_date) {
	super();
	this.record_id = record_id;
	this.book_id = book_id;
	this.book_name = book_name;
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
public int getBook_id() {
	return book_id;
}
public void setBook_id(int book_id) {
	this.book_id = book_id;
}
public String getBook_name() {
	return book_name;
}
public void setBook_name(String book_name) {
	this.book_name = book_name;
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
