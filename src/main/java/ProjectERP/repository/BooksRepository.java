package ProjectERP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjectERP.Models.Book;

public interface BooksRepository extends JpaRepository<Book, Integer>{

}
