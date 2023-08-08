package ProjectERP.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;
	private String book_name;
	private String author_name;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int book_id, String book_name, String author_name) {
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
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "books",cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("books")
	private Set<BooksRecord> boooksrecord=new HashSet<BooksRecord>();
	public Set<BooksRecord> getBoooksrecord() {
		return boooksrecord;
	}
	public void setBoooksrecord(Set<BooksRecord> boooksrecord) {
		this.boooksrecord = boooksrecord;
	}
}
