package ProjectERP.ViewModels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vw_books")
public class Book_View {
	@Id
private int book_id;
private String book_name;
private String author_name;
public Book_View() {
	super();
	// TODO Auto-generated constructor stub
}
public Book_View(int book_id, String book_name, String author_name) {
	super();
	this.book_id = book_id;
	this.book_name = book_name;
	this.author_name = author_name;
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
public String getAuthor_name() {
	return author_name;
}
public void setAuthor_name(String author_name) {
	this.author_name = author_name;
}
}
